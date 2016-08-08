package entity;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PhonsNumbers {

	private long id;
	private String homeNumber;
	private String workNumber;
	//TODO entity mobileNumbers
	private Set<String> mobileNumbers = new HashSet<>();
	
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

}
