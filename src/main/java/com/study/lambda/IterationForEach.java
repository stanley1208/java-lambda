package com.study.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		
		System.out.println();
		
		Map<Long, String>map=new HashMap<>();
		map.put(86L, "Don Adams");
		map.put(99L, "Barbara Feldon");
		map.put(13L, "David Feldon");
		map.forEach((num,agent)->System.out.printf("Agent %d, played by %s%n",num,agent));
	}
	
	
}
