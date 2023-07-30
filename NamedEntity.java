/*
NamedEntity
Thomas Warenski
7/14/2023
Abstract class that serves as the root for both Player and Team classes. This mainly serves as a outline to give objects names and have them include a getString() method.
*/

public abstract class NamedEntity{
	private String name = "Nameless";

	public NamedEntity(){
		
	}

	public NamedEntity(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	abstract String getString();
}
