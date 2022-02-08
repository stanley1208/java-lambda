package com.study.lambda;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl.Mode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

public class ConcurrencyAndParallelism {

	public static void main(String[] args) {
		// 從平行切換成循序
//		List<Integer>numbers=Arrays.asList(3,1,4,1,5,9);
//		List<Integer>nums=numbers.parallelStream()
//				.map(n->n*2)
//				.peek(n->System.out.printf("%s processing %d%n",Thread.currentThread().getName(),n))
//				.sequential()
//				.sorted()
//				.collect(Collectors.toList());
		
//		Instant before=Instant.now();
//		int total=IntStream.of(3,1,4,1,5,9)
//				.map(ConcurrencyAndParallelism::doubleIt)
//				.sum();
		// 使用平行串流
//		int total=IntStream.of(3,1,4,1,5,9)
//				.parallel()
//				.map(ConcurrencyAndParallelism::doubleIt)
//				.sum();
//		
//		Instant after=Instant.now();
//		Duration duration=Duration.between(before, after);
//		System.out.println("Total of doubles = "+total);
//		System.out.println("time = "+duration.toMillis()+"ms");
		
		
		
		
	}

	// 建立循序串流
//	@Test
//	public void sequentialStreamOf() {
//		assertTrue(Stream.of(3, 1, 4, 1, 5, 9).isParallel());
//	}

//	@Test
//	public void sequentialIterateStream() {
//		assertTrue(Stream.iterate(1, n -> n + 1).isParallel());
//	}

//	@Test
//	public void sequentialGenerateStream() {
//		assertTrue(Stream.generate(Math::random).isParallel());
//	}

//	@Test
//	public void sequentialCollectionStream() {
//		List<Integer>numbers=Arrays.asList(3,1,4,1,5,9);
//		assertTrue(numbers.stream().isParallel());
//	}

	// 使用parallelStream方法
//	@Test
//	public void parallelStreamMethodOnCollection() {
//		List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
//		assertTrue(numbers.parallelStream().isParallel());
//	}

	// 使用串流的parallel方法
//	@Test
//	public void parallelMethodOnStream() {
//		assertTrue(Stream.of(3,1,4,1,5,9)
//				.parallel()
//				.isParallel());
//	}

	// 將平行串流轉換成循序
//	@Test
//	public void parallelStreamThenSequential() {
//		List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
//		assertTrue(numbers.parallelStream().sequential().isParallel());
//	}

	// 對循序串流加上整數
	public static int doubleIt(int n) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException ignore) {
			// TODO: handle exception
		}
		return n*2;
	}
			
}
