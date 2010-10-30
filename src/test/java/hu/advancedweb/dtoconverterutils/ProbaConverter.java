package hu.advancedweb.dtoconverterutils;

import hu.advancedweb.dtoconverterutils.data.ChildObject;
import hu.advancedweb.dtoconverterutils.data.ParentObject;
import hu.advancedweb.dtoconverterutils.data.dto.ChildObjectDto;
import hu.advancedweb.dtoconverterutils.data.dto.ParentObjectDto;

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
