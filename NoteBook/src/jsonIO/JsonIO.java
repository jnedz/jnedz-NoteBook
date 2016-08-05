package jsonIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entity.PhoneBook;
import entity.User;
import interfacesIO.UserIO;

public class JsonIO implements UserIO {

	@Override
	public void writeListTo(PhoneBook pb, String fileName) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File(fileName), pb);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public PhoneBook readListFrom(String fileName) {

		ObjectMapper mapper = new ObjectMapper();
		List<User> users = new ArrayList<>();

		try {
			String jsonInString = mapper.writeValueAsString(users);
		
		    /*users = mapper.readValue(
		            jsonInString,
		            mapper.getTypeFactory().constructCollectionType(
		                    List.class, User.class));
		    users = mapper.readValue(new File(fileName),  mapper.getTypeFactory().constructCollectionType(
                    List.class, User.class));
		   */
		    PhoneBook ph = mapper.readValue(new File(fileName), PhoneBook.class);
		    
		    
		    System.out.println(ph);
		   // System.out.println(ph.getUsers().get(1).toString());
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PhoneBook pb = new PhoneBook();
		pb.setUsers(users);
		return pb;
	
 
	}
}
