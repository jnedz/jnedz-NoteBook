package main;

import org.joda.time.DateTime;

import consoleIO.ConsoleUserIO;
import entity.PhoneBook;
import repository.Repository;
import services.PhoneBookService;
import utils.DbUtils;
import xmlIO.XmlUserIO;

public class Main {
	// User user = new User();

	public static void main(String... args) {

		PhoneBookService phbookServ = new PhoneBookService(Repository.phoneBookRepository());
	//	System.out.println(phbookServ.getSortedByLastName());
	//	System.out.println(phbookServ.getUsersByDateOfBirthday(new DateTime(1980, 01, 15, 0, 0)));
	//	System.out.println(phbookServ.getUsersByDayAndMonth(new  DateTime(2016, 01, 15, 0, 0)));
	//	System.out.println(phbookServ.getUsersByEmail("email2@gmail.com"));
	//	System.out.println(phbookServ.getUsersByName("LN1", "FN1"));
	//	System.out.println(phbookServ.getUsersByPhoneContains("123"));
	//	System.out.println(phbookServ.getUsersByPhoneNumberEquals("(123)4567890"));
	//	System.out.println(phbookServ.getUsersByTown("Rivne"));
	//	System.out.println(phbookServ.getUsersByType("OTHER"));
	//	System.out.println(phbookServ.getUsersWithBirthdayInMonth(5));
		
		
		
		
	/*	System.out.println(phbookServ.getUsersWithBirthdayInDiapason2(new DateTime(2016, 1, 20, 0, 0),
				new DateTime(2016, 2, 25, 0, 0)));
*/
		
		// System.out.println(Repository.usersRepository());
		// System.out.println(Repository.phoneBookRepository());

		ConsoleUserIO cu = new ConsoleUserIO();
		
	/*	
		PhoneBook phoneBook = cu.readPhoneBookFrom("console");
		 System.out.println(phoneBook);
	*/	
		
		XmlUserIO xml = new XmlUserIO();
		
		//PhoneBook phoneBook = Repository.phoneBookRepository();
	
/*		JsonIO js = new JsonIO();
		
		js.writePhoneBookTo(phoneBook, "e:\\json1.json");
		
		System.out.println(js.readPhoneBookFrom("e:\\json1.json"));
				// List<User> users = Repository.usersRepository();

*/		
//		  PhoneBook users = Repository.phoneBookRepository();
//		  xml.writePhoneBookTo(users, "e:\\xml1.xml");
		
		// System.out.println(xml.readPhoneBookFrom("e:\\xml1.xml"));

		DbUtils.createAddressesTable();
	//	DbUtils.createUsersTable();
	//	DbUtils.dropUsersTable();
		
	}
}
