package hu.advancedweb.dtoconverterutils.generic;

import hu.advancedweb.dtoconverterutils.DtoConverterUtils;
import hu.advancedweb.dtoconverterutils.KeyResolver;
import hu.advancedweb.dtoconverterutils.generic.data.ChildObject;
import hu.advancedweb.dtoconverterutils.generic.data.ParentObject;
import hu.advancedweb.dtoconverterutils.generic.data.SampleEnum;
import hu.advancedweb.dtoconverterutils.generic.data.dto.ParentObjectDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@SuppressWarnings({ "unchecked" })
	@Test
	public void testA() {

		final Map<Class<?>, Map<Object, Object>> objects = new HashMap<Class<?>, Map<Object, Object>>();
		objects.put(ChildObject.class, new HashMap<Object, Object>());

		ProbaConverter converter = DtoConverterUtils.getConverter(new ProbaConverter(), new KeyResolver() {

			@Override
			public Object findByKey(Class<?> type, Object key) {
				return objects.get(type).get(key);
			}
		});
		final ParentObject parent = new ParentObject() {
			{
				setId("parent");
			}
		};
		final ChildObject directChild = new ChildObject() {
			{
				setDirectParent(parent);
				setId("directChild");
			}
		};
		parent.setChild(directChild);

		final List<ChildObject> children = new ArrayList<ChildObject>() {
			{
				add(new ChildObject() {
					{
						setId("list1");
					}
				});
				add(new ChildObject() {
					{
						setId("list2");
					}
				});
			}
		};
		parent.setChildren(children);

		final ChildObject referencedChild = new ChildObject() {
			{
				setId("referenced");
			}
		};
		parent.setChildKey(referencedChild.getId());
		objects.get(ChildObject.class).put("referenced", referencedChild);

		ParentObjectDto dto = converter.convert(parent);
		Assert.assertEquals("parent", dto.getId());
		Assert.assertEquals("directChild", dto.getChild().getId());
		Assert.assertEquals("parent", dto.getChild().getDirectParent().getId());
		Assert.assertEquals(dto, dto.getChild().getDirectParent());
		Assert.assertEquals(2, dto.getChildren().size());
		Assert.assertEquals("list1", dto.getChildren().get(0).getId());
		Assert.assertEquals("list2", dto.getChildren().get(1).getId());
		Assert.assertEquals("referenced", dto.getRealChildKey().getId());

		Assert.assertEquals(null, converter.convert(new ParentObject() {
			{
				setId("5");
			}
		}).getChildren());

		List<ParentObjectDto> dtolist = (List<ParentObjectDto>) converter.convert(new ArrayList<ParentObject>() {
			{
				add(new ParentObject() {
					{
						setId("1");
					}
				});
				add(new ParentObject() {
					{
						setId("2");
					}
				});
			}
		});

		Assert.assertEquals("1", dtolist.get(0).getId());
		Assert.assertEquals("2", dtolist.get(1).getId());

		Assert.assertEquals(SampleEnum.Value1, converter.convert(new ParentObject() {
			{
				setTestEnum(SampleEnum.Value1.toString());
			}
		}).getTestEnum());
		Assert.assertEquals(SampleEnum.Value2, converter.convert(new ParentObject() {
			{
				setTestEnum(SampleEnum.Value2.toString());
			}
		}).getTestEnum());

		Assert.assertEquals("uncreateablelist1", ((List<ParentObjectDto>) converter.convert(new NoNullArgConstructorList<ParentObject>(new ArrayList<ParentObject>() {
			{
				add(new ParentObject() {
					{
						setId("uncreateablelist1");
					}
				});
			}
		}))).get(0).getId());
	}

	private class NoNullArgConstructorList<E> implements List<E> {

		List	_list;

		public <F> NoNullArgConstructorList(List arg) {
			_list = arg;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(Object paramObject) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator<E> iterator() {
			return _list.iterator();
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T[] toArray(T[] paramArrayOfT) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean add(E paramE) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean remove(Object paramObject) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> paramCollection) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends E> paramCollection) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> paramCollection) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> paramCollection) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub

		}

		@Override
		public E get(int paramInt) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public E set(int paramInt, E paramE) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void add(int paramInt, E paramE) {
			// TODO Auto-generated method stub

		}

		@Override
		public E remove(int paramInt) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int indexOf(Object paramObject) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int lastIndexOf(Object paramObject) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ListIterator<E> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator<E> listIterator(int paramInt) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<E> subList(int paramInt1, int paramInt2) {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
