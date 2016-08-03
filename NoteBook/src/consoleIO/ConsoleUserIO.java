package consoleIO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import entity.Address;
import entity.PhonsNumbers;
import entity.PhoneBook;
import entity.User;
import enums.Group;
import interfacesIO.UserIO;
import validationUtils.ValidationUtils;

public class ConsoleUserIO implements UserIO {
	
	private String codding;
	
	private ValidationUtils validation = new ValidationUtils(codding);
	
	private Scanner sc = new Scanner(System.in);
	
	
	private void setCodding(){
		System.out.println("Select language: \nUA - 1, \nEN - 2");
		String cod = sc.next();
		if (cod.equals("1")) {
			codding = "UA";
		}
		if (cod.equals("2")) {
			codding = "EN";
		}
	}
	
	private Group getTypeFromConsole(){
		System.out.println("Enter type of Group (1 - FAMILY, 2 - FRIENDS, 3 - WORK, 4 - OTHER): ");
		Group type = null;
		String str = sc.next();
		switch (str) {
		case "1":
			type =  Group.FAMILY;
			break;
		case "2":
			type = Group.FRIENDS;
			break;
		case "3":
			type = Group.WORK;
			break;
		case "4":
			type = Group.OTHER;
			break;
		default:
			System.out.println("You have entered the wrong type. Please try again.");
			str = sc.next();
			if (str != "1" || str != "2" || str != "3" || str != "4") {
				System.out.println("You have entered the wrong type. Wrote OTHER.");
				str = "4";
			}
			break;
		}
		return type;
	}
	
	private String getFirstNameFromConsole(){
		String str;
		System.out.println("Enter first name, please: "); 
		do {
			str = sc.next();
			if (!validation.checkCharacters(str)) {
				System.out.println("You have entered the invalide name`s format. Please try again."); 
			}
		} while (!validation.checkCharacters(str));
		return str;
	}
	
	private String getLastNameFromConsole(){
		String str;
		System.out.println("Enter last name, please: "); 
		do {
			str = sc.next();
			if (!validation.checkCharacters(str)) {
				System.out.println("You have entered the invalide name`s format. Please try again."); 
			}
		} while (!validation.checkCharacters(str));
		return str;
	}
	
	private String getEmailFromConsole(){
		String str;
		System.out.println("Enter email, please: "); 
		do {
			str = sc.next();
			if (!validation.checkEmail(str)) {
				System.out.println("You have entered the invalide email`s format. Please try again."); 
			}
		} while (!validation.checkEmail(str));
		return str;
	}
	
	private DateTime getDateOfBirthdayFromConsole(){
		String str;
		System.out.println("Enter date of birthday: "); 
		do {
			str = sc.next();
			if (!validation.checkDate(str)) {
				System.out
						.println("You have entered the invalide date`s format. Please try again."); 
			}
		} while (!validation.checkDate(str));
		
		DateTime dt = new DateTime();
		org.joda.time.format.DateTimeFormatter formatter = null;
		if (codding.equals("UA")) {
			formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
		}
		if (codding.equals("EN")) {
			formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
		}

		//org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		dt = formatter.parseDateTime(str);
		return dt;
	}
	
	private String getIndexFromConsole(){
		String str;
		System.out.println("1) index: "); 
		do {
			str = sc.next();
			if (!validation.checkIndex(str)) {
				System.out.println("You have entered the invalide index format. Please try again."); 
			}
		} while (!validation.checkIndex(str));
		return str;
	}
	
	private String getTownFromConsole(){
		String str;
		System.out.println("2) town: "); 
		do {
			str = sc.next();
			if (!validation.checkCharacters(str)) {
				System.out.println("You have entered the invalide town format. Please try again."); 
			}
		} while (!validation.checkCharacters(str));
		return str;
	}
	
	private String getStreetFromConsole(){
		String str;
		System.out.println("3) street: "); 
		do {
			str = sc.next(); //str = sc.nextLine();
			if (!validation.checkCharacters(str)) {
				System.out.println("You have entered the invalide street format. Please try again."); 
			}
		} while (!validation.checkCharacters(str));
		return str;
	}
	
	private String getBuildNumberFromConsole(){
		String str;
		System.out.println("4) build`s number: "); 
		do {
			str = sc.next();//str = sc.nextLine();
			if (!validation.checkBuildNumber(str)) {
				System.out.println("You have entered the invalide build`s number format. Please try again."); 
			}
		} while (!validation.checkBuildNumber(str));
		return str;
	}
	
	private String getHomeTelNumber(){
		String str;
		System.out.println("home number (if it is not, enter 'z'): "); 
		str = sc.next();
		if (!str.equals("z") && !str.equals("Z")){
		do {
			if (!validation.checkTelNumber(str)) {
				System.out.println("You have entered the invalide number`s format. Please try again."); 
				str = sc.next();
			}
		} while (!validation.checkTelNumber(str));
		}
		return str;
	}
	
	private String getWorkNumber(){
		String str;
		str = sc.next();
		System.out.println("work number: (if it is not, enter 'z'): "); 
		if (!str.equals("z") && !str.equals("Z")){
		do {
			if (!validation.checkTelNumber(str)) {
				System.out.println("You have entered the invalide number`s format. Please try again."); 
				str = sc.next();
			}
		} while (!validation.checkTelNumber(str));
		}
		return str;
	}
	
	private Set<String> getMobileNumbers(){
		String mobile;
		String str;
		Set<String> mobileNumbers = new HashSet<>();
		
			System.out.println("mobile`s number: (if it is not, enter 'z'): ");
			str = sc.next();
			if (!str.equals("z") && !str.equals("Z")){
				do {
					//System.out.println("mobile`s number: ");	
			do {
				//str = sc.next();
				if(!validation.checkTelNumber(str)) {
					System.out.println("You have entered the invalide number`s format. Please try again."); 
					str = sc.next();
				}
			} while (!validation.checkTelNumber(str));
			mobileNumbers.add(str);

			System.out.println("Do you want to continue to add mobile`s numbers? (1 - yes)");
			mobile = sc.next();
			if (mobile.equals("1")){
				System.out.println("mobile`s number: ");	
			}
		} while (mobile.equals("1"));
			}
			
		return mobileNumbers;
	}

	/**
	 * read from console one user
	 */
	private User readUserFromConsole() {
		User user = new User();
		
		setCodding();
		
		user.setType(getTypeFromConsole());
		user.setFirstName(getFirstNameFromConsole());
		user.setLastName(getLastNameFromConsole());
		user.setEmail(getEmailFromConsole());
		user.setDateOfBirthday(new DateTime(getDateOfBirthdayFromConsole()));
		
		System.out.println("Enter address, please: ");
		Address address = new Address();
		address.setIndex(getIndexFromConsole());
		address.setTown(getTownFromConsole());
		address.setStreet(getStreetFromConsole());
		address.setBuildNumber(getBuildNumberFromConsole());
		
		user.setAddress(address);

		System.out.println("Enter telefone`s numbers in format '(123)1234567', please: ");
		PhonsNumbers telNumbers = new PhonsNumbers();
		telNumbers.setHomeNumber(getHomeTelNumber());
		telNumbers.setWorkNumber(getWorkNumber());
		telNumbers.setMobileNumbers(getMobileNumbers());
		
		user.setTelNumbers(telNumbers);
		
		return user;
	}

	/**
	 * method implements from interface and write to console object phoneBook
	 * @param fileName some String like "Console"
	 * @param phoneBook
	 */
	@Override
	public void writeListTo(PhoneBook phoneBook, String fileName) {
		System.out.println(phoneBook);
	}

	/**
	 * read PhoneBook from console
	 * @param fileName some String like "Console"
	 */
	@Override
	public PhoneBook readListFrom(String fileName) {

		List<User> users = new ArrayList<>();
		User user = new User();
		String str;
		do {
			user = readUserFromConsole();
			users.add(user);
			
			System.out.println("Do you want to continue to add users? (1 - yes)");
			str = sc.next();
		} while (str.equals("1"));

		PhoneBook phones = new PhoneBook(users);
		return phones;
	}

}
