package entity;

import javax.xml.bind.annotation.XmlRootElement;

import enums.NumbersType;

@XmlRootElement
public class PhoneNumber {

	private long id;
	private NumbersType numbersType;
	private String phoneNumber;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public NumbersType getNumbersType() {
		return numbersType;
	}
	public void setNumbersType(NumbersType numbersType) {
		this.numbersType = numbersType;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "\n" + getNumbersType() + ": " + getPhoneNumber() + ", ";
	}
	
/*	
	private String homeNumber;
	private String workNumber;
	//TODO entity mobileNumbers
	private Set<String> mobileNumbers = new HashSet<>();
	//TODO enum typeNumber, string number
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlElement
	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	@XmlElement
	public String getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	@XmlElement
	public Set<String> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(Set<String> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	@Override
	public String toString() {

		String str = "\n";
		if (!(getMobileNumbers().isEmpty())) {
			for (String s : getMobileNumbers()) {
				str += s + ", ";
			}
		}
		if (getHomeNumber().toString().length() >= 6) {
		//if (!(getHomeNumber().toString().isEmpty())) {
			str += getHomeNumber().substring(getHomeNumber().length() - 6) + ", ";
		}
		if (getWorkNumber().toString().length() >= 6) {
		//if (!(getWorkNumber().toString().isEmpty())) {
			str += getWorkNumber().substring(getWorkNumber().length() - 6);
		}
		return str.toString();
	}
*/
}
