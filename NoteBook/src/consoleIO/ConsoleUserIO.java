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
	Scanner sc = new Scanner(System.in);

	private User readUserFromConsole() {
		User user = new User();
		String str;

		System.out.println("Enter type of Group (1 - FAMILY, 2 - FRIENDS, 3 - WORK, 4 - OTHER): ");
		str = sc.next();
		switch (str) {
		case "1":
			user.setType(Group.FAMILY);
			break;
		case "2":
			user.setType(Group.FRIENDS);
			break;
		case "3":
			user.setType(Group.WORK);
			break;
		case "4":
			user.setType(Group.OTHER);
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
		
		
		System.out.println("Enter first name, please: "); // TODO name in which
															// format?
		do {
			str = sc.next();
			if (!ValidationUtils.checkTitle(str)) {
				System.out.println("You have entered the invalide name`s format. Please try again."); // TODO
																										// name
																										// in
																										// which
																										// format?
			}
		} while (!ValidationUtils.checkTitle(str));
		user.setFirstName(str);

		System.out.println("Enter last name, please: "); // TODO name in which
															// format?
		do {
			str = sc.next();
			if (!ValidationUtils.checkTitle(str)) {
				System.out.println("You have entered the invalide name`s format. Please try again."); // TODO
																										// name
																										// in
																										// which
																										// format?
			}
		} while (!ValidationUtils.checkTitle(str));
		user.setLastName(str);

		System.out.println("Enter email, please: "); // TODO email in which
														// format?
		do {
			str = sc.next();
			if (!ValidationUtils.checkEmail(str)) {
				System.out.println("You have entered the invalide email`s format. Please try again."); // TODO
																										// email
																										// in
																										// which
																										// format?
			}
		} while (!ValidationUtils.checkEmail(str));
		user.setEmail(str);

		System.out.println("Enter date of birthday in format dd/MM/yyyy: "); // TODO
																				// date
																				// in
																				// which
																				// format?
		do {
			str = sc.next();
			if (!ValidationUtils.checkDate(str)) {
				System.out
						.println("You have entered the invalide date`s format. Please try again (format dd/MM/yyyy)."); // TODO
																														// date
																														// in
																														// which
																														// format?
			}
		} while (!ValidationUtils.checkDate(str));
		DateTime dt = new DateTime();
		org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		dt = formatter.parseDateTime(str);
		user.setDateOfBirthday(new DateTime(dt));

		System.out.println("Enter address, please: ");
		Address address = new Address();

		System.out.println("1) index: "); // TODO index in which format?
		do {
			str = sc.next();
			if (!ValidationUtils.checkIndex(str)) {
				System.out.println("You have entered the invalide index format. Please try again."); // TODO
																										// index
																										// in
																										// which
																										// format?
			}
		} while (!ValidationUtils.checkIndex(str));
		address.setIndex(str);

		System.out.println("2) town: "); // TODO town in which format?
		do {
			str = sc.next();
			if (!ValidationUtils.checkTitle(str)) {
				System.out.println("You have entered the invalide town format. Please try again."); // TODO
																									// town
																									// in
																									// which
																									// format?
			}
		} while (!ValidationUtils.checkTitle(str));
		address.setTown(str);

		System.out.println("3) street: "); // TODO street in which format?
		do {
			str = sc.next();
			if (!ValidationUtils.checkTitle(str)) {
				System.out.println("You have entered the invalide street format. Please try again."); // TODO
																										// street
																										// in
																										// which
																										// format?
			}
		} while (!ValidationUtils.checkTitle(str));
		address.setStreet(str);

		System.out.println("4) build`s number: "); // TODO number in which
													// format?
		do {
			str = sc.nextLine();
			if (!ValidationUtils.checkBuildNumber(str)) {
				System.out.println("You have entered the invalide build`s number format. Please try again."); // TODO
																												// number
																												// in
																												// which
																												// format?
			}
		} while (!ValidationUtils.checkBuildNumber(str));
		address.setBuildNumber(str);

		user.setAddress(address);

		System.out.println("Enter telefone`s numbers, please: ");
		PhonsNumbers telNumbers = new PhonsNumbers();

		System.out.println("home number: "); // TODO number in which format?
		do {
			str = sc.next();
			if (!ValidationUtils.checkTelNumber(str)) {
				System.out.println("You have entered the invalide number`s format. Please try again."); // TODO
																										// number
																										// in
																										// which
																										// format?
			}
		} while (!ValidationUtils.checkTelNumber(str));
		telNumbers.setHomeNumber(str);

		System.out.println("work number: "); // TODO number in which format?
		do {
			str = sc.next();
			if (!ValidationUtils.checkTelNumber(str)) {
				System.out.println("You have entered the invalide number`s format. Please try again."); // TODO
																										// number
																										// in
																										// which
																										// format?
			}
		} while (!ValidationUtils.checkTelNumber(str));
		telNumbers.setWorkNumber(str);

		String mobile;
		Set<String> mobileNumbers = new HashSet<>();
		do {
			System.out.println("mobile`s number: ");
			do {
				str = sc.next();
				if (!ValidationUtils.checkTelNumber(str)) {
					System.out.println("You have entered the invalide number`s format. Please try again."); // TODO
																											// number
																											// in
																											// which
																											// format?
				}
			} while (!ValidationUtils.checkTelNumber(str));
			mobileNumbers.add(str);

			System.out.println("Do you want to continue to add mobile`s numbers? (1 - yes)");
			mobile = sc.next();
		} while (mobile.equals("1"));
		telNumbers.setMobileNumbers(mobileNumbers);

		user.setTelNumbers(telNumbers);

		return user;
	}

	@Override
	public void writeListTo(PhoneBook phoneBook, String fileName) {
		System.out.println(phoneBook);
	}

	@Override
	//public List<User> readListFrom(String fileName) {
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
