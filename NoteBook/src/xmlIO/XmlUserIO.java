package xmlIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import entity.PhoneBook;
import interfacesIO.UserIO;

public class XmlUserIO implements UserIO {

	@Override
	public void writeListTo(PhoneBook phoneBook, String fileName) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(PhoneBook.class);

			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(phoneBook, new FileOutputStream(fileName));
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}


	}

	//@SuppressWarnings("unchecked")
	@Override
	public PhoneBook readListFrom(String fileName) {
		PhoneBook phoneBook = null;
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(PhoneBook.class);
			Unmarshaller marshaller = context.createUnmarshaller();

			phoneBook =  (PhoneBook) marshaller.unmarshal(new File(fileName));
		} catch (JAXBException e) {
	
			e.printStackTrace();
		}
        
		return phoneBook;
	}

}
