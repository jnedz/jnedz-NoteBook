package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.User;

public class UserService {
	
	private List<User> users = new ArrayList<>();
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public UserService() {
	}

	public UserService(List<User> users) {
		this.users = users;
	}
	

	public List<User> getSortedByFirstName() {
		List<User> sortedList = new ArrayList<>(users);
		Collections.sort(sortedList, new Comparator<User>() {

			@Override
			public int compare(User u1, User u2) {
				
				return u1.getFirstName().compareTo(u2.getFirstName());
			}
		});
		return sortedList;
	}
	
	public List<User> getSortedByLastName() {
		List<User> sortedList = new ArrayList<>(users);
		Collections.sort(sortedList, new Comparator<User>() {

			@Override
			public int compare(User u1, User u2) {
				
				return u1.getLastName().compareTo(u2.getLastName());
			}
		});
		return sortedList;
	}
	
	public List<User> getUsersByType(String type){
		List<User> usersByType = new ArrayList<>();
		for (User user : users){
			if (user.getType().equals(type)){
				usersByType.add(user);
			}
		}
		return usersByType;
	}
	
	public List<User> getUsersByPhone(String phoneNumber){
		List<User> usersByPhone = new ArrayList<>();
		for (User user : users){
			if (user.getTelNumbers().getHomeNumber().contains(phoneNumber) || user.getTelNumbers().getWorkNumber().contains(phoneNumber)){
				usersByPhone.add(user);
				//TODO else or set
			}
			for (String mobile : user.getTelNumbers().getMobileNumbers()){
				if (mobile.contains(phoneNumber)){
					usersByPhone.add(user);
				}
			}
		}
		return usersByPhone;
	}
	
	public List<User> getUsersByEmail(String email){
		List<User> usersByEmail = new ArrayList<>();
		for (User user : users){
			if (user.getEmail().contains(email)){
				usersByEmail.add(user);
			}
		}
		return usersByEmail;
	}
	
	public List<User> getUsersByTown(String town){
		List<User> usersByTown = new ArrayList<>();
		for (User user : users){
			if (user.getAddress().getTown().contains(town)){
				usersByTown.add(user);
			}
		}
		return usersByTown;
	}
	
	//TODO
	public List<User> getUsersByName(String name1, String name2){
		List<User> usersByName = new ArrayList<>();
		for (User user: users){
			if (user.getFirstName().contains(name1)&&user.getLastName().contains(name2) || user.getFirstName().contains(name2)&&user.getLastName().contains(name1)){
				usersByName.add(user);
			}
		}
		return usersByName;
	}
	
}
