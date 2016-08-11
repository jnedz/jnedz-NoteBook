package entity;

import javax.xml.bind.annotation.XmlRootElement;

import enums.NumbersType;

@XmlRootElement
public class PhoneNumber{ 

	private long id;
	private NumbersType numbersType;
	private String phoneNumber = "";
	
	public PhoneNumber (){
	}
	
	public PhoneNumber (NumbersType numbersType, String phoneNumber){
		this.numbersType = numbersType;
		this.phoneNumber = phoneNumber;
	}
	
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
		String str = "";
			
		if (getNumbersType().name().equals("HOME") || getNumbersType().name().equals("WORK")){
			
					str += getNumbersType() + " " +  getPhoneNumber().substring(getPhoneNumber().length() - 6) + "\n";
			
		}else {
			str += getNumbersType() + " " +  getPhoneNumber() + "\n";
	}
		return str;
	}

}
