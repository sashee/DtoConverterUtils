package hu.advancedweb.dtoconverterutils;

import hu.advancedweb.dtoconverterutils.data.ChildObject;
import hu.advancedweb.dtoconverterutils.data.ParentObject;
import hu.advancedweb.dtoconverterutils.data.SampleEnum;
import hu.advancedweb.dtoconverterutils.data.dto.ParentObjectDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@SuppressWarnings({ "unchecked" })
	@Test
	public void testA() {

		final Map<Class<?>, Map<Object, Object>> objects = new HashMap<Class<?>, Map<Object, Object>>();
		objects.put(ChildObject.class, new HashMap<Object, Object>());

		ProbaConverter converter = DtoConverterUtils.getConverter(new ProbaConverter(), new KeyResolver() {

			@Override
			public Object findByKey(Class<?> type, Object key) {
				return objects.get(type).get(key);
			}
		});
		final ParentObject parent = new ParentObject() {
			{
				setId("parent");
			}
		};
		final ChildObject directChild = new ChildObject() {
			{
				setDirectParent(parent);
				setId("directChild");
			}
		};
		parent.setChild(directChild);

		final List<ChildObject> children = new ArrayList<ChildObject>() {
			{
				add(new ChildObject() {
					{
						setId("list1");
					}
				});
				add(new ChildObject() {
					{
						setId("list2");
					}
				});
			}
		};
		parent.setChildren(children);

		final ChildObject referencedChild = new ChildObject() {
			{
				setId("referenced");
			}
		};
		parent.setChildKey(referencedChild.getId());
		objects.get(ChildObject.class).put("referenced", referencedChild);

		ParentObjectDto dto = converter.convert(parent);
		Assert.assertEquals("parent", dto.getId());
		Assert.assertEquals("directChild", dto.getChild().getId());
		Assert.assertEquals("parent", dto.getChild().getDirectParent().getId());
		Assert.assertEquals(dto, dto.getChild().getDirectParent());
		Assert.assertEquals(2, dto.getChildren().size());
		Assert.assertEquals("list1", dto.getChildren().get(0).getId());
		Assert.assertEquals("list2", dto.getChildren().get(1).getId());
		Assert.assertEquals("referenced", dto.getRealChildKey().getId());
		
		Assert.assertEquals(null, converter.convert(new ParentObject() {
			{
				setId("5");
			}
		}).getChildren());

		List<ParentObjectDto> dtolist = (List<ParentObjectDto>) converter.convert(new ArrayList<ParentObject>() {
			{
				add(new ParentObject() {
					{
						setId("1");
					}
				});
				add(new ParentObject() {
					{
						setId("2");
					}
				});
			}
		});
		
		Assert.assertEquals("1", dtolist.get(0).getId());
		Assert.assertEquals("2", dtolist.get(1).getId());

		Assert.assertEquals(SampleEnum.Value1, converter.convert(new ParentObject() {
			{
				setTestEnum(SampleEnum.Value1.toString());
			}
		}).getTestEnum());
		Assert.assertEquals(SampleEnum.Value2, converter.convert(new ParentObject() {
			{
				setTestEnum(SampleEnum.Value2.toString());
			}
		}).getTestEnum());

	}
}
