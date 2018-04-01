package app.mockito.unit01;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

	//@InjectMocks annotation is used to create and inject the mock object
	@InjectMocks	
	MathApplication mathApplication;// = new MathApplication();

	//@Mock annotation is used to create the mock object to be injected
	@Mock
	CalculatorService calcService;
	
	CalculatorService calcServiceSpy;
	
	@Before
	public void setUp() {
		// TODO Auto-generated method stub
		calcServiceSpy = spy(Calculator.class);
		mathApplication.setCalcServiceSpy(calcServiceSpy);
	}
	
	@After
	public void tearDown() {
		calcServiceSpy = null;
	}
	
	@Test
	public void testAssert(){
		//add the behavior of calc service to add two numbers
		when(calcService.add(10.0,20.0)).thenReturn(30.00);		

		//test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
				
	}
	
	@Test
	public void testVerify(){
		//add the behavior of calc service to add two numbers
		when(calcService.add(10.0,20.0)).thenReturn(50.00);

		//test the add functionality
		Assert.assertEquals(mathApplication.add2(10.0, 20.0),250.0,0);		
		
		// Verify that the method calcService.add() will be executed with the parameter 10.0, 20.0
		//verify(calcService).add(10.0, 20.0);
		//verify(calcService).add(11.0, 40.0);
		
		// verify that the method calcService.add() will be executed 5 times with parameter (10.0, 20.0)
		verify(calcService, times(5)).add(10.0, 20.0);
		// verify that the method calcService.add() will be executed 10 times with parameter (30.0, 40.0)
		verify(calcService, times(10)).add(30.0, 50.0);
		
		// verify that the method .multiply() was never called on the mock
		verify(calcService, never()).multiply(10.0, 20.0);
	}
	
	@Test
	public void testNumTimesExec(){
		//add the behavior of calc service to add two numbers
		when(calcService.add(10.0,20.0)).thenReturn(50.00);

		//test the add functionality
		Assert.assertEquals(mathApplication.add2(10.0, 20.0),250.0,0);		
				
		// check the minimum call of function
		verify(calcService, atLeastOnce()).add(10.0, 20.0);
		// verify that the method calcService.add() will be executed 10 times with parameter (30.0, 40.0)
		verify(calcService, atLeast(9)).add(30.0, 50.0);
		
		// verify that the method .multiply() was never called on the mock
		verify(calcService, never()).multiply(10.0, 20.0);
	}
	
	@Test
	public void testException(){
		// add the behavior about throwing exception
		doThrow(new NullPointerException("Custom Exception in Mockito - TDC")).when(calcService).add(10, 20);

		//test the add functionality
		try {
			Assert.assertEquals(mathApplication.add2(10, 20),250);	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void testOrder(){
		
		//add the behavior of calc service to add two numbers
		when(calcService.add(10,20)).thenReturn(30.0);
		when(calcService.multiply(10,20)).thenReturn(200.0);
		

		//test the add functionality
		Assert.assertEquals(mathApplication.add(10, 20),30,0);		
		Assert.assertEquals(mathApplication.multiply(10, 20),200.0,0);

		// Create order rule
		InOrder inOrder = inOrder(calcService);
		
		inOrder.verify(calcService).add(10.0, 20.0);
		inOrder.verify(calcService).multiply(10, 20);
				
	}
	
	@Test
	public void testCallback(){
		
		//add the behavior of calc service to add two numbers
		when(calcService.add(10,20)).thenAnswer(new Answer<Double>() {
			@Override
			public Double answer(InvocationOnMock invocation) throws Throwable {
				//get the arguments passed to mock
				Object[] args = invocation.getArguments();
				
				System.out.println("args : " + args);
				//get the mock 
				Object mock = invocation.getMock();
				System.out.println("mock : " + mock);
				
				double x = 0;
				if (args != null) {					
					for (Object arg : args) {
						x += (Double)arg;
					}
				}
				return (x*10);
			}
		});

		//test the add functionality
		Assert.assertEquals(mathApplication.add(10, 20),300,0);		
	}
	
	@Test
	public void testSpy(){
		//add the behavior of calc service to add two numbers
		//when(calcServiceSpy.add(10.0,20.0)).thenReturn(40.00);
		
		//test the add functionality
		Assert.assertEquals(mathApplication.addSpy(10.0, 20.0),30.0,0);
				
	}
	
	@Test
	public void testResetMock(){
		//add the behavior of calc service to add two numbers
		when(calcService.add(10.0,20.0)).thenReturn(30.00);		

		//test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
		
		//reset(calcService);
		//add the behavior of calc service to add two numbers
		//when(calcService.add(10.0,20.0)).thenReturn(30.00);		

		//test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
	}
	
	@Test
	public void testGivenWill(){
		//add the behavior of calc service to add two numbers
		//when(calcService.add(10.0,20.0)).thenReturn(30.00);		
		given(calcService.add(10.0,20.0)).willReturn(30.00);

		//test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
		
		//reset(calcService);
		//add the behavior of calc service to add two numbers
		//when(calcService.add(10.0,20.0)).thenReturn(30.00);		

		//test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
	}
	
	@Test
	public void testTimeout(){
		//add the behavior of calc service to add two numbers
		when(calcService.divide(10.0,20.0)).thenReturn(30.00);

		//test the add functionality
		Assert.assertEquals(mathApplication.divide(10.0, 20.0),30.0,0);		
		
		// Verify that the method calcService.add() will be executed with the parameter 10.0, 20.0
		verify(calcService, timeout(100)).divide(10.0, 20.0);		
	}
}

/**
 * Class implements Calculator Service
 * @author tdc
 *
 */
class Calculator implements CalculatorService {
    @Override
    public double add(double input1, double input2) {
       return input1 + input2;
    }

    @Override
    public double subtract(double input1, double input2) {
       throw new UnsupportedOperationException("Method not implemented yet!");
    }

    @Override
    public double multiply(double input1, double input2) {
       throw new UnsupportedOperationException("Method not implemented yet!");
    }

    @Override
    public double divide(double input1, double input2) {
       throw new UnsupportedOperationException("Method not implemented yet!");
    }
 }