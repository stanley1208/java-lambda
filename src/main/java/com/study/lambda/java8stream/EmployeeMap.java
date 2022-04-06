package com.study.lambda.java8stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeMap {
	public static void main(String[] args) {
		List<EmployeePOJO>employees=Arrays.asList(
			new EmployeePOJO(1,"Seth Curry"),
			new EmployeePOJO(2,"Kevin Durant"),
			new EmployeePOJO(3,"Draymond Green"),
			new EmployeePOJO(4,"Klay Thompson")
			);
	
		// 以 id 為鍵將員工加入 map
		Map<Integer, EmployeePOJO>employeeMap=employees.stream()
				.collect(Collectors.toMap(EmployeePOJO::getId, Function.identity()));
		
		
		
		// 用鍵來排序 Map 元素並印出
		// Comparator.reverseOrder() -> 由高到低 
		
		System.out.println("Sorted by key:");
		employeeMap.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByKey())
					.forEach(entry->{
						System.out.println(entry.getKey()+":"+entry.getValue());
					});
		
		
		// 用值來排序 Map 元素並印出
		System.out.println("Sorted by name:");
		employeeMap.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue(Comparator.comparing(EmployeePOJO::getName)))
		.forEach(entry->{
			System.out.println(entry.getKey()+":"+entry.getValue());
		});
		
	}
	
	
	
	
}
