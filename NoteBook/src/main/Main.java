package main;

import java.util.LinkedHashSet;
import java.util.Set;

import org.joda.time.DateTime;

import consoleIO.ConsoleUserIO;
import dao.PhoneBookDAO;
import entity.Address;
import entity.PhoneBook;
import entity.PhonsNumbers;
import entity.User;
import enums.Group;
import jsonIO.JsonIO;
import repository.Repository;
import services.PhoneBookService;
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
		
		
		PhoneBook phoneBook = Repository.phoneBookRepository();
	
		JsonIO js = new JsonIO();
		
	js.writePhoneBookTo(phoneBook, "e:\\json1.json");
		
	//	System.out.println(js.readPhoneBookFrom("e:\\json1.json"));
				// List<User> users = Repository.usersRepository();

		
//		  PhoneBook users = Repository.phoneBookRepository();
//		  xml.writePhoneBookTo(users, "e:\\xml1.xml");
		
		// System.out.println(xml.readPhoneBookFrom("e:\\xml1.xml"));

	//	DbUtils.createAddressesTable();
	//	DbUtils.createMobileNumbersTable();
	//	DbUtils.createPhoneNumbersTable();
	//	DbUtils.createPhoneBookTable();
	//	DbUtils.dropPhoneBookTable();
	//	DbUtils.dropAddressesTable();
	//	DbUtils.dropMobileNumbersTable();
		
		
	//	Repository.createDbTables();
	//	Repository.dropDbTables();
	/*	
		User user = new User();

		user.setFirstName("FN1");
		user.setLastName("LN1");
		user.setType(Group.FAMILY);
		user.setDateOfBirthday(new DateTime(1990, 10, 20, 00, 00));
		user.setEmail("email1@gmail.com");

		Address address = new Address();
		address.setId(1);
		address.setBuildNumber("10/2");
		address.setIndex("58000");
		address.setStreet("Golovna str.");
		address.setTown("Chernivtsy");
		user.setAddress(address);

		PhonsNumbers telNumbers = new PhonsNumbers();
		telNumbers.setId(1);
		telNumbers.setHomeNumber("0372654321");
		telNumbers.setWorkNumber("0372123456");
		String mobNumber1 = "1234567890";
		String mobNumber2 = "0987654321";
		Set<String> mobileNumbers = new LinkedHashSet<>();
		mobileNumbers.add(mobNumber1);
		mobileNumbers.add(mobNumber2);
		telNumbers.setMobileNumbers(mobileNumbers);
		user.setTelNumbers(telNumbers);
		
		
		PhoneBookDAO.add(user);

		*/
	}
}
