package com.study.lambda;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class OptionalPractice {
	public static void main(String[] args) {
		AtomicInteger counter=new AtomicInteger();
		Optional<AtomicInteger>opt=Optional.ofNullable(counter);
		
		System.out.println(opt); // Optional[0]
		
		counter.incrementAndGet();
		
		System.out.println(opt); // Optional[1]
	}
}
