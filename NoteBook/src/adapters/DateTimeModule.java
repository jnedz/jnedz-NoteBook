package adapters;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class DateTimeModule extends SimpleModule {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DateTimeModule() {
        super();
        addSerializer(DateTime.class, new DateTimeSerializer());
        addDeserializer(DateTime.class, new DateTimeDesrializer());
    }
}