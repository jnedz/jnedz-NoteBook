package consoleIO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import entity.Address;
import entity.PhoneBook;
import entity.PhonsNumbers;
import entity.User;
import enums.Group;
import interfacesIO.UserIO;
import utils.ValidationUtils;

public class ConsoleUserIO implements UserIO {

	private ValidationUtils validation;

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

		PhonsNumbers telNumbers = new PhonsNumbers();
		telNumbers.setHomeNumber(getHomeTelNumber());
		telNumbers.setWorkNumber(getWorkNumber());
		telNumbers.setMobileNumbers(getMobileNumbers());

		user.setTelNumbers(telNumbers);

		return user;
	}

	/**
	 * set codding for selecting validation pattern
	 */
	private void setCodding() {
		Scanner sc = new Scanner(System.in);
		String codding;

		System.out.println("Select language: \nUA - 1, \nEN - 2");
		String cod = sc.next();
		if (cod.equals("1")) {
			codding = "UA";
		} else if (cod.equals("2")) {
			codding = "EN";
		} else {
			codding = "UA";
		}
		validation = new ValidationUtils(codding);
		// sc.close();

	}

	/**
	 * 
	 * @return selected from console users group
	 */
	private Group getTypeFromConsole() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter type of Group (1 - FAMILY, 2 - FRIENDS, 3 - WORK, 4 - OTHER): ");
		Group type = null;
		String str = sc.next();
		switch (str) {
		case "1":
			type = Group.FAMILY;
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
			/*
			 * System.out.println(
			 * "You have entered the wrong type. Please try again."); str =
			 * sc.next(); if (str != "1" || str != "2" || str != "3" || str !=
			 * "4") {
			 */
			System.out.println("You have entered the wrong type. Wrote OTHER.");
			str = "4";
			// }
			break;
		}
		// sc.close();
		return type;
	}

	/**
	 * 
	 * @return selected from console users first name
	 */
	private String getFirstNameFromConsole() {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("Enter first name, please: ");
		do {
			str = sc.next();
			if (!validation.checkCharacters(str)) {
				System.out.println("You have entered the invalide name`s format. Please try again.");
			}
		} while (!validation.checkCharacters(str));
		// sc.close();
		return str;
	}

	/**
	 * 
	 * @return selected from console users last name
	 */
	private String getLastNameFromConsole() {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("Enter last name, please: ");
		do {
			str = sc.next();
			if (!validation.checkCharacters(str)) {
				System.out.println("You have entered the invalide name`s format. Please try again.");
			}
		} while (!validation.checkCharacters(str));
		// sc.close();
		return str;
	}

	/**
	 * 
	 * @return selected from console users email
	 */
	private String getEmailFromConsole() {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("Enter email, please: ");
		do {
			str = sc.next();
			if (!validation.checkEmail(str)) {
				System.out.println("You have entered the invalide email`s format. Please try again.");
			}
		} while (!validation.checkEmail(str));
		// sc.close();
		return str;
	}

	/**
	 * 
	 * @return selected from console users date of birthday
	 */
	private DateTime getDateOfBirthdayFromConsole() {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("Enter date of birthday: ");
		do {
			str = sc.next();
			if (!validation.checkDate(str)) {
				System.out.println("You have entered the invalide date`s format. Please try again.");
			}
		} while (!validation.checkDate(str));

		DateTime dt = new DateTime();
		org.joda.time.format.DateTimeFormatter formatter = null;
		if (this.validation.getCodding().equals("UA")) {
			formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
		}
		if (this.validation.getCodding().equals("EN")) {
			formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
		}

		// org.joda.time.format.DateTimeFormatter formatter =
		// DateTimeFormat.forPattern("dd/MM/yyyy");
		dt = formatter.parseDateTime(str);
		if (dt.isAfterNow()) {
			dt = new DateTime();
		}
		// sc.close();
		return dt;
	}

	/**
	 * 
	 * @return selected from console users index (address)
	 */
	private String getIndexFromConsole() {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("1) index: ");
		do {
			str = sc.next();
			if (!validation.checkIndex(str)) {
				System.out.println("You have entered the invalide index format. Please try again.");
			}
		} while (!validation.checkIndex(str));
		// sc.close();
		return str;
	}

	/**
	 * 
	 * @return selected from console users town (address)
	 */
	private String getTownFromConsole() {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("2) town: ");
		do {
			str = sc.next();
			if (!validation.checkTown(str)) {
				// if (!validation.checkCharacters(str)) {
				System.out.println("You have entered the invalide town format. Please try again.");
			}
		} while (!validation.checkTown(str));
		// } while (!validation.checkCharacters(str));
		// sc.close();
		return str;
	}

	/**
	 * 
	 * @return selected from console users street (address)
	 */
	private String getStreetFromConsole() {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("3) street: ");
		do {
			str = sc.nextLine();
			if (!validation.checkStreet(str)) {
				System.out.println("You have entered the invalide street format. Please try again.");
			}
		} while (!validation.checkStreet(str));
		// sc.close();
		return str;
	}

	/**
	 * 
	 * @return selected from console users build number (address)
	 */
	private String getBuildNumberFromConsole() {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("4) build`s number: ");
		do {
			str = sc.nextLine();
			if (!validation.checkBuildNumber(str)) {
				System.out.println("You have entered the invalide build`s number format. Please try again.");
			}
		} while (!validation.checkBuildNumber(str));
		// sc.close();
		return str;
	}

	/**
	 * 
	 * @return selected from console users home telephone number
	 */
	private String getHomeTelNumber() {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("Will you enter home telephone number? If it is not, enter 'z': ");
		str = sc.next();
		if (!str.equals("z") && !str.equals("Z")) {
			do {
				System.out.println("home number in format '(123)1234567': ");
				str = sc.next();
				if (!validation.checkTelNumber(str)) {
					System.out.println("You have entered the invalide number`s format. Please try again.");
				}
			} while (!validation.checkTelNumber(str));
		}
		// sc.close();
		return str;
	}

	/**
	 * 
	 * @return selected from console users work telephone number
	 */
	private String getWorkNumber() {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("Will you enter work telephone number? If it is not, enter 'z': ");
		str = sc.next();
		if (!str.equals("z") && !str.equals("Z")) {
			do {
				System.out.println("work number in format '(123)1234567': ");
				str = sc.next();
				if (!validation.checkTelNumber(str)) {
					System.out.println("You have entered the invalide number`s format. Please try again.");
				}
			} while (!validation.checkTelNumber(str));
		}
		// sc.close();
		return str;
	}

	/**
	 * 
	 * @return selected from console users mobile telephone numbers
	 */
	private Set<String> getMobileNumbers() {
		Scanner sc = new Scanner(System.in);
		String mobile;
		String str;
		Set<String> mobileNumbers = new HashSet<>();
		System.out.println("Will you enter mobile telephone number? If it is not, enter 'z': ");
		str = sc.next();
		if (!str.equals("z") && !str.equals("Z")) {
			do {
				do {
					System.out.println("mobile number in format '(123)1234567': ");
					str = sc.next();
					if (!validation.checkTelNumber(str)) {
						System.out.println("You have entered the invalide number`s format. Please try again.");
					}
				} while (!validation.checkTelNumber(str));
				mobileNumbers.add(str);
				System.out.println("Do you want to continue to add mobile`s numbers? (1 - yes)");
				mobile = sc.next();
			} while (mobile.equals("1"));
		}
		// sc.close();
		return mobileNumbers;
	}

	/**
	 * method implements from interface and write to console object phoneBook
	 * 
	 * @param fileName
	 *            some String like "Console"
	 * @param phoneBook
	 */
	@Override
	public void writeListTo(PhoneBook phoneBook, String fileName) {
		System.out.println(phoneBook);
	}

	/**
	 * read PhoneBook from console
	 * 
	 * @param fileName
	 *            some String like "Console"
	 */
	@Override
	public PhoneBook readListFrom(String fileName) {

		Scanner sc = new Scanner(System.in);
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
		// sc.close();
		return phones;
	}

}
