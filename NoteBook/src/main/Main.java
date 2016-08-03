package main;

import java.util.List;

import consoleIO.ConsoleUserIO;
import entity.PhoneBook;
import entity.User;
import repository.Repository;
import services.UserService;
import xmlIO.XmlUserIO;

public class Main {
	//User user = new User();

	public static void main (String ... args) {
		
		//System.out.println(Repository.usersRepository());
		//System.out.println(Repository.phoneBookRepository());
		
		ConsoleUserIO cu = new ConsoleUserIO();
		System.out.println(cu.readListFrom("console"));
		
		
		XmlUserIO xml = new XmlUserIO();
	//	List<User> users = Repository.usersRepository();
	/*	
		PhoneBook users = Repository.phoneBookRepository();
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
