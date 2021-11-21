package com.study.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class unCheckedException {
	public static void main(String[] args) {
		List<Integer>values=Arrays.asList(30,10,40,10,50,90);
//		List<Integer>scaled=unCheckedException.div(values,10);
//		System.out.println(scaled);
//		
//		scaled=unCheckedException.div(values, 0);
//		System.out.println(scaled);
		
		System.out.println(divUsingMethod(values,10));
	
	}
	public static List<Integer>div(List<Integer>values,Integer factor){
		return values.stream()
				.map(n->{
					try {
						return n/factor;
					} catch (ArithmeticException e) {
						e.printStackTrace();
					}
					return n/factor;
					
				})
				.collect(Collectors.toList());
				
	}
	
	private static Integer divide(Integer value,Integer factor) {
		try {
			return value/factor;
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		return value/factor;
	}
	
	public static List<Integer>divUsingMethod(List<Integer>values,Integer factor){
		return values.stream()
				.map(n->divide(n, factor))
				.collect(Collectors.toList());
	}
}
