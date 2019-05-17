package com.cg.mps.bean;

public class Mobile {
	private String mobileId;
	private String mobileName;
	private String mobilePrice;
	private String quantity;

	public Mobile() {
		// TODO Auto-generated constructor stub
	}

	public Mobile(String mobileId, String mobileName, String mobilePrice,
			String quantity) {
		super();
		this.mobileId = mobileId;
		this.mobileName = mobileName;
		this.mobilePrice = mobilePrice;
		this.quantity = quantity;
	}

	public String getMobileId() {
		return mobileId;
	}

	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public String getMobilePrice() {
		return mobilePrice;
	}

	public void setMobilePrice(String mobilePrice) {
		this.mobilePrice = mobilePrice;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", mobileName=" + mobileName
				+ ", mobilePrice=" + mobilePrice + ", quantity=" + quantity
				+ "]";
	}
	

}
