package com.study.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;



public class IterationForEach {
	public static void main(String[] args) {
		List<Integer>integers=Arrays.asList(3,1,4,1,5,9);
		
		
		integers.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer integer) {
			System.out.print(integer);
		}
		});
		
		System.out.println();
		
		integers.forEach((Integer n)->{
			System.out.print(n);
		});
		
		System.out.println();
		
		integers.forEach(n->System.out.print(n));
		
		System.out.println();
		
		integers.forEach(System.out::print);
	}
	
	
}
