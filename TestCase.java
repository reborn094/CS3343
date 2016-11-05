package test;
import static org.junit.Assert.*;

import org.junit.*;

// import junit.*;
import testInfo.DataStorage;

public class TestCase {
	
	@Test
	public void test1()
	{
		DataStorage test = DataStorage.getInstance();
		assertEquals(test.searchEmployee(8).testFunction(), true);
	}
}
