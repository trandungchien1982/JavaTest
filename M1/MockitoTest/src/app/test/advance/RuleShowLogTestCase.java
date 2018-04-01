package app.test.advance;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Tạo @Rule để điều khiển flow cho test case thay cho thứ tự cổ điển :
 * 		setUp() -> test() -> tearDown()
 * @author tdc
 *
 */
public class RuleShowLogTestCase {

	public void before() {
		System.out.println("\nbefore ...");
	}
	public void after() {
		System.out.println("after ...");
	}
	
	@Before
	public void st() {
		System.out.println("Before FUNC ...");
	}
	@After
	public void tr() {
		System.out.println("After FUNC ...");
	}

	@Rule
	public ShowLogRule rule = new ShowLogRule();	
	
	@Test
	@ShowLogTC
	public void test1() {
		System.out.println("test1");		
	}
		
	@Test
	@ShowLogTC(start=true, end=false)
	public void test2() {
		System.out.println("test2");
	}
	
	@Test
	public void test3() {
		System.out.println("test3");
	}	
	
	/**
	 * Tạo rule mới
	 * @author tdc
	 *
	 */
	class ShowLogRule implements TestRule {
		@Override
		public Statement apply(Statement statement, Description description) {
			// TODO Auto-generated method stub
			return new Statement() {
							
				@Override
				public void evaluate() throws Throwable {					
					
					ShowLogTC showLog = description.getAnnotation(ShowLogTC.class);
					if (showLog != null && showLog.start()) {
						System.out.println("Start test name : " + description.getMethodName());
					}
					
					before();
					
					try {
												
						// Tương đương với hàm setup() -> testXXX() -> tearDown()
						statement.evaluate();
						
						
						System.out.println("description ... " + description);
						if (description != null) {
							System.out.println("Method name : " + description.getMethodName());
							System.out.println("Class name : " + description.getClassName());
							System.out.println("Display name : " + description.getDisplayName());
							System.out.println("Annotations : " + description.getAnnotations());							
						}
						
					} catch (Exception e) {
						throw e;
					} finally {
						after();
						
						if (showLog != null && showLog.end()) {
							System.out.println("End test name : " + description.getMethodName());
						}
					}
				}
			};
		}
	}

}

/**
 * Tạo Annotation ShowLog
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface ShowLogTC {	
	public abstract boolean start() default true;
	public abstract boolean end() default true;
}

