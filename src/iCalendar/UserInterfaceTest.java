package iCalendar;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class UserInterfaceTest {
	UserInterface test = new UserInterface();

	@Test
	public void testTitlePrompt() {
		String data = "Hello, World!\r\n";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		String input = test.titlePrompt();
		
		
		assertEquals("Hello, World!\r\n", input);		
	}

	@Test
	public void testStartDatePrompt() {
		
	}

	@Test
	public void testEndDatePrompt() {
		fail("Not yet implemented");
	}

	@Test
	public void testStartTimePrompt() {
		fail("Not yet implemented");
	}

	@Test
	public void testEndTimePrompt() {
		fail("Not yet implemented");
	}

	@Test
	public void testClassificationPrompt() {
		fail("Not yet implemented");
	}

	@Test
	public void testClassificationEqualsNA() {
		fail("Not yet implemented");
	}

	@Test
	public void testLocationPrompt() {
		fail("Not yet implemented");
	}

	@Test
	public void testLatitudinalPrompt() {
		fail("Not yet implemented");
	}

	@Test
	public void testLongitudinalPrompt() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnterGeographicPosition() {
		fail("Not yet implemented");
	}

}
