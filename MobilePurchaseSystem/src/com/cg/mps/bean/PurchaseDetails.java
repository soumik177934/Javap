package com.cg.mps.bean;

public class PurchaseDetails {
	private String purchaseId;
	private String mobileId;
	private String cName;
	private String cNumber;
	private String cmail;

	public PurchaseDetails() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseDetails(String purchaseId, String mobileId, String cName,
			String cNumber, String cmail) {
		super();
		this.purchaseId = purchaseId;
		this.mobileId = mobileId;
		this.cName = cName;
		this.cNumber = cNumber;
		this.cmail = cmail;
	}

	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getMobileId() {
		return mobileId;
	}

	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcNumber() {
		return cNumber;
	}

	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}

	public String getCmail() {
		return cmail;
	}

	public void setCmail(String cmail) {
		this.cmail = cmail;
	}

	@Override
	public String toString() {
		return "PurchaseDetails [purchaseId=" + purchaseId + ", mobileId="
				+ mobileId + ", cName=" + cName + ", cNumber=" + cNumber
				+ ", cmail=" + cmail + "]";
	}
	

}
