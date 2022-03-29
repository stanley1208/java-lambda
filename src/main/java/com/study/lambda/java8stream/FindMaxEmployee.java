package com.study.lambda.java8stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TooManyListenersException;
import java.util.stream.Collectors; 
import java.util.stream.Stream; 

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class FindMaxEmployee {

	public static void main(String[] args)throws Exception {
		// 找出最大的 Employee (舊的方法)
		List<EmployeePOJO>employees=Arrays.asList(
				new EmployeePOJO(1,"Seth Curry"),
				new EmployeePOJO(2,"Kevin Durant"),
				new EmployeePOJO(3,"Draymond Green"),
				new EmployeePOJO(4,"Klay Thompson")
				);
		
		EmployeePOJO maxId=employees.stream()
				.max(new Comparator<EmployeePOJO>() {
					@Override
					public int compare(EmployeePOJO e1,EmployeePOJO e2) {
						return e1.getId()-e2.getId();
					}
				}).orElse(EmployeePOJO.DEFAULT_EMPLOYEE);
		
		EmployeePOJO maxName=employees.stream()
				.max(new Comparator<Object>() {
					@Override
					public int compare(Object o1,Object o2) {
						return o1.toString().compareTo(o2.toString());
					}
				}).orElse(EmployeePOJO.DEFAULT_EMPLOYEE);	
		
		System.out.println(maxId);
		System.out.println(maxName);
		
		// 找出最大的 Employee (新的方法)
		EmployeePOJO maxId2=employees.stream()
				.max(comparingInt(EmployeePOJO::getId))
				.orElse(EmployeePOJO.DEFAULT_EMPLOYEE);
		
		EmployeePOJO maxName2=employees.stream()
				.max(comparing(Object::toString))
				.orElse(EmployeePOJO.DEFAULT_EMPLOYEE);
		
		System.out.println(maxId2);
		System.out.println(maxName2);
		
		// 將 List<EmployeePOJO> 對應至 List<String>
		List<String>names=employees.stream()
				.map(EmployeePOJO::getName)
				.collect(Collectors.toList());
		
		List<String>strings=employees.stream()
				.map(Object::toString)
				.collect(Collectors.toList());
	}

}
