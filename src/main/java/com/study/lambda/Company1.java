package com.study.lambda;

import java.security.PublicKey;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javax.management.ValueExp;
import javax.naming.ldap.ManageReferralControl;

public class Company1 {
	
	private Department department;
	
	public Optional<Department>getDepartment(){
		return Optional.ofNullable(department);
	}
	
	public void setDepartment(Department department) {
		this.department=department;
	}
	
	
	
	@Override
	public String toString() {
		return "Company1 [department=" + department + "]";
	}

	public static void main(String[] args) {
		Company1 co=new Company1();
		Manager mrSlate=new Manager("Mr. Slate");
		
		Department d=new Department();
		d.setBoss(mrSlate);
		
		co.setDepartment(d);
		
		//two Optional
		System.out.println("Company Dept: "+co.getDepartment());
		System.out.println("Company Dept Manager: "+co.getDepartment().map(Department::getBoss));
		
		//using flatMap
		System.out.println(co.getDepartment().flatMap(Department::getBoss).map(Manager::getName));
		
		Optional<Company1>company=Optional.of(co);
		System.out.println(company.flatMap(Company1::getDepartment)
								  .flatMap(Department::getBoss)
								  .map(Manager::getName));
		
		
	}

	

}
