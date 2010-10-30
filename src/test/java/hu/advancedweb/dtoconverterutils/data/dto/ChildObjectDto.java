package hu.advancedweb.dtoconverterutils.data.dto;


public class ChildObjectDto {
	private String			id;

	private ParentObjectDto	directParent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ParentObjectDto getDirectParent() {
		return directParent;
	}

	public void setDirectParent(ParentObjectDto directParent) {
		this.directParent = directParent;
	}

}
