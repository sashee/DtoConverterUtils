package hu.advancedweb.dtoconverterutils;

public interface AfterCreateConverter<T> {
	public void afterCreate(T source);
}
