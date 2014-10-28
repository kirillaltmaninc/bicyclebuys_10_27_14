package com.admin.action;

import java.io.Serializable;
import java.util.ArrayList;

public class productDTO implements Serializable
{
  private int id;
  private int pid;
  private int cartID;
  private int qty;
  private String orderID;
  private String orderdate;
  private String afterDiscount;
  private int totalproduct;
  private String price1;
  private String metadescription;
  private String metatitle;
  private String keywords;
  private String SUBID;
  private String shipingchargeviastate;
  private String shippingcost;
  private String status;
  private int chieldid;
  private String cookiesvalue;
  private float tax;
  private String product_name;
  private float price;
  private float QtyOnHand;
  private int qtyh;
  private String ManufactModel;
  private String ManufactModel1;
  private String SKU;
  private String RetailPrice;
  private String MSRP;
  private String BBCost;
  private String RetailMarkupPerc;
  private String InternetMarkupPerc;
  private String QtyCommitted;
  private String QtyAvailable;
  private String link;
  private String marketingdescription;
  private String model;
  private String QtyUpdatedBy;
  private String ManufactUPCode;
  private String ManufactUPCode1;
  private String Discontinued;
  private String webposted;
  private String FCW_POST;
  private String STORE_POST;
  private String DemandCustomer;
  private String DemandSerialNumber;
  private String QtyTransfered;
  private String RetailWebPrice;
  private String RetailWebMarkupPerc;
  private String ReorderLevel;
  private String WebNote;
  private String IsKit;
  private String Width_Mini;
  private String Height_Mini;
  private String Width_Small;
  private String Height_Small;
  private String Width_Large;
  private String Height_Large;
  private String IsChildorParentorItem;
  private String marketdescriptwo;
  private String DateDeleted;
  private String isparent;
  private String ProductNote;
  private String OverWeight;
  private String WebDiscPerc;
  private String WebDiscOfferings;
  private String DateCreated;
  private String METADescription;
  private String ManuLink;
  private String MaterialID;
  private String PatternID;
  private String AgeGroupID;
  private String GenderID;
  private String GoogleID;
  private String LargeImage;
  private String Width_XLarge;
  private String Height_XLarge;
  private String ShippingWeight;
  private String caption;
  private String subcatname;
  private String catname;
  private int catid;
  private String categoryname;
  private int cvisable;
  private String description;
  private String picturename;
  private String FreeFreight;
  private String Size;
  private String color;
  private String colorandsize;
  private String freeshipping;
  private String overweight;
  private String webTypes;
  private String webdisplay;
  private String subcatid;
  private int subID;
  private String val;
  private String brand;
  private String totalprod;
  private int coupan_id;
  private int max_uses;
  private String coupan_code;
  private String coupandescription;
  private float minamt;
  private float maxamt;
  
  private float rebateprice;
  private String webnoteid;
  
  
  private String prodid;
  
  public String getProdid() {
	return prodid;
}

public void setProdid(String prodid) {
	this.prodid = prodid;
}

private String startdate;
  private String enddate;
  private ArrayList coloransize;
  private String flag;
  
  private int childcount;
  
  private int ovw;
  
  public int getOvw() {
	return ovw;
}

public void setOvw(int ovw) {
	this.ovw = ovw;
}

public float getRebateprice() {
	return rebateprice;
}

public void setRebateprice(float rebateprice) {
	this.rebateprice = rebateprice;
}

public String getWebnoteid() {
	return webnoteid;
}

public void setWebnoteid(String webnoteid) {
	this.webnoteid = webnoteid;
}

public ArrayList getColoransize() {
	return coloransize;
}

public void setColoransize(ArrayList coloransize) {
	this.coloransize = coloransize;
}

public int getChildcount() {
	return childcount;
}

public void setChildcount(int childcount) {
	this.childcount = childcount;
}

public String getFlag() {
	return flag;
}

public void setFlag(String flag) {
	this.flag = flag;
}

public int getTotalproduct()
  {
    return this.totalproduct;
  }
  
  public void setTotalproduct(int totalproduct)
  {
    this.totalproduct = totalproduct;
  }
  
  public String getPrice1()
  {
    return this.price1;
  }
  
  public void setPrice1(String price1)
  {
    this.price1 = price1;
  }
  
  public String getAfterDiscount()
  {
    return this.afterDiscount;
  }
  
  public void setAfterDiscount(String afterDiscount)
  {
    this.afterDiscount = afterDiscount;
  }
  
  public String getMetadescription()
  {
    return this.metadescription;
  }
  
  public void setMetadescription(String metadescription)
  {
    this.metadescription = metadescription;
  }
  
  public String getMetatitle()
  {
    return this.metatitle;
  }
  
  public void setMetatitle(String metatitle)
  {
    this.metatitle = metatitle;
  }
  
  public String getKeywords()
  {
    return this.keywords;
  }
  
  public void setKeywords(String keywords)
  {
    this.keywords = keywords;
  }
  
  public String getSUBID()
  {
    return this.SUBID;
  }
  
  public void setSUBID(String sUBID)
  {
    this.SUBID = sUBID;
  }
  
  public String getShippingcost()
  {
    return this.shippingcost;
  }
  
  public void setShippingcost(String shippingcost)
  {
    this.shippingcost = shippingcost;
  }
  
  public String getShipingchargeviastate()
  {
    return this.shipingchargeviastate;
  }
  
  public void setShipingchargeviastate(String shipingchargeviastate)
  {
    this.shipingchargeviastate = shipingchargeviastate;
  }
  
  public int getQtyh()
  {
    return this.qtyh;
  }
  
  public void setQtyh(int qtyh)
  {
    this.qtyh = qtyh;
  }
  
  public String getManufactModel1()
  {
    return this.ManufactModel1;
  }
  
  public void setManufactModel1(String manufactModel1)
  {
    this.ManufactModel1 = manufactModel1;
  }
  
  public String getManufactUPCode1()
  {
    return this.ManufactUPCode1;
  }
  
  public void setManufactUPCode1(String manufactUPCode1)
  {
    this.ManufactUPCode1 = manufactUPCode1;
  }
  
  public String getIsparent()
  {
    return this.isparent;
  }
  
  public void setIsparent(String isparent)
  {
    this.isparent = isparent;
  }
  
  public float getTax()
  {
    return this.tax;
  }
  
  public void setTax(float tax)
  {
    this.tax = tax;
  }
  
  public String getOrderID()
  {
    return this.orderID;
  }
  
  public void setOrderID(String orderID)
  {
    this.orderID = orderID;
  }
  
  public String getOrderdate()
  {
    return this.orderdate;
  }
  
  public void setOrderdate(String orderdate)
  {
    this.orderdate = orderdate;
  }
  
  public String getCookiesvalue()
  {
    return this.cookiesvalue;
  }
  
  public void setCookiesvalue(String cookiesvalue)
  {
    this.cookiesvalue = cookiesvalue;
  }
  
  public int getChieldid()
  {
    return this.chieldid;
  }
  
  public void setChieldid(int chieldid)
  {
    this.chieldid = chieldid;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public int getQty()
  {
    return this.qty;
  }
  
  public void setQty(int qty)
  {
    this.qty = qty;
  }
  
  public int getPid()
  {
    return this.pid;
  }
  
  public void setPid(int pid)
  {
    this.pid = pid;
  }
  
  public int getCartID()
  {
    return this.cartID;
  }
  
  public void setCartID(int cartID)
  {
    this.cartID = cartID;
  }
  
  public String getWebTypes()
  {
    return this.webTypes;
  }
  
  public void setWebTypes(String webTypes)
  {
    this.webTypes = webTypes;
  }
  
  public int getSubID()
  {
    return this.subID;
  }
  
  public void setSubID(int subID)
  {
    this.subID = subID;
  }
  
  public int getCoupan_id()
  {
    return this.coupan_id;
  }
  
  public void setCoupan_id(int coupan_id)
  {
    this.coupan_id = coupan_id;
  }
  
  public int getMax_uses()
  {
    return this.max_uses;
  }
  
  public void setMax_uses(int max_uses)
  {
    this.max_uses = max_uses;
  }
  
  public String getCoupan_code()
  {
    return this.coupan_code;
  }
  
  public void setCoupan_code(String coupan_code)
  {
    this.coupan_code = coupan_code;
  }
  
  public String getCoupandescription()
  {
    return this.coupandescription;
  }
  
  public void setCoupandescription(String coupandescription)
  {
    this.coupandescription = coupandescription;
  }
  
  public float getMinamt()
  {
    return this.minamt;
  }
  
  public void setMinamt(float minamt)
  {
    this.minamt = minamt;
  }
  
  public float getMaxamt()
  {
    return this.maxamt;
  }
  
  public void setMaxamt(float maxamt)
  {
    this.maxamt = maxamt;
  }
  
  public String getStartdate()
  {
    return this.startdate;
  }
  
  public void setStartdate(String startdate)
  {
    this.startdate = startdate;
  }
  
  public String getEnddate()
  {
    return this.enddate;
  }
  
  public void setEnddate(String enddate)
  {
    this.enddate = enddate;
  }
  
  public String getTotalprod()
  {
    return this.totalprod;
  }
  
  public void setTotalprod(String totalprod)
  {
    this.totalprod = totalprod;
  }
  
  public int getCatid()
  {
    return this.catid;
  }
  
  public void setCatid(int catid)
  {
    this.catid = catid;
  }
  
  public String getVal()
  {
    return this.val;
  }
  
  public void setVal(String val)
  {
    this.val = val;
  }
  
  public String getSubcatname()
  {
    return this.subcatname;
  }
  
  public void setSubcatname(String subcatname)
  {
    this.subcatname = subcatname;
  }
  
  public String getCatname()
  {
    return this.catname;
  }
  
  public void setCatname(String catname)
  {
    this.catname = catname;
  }
  
  public String getBrand()
  {
    return this.brand;
  }
  
  public void setBrand(String brand)
  {
    this.brand = brand;
  }
  
  public String getWebdisplay()
  {
    return this.webdisplay;
  }
  
  public void setWebdisplay(String webdisplay)
  {
    this.webdisplay = webdisplay;
  }
  
  public String getSubcatid()
  {
    return this.subcatid;
  }
  
  public void setSubcatid(String subcatid)
  {
    this.subcatid = subcatid;
  }
  
  public String getFreeFreight()
  {
    return this.FreeFreight;
  }
  
  public void setFreeFreight(String freeFreight)
  {
    this.FreeFreight = freeFreight;
  }
  
  public String getFreeshipping()
  {
    return this.freeshipping;
  }
  
  public void setFreeshipping(String freeshipping)
  {
    this.freeshipping = freeshipping;
  }
  
  public String getOverweight()
  {
    return this.overweight;
  }
  
  public void setOverweight(String overweight)
  {
    this.overweight = overweight;
  }
  
  public String getColorandsize()
  {
    return this.colorandsize;
  }
  
  public void setColorandsize(String colorandsize)
  {
    this.colorandsize = colorandsize;
  }
  
  public String getSize()
  {
    return this.Size;
  }
  
  public void setSize(String size)
  {
    this.Size = size;
  }
  
  public String getColor()
  {
    return this.color;
  }
  
  public void setColor(String color)
  {
    this.color = color;
  }
  
  public String getCaption()
  {
    return this.caption;
  }
  
  public void setCaption(String caption)
  {
    this.caption = caption;
  }
  
  public String getPicturename()
  {
    return this.picturename;
  }
  
  public void setPicturename(String picturename)
  {
    this.picturename = picturename;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public String getCategoryname()
  {
    return this.categoryname;
  }
  
  public void setCategoryname(String categoryname)
  {
    this.categoryname = categoryname;
  }
  
  public int getCvisable()
  {
    return this.cvisable;
  }
  
  public void setCvisable(int cvisable)
  {
    this.cvisable = cvisable;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public String getProduct_name()
  {
    return this.product_name;
  }
  
  public void setProduct_name(String product_name)
  {
    this.product_name = product_name;
  }
  
  public float getPrice()
  {
    return this.price;
  }
  
  public void setPrice(float price)
  {
    this.price = price;
  }
  
  public float getQtyOnHand()
  {
    return this.QtyOnHand;
  }
  
  public void setQtyOnHand(float qtyOnHand)
  {
    this.QtyOnHand = qtyOnHand;
  }
  
  public String getManufactModel()
  {
    return this.ManufactModel;
  }
  
  public void setManufactModel(String manufactModel)
  {
    this.ManufactModel = manufactModel;
  }
  
  public String getSKU()
  {
    return this.SKU;
  }
  
  public void setSKU(String sKU)
  {
    this.SKU = sKU;
  }
  
  public String getRetailPrice()
  {
    return this.RetailPrice;
  }
  
  public void setRetailPrice(String retailPrice)
  {
    this.RetailPrice = retailPrice;
  }
  
  public String getMSRP()
  {
    return this.MSRP;
  }
  
  public void setMSRP(String mSRP)
  {
    this.MSRP = mSRP;
  }
  
  public String getBBCost()
  {
    return this.BBCost;
  }
  
  public void setBBCost(String bBCost)
  {
    this.BBCost = bBCost;
  }
  
  public String getRetailMarkupPerc()
  {
    return this.RetailMarkupPerc;
  }
  
  public void setRetailMarkupPerc(String retailMarkupPerc)
  {
    this.RetailMarkupPerc = retailMarkupPerc;
  }
  
  public String getInternetMarkupPerc()
  {
    return this.InternetMarkupPerc;
  }
  
  public void setInternetMarkupPerc(String internetMarkupPerc)
  {
    this.InternetMarkupPerc = internetMarkupPerc;
  }
  
  public String getQtyCommitted()
  {
    return this.QtyCommitted;
  }
  
  public void setQtyCommitted(String qtyCommitted)
  {
    this.QtyCommitted = qtyCommitted;
  }
  
  public String getQtyAvailable()
  {
    return this.QtyAvailable;
  }
  
  public void setQtyAvailable(String qtyAvailable)
  {
    this.QtyAvailable = qtyAvailable;
  }
  
  public String getLink()
  {
    return this.link;
  }
  
  public void setLink(String link)
  {
    this.link = link;
  }
  
  public String getMarketingdescription()
  {
    return this.marketingdescription;
  }
  
  public void setMarketingdescription(String marketingdescription)
  {
    this.marketingdescription = marketingdescription;
  }
  
  public String getModel()
  {
    return this.model;
  }
  
  public void setModel(String model)
  {
    this.model = model;
  }
  
  public String getQtyUpdatedBy()
  {
    return this.QtyUpdatedBy;
  }
  
  public void setQtyUpdatedBy(String qtyUpdatedBy)
  {
    this.QtyUpdatedBy = qtyUpdatedBy;
  }
  
  public String getManufactUPCode()
  {
    return this.ManufactUPCode;
  }
  
  public void setManufactUPCode(String manufactUPCode)
  {
    this.ManufactUPCode = manufactUPCode;
  }
  
  public String getDiscontinued()
  {
    return this.Discontinued;
  }
  
  public void setDiscontinued(String discontinued)
  {
    this.Discontinued = discontinued;
  }
  
  public String getWebposted()
  {
    return this.webposted;
  }
  
  public void setWebposted(String webposted)
  {
    this.webposted = webposted;
  }
  
  public String getFCW_POST()
  {
    return this.FCW_POST;
  }
  
  public void setFCW_POST(String fCW_POST)
  {
    this.FCW_POST = fCW_POST;
  }
  
  public String getSTORE_POST()
  {
    return this.STORE_POST;
  }
  
  public void setSTORE_POST(String sTORE_POST)
  {
    this.STORE_POST = sTORE_POST;
  }
  
  public String getDemandCustomer()
  {
    return this.DemandCustomer;
  }
  
  public void setDemandCustomer(String demandCustomer)
  {
    this.DemandCustomer = demandCustomer;
  }
  
  public String getDemandSerialNumber()
  {
    return this.DemandSerialNumber;
  }
  
  public void setDemandSerialNumber(String demandSerialNumber)
  {
    this.DemandSerialNumber = demandSerialNumber;
  }
  
  public String getQtyTransfered()
  {
    return this.QtyTransfered;
  }
  
  public void setQtyTransfered(String qtyTransfered)
  {
    this.QtyTransfered = qtyTransfered;
  }
  
  public String getRetailWebPrice()
  {
    return this.RetailWebPrice;
  }
  
  public void setRetailWebPrice(String retailWebPrice)
  {
    this.RetailWebPrice = retailWebPrice;
  }
  
  public String getRetailWebMarkupPerc()
  {
    return this.RetailWebMarkupPerc;
  }
  
  public void setRetailWebMarkupPerc(String retailWebMarkupPerc)
  {
    this.RetailWebMarkupPerc = retailWebMarkupPerc;
  }
  
  public String getReorderLevel()
  {
    return this.ReorderLevel;
  }
  
  public void setReorderLevel(String reorderLevel)
  {
    this.ReorderLevel = reorderLevel;
  }
  
  public String getWebNote()
  {
    return this.WebNote;
  }
  
  public void setWebNote(String webNote)
  {
    this.WebNote = webNote;
  }
  
  public String getIsKit()
  {
    return this.IsKit;
  }
  
  public void setIsKit(String isKit)
  {
    this.IsKit = isKit;
  }
  
  public String getWidth_Mini()
  {
    return this.Width_Mini;
  }
  
  public void setWidth_Mini(String width_Mini)
  {
    this.Width_Mini = width_Mini;
  }
  
  public String getHeight_Mini()
  {
    return this.Height_Mini;
  }
  
  public void setHeight_Mini(String height_Mini)
  {
    this.Height_Mini = height_Mini;
  }
  
  public String getWidth_Small()
  {
    return this.Width_Small;
  }
  
  public void setWidth_Small(String width_Small)
  {
    this.Width_Small = width_Small;
  }
  
  public String getHeight_Small()
  {
    return this.Height_Small;
  }
  
  public void setHeight_Small(String height_Small)
  {
    this.Height_Small = height_Small;
  }
  
  public String getWidth_Large()
  {
    return this.Width_Large;
  }
  
  public void setWidth_Large(String width_Large)
  {
    this.Width_Large = width_Large;
  }
  
  public String getHeight_Large()
  {
    return this.Height_Large;
  }
  
  public void setHeight_Large(String height_Large)
  {
    this.Height_Large = height_Large;
  }
  
  public String getIsChildorParentorItem()
  {
    return this.IsChildorParentorItem;
  }
  
  public void setIsChildorParentorItem(String isChildorParentorItem)
  {
    this.IsChildorParentorItem = isChildorParentorItem;
  }
  
  public String getMarketdescriptwo()
  {
    return this.marketdescriptwo;
  }
  
  public void setMarketdescriptwo(String marketdescriptwo)
  {
    this.marketdescriptwo = marketdescriptwo;
  }
  
  public String getDateDeleted()
  {
    return this.DateDeleted;
  }
  
  public void setDateDeleted(String dateDeleted)
  {
    this.DateDeleted = dateDeleted;
  }
  
  public String getProductNote()
  {
    return this.ProductNote;
  }
  
  public void setProductNote(String productNote)
  {
    this.ProductNote = productNote;
  }
  
  public String getOverWeight()
  {
    return this.OverWeight;
  }
  
  public void setOverWeight(String overWeight)
  {
    this.OverWeight = overWeight;
  }
  
  public String getWebDiscPerc()
  {
    return this.WebDiscPerc;
  }
  
  public void setWebDiscPerc(String webDiscPerc)
  {
    this.WebDiscPerc = webDiscPerc;
  }
  
  public String getWebDiscOfferings()
  {
    return this.WebDiscOfferings;
  }
  
  public void setWebDiscOfferings(String webDiscOfferings)
  {
    this.WebDiscOfferings = webDiscOfferings;
  }
  
  public String getDateCreated()
  {
    return this.DateCreated;
  }
  
  public void setDateCreated(String dateCreated)
  {
    this.DateCreated = dateCreated;
  }
  
  public String getMETADescription()
  {
    return this.METADescription;
  }
  
  public void setMETADescription(String mETADescription)
  {
    this.METADescription = mETADescription;
  }
  
  public String getManuLink()
  {
    return this.ManuLink;
  }
  
  public void setManuLink(String manuLink)
  {
    this.ManuLink = manuLink;
  }
  
  public String getMaterialID()
  {
    return this.MaterialID;
  }
  
  public void setMaterialID(String materialID)
  {
    this.MaterialID = materialID;
  }
  
  public String getPatternID()
  {
    return this.PatternID;
  }
  
  public void setPatternID(String patternID)
  {
    this.PatternID = patternID;
  }
  
  public String getAgeGroupID()
  {
    return this.AgeGroupID;
  }
  
  public void setAgeGroupID(String ageGroupID)
  {
    this.AgeGroupID = ageGroupID;
  }
  
  public String getGenderID()
  {
    return this.GenderID;
  }
  
  public void setGenderID(String genderID)
  {
    this.GenderID = genderID;
  }
  
  public String getGoogleID()
  {
    return this.GoogleID;
  }
  
  public void setGoogleID(String googleID)
  {
    this.GoogleID = googleID;
  }
  
  public String getLargeImage()
  {
    return this.LargeImage;
  }
  
  public void setLargeImage(String largeImage)
  {
    this.LargeImage = largeImage;
  }
  
  public String getWidth_XLarge()
  {
    return this.Width_XLarge;
  }
  
  public void setWidth_XLarge(String width_XLarge)
  {
    this.Width_XLarge = width_XLarge;
  }
  
  public String getHeight_XLarge()
  {
    return this.Height_XLarge;
  }
  
  public void setHeight_XLarge(String height_XLarge)
  {
    this.Height_XLarge = height_XLarge;
  }
  
  public String getShippingWeight()
  {
    return this.ShippingWeight;
  }
  
  public void setShippingWeight(String shippingWeight)
  {
    this.ShippingWeight = shippingWeight;
  }
}
