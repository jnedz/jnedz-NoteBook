package entity;

import org.joda.time.DateTime;

import enums.Group;

public class User {

	private Group type;
	private String lastName;
	private String firstName;
	private String email;
	private DateTime dateOfBirthday;
	private Address address;
	private FonsNumbers telNumbers;
	
	
	public Group getType() {
		return type;
	}
	public void setType(Group type) {
		this.type = type;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public DateTime getDateOfBirthday() {
		return dateOfBirthday;
	}
	public void setDateOfBirthday(DateTime dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}
	public FonsNumbers getTelNumbers() {
		return telNumbers;
	}
	public void setTelNumbers(FonsNumbers telNumbers) {
		this.telNumbers = telNumbers;
	}
	
	@Override
	public String toString() {
		return "\n\n" + getFirstName() + " " + getLastName() + " (" + getDateOfBirthday().toString("dd/MM/yyyy") + ")\n" + getEmail() +"\n" + getAddress().toString().substring(1, 11) + getTelNumbers();
	}
	
	
}
