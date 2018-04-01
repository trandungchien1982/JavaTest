package app.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCase03 {

	@BeforeClass
	public static void beforeC() {
		System.out.println("Before CLASS ...");
	}
	
	@AfterClass
	public static void afterC() {
		System.out.println("After CLASS ...");
	}
	
	
	@Before
	public void initF() {
		System.out.println("Before");
	}
	
	@After
	public void afterF() {
		// TODO Auto-generated method stub
		System.out.println("After");

	}
	
	@Test
	
	public void test01() {
		System.out.println("test01");
		
	}
	
	@Test
	public void test02() {
		System.out.println("test02");
		
	}

}
