package hu.advancedweb.dtoconverterutils.specialconverteraction;

import hu.advancedweb.dtoconverterutils.DtoConverterUtils;
import hu.advancedweb.dtoconverterutils.generic.AppTest;
import hu.advancedweb.dtoconverterutils.specialconverteraction.data.SpecialConverterData;
import hu.advancedweb.dtoconverterutils.specialconverteraction.data.SpecialConverterWithException;
import hu.advancedweb.dtoconverterutils.specialconverteraction.data.dto.SpecialConverterDataDto;
import hu.advancedweb.dtoconverterutils.specialconverteraction.data.dto.SpecialConverterWithExceptionDto;

import java.util.ArrayList;
import java.util.List;

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
		
		SpecialConverterWithExceptionDto dto2 = DtoConverterUtils.getConverter(new SpecialConverter()).convert(new SpecialConverterWithException() {
			{
				setId("1");
				setData("data");
			}
		});
		Assert.assertEquals(dto2.getData(), "data");
		Assert.assertEquals(dto2.getTripleData(), "datadatadata");

		final List<SpecialConverterWithException> children = new AppTest.NoNullArgConstructorList(new ArrayList<SpecialConverterWithException>() {
			{
				add(new SpecialConverterWithException() {
					{
						setId("list1");
						setData("1");
					}
				});
				add(new SpecialConverterWithException() {
					{
						setId("list2");
						setData("2");
					}
				});
			}
		});

		List<SpecialConverterWithExceptionDto> dtos = (List<SpecialConverterWithExceptionDto>) DtoConverterUtils.getConverter(new SpecialConverter()).convert(children);
		Assert.assertEquals(dtos.size(), 2);

	}
}
