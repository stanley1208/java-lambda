package com.study.lambda;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Product {
	private Integer id;
	private String name;

	public Product(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return "Product [name=" + name + "]";
	}

}
