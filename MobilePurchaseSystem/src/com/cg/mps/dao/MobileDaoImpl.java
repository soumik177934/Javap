package com.cg.mps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseDetails;
import com.cg.mps.exception.MobileDBException;
import com.cg.mps.util.DBUtil;

public class MobileDaoImpl implements MobileDao {
	
	Logger logger=Logger.getRootLogger();
	Connection conn = null;

	public MobileDaoImpl() {
		
			PropertyConfigurator.configure("Resource//log4j.properties");
			
			
	}

	@Override
	public String addMobile(Mobile mobile) throws MobileDBException {
		mobile.setMobileId(generateMobileId());
		conn = DBUtil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(QueryMapper.INSERT_MOBILE);
			pst.setString(1, mobile.getMobileId());
			pst.setString(2, mobile.getMobileName());
			pst.setString(3, mobile.getMobilePrice());
			pst.setString(4, mobile.getQuantity());
			pst.executeUpdate();
		} catch (SQLException e) {
			logger.error("Problem in inserting product details");
			throw new MobileDBException("Problem in inserting product details"+e.getMessage());
		}
		logger.info("Mobile ID generated successfully");
		return mobile.getMobileId();
	}
	
	
	
	private String generateMobileId() throws MobileDBException{
		String mid = null;

		conn = DBUtil.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rst  = stmt.executeQuery(QueryMapper.MOBILEID_SEQUENCE);
			while(rst.next()){
				mid = rst.getString(1);
			}
			
		} catch (SQLException e) {
			logger.error("Problem in generating mobile id");
			throw new MobileDBException("Problem in generating mobile id");
		}
		logger.info("Mobile ID generated successfully");
		return mid;
	}

	@Override
	public List<Mobile> getAllMobiles() throws MobileDBException {
		List<Mobile> mobileList = new ArrayList<Mobile>();
		conn = DBUtil.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rst = stmt.executeQuery(QueryMapper.RETRIVE_ALL_MOBILES_QUERY);
			while (rst.next()) {
				Mobile mob = new Mobile();
				mob.setMobileId(rst.getString("mobileid"));
				mob.setMobileName(rst.getString("name"));
				mob.setMobilePrice(rst.getString("price"));
				mob.setQuantity(rst.getString("quantity"));
				mobileList.add(mob);
			}
		} catch (SQLException e) {
			logger.error("Mobile table failed to fetch");
			throw new MobileDBException("Mobile table failed to fetch"+e.getMessage());
		}
		logger.info("fetching of Mobile list done");
		return mobileList;
	}

	@Override
	public String purchaseDetails(PurchaseDetails purchaseDetails)
			throws MobileDBException {
		purchaseDetails.setPurchaseId(generatePurchaseId());
		conn = DBUtil.getConnection();
		try {
			PreparedStatement purchasePst = conn.prepareStatement(QueryMapper.INSERT_PURCHASE);
			purchasePst.setString(1, purchaseDetails.getPurchaseId());
			purchasePst.setString(2, purchaseDetails.getcName());
			purchasePst.setString(3, purchaseDetails.getCmail());
			purchasePst.setString(4, purchaseDetails.getcNumber());
			purchasePst.setString(5, purchaseDetails.getMobileId());
			try {
				
				purchasePst.executeQuery();
			} catch (Exception e) {
				// TODO Auto-generated catch block0
				e.printStackTrace();
			}
			
			PreparedStatement mobilePst = conn.prepareStatement(QueryMapper.MOBILE_UPDATE);
			mobilePst.setString(1, purchaseDetails.getMobileId());
			mobilePst.executeQuery();
		} catch (SQLException e) {
			throw new MobileDBException("Order not placed "+e.getMessage());
		}
		return purchaseDetails.getPurchaseId();
	}
	private String generatePurchaseId() throws MobileDBException{
		String pid = null;
		conn = DBUtil.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rst  = stmt.executeQuery(QueryMapper.PURCHASEID_SEQUENCE);
			rst.next();
			pid = rst.getString(1);
			
		} catch (SQLException e) {
			throw new MobileDBException("Purchaseid not completed" + e.getMessage());
		}
		return pid;
	}

	@Override
	public String deleteMobile(String mobileId) throws MobileDBException {
		conn = DBUtil.getConnection();
		try{
			PreparedStatement pst = conn.prepareStatement(QueryMapper.DELETE_MOBILE);
			pst.setString(1,mobileId);
			pst.executeUpdate();
		}catch(SQLException e){
			System.out.println("Record not deleted" + e.getMessage());
		}
		return mobileId;
	}

	@Override
	public String searchMobileInPriceRange(String mobileid)
			throws MobileDBException {
		conn = DBUtil.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rst = stmt.executeQuery(QueryMapper.MOBILE_SEARCH_IN_PRICE_RANGE);
			while (rst.next()) {
				Mobile mob = new Mobile();
				mob.setMobileId(rst.getString("mobileid"));
				mob.setMobileName(rst.getString("name"));
				mob.setMobilePrice(rst.getString("price"));
				mob.setQuantity(rst.getString("quantity"));
			}
		} catch (SQLException e) {
			throw new MobileDBException("cannot retrieve data from mobile table"+e.getMessage());
		}
		return null;
	}

	@Override
	public Mobile searchMobile(String mobileId) throws MobileDBException {
		String sql = "SELECT mobileid, name, price, quantity FROM mobiles WHERE mobileid=?";
		Mobile mob = null;
		conn = DBUtil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, mobileId);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				mob = new Mobile();
				mob.setMobileId(rst.getString("mobileid"));
				mob.setMobileName(rst.getString("name"));
				mob.setMobilePrice(rst.getString("price"));
				mob.setQuantity(rst.getString("quantity"));
			}
		} catch (SQLException e) {
			throw new MobileDBException("Mobile searching failed"+e.getMessage());
		}
		return mob;
	}

	@Override
	public Mobile searchMobileInPriceRange(Mobile mobile)
			throws MobileDBException {
		// TODO Auto-generated method stub
		return null;
	}

}