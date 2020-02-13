package com.tyss.junittyss;

public class BMICalculator {
	
	public double bmiCalculator(double weight,double height) {
		
		return weight / (height * height);
	}
	
	
	public String getBmiResult(double res) {
		
		if(res < 18.5) {
			
			return "Under Weight";
			
		}else if(res >= 18.5 && res<25) {
			
			return "Normal";
			
		}else if(res >= 25 && res <35) {
			
			return "Over weight";
			
		}
		else {
			return "Obesity";
		}
		
	}
	
	
}
