package com.study.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.w3c.dom.ls.LSOutput;

public class FunctionPractice {
	public static void main(String[] args) {
		Function<Integer, Integer>add2=x->x+2;
		Function<Integer, Integer>mult3=x->x*3;
		
		Function<Integer, Integer>mult3add2=add2.compose(mult3);
		Function<Integer, Integer>add2mult3=add2.andThen(mult3);
		
		System.out.println("mult3add2(1):"+mult3add2.apply(1));
		System.out.println("add2mult3(2):"+add2mult3.apply(1));

		Function<Integer, Integer>add2_2=x->x+2;
		Function<String,Integer>parseThenAdd2=add2_2
				.compose(Integer::parseInt);
		System.out.println(parseThenAdd2.apply("1"));
				
		
		Function<Integer, Integer>add2_3=x->x+2;
		Function<Integer,String>plus2ToString=add2_3
				.andThen(Object::toString);
		System.out.println(plus2ToString.apply(1));
		
		Logger log=Logger.getLogger("a");
		Consumer<String> printer=System.out::println;
		Consumer<String>logger=log::info;
		
		Consumer<String>printThenLog=printer.andThen(logger);
		Stream.of("this","is","a","stream","of","strings").forEach(printThenLog);
		
		
	}
}
