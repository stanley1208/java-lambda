package com.study.lambda.java8detail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.math3.analysis.solvers.NewtonRaphsonSolver;

public class ListObject {
	public static void main(String[] args) {
		// 使用 List<Object>
		List<Object> objects = new ArrayList<>();
		objects.add("Hello");
		objects.add(LocalDate.now());
		objects.add(3);
		System.out.println(objects);
		// 在 List<Object> 使用物件
		List<String> strings = new ArrayList<>();
		String s = "abc";
		Object o = s;
		// strings.add(o);
		//	List<Object>moreObjects=strings;
		//	moreObjects.add(new Date());
		//	String s2=moreObjects.get(0);
	}

	// 使用 List<String>

}
