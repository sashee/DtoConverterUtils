package hu.advancedweb.dtoconverterutils.customconverter.data.dto;

import hu.advancedweb.dtoconverterutils.annotations.SpecialConverter;
import hu.advancedweb.dtoconverterutils.annotations.predefinedconverters.Base64DecodedStringArray;
import hu.advancedweb.dtoconverterutils.customconverter.StringTrimmerSpecialFieldConverter;
import hu.advancedweb.dtoconverterutils.customconverter.TestNamedSpecialConverter;
import hu.advancedweb.dtoconverterutils.customconverter.ToIntSpecialFieldConverter;
import hu.advancedweb.dtoconverterutils.customconverter.ToStringArraySpecialFieldConverter;

public class CustomConverterDto {

	private String		trimString;

	@SpecialConverter(ToIntSpecialFieldConverter.class)
	private int			toIntString;

	private String[]	toStringArray;

	@Base64DecodedStringArray
	private String[]	toBase64DecodedStringArray;

	private int			namedConverterValue;

	public String getTrimString() {
		return trimString;
	}

	@SpecialConverter(StringTrimmerSpecialFieldConverter.class)
	public void setTrimString(String trimString) {
		this.trimString = trimString;
	}

	public int getToIntString() {
		return toIntString;
	}

	public void setToIntString(int toIntString) {
		this.toIntString = toIntString;
	}

	public String[] getToStringArray() {
		return toStringArray;
	}

	@SpecialConverter(ToStringArraySpecialFieldConverter.class)
	public void setToStringArray(String[] toStringArray) {
		this.toStringArray = toStringArray;
	}

	public String[] getToBase64DecodedStringArray() {
		return toBase64DecodedStringArray;
	}

	public void setToBase64DecodedStringArray(String[] toBase64DecodedStringArray) {
		this.toBase64DecodedStringArray = toBase64DecodedStringArray;
	}

	public int getNamedConverterValue() {
		return namedConverterValue;
	}

	@TestNamedSpecialConverter
	public void setNamedConverterValue(int namedConverterValue) {
		this.namedConverterValue = namedConverterValue;
	}

}
