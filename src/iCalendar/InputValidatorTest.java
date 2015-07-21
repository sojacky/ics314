package iCalendar;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputValidatorTest {

	@Test
	public void testIsValidDateString() {
		InputValidator test = new InputValidator();
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
		fail("Not yet implemented");
	}

	@Test
	public void testIsValidClassification() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsValidGeographicPosition() {
		fail("Not yet implemented");
	}

}
