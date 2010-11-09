package hu.advancedweb.dtoconverterutils.data.dto;

import hu.advancedweb.dtoconverterutils.data.SampleEnum;

import java.util.List;

public class ParentObjectDto {
	private String					id;

	private ChildObjectDto			child;

	private List<ChildObjectDto>	children;

	private ChildObjectDto			realChildKey;

	private SampleEnum				testEnum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ChildObjectDto getChild() {
		return child;
	}

	public void setChild(ChildObjectDto child) {
		this.child = child;
	}

	public List<ChildObjectDto> getChildren() {
		return children;
	}

	public void setChildren(List<ChildObjectDto> children) {
		this.children = children;
	}

	public ChildObjectDto getRealChildKey() {
		return realChildKey;
	}

	public void setRealChildKey(ChildObjectDto realChildKey) {
		this.realChildKey = realChildKey;
	}

	public SampleEnum getTestEnum() {
		return testEnum;
	}

	public void setTestEnum(SampleEnum testEnum) {
		this.testEnum = testEnum;
	}

}
