package hu.advancedweb.dtoconverterutils.annotations.predefinedconverters;

import hu.advancedweb.dtoconverterutils.SpecialFieldConverter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

public class ToBase64DecodedStringArraySpecialFieldConverter implements SpecialFieldConverter {

	@Override
	public Object convert(Object source) {
		if (source.toString().compareTo("") != 0) {
			String[] encodeds = source.toString().split("[,]");
			List<String> decodeds = new ArrayList<String>();
			for (String s : encodeds) {
				decodeds.add(new String(Base64.decodeBase64(s)));
			}
			return decodeds.toArray(new String[] {});
		} else {
			return new String[] {};
		}
	}

}
