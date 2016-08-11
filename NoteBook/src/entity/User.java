package entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import adapters.DateTimeDeserializer;
import adapters.DateTimeSerializer;
import adapters.JodaDateTimeAdapter;
import enums.Group;
import utils.IdGenerator;

@XmlRootElement
@XmlType(propOrder = { "id", "type", "firstName", "lastName", "dateOfBirthday", "email", "address", "phonesNumbers" })
public class User {

	private long id;
	private Group type;
	private String lastName;
	private String firstName;
	private String email;
	@JsonDeserialize(using = DateTimeDeserializer.class)
	private DateTime dateOfBirthday;
	private Address address;
	private Set<PhoneNumber> phonesNumbers = new HashSet<>();

	@XmlElement
	public Set<PhoneNumber> getPhonesNumbers() {
		return phonesNumbers;
	}

	public void setPhonesNumbers(Set<PhoneNumber> phonesNumbers) {
		this.phonesNumbers = phonesNumbers;
	}

	public User() {
		IdGenerator idGener = new IdGenerator(new LinkedHashSet<>());
		id = idGener.getID(1000, 9999);
	}

	@XmlElement
	public long getId() {
		return id;
	}

	/*
	 * public void setId(long id) { this.id = id; }
	 */

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

	@JsonSerialize(using = DateTimeSerializer.class)
	@XmlElement
	@XmlJavaTypeAdapter(JodaDateTimeAdapter.class)
	public DateTime getDateOfBirthday() {
		return dateOfBirthday;
	}

	public void setDateOfBirthday(DateTime dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}

	
	@Override
	public String toString() {
		String format = new JodaDateTimeAdapter().getFormat();

		String address = getAddress().toString();
		if (!(getAddress().toString().isEmpty())) {
			address = getAddress().toString().substring(1, 11);
		}

		String phn = "";
		
		for (PhoneNumber pn : getPhonesNumbers()) {
			phn+= pn.toString();
		
		}
		return "\n\n" + getType() + " " + getFirstName() + " " + getLastName() + " ("
				+ getDateOfBirthday().toString(format) + ")\n" + getEmail() + "\n" + address + phn;
	}

}
