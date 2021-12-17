package com.study.lambda;

import java.security.PublicKey;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javax.management.ValueExp;

public class OptionalPractice2 {
	public static void main(String[] args) {
		Manager mrSlate=new Manager("Mr. Slate");
		
		Department d=new Department();
		d.setBoss(mrSlate);
		System.out.println("Boss: " + d.getBoss());
		
		Department d1=new Department();
		System.out.println("Boss: " + d1.getBoss());
		
		System.out.println("Name: "+d.getBoss().orElse(new Manager("Unknown")).getName());
		System.out.println("Name: "+d1.getBoss().orElse(new Manager("Unknown")).getName());
		
		System.out.println("Name: "+d.getBoss().map(Manager::getName));
		System.out.println("Name: "+d1.getBoss().map(Manager::getName));
	}



}
