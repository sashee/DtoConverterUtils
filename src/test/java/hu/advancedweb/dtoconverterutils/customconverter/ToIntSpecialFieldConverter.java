package hu.advancedweb.dtoconverterutils.customconverter;

import hu.advancedweb.dtoconverterutils.SpecialFieldConverter;

public class ToIntSpecialFieldConverter implements SpecialFieldConverter {

	@Override
	public Object convert(Object source) {
		return Integer.parseInt(source.toString());
	}

}
