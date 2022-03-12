package com.study.lambda.java8detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.ode.ContinuousOutputModel;


public class WildCard {
	public static void main(String[] args) {
		// 使用無建萬用字元的 List
		List<?> stuff = new ArrayList<>();
		List<?> ints = new ArrayList<>();
		List<?> strings = new ArrayList<>();
		// stuff.add("abc");
		// stuff.add(new Object());
		// stuff.add(3);
		int numElements = stuff.size();
		// System.out.println(stuff + ":" + numElements);
		// printList(stuff);
		// printList(ints);
		// printList(strings);
		
		// 有上邊界的 List
		List<? extends Number>numbers=new ArrayList<>();
		// numbers.add(3);
		// numbers.add(3.14159);
		// numbers.add(new BigDecimal("3"));
		
		List<Integer>ints2=Arrays.asList(1,2,3,4,5);
		List<Double>doubles=Arrays.asList(1.0,2.0,3.0,4.0,5.0);
		List<BigDecimal>bigDecimals=Arrays.asList(
				new BigDecimal("1.0"),
				new BigDecimal("2.0"),
				new BigDecimal("3.0"),
				new BigDecimal("4.0"),
				new BigDecimal("5.0")
		);
		
		System.out.printf("ints sum is  %s%n",sumList2(ints2));
		System.out.printf("doubles sum is  %s%n",sumList2(doubles));
		System.out.printf("big decimals sum is  %s%n",sumList2(bigDecimals));
	}

	// 作為方法引數的無界 List
	private static void printList(List<?> list) {
		System.out.println(list);
	}
	
	// 使用上邊界
	private static double sumList(List<? extends Number>list) {
		return list.stream()
				.mapToDouble(Number::doubleValue)
				.sum();
				
	}
	
	// 從上邊界參考取值
	private static double sumList2(List<? extends Number>list) {
		Number num=list.get(0);
		return list.stream()
				.mapToDouble(Number::doubleValue)
				.sum();
	}
	
}
