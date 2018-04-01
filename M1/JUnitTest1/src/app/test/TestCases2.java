package app.test;

import static org.junit.Assert.assertArrayEquals;

import junit.framework.TestCase;

public class TestCases2 extends TestCase {
	public void setUp() {
		System.out.println("setUp()");
	}
	public void tearDown() {
		System.out.println("tearDown()");

	}
	
	public void testFunct01() {
		System.out.println("test01()");
		int a = 0;
		int b = 0;
		Object o1 = "a";
		Object o2 = "a";
		Object o3 = null;
		
		assertEquals(a, b);
		assertEquals(o1, o2);
		assertTrue("True condition", true);
		assertNotNull(o1);
		assertNull("NULL value", null);
		assertArrayEquals("Equals array", new String[]{"1","12"},	new String[]{"1","2"});
		
		
		

	}

	public void testFunct02() {
		System.out.println("test02()");
		
		int a = 0;
		int b = 0;
		Object o1 = "a";
		Object o2 = "a";
		Object o3 = null;
		
		assertEquals(a, b);
		assertEquals(o1, o2);
		assertTrue("True condition", true);
		assertNotNull(o1);
		assertNull("NULL value", null);
		assertArrayEquals("Equals array", new String[]{"1","12"},	new String[]{"1","2"});
		
		
		

	}

}
