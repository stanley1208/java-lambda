package com.study.lambda.java8stream;

public class EmployeePOJO {
	public static final EmployeePOJO DEFAULT_EMPLOYEE=new EmployeePOJO(4,"Klay Thompson");
	private int id;
	private String name;
	public EmployeePOJO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "EmployeePOJO [id=" + id + ", name=" + name + "]";
	}
	
	
}
