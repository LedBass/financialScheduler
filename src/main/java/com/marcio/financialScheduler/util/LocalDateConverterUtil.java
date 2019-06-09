/**
 * 
 */
package com.marcio.financialScheduler.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Class to convert a {@link LocalDate} into {@link Date} and vice-versa
 * @author marcio
 *
 */
@Converter(autoApply = true)
public class LocalDateConverterUtil implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		if (attribute == null) {
			return null;
		}
		
		return Date.from(attribute.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		if (dbData == null) {
			return null;
		}
		
		return dbData.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public Long getDifferneceInDaysBetweenTwoLocalDates(LocalDate start, LocalDate end) {
		return ChronoUnit.DAYS.between(start, end);
	}
	
	public Long getDifferneceInDaysBetweenTwoDates(Date start, Date end) {
		LocalDate startDate = this.convertToEntityAttribute(start);
		LocalDate endDate = this.convertToEntityAttribute(end);
		return this.getDifferneceInDaysBetweenTwoLocalDates(startDate, endDate);
	}
}
