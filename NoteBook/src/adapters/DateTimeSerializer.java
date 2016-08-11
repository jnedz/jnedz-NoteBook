package adapters;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import utils.CoddingUtils;

public class DateTimeSerializer extends JsonSerializer<DateTime> {

	private static String FORMAT;

	
	public static void setFORMAT(String fORMAT) {
		FORMAT = fORMAT;
	}

	public static String getFORMAT() {
		if (FORMAT == null){
		FORMAT = CoddingUtils.getFORMAT();
		if (FORMAT == null) {
			FORMAT = "dd.MM.yyyy";
		}
		}
		return FORMAT;
	}

	/**
	 * method for serialize DateTime into String (json)
	 */
	@Override
	public void serialize(DateTime value, JsonGenerator gen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {

		gen.writeString(DateTimeFormat.forPattern(getFORMAT()).print(value));
	}

}