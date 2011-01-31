package hu.advancedweb.dtoconverterutils.specialconverteraction.data.dto;

import hu.advancedweb.dtoconverterutils.AfterCreateConverter;
import hu.advancedweb.dtoconverterutils.annotations.AfterCreate;

@AfterCreate(SpecialConverterDataDto.DoubleDataAfterCreateConverter.class)
public class SpecialConverterDataDto {

	public static class DoubleDataAfterCreateConverter implements AfterCreateConverter<SpecialConverterDataDto> {

		@Override
		public void afterCreate(SpecialConverterDataDto source) {
			source.setDoubleData(source.getData() + source.getData());
		}

	}

	private String	id;

	private String	data;

	private String	doubleData;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDoubleData() {
		return doubleData;
	}

	public void setDoubleData(String doubleData) {
		this.doubleData = doubleData;
	}

}
