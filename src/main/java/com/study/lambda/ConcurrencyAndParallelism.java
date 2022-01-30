package com.study.lambda;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class ConcurrencyAndParallelism {

	public static void main(String[] args) {
		// 從平行切換成循序
		List<Integer>numbers=Arrays.asList(3,1,4,1,5,9);
		List<Integer>nums=numbers.parallelStream()
				.map(n->n*2)
				.peek(n->System.out.printf("%s processing %d%n",Thread.currentThread().getName(),n))
				.sequential()
				.sorted()
				.collect(Collectors.toList());
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

	
			
}
