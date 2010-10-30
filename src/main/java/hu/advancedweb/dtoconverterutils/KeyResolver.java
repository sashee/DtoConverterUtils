package hu.advancedweb.dtoconverterutils;

public interface KeyResolver {
	public Object findByKey(Class<?> type, Object key);

}
