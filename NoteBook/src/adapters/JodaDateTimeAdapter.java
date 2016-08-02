package adapters;


import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JodaDateTimeAdapter extends XmlAdapter<String, DateTime> {

	@Override
	public String marshal(DateTime v) throws Exception {
		return v.toString("dd/MM/YYYY");
	}

	@Override
	public DateTime unmarshal(String v) throws Exception {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		
		
		return formatter.parseDateTime(v);
	}

  
  
}
