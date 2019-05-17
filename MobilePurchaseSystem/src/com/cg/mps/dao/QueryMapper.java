package com.cg.mps.dao;


public interface QueryMapper {
	public static final String RETRIVE_ALL_MOBILES_QUERY="SELECT mobileid,name,price,quantity FROM mobiles";
	public static final String VIEW_MOBILE_DETAILS="SELECT mobileid,name,price,quantity FROM mobiles WHERE  mobileid=?";
	public static final String INSERT_MOBILE="INSERT INTO mobiles VALUES(?,?,?,?)";
	public static final String INSERT_PURCHASE = "INSERT INTO purchasedetails VALUES(?,?,?,?,SYSDATE,?)";
	public static final String MOBILEID_SEQUENCE="SELECT mobileid_sequence.NEXTVAL FROM DUAL";
	public static final String PURCHASEID_SEQUENCE="SELECT purchaseid_sequence.NEXTVAL FROM DUAL";
	public static final String MOBILE_UPDATE="UPDATE mobiles SET quantity = quantity-1 WHERE mobileid=?";
	public static final String DELETE_MOBILE="DELETE FROM mobiles WHERE mobileid=?";
	public static final String MOBILE_SEARCH="SELECT mobileid,name,price,quantity FROM mobiles WHERE mobileid=?";
	public static final String MOBILE_SEARCH_IN_PRICE_RANGE="SELECT mobileid,name,price,quantity FROM mobiles WHERE price BETWEEN ? AND ?";

}
