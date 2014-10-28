package com.admin.item;

public class Item {

	 public String id;
	   public String sku;
	   public String description;
	   public float price;
	   public int qty = 1;
	   public float perPrice;
	   private String pictureName;
	   private String colorAndSize;
	   
	/*public Item(String id, String sku, String description, float price,float perprice) {
		
		this.id = id;
		this.sku = sku;
		this.description = description;
		this.price = price;
		this.qty = qty;
		this.perpice=perpice;
	}*/
	public String getId() {
		return id;
	}
	public String getColorAndSize() {
		return colorAndSize;
	}
	public void setColorAndSize(String colorAndSize) {
		this.colorAndSize = colorAndSize;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getperPrice() {
		return perPrice;
	}
	public void setperPrice(float perPrice) {
		this.perPrice = perPrice;
	}
	   
	   
}
