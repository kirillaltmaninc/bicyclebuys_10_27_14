package com.admin.action;

import java.net.InetAddress;
import java.util.ArrayList;

public abstract interface adminDAO
{
	 
	
  public abstract ArrayList getproductdetails();
  
  public abstract ArrayList getcategorydetails();
  
  public abstract ArrayList getnewproduct();
  
  public abstract ArrayList getcolorandsizedetails(String paramString);
  
  public abstract ArrayList getcolorandsizedetails1(String paramString);
  
  public abstract String getshippingstatus(String paramString);
  
  public abstract ArrayList getcategorywiseproductdetails(String paramString, int pcount, String subcatidd) throws ClassNotFoundException;
  
  public abstract ArrayList getshippingvia(float paramFloat, String paramString);
  
  public abstract ArrayList getproductsubcategorywise(String paramString1, String paramString2, int pcount);
  
  
  
  public abstract ArrayList getsubcategorylistformenu(String paramString,String WEBTYPE);
  
  public abstract ArrayList getgetbrandname(String paramString1, String paramString2);
  
  public abstract ArrayList getgetbrandnameforsubcategory(String paramString1, String paramString2);
  
  public abstract ArrayList getsubcategorylistFORSubcategory(String paramString);
  
  public abstract ArrayList getproductdetailsBrandWise(String paramString1, String paramString2, String paramString3, String subcatidd);
  
  public abstract ArrayList getproductdescription(String paramString);
  
  public abstract ArrayList gethotdeals();
  
  public abstract ArrayList getpromo();
  
  public abstract ArrayList getrelatedproduct(String paramString1, String paramString2);
  
  public abstract ArrayList getParticularProduct(String paramString);
  
  public abstract ArrayList gethomelink1(String paramString1, String paramString2);
  
  public abstract ArrayList getmenunav(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract ArrayList getspecialsproduct();
  
  public abstract ArrayList getsearchdetails(String paramString);
  
  public abstract ArrayList getcoupandetails();
  
  public abstract ArrayList getcoupanwithproductdetails(String paramString);
  
  public abstract ArrayList getproductdetailsforcart(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract ArrayList getcartdetails(String paramString1, String paramString2);
  
  public abstract boolean deletecartdetails(String paramString);
  
  public abstract boolean updatecartdetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract boolean checkproductstatus(String paramString, InetAddress paramInetAddress);
  
  public abstract boolean checkproductstatusforchildprodd(String paramString1, InetAddress paramInetAddress, String paramString2);
  
  public abstract ArrayList getgetoffer(String paramString1, double paramDouble, String paramString2);
  
  public abstract int getcartitemscount(String paramString1, String paramString2);
  
  public abstract boolean clearcartdetails(String paramString1, String paramString2);
  
  public abstract boolean registeruser(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15);
  
  public abstract ArrayList checkuser(String paramString1, String paramString2);
  
  public abstract ArrayList getuserdetails(String paramString);
  
  public abstract ArrayList getshippingdetails(String paramString);
  
  public abstract boolean registeruser1(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16);
  
  public abstract String getUIDforgeustuser(String paramString);
  
  public abstract boolean getupdate(String paramString1, String paramString2);
  
  public abstract ArrayList getgetallstate();
  
  public abstract ArrayList getgetcountry();
  
  public abstract String getuid(String paramString);
  
  public abstract ArrayList getuserdetails1(String paramString);
  
  public abstract String getemail(String paramString);
  
  public abstract String getstateabb(String paramString);
  
  public abstract boolean saveorder(ArrayList paramArrayList, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract ArrayList getorderdetails(String paramString);
  
  public abstract ArrayList viewproductorderwise(String paramString);
  
  public abstract String getguid(String paramString);
  
  public abstract boolean updateshippingdetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17);
  
  public abstract boolean updatecarddetails(String paramString1, String paramString2);
  
  public abstract ArrayList getuserdetailsforallreadylogin(String paramString);
  
  public abstract ArrayList getshippingdetailsforloginuser(String paramString);
  
  public abstract boolean updateshippingdetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15);
  
  public abstract ArrayList getnavigation(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract ArrayList getcategorydetailsforviewmenu(String paramString);
  
  public abstract String getallsubcategoryID(String paramString);
  
  public abstract String getwebtypeid(String paramString);
  
  public abstract ArrayList getlistofsubcat(String paramString);
  
  public abstract ArrayList getpagetitledetails(String paramString);
  
  public abstract String gettitle(String paramString);
  
  public abstract String getdescriptions(String paramString);
  
  public abstract ArrayList getheaderdetails(String paramString);
  
  public abstract ArrayList getheaderdetailsforsubcategoryproduct(String paramString);
  
  public abstract ArrayList viewmyprofile(String paramString);
  
  public abstract boolean updateuserprofile(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17);
  
  public abstract boolean deletecartdetailsafterpayments(String paramString1, String paramString2);
  
  public abstract String getbrandname(String paramString);
  
  public abstract boolean subscribeToEmail(String paramString);
  
  public abstract String getsubcatlist(String paramString);
  
  public abstract String getStateAbbrevation(String paramString);
  
  public abstract float getTax(String paramString);
  
  public abstract boolean updateShipDetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String state, String country);
  
  public abstract boolean updateShipDetailsUnReg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String state, String country);
  
  public abstract String getShipCost(String paramString, double paramDouble);
  
  public abstract String getguestuid(String paramString);
  
  public abstract String getsubcategory(String paramString);

public abstract float getminprice(String webtypesID, String subcatidd);

public abstract float getmaxprice(String webtypesID, String subcatidd);

public abstract float getminpriceFORSubcategoryproduct(String subcat_id,
		String webtypeID);

public abstract float getmaxpriceFORSubcategoryproduct(String subcat_id,
		String webtypeID);

public abstract float getminpriceFORCategoryAndVendors(String vid,
		  String webtypes, String subCatID);

public abstract float getmaxpriceFORCategoryAndVendors(String vid,
		  String webtypes, String subCatID);

public abstract float getminpriceFORSubcategoryproductbooleanvaluefalse(
		String vid, String webtypes, String parameter);

public abstract float getmaxpriceFORSubcategoryproductbooleanvaluefalse(
		String vid, String webtypes, String parameter);

public abstract ArrayList getshipdetails(String useremail, String uid);

public abstract ArrayList getshippingdetailsGUESTUSER(String uid1);

public abstract ArrayList getbillengdetails(String useremail, String uid);

public abstract boolean createTextFile(ArrayList carddetails,
		ArrayList shipdetails, ArrayList billengdetails, String parameter,
		String parameter2, String parameter3, String parameter4, String shipvia, double ototal, double txtamt, double cp, String shicp, int odid, double rbetprice);
 

public int countchildren(String pid);

public abstract ArrayList getgetbrandnameForCategory(String webtypesID,
		String subcatidd, ArrayList details);

public abstract String getchieldid(String color);

public abstract ArrayList getcartdetails1(String bookingcode, String uid);

public abstract ArrayList getcartdetailsforcheckout(String bookingcode,
		String uid);

public abstract String getstateabbforpayment(String shipTo_state);

public abstract ArrayList getsubcategorylist(String subcatlist,
		String webtypesID);

public abstract ArrayList getshipdetailswithUID(String uid);

public abstract String getradiobuttonvalue(String stateAbbrevation, double ft); 
}
