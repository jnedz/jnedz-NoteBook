package interfacesIO;

import entity.PhoneBook;

public interface UserIO {

	public void writePhoneBookTo(PhoneBook pb, String fileName);
	
	public PhoneBook readPhoneBookFrom(String fileName);
	
}
