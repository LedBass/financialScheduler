/**
 * 
 */
package com.marcio.financialScheduler.config;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Class responsible for parsing {@link String} into {@link LocalDate}
 * @author marcio
 *
 */
@JsonComponent
public class LocalDateJsonDeserializer {
	public static class LocalDateDesirializer extends JsonDeserializer<LocalDate> {

		@Override
		public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
			String serialized = jsonParser.getValueAsString();

            if (serialized == null || serialized.isEmpty()) {
                return null;
            }

            return LocalDate.parse(serialized, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		
	}
}
