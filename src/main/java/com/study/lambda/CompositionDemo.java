package com.study.lambda;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class CompositionDemo {
	
	public static boolean isPerfect(int x) {
		return Math.sqrt(x)%1==0;
	}
	
	public static boolean isTriangular(int x) {
		double val=(Math.sqrt(8*x+1)-1)/2;
		return val%1==0;
	}
	
	public static void main(String[] args) {
		IntPredicate triangular=CompositionDemo::isTriangular;
		IntPredicate perfect=CompositionDemo::isPerfect;
		IntPredicate both=triangular.and(perfect);
		
		IntStream.rangeClosed(1, 10_000)
		.filter(both)
		.forEach(System.out::println);
	}

}
