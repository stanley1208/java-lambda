package com.study.lambda;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

import javax.swing.DefaultBoundedRangeModel;

public class RandomParam {

	public static void main(String[] args) {
		Random r=new Random();
		r.ints(5)
		.sorted()
		.forEach(System.out::print);//五個整數亂數
		System.out.println();
		
		r.doubles(5,0,0.5)
		.sorted()
		.forEach(System.out::print);//>=0 <0.5 間的五個double亂數
		System.out.println();
		
		List<Long>longs=r.longs(5)
				.boxed()
				.collect(Collectors.toList());//將long轉換成Long，讓他們可被收集
		System.out.println(longs);
		
		List<Integer>listOfInts=r.ints(5,10,20)
				.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
		System.out.println(listOfInts);//除了呼叫boxed之外的另一種collect形式
		
		
		String myString="Hello everyone ! My name is stanley stanley stanley.";
		System.out.println(fullWordCounts(myString));
		
	}
	
	long fib1(long i) {
		if(i==0) return 0;
		if(i==1) return 1;
		return fib1(i-1)+fib1(i-2);
	}
	
	private Map<Long, BigInteger>cache=new HashMap<Long, BigInteger>();
	
	public BigInteger fib2(long i) {
		if (i==0) return BigInteger.ZERO;
		if (i==1) return BigInteger.ONE;
		return cache.computeIfAbsent(i, n->fib2(n-2).add(fib2(n-1)));//如果值存在，cache會回傳值，否則會計算並儲存它
	}
	
	public static Map<String, Integer>fullWordCounts(String passage){
		Map<String,Integer>wordCounds=new HashMap<>();
		String testString = passage.toLowerCase().replaceAll("\\W", " ");
		
		Arrays.stream(testString.split("\\s+")).forEach(word->wordCounds.merge(word, 1, Integer::sum));
		
		return wordCounds;
	}
}
