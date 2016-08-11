package services;

import entity.PhoneNumber;
import entity.User;

public class UserService {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService() {
	}

	public UserService(User user) {
		this.user = user;
	}

	/**
	 * 
	 * @param phoneNumber
	 * @return true when user has phone number, false when user has not it
	 */
	public boolean isEqualsNumber(String phoneNumber) {
	/*	if (user.getTelNumbers().getHomeNumber().equals(phoneNumber)
				|| user.getTelNumbers().getWorkNumber().equals(phoneNumber)) {
			return true;
		} else
			for (String number : user.getTelNumbers().getMobileNumbers()) {
				if (number.equals(phoneNumber)) {
					return true;
				}
			}
		return false;*/
		
		for (PhoneNumber pn : user.getPhonesNumbers()){
			if (pn.getPhoneNumber().equals(phoneNumber)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param phoneNumber
	 * @return true when user has phone number which contains argument phoneNumber, false when user has not it
	 */
	public boolean isContainsNumber(String phoneNumber) {
		
		for (PhoneNumber pn : user.getPhonesNumbers()){
			if (pn.getPhoneNumber().contains(phoneNumber)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isContaint(String firstName, String lastName){
		if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)){
			return true;
		}
		return false;
	}

}
