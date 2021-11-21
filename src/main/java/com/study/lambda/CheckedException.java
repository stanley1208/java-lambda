package com.study.lambda;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckedException {

	public static void main(String[] args) {
		

	}
	public static List<String>encodeValuesAnonInner(String... values){
		return Arrays.stream(values)
				.map(new Function<String,String>() {
					@Override
					public String apply(String s) {
						try {
							return URLEncoder.encode(s, "UTF-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
							return "";						}
					}
				})
				.collect(Collectors.toList());
				

	}
	
	public static List<String> encodeValues(String... values){
		return Arrays.stream(values)
				.map(s->{
					try {
						return URLEncoder.encode(s,"UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
						return "";
					}
				})
				.collect(Collectors.toList());
	}
	
	private String encodeString(String s) {
		try {
			return URLEncoder.encode(s,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException();
		}
	}
	
	public List<String>encodeValuesUsingMethod(String... values){
		return Arrays.stream(values)
				.map(this::encodeString)
				.collect(Collectors.toList());
	}
}
