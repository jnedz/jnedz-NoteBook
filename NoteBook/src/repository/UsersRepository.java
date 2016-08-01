package repository;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;

import entity.Address;
import entity.FonsNumbers;
import entity.User;
import enums.Group;

public class UsersRepository {

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
		
		
		FonsNumbers telNumbers = new FonsNumbers();
		telNumbers.setHomeNumber("0372654321");
		telNumbers.setWorkNumbers("0372123456");
		String mobNumber1 = "123456789";
		String mobNumber2 = "987654321";
		Set <String> mobileNumbers = new LinkedHashSet<>();
		mobileNumbers.add(mobNumber1);
		mobileNumbers.add(mobNumber2);
		telNumbers.setMobileNumbers(mobileNumbers);
		user.setTelNumbers(telNumbers);
		
		users.add(user);
		
		user = new User();
		
		user.setFirstName("FN2");
		user.setLastName("LN2");
		user.setType(Group.FRIENDS);
		user.setDateOfBirthday(new DateTime(1980, 01, 15, 00, 00));
		user.setEmail("email2@gmail.com");
		
		address = new Address();
		address.setBuildNumber("20/1");
		address.setIndex("65000");
		address.setStreet("Main str.");
		address.setTown("Lviv");
		user.setAddress(address);
		
		
		telNumbers = new FonsNumbers();
		telNumbers.setHomeNumber("0372654321");
		telNumbers.setWorkNumbers("0372123456");
		String mobNumber3 = "112233445";
		String mobNumber4 = "998877665";
		Set <String> mobileNumbers2 = new LinkedHashSet<>();
		mobileNumbers2.add(mobNumber3);
		mobileNumbers2.add(mobNumber4);
		telNumbers.setMobileNumbers(mobileNumbers2);
		user.setTelNumbers(telNumbers);
		
		users.add(user);
		
		return users;
	}
}
