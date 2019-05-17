package com.cg.mps.dao;

import java.util.List;

import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseDetails;
import com.cg.mps.exception.MobileDBException;

public interface MobileDao {
	String addMobile(Mobile mobile) throws MobileDBException;
	List<Mobile> getAllMobiles() throws MobileDBException;
	String purchaseDetails(PurchaseDetails purchaseDetails) throws MobileDBException;
	String deleteMobile(String mobileId) throws MobileDBException;
	Mobile searchMobileInPriceRange(Mobile mobile) throws MobileDBException;
	Mobile searchMobile(String mobileId) throws MobileDBException;
	String searchMobileInPriceRange(String mobileid) throws MobileDBException;

}
