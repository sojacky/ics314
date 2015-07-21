package iCalendar;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputValidatorTest {

	InputValidator test = new InputValidator();
	
	@Test
	public void testIsValidDateString() {

		assertTrue(test.isValidDateString("12/12/1234"));
		assertFalse(test.isValidDateString("as/as/asdf"));
		assertFalse(test.isValidDateString("asasasdf"));
		assertFalse(test.isValidDateString(""));
		assertFalse(test.isValidDateString("1234567890"));
		assertFalse(test.isValidDateString("123/12/1234"));
		assertFalse(test.isValidDateString("12/123/1234"));
		assertFalse(test.isValidDateString("12/12/12345"));
		assertFalse(test.isValidDateString("12.12.1234"));
		
	}

	@Test
	public void testIsValidTimeString() {
		assertTrue(test.isValidTimeString("01:12 am"));
		assertTrue(test.isValidTimeString("01:12 pm"));	
		assertFalse(test.isValidTimeString(""));
		assertFalse(test.isValidTimeString("aa:12 pm"));
		assertFalse(test.isValidTimeString("12/12 pm"));
		assertFalse(test.isValidTimeString("12:aa pm"));
		assertFalse(test.isValidTimeString("12:12pm"));
		assertFalse(test.isValidTimeString("12:12 qm"));
		assertFalse(test.isValidTimeString("12:12 pq"));
		assertFalse(test.isValidTimeString("123:123 pm"));
	}

	@Test
	public void testIsValidClassification() {
		assertTrue(test.isValidClassification("public"));
		assertTrue(test.isValidClassification("PUBLIC"));
		assertTrue(test.isValidClassification("private"));
		assertTrue(test.isValidClassification("PRIVATE"));
		assertTrue(test.isValidClassification("confidential"));
		assertTrue(test.isValidClassification("CONFIDENTIAL"));
		assertTrue(test.isValidClassification("NA"));
		assertTrue(test.isValidClassification("na"));
		assertFalse(test.isValidClassification(""));
		assertFalse(test.isValidClassification("aA1!/"));
		
			
			
	}

	@Test
	public void testIsValidGeographicPosition() {
		assertTrue(test.isValidGeographicPosition("00.000000"));
		assertTrue(test.isValidGeographicPosition("+00.000000"));
		assertTrue(test.isValidGeographicPosition("-00.000000"));
		assertTrue(test.isValidGeographicPosition("12.123456"));
		assertTrue(test.isValidGeographicPosition("00.0"));
		assertTrue(test.isValidGeographicPosition("+00.0"));
		assertTrue(test.isValidGeographicPosition("-00.0"));
		assertFalse(test.isValidGeographicPosition("*00.000000"));
		assertFalse(test.isValidGeographicPosition("as.000000"));
		assertFalse(test.isValidGeographicPosition("+as.000000"));
		assertFalse(test.isValidGeographicPosition("-as.000000"));
		assertFalse(test.isValidGeographicPosition("00/000000"));
		assertFalse(test.isValidGeographicPosition("+00/000000"));
		assertFalse(test.isValidGeographicPosition("-00/000000"));
		assertFalse(test.isValidGeographicPosition("00.asdfas"));
		assertFalse(test.isValidGeographicPosition("+00.asdfas"));
		assertFalse(test.isValidGeographicPosition("-00.asdfas"));
		assertFalse(test.isValidGeographicPosition("0.000000"));
		assertFalse(test.isValidGeographicPosition("+0.000000"));
		assertFalse(test.isValidGeographicPosition("-0.000000"));
		assertFalse(test.isValidGeographicPosition("000.000000"));
		assertFalse(test.isValidGeographicPosition("00.00000000"));
		assertFalse(test.isValidGeographicPosition(""));
		
	}

}
