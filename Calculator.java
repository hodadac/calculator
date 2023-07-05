package net.hb.day0704;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Calculator {
	
	private double total = 0.0;
	
	public Calculator(List<String> nums, List<String> opers) {
		divTomulti(nums,opers);
	}
	
	public void divTomulti (List<String> nums, List<String> opers) {
		int index_div = opers.indexOf("/");
		
		while (index_div != -1) {
			double num1 = Double.valueOf(nums.get(index_div+1));
			double num2 = 1/num1;
			String result = String.valueOf(num2);
			opers.remove(index_div);opers.add(index_div,"*");
			nums.remove(index_div+1);nums.add(index_div+1,result);
			index_div = opers.indexOf("/");
		}
		multiCal(nums,opers);
	}
	
	public void multiCal (List<String> nums, List<String> opers) {
		int index_multi = opers.indexOf("*");
		
		while (index_multi !=-1) {
			
			double num1 = Double.valueOf(nums.get(index_multi));
			double num2 = Double.valueOf(nums.get(index_multi+1));
			String result = String.valueOf(num1*num2);
			nums.remove(index_multi);
			nums.remove(index_multi);
			opers.remove(index_multi);
			nums.add(index_multi,result);
			
			index_multi = opers.indexOf("*");
		}
		minuToplus(nums,opers);
	}
	
	public void minuToplus (List<String> nums, List<String> opers) {
		int index_minus = opers.indexOf("-");
		
		while (index_minus!=-1) {
			
			double num = -Double.valueOf(nums.get(index_minus+1));
			String result = String.valueOf(num);
			opers.remove(index_minus);opers.add(index_minus,"+");
			nums.remove(index_minus+1);nums.add(index_minus+1,result);
			
			index_minus = opers.indexOf("-");
		}
		allPlus(nums);
	}
	
	public void allPlus (List<String> nums) {

		for (String i:nums) {
			double num = Double.valueOf(i);
			total += num;
		}
		System.out.println(total);

	}
	
	
	
}
