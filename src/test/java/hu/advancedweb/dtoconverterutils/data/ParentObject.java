package hu.advancedweb.dtoconverterutils.data;

import java.util.List;

public class ParentObject {

	private String				id;

	private ChildObject			child;

	private List<ChildObject>	children;

	private String				childKey;

	private String				testEnum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ChildObject getChild() {
		return child;
	}

	public void setChild(ChildObject child) {
		this.child = child;
	}

	public List<ChildObject> getChildren() {
		return children;
	}

	public void setChildren(List<ChildObject> children) {
		this.children = children;
	}

	public String getChildKey() {
		return childKey;
	}

	public void setChildKey(String childKey) {
		this.childKey = childKey;
	}

	public String getTestEnum() {
		return testEnum;
	}

	public void setTestEnum(String testEnum) {
		this.testEnum = testEnum;
	}

}
