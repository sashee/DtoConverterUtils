package hu.advancedweb.dtoconverterutils.specialconverteraction;

import hu.advancedweb.dtoconverterutils.AfterCreateConverter;
import hu.advancedweb.dtoconverterutils.NoSpecialConversionException;
import hu.advancedweb.dtoconverterutils.specialconverteraction.data.SpecialConverterData;
import hu.advancedweb.dtoconverterutils.specialconverteraction.data.SpecialConverterWithException;
import hu.advancedweb.dtoconverterutils.specialconverteraction.data.dto.SpecialConverterDataDto;
import hu.advancedweb.dtoconverterutils.specialconverteraction.data.dto.SpecialConverterWithExceptionDto;

import java.util.List;

public class SpecialConverter {
	public SpecialConverterDataDto convert(SpecialConverterData o) {
		throw new NoSpecialConversionException();
	}

	public SpecialConverterWithExceptionDto convert(SpecialConverterWithException o) {
		throw new NoSpecialConversionException(new AfterCreateConverter<SpecialConverterWithExceptionDto>() {
			@Override
			public void afterCreate(SpecialConverterWithExceptionDto source) {
				source.setTripleData(source.getData() + source.getData() + source.getData());
			}
		});
	}

	public List<?> convert(List<?> l) {
		throw new NoSpecialConversionException();
	}
}
