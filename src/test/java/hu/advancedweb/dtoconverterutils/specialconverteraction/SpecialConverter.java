package hu.advancedweb.dtoconverterutils.specialconverteraction;

import hu.advancedweb.dtoconverterutils.NoSpecialConversionException;
import hu.advancedweb.dtoconverterutils.specialconverteraction.data.SpecialConverterData;
import hu.advancedweb.dtoconverterutils.specialconverteraction.data.dto.SpecialConverterDataDto;

public class SpecialConverter {
	public SpecialConverterDataDto convert(SpecialConverterData o) {
		throw new NoSpecialConversionException();
	}
}
