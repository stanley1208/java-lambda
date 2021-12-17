package com.study.lambda;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee1 {
	public Optional<Employee1>findEmployeeById(int id){
		return null;
		
	}
	
	public List<Employee1> findEmployeeByIds1(List<Integer> ids){
		return ids.stream()
				.map(this::findEmployeeById) // Stream<Optional<Employee1>>
				.filter(Optional::isPresent) // delete empty Optional 
				.map(Optional::get) // get exist Optional<Employee1>
				.collect(Collectors.toList());
	}
	
	public List<Employee1> findEmployeeByIds2(List<Integer> ids){
		return ids.stream()
				.map(this::findEmployeeById) // Stream<Optional<Employee1>>
				.flatMap(optional->optional.map(Stream::of) // Stream<Optional<Employee1>> -> Optional<Stream<Employee1>>
						.orElseGet(Stream::empty)) // get Stream<Employee1>
				.collect(Collectors.toList());
	}
}
