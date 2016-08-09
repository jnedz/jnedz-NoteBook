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
	public List<User> getSortedByFirstName() {
		List<User> sortedList = new ArrayList<>(phoneBook.getUsers());
		Collections.sort(sortedList, new Comparator<User>() {

			@Override
			public int compare(User u1, User u2) {

				return u1.getFirstName().compareTo(u2.getFirstName());
			}
		});
		return sortedList;
	}

	/**
	 * 
	 * @return PhoneBook (list users) sorted by last name
	 */
	public List<User> getSortedByLastName() {
		List<User> sortedList = new ArrayList<>(phoneBook.getUsers());
		Collections.sort(sortedList, new Comparator<User>() {

			@Override
			public int compare(User u1, User u2) {

				return u1.getLastName().compareTo(u2.getLastName());
			}
		});
		return sortedList;
	}

	/**
	 * 
	 * @return users sorted by group(type). When group is the same - sorted by last name
	 */
	public List<User> getUsersByTypeSortedByLastName(){
		List<User> sortedList = new ArrayList<>(phoneBook.getUsers());
		Collections.sort(sortedList, new Comparator<User>() {

			@Override
			public int compare(User u1, User u2) {

				if (u1.getType().name().compareTo(u2.getType().name()) == 0){
					return u1.getLastName().compareTo(u2.getLastName());
				}
				else 
					return u1.getType().name().compareTo(u2.getType().name());
			}
		});
		return sortedList;
	}
	
	
	/**
	 * 
	 * @param type
	 * @return PhoneBook (list users) with entered type
	 */
	public List<User> getUsersByType(String type) {
		List<User> usersByType = new ArrayList<>();
		for (User user : phoneBook.getUsers()) {
			if (user.getType().name().equals(type)) {
				usersByType.add(user);
			}
		}
		return usersByType;
	}

	/**
	 * 
	 * @param phoneNumber
	 * @return PhoneBook (list users) which contains entered phoneNumber
	 */
	public List<User> getUsersByPhoneContains(String phoneNumber) {
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
		return usersByPhone;
	}


	/**
	 * 
	 * @param town
	 * @return PhoneBook (list users) which contains entered town
	 */
	public List<User> getUsersByTown(String town) {
		List<User> usersByTown = new ArrayList<>();
		for (User user : phoneBook.getUsers()) {
			if (user.getAddress().getTown().contains(town)) {
				usersByTown.add(user);
			}
		}
		return usersByTown;
	}

	/**
	 * 
	 * @param name1
	 * @param name2
	 * @return PhoneBook (list users) with first name which contains name1 or
	 *         name2 and last name which contains name2 or name1.
	 */
	//TODO +email
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

	/**
	 * 
	 * @param dateOfBirthday
	 * @return PhoneBook (list users) with birthday in entered date. Method uses
	 *         only day and month, not year
	 */
	public PhoneBook getUsersByToday(DateTime date) {
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
	public List<User> getUsersWithBirthdayInMonth(int month) {
		List<User> usersByMonth = new ArrayList<>();
		for (User user : phoneBook.getUsers()) {
			if (user.getDateOfBirthday().getMonthOfYear() == month) {
				usersByMonth.add(user);
			}
		}
		return usersByMonth;
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
	public List<User> getUsersWithBirthdayInDiapason(DateTime startDate, DateTime finishDate) {
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
		return usersByDateDiapason;
	}

	/**
	 * 
	 * @param phoneNumber
	 * @return all users with entered phone number
	 */
	public PhoneBook getUsersByPhoneNumberEquals(String phoneNumber) {
		PhoneBook phBook = new PhoneBook();
		List<User> users = new ArrayList<>();
		for (User user : phoneBook.getUsers()) {
			UserService userService = new UserService(user);
			if (userService.isGetNumber(phoneNumber)) {
				users.add(user);
			}
		}
		phBook.setUsers(users);
		return phBook;
	}

	/**
	 * 
	 * @param user
	 *            add unique for the first names and last names users
	 */
	public void add(User user) {
		boolean isUser = false;
		if (phoneBook.getUsers().isEmpty()) {
			isUser = true;
		} else
			for (User us : phoneBook.getUsers()) {
				if (!(us.getFirstName().equals(user.getFirstName()))
						&& !(us.getLastName().equals(user.getLastName()))) {
					isUser = true;
				}
			}
		if (isUser) {
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

	public List<User> searchUsers(String str) {
		List<User> users = new ArrayList<>();
		for (User us : phoneBook.getUsers()) {
			if (us.getFirstName().contains(str) || us.getLastName().contains(str) || us.getEmail().contains(str)) {
				users.add(us);
			}
		}
		return users;
	}
	
}
