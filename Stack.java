package net.hb.day0704;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Stack {
	private String[] OPERATOR = {"+","-","*","/"};
	private String[] num = {};
	private String[] oper = {};
	private List<String> nums = new ArrayList<>(Arrays.asList(num));
	private List<String> opers = new ArrayList<>(Arrays.asList(oper));

	public String getInput() {
		String input;
		Scanner sc =  new Scanner(System.in);
		System.out.println("숫자(공백)기호(공백) 형식으로 입력해주세요");
		input = sc.nextLine();
		return input;
	}
	
	public void inputTokenizer(StringTokenizer tokens) {
		
		while(tokens.hasMoreTokens()) {
			String token = tokens.nextToken();
			if (Arrays.asList(OPERATOR).contains(token)) {
				opers.add(token);
			}else {
				nums.add(token);
			}
		}
	}
	
	public String strCheck(String str) {
		for (int i = 0;i<str.length();i++) {
			char a = str.charAt(i);
			if ( Character.isDigit(a)|| a == 32 || a == '+' || a == '-' || a == '*' || a == '/') {
				continue;
			}else {
				str = "retry";
				break;
			}
		}
		return str;
	}
	
	public static void main(String[] args) {
		Stack ss = new Stack();
		boolean flag = true;
		while (flag) {
			
			String input = ss.strCheck(ss.getInput());
			if (input.equals("retry")) {
				continue;
			}else {
				StringTokenizer tokens = new StringTokenizer(input);
				ss.opers.removeAll(ss.opers);
				ss.nums.removeAll(ss.nums);
				ss.inputTokenizer(tokens);
				Calculator cc = new Calculator(ss.nums,ss.opers);
				
			}
		}
		
	}
	
}
