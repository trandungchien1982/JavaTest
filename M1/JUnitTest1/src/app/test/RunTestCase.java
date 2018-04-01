package app.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import app.test.advance.RepeatTestCase;
import app.test.advance.RuleTestCase;
import junit.extensions.RepeatedTest;

/**
 * Run the test case directly, not through the JUnit Tool.
 * We can analyse all fail or successful cases
 * 
 * @author tdc
 *
 */
public class RunTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Result result = JUnitCore.runClasses(RuleTestCase.class);
		//Result result = JUnitCore.runClasses(AllTestsSuite.class);
		//Result result = JUnitCore.runClasses(RepeatTestCase.class);
		Result result = JUnitCore.runClasses(RuleTestCase.class, AllTestsSuite.class);
		
		for (Failure fail : result.getFailures()) {
			System.out.println("Failure : " + fail);
		}
		
		System.out.println("Result Successful ? : " + result.wasSuccessful());
	}

}
