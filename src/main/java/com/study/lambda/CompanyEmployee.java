package com.study.lambda;

public class CompanyEmployee implements Company,Employee{
	
	private String first;
	private String last;
	
	@Override
	public String getName() {
		return String.format("%s working for %s",
				Employee.super.getName(),Company.super.getName());
	}

	@Override
	public String getFirst() {
		return first;
	}

	@Override
	public String getLast() {
		return last;
	}

	@Override
	public void convertCaffeineToCodeForMoney() {
		System.out.println("Coding...");
	}

}
