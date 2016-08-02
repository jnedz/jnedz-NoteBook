package interfacesIO;

import java.util.List;

import entity.PhoneBook;
import entity.User;

public interface UserIO {

	/*public void writeListTo(List<User>users, String fileName);
	
	public List<User> readListFrom(String fileName);*/
	
	public void writeListTo(PhoneBook pb, String fileName);
	
	public PhoneBook readListFrom(String fileName);
	
}
