package com.study.lambda;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Wrapper {
	private <T,R,E extends Exception> //可接收任何一個Exception程式
		Function<T,R>wrapper(FunctionWithException<T, R, E>fe){
		return arg->{
			try {
				return fe.apply(arg);
			} catch (Exception e) {
				throw new RuntimeException(e);//會以unchecked重新丟出
			}
		};
}
	
	public List<String> encodeValuesWithWrapper(String... values){
		return Arrays.stream(values)
				.map(wrapper(s->URLEncoder.encode(s, "UTF-8")))
				.collect(Collectors.toList());
	}
}
