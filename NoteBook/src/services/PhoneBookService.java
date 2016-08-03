package services;

import entity.PhoneBook;

public class PhoneBookService {

	private PhoneBook phoneBook;

	public PhoneBook getPhoneBook() {
		return phoneBook;
	}

	public void setPhoneBook(PhoneBook phoneBook) {
		this.phoneBook = phoneBook;
	}
	
	public PhoneBookService(){
	}
	
	public PhoneBookService(PhoneBook phoneBook){
		this.phoneBook = phoneBook;
	}
	
	//TODO get all by type
}
