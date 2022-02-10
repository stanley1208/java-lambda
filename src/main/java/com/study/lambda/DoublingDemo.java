package com.study.lambda;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.*;
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
	
	// 從 Future 取值
	public static void getIfNotCancelled(Future<String>future) {
		try {
			if(!future.isCancelled()) {
				System.out.println(future.get());
			}else {
				System.out.println("Cancelled");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) throws Exception {
//		Options opt = new OptionsBuilder()
//	            .include(DoublingDemo.class.getSimpleName())
//	            .build();
//	        new Runner(opt).run();

	     // 以程式指定公共池的大小   
//	     System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
//	     long total=LongStream.rangeClosed(1, 3_000_000)
//	    		 .parallel()
//	    		 .sum();
//	     int poolSize=ForkJoinPool.commonPool().getPoolSize();
	     //System.out.println("Pool size: "+poolSize);
	     
	     // 建立自己的 ForkJoinPool
//	     ForkJoinPool pool=new ForkJoinPool(15);
//	     ForkJoinTask<Long>task=pool.submit(
//	    		 ()->LongStream.rangeClosed(1,3_000_000)
//	    		 .parallel()
//	    		 .sum());
//	     
//	     try {
//			task.get();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			pool.shutdown();
//		}
//	     poolSize=pool.getPoolSize();
//	     System.out.println("Pool size: "+poolSize);
		
		// 送出一個 Callable 並回傳 Future
		ExecutorService service=Executors.newCachedThreadPool();
//		Future<String>future=service.submit(new Callable<String>() {
//
//			@Override
//			public String call() throws Exception {
//				Thread.sleep(100);
//				return "Hello, World!";
//			}
//			
//		});
		
//		System.out.println("Processing...");
//		getIfNotCancelled(future);
		
		Future<String>future=service.submit(()->{
			Thread.sleep(100);
			return "Hello, World!";
		});
		
		// 取消 Future
		future.cancel(true);
		
		System.out.println("Even More Processing...");
		
//		while(!future.isDone()){
//			System.out.println("Waiting...");
//		}
		
		getIfNotCancelled(future);
	}

}
