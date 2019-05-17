package com.cg.mps.service;

import java.util.List;

import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseDetails;
import com.cg.mps.dao.MobileDao;
import com.cg.mps.dao.MobileDaoImpl;
import com.cg.mps.exception.MobileDBException;

public class MobileServiceImpl implements MobileService {
	MobileDao mdao = new MobileDaoImpl();

	
	@Override
	public String addMobile(Mobile mobile) throws MobileDBException {
		// TODO Auto-generated method stub
		return mdao.addMobile(mobile);
	}

	@Override
	public List<Mobile> getAllMobiles() throws MobileDBException {
		// TODO Auto-generated method stub
		return mdao.getAllMobiles();
	}

	@Override
	public String purchaseDetails(PurchaseDetails mobileId)
			throws MobileDBException {
		// TODO Auto-generated method stub
		return mdao.purchaseDetails(mobileId);
	}

	@Override
	public String deleteMobile(String mobileId) throws MobileDBException {
		// TODO Auto-generated method stub
		return mdao.deleteMobile(mobileId);
	}

	@Override
	public Mobile searchMobileInPriceRange(Mobile mobile)
			throws MobileDBException {
		// TODO Auto-generated method stub
		return mdao.searchMobileInPriceRange(mobile);
	}

	@Override
	public Mobile searchMobile(String mobileId) throws MobileDBException {
		// TODO Auto-generated method stub
		return mdao.searchMobile(mobileId);
	}
	
	public boolean isValidMobile(Mobile mobile) throws MobileDBException {
		if(!mobile.getMobileName().matches("^[A-Z][a-z]{3,15}$")){
			throw new MobileDBException("Mobile name should start with caps and should be minimum of 3 letters");
		}
		
		return true;
	}
	
	public boolean isValidPurchaseMobile(PurchaseDetails purchaseDetails) throws MobileDBException {
		if(!purchaseDetails.getcName().matches("^[A-Z][a-z]{3,15}$")){
			throw new MobileDBException("Customer name should be start with Capital letter and should be minimum of 3 letters");
		}/*if(!purchaseDetails.getcNumber().matches("[789]{1}[0-9]{9}")){
			throw new MobileDBException("enter valid mobile no");
		}*/
		return true;
	}

}
