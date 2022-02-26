package com.study.lambda.java8detail;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ListExam {

	public static void main(String[] args) {
		// 簡單示範泛行
		List<String>strings=new ArrayList<>();
		strings.add("Hello");
		strings.add("World");
		for(String s:strings) {
			System.out.printf("%s has length %d%n",s,s.length());
		}
		
		// 再泛行集合中使用基本型態
		List<Integer>ints=new ArrayList<>();
		ints.add(3);
		ints.add(1);
		ints.add(4);
		ints.add(1);
		ints.add(5);
		ints.add(9);
		System.out.println(ints);
		for(int i:ints) {
			System.out.println(i);
		}
	}

}
