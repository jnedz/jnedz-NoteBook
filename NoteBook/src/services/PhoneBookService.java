package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.joda.time.DateTime;

import entity.PhoneBook;
import entity.User;

public class PhoneBookService {

	private PhoneBook phoneBook;

	public PhoneBook getPhoneBook() {
		return phoneBook;
	}

	public void setPhoneBook(PhoneBook phoneBook) {
		this.phoneBook = phoneBook;
	}

	public PhoneBookService(PhoneBook phoneBook) {
		this.phoneBook = phoneBook;
	}

	/**
	 * 
	 * @return PhoneBook (list users) sorted by first name
	 */
	public PhoneBook getSortedByFirstName() {
		PhoneBook phBook = new PhoneBook();
		List<User> sortedList = new ArrayList<>(phoneBook.getUsers());
		Collections.sort(sortedList, new Comparator<User>() {

			@Override
			public int compare(User u1, User u2) {

				return u1.getFirstName().compareTo(u2.getFirstName());
			}
		});
		phBook.setUsers(sortedList);
		return phBook;
	}

	/**
	 * 
	 * @return PhoneBook (list users) sorted by last name
	 */
	public PhoneBook getSortedByLastName() {
		PhoneBook phBook = new PhoneBook();
		List<User> sortedList = new ArrayList<>(phoneBook.getUsers());
		Collections.sort(sortedList, new Comparator<User>() {

			@Override
			public int compare(User u1, User u2) {

				return u1.getLastName().compareTo(u2.getLastName());
			}
		});
		phBook.setUsers(sortedList);
		return phBook;
	}

	/**
	 * 
	 * @param type
	 * @return PhoneBook (list users) with entered type
	 */
	public PhoneBook getUsersByType(String type) {
		PhoneBook phBook = new PhoneBook();
		List<User> usersByType = new ArrayList<>();
		for (User user : phoneBook.getUsers()) {
			if (user.getType().name().equals(type)) {
				usersByType.add(user);
			}
		}
		phBook.setUsers(usersByType);
		return phBook;
	}

	/**
	 * 
	 * @param phoneNumber
	 * @return PhoneBook (list users) which contains entered phoneNumber
	 */
	public PhoneBook getUsersByPhoneContains(String phoneNumber) {
		PhoneBook phBook = new PhoneBook();
		List<User> usersByPhone = new ArrayList<>();
		for (User user : phoneBook.getUsers()) {
			if (user.getTelNumbers().getHomeNumber().contains(phoneNumber)) {
				usersByPhone.add(user);
			} else if (user.getTelNumbers().getWorkNumber().contains(phoneNumber)) {
				usersByPhone.add(user);
			} else
				for (String mobile : user.getTelNumbers().getMobileNumbers()) {
					if (mobile.contains(phoneNumber)) {
						usersByPhone.add(user);
					}
				}
		}
		phBook.setUsers(usersByPhone);
		return phBook;
	}

	/**
	 * 
	 * @param email
	 * @return PhoneBook (list users) which contains entered email
	 */
	public PhoneBook getUsersByEmail(String email) {
		PhoneBook phBook = new PhoneBook();
		List<User> usersByEmail = new ArrayList<>();
		for (User user : phoneBook.getUsers()) {
			if (user.getEmail().contains(email)) {
				usersByEmail.add(user);
			}
		}
		phBook.setUsers(usersByEmail);
		return phBook;
	}

	/**
	 * 
	 * @param town
	 * @return PhoneBook (list users) which contains entered town
	 */
	public PhoneBook getUsersByTown(String town) {
		PhoneBook phBook = new PhoneBook();
		List<User> usersByTown = new ArrayList<>();
		for (User user : phoneBook.getUsers()) {
			if (user.getAddress().getTown().contains(town)) {
				usersByTown.add(user);
			}
		}
		phBook.setUsers(usersByTown);
		return phBook;
	}

	/**
	 * 
	 * @param name1
	 * @param name2
	 * @return PhoneBook (list users) with first name which contains name1 or
	 *         name2 and last name which contains name2 or name1.
	 */
	public PhoneBook getUsersByName(String name1, String name2) {
		PhoneBook phBook = new PhoneBook();
		List<User> usersByName = new ArrayList<>();
		for (User user : phoneBook.getUsers()) {
			if (user.getFirstName().contains(name1) && user.getLastName().contains(name2)
					|| user.getFirstName().contains(name2) && user.getLastName().contains(name1)) {
				usersByName.add(user);
			}
		}
		phBook.setUsers(usersByName);
		return phBook;
	}

	/**
	 * 
	 * @param dateOfBirthday
	 * @return PhoneBook (list users) with birthday in entered date. Method uses
	 *         all date (day, month, year)
	 */
	public PhoneBook getUsersByDateOfBirthday(DateTime dateOfBirthday) {
		PhoneBook phBook = new PhoneBook();
		List<User> usersByDate = new ArrayList<>();
		for (User user : phoneBook.getUsers()) {
			if (dateOfBirthday.equals(user.getDateOfBirthday())) {
				usersByDate.add(user);
			}
		}
		phBook.setUsers(usersByDate);
		return phBook;
	}

	// TODO new
	/**
	 * 
	 * @param dateOfBirthday
	 * @return PhoneBook (list users) with birthday in entered date. Method uses
	 *         only day and month, not year
	 */
	public PhoneBook getUsersByDayAndMonth(DateTime date) {
		PhoneBook phBook = new PhoneBook();
		List<User> usersByDate = new ArrayList<>();
		for (User user : phoneBook.getUsers()) {
			if (user.getDateOfBirthday().getDayOfMonth() == date.getDayOfMonth()
					&& user.getDateOfBirthday().getMonthOfYear() == date.getMonthOfYear()) {
				usersByDate.add(user);
			}
		}
		phBook.setUsers(usersByDate);
		return phBook;
	}

	/**
	 * 
	 * @param month
	 * @return PhoneBook (list users) with birthday in entered month. Method
	 *         uses only months, not years.
	 */
	public PhoneBook getUsersWithBirthdayInMonth(int month) {
		PhoneBook phBook = new PhoneBook();
		List<User> usersByMonth = new ArrayList<>();
		for (User user : phoneBook.getUsers()) {
			if (user.getDateOfBirthday().getMonthOfYear() == month) {
				usersByMonth.add(user);
			}
		}
		phBook.setUsers(usersByMonth);
		return phBook;
	}

	/**
	 * 
	 * @param startDate
	 *            start date from Diapason
	 * @param finishDate
	 *            finish date from Diapason
	 * @return PhoneBook (list users) with birthday after start date and before
	 *         finish date. Method uses only days and months, not years
	 */
	public PhoneBook getUsersWithBirthdayInDiapason(DateTime startDate, DateTime finishDate) {
		PhoneBook phBook = new PhoneBook();
		List<User> usersByDateDiapason = new ArrayList<>();
		int userDay;
		int userMonth;
		int startDay;
		int startMonth;
		int finishDay;
		int finishMonth;

		for (User user : phoneBook.getUsers()) {
			userDay = user.getDateOfBirthday().getDayOfMonth();
			userMonth = user.getDateOfBirthday().getMonthOfYear();
			startDay = startDate.getDayOfMonth();
			startMonth = startDate.getMonthOfYear();
			finishDay = finishDate.getDayOfMonth();
			finishMonth = finishDate.getMonthOfYear();

			if (startMonth == finishMonth) {
				if (userDay >= startDay && userDay <= finishDay)
					usersByDateDiapason.add(user);
			}
			if ((finishMonth - startMonth) == 1) {
				if ((userMonth == startMonth && userDay >= startDay)
						|| (userMonth == finishMonth && userDay <= finishDay))
					usersByDateDiapason.add(user);
			}
			if ((finishMonth - startMonth) > 1) {
				if ((userMonth > startMonth && userMonth < finishMonth)
						|| (userMonth == startMonth && userDay >= startDay)
						|| (userMonth == finishMonth && userDay <= finishDay))
					usersByDateDiapason.add(user);
			}
			// TODO set 1970
		}
		phBook.setUsers(usersByDateDiapason);
		return phBook;
	}

	//////////////////////////////////////////////////
	/**
	 * 
	 * @param startDate
	 *            start date from Diapason
	 * @param finishDate
	 *            finish date from Diapason
	 * @return PhoneBook (list users) with birthday after start date and before
	 *         finish date. Method uses only days and months, not years
	 */
	public PhoneBook getUsersWithBirthdayInDiapason2(DateTime startDate, DateTime finishDate) {
		PhoneBook phBook = new PhoneBook();
		List<User> usersByDateDiapason = new ArrayList<>();

		int dayStart = startDate.getDayOfMonth();
		int monthStart = startDate.getMonthOfYear();
		DateTime newStartDate = new DateTime(1970, monthStart, dayStart, 0, 0);

		int dayFinish = finishDate.getDayOfMonth();
		int monthFinish = finishDate.getMonthOfYear();
		DateTime newFinishDate = new DateTime(1970, monthFinish, dayFinish, 0, 0);

		for (User user : phoneBook.getUsers()) {
			int day = user.getDateOfBirthday().getDayOfMonth();
			int month = user.getDateOfBirthday().getMonthOfYear();
			DateTime newDateOfBirthday = new DateTime(1970, month, day, 0, 0);

			if (newDateOfBirthday.getMillis() >= newStartDate.getMillis()
					&& newDateOfBirthday.getMillis() <= newFinishDate.getMillis()) {
				usersByDateDiapason.add(user);
			}
		}
		phBook.setUsers(usersByDateDiapason);
		return phBook;
	}

	/**
	 * 
	 * @param phoneNumber
	 * @return all users with entered phone number
	 */
	public List<User> getUsersByPhoneNumberEquals(String phoneNumber) {
		List<User> users = new ArrayList<>();
		for (User user : phoneBook.getUsers()) {
			UserService userService = new UserService(user);
			if (userService.isGetNumber(phoneNumber)) {
				users.add(user);
			}
		}
		return users;
	}

	/**
	 * 
	 * @param user
	 *            add unique for the first names and last names users
	 */
	public void add(User user) {
		boolean addUser = false;
		if (phoneBook.getUsers().isEmpty()) {
			addUser = true;
		} else
			for (User us : phoneBook.getUsers()) {
				if (!(us.getFirstName().equals(user.getFirstName()))
						&& !(us.getLastName().equals(user.getLastName()))) {
					addUser = true;
				}
			}
		if (addUser == true) {
			phoneBook.getUsers().add(user);
		}
	}

	public void add2(User user) {
		UserService userService = new UserService(user);
		for (User us : phoneBook.getUsers()) {
			if (!(userService.isContaint(us.getFirstName(), us.getLastName()))) {
				phoneBook.getUsers().add(user);
			}
		}
	}

}
