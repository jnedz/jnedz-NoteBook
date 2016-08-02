package consoleIO;

import java.util.List;
import java.util.Scanner;

import org.joda.time.DateTime;

import entity.Address;
import entity.FonsNumbers;
import entity.User;
import interfacesIO.UserIO;
import validationUtils.ValidationUtil;

public class ConsoleUserIO implements UserIO {
	
	private User readUserFromConsole(){
		User user = new User();
		Scanner sc = new Scanner(System.in);
		String str;
		
		System.out.println("Enter first name, please: "); //TODO name in which format?
		do{
		str = sc.next();
		if (!ValidationUtil.checkName(str)){
			System.out.println("You have entered the invalide name`s formate. Please try again."); //TODO name in which format?
		}
		}while(!ValidationUtil.checkName(str));
		user.setFirstName(str);
		
		System.out.println("Enter last name, please: "); //TODO name in which format?
		do{
		str = sc.next();
		if (!ValidationUtil.checkName(str)){
			System.out.println("You have entered the invalide name`s formate. Please try again."); //TODO name in which format?
		}
		}while(!ValidationUtil.checkName(str));
		user.setLastName(str);
		
		System.out.println("Enter email, please: "); //TODO email in which format?
		do{
		str = sc.next();
		if (!ValidationUtil.checkEmail(str)){
			System.out.println("You have entered the invalide email`s formate. Please try again."); //TODO email in which format?
		}
		}while(!ValidationUtil.checkEmail(str));
		user.setEmail(str);
		
		System.out.println("Enter date of birthday, please: "); //TODO date in which format?
		do{
		str = sc.next();
		if (!ValidationUtil.checkDate(str)){
			System.out.println("You have entered the invalide date`s formate. Please try again."); //TODO date in which format?
		}
		}while(!ValidationUtil.checkDate(str));
		user.setDateOfBirthday(new DateTime(str));
		
		System.out.println("Enter address, please: "); 
		Address address = new Address();
		
		System.out.println("1) index: "); //TODO index in which format?
		do{
		str = sc.next();
		if (!ValidationUtil.checkIndex(str)){
			System.out.println("You have entered the invalide index formate. Please try again."); //TODO index in which format?
		}
		}while(!ValidationUtil.checkIndex(str));
		address.setIndex(str);
		
		System.out.println("2) town: "); //TODO town in which format?
		do{
		str = sc.next();
		if (!ValidationUtil.checkTown(str)){
			System.out.println("You have entered the invalide town formate. Please try again."); //TODO town in which format?
		}
		}while(!ValidationUtil.checkTown(str));
		address.setTown(str);
		
		System.out.println("3) street: "); //TODO street in which format?
		do{
		str = sc.next();
		if (!ValidationUtil.checkStreet(str)){
			System.out.println("You have entered the invalide street formate. Please try again."); //TODO street in which format?
		}
		}while(!ValidationUtil.checkStreet(str));
		address.setStreet(str);
		
		System.out.println("4) build`s number: "); //TODO number in which format?
		do{
		str = sc.next();
		if (!ValidationUtil.checkBuildNumber(str)){
			System.out.println("You have entered the invalide build`s number formate. Please try again."); //TODO number in which format?
		}
		}while(!ValidationUtil.checkBuildNumber(str));
		address.setBuildNumber(str);
		
		user.setAddress(address);
		
		System.out.println("Enter telefone`s numbers, please: "); 
		FonsNumbers telNumbers = new FonsNumbers();
		
		System.out.println("1) home number: "); //TODO number in which format?
		do{
		str = sc.next();
		if (!ValidationUtil.checkTelNumber(str)){
			System.out.println("You have entered the invalide number`s formate. Please try again."); //TODO number in which format?
		}
		}while(!ValidationUtil.checkTelNumber(str));
		//TODO !!! 
		
		
	return user;	
	}

	@Override
	public void writeListTo(List<User> users, String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> readListFrom(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
