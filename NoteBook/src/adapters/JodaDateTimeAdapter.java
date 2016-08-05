package adapters;


import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import utils.CoddingUtils;

public class JodaDateTimeAdapter extends XmlAdapter<String, DateTime> {
	
	private String format;
	
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	public JodaDateTimeAdapter(){
		format = CoddingUtils.getFORMAT();
		if (format == null){
			format = "dd.MM.yyyy";
		}
	}
	
	@Override
	public String marshal(DateTime v) throws Exception {
		return v.toString(format);
	}

	@Override
	public DateTime unmarshal(String v) throws Exception {
		DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
		return formatter.parseDateTime(v);
	}

  
  
}
