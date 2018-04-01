package app.test.advance;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Tạo @Rule để điều khiển flow cho test case thay cho thứ tự cổ điển :
 * 		setUp() -> test() -> tearDown()
 * Kết hợp với 1 annotation đánh dấu repeat để lặp lại test case 1000 lần
 * 
 * @author tdc
 *
 */
public class RepeatTestCase {

	public void before() {
		System.out.println("\nBefore ...");
	}	
	public void after() {
		System.out.println("After ...");
	}
	
		
	@Rule
	public MyRule rule = new MyRule();
	
	@Test	
	public void test1() {
		System.out.println("test1");
	}
	
	@Test
	@Repeat(times=1000)
	public void test2() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	class MyRule implements TestRule {
					
		@Override
		public Statement apply(Statement statement, Description description) {
			// TODO Auto-generated method stub
			return new Statement() {			
				@Override
				public void evaluate() throws Throwable {
					// TODO Auto-generated method stub

					before();
					
					try {
						// Tương đương với hàm testXXX()
						statement.evaluate();
						
						// Get the @Repeat Annotation
						Repeat repeat = description.getAnnotation(Repeat.class);
						System.out.println("repeat = " + repeat);
						
						if( repeat != null ) {
							int times = repeat.times();
							if (times > 1) {
								// Repeat loop
								times = times - 1;
								
								for (int i = 1; i <= times; i++) {
									System.out.println("Repeat loop pos = " + i);
									statement.evaluate();
								}
							}
							
						}
						
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
					}
				}
			};
		}
	}
	
}

/**
 * Tạo Annotation Repeat với times = 1000
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface Repeat {	
	public abstract int times();
}


