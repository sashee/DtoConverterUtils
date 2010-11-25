package hu.advancedweb.dtoconverterutils.customconverter;

import hu.advancedweb.dtoconverterutils.DtoConverterUtils;
import hu.advancedweb.dtoconverterutils.customconverter.data.CustomConverterData;
import hu.advancedweb.dtoconverterutils.customconverter.data.dto.CustomConverterDto;
import junit.framework.Assert;

import org.junit.Test;

public class CustomConverterTest {

	@Test
	public void test() throws Exception {
		CustomConverterDto dto = DtoConverterUtils.getConverter(
				new CustomConverterTestConverter()).convert(
				new CustomConverterData() {
					{
						setId("obj");
						setTrimString("  trimmed ");
						setToIntString("15");
						setToStringArray("elso,masodik");
						setToBase64DecodedStringArray("YmFzZTY0Zmlyc3Q=,YmFzZTY0c2Vjb25k,YmFzZTY0dGhpcmQ=");
				setNamedConverterValue("42");
					}
				});
		Assert.assertEquals("trimmed", dto.getTrimString());
		Assert.assertEquals(15, dto.getToIntString());
		Assert.assertEquals(2, dto.getToStringArray().length);
		Assert.assertEquals("elso", dto.getToStringArray()[0]);
		Assert.assertEquals("masodik", dto.getToStringArray()[1]);
		Assert.assertEquals(42, dto.getNamedConverterValue());

		Assert.assertEquals(3, dto.getToBase64DecodedStringArray().length);
		Assert.assertEquals("base64first", dto.getToBase64DecodedStringArray()[0]);
		Assert.assertEquals("base64second", dto.getToBase64DecodedStringArray()[1]);
		Assert.assertEquals("base64third", dto.getToBase64DecodedStringArray()[2]);
		
	}
}
