package com.study.lambda.java8detail;

import java.util.ArrayList;
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
		System.out.println(stuff + ":" + numElements);
		printList(stuff);
		printList(ints);
		printList(strings);
	}

	// 作為方法引數的無界 List
	private static void printList(List<?> list) {
		System.out.println(list);
	}
}
