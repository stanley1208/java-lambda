package com.study.lambda;

import java.security.PublicKey;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javax.management.ValueExp;

public class OptionalPractice {
	public static void main(String[] args) {
		AtomicInteger counter = new AtomicInteger();
		Optional<AtomicInteger> opt = Optional.ofNullable(counter);
		System.out.println(opt); // Optional[0]
		counter.incrementAndGet();
		System.out.println(opt); // Optional[1]
		opt.get().incrementAndGet();
		System.out.println(opt); // Optional[2]
		opt = Optional.ofNullable(new AtomicInteger());

		Optional<String> firstEven = Stream.of("five", "even", "length", "string", "values")
				.filter(s -> s.length() % 2 == 0).findFirst();

		System.out.println(firstEven.isPresent() ? firstEven.get() : "No such length strings"); // make sure Optional
																								// has a value
		System.out.println(firstEven.orElse("No such length strings"));

		Optional<String> firstOdd = Stream.of("five", "even", "length", "string", "values")
				.filter(s -> s.length() % 2 != 0).findFirst();

		System.out.println(firstOdd.isPresent() ? firstOdd.get() : "No such length strings"); // throws
																								// NoSuchElementException
		System.out.println(firstOdd.orElse("No such length strings"));

		Optional<String> first = Stream.of("five", "even", "length", "string", "values")
				.filter(s -> s.length() % 2 == 0).findFirst();

		//System.out.println(first.orElseThrow(NoSuchElementException::new));

		first.ifPresent(val -> System.out.println("Found an even-length string"));// execute only when Optional has an
																					// element
		first = Stream.of("five", "even", "length", "string", "values").filter(s -> s.length() % 2 != 0).findFirst();

		first.ifPresent(val -> System.out.println("Found an even-length string"));// execute only when Optional has an
																					// element
	}

	public static <T> Optional<T> createOptionalTheHardWay(T value) {
		return value == null ? Optional.empty() : Optional.of(value);
	}

	public static <T> Optional<T> createOptionalTheEasyWay(T value) {
		return Optional.ofNullable(value);
	}

}
