package com.study.lambda;

import java.security.PublicKey;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javax.management.ValueExp;
import javax.naming.ldap.ManageReferralControl;

public class Department {
	
	private Manager boss;
	
	public Optional<Manager>getBoss(){
		return Optional.ofNullable(boss);
	}
	
	public void setBoss(Manager boss) {
		this.boss=boss;
	}

	@Override
	public String toString() {
		return "Department [boss=" + boss + "]";
	}
	
	

	

}
