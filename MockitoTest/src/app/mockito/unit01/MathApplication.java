package app.mockito.unit01;

public class MathApplication {
	private CalculatorService calcService;
	
	private CalculatorService calcServiceSpy;

	public void setCalculatorService(CalculatorService calcService){
		this.calcService = calcService;
	}
	
	public double add(double input1, double input2){		
		return calcService.add(input1, input2);
	}
	
	public double subtract(double input1, double input2){
		return calcService.subtract(input1, input2);
	}

	public double multiply(double input1, double input2){
		return calcService.multiply(input1, input2);
	}

	public double divide(double input1, double input2){
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return calcService.divide(input1, input2);
	}
	
	public double add2(double input1, double input2){
		double x = 0;
		for (int i = 0; i < 5; i++) {
			x += calcService.add(input1, input2);
		}
		for (int i = 0; i < 10; i++) {
			x += calcService.add(input1+20, input2+30);
		}

		return x;
	}
	
	public double addSpy(double input1, double input2){
		return calcServiceSpy.add(input1, input2);
	}

	public CalculatorService getCalcServiceSpy() {
		return calcServiceSpy;
	}

	public void setCalcServiceSpy(CalculatorService calcServiceSpy) {
		this.calcServiceSpy = calcServiceSpy;
	}
}