package repository;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;

import entity.Address;
import entity.PhonsNumbers;
import entity.PhoneBook;
import entity.User;
import enums.Group;
import utils.DbUtils;

public class Repository {

	public static List<User> usersRepository() {

		List<User> users = new ArrayList<>();
		User user = new User();

		user.setFirstName("FN1");
		user.setLastName("LN1");
		user.setType(Group.FAMILY);
		user.setDateOfBirthday(new DateTime(1990, 10, 20, 00, 00));
		user.setEmail("email1@gmail.com");

		Address address = new Address();
		address.setBuildNumber("10/2");
		address.setIndex("58000");
		address.setStreet("Golovna str.");
		address.setTown("Chernivtsy");
		user.setAddress(address);

		PhonsNumbers telNumbers = new PhonsNumbers();
		telNumbers.setHomeNumber("0372654321");
		telNumbers.setWorkNumber("0372123456");
		String mobNumber1 = "1234567890";
		String mobNumber2 = "0987654321";
		Set<String> mobileNumbers = new LinkedHashSet<>();
		mobileNumbers.add(mobNumber1);
		mobileNumbers.add(mobNumber2);
		telNumbers.setMobileNumbers(mobileNumbers);
		user.setTelNumbers(telNumbers);

		users.add(user);

		user = new User();

		user.setFirstName("FN4");
		user.setLastName("LN4");
		user.setType(Group.FRIENDS);
		user.setDateOfBirthday(new DateTime(1980, 01, 15, 00, 00));
		user.setEmail("email2@gmail.com");

		address = new Address();
		address.setBuildNumber("20/1");
		address.setIndex("65000");
		address.setStreet("Main str.");
		address.setTown("Lviv");
		user.setAddress(address);

		telNumbers = new PhonsNumbers();
		telNumbers.setHomeNumber("0372654321");
		telNumbers.setWorkNumber("0372123456");
		// String mobNumber3 = "112233445";
		// String mobNumber4 = "998877665";
		Set<String> mobileNumbers2 = new LinkedHashSet<>();
		// mobileNumbers2.add(mobNumber3);
		// mobileNumbers2.add(mobNumber4);
		telNumbers.setMobileNumbers(mobileNumbers2);
		user.setTelNumbers(telNumbers);

		users.add(user);

		user = new User();

		user.setFirstName("FN3");
		user.setLastName("LN3");
		user.setType(Group.OTHER);
		user.setDateOfBirthday(new DateTime(1970, 01, 25, 00, 00));
		user.setEmail("email3@gmail.com");

		address = new Address();
		address.setBuildNumber("40/1 25");
		address.setIndex("43002");
		address.setStreet("Street str.");
		address.setTown("Odessa");
		user.setAddress(address);

		telNumbers = new PhonsNumbers();
		telNumbers.setHomeNumber("0372556699");
		telNumbers.setWorkNumber("0372445511");
		String mobNumber5 = "(050)888-99-44";
		String mobNumber6 = "(066)555-44-21";
		Set<String> mobileNumbers3 = new LinkedHashSet<>();
		mobileNumbers3.add(mobNumber5);
		mobileNumbers3.add(mobNumber6);
		telNumbers.setMobileNumbers(mobileNumbers3);
		user.setTelNumbers(telNumbers);

		users.add(user);

		user = new User();

		user.setFirstName("FN2");
		user.setLastName("LN2");
		user.setType(Group.FRIENDS);
		user.setDateOfBirthday(new DateTime(1995, 02, 15, 00, 00));
		user.setEmail("email4@gmail.com");

		address = new Address();
		address.setBuildNumber("287/g");
		address.setIndex("24005");
		address.setStreet("Sss str.");
		address.setTown("Rivne");
		user.setAddress(address);

		telNumbers = new PhonsNumbers();
		telNumbers.setHomeNumber("(111)1111111");
		telNumbers.setWorkNumber("(222)2222222");
		Set<String> mobileNumbers4 = new LinkedHashSet<>();
		mobileNumbers4.add("(123)4567890");
		mobileNumbers4.add("(098)7654321");
		telNumbers.setMobileNumbers(mobileNumbers4);
		user.setTelNumbers(telNumbers);

		users.add(user);

		user = new User();

		user.setFirstName("FN5");
		user.setLastName("LN5");
		user.setType(Group.WORK);
		user.setDateOfBirthday(new DateTime(1975, 05, 21, 00, 00));
		user.setEmail("email4@gmail.com");

		address = new Address();
		address.setBuildNumber("555");
		address.setIndex("12555");
		address.setStreet("Fff str.");
		address.setTown("Town");
		user.setAddress(address);

		telNumbers = new PhonsNumbers();
		telNumbers.setHomeNumber("(555)5555555");
		telNumbers.setWorkNumber("(888)8888888");
		Set<String> mobileNumbers5 = new LinkedHashSet<>();
		mobileNumbers5.add("(222)5652145");
		mobileNumbers5.add("(558)7569845");
		telNumbers.setMobileNumbers(mobileNumbers5);
		user.setTelNumbers(telNumbers);

		users.add(user);

		return users;
	}

	public static PhoneBook phoneBookRepository() {
		PhoneBook phoneBook = new PhoneBook(usersRepository());
		return phoneBook;
	}
	
	public static void createDbTables(){
		DbUtils.createAddressesTable();
		DbUtils.createMobileNumbersTable();
		DbUtils.createPhoneNumbersTable();
		DbUtils.createPhoneBookTable();
	}
	
	public static void dropDbTables(){
		DbUtils.dropPhoneBookTable();
		DbUtils.dropPhoneNumbersTable();
		DbUtils.dropMobileNumbersTable();
		DbUtils.dropAddressesTable();
	}
}
