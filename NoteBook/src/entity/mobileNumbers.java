package entity;

import java.util.HashSet;
import java.util.Set;

public class mobileNumbers {

	private long id;
	private Set<String> mobileNumbers = new HashSet<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Set<String> getMobileNumbers() {
		return mobileNumbers;
	}
	public void setMobileNumbers(Set<String> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}
	
	
	
	
}
