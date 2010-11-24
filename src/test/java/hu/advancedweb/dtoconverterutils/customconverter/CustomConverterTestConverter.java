package hu.advancedweb.dtoconverterutils.customconverter;

import hu.advancedweb.dtoconverterutils.NoSpecialConversionException;
import hu.advancedweb.dtoconverterutils.customconverter.data.CustomConverterData;
import hu.advancedweb.dtoconverterutils.customconverter.data.dto.CustomConverterDto;

public class CustomConverterTestConverter {
	public CustomConverterDto convert(CustomConverterData data){
		throw new NoSpecialConversionException();
	}
}
