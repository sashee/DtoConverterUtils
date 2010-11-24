package hu.advancedweb.dtoconverterutils.customconverter;

import hu.advancedweb.dtoconverterutils.SpecialFieldConverter;

public class ToStringArraySpecialFieldConverter implements
		SpecialFieldConverter {

	@Override
	public Object convert(Object source) {
		if(source.toString().compareTo("")!=0){
			return source.toString().split("[,]");
		}else{
			return new String[]{};
		}
	}

}
