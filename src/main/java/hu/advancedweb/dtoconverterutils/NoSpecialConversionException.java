package hu.advancedweb.dtoconverterutils;

public class NoSpecialConversionException extends RuntimeException {

	private final AfterCreateConverter<?>	afterCreateConverter;

	public NoSpecialConversionException() {
		afterCreateConverter = null;
	}

	public NoSpecialConversionException(AfterCreateConverter<?> afterCreateConverter) {
		this.afterCreateConverter = afterCreateConverter;
	}

	public AfterCreateConverter getAfterCreateConverter() {
		return afterCreateConverter;
	}

}
