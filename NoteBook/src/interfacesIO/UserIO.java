package interfacesIO;

import entity.PhoneBook;

public interface UserIO {

	/*public void writeListTo(List<User>users, String fileName);
	
	public List<User> readListFrom(String fileName);*/
	
	public void writeListTo(PhoneBook pb, String fileName);
	
	public PhoneBook readListFrom(String fileName);
	
}
