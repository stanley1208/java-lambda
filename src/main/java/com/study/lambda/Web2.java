package com.study.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore.Entry.Attribute;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Web2 {
	public static void main(String[] args) {
//		try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\user\\Downloads"))) {
//			lines.filter(s -> s.length() > 20).sorted(Comparator.comparingInt(String::length).reversed()).limit(10)
//					.forEach(w -> System.out.printf("%s (%d)%n", w, w.length()));
//
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//		try (Stream<String>lines=Files.lines(Paths.get("C:\\Users\\user\\Downloads"))){
//			lines.filter(s->s.length()>20)
//			.collect(Collectors.groupingBy(String::length,Collectors.counting()))
//			.forEach((len,num)->System.out.println(len+":"+num));
//				
//			
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//		try (Stream<String>lines=Files.lines(Paths.get("C:\\Users\\user\\Downloads"))){
//			Map<Integer, Long>map=lines.filter(s->s.length()>20)
//					.collect(Collectors.groupingBy(String::length,Collectors.counting()));
//			
//			map.entrySet().stream()
//				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
//				.forEach(e->System.out.printf("Length %d: %d words%n",e.getKey(),e.getValue()));
//				
//		
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//		try (Stream<String>lines=new BufferedReader(new FileReader("C:\\Users\\user\\Downloads")).lines()){
//			Map<Integer, Long>map=lines.filter(s->s.length()>20)
//					.collect(Collectors.groupingBy(String::length,Collectors.counting()));
//			
//			map.entrySet().stream()
//				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
//				.forEach(e->System.out.printf("Length %d: %d words%n",e.getKey(),e.getValue()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		// ??? Stream ?????????????????????
//		try (Stream<Path> list = Files.list(Paths.get("C:\\Users\\user\\Downloads"))) {
//			list.forEach(System.out::println);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		// ?????????????????? (????????????)
//		try (Stream<Path> list = Files.walk(Paths.get("C:\\Users\\user\\Downloads"))) {
//			list.forEach(System.out::println);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try (Stream<Path> paths = Files.find(Paths.get("C:\\Users\\user\\Downloads"), Integer.MAX_VALUE,
				(path, attribute) -> !attribute.isDirectory() && path.toString().contains("hello"))) {
			paths.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
