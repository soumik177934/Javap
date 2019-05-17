package com.cg.mps.test;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mps.dao.MobileDaoImpl;
import com.cg.mps.exception.MobileDBException;
import com.cg.mps.util.DBUtil;

public class DBUtilTest {
	static MobileDaoImpl daotest;
	static Connection dbCon;
	
	@BeforeClass
	public static void initialise(){
		daotest=new MobileDaoImpl();
		dbCon=null;
	}
	
	@Before
	public void beforeEachTest() {
		System.out.println("----Starting DBUtil Test Case----\n");
	}
	
	@Test
	public void test() throws MobileDBException {
		Connection dbCon = DBUtil.getConnection();
		Assert.assertNotNull(dbCon);
	}
	
	@After
	public void afterEachTest() {
		System.out.println("----End of DBConnection Test Case----\n");
	}

	@AfterClass
	public static void destroy() {
		System.out.println("\t----End of Tests----");
		daotest = null;
		dbCon = null;
	}

}
