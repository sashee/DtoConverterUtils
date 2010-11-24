package hu.advancedweb.dtoconverterutils.generic;

import hu.advancedweb.dtoconverterutils.NoSpecialConversionException;
import hu.advancedweb.dtoconverterutils.generic.data.ChildObject;
import hu.advancedweb.dtoconverterutils.generic.data.ParentObject;
import hu.advancedweb.dtoconverterutils.generic.data.dto.ChildObjectDto;
import hu.advancedweb.dtoconverterutils.generic.data.dto.ParentObjectDto;

import java.util.List;

public class ProbaConverter {
	public ParentObjectDto convert(ParentObject o) {
		throw new NoSpecialConversionException();
	}

	public ChildObjectDto convert(ChildObject o) {
		throw new NoSpecialConversionException();
	}

	public List<?> convert(List<?> l) {
		throw new NoSpecialConversionException();
	}
}
