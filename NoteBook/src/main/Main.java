package main;

import java.io.IOException;

import consoleIO.ConsoleUserIO;
import xmlIO.XmlUserIO;

public class Main {
	//User user = new User();

	public static void main (String ... args) {
		
		
		String s = "";
		if (!s.isEmpty()){
		System.out.println(s.substring(-2));
		}
		
		
		//System.out.println(Repository.usersRepository());
		//System.out.println(Repository.phoneBookRepository());
		
		ConsoleUserIO cu = new ConsoleUserIO();
	/*	
		PhoneBook phoneBook = cu.readListFrom("console");
		System.out.println(phoneBook);
	*/	
		
		XmlUserIO xml = new XmlUserIO();
	//	List<User> users = Repository.usersRepository();
		
	/*	PhoneBook users = Repository.phoneBookRepository();
		xml.writeListTo(users, "e:\\xml1.xml");
	*/	
	//	System.out.println(xml.readListFrom("e:\\xml1.xml"));
		
		//UserService us = new UserService(users);
		//System.out.println(us.getSortedByFirstName());
		//System.out.println(us.getSortedByLastName());
		//System.out.println(us.getUsersByPhone("123"));
		
		
		//TODO dateTime formatter!!! System.out.println(us.getUsersWithBirthdayInDiapason(("10/10/2016"), "21.10.2016"));
	}
}
