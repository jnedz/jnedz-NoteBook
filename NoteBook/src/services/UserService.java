package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.joda.time.DateTime;

import entity.PhoneBook;
import entity.User;

public class UserService {

	private List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserService() {
	}

	public UserService(List<User> users) {
		this.users = users;
	}

	public UserService(PhoneBook phoneBook) {
		this.users = phoneBook.getUsers();
	}

	/**
	 * 
	 * @return list Users sorted by first name
	 */
	public List<User> getSortedByFirstName() {
		List<User> sortedList = new ArrayList<>(users);
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
	 * @return list Users sorted by last name
	 */
	public List<User> getSortedByLastName() {
		List<User> sortedList = new ArrayList<>(users);
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
	 * @param type
	 * @return list Users with entered type
	 */
	public List<User> getUsersByType(String type) {
		List<User> usersByType = new ArrayList<>();
		for (User user : users) {
			if (user.getType().equals(type)) {
				usersByType.add(user);
			}
		}
		return usersByType;
	}

	/**
	 * 
	 * @param phoneNumber
	 * @return list Users which contains entered phoneNumber
	 */
	public List<User> getUsersByPhone(String phoneNumber) {
		List<User> usersByPhone = new ArrayList<>();
		for (User user : users) {
			if (user.getTelNumbers().getHomeNumber().contains(phoneNumber)) {
				usersByPhone.add(user);
				break;
			} else if (user.getTelNumbers().getWorkNumber().contains(phoneNumber)) {
				usersByPhone.add(user);
				break;
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
	 * @param email
	 * @return list Users which contains entered email
	 */
	public List<User> getUsersByEmail(String email) {
		List<User> usersByEmail = new ArrayList<>();
		for (User user : users) {
			if (user.getEmail().contains(email)) {
				usersByEmail.add(user);
			}
		}
		return usersByEmail;
	}

	/**
	 * 
	 * @param town
	 * @return list Users which contains entered town
	 */
	public List<User> getUsersByTown(String town) {
		List<User> usersByTown = new ArrayList<>();
		for (User user : users) {
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
	 * @return list Users with first name which contains name1 or name2 and last
	 *         name which contains name2 or name1.
	 */
	public List<User> getUsersByName(String name1, String name2) {
		List<User> usersByName = new ArrayList<>();
		for (User user : users) {
			if (user.getFirstName().contains(name1) && user.getLastName().contains(name2)
					|| user.getFirstName().contains(name2) && user.getLastName().contains(name1)) {
				usersByName.add(user);
			}
		}
		return usersByName;
	}

	//TODO getUsersByDateOfBirthday() by day and month, not year
	/**
	 * 
	 * @param dateOfBirthday
	 * @return list Users with birthday in entered date. Method uses all date
	 *         (day, month, year)
	 */
	public List<User> getUsersByDateOfBirthday(DateTime dateOfBirthday) {
		List<User> usersByDate = new ArrayList<>();
		for (User user : users) {
			if (dateOfBirthday.equals(user.getDateOfBirthday())) {
				usersByDate.add(user);
			}
		}
		return usersByDate;
	}

	/**
	 * 
	 * @param month
	 * @return list Users with birthday in entered month. Method uses only
	 *         months, not years.
	 */
	public List<User> getUsersWithBirthdayInMonth(int month) {
		List<User> usersByMonth = new ArrayList<>();
		for (User user : users) {
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
	 * @return list Users with birthday after start date and before finish date.
	 *         Method uses only days and months, not years
	 */
	public List<User> getUsersWithBirthdayInDiapason(DateTime startDate, DateTime finishDate) {
		List<User> usersByDateDiapason = new ArrayList<>();
		int userDay;
		int userMonth;
		int startDay;
		int startMonth;
		int finishDay;
		int finishMonth;

		for (User user : users) {
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
			//TODO set 1970
		}
		return usersByDateDiapason;
	}
}
