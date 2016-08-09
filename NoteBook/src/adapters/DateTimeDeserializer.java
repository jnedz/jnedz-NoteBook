package adapters;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import utils.CoddingUtils;

public class DateTimeDeserializer extends JsonDeserializer<DateTime> {

	private static String FORMAT;
	
	public static void setFORMAT(String format) {
		FORMAT = format;
	}

	public static String getFORMAT() {
		if (FORMAT == null){
		
			FORMAT = "dd.MM.yyyy";
		}
		return FORMAT;
	}
	
	@Override
	public DateTime deserialize(JsonParser jsonParser, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		String dateTimeAsString = jsonParser.getText().trim();
		return DateTimeFormat.forPattern(FORMAT).parseDateTime(dateTimeAsString);
	}
	
}