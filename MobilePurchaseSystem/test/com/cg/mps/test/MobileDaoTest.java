package com.cg.mps.test;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mps.bean.Mobile;
import com.cg.mps.dao.MobileDaoImpl;
import com.cg.mps.exception.MobileDBException;

public class MobileDaoTest {
	
	static MobileDaoImpl dao;
	static Mobile mobile;
	
	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		dao = new MobileDaoImpl();
		mobile = new Mobile();
	}
	
	@Test
	public void addMobile(Mobile mobile) throws MobileDBException {

		assertNotNull(dao.addMobile(mobile));

	}
	
		
}
