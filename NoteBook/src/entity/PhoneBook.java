package entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PhoneBook {

	private long id;
	private Owner owner;
	private List<User> users;

	
	@XmlElement
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlElement
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

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
		if (owner != null){
			str += getOwner().toString();
		}
		if (users != null){
		for (User user : users) {
				str += user.toString();				
		}
		}else {str = "PhoneBook has not got users";}
		return str;
	}
	
	
}
