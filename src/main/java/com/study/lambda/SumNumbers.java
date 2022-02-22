package com.study.lambda;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import javax.print.attribute.IntegerSyntax;

import org.apache.commons.math3.analysis.function.Add;

// 介面內的私用方法
public interface SumNumbers {

	default int addEvens(int... nums) {
		return add(n->n%2==0,nums);
	}
	
	default int addOdds(int... nums) {
		return add(n->n%2!=0,nums);
	}
	
	static int add(IntPredicate predicate,int... nums) {
		return IntStream.of(nums)
				.filter(predicate)
				.sum();
	}
	
}
