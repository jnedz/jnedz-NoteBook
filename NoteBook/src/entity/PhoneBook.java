package entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PhoneBook {

	private List<User> users;

	@XmlElement
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public PhoneBook(List<User> users) {
		this.setUsers(users);
	}

	public PhoneBook() {
	}

	@Override
	public String toString() {
		String str = "";
		for (User user : users) {
			
				str += user.toString();				
			
		}
		return str;
	}
	
}
