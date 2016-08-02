package interfacesIO;

import java.util.List;

import entity.User;

public interface UserIO {

	public void writeListTo(List<User>users, String fileName);
	
	public List<User> readListFrom(String fileName);
	
}
