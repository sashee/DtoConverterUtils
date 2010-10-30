package hu.advancedweb.dtoconverterutils.data;

public class ChildObject {

	private String			id;

	private ParentObject	directParent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ParentObject getDirectParent() {
		return directParent;
	}

	public void setDirectParent(ParentObject directParent) {
		this.directParent = directParent;
	}

}
