package hu.advancedweb.dtoconverterutils.customconverter.data.dto;

import hu.advancedweb.dtoconverterutils.annotations.SpecialConverter;
import hu.advancedweb.dtoconverterutils.customconverter.StringTrimmerSpecialFieldConverter;
import hu.advancedweb.dtoconverterutils.customconverter.ToBase64DecodedStringArraySpecialFieldConverter;
import hu.advancedweb.dtoconverterutils.customconverter.ToIntSpecialFieldConverter;
import hu.advancedweb.dtoconverterutils.customconverter.ToStringArraySpecialFieldConverter;

public class CustomConverterDto {
	
	private String trimString;
	
	
	private int toIntString;
	
	
	private String[] toStringArray;
	
	private String[] toBase64DecodedStringArray;

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

	@SpecialConverter(ToIntSpecialFieldConverter.class)
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

	@SpecialConverter(ToBase64DecodedStringArraySpecialFieldConverter.class)
	public void setToBase64DecodedStringArray(String[] toBase64DecodedStringArray) {
		this.toBase64DecodedStringArray = toBase64DecodedStringArray;
	}
	
	
}
