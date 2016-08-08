package adapters;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

import utils.CoddingUtils;

public class DateTimeDeserializer extends StdScalarDeserializer<DateTime> {

	private static final long serialVersionUID = 1L;

	private static String format;

	public static String getFormat() {
		format = CoddingUtils.getFORMAT();
		if (format == null) {
			format = "dd.MM.yyyy";
		}
		return format;
	}

	public DateTimeDeserializer() {
		super(DateTime.class);
	}

	private static DateTimeFormatter formatter = DateTimeFormat.forPattern(getFormat());

	/**
	 * method for deserialize from String to DateTime (json)
	 */
	@Override
	public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {

		String dateTimeAsString = jsonParser.getText().trim();
		return formatter.parseDateTime(dateTimeAsString);
	}

}