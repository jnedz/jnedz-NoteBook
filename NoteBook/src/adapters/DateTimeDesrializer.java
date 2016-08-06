package adapters;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

public class DateTimeDesrializer extends StdScalarDeserializer<DateTime> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public DateTimeDesrializer() {
        super(DateTime.class);
    }
    
    private static DateTimeFormatter formatter = 
            DateTimeFormat.forPattern("dd.MM.yyyy");
    

    @SuppressWarnings("finally")
	@Override
    public DateTime deserialize(JsonParser jsonParser,
                                DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        try {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_STRING) {
                String dateTimeAsString = jsonParser.getText().trim();
                return formatter.parseDateTime(dateTimeAsString);
            }
        } finally {
            throw deserializationContext.mappingException(getValueClass());
        }
    }
}