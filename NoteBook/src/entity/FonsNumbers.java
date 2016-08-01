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
	
	
	//TODO toString

}
