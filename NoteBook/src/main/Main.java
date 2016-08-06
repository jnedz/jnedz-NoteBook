package main;

import java.io.IOException;

import org.joda.time.DateTime;

import consoleIO.ConsoleUserIO;
import entity.PhoneBook;
import jsonIO.JsonIO;
import repository.Repository;
import services.PhoneBookService;
import xmlIO.XmlUserIO;

public class Main {
	// User user = new User();

	public static void main(String... args) {

		PhoneBookService phbookServ = new PhoneBookService(Repository.phoneBookRepository());
	/*	System.out.println(phbookServ.getUsersWithBirthdayInDiapason2(new DateTime(2016, 1, 20, 0, 0),
				new DateTime(2016, 5, 25, 0, 0)));
*/
		
		// System.out.println(Repository.usersRepository());
		// System.out.println(Repository.phoneBookRepository());

		ConsoleUserIO cu = new ConsoleUserIO();
		
		
	/*	PhoneBook phoneBook = cu.readListFrom("console");
		 System.out.println(phoneBook);
	*/	
		
		XmlUserIO xml = new XmlUserIO();
		
		PhoneBook phoneBook = Repository.phoneBookRepository();
	
		JsonIO js = new JsonIO();
		
		js.writeListTo(phoneBook, "e:\\json1.json");
		
		System.out.println(js.readListFrom("e:\\json1.json"));
				// List<User> users = Repository.usersRepository();

		
	/*	  PhoneBook users = Repository.phoneBookRepository();
		  xml.writeListTo(users, "e:\\xml1.xml");
		*/
		// System.out.println(xml.readListFrom("e:\\xml1.xml"));

		// UserService us = new UserService(users);
		// System.out.println(us.getSortedByFirstName());
		// System.out.println(us.getSortedByLastName());
		// System.out.println(us.getUsersByPhone("123"));

		// TODO dateTime formatter!!!
		// System.out.println(us.getUsersWithBirthdayInDiapason(("10/10/2016"),
		// "21.10.2016"));
	}
}
