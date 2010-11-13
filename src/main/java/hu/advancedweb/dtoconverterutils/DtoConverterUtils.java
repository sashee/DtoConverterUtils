package hu.advancedweb.dtoconverterutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.proxy.Invoker;
import org.apache.commons.proxy.factory.cglib.CglibProxyFactory;

public class DtoConverterUtils implements Invoker {

	Object								a;
	KeyResolver							resolver;
	Object								converter;
	int									recursionLevel	= 0;
	Map<Class<?>, Map<Object, Object>>	objectCache		= new HashMap<Class<?>, Map<Object, Object>>();

	private DtoConverterUtils(Object a, KeyResolver resolver) {
		this.a = a;
		this.resolver = resolver;
	}

	@SuppressWarnings("unchecked")
	private void copyProperties(Object source, Object target) {
		try {
			if (objectCache.containsKey(source.getClass()) == false) {
				objectCache.put(source.getClass(), new HashMap<Object, Object>());
			}
			objectCache.get(source.getClass()).put(findId(source), target);
			for (Method m : target.getClass().getMethods()) {
				if (m.getName().startsWith("set")) {
					Method getter = null;
					try {
						getter = source.getClass().getMethod("get" + m.getName().substring(3));
					} catch (NoSuchMethodException nsme) {
					}
					if (getter != null) {
						if (Collection.class.isAssignableFrom(getter.getReturnType())) {
							Collection<?> c = (Collection<?>) getter.invoke(source);
							if (c != null) {
								Collection collection = null;
								try {
									collection = c.getClass().newInstance();
								} catch (Exception e) {
									collection = (Collection<?>) c.getClass().getSuperclass().newInstance();
								}
								for (Object collectionElement : c) {
									collection.add(tryConvert(collectionElement));
								}
								m.invoke(target, collection);
							}
						} else if (m.getParameterTypes()[0].isAssignableFrom(getter.getReturnType())) {
							m.invoke(target, getter.invoke(source));
						} else if (Enum.class.isAssignableFrom(m.getParameterTypes()[0])) {
							String value = (String) getter.invoke(source);
							if (value != null) {
								m.invoke(target, Enum.valueOf((Class<Enum>) m.getParameterTypes()[0], value));
							}
						} else {
							Object converted = tryConvert(getter.invoke(source));
							if (converted != null) {
								m.invoke(target, converted);
							}
						}
					} else if (m.getName().startsWith("setReal")) {
						Method realGetter = null;
						try {
							realGetter = source.getClass().getMethod("get" + m.getName().substring(7));
						} catch (NoSuchMethodException nsme) {
						}
						if (realGetter != null) {
							m.invoke(target, tryConvert(resolver.findByKey(findConverterMethodForObject(m.getParameterTypes()[0]).getParameterTypes()[0], realGetter.invoke(source))));
						}
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Object findId(Object o) {
		try {
			return o.getClass().getMethod("getId").invoke(o);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Method findConverterMethodForObject(Class<?> returnType) {
		for (Method m : converter.getClass().getMethods()) {
			if (m.getName().compareTo("convert") == 0) {
				if (m.getReturnType() == returnType) {
					return m;
				}
			}
		}
		return null;
	}

	private Object tryConvert(Object o) {
		if (o == null) {
			return null;
		}
		if (objectCache.containsKey(o.getClass()) && objectCache.get(o.getClass()).containsKey(findId(o))) {
			return objectCache.get(o.getClass()).get(findId(o));
		}
		for (Method m : converter.getClass().getMethods()) {
			if (m.getName().compareTo("convert") == 0) {
				try {
					return m.invoke(converter, o);
				} catch (InvocationTargetException ite) {
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {
				}
			}
		}
		return null;
	}

	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		if (arg1.getName().compareTo("convert") == 0) {
			recursionLevel++;
			try {
				Object result = null;
				try {
					result = arg1.invoke(a, arg2);
				} catch (InvocationTargetException ite) {
					if (ite.getCause() != null && ite.getCause() instanceof NoSpecialConversionException) {
						try {
							result = arg1.getReturnType().newInstance();
						} catch (InstantiationException ie) {
							try {
								result = arg2[0].getClass().newInstance();
							} catch (InstantiationException ie2) {
								if (arg1.getReturnType() == List.class) {
									result = new ArrayList();
								} else {
									result = arg2[0].getClass().getSuperclass().newInstance();
								}
							}
						}
						if (result instanceof Collection) {
							for (Object collectionElement : (Collection) arg2[0]) {
								((Collection) result).add(tryConvert(collectionElement));
							}
							return result;
						} else {
							copyProperties(arg2[0], result);
						}
					} else {
						throw ite;
					}
				}
				return result;
			} finally {
				recursionLevel--;
				if (recursionLevel == 0) {
					objectCache.clear();
				}
			}
		} else {
			return arg1.invoke(a, arg2);
		}
	}

	public static <T> T getConverter(final T a) {
		return getConverter(a, null);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getConverter(final T a, KeyResolver resolver) {
		DtoConverterUtils utils = new DtoConverterUtils(a, resolver);
		utils.converter = new CglibProxyFactory().createInvokerProxy(utils, new Class[] { a.getClass() });

		return (T) utils.converter;
	}
}
