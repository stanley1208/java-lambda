package com.study.lambda;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import javax.management.RuntimeErrorException;


import org.junit.Test;


// 擷取產品
public class CompletableFutureExam {
	private static Map<Integer, Product>cache=new HashMap<>();
	private Logger logger=Logger.getLogger(this.getClass().getName());
	
	private static Product getLocal(int id) {
		return cache.get(id);
	}
	
	private static Product getRemote(int id) {
		try {
			Thread.sleep(100);
			if(id==666) {
				throw new RuntimeException("Evil request");
			}
		} catch (Exception e) {
			
		}
		return new Product(id,"name");
	}
	
	// 完成 CompletableFuture
	public static CompletableFuture<Product>getProduct(int id){
		try {
			Product product=getLocal(id);
			if(product!=null) {
				return CompletableFuture.completedFuture(product);
			}else {
				CompletableFuture<Product>future=new CompletableFuture<>();
				Product p=getRemote(id);
				cache.put(id, p);
				future.complete(p);
				return future;
			}
		} catch (Exception e) {
			CompletableFuture<Product>future=new CompletableFuture<>();
			future.completeExceptionally(e);
			return future;
		}
	}
	
	// 對 CompletableFuture 使用 completeExceptionally
	@Test(expected = ExecutionException.class)
	public void testException() throws Exception {
		CompletableFutureExam.getProduct(666).get();
	}
	
	@Test
	public void TestExceptionWithCause() throws Exception{
		try {
			CompletableFutureExam.getProduct(666).get();
			fail("Houston,we have a problem");
		} catch (ExecutionException e) {
			assertEquals(ExecutionException.class,e.getClass());
			assertEquals(RuntimeException.class, e.getCause().getClass());
		}
	}
	
	// 使用 suppluAsync 取得產品
		public static CompletableFuture<Product>getProductAsync(int id){
			try {
				Product product=getLocal(id);
				if(product!=null) {
					//logger.info("getLocal with id="+id);
					return CompletableFuture.completedFuture(product);
				}else {
					//logger.info("getLocal with id="+id);
					return CompletableFuture.supplyAsync(()->{
						Product p=getRemote(id);
						cache.put(id, product);
						return p;
					});
				}
			} catch (Exception e) {
				//logger.info("getLocal with id="+id);
				CompletableFuture<Product>future=new CompletableFuture<>();
				future.completeExceptionally(e);
				return future;
			}
		}
	
		// 使用 CompletableFuture 協調工作 
		private static String sleepThenReturnString() {
			try { 
				Thread.sleep(100);
			} catch (Exception e) {
				
			}
			return "42";
		}
		
		// 結合兩個 Futures
		@Test
		public void compose() throws Exception {
			int x=2;
			int y=3;
			CompletableFuture<Integer>completableFuture=CompletableFuture
					.supplyAsync(() -> x)
					.thenCompose(n->CompletableFuture.supplyAsync(() -> n+y));
			assertTrue(5==completableFuture.get());
		}
		
		// 使用 Handle 方法
		private CompletableFuture<Integer> getIntegerCompletableFuture(String num){
			return CompletableFuture.supplyAsync(() -> Integer.parseInt(num))
					.handle((val, exc) -> val!=null?val:0);
		}
		
		@Test
		public void handleWithException() throws Exception{
			String num="";
			CompletableFuture<Integer>value=getIntegerCompletableFuture(num);
			assertTrue(value.get()==0);
		}
		
		@Test
		public void handleWithoutException() throws Exception{
			String num="42";
			CompletableFuture<Integer>value=getIntegerCompletableFuture(num);
			assertTrue(value.get()==42);
		}
		
	public static void main(String[] args) {
		
		// 在個別的執行緒池執行 CompletableFuture 工作
		ExecutorService service=Executors.newFixedThreadPool(4);
		
		CompletableFuture.supplyAsync(()->CompletableFutureExam.sleepThenReturnString(),service)
								.thenApply(Integer::parseInt)
								.thenApply(x->2*x)
								.thenAccept(System.out::println)
								.join();
										
		System.out.println("Running...");
		
	}
}


