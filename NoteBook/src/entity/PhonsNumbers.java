package entity;

import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PhonsNumbers {

	private String homeNumber;
	private String workNumber;
	private Set<String> mobileNumbers;

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
		StringBuilder str = new StringBuilder();
		str.append("\n");
		if (getMobileNumbers()!=null) {
			for (String s : getMobileNumbers()){
				str.append(s + ", ");
			}
		}
		str.append(getHomeNumber().substring(getHomeNumber().length() - 6) + ", ");
		str.append(getWorkNumber().substring(getWorkNumber().length() - 6));
		return str.toString();
	}

}
