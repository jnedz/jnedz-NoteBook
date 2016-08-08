package adapters;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import utils.CoddingUtils;

public class DateTimeSerializer extends JsonSerializer<DateTime> {
	
	private static String format;
	
	public static String getFormat() {
		format = CoddingUtils.getFORMAT();
		if (format == null){
			format = "dd.MM.yyyy";
		}
		return format;
	}

	public static void setFormat(String format) {
		DateTimeSerializer.format = format;
	}

    private static DateTimeFormatter formatter = 
        DateTimeFormat.forPattern(getFormat());
    
    /**
     * method for serialize DateTime into String (json)
     */
    @Override
    public void serialize(DateTime value, JsonGenerator gen, 
                          SerializerProvider arg2)
        throws IOException, JsonProcessingException {

        gen.writeString(formatter.print(value));
    }
}