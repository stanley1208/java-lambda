package com.study.lambda;

public class Manager {
	
	private String name; //can't be null

	public Manager(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Manager [name=" + name + "]";
	}
	
	
}
