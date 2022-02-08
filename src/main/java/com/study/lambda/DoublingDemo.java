package com.study.lambda;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(value = 2,jvmArgs = {"-Xms4G","-Xmx4G"})
public class DoublingDemo {

	public static long N=Long.MAX_VALUE;
	public int doubleIt(int n) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		return n*2;
	}
	
	@Benchmark
	public int doubleAndSumSequential() {
		return IntStream.of(3,1,4,1,5,9)
				.map(this::doubleIt)
				.sum();
	}
	
	@Benchmark
	public int doubleAndSumParallel() {
		return IntStream.of(3,1,4,1,5,9)
				.parallel()
				.map(this::doubleIt)
				.sum();
	}
	
	// 在迴圈中迭代家總數字
	public long iterativeSum() {
		long result=0;
		
		for(long i=1L;i<=N;i++) {
			result+=i;
		}
		return result;
	}
	
	// 總和泛型串流
	public long sequentialStreamSum() {
		return Stream.iterate(1L, i->i+1)
				.limit(N)
				.reduce(0L, Long::sum);
				
				
	}
	
	public long parallelStreamSum() {
		return Stream.iterate(1L, i->i+1)
				.limit(N)
				.parallel()
				.reduce(0L, Long::sum);
				
				
	}
	
	// 使用LongStream
	public long sequentialLongStreamSum() {
		return LongStream.rangeClosed(1, N)
				.sum();
	}
	
	public long parallelLongStreamSum() {
		return LongStream.rangeClosed(1, N)
				.parallel()
				.sum();
	}
	
	public static void main(String[] args) throws Exception {
		Options opt = new OptionsBuilder()
	            .include(DoublingDemo.class.getSimpleName())
	            .build();
	        new Runner(opt).run();

	}

}
