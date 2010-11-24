package hu.advancedweb.dtoconverterutils.customconverter;

import hu.advancedweb.dtoconverterutils.SpecialFieldConverter;

public class StringTrimmerSpecialFieldConverter implements
		SpecialFieldConverter {

	@Override
	public Object convert(Object source) {
		return source.toString().trim();
	}

}
