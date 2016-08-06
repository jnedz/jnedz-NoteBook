package entity;

import java.util.LinkedHashSet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import adapters.DateTimeSerializer;
import adapters.JodaDateTimeAdapter;
import enums.Group;
import utils.IdGenerator;

@XmlRootElement
@XmlType(propOrder = {"id", "type", "firstName", "lastName", "dateOfBirthday", "email", "address", "telNumbers"})
public class User {

	private long id;
	private Group type;
	private String lastName;
	private String firstName;
	private String email;
	private DateTime dateOfBirthday;
	private Address address;
	private PhonsNumbers telNumbers;
	
	
	public User(){
		IdGenerator idGener = new IdGenerator(new LinkedHashSet<>());
		id = idGener.getID(1000, 9999);
	}
	
	@XmlElement
	public long getId() {
		return id;
	}

	/*public void setId(long id) {
		this.id = id;
	}*/


	@XmlElement
	public Group getType() {
		return type;
	}
	public void setType(Group type) {
		this.type = type;
	}
	@XmlElement
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@XmlElement
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@XmlElement
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	//@JsonIgnore
	@JsonSerialize(using = DateTimeSerializer.class)
	@XmlElement
	@XmlJavaTypeAdapter(JodaDateTimeAdapter.class)
	public DateTime getDateOfBirthday() {
		return dateOfBirthday;
	}
	public void setDateOfBirthday(DateTime dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}
	@XmlElement
	public PhonsNumbers getTelNumbers() {
		return telNumbers;
	}
	public void setTelNumbers(PhonsNumbers telNumbers) {
		this.telNumbers = telNumbers;
	}
	
	@Override
	public String toString() {
		String format = new JodaDateTimeAdapter().getFormat();
		
		String address = getAddress().toString();
		if (!(getAddress().toString().isEmpty())){
			address = getAddress().toString().substring(1, 11);
		}
		
		return "\n\n" + getFirstName() + " " + getLastName() + " (" + getDateOfBirthday().toString(format) + ")\n" + getEmail() +"\n" + address + getTelNumbers();
	}
	
	
}
