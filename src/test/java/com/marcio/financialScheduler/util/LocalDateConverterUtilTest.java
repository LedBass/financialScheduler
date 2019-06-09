/**
 * 
 */
package com.marcio.financialScheduler.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * @author marcio
 *
 */
class LocalDateConverterUtilTest {

	/**
	 * Test method for {@link com.marcio.financialScheduler.util.LocalDateConverterUtil#convertToDatabaseColumn(java.time.LocalDate)}.
	 */
	@Test
	void testConvertToDatabaseColumn() {
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		LocalDate localDate = LocalDate.now();
		assertTrue(converterUtil.convertToDatabaseColumn(localDate) instanceof Date);
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.util.LocalDateConverterUtil#convertToEntityAttribute(java.util.Date)}.
	 */
	@Test
	void testConvertToEntityAttribute() {
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		Date date = new Date();
		assertTrue(converterUtil.convertToEntityAttribute(date) instanceof LocalDate);
		
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.util.LocalDateConverterUtil#convertToDatabaseColumn(java.time.LocalDate)}.
	 */
	@Test
	void testConvertToDatabaseColumnShouldReturnNull() {
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		assertNull(converterUtil.convertToDatabaseColumn(null));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.util.LocalDateConverterUtil#convertToEntityAttribute(java.util.Date)}.
	 */
	@Test
	void testConvertToEntityAttributeShouldReturnNull() {
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		assertNull(converterUtil.convertToEntityAttribute(null));
	}

}
