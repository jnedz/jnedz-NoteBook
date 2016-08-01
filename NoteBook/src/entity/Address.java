package entity;

public class Address {

	private String index;
	private String town;
	private String street;
	private String buildNumber;
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBuildNumber() {
		return buildNumber;
	}
	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}
	
	@Override
	public String toString() {

		return "\n" + getIndex() + " " + getTown() + " " + getStreet() + " " + getBuildNumber() + ";";
	}
	
}
