package main;

import xmlIO.XmlUserIO;

public class Main {
	//User user = new User();

	public static void main (String ... args) {
		
		//System.out.println(Repository.usersRepository());
		//System.out.println(Repository.phoneBookRepository());
		/*
		ConsoleUserIO cu = new ConsoleUserIO();
		System.out.println(cu.readListFrom("console"));
		*/
		
		XmlUserIO xml = new XmlUserIO();
		//List<User> users = UsersRepository.usersRepository();
/*		
		PhoneBook users = Repository.phoneBookRepository();
		xml.writeListTo(users, "e:\\xml1.xml");
	*/	
		System.out.println(xml.readListFrom("e:\\xml1.xml"));
	}
}
