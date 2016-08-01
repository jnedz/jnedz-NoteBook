package entity;

import java.util.Set;

public class FonsNumbers {

	private String homeNumber;
	private String workNumber;
	private Set<String> mobileNumbers;

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumbers(String workNumber) {
		this.workNumber = workNumber;
	}

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
		for (String s : mobileNumbers){
			str.append(s.toString() + ", ");
		}
		str.append(getHomeNumber().substring(getHomeNumber().length() - 6) + ", ");
		str.append(getWorkNumber().substring(getWorkNumber().length() - 6));
		return str.toString();
	}

}
