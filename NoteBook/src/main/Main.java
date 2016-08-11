package main;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.joda.time.DateTime;

import dao.AddressesDAO;
import dao.OwnersDAO;
import dao.PhoneBooksDAO;
import dao.PhonesNumbersDAO;
import dao.UsersDAO;
import entity.Address;
import entity.Owner;
import entity.PhoneBook;
import entity.PhoneNumber;
import entity.User;
import enums.Group;
import enums.NumbersType;
import jsonIO.JsonIO;
import repository.Repository;
import services.PhoneBookService;
import utils.DbUtils;
import xmlIO.XmlUserIO;

public class Main {
	// User user = new User();

	public static void main(String... args) {

		PhoneBookService phbookServ = new PhoneBookService(Repository.phoneBookRepository());
		
	//	System.out.println(phbookServ.searchUsers("ail4"));
		
	//	System.out.println(phbookServ.getUsersByTypeSortedByLastName());
		
	//	System.out.println(phbookServ.getSortedByLastName());
	//	System.out.println(phbookServ.getUsersByDateOfBirthday(new DateTime(1980, 01, 15, 0, 0)));
	//	System.out.println(phbookServ.getUsersByToday(new  DateTime(2016, 01, 15, 0, 0)));
	//	System.out.println(phbookServ.getUsersByName("LN1", "FN1"));
	//	System.out.println(phbookServ.getUsersByPhoneContains("123"));
	//	System.out.println(phbookServ.getUsersByPhoneNumberEquals("(037)1111111"));
	//	System.out.println(phbookServ.getUsersByTown("Rivne"));
	//	System.out.println(phbookServ.getUsersByType("OTHER"));
	//	System.out.println(phbookServ.getUsersWithBirthdayInMonth(5));
		
		
		
		
	/*	System.out.println(phbookServ.getUsersWithBirthdayInDiapason2(new DateTime(2016, 1, 20, 0, 0),
				new DateTime(2016, 2, 25, 0, 0)));
*/
		
	//	 System.out.println(Repository.usersRepository());
	//	 System.out.println(Repository.phoneBookRepository());

	/*	ConsoleUserIO cu = new ConsoleUserIO();
		
		
		PhoneBook phoneBook = cu.readPhoneBookFrom("console");
		 System.out.println(phoneBook);
	*/		
		
		XmlUserIO xml = new XmlUserIO();
		
	
	//	PhoneBook phoneBook = Repository.phoneBookRepository();
		
	//	PhoneBook phoneBook = new PhoneBook();
	//	phoneBook.setUsers(phbookServ.getUsersByTypeSortedByLastName());
	
		JsonIO js = new JsonIO();
	/*	
		DateTimeSerializer.setFORMAT("dd/MM/yy");
		DateTimeDeserializer.setFORMAT("dd/MM/yy");
		
		js.writePhoneBookTo(phoneBook, "e:\\json1.json");
		
		System.out.println(js.readPhoneBookFrom("e:\\json1.jsoe:\\json1.jsonn"));
	*/
		
	//	xml.writePhoneBookTo(users, "e:\\xml1.xml");
	//	PhoneBook pb = xml.readPhoneBookFrom("e:\\json1.json");
	//	js.writePhoneBookTo(pb, "e:\\json1.json");
	/*
		PhoneBook pb = js.readPhoneBookFrom("e:\\json1.json");
		System.out.println(pb);
	*/	
	//	xml.writePhoneBookTo(pb, "e:\\xml1.xml");
	//	*/
		
		
	//	System.out.println(js.readPhoneBookFrom("e:\\xml1.xml"));	
	
				// List<User> users = Repository.usersRepository();

		
	/*	  PhoneBook users = Repository.phoneBookRepository();
		  xml.writePhoneBookTo(users, "e:\\xml1.xml");
		
		 System.out.println(xml.readPhoneBookFrom("e:\\xml1.xml"));
*/
	//	DbUtils.createAddressesTable();
	//	DbUtils.createPhonesNumbersTable();
	//	DbUtils.createPhoneBookTable();
	//	DbUtils.dropPhoneBookTable();
	//	DbUtils.dropAddressesTable();
	//	DbUtils.dropPhonesNumbersTable();
		
		
	//	Repository.createDbTables();
	//	Repository.dropDbTables();

		
		//Repository.createDbTables();
		//Repository.dropDbTables();
	/*	
		Address address = new Address();
		address.setBuildNumber("10/2");
		address.setIndex("58000");
		address.setStreet("Golovna str.");
		address.setTown("Chernivtsy");
		
		AddressesDAO.add(address);
	*/
		
/*	Owner owner = new Owner();
		owner.setLogin("login1");
		owner.setPassword("password1");
		
		OwnersDAO.add(owner);
*/	
		
	/* 
	 * !!!!!!!!!!!!!!!!!!!!
	 * 	
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
		
		AddressesDAO.add(address);
		
		user.setAddress(address);
		UsersDAO.add(user);

		
		PhoneNumber phoneNumber = new PhoneNumber();
		Set<PhoneNumber> phonesNumbers = new LinkedHashSet<>();
		phoneNumber.setNumbersType(NumbersType.HOME);
		phoneNumber.setPhoneNumber("(050)1111111");
		
		phonesNumbers.add(phoneNumber);
		
		PhonesNumbersDAO.add(phoneNumber, user);
		
		phoneNumber = new PhoneNumber();
		phoneNumber.setNumbersType(NumbersType.WORK);
		phoneNumber.setPhoneNumber("(050)2222222");
		
		phonesNumbers.add(phoneNumber);
		
		PhonesNumbersDAO.add(phoneNumber, user);
		
		user.setPhonesNumbers(phonesNumbers);
		
		
		ArrayList<User> users = new ArrayList<>();
		users.add(user);
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.setUsers(users);
		Owner owner = new Owner();
		owner.setLogin("login1");
		owner.setPassword("password1");
		OwnersDAO.add(owner);
		owner.setId(1);
		phoneBook.setOwner(owner);
		
		PhoneBooksDAO.add(user, owner);
	*/	
		
		
/*		PhoneNumbers telNumbers = new PhonsNumbers();
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
	*/	

		
	/*	PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setNumbersType(NumbersType.HOME);
		phoneNumber.setPhoneNumber("(050)1111111");
		//User user = new User();
		
		PhonesNumbersDAO.add(phoneNumber, 1);
	*/	
	/*	PhoneBooksDAO.delete(3);
		PhonesNumbersDAO.delete(2);
		PhonesNumbersDAO.delete(3);
		PhonesNumbersDAO.delete(4);
		PhonesNumbersDAO.delete(5);
		PhonesNumbersDAO.delete(6);
		PhonesNumbersDAO.delete(7);
		PhonesNumbersDAO.delete(8);
		PhonesNumbersDAO.delete(9);
		UsersDAO.delete(3926);
		UsersDAO.delete(4824);
		UsersDAO.delete(6367);
		UsersDAO.delete(7873);
		OwnersDAO.delete(1);
		AddressesDAO.delete(1);
	*/	
	/*	
		Address address = AddressesDAO.getAddressById(1);
		address.setBuildNumber("10/2");
		address.setIndex("58000");
		address.setStreet("Golovna str.");
		address.setTown("Chernivtsy");
		AddressesDAO.update(address);
	*/
		//System.out.println(AddressesDAO.getAll());
		//System.out.println(OwnersDAO.getAll());
		//System.out.println(PhonesNumbersDAO.getAll());
	}
	
	
}
