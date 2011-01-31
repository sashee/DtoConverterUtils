package hu.advancedweb.dtoconverterutils.specialconverteraction;

import hu.advancedweb.dtoconverterutils.DtoConverterUtils;
import hu.advancedweb.dtoconverterutils.specialconverteraction.data.SpecialConverterData;
import hu.advancedweb.dtoconverterutils.specialconverteraction.data.dto.SpecialConverterDataDto;
import junit.framework.Assert;

import org.junit.Test;

public class SpecialConverterActionTest {

	@Test
	public void testSpecialConverterAction() throws Exception {
		SpecialConverterDataDto dto = DtoConverterUtils.getConverter(new SpecialConverter()).convert(new SpecialConverterData() {
			{
				setId("1");
				setData("data");
			}
		});
		Assert.assertEquals(dto.getData(), "data");
		Assert.assertEquals(dto.getDoubleData(), "datadata");

	}
}
