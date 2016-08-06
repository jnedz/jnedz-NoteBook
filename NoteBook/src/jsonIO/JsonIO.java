package jsonIO;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import adapters.DateTimeModule;
import entity.PhoneBook;
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
		PhoneBook ph = new PhoneBook();

		try {
			mapper.registerModule(new DateTimeModule());
			//mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		   ph = mapper.readValue(new File(fileName), PhoneBook.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return ph;
	
 
	}
}
