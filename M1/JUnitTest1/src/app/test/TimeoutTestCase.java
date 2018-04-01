package app.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TimeoutTestCase {

	
	private void testFunc() {
		for (int i = 0; i < 100; i++) {
			System.out.println("i : " + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test(timeout=20)	
	public void test01() {
		System.out.println("test01");
		testFunc();
		
	}
	
	@Test
	public void test02() {
		System.out.println("test02");
		
	}
	
	@Test(expected=NullPointerException.class)
	public void test04() throws Exception {
		System.out.println("test02");
		
		throw new IllegalAccessException("My custom Exception - CH");
		
	}
	
	@Test
	public void test05() throws Exception {
		fail("This is the failure message in test05()");
	}

	@Test
	public void test06() throws Exception {
		Assume.assumeFalse(false);
		System.out.println("test06");
	}
	
	
	@Test
	@Ignore("Do not need in this time")
	public void test03() {
		System.out.println("test02");
		
	}

}
