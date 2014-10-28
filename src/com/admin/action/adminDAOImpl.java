package com.admin.action;

import com.dbconnect.Dbconnect;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class adminDAOImpl
  implements adminDAO
{
	    
  public ArrayList getproductdetails()
  {
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect(); 
      Statement st = db.dbconnect(); 
      ResultSet rs = st.executeQuery("select * from products");
      while (rs.next())
      {
        productDTO dt = new productDTO();
        dt.setId(rs.getInt("ProdID"));
        dt.setProduct_name(rs.getString("description"));
        dt.setPrice(rs.getFloat("BBCost"));
        dt.setManufactModel(rs.getString("ManufactModel"));
        dt.setPicturename(rs.getString("picture"));
        dt.setFreeshipping(rs.getString("FreeFreight"));
        dt.setOverweight(rs.getString("OverWeight"));
        type.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList getcategorydetails()
  {
    
    
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      ResultSet rs = st.executeQuery("select WebDisplayForNavType,SubCats,WebTypes from JohnWebNavType where SubCats!='' order by [WebDisplayForNavType]  ");
      int i=0;
      while (rs.next())
      {
    	  
        productDTO dt = new productDTO();
        dt.setCategoryname(rs.getString("WebDisplayForNavType"));
        dt.setSubcatid(rs.getString("SubCats")); 
        dt.setWebTypes(rs.getString("WebTypes"));  
        ResultSet rs1 = st1.executeQuery("select TOP 15 * from products as p,Vendor as v where p.VendID=v.VendID    and p.SubCatID IN ("+rs.getString("SubCats")+") and p.WebTypeID IN ("+rs.getString("WebTypes")+") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='' ) and webposted = 'Yes'  ");
         if (rs1.next())
	       {
	        dt.setStatus("true");
	       }
	       else
	       {
	    	   dt.setStatus("false"); 
	       }
      
        type.add(dt);
        i++;
        System.out.println("in side whil-->"+i);
      }
   
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList getnewproduct()
  {
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      ResultSet rs = st.executeQuery("SELECT TOP 8 p.*, H.ID, H.Sort, H.Col1_ProductID, H.Col2_ProductID, H.Col1_Original_Price, H.Col2_Original_Price,H.Col1_SizeHTML,H.Col2_SizeHTML,H.Col1_PageLink, H.Col2_PageLink, H.Type, H.NavTypeID FROM HTML_Special_SaleItems H INNER JOIN vwWebProducts p ON H.Col1_ProductID = p.ProdID WHERE H.Type=2 and webposted = 'Yes' AND p.WebPosted LIKE 'yes' and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='')  ORDER BY NEWID(), H.Sort");
      while (rs.next())
      {
        productDTO dt = new productDTO();
        dt.setId(rs.getInt("ProdID"));
        dt.setSubcatid(rs.getString("SubCatID"));
        dt.setQtyh(rs.getInt("QtyOnHand"));
        dt.setPrice(rs.getFloat("price"));
        dt.setDescription(rs.getString("description"));
        dt.setPicturename(rs.getString("picture"));
        dt.setFreeshipping(rs.getString("FreeFreight"));
        dt.setOverweight(rs.getString("OverWeight"));
        
        dt.setOvw(rs.getInt("OverWeight"));
        
        dt.setIsparent(rs.getString("IsChildorParentorItem"));
        dt.setProduct_name(rs.getString("description"));
        dt.setSKU(rs.getString("SKU"));
        
        ResultSet rs1 = st1.executeQuery("select w.Caption,p.ProdID from products as p, WebNotes as w where p.WebNote=w.WebNoteID and p.ProdID='" + rs.getInt("ProdID") + "' ");
        if (rs1.next()) {
          dt.setCaption(rs1.getString("Caption"));
        }
        type.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList getcolorandsizedetails(String id)
  {

	    ArrayList type = new ArrayList();
	    try
	    {
	      Dbconnect db = new Dbconnect();
	      Statement st = db.dbconnect();
	      Statement st1 = db.dbconnect();
	      Statement st2 = db.dbconnect();
	      String ColorID="";
	      ResultSet rs=null; 
	      int childcount=0;
	      boolean b=false;
	      ResultSet rs1= st1.executeQuery("select pc.ChildProdID,s.Size,c.Color,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c,Size as s where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid and p.SizeID=s.SizeID and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
	       if(rs1.next())
	      {  
	    	  rs= st.executeQuery("select pc.ChildProdID,s.Size,c.Color,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c,Size as s where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid and p.SizeID=s.SizeID and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
	          while (rs.next())
	          { 
	            productDTO dt = new productDTO();
	            dt.setId(rs.getInt("ChildProdID")); 
	            dt.setFreeshipping(rs.getString("FreeFreight"));
	            dt.setOverweight(rs.getString("OverWeight")); 
	            dt.setColor(rs.getString("Color"));
	            dt.setSize(rs.getString("Size"));
	            dt.setPrice(rs.getFloat("price")); 
	            String colorandsize = rs.getString("Size").replace('"',' ') + " " + rs.getString("Color").replace('"',' ');
	            dt.setColorandsize(colorandsize); 
	            dt.setFlag("true");
	            childcount++;
	            dt.setChildcount(childcount);
	            type.add(dt); 
	          }
	    	b=true;    	
	      }       
	      if(b==false)
	      { 
	    	  
	    	  ResultSet rs2= st2.executeQuery("select pc.ChildProdID,c.Color,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid  and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
	          if(rs2.next())
	    	  {
	        	  rs=st.executeQuery("select pc.ChildProdID,c.Color,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid  and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
	    		  while (rs.next())
	              {
	                productDTO dt = new productDTO();
	                dt.setId(rs.getInt("ChildProdID")); 
	                dt.setFreeshipping(rs.getString("FreeFreight"));
	                dt.setOverweight(rs.getString("OverWeight"));
	                String dvalue=rs.getString("Color");  
	                String color = dvalue.replace('"',' ');;  
	                dt.setColor(color);
	                dt.setSize(""); 
	                dt.setPrice(rs.getFloat("price"));  
	                dt.setColorandsize(color); 
	                dt.setFlag("false");
	                childcount++;
	                dt.setChildcount(childcount);
	                type.add(dt);
	              }   
	    		  b=true;
	    	  }
	    	  else
	    	  {
	    		  rs=st.executeQuery("select pc.ChildProdID,s.Size,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc , Size as s where p.ProdID=pc.ChildProdID  and p.SizeID=s.SizeID  and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
	    		  while (rs.next())
	              {
	                productDTO dt = new productDTO();
	                dt.setId(rs.getInt("ChildProdID")); 
	                dt.setFreeshipping(rs.getString("FreeFreight"));
	                dt.setOverweight(rs.getString("OverWeight")); 
	                dt.setColor(rs.getString("Size"));
	                dt.setSize(""); 
	                dt.setPrice(rs.getFloat("price")); 
	                String dvalue=rs.getString("Size"); 
	                String colorandsize = dvalue.replace('"',' ');; 
	                dt.setColorandsize(colorandsize); 
	                dt.setFlag("false");
	                childcount++;
	                dt.setChildcount(childcount);
	                type.add(dt);                
	              }     
	    	  }
	      } 
	      //}
	      db.close();
	      rs.close();
	    }
	    catch (Exception e)
	    {
	      System.out.println(e);
	    } 
	    return type;
	  /*  ArrayList type = new ArrayList();
	    try
	    { 
	      Dbconnect db = new Dbconnect();
	      Statement st = db.dbconnect();
	      Statement st1 = db.dbconnect();
	      Statement st2 = db.dbconnect();
	      String ColorID="";
	      ResultSet rs=null; 
	      int childcount=0;
	      boolean b=false;
	     
	      productDTO dt = null; 
	    	 String color = null;
	    	  ResultSet rs2= st2.executeQuery("select pc.ChildProdID,c.Color,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid  and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
	           while (rs2.next())
	              {
	                 dt = new productDTO();
	                dt.setId(rs2.getInt("ChildProdID")); 
	                dt.setFreeshipping(rs2.getString("FreeFreight"));
	                dt.setOverweight(rs2.getString("OverWeight"));
	                String dvalue=rs2.getString("Color");  
	                 color = dvalue.replace('"',' ');;  
	                dt.setColor(color);
	                dt.setSize(""); 
	                dt.setPrice(rs2.getFloat("price"));  
	                dt.setColorandsize(color); 
	                dt.setFlag("false");
	                childcount++;
	                dt.setChildcount(childcount); 
	                type.add(dt);
	              }  
	    		  rs=st.executeQuery("select pc.ChildProdID,s.Size,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc , Size as s where p.ProdID=pc.ChildProdID  and p.SizeID=s.SizeID  and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
	    		    while (rs.next())
	    			  {
	    				  if (dt==null) {
	    					  dt = new productDTO();
	    				  }
	    				  dt.setId(rs.getInt("ChildProdID")); 
	    				  dt.setFreeshipping(rs.getString("FreeFreight"));
	    				  dt.setOverweight(rs.getString("OverWeight")); 
	    				  dt.setColor(rs.getString("Size"));
	    				  dt.setSize(""); 
	    				  dt.setPrice(rs.getFloat("price")); 
	    				  String dvalue=rs.getString("Size"); 
	    				  String colorandsize;
	    				  if(color!=null){
	    					  colorandsize = rs.getString("Size").replace('"',' ') + color.replace('"',' ');
	    				  }
	    				  else{
	    					  colorandsize = dvalue.replace('"',' ');
	    				  }

	    				  dt.setColorandsize(colorandsize); 

	    				  dt.setFlag("false");
	    				  childcount++;
	    				  dt.setChildcount(childcount);
	    				  type.add(dt);                
	    			  }  
	      //}
	      db.close();
	      rs.close();
	       
	      if (dt!=null) {
			//type.add(dt);
		}
	      
	    }
	    catch (Exception e)
	    {
	      System.out.println(e);
	    } 
	    System.out.println("Type size----->"+type.size()); 
	    return type;
	    
	    */
	  }
  
  public ArrayList getcolorandsizedetails1(String id)
  {
	  System.out.println("INSIDE COLOR AND SIZE METHODS");  
	    ArrayList type = new ArrayList();
	    boolean k=false;
	     try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      Statement st2 = db.dbconnect();
      Statement st3 = db.dbconnect();
      ResultSet rs=null; 
	      int childcount=0;
	      boolean b=false;
	   
      ResultSet rs1= st1.executeQuery("select DISTINCT c.Color from products as p,[Products Children] pc ,Color as c,Size as s where p.ProdID=pc.ChildProdID and p.ColorID=c.colorid and p.SizeID=s.SizeID and pc.ProdID='" + id + "'");
	  if(rs1.next())
	  { 
	    rs = st.executeQuery("select DISTINCT c.Color from products as p,[Products Children] pc ,Color as c,Size as s where p.ProdID=pc.ChildProdID and p.ColorID=c.colorid and p.SizeID=s.SizeID and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
	    while (rs.next())
         {
	    	System.out.println("INSIDE BOTH");
	        productDTO dt = new productDTO(); 
	        dt.setColor(rs.getString("Color"));
	        dt.setFlag("true");
	        childcount++;
            dt.setChildcount(childcount);
	        type.add(dt);
        } 
        b=true;  
	  }
    if(b==false)
	    { 
	       ResultSet rs2= st2.executeQuery("select DISTINCT c.Color from products as p,[Products Children] pc ,Color as c where p.ProdID=pc.ChildProdID and p.ColorID=c.colorid  and  pc.ProdID='" + id + "'");
	       if(rs2.next())
	    	 {
	    	     System.out.println("INSIDE ONLY COLOR");
	    	      rs = st.executeQuery("select DISTINCT c.Color  from products as p,[Products Children] pc ,Color as c where p.ProdID=pc.ChildProdID and p.ColorID=c.colorid  and  pc.ProdID='" + id + "'");
	    	      while(rs.next()){
	    	      productDTO dt = new productDTO(); 
			      dt.setColor(rs.getString("Color"));
			      dt.setFlag("false");
	              childcount++;
	              dt.setChildcount(childcount); 
			      type.add(dt);
	    	      }
			      k=true;
			      b=true;
	    	      
	    	 }
	       else
	       {
	         b=false;
	       }
	      }
    if(b==false && k==false)
     {  
    	 ResultSet rs3= st3.executeQuery("select DISTINCT c.Size from products as p,[Products Children] pc , Size as c where p.ProdID=pc.ChildProdID and p.SizeID=c.SizeID and  pc.ProdID='" + id + "'");
	       if(rs3.next())
	    	 {    System.out.println("INSIDE ONLY SIZE");
	    	      rs = st.executeQuery("select DISTINCT c.Size  from products as p,[Products Children] pc , Size as c where p.ProdID=pc.ChildProdID and p.SizeID=c.SizeID and  pc.ProdID='" + id + "'");
	    	      while(rs.next()){ 
	    	      productDTO dt = new productDTO();
	    	      
			      dt.setColor(rs.getString("Size"));
			      dt.setFlag("false");
	              childcount++;
	              dt.setChildcount(childcount); 
			      type.add(dt);}
	    	 }
     }
	    
	    
	  /* 
	   * 
	   *  
	   *  
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      Statement st2 = db.dbconnect();
      String ColorID="";
      ResultSet rs=null; 
      int childcount=0;
      boolean b=false;
      ResultSet rs1= st1.executeQuery("select pc.ChildProdID,s.Size,c.Color,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c,Size as s where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid and p.SizeID=s.SizeID and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
     
      if(rs1.next())
      {  
    	  rs= st.executeQuery("select pc.ChildProdID,s.Size,c.Color,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c,Size as s where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid and p.SizeID=s.SizeID and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
          while (rs.next())
          { 
            productDTO dt = new productDTO();
            dt.setId(rs.getInt("ChildProdID")); 
            dt.setFreeshipping(rs.getString("FreeFreight"));
            dt.setOverweight(rs.getString("OverWeight")); 
            dt.setColor(rs.getString("Color"));
            dt.setSize(rs.getString("Size"));
            dt.setPrice(rs.getFloat("price")); 
            String colorandsize = rs.getString("Size") + " " + rs.getString("Color");
            dt.setColorandsize(colorandsize);
            dt.setFlag("true");
            childcount++;
            dt.setChildcount(childcount);
            type.add(dt); 
          }
    	b=true; 
    	
      }
       
      if(b==false)
      { 
    	  
    	  ResultSet rs2= st2.executeQuery("select pc.ChildProdID,c.Color,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid  and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
          if(rs2.next())
    	  {
        	  rs=st.executeQuery("select pc.ChildProdID,c.Color,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid  and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
    		  while (rs.next())
              {
                productDTO dt = new productDTO();
                dt.setId(rs.getInt("ChildProdID")); 
                dt.setFreeshipping(rs.getString("FreeFreight"));
                dt.setOverweight(rs.getString("OverWeight")); 
                dt.setColor(rs.getString("Color"));
                dt.setSize(""); 
                dt.setPrice(rs.getFloat("price")); 
                String colorandsize = rs.getString("Color");
                dt.setColorandsize(colorandsize); 
                dt.setFlag("false");
                childcount++;
                dt.setChildcount(childcount);
                type.add(dt);
                
              }   
    		  b=true;
    	  }
    	  else
    	  {
    		  rs=st.executeQuery("select pc.ChildProdID,s.Size,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc , Size as s where p.ProdID=pc.ChildProdID  and p.SizeID=s.SizeID  and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
    		  while (rs.next())
              {
                productDTO dt = new productDTO();
                dt.setId(rs.getInt("ChildProdID")); 
                dt.setFreeshipping(rs.getString("FreeFreight"));
                dt.setOverweight(rs.getString("OverWeight")); 
                dt.setColor(rs.getString("Size"));
                dt.setSize(""); 
                dt.setPrice(rs.getFloat("price")); 
                String colorandsize = rs.getString("Size");
                
                dt.setColorandsize(colorandsize); 
                dt.setFlag("false");
                childcount++;
                dt.setChildcount(childcount);
                type.add(dt);
                
              }     
    	  }
    	  
    	 
      } 
      
      
      
      
      //}
       
      db.close();
      rs.close();
       
    }
    catch (Exception e)
    {
      System.out.println(e);
    } 
    
    return type;
  
  
	   *  try
	    {
	      Dbconnect db = new Dbconnect();
	      Statement st = db.dbconnect();
	      Statement st1 = db.dbconnect();
	      Statement st2 = db.dbconnect();
	      String ColorID="";
	      ResultSet rs=null; 
	      int childcount=0;
	      boolean b=false;
	      ResultSet rs1= st1.executeQuery("select pc.ChildProdID,s.Size,c.Color,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c,Size as s where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid and p.SizeID=s.SizeID and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
	     
	      if(rs1.next())
	      {  
	    	  rs= st.executeQuery("select pc.ChildProdID,s.Size,c.Color,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c,Size as s where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid and p.SizeID=s.SizeID and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
	          while (rs.next())
	          { 
	            productDTO dt = new productDTO();
	            dt.setId(rs.getInt("ChildProdID")); 
	            dt.setFreeshipping(rs.getString("FreeFreight"));
	            dt.setOverweight(rs.getString("OverWeight")); 
	            dt.setColor(rs.getString("Color"));
	            dt.setSize(rs.getString("Size"));
	            dt.setPrice(rs.getFloat("price")); 
	            String colorandsize = rs.getString("Size") + " " + rs.getString("Color");
	            dt.setColorandsize(colorandsize);
	            dt.setFlag("true");
	            childcount++;
	            dt.setChildcount(childcount);
	            type.add(dt); 
	          }
	    	b=true; 
	    	
	      }
	       
	      if(b==false)
	      { 
	    	  
	    	  ResultSet rs2= st2.executeQuery("select pc.ChildProdID,c.Color,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid  and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
	          if(rs2.next())
	    	  {
	        	  rs=st.executeQuery("select pc.ChildProdID,c.Color,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid  and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
	    		  while (rs.next())
	              {
	                productDTO dt = new productDTO();
	                dt.setId(rs.getInt("ChildProdID")); 
	                dt.setFreeshipping(rs.getString("FreeFreight"));
	                dt.setOverweight(rs.getString("OverWeight")); 
	                dt.setColor(rs.getString("Color"));
	                dt.setSize(""); 
	                dt.setPrice(rs.getFloat("price")); 
	                String colorandsize = rs.getString("Color");
	                dt.setColorandsize(colorandsize); 
	                dt.setFlag("false");
	                childcount++;
	                dt.setChildcount(childcount);
	                type.add(dt);
	                
	              }   
	    		  b=true;
	    	  }
	    	  else
	    	  {
	    		  rs=st.executeQuery("select pc.ChildProdID,s.Size,p.price,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc , Size as s where p.ProdID=pc.ChildProdID  and p.SizeID=s.SizeID  and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + id + "'");
	    		  while (rs.next())
	              {
	                productDTO dt = new productDTO();
	                dt.setId(rs.getInt("ChildProdID")); 
	                dt.setFreeshipping(rs.getString("FreeFreight"));
	                dt.setOverweight(rs.getString("OverWeight")); 
	                dt.setColor(rs.getString("Size"));
	                dt.setSize(""); 
	                dt.setPrice(rs.getFloat("price")); 
	                String colorandsize = rs.getString("Size");
	                
	                dt.setColorandsize(colorandsize); 
	                dt.setFlag("false");
	                childcount++;
	                dt.setChildcount(childcount);
	                type.add(dt);
	                
	              }     
	    	  }
	    	  
	    	 
	      } 
	      
	      */
	      
	      
	      //}
	       
	      db.close();
	      rs.close();
	       
	    }
	    catch (Exception e)
	    {
	      System.out.println(e);
	    } 
	    
	    return type;
	  
    /*System.out.println("idddddddddddd" + id);
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      ResultSet rs=null; 
      ResultSet rs1=null;
      boolean b=false;
      rs1 = st1.executeQuery("select DISTINCT c.Color from products as p,[Products Children] pc ,Color as c,Size as s where p.ProdID=pc.ChildProdID and p.ColorID=c.colorid and p.SizeID=s.SizeID and pc.ProdID='" + id + "'");
      if(rs1.next())
      {
    	  rs = st.executeQuery("select DISTINCT c.Color from products as p,[Products Children] pc ,Color as c,Size as s where p.ProdID=pc.ChildProdID and p.ColorID=c.colorid and p.SizeID=s.SizeID and pc.ProdID='" + id + "'");
    	  while (rs.next())
          {
            productDTO dt = new productDTO();
            dt.setColor(rs.getString("Color"));
            dt.setFlag("true");
            type.add(dt);
          }
    	  b=true;
      }
      
      if(b==false)
      {
    	  rs = st.executeQuery("select DISTINCT c.Color from products as p,[Products Children] pc ,Color as c where p.ProdID=pc.ChildProdID and p.ColorID=c.colorid  and  pc.ProdID='" + id + "'");
    	  while (rs.next())
          {
            productDTO dt = new productDTO();
            dt.setColor(rs.getString("Color"));
            dt.setFlag("false");
            type.add(dt);
          } 
      }
      
      
      
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
    
    */
  }
  
  public String getshippingstatus(String id)
  {
    String ship = "null";
    



















    return ship;
  }
  
  public ArrayList getcategorywiseproductdetails(String id, int pcount, String subcatidd) throws ClassNotFoundException
  {
    ArrayList type = new ArrayList();
    System.out.println(id); 
    try 
	  {
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 Connection con = DriverManager.getConnection("jdbc:sqlserver://10.0.0.66:1433;databaseName=BBC_PROD;selectMethod=cursor","bicyclebuys","bicyclebuys");
		  String SQL = "{call getMostPopularFour(?,?)}";  
	      CallableStatement cstmt = con.prepareCall (SQL);
	      StringBuffer br=new StringBuffer();
	      int pcountc=0;
	      cstmt.setString(1,id); 
	      cstmt.setInt(2,0); 
	     cstmt.execute();
	     ResultSet rs=cstmt.getResultSet(); 
	      Dbconnect db = new Dbconnect();
	      Statement st = db.dbconnect();
	      Statement st4 = db.dbconnect();
	     while(rs.next())
	     {
	    	 productDTO dt = new productDTO();
	           dt.setId(rs.getInt("ProdID")); 
	           ResultSet rs4=st4.executeQuery("select IsChildorParentorItem from products where ProdID='"+rs.getInt("ProdID")+"'"); 
	           if(rs4.next())
	           {
	        	  if(rs4.getString("IsChildorParentorItem").equals("2"))
	        	  {
	        		  
	        	  }
	        	  else
	        	  {
	        		  br.append(rs.getInt("ProdID"));
	   	           br.append(",");	           
	   	           ResultSet rs3=st.executeQuery("select SubCatID,QtyOnHand,ManufactModel from products where ProdID='"+rs.getInt("ProdID")+"'"); 
	   	           if(rs3.next())
	   	           {
	   	        	   dt.setSubcatid(rs3.getString("SubCatID"));  
	   	        	   dt.setManufactModel(rs3.getString("ManufactModel"));
	   	        	   dt.setQtyh(rs3.getInt("QtyOnHand")); 
	   	           }
	   	           
	   	           dt.setProduct_name(rs.getString("description"));      
	   	           dt.setIsparent(rs.getString("IsChildorParentorItem")); 
	   	           
	   	           
	   	           
	   	           dt.setPrice(rs.getFloat("price"));        
	   	           
	   	           dt.setPicturename(rs.getString("picture"));
	   	           dt.setFreeshipping(rs.getString("FreeFreight"));
	   	           dt.setOverweight(rs.getString("OverWeight"));           
	   	           dt.setOvw(rs.getInt("OverWeight"));           
	   	          
	   	           dt.setIsChildorParentorItem(rs.getString("IsChildorParentorItem"));
	   	           dt.setSKU(rs.getString("SKU"));        
	    
	   	           dt.setCaption("");
	   	           pcountc++; 
	   	           dt.setProdid(br.toString());
	   	           type.add(dt); 
	        	  }
	           } 
	       }
	}
	catch (SQLException e) {
	   e.printStackTrace();
	}
	 
    
    
   /* try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      StringBuffer br=new StringBuffer();
      int pcountc=0;
       //ResultSet rs = st.executeQuery("select * from products where ProdID in( select DISTINCT TOP 10  p.ProdID from products as p,Vendor as v where p.VendID=v.VendID  and p.SubCatID IN ("+subcatidd+") and p.WebTypeID IN ("+id+") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='' )  and webposted = 'Yes') order by  description");
      ResultSet rs = st.executeQuery("select TOP 15 * from products as p,Vendor as v where p.VendID=v.VendID    and p.SubCatID IN ("+subcatidd+") and p.WebTypeID IN ("+id+") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='' ) and webposted = 'Yes'  order by  description");
      
       while (rs.next())
      {
           productDTO dt = new productDTO();
           dt.setId(rs.getInt("ProdID"));
           br.append(rs.getInt("ProdID"));
           br.append(",");
           dt.setSubcatid(rs.getString("SubCatID"));
           dt.setProduct_name(rs.getString("description"));      
           dt.setIsparent(rs.getString("IsChildorParentorItem"));  
           dt.setPrice(rs.getFloat("price"));        
           dt.setManufactModel(rs.getString("ManufactModel"));
           dt.setPicturename(rs.getString("picture"));
           dt.setFreeshipping(rs.getString("FreeFreight"));
           dt.setOverweight(rs.getString("OverWeight"));           
           dt.setOvw(rs.getInt("OverWeight"));           
           dt.setQtyh(rs.getInt("QtyOnHand")); 
           dt.setIsChildorParentorItem(rs.getString("IsChildorParentorItem"));
           dt.setSKU(rs.getString("SKU"));        
//           String q1="select w.Caption,p.ProdID from products as p, WebNotes as w where p.WebNote=w.WebNoteID and p.ProdID=?";
//           ResultSet rs1 = st1.executeQuery("select w.Caption,p.ProdID from products as p, WebNotes as w where p.WebNote=w.WebNoteID and p.ProdID='" + rs.getInt("ProdID") + "' ");
//         
//           if (rs1.next()) {
//             dt.setCaption(rs1.getString("Caption"));
//           } 
           dt.setCaption("");
           pcountc++; 
           dt.setProdid(br.toString());
           type.add(dt);
         } 
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    
    */
    return type;
  }
  
  public ArrayList getproductsubcategorywise(String id, String webtypeID, int pcount)
  {
    
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from products where ProdID in( select DISTINCT TOP 2000 p.ProdID from products as p,Subcategory as s,Vendor as v" +
        		"  where p.SubCatID=s.SubCatID and p.VendID=v.VendID and s.SubCatID='" + id + "' and CAST(p.WebTypeID as varchar(250)) IN (" + webtypeID + ")" +
        		" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes' ) order by  description ");
     int pcountc=0;
      while (rs.next())
      {  
    	        productDTO dt = new productDTO();
    	        dt.setQtyh(rs.getInt("QtyOnHand"));
    	        dt.setId(rs.getInt("ProdID"));
    	        dt.setProduct_name(rs.getString("description"));
    	        
//    	        float f = rs.getFloat("price");
//    	        String val = String.valueOf(f);
//    	        if (!val.contains("."))
//    	        {
//    	          val = val + ".00";
//    	          dt.setPrice(Float.parseFloat(val));
//    	        }
//    	        else
//    	        {
//    	          String str = Float.valueOf(val).toString();
//    	          str = str.substring(val.indexOf(".") + 1);
//    	          if (str.length() == 1)
//    	          {
//    	            val = val + "0";
//    	            dt.setPrice(Float.parseFloat(val));
//    	          }
//    	          if (str.length() > 1)
//    	          {
//    	            float totalval = 0.0F;
//    	            totalval = Float.parseFloat(val);
//    	            DecimalFormat twoDForm = new DecimalFormat("#0.00");
//    	            Double.parseDouble(twoDForm.format(totalval));
//    	            
//    	            String val1 = String.valueOf(Double.parseDouble(twoDForm.format(totalval)));
//    	            dt.setPrice(Float.parseFloat(val1));
//    	          }
//    	        }
    	        dt.setPrice(rs.getFloat("price"));
    	        dt.setManufactModel(rs.getString("ManufactModel"));
    	        dt.setFreeshipping(rs.getString("FreeFreight"));
    	        dt.setOverweight(rs.getString("OverWeight"));
    	        dt.setPicturename(rs.getString("picture"));
    	        dt.setSubcatid(rs.getString("SubCatID"));
    	        
    	        dt.setOvw(rs.getInt("OverWeight"));
    	        
    	        dt.setSKU(rs.getString("SKU"));
    	        dt.setIsparent(rs.getString("IsChildorParentorItem"));
    	        ResultSet rs1 = st1.executeQuery("select w.Caption,p.ProdID from products as p, WebNotes as w where p.WebNote=w.WebNoteID and p.ProdID='" + rs.getInt("ProdID") + "' ");
    	        if (rs1.next())
    	        {
    	          dt.setCaption(rs1.getString("Caption"));
    	        }
    	        type.add(dt); 
    	        pcountc++;
      }
       
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList getsubcategorylistformenu(String id,String WEBTYPE)
  {
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      String subcatid = id;
      String[] splits = subcatid.split(",");
      for (String SID : splits)
      {
        ResultSet rs = st.executeQuery("select DISTINCT * from Subcategory where SubCatID='" + SID + "'");
        while (rs.next())
        {
          productDTO dt = new productDTO();
          dt.setId(rs.getInt("SubCatID"));
          dt.setWebdisplay(rs.getString("WebDisplay"));
          dt.setSubcatname(rs.getString("SubCategory"));
          dt.setSubcatid(id);
          
           ResultSet rs1=st1.executeQuery("select COUNT(*) as countrow from products where CAST(WebTypeID as varchar(250)) IN ("+WEBTYPE+") " +
            		" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes' and CAST(SubCatID as varchar(250)) ='"+SID+"'");
             if(rs1.next())
            {
            	 if(rs1.getInt("countrow")==0)
            	 {
            		 dt.setStatus("false");
            	 }
            	 else
            	 {
            		 dt.setStatus("true");  
            	 } 
            }  
  
        //dt.setStatus("true");  
          type.add(dt);
        }
      }
      db.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
    /*
     * 
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      String subcatid = id;
      System.out.println("WEB TYPE ID---->"+webtypesID);
      System.out.println("subcatid ID---->"+subcatid);
      String[] splits = subcatid.split(",");
      for (String SID : splits)
      {
    	  System.out.println("SPLIT VALUE---->"+SID); 
        ResultSet rs = st.executeQuery("select TOP 1 * from Subcategory where SubCatID='" + SID + "'");
        while (rs.next())
        {
          productDTO dt = new productDTO();
          dt.setId(rs.getInt("SubCatID"));
          dt.setWebdisplay(rs.getString("WebDisplay"));
          dt.setSubcatid(id);
          dt.setSubcatname(rs.getString("SubCategory")); 
          
          ResultSet rs1=st1.executeQuery("select * from products where ProdID in( select DISTINCT TOP 5000 p.ProdID from products as p,Subcategory as s,Vendor as v " +
          		" where p.SubCatID=s.SubCatID and p.VendID=v.VendID and s.SubCatID='" + SID + "' and CAST(p.WebTypeID as varchar(250)) IN (" + webtypesID + ") " +
          				" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes' )");
          if(rs1.next())
          {
        	dt.setStatus("true");  
          }
          else
          {
        	  System.out.println("in side false");
        	  dt.setStatus("false"); 
          } 

          type.add(dt);
        }
      }
      db.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  
     */
  }
  
  public ArrayList getsubcategorylist(String id , String webtypesID)
  {
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      String subcatid = id;
      System.out.println("WEB TYPE ID---->"+webtypesID);
      System.out.println("subcatid ID---->"+subcatid);
      String[] splits = subcatid.split(",");
      
      
      ResultSet rssub=st.executeQuery("select SubCategory,SubCatID,WebDisplay from Subcategory where SubCatID in("
+"select distinct SubCatID from products where SubCatID in("+subcatid+") and WebTypeID in ("+webtypesID+")"
+"and webposted='yes' and (IsChildorParentorItem='0' or IsChildorParentorItem='1' or IsChildorParentorItem=''))");
      
//      
//      for (String SID : splits)
//      {
//    	  System.out.println("SPLIT VALUE---->"+SID); 
       // ResultSet rs = st.executeQuery("select TOP 1 * from Subcategory where SubCatID='" + SID + "'");
        while (rssub.next())
        {
          productDTO dt = new productDTO();
          dt.setId(rssub.getInt("SubCatID"));
          dt.setWebdisplay(rssub.getString("WebDisplay"));
          dt.setSubcatid(id);
          dt.setSubcatname(rssub.getString("SubCategory")); 
          
//           ResultSet rs1=st1.executeQuery("select COUNT(*) as countrow from products where CAST(WebTypeID as varchar(250)) IN ("+webtypesID+") " +
//          		" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes' and CAST(SubCatID as varchar(250)) ='"+SID+"'");
//          if(rs1.next())
//          {
//        	 if(rs1.getInt("countrow")==0)
//        	 {
//        		 dt.setStatus("false");
//        	 }
//        	 else
//        	 {
//        		 dt.setStatus("true");  
//        	 }
//        	 
//          } 
         dt.setStatus("true");  
          type.add(dt);
        }
      //}
      db.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  
  
  
  
  public ArrayList getgetbrandname(String id, String subcatidd)
  {
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect(); 
      Statement st1 = db.dbconnect();
      ResultSet rs = st.executeQuery("select   DISTINCT top 5000  v.Vendor ,v.VendID from products as p,Vendor as v where p.VendID=v.VendID  and p.SubCatID IN (" + subcatidd + ") and p.WebTypeID IN (" + id + ") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes'");
      while (rs.next())
      {
    	int i=0;
        productDTO dt = new productDTO();
        dt.setId(rs.getInt("VendID"));
        dt.setBrand(rs.getString("Vendor")); 
        
        StringBuffer sb=new StringBuffer("select ProdID,IsChildorParentorItem from products where ProdID in( select DISTINCT TOP 5000  p.ProdID from products as p,Vendor as v where p.VendID=v.VendID" +
        		" and p.SubCatID IN ("+subcatidd+") and p.WebTypeID IN ("+id+") " +
        		" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='' )  and webposted = 'Yes') " +
        		" and VendID='"+rs.getInt("VendID")+"'");
        
        ResultSet rs1=st1.executeQuery(sb.toString()); 
         
        while(rs1.next())
        {
        	ArrayList colorandsize;
        	colorandsize=getcolorandsizedetails(rs1.getString("ProdID")); 
        	 
        	if(colorandsize.isEmpty() && rs1.getString("IsChildorParentorItem").trim().equals("1")) 
         	{
        		//System.out.println("emptyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        	}
        	else
        	{
        	 i++;	
        	} 
        }  
        //System.out.println("VALUE OF I----------------->"+i); 
        dt.setCoupan_id(i);
        type.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList getgetbrandnameforsubcategory(String id, String webtypeID)
  {
    
    
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      ResultSet rs = st.executeQuery("select DISTINCT top 2000 p.WebTypeID,p.SubCatID, v.Vendor ,v.VendID from products as p,Subcategory as s,Vendor as v where p.SubCatID=s.SubCatID and p.VendID=v.VendID and s.SubCatID='" + id + "' and CAST(p.WebTypeID as varchar(250)) IN (" + webtypeID + ") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes'");
      while (rs.next())
      {
    	  int i=0;
        productDTO dt = new productDTO();
        dt.setId(rs.getInt("VendID"));
        dt.setBrand(rs.getString("Vendor"));
        dt.setSubcatid(rs.getString("SubCatID"));
        dt.setWebTypes(rs.getString("WebTypeID"));
        StringBuffer sb=new StringBuffer();
        sb.append("select ProdID,IsChildorParentorItem from products where ProdID in( select DISTINCT TOP 2000 p.ProdID from products as p,Subcategory as s,Vendor as v" +
        		"  where p.SubCatID=s.SubCatID and p.VendID=v.VendID and s.SubCatID='" + id + "' and CAST(p.WebTypeID as varchar(250)) IN (" + webtypeID + ")" +
        		" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes' ) and  VendID='"+rs.getInt("VendID")+"'");
        
        ResultSet rs1=st1.executeQuery(sb.toString());
         
        
        while(rs1.next())
        { 
        	ArrayList coldetails;
        	coldetails=getcolorandsizedetails(rs1.getString("ProdID"));
        	if(coldetails.isEmpty() && rs1.getString("IsChildorParentorItem").equals("1")) 
        	{
        		  
        	}
        	else
        	{
        		i++; 
        	} 
        	
        } 
    
        dt.setCoupan_id(i);
        
        
        type.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList getsubcategorylistFORSubcategory(String id)
  {
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select DISTINCT * from Subcategory where SubCatID='" + id + "'");
      while (rs.next())
      {
        productDTO dt = new productDTO();
        dt.setId(rs.getInt("SubCatID"));
        dt.setWebdisplay(rs.getString("WebDisplay"));
        type.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList getproductdetailsBrandWise(String id, String webtypes, String subCatID, String subcatidd)
  {
    ArrayList type = new ArrayList();
    
    
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
     
      if (subCatID.equals(""))
      {
        
        ResultSet rs = st.executeQuery("SELECT * from products where ProdID IN( select DISTINCT TOP 5000 ProdID from products where  CAST(WebTypeID as varchar(250)) IN (" + webtypes + ") " +
        		" and webposted='Yes' and SubCatID IN ("+subcatidd+") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') ) and VendID='" + id + "' order by  description");
        while (rs.next())
        {
          
          productDTO dt = new productDTO();
          dt.setId(rs.getInt("ProdID"));
          dt.setProduct_name(rs.getString("description"));
          dt.setPrice(rs.getFloat("price"));
          dt.setManufactModel(rs.getString("ManufactModel"));
          dt.setPicturename(rs.getString("picture"));
          dt.setFreeshipping(rs.getString("FreeFreight"));
          dt.setOverweight(rs.getString("OverWeight"));
          dt.setOvw(rs.getInt("OverWeight"));
          dt.setIsparent(rs.getString("IsChildorParentorItem"));
          dt.setSubcatid(rs.getString("SubCatID"));
          dt.setSKU(rs.getString("SKU")); 
          ResultSet rs1 = st1.executeQuery("select w.Caption,p.ProdID from products as p, WebNotes as w where p.WebNote=w.WebNoteID and p.ProdID='" + rs.getInt("ProdID") + "' ");
          if (rs1.next()) {
            dt.setCaption(rs1.getString("Caption"));
          }
          type.add(dt);
        }
      }
      else
      { 
        ResultSet rs = st.executeQuery("SELECT * from products where ProdID IN( select DISTINCT TOP 5000 ProdID from products where  CAST(WebTypeID as varchar(250)) IN (" + webtypes + ") " +
        		" and webposted='Yes' and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and SubCatID='"+subCatID+"') and VendID='" + id + "' order by  description");
        while (rs.next())
        {
          
          productDTO dt = new productDTO();
          dt.setId(rs.getInt("ProdID"));
          dt.setProduct_name(rs.getString("description"));
          dt.setPrice(rs.getFloat("price"));
          dt.setManufactModel(rs.getString("ManufactModel"));
          dt.setPicturename(rs.getString("picture"));
          dt.setFreeshipping(rs.getString("FreeFreight"));
          dt.setOverweight(rs.getString("OverWeight"));
          dt.setIsparent(rs.getString("IsChildorParentorItem"));
          dt.setSubcatid(rs.getString("SubCatID"));
          dt.setSKU(rs.getString("SKU")); 
          ResultSet rs1 = st1.executeQuery("select w.Caption,p.ProdID from products as p, WebNotes as w where p.WebNote=w.WebNoteID and p.ProdID='" + rs.getInt("ProdID") + "' ");
          if (rs1.next()) {
            dt.setCaption(rs1.getString("Caption"));
          }
          type.add(dt);
        }
      }
      db.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList getproductdescription(String id)
  {
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from Products as p,WebNotes as w,Vendor as v where p.WebNote=w.WebNoteID and p.VendID=v.VendID  and  webposted='Yes' and p.ProdID='" + id + "'");
      while (rs.next())
      {
        productDTO dt = new productDTO();
        dt.setId(rs.getInt("ProdID"));
        dt.setSubcatid(rs.getString("SubCatID"));
        dt.setDescription(rs.getString("description"));
        dt.setProduct_name(rs.getString("description"));
        dt.setPicturename(rs.getString("picture"));
        dt.setFreeFreight(rs.getString("FreeFreight"));
        dt.setSKU(rs.getString("SKU"));
        dt.setMSRP(rs.getString("MSRP"));
        dt.setPrice(rs.getFloat("price"));
        dt.setMarketingdescription(rs.getString("marketingdescription"));
        dt.setMarketdescriptwo(rs.getString("marketdescriptwo"));
        dt.setCaption(rs.getString("Caption"));
        dt.setManufactModel(rs.getString("ManufactModel"));
        
        dt.setManufactModel1(rs.getString("ManufactModel"));
        dt.setManufactUPCode1(rs.getString("ManufactUPCode"));
        
        
        dt.setWebnoteid(rs.getString("WebNote"));
        dt.setRebateprice(rs.getFloat("RetailWebPrice"));
        
        
        dt.setPicturename(rs.getString("picture"));
        dt.setOverweight(rs.getString("OverWeight"));
        
        dt.setOvw(rs.getInt("OverWeight")); 
        dt.setQtyh(rs.getInt("QtyOnHand"));
        
        
        dt.setQtyOnHand(rs.getFloat("QtyOnHand"));
        dt.setBrand(rs.getString("Vendor"));
        type.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList gethotdeals()
  {
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      
      Statement st2 = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select * from MainPage where ID='1'");
      if (rs.next()) {
        for (int i = 1; i <= 8; i++)
        {
          String pro1 = rs.getString("ProdID" + i);
          
          ResultSet rs1 = st1.executeQuery("select * from products where ProdID='" + pro1 + "' and  (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes'");
          while (rs1.next())
          {
            productDTO dt = new productDTO();
            dt.setId(rs1.getInt("ProdID"));
            dt.setSubcatid(rs1.getString("SubCatID"));
            dt.setProduct_name(rs1.getString("description"));  

            dt.setPrice(rs1.getFloat("price"));
            dt.setManufactModel(rs1.getString("ManufactModel"));
            dt.setPicturename(rs1.getString("picture"));
            dt.setFreeshipping(rs1.getString("FreeFreight"));
            dt.setOverweight(rs1.getString("OverWeight"));
            dt.setSKU(rs1.getString("SKU"));
            
            dt.setQtyh(rs1.getInt("QtyOnHand")); 
            dt.setOvw(rs1.getInt("OverWeight")); 
            dt.setIsparent(rs1.getString("IsChildorParentorItem"));
            

            ResultSet rs2 = st2.executeQuery("select w.Caption,p.ProdID from products as p, WebNotes as w where p.WebNote=w.WebNoteID and p.ProdID='" + rs1.getInt("ProdID") + "' ");
            if (rs2.next()) {
              dt.setCaption(rs2.getString("Caption"));
            }
            type.add(dt);
          }
        }
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList getpromo()
  {
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      ResultSet rs = st.executeQuery("select TOP 5 * from  Promo where status='1'");
      while (rs.next())
      {
        productDTO dt = new productDTO();
        
        dt.setLink(rs.getString("link"));
        dt.setPicturename(rs.getString("picture"));
        















        type.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList getrelatedproduct(String id, String id2)
  {
     
    
    ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select top 5 * from products where  SubCatID='" + id + "' AND webposted='Yes' AND ProdID <> '" + id2 + "' ORDER BY NEWID()");
      while (rs.next())
      {
        productDTO dt = new productDTO();
        dt.setId(rs.getInt("ProdID"));
        dt.setSubcatid(rs.getString("SubCatID"));
        dt.setDescription(rs.getString("description"));
        dt.setPicturename(rs.getString("picture"));
        
        dt.setWebnoteid(rs.getString("WebNote"));
        dt.setRebateprice(rs.getFloat("RetailWebPrice"));
        
        dt.setProduct_name(rs.getString("description"));
        dt.setSKU(rs.getString("SKU"));
        dt.setFreeFreight(rs.getString("FreeFreight"));
        
        System.out.println("WEBNOTE ID IN DAOIMPL---->"+rs.getString("WebNote")); 

        float f = rs.getFloat("price");
        String val = String.valueOf(f);
        if (!val.contains("."))
        {
          val = val + ".00";
          dt.setPrice(Float.parseFloat(val));
        }
        else
        {
          String str = Float.valueOf(val).toString();
          str = str.substring(val.indexOf(".") + 1);
          if (str.length() == 1)
          {
            val = val + "0";
            dt.setPrice(Float.parseFloat(val));
          }
          if (str.length() > 1)
          {
            float totalval = 0.0F;
            totalval = Float.parseFloat(val);
            DecimalFormat twoDForm = new DecimalFormat("#0.00");
            Double.parseDouble(twoDForm.format(totalval));
            
            String val1 = String.valueOf(Double.parseDouble(twoDForm.format(totalval)));
            dt.setPrice(Float.parseFloat(val1));
          }
        }
        dt.setOverweight(rs.getString("OverWeight"));
        
        details.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public ArrayList getParticularProduct(String id)
  {
    ArrayList productDetails = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select * from products where ProdID='" + id + "'");
      while (rs.next())
      {
        productDTO dt = new productDTO();
        dt.setId(rs.getInt("ProdID"));
        dt.setSKU(rs.getString("SKU"));
        dt.setDescription(rs.getString("description"));
        dt.setPrice(rs.getFloat("price"));
        dt.setPicturename(rs.getString("picture"));
        
        productDetails.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return productDetails;
  }
  
  public ArrayList gethomelink1(String id, String subid)
  {
    ArrayList details = new ArrayList();
    
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      Statement st2 = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from Subcategory where SubCatID='" + subid + "' ");
      if (rs.next())
      {
        productDTO dt = new productDTO();
        dt.setWebdisplay(rs.getString("WebDisplay"));
        ResultSet rs1 = st1.executeQuery("select * from Categories  where CategoryID='" + rs.getInt("CategoryID") + "'");
        if (rs1.next())
        {
          dt.setCatid(rs1.getInt("CategoryID"));
          dt.setCategoryname(rs1.getString("Category"));
        }
        details.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public ArrayList getmenunav(String cat_id, String cat, String subcat_id, String ven_id, String pro_id, String val)
  {
    
    ArrayList details = new ArrayList();
    if (val.equals("1"))
    {
      productDTO dt = new productDTO();
      dt.setCategoryname(cat);
      dt.setVal(val);
      details.add(dt);
    }
    if (val.equals("2")) {
      try
      {
        Dbconnect db = new Dbconnect();
        Statement st = db.dbconnect();
        ResultSet rs = st.executeQuery("select c.Category,c.CategoryID from Subcategory as s, Categories as c where s.CategoryID=c.CategoryID and s.SubCatID='" + subcat_id + "'");
        if (rs.next())
        {
          productDTO dt = new productDTO();
          dt.setCategoryname(rs.getString("Category"));
          dt.setCatid(Integer.parseInt(rs.getString("CategoryID")));
          dt.setSubcatid(subcat_id);
          dt.setSubcatname(cat);
          dt.setVal(val);
          details.add(dt);
        }
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
    }
    if (val.equals("4")) {
      try
      {
        Dbconnect db = new Dbconnect();
        Statement st = db.dbconnect();
        Statement st1 = db.dbconnect();
        Statement st2 = db.dbconnect();
        ResultSet rs = st.executeQuery("select * from products where ProdID='" + pro_id + "'");
        if (rs.next())
        {
          productDTO dt = new productDTO();
          dt.setProduct_name(rs.getString("description"));
          ResultSet rs1 = st1.executeQuery("select top 1 * from JohnWebNavType WHERE WebTypes like '%" + rs.getString("WebTypeID") + "%' ");
          if (rs1.next())
          {
            dt.setCategoryname(rs1.getString("WebDisplayForNavType"));
            dt.setSubcatid(rs1.getString("SubCats"));
            dt.setWebTypes(rs1.getString("WebTypes"));
          }
          ResultSet rs2 = st2.executeQuery("select top 1 * from Subcategory where SubCatID='" + rs.getString("SubCatID") + "'");
          if (rs2.next())
          {
            dt.setSubcatname(rs2.getString("WebDisplay"));
            Statement st5 = db.dbconnect();
            ResultSet rs5 = st.executeQuery("select DISTINCT SubCatID from Subcategory where WebDisplay='" + rs2.getString("WebDisplay") + "'");
            if (rs5.next()) {
              dt.setId(rs5.getInt("SubCatID"));
            }
          }
          details.add(dt);
        }
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
    }
    return details;
  }
  
  public ArrayList getspecialsproduct()
  {
    ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("SELECT TOP 21  p.ProdID,p.picture,p.description,p.SubCatID  FROM HTML_Special_SaleItems INNER JOIN vwWebProducts p ON HTML_Special_SaleItems.Col1_ProductID = p.ProdID WHERE HTML_Special_SaleItems.Type=1 AND p.WebPosted LIKE 'yes'");
      while (rs.next())
      {
        productDTO dt = new productDTO();
        dt.setId(rs.getInt("ProdID"));
        dt.setSubcatid(rs.getString("SubCatID"));
        dt.setDescription(rs.getString("description"));
        dt.setPicturename(rs.getString("picture"));
        details.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public ArrayList getsearchdetails(String searchvalue)
  {
	  int searchcount = 0;
    ArrayList type = new ArrayList();
    String query = "0";
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      Statement st2 = db.dbconnect();
      
      boolean b = false;
      boolean status = false;
      StringBuffer main = new StringBuffer();
      StringBuffer main1 = new StringBuffer();
      StringBuffer main2 = new StringBuffer();
      
 
      main.append("select TOP 2000 * from products  where  SKU like '%" + searchvalue + "%'  AND (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes'");
      ResultSet rs1 = st1.executeQuery("select * from Vendor where Vendor = '" + searchvalue + "'");
      if (rs1.next())
      {
        
        main1.append(" select TOP 2000 * from products  p ,Vendor v where p.VendID=v.VendID AND (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and v.VendID='" + rs1.getString("VendID") + "'  and webposted = 'Yes' order by  description");
        b = true;
        status = true;
      }
      String sta = "notfound";
      ResultSet rs = null;
      if (b)
      {
       
        rs = st.executeQuery(main1.toString());
        status = true;
       
      }
      else
      {
        
        rs = st.executeQuery(main.toString());
        
      }
    
       //918150973333  k34i7
      
      while (rs.next())
      {
    	  System.out.println("inside 1 while");
        status = true;
        productDTO dt = new productDTO();
        dt.setQtyh(rs.getInt("QtyOnHand"));
        dt.setIsparent(rs.getString("IsChildorParentorItem"));
        dt.setId(rs.getInt("ProdID"));
        dt.setSubcatid(rs.getString("SubCatID"));
        dt.setProduct_name(rs.getString("description"));
        dt.setPrice(rs.getFloat("price"));
        dt.setManufactModel(rs.getString("ManufactModel"));
        dt.setPicturename(rs.getString("picture"));
        dt.setFreeshipping(rs.getString("FreeFreight"));
        dt.setOvw(rs.getInt("OverWeight"));
        
        dt.setOverweight(rs.getString("OverWeight"));
        dt.setSKU(rs.getString("SKU"));
        ResultSet rs2 = st1.executeQuery("select w.Caption,p.ProdID from products as p, WebNotes as w where p.WebNote=w.WebNoteID and p.ProdID='" + rs.getInt("ProdID") + "' ");
        if (rs2.next()) {
          dt.setCaption(rs2.getString("Caption"));
        }
       //i++;
        
        ArrayList colorandsize = getcolorandsizedetails(rs.getString("ProdID"));
        if ((!colorandsize.isEmpty()) || (!rs.getString("IsChildorParentorItem").equals("1")) || (!rs.getString("IsChildorParentorItem").equals("0"))) {
        	searchcount++;
       	  dt.setTotalproduct(searchcount);
        }
        type.add(dt);
      }
      if (!status)
      {
        
        String[] splits = searchvalue.split(" ");
        
        String part1 = "";
        String part2 = "";
        String part3 = "";
        String part4 = "";
        
        int k = 0;
        for (String SID1 : splits)
        {          
          k++;
        }
        if (k > 0) {
          part1 = splits[0];
        }
        if (k > 1) {
          part2 = splits[1];
        }
        if (k > 2) {
          part3 = splits[2];
        }
        if (k > 3) {
          part4 = splits[3];
        }
       
        main2.append("select  TOP 2000 * from products where webposted = 'Yes' and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') ");
        if (!part1.equals("")) {
          main2.append(" and description like '%" + part1 + "%'");
        }
        if (!part2.equals("")) {
          main2.append(" and description like '%" + part2 + "%'");
        }
        if (!part3.equals("")) {
          main2.append(" and description like '%" + part3 + "%'");
        }
        if (!part4.equals("")) {
          main2.append(" and description like '%" + part4 + "%'");
        } 
        main2.append(" order by  description");
        System.out.println(" final quesry-->" + main2);
        rs = st2.executeQuery(main2.toString());
        while (rs.next())
        {
        	System.out.println("inside 2 while");
          productDTO dt = new productDTO();
          dt.setIsparent(rs.getString("IsChildorParentorItem"));
          dt.setQtyh(rs.getInt("QtyOnHand"));
          dt.setId(rs.getInt("ProdID"));
          dt.setSubcatid(rs.getString("SubCatID"));
          dt.setProduct_name(rs.getString("description"));
          dt.setPrice(rs.getFloat("price"));
          dt.setManufactModel(rs.getString("ManufactModel"));
          dt.setPicturename(rs.getString("picture"));
          dt.setFreeshipping(rs.getString("FreeFreight"));
          dt.setOverweight(rs.getString("OverWeight"));
          dt.setSKU(rs.getString("SKU"));
          ResultSet rs2 = st1.executeQuery("select w.Caption,p.ProdID from products as p, WebNotes as w where p.WebNote=w.WebNoteID and p.ProdID='" + rs.getInt("ProdID") + "' ");
          if (rs2.next()) {
            dt.setCaption(rs2.getString("Caption"));
          }  
          ArrayList colorandsize = getcolorandsizedetails(rs.getString("ProdID"));
          if ((!colorandsize.isEmpty()) || (!rs.getString("IsChildorParentorItem").equals("1")) || (!rs.getString("IsChildorParentorItem").equals("0"))) {
        	  searchcount++;
        	  dt.setTotalproduct(searchcount); 
          }
          type.add(dt);
        }
      }
      db.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList getcoupandetails()
  {
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select * from Coupon where status='true'");
      while (rs.next()) {}
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList getcoupanwithproductdetails(String couid)
  {
    ArrayList type = new ArrayList();
    










































    return type;
  }
  
  public ArrayList getproductdetailsforcart(String id, String colorandsize, String chieldPID, String code, String uid, String qtyinpd)
  {
    ArrayList type = new ArrayList();
    

    
    try
    {
      String code1 = null;
      if (uid == null) {
        code1 = code;
      } else {
        code1 = uid;
      }
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = null;
      if ((chieldPID.equals("NULL")) || (chieldPID == null))
      {
        System.out.println("INSIDE COLORAND SIZE NULL IN DAOIMPL");
        rs = st.executeQuery("select * from products where ProdID='" + id + "'");
        while (rs.next())
        {
          productDTO dt = new productDTO();
          dt.setId(rs.getInt("ProdID"));
          dt.setProduct_name(rs.getString("description"));
          dt.setPrice(rs.getFloat("BBCost"));
          dt.setManufactModel(rs.getString("ManufactModel"));
          dt.setPicturename(rs.getString("picture"));
          dt.setFreeshipping(rs.getString("FreeFreight"));
          dt.setOverweight(rs.getString("OverWeight"));
          
          dt.setSKU(rs.getString("SKU"));
          dt.setDescription(rs.getString("description"));
          dt.setPrice(rs.getFloat("price"));
          dt.setMSRP(rs.getString("MSRP"));
          
          Statement st1 = db.dbconnect();
          
          Statement st3 = db.dbconnect();
          Statement st4 = db.dbconnect();
          ResultSet rs3 = st3.executeQuery("select * from cartdetails where productid='" + rs.getInt("ProdID") + "' and Ipaddress1='" + code1 + "'");
          if (rs3.next())
          {
            String qty = rs3.getString("QTY");
            int finalqty = Integer.parseInt(qty);
            finalqty += Integer.parseInt(qtyinpd);
            st4.executeUpdate("update  cartdetails set QTY='" + finalqty + "' where productid='" + rs.getInt("ProdID") + "' and Ipaddress1='" + code1 + "'");
          }
          else
          {
            st1.executeUpdate("insert into cartdetails (productid,QTY,Ipaddress1,colorandsize) values('" + 
              rs.getInt("ProdID") + "','" + qtyinpd + "','" + code1 + "','" + colorandsize + "')");
          }
          type.add(dt);
        }
        db.close();
        rs.close();
      }
      else
      {
    	  System.out.println("INSIDE COLORAND SIZE NOT NULL IN DAOIMPL");
        rs = st.executeQuery("select * from products where ProdID='" + chieldPID + "'");
        while (rs.next())
        {
          productDTO dt = new productDTO();
          dt.setId(rs.getInt("ProdID"));
          dt.setProduct_name(rs.getString("description"));
          dt.setPrice(rs.getFloat("BBCost"));
          dt.setManufactModel(rs.getString("ManufactModel"));
          dt.setPicturename(rs.getString("picture"));
          dt.setFreeshipping(rs.getString("FreeFreight"));
          dt.setOverweight(rs.getString("OverWeight"));
          dt.setSKU(rs.getString("SKU"));
          dt.setDescription(rs.getString("description"));
          dt.setPrice(rs.getFloat("price"));
          dt.setMSRP(rs.getString("MSRP"));
          Statement st1 = db.dbconnect();
          


          Statement st3 = db.dbconnect();
          Statement st4 = db.dbconnect();
          System.out.println("in side select box available -->" + rs.getInt("ProdID"));
          ResultSet rs3 = st3.executeQuery("select * from cartdetails where chieldPID='" + chieldPID + "' and Ipaddress1='" + code1 + "'");
          if (rs3.next())
          {
            String qty = rs3.getString("QTY");
            int finalqty = Integer.parseInt(qty);
            finalqty++;
            st4.executeUpdate("update  cartdetails set QTY='" + finalqty + "' where chieldPID='" + chieldPID + "' and Ipaddress1='" + code1 + "'");
          }
          else
          {
            st1.executeUpdate("insert into cartdetails (productid,QTY,Ipaddress1,colorandsize,chieldPID) values('" + 
              id + "','" + qtyinpd + "','" + code1 + "','" + colorandsize + "','" + chieldPID + "')");
          }
          type.add(dt);
        }
        db.close();
        rs.close();
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public ArrayList getcartdetails(String code, String uid)
  {
    ArrayList type = new ArrayList(); 
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      if (uid == null)
      {
        System.out.println("inside 1");
        ResultSet rs = st.executeQuery("select * from Cartdetails where Ipaddress1='" + code + "'");
        while (rs.next())
        {
          productDTO dt = new productDTO();
          dt.setCartID(rs.getInt("cid"));
          dt.setQty(rs.getInt("QTY"));
          dt.setCookiesvalue(rs.getString("Ipaddress1"));
          dt.setColorandsize(rs.getString("colorandsize"));
          dt.setPid(rs.getInt("productid"));
          dt.setChieldid(rs.getInt("chieldPID"));
          Statement st1 = db.dbconnect();
          Statement st2 = db.dbconnect();
          System.out.println("rs.getString-->" + rs.getString("chieldPID"));
          if (rs.getString("chieldPID") == null)
          {
            ResultSet rs1 = st1.executeQuery("select * from products where ProdID='" + rs.getInt("productid") + "'");
            if (rs1.next())
            {
              dt.setPid(rs.getInt("productid"));
              dt.setId(rs1.getInt("ProdID"));
              dt.setSubcatid(rs1.getString("SubCatID"));
              dt.setProduct_name(rs1.getString("description"));
              dt.setWebnoteid(rs1.getString("WebNote")); 
              dt.setRebateprice(rs1.getFloat("RetailWebPrice")); 
              dt.setManufactModel(rs1.getString("ManufactModel"));
              dt.setPicturename(rs1.getString("picture"));
              dt.setFreeshipping(rs1.getString("FreeFreight"));
              dt.setOverweight(rs1.getString("OverWeight"));
              dt.setSKU(rs1.getString("SKU"));
              dt.setDescription(rs1.getString("description")); 
               dt.setPrice(rs1.getFloat("price")); 
              dt.setMSRP(rs1.getString("MSRP"));
            }
            type.add(dt);
          }
          else
          {
            ResultSet rs2 = st2.executeQuery("select * from products where ProdID='" + rs.getString("chieldPID") + "'");
            if (rs2.next())
            {
              dt.setPid(rs.getInt("productid"));
              
              dt.setId(rs2.getInt("ProdID"));
              dt.setSubcatid(rs2.getString("SubCatID"));
              dt.setProduct_name(rs2.getString("description"));
              dt.setWebnoteid(rs2.getString("WebNote")); 
              dt.setRebateprice(rs2.getFloat("RetailWebPrice")); 
              dt.setManufactModel(rs2.getString("ManufactModel"));
              dt.setPicturename(rs2.getString("picture"));
              dt.setFreeshipping(rs2.getString("FreeFreight"));
              dt.setOverweight(rs2.getString("OverWeight"));
              dt.setSKU(rs2.getString("SKU"));
              dt.setDescription(rs2.getString("description")); 
               dt.setPrice(rs2.getFloat("price")); 
              dt.setPrice(rs2.getFloat("price"));
              dt.setMSRP(rs2.getString("MSRP"));
            }
            type.add(dt);
          }
        }
        db.close();
        rs.close();
      }
      else
      {
        System.out.println("inside 2");
        ResultSet rs = st.executeQuery("select * from Cartdetails where Ipaddress1='" + uid + "'");
        while (rs.next())
        {
          productDTO dt = new productDTO();
          dt.setCartID(rs.getInt("cid"));
          dt.setQty(rs.getInt("QTY"));
          dt.setColorandsize(rs.getString("colorandsize"));
          dt.setCookiesvalue(rs.getString("Ipaddress1"));
          dt.setPid(rs.getInt("productid"));
          dt.setChieldid(rs.getInt("chieldPID"));
          Statement st1 = db.dbconnect();
          Statement st2 = db.dbconnect();
          System.out.println("rs.getString-->" + rs.getString("chieldPID"));
          if (rs.getString("chieldPID") == null)
          {
            
            ResultSet rs1 = st1.executeQuery("select * from products where ProdID='" + rs.getInt("productid") + "'");
            if (rs1.next())
            {
              dt.setPid(rs.getInt("productid"));
              dt.setProduct_name(rs1.getString("description"));              
              dt.setWebnoteid(rs1.getString("WebNote")); 
              dt.setRebateprice(rs1.getFloat("RetailWebPrice"));               
              dt.setManufactModel(rs1.getString("ManufactModel"));
              dt.setPicturename(rs1.getString("picture"));
              dt.setFreeshipping(rs1.getString("FreeFreight"));
              dt.setOverweight(rs1.getString("OverWeight"));
              dt.setSKU(rs1.getString("SKU"));
              dt.setDescription(rs1.getString("description"));
              dt.setPrice(rs1.getFloat("price"));
              dt.setMSRP(rs1.getString("MSRP"));
            }
            type.add(dt);
          }
          else
          {
            ResultSet rs2 = st2.executeQuery("select * from products where ProdID='" + rs.getString("chieldPID") + "'");
            if (rs2.next())
            {
              dt.setPid(rs.getInt("productid"));
              
              dt.setProduct_name(rs2.getString("description"));
              dt.setWebnoteid(rs2.getString("WebNote")); 
              dt.setRebateprice(rs2.getFloat("RetailWebPrice")); 
              dt.setManufactModel(rs2.getString("ManufactModel"));
              dt.setPicturename(rs2.getString("picture"));
              dt.setFreeshipping(rs2.getString("FreeFreight"));
              dt.setOverweight(rs2.getString("OverWeight"));
              dt.setSKU(rs2.getString("SKU"));
              dt.setDescription(rs2.getString("description"));
              dt.setPrice(rs2.getFloat("price"));
              dt.setMSRP(rs2.getString("MSRP"));
            }
            type.add(dt);
          }
        }
        db.close();
        rs.close();
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public boolean deletecartdetails(String cid)
  {
    boolean b = false;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      st.executeUpdate("delete from Cartdetails where cid='" + cid + "'");
      b = true;
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public boolean updatecartdetails(String cid, String qty, String chieldPID, String coloransize, String bookingcode, String uid)
  {
    String code1 = null;
    if (uid == null) {
      code1 = bookingcode;
    } else {
      code1 = uid;
    }
    
    boolean b = false;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st3 = db.dbconnect();
      Statement st4 = db.dbconnect();
      Statement st5 = db.dbconnect();
      if (chieldPID.equals("NULL"))
      {
        st.executeUpdate("update Cartdetails set QTY='" + qty + "',colorandsize='" + coloransize + "'  where cid='" + cid + "'");
        b = true;
      }
      else
      {
        st.executeUpdate("update Cartdetails set QTY='" + qty + "',colorandsize='" + coloransize + "',chieldPID='" + chieldPID + "'  where cid='" + cid + "'");
        ResultSet rs = st3.executeQuery("select SUM(QTY) as qty from Cartdetails where chieldPID='" + chieldPID + "' and Ipaddress1='" + code1 + "'");
        if (rs.next())
        {
          st4.executeUpdate("update Cartdetails set QTY='" + rs.getString("qty") + "',colorandsize='" + coloransize + "',chieldPID='" + chieldPID + "'  where cid='" + cid + "'");
          st5.executeUpdate("delete from Cartdetails where chieldPID='" + chieldPID + "' and Ipaddress1='" + code1 + "' and cid <>'" + cid + "' ");
          b = true;
        }
        else
        {
          b = true;
        }
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public boolean checkproductstatus(String id, InetAddress ip)
  {
    boolean b = false;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select *  from Cartdetails where productid='" + id + "' and Ipaddress1='" + ip.getHostAddress() + "'");
      if (rs.next()) {
        b = true;
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public boolean checkproductstatusforchildprodd(String id, InetAddress ip, String chieldPID)
  {
    boolean b = false;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select *  from Cartdetails where productid='" + id + "' and chieldPID='" + chieldPID + "' and Ipaddress1='" + ip.getHostAddress() + "'");
      if (rs.next()) {
        b = true;
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public ArrayList getgetoffer(String coupancode, double prodTotalPrice, String totalPrice)
  {
     
    ArrayList details = new ArrayList();
    double value = 0.0D;
    double userpurchese = prodTotalPrice;
    double totalPrice2 = Double.parseDouble(totalPrice);
    try
    {
      productDTO dt = new productDTO();
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from Coupon where coupon_code='" + coupancode + "'");
      if (rs.next())
      {
        System.out.println("INSIDE RS.NEST");
        float minamr = rs.getFloat("min_amt");
        float offer = rs.getFloat("offer_amt");
        if (userpurchese > minamr)
        {
         
          value = totalPrice2 - offer;
          dt.setPrice(rs.getFloat("offer_amt"));
          dt.setMSRP(String.valueOf(value));
          dt.setAfterDiscount(String.valueOf(value));
          dt.setStatus("3");
        }
        else
        {
          
          value = totalPrice2;
          dt.setStatus("1");
          dt.setAfterDiscount(totalPrice);
        }
      }
      else
      {
        
        dt.setStatus("2");
        dt.setAfterDiscount(totalPrice);
      }
      details.add(dt);
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public int getcartitemscount(String bookingcode, String uid)
  {
    int count = 0;
    try
    {
      productDTO dt = new productDTO();
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = null;
      if (uid == null) {
        rs = st.executeQuery("select SUM(QTY) as countvalue from Cartdetails where Ipaddress1='" + bookingcode + "'");
      } else {
        rs = st.executeQuery("select SUM(QTY) as countvalue from Cartdetails where Ipaddress1='" + uid + "'");
      }
      if (rs.next()) {
        count = rs.getInt("countvalue");
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return count;
  }
  
  public boolean clearcartdetails(String bookingcode, String uid)
  {
    boolean b = false;
    try
    {
      productDTO dt = new productDTO();
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      if (uid == null)
      {
        st.executeUpdate("delete from Cartdetails where Ipaddress1='" + bookingcode + "'");
        b = true;
      }
      else
      {
        st.executeUpdate("delete from Cartdetails where Ipaddress1='" + uid + "'");
      }
      b = true;
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public boolean registeruser(String fname, String mname, String lname, String company, String address, String city, String postalcode, String state, String email, String phone, String subscription, String country, String province, String fax, String pwd)
  {
    boolean b = false;
    try
    {
      productDTO dt = new productDTO();
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      


      st.executeUpdate("insert into Customers (CustFN,CustMI,CustLN,CustCompanyName,CustAddr,CustCity,CustPostalCode,CustStateOrProvince,CustEmail,CustPhone,CustCountry,CustProvince,CustFax,Password,ShipName,ShipMName,ShipLName,ShipCompanyName,ShipAddress,ShipCity,ShipPostalCode,ShipStateOrProvince,ShipEmail,ShipPhoneNumber,ShipCountry,ShipProvince,ShipFax,UserType) values('" + 
      
        fname + "','" + mname + "','" + lname + "','" + company + "','" + address + "','" + city + "','" + postalcode + "','" + state + "','" + email + "','" + phone + "','" + country + "','" + province + "'" + 
        ",'" + fax + "','" + pwd + "','" + fname + "','" + mname + "','" + lname + "','" + company + "','" + address + "'" + 
        ",'" + city + "','" + postalcode + "','" + state + "','" + email + "','" + phone + "','" + country + "','" + province + "','" + fax + "','registeruser')");
      b = true;
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public ArrayList checkuser(String useremail, String pwd)
  {
    ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from  Customers where CustEmail='" + useremail + "' and Password='" + pwd + "' and UserType='registeruser'");
      if (rs.next())
      {
        userDTO dt = new userDTO();
        dt.setUid1(rs.getString("CustomerID"));
        dt.setEmail(rs.getString("CustEmail"));
        details.add(dt);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public ArrayList getuserdetails(String email)
  {
    ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from  Customers where CustEmail='" + email + "'");
      if (rs.next())
      {
        userDTO dt = new userDTO();
        dt.setUid(rs.getInt("CustomerID"));
        dt.setFname(rs.getString("CustFN"));
        dt.setMname(rs.getString("CustMI"));
        dt.setLname(rs.getString("CustLN"));
        dt.setCompany(rs.getString("CustCompanyName"));
        dt.setPhone(rs.getString("CustPhone"));
        dt.setEmail(rs.getString("CustEmail"));
        dt.setAddress(rs.getString("CustAddr"));
        dt.setCity(rs.getString("CustCity"));
        dt.setPostalcode(rs.getString("CustPostalCode"));
        dt.setProvince(rs.getString("CustStateOrProvince"));
        dt.setFax(rs.getString("CustFax"));
        dt.setState(rs.getString("CustStateOrProvince"));
        dt.setCountry(rs.getString("CustCountry"));
        details.add(dt);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public ArrayList getshippingdetails(String email)
  {
    ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from  Customers where CustEmail='" + email + "'");
      if (rs.next())
      {
        userDTO dt = new userDTO();
        dt.setUid(rs.getInt("CustomerID"));
        dt.setShip_fname(rs.getString("CustFN"));
        dt.setShip_mname(rs.getString("CustMI"));
        dt.setShip_lname(rs.getString("CustLN"));
        dt.setShip_company(rs.getString("CustCompanyName"));
        dt.setShip_address(rs.getString("CustAddr"));
        dt.setShip_email(rs.getString("CustEmail"));
        dt.setShip_city(rs.getString("CustCity"));
        dt.setShip_zipcode(rs.getString("CustPostalCode"));
        dt.setShip_fax(rs.getString("CustFax"));
        dt.setShip_phone(rs.getString("CustPhone"));
        dt.setShip_state(rs.getString("CustStateOrProvince"));
        dt.setShip_country(rs.getString("CustCountry"));
        

        details.add(dt);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public boolean registeruser1(String fname, String mname, String lname, String company, String address, String city, String postalcode, String state, String email, String phone, String subscription, String country, String province, String fax, String comment, String bookingcode)
  {
    boolean b = false;
    try
    {
      if (subscription == null) {
        subscription = subscription;
      } else {
        subscription = email;
      }
      productDTO dt = new productDTO();
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      st.executeUpdate("insert into GuestUserShippingDetails(f_name,m_name,l_name,Company,Address,City,State,Pincode,Country,Email,Phone," +
      		"ship_f_name,ship_m_name,ship_l_name,ship_Company,ship_Address,ship_City,ship_State,ship_Country," +
      		"ship_Pincode,ship_Email,ship_Phone,ship_ShipFax) values('" + fname + "','" + mname + "','" + lname + "','" + company + "','" + address + "','" + city + "','" + state + "','" + postalcode + "','" + country + "','" + email + "','" + phone + "'" +
      				",'" + fname + "','" + mname + "','" + lname + "','" + company + "','" + address + "','" + city + "'" +
      						",'" + state + "','" + country + "','" + postalcode + "','" + email + "','" + phone + "','" + fax + "')");
      

      b = true;
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public String getUIDforgeustuser(String email)
  {
    String uid = "null";
    try
    {
      productDTO dt = new productDTO();
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select UID from Customers where CustEmail='" + email + "'");
      if (rs.next()) {
        uid = rs.getString("CustomerID");
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return uid;
  }
  
  public boolean getupdate(String uid, String bookingcode)
  {
    boolean b = false;
    try
    {
      productDTO dt = new productDTO();
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      st.executeUpdate("update Cartdetails set Ipaddress1='" + uid + "' where Ipaddress1='" + bookingcode + "'");
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public ArrayList getgetallstate()
  {
    ArrayList state = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from State");
      while (rs.next())
      {
        userDTO dt = new userDTO();
        dt.setStateID(rs.getInt("StateID"));
        dt.setState(rs.getString("State"));
        state.add(dt);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return state;
  }
  
  public ArrayList getgetcountry()
  {
    ArrayList country = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from Country");
      while (rs.next())
      {
        userDTO dt = new userDTO();
        dt.setCountryID(rs.getInt("ID"));
        dt.setCountry(rs.getString("Country"));
        country.add(dt);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return country;
  }
  
  public String getuid(String email)
  {
    String uid = null;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      


      ResultSet rs = st.executeQuery("select * from Customers where CustEmail='" + email + "'");
      while (rs.next()) {
        uid = rs.getString("CustomerID");
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return uid;
  }
  
  public ArrayList getuserdetails1(String uid)
  {
    ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from  Customers where CustomerID='" + uid + "'");
      if (rs.next())
      {
        userDTO dt = new userDTO();
        
        dt.setUid(rs.getInt("CustomerID"));
        dt.setFname(rs.getString("CustFN"));
        dt.setMname(rs.getString("CustMI"));
        dt.setLname(rs.getString("CustLN"));
        dt.setCompany(rs.getString("CustCompanyName"));
        dt.setPhone(rs.getString("CustPhone"));
        dt.setEmail(rs.getString("CustEmail"));
        dt.setAddress(rs.getString("CustAddr"));
        dt.setCity(rs.getString("CustCity"));
        dt.setPostalcode(rs.getString("CustPostalCode"));
        dt.setProvince(rs.getString("CustStateOrProvince"));
        dt.setFax(rs.getString("CustFax"));
        dt.setState(rs.getString("CustStateOrProvince"));
        dt.setCountry(rs.getString("CustCountry"));
        details.add(dt);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public String getemail(String uid)
  {
    String email = null;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from Customers where CustomerID='" + uid + "'");
      while (rs.next()) {
        email = rs.getString("CustEmail");
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return email;
  }
  
  public String getstateabb(String state)
  {
    String taxrate = null;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select t.TaxRate from State as s, TaxRates as t where s.abbreviation=t.State and s.State='" + state + "'");
      while (rs.next()) {
        taxrate = rs.getString("TaxRate");
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return taxrate;
  }
  
  public boolean saveorder(ArrayList carddetails, int num, String bookingcode, String uid, String taxrate, String couponprice)
  {
    boolean b = false;
    
     String taxrate1;
     
    if (taxrate == null)
    {
       
      taxrate1 = "0";
    }
    else
    {
      
      taxrate1 = taxrate;
    }
    String couponprice1;
    
    if (couponprice.equals("null"))
    {
      
      couponprice1 = "0";
    }
    else
    {
      
      couponprice1 = couponprice;
    }
    try
    {
      int maxid = 0;
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      Statement st2 = db.dbconnect();
      Statement st3 = db.dbconnect();
      ResultSet rs = st.executeQuery("select max(OrderDetailID)as maxid from [Order Details]");
      if (rs.next())
      {
        maxid = rs.getInt("maxid");
        maxid++;
      }
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date date = new Date();
      
      int j = 1;
      for (int i = 0; i < carddetails.size(); i++)
      {
        productDTO dt = (productDTO)carddetails.get(i);
        
        ResultSet rs1 = st1.executeQuery("select * from products where ProdID='" + dt.getPid() + "'");
        if (rs1.next())
        {
          System.out.println("in side save order");
          st2.executeUpdate("insert into [Order Details] (RegisterID,OrderID,ProductID,Quantity,UnitPrice,DiscountType,Discount,BBCostOnOrder,SerialNumbID,OrdSalesTaxRate,Old_Quantity,MasterOrderDetailID,IsKit,KitPrice,CreatedBy,UpdatedBy,OrderDetailID_old,OverWeightCost,OverWeight,FreeFreight,Created_Date) values('" + 
            uid + "','" + num + "','" + dt.getPid() + "','" + dt.getQty() + "','" + rs1.getString("price") + "','0','" + Float.parseFloat(couponprice1) + "','" + rs1.getString("BBCost") + "','0','" + Float.parseFloat(taxrate1) + "','0','0','0','0','-1','-1','0','0','0','0','" + dateFormat.format(date) + "')");
        }
        maxid += j;
      }
      b = true;
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public ArrayList getorderdetails(String uid)
  {
    ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select DISTINCT OrderID,Created_Date from  [Order Details] where RegisterID='" + uid + "'");
      while (rs.next())
      {
        userDTO dt = new userDTO();
        dt.setOrderID(rs.getString("OrderID"));
        dt.setOrderdate(rs.getString("Created_Date"));
        details.add(dt);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public ArrayList viewproductorderwise(String orderid)
  {
    ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from   [Order Details] where OrderID='" + orderid + "'");
      while (rs.next())
      {
        productDTO dt = new productDTO();
        dt.setPid(rs.getInt("ProductID"));
        dt.setQty(rs.getInt("Quantity"));
        dt.setPrice(rs.getFloat("UnitPrice"));
        dt.setCookiesvalue(rs.getString("Discount"));
        dt.setOrderdate(rs.getString("Created_Date"));
        dt.setTax(rs.getFloat("OrdSalesTaxRate"));
        

        ResultSet rs1 = st1.executeQuery("select * from products where ProdID='" + rs.getInt("ProductID") + "'");
        if (rs1.next())
        {
          dt.setSKU(rs1.getString("SKU"));
          dt.setDescription(rs1.getString("description"));
          dt.setPicturename(rs1.getString("picture"));
        }
        details.add(dt);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public String getguid(String email)
  {
    String uid = null;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select MAX(ID) as ID from  GuestUserShippingDetails where Email='" + email + "'");
      while (rs.next()) {
        uid = rs.getString("ID");
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return uid;
  }
  
  public boolean updateshippingdetails(String guid, String fname, String mname, String lname, String company, String address, String city, String postalcode, String state, String email, String phone, String subscription, String country, String province, String fax, String comment, String bookingcode)
  {
    if (subscription == null) {
      subscription = subscription;
    } else {
      subscription = email;
    }
     
    boolean b = false;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      st.executeUpdate("update GuestUserShippingDetails set f_name='" + fname + "',m_name='" + mname + "',l_name='" + lname + "'," + 
        "Company='" + company + "',Address='" + address + "',City='" + city + "',Pincode='" + postalcode + "'" + 
        ",State='" + state + "',Email='" + email + "',Phone='" + phone + "'" + 
        ",Country='" + country + "',ShipFax='" + fax + "'  where ID='" + guid + "'");
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public boolean updatecarddetails(String guid, String bookingcode)
  {
    boolean b = false;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      st.executeUpdate("update Cartdetails set Ipaddress1='" + guid + "' where Ipaddress1='" + bookingcode + "'");
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public ArrayList getshippingvia(float totalprice, String shipviastate)
  {
    ArrayList details = new ArrayList();
     try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select sm.ShippingMethod,scz.ShippingCost from ShippingCostPerZone scz,State s,ShippingStateZones sz,[Shipping Methods] as sm where scz.Zone=sz.Zone and sz.State= s.abbreviation and s.State='" + shipviastate + "' and scz.ShippingType in (7,11,12) and scz.PurchasePriceLow<='" + totalprice + "' and scz.PurchasePriceHigh>='" + totalprice + "' and sm.ShippingMethodID=scz.ShippingType");
      while (rs.next())
      {
        productDTO dt = new productDTO();
        
        String shipmethod = rs.getString("ShippingMethod");
        String shipcost = rs.getString("ShippingCost");
        String value = shipmethod + "->" + shipcost;
        dt.setShipingchargeviastate(value);
        dt.setShippingcost(rs.getString("ShippingCost"));
        details.add(dt);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public ArrayList getuserdetailsforallreadylogin(String uid)
  {
      ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from  Customers where CustomerID='" + uid + "'");
      if (rs.next())
      {
        userDTO dt = new userDTO();
        
        dt.setUid(rs.getInt("CustomerID"));
        dt.setFname(rs.getString("CustFN"));
        dt.setMname(rs.getString("CustMI"));
        dt.setLname(rs.getString("CustLN"));
        dt.setCompany(rs.getString("CustCompanyName"));
        dt.setPhone(rs.getString("CustPhone"));
        dt.setEmail(rs.getString("CustEmail"));
        dt.setAddress(rs.getString("CustAddr"));
        dt.setCity(rs.getString("CustCity"));
        dt.setPostalcode(rs.getString("CustPostalCode"));
        dt.setProvince(rs.getString("CustStateOrProvince"));
        dt.setFax(rs.getString("CustFax"));
        dt.setState(rs.getString("CustStateOrProvince"));
        dt.setCountry(rs.getString("CustCountry"));
        details.add(dt);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public ArrayList getshippingdetailsforloginuser(String uid)
  {
    System.out.println("UID IN DAOIMPL---"+uid);
    ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      


      ResultSet rs = st.executeQuery("select * from  Customers where CustomerID='" + uid + "'");
      if (rs.next())
      {
        userDTO dt = new userDTO();
        dt.setUid(rs.getInt("CustomerID"));
        dt.setShip_fname(rs.getString("ShipName"));
        dt.setShip_mname(rs.getString("ShipMName"));
        dt.setShip_lname(rs.getString("ShipLName"));
        dt.setShip_company(rs.getString("ShipCompanyName"));
        dt.setShip_address(rs.getString("ShipAddress"));
        dt.setShip_email(rs.getString("ShipEmail"));
        dt.setShip_city(rs.getString("ShipCity"));
        dt.setShip_zipcode(rs.getString("ShipPostalCode"));
        dt.setShip_fax(rs.getString("ShipFax"));
        dt.setShip_phone(rs.getString("ShipPhoneNumber"));
        dt.setShip_state(rs.getString("ShipStateOrProvince"));
        dt.setShip_country(rs.getString("ShipCountry"));
        details.add(dt);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public boolean updateshippingdetails(String uid, String email, String fname, String mname, String lname, String company, String address, String city, String postalcode, String state, String country, String phone, String province, String fax, String comment)
  {
    if (province == null) {
      province = province;
    } else {
      province = email;
    }
    boolean b = false;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      st.executeUpdate("update Customers set ShipName='" + fname + "',ShipMName='" + mname + "',ShipLName='" + lname + "'," + 
        "ShipCompanyName='" + company + "',ShipAddress='" + address + "',ShipCity='" + city + "',ShipPostalCode='" + postalcode + "'" + 
        ",ShipStateOrProvince='" + state + "',ShipEmail='" + email + "',ShipPhoneNumber='" + phone + "'" + 
        ",ShipCountry='" + country + "',ShipFax='" + fax + "',WebMailLIst='" + province + "'  where CustomerID='" + uid + "'");
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public ArrayList getnavigation(String category, String cat, String val, String ven_id, String pro_id, String subcat_id)
  {
     
    ArrayList details = new ArrayList();
    if (val.equals("1"))
    {
      productDTO dt = new productDTO();
      dt.setCategoryname(cat);
      dt.setVal(val);
      details.add(dt);
    }
    if (val.equals("2"))
    {
        try
      {
        Dbconnect db = new Dbconnect();
        Statement st = db.dbconnect();
        ResultSet rs = st.executeQuery("select WebDisplayForNavType,SubCats,WebTypes from JohnWebNavType where WebDisplayForNavType='" + category + "'");
        while (rs.next())
        {
          productDTO dt = new productDTO();
          dt.setCategoryname(rs.getString("WebDisplayForNavType"));
          dt.setSubcatid(rs.getString("SubCats"));
          dt.setWebTypes(rs.getString("WebTypes"));
          dt.setCategoryname(category);
          
          dt.setSubcatname(cat);
          dt.setVal(val);
          details.add(dt);
        }
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
    }
    if (val.equals("3"))
    {
       try
      {
        Dbconnect db = new Dbconnect();
        Statement st = db.dbconnect();
        productDTO dt = new productDTO();
        ResultSet rs = st.executeQuery("select Vendor from Vendor where VendID='" + ven_id + "'");
        if (rs.next())
        {
          dt.setBrand(rs.getString("Vendor"));
          
          dt.setSubcatname(pro_id);
          dt.setVal(val);
        }
        Statement st1 = db.dbconnect();
        ResultSet rs1 = st.executeQuery("select WebDisplayForNavType,SubCats,WebTypes from JohnWebNavType where WebDisplayForNavType='" + cat + "'");
        while (rs1.next())
        {
          dt.setCategoryname(rs1.getString("WebDisplayForNavType"));
          dt.setWebTypes(rs1.getString("WebTypes"));
        }
        dt.setSubcatid(subcat_id);
        
        Statement st2 = db.dbconnect();
        ResultSet rs2 = st.executeQuery("select DISTINCT SubCatID from Subcategory where WebDisplay='" + pro_id + "'");
        if (rs2.next()) {
          dt.setSubcatid(rs2.getString("SubCatID"));
        }
        details.add(dt);
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
    }
    if (val.equals("4"))
    {
      productDTO dt = new productDTO();
      
      try
      {
        Dbconnect db = new Dbconnect();
        Statement st = db.dbconnect();
        Statement st1 = db.dbconnect();
        ResultSet rs = st.executeQuery("select Vendor from Vendor where VendID='" + ven_id + "'");
        if (rs.next()) {
          dt.setBrand(rs.getString("Vendor"));
        }
        ResultSet rs1 = st1.executeQuery("select WebDisplayForNavType,SubCats,WebTypes from JohnWebNavType where WebDisplayForNavType='" + cat + "'");
        if (rs1.next())
        {
          dt.setSubcatid(rs1.getString("SubCats"));
          dt.setWebTypes(rs1.getString("WebTypes"));
        }
        dt.setCategoryname(cat);
        dt.setVal(val);
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
      details.add(dt);
    }
    return details;
  }
  
  public ArrayList getcategorydetailsforviewmenu(String cat)
  {
     
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select WebDisplayForNavType,SubCats,WebTypes from JohnWebNavType where WebDisplayForNavType='" + cat + "' ");
      while (rs.next())
      {
        productDTO dt = new productDTO();
        dt.setCategoryname(rs.getString("WebDisplayForNavType"));
        dt.setSubcatid(rs.getString("SubCats"));
        
        dt.setWebTypes(rs.getString("WebTypes"));
        
          type.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public String getallsubcategoryID(String category)
  {
    String subcat = "";
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select SubCats from JohnWebNavType where WebDisplayForNavType='" + category + "'");
      if (rs.next()) {
        subcat = rs.getString("SubCats");
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return subcat;
  }
  
  public String getwebtypeid(String category)
  {
    String webtype = "";
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select WebTypes from JohnWebNavType where WebDisplayForNavType='" + category + "'");
      if (rs.next()) {
        webtype = rs.getString("WebTypes");
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return webtype;
  }
  
  public ArrayList getlistofsubcat(String pro_id)
  {
    ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from products where ProdID='" + pro_id + "'");
      if (rs.next())
      {
        productDTO dt = new productDTO();
        ResultSet rs1 = st1.executeQuery("select * from JohnWebNavType Where WebTypes like '%" + rs.getString("WebTypeID") + "%'");
        if (rs1.next())
        {
          dt.setSubcatid(rs1.getString("SubCats"));
          dt.setCategoryname(rs1.getString("WebDisplayForNavType"));
          dt.setWebTypes(rs1.getString("WebTypes"));
        }
        details.add(dt);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public ArrayList getpagetitledetails(String subcat_id)
  {
    ArrayList type = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select * from products");
      while (rs.next())
      {
        productDTO dt = new productDTO();
        dt.setId(rs.getInt("ProdID"));
        dt.setProduct_name(rs.getString("description"));
        dt.setPrice(rs.getFloat("BBCost"));
        dt.setManufactModel(rs.getString("ManufactModel"));
        dt.setPicturename(rs.getString("picture"));
        dt.setFreeshipping(rs.getString("FreeFreight"));
        dt.setOverweight(rs.getString("OverWeight"));
        type.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
  
  public String gettitle(String pro_id)
  {
    String title = "";
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select * from products where ProdID='" + pro_id + "'");
      if (rs.next()) {
        title = rs.getString("description");
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return title;
  }
  
  public String getdescriptions(String pro_id)
  {
    String title = "";
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select * from products where ProdID='" + pro_id + "'");
      if (rs.next()) {
        title = rs.getString("marketingdescription");
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return title;
  }
  
  public ArrayList getheaderdetails(String webtypesID)
  {
    ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select  * from JohnWebNavType where CAST(WebTypes as varchar(250)) like '" + webtypesID + "' ");
      if (rs.next())
      {
        productDTO dt = new productDTO();
        dt.setMetadescription(rs.getString("MetaDescription"));
        dt.setMetatitle(rs.getString("MetaTitle"));
        dt.setKeywords(rs.getString("MetaKeywords"));
        
       
        details.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public ArrayList getheaderdetailsforsubcategoryproduct(String subcat_id)
  {
    ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select * from Subcategory where SubCatID='" + subcat_id + "' ");
      if (rs.next())
      {
        productDTO dt = new productDTO();
        dt.setMetadescription(rs.getString("MetaDescription"));
        dt.setMetatitle(rs.getString("MetaTitle"));
        dt.setKeywords(rs.getString("MetaKeywords"));
        
       
        details.add(dt);
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public ArrayList viewmyprofile(String uid)
  {
    ArrayList details = new ArrayList();
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from  Customers where CustomerID='" + uid + "'");
      if (rs.next())
      {
        userDTO dt = new userDTO();
        
        dt.setUid(rs.getInt("CustomerID"));
        dt.setFname(rs.getString("CustFN"));
        dt.setMname(rs.getString("CustMI"));
        dt.setLname(rs.getString("CustLN"));
        dt.setCompany(rs.getString("CustCompanyName"));
        dt.setPhone(rs.getString("CustPhone"));
        dt.setEmail(rs.getString("CustEmail"));
        dt.setAddress(rs.getString("CustAddr"));
        dt.setCity(rs.getString("CustCity"));
        dt.setPostalcode(rs.getString("CustPostalCode"));
        dt.setProvince(rs.getString("CustStateOrProvince"));
        dt.setFax(rs.getString("CustFax"));
        dt.setState(rs.getString("CustStateOrProvince"));
        dt.setCountry(rs.getString("CustCountry"));
        details.add(dt);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return details;
  }
  
  public boolean updateuserprofile(String uid, String fname, String mname, String lname, String company, String address, String city, String postalcode, String state, String email, String country, String subscription, String phone, String province, String fax, String comment, String password)
  {
    System.out.println("in side update profile");
    boolean b = false;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      


      st.executeUpdate("update Customers set CustFN='" + fname + "'" + 
        ",CustMI='" + mname + "'" + 
        ",CustLN='" + lname + "'" + 
        ",CustCompanyName='" + company + "'" + 
        ",CustAddr='" + address + "'" + 
        ",CustCity='" + city + "'" + 
        ",CustPostalCode='" + postalcode + "'" + 
        ",CustStateOrProvince='" + state + "'" + 
        ",CustEmail='" + email + "'" + 
        ",CustPhone='" + phone + "'" + 
        ",CustCountry='" + country + "'" + 
        
        ",CustFax='" + fax + "'" + 
        ",Password='" + province + "'" + 
        ",ShipName='" + fname + "'" + 
        ",ShipMName='" + mname + "'" + 
        ",ShipLName='" + lname + "'" + 
        ",ShipCompanyName='" + company + "'" + 
        ",ShipAddress='" + address + "'" + 
        ",ShipCity='" + city + "'" + 
        ",ShipPostalCode='" + postalcode + "'" + 
        ",ShipStateOrProvince='" + state + "'" + 
        ",ShipEmail='" + email + "'" + 
        ",ShipPhoneNumber='" + phone + "'" + 
        ",ShipCountry='" + country + "'" + 
        
        ",ShipFax='" + fax + "'" + 
        
        " where CustomerID='" + uid + "'");
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public boolean deletecartdetailsafterpayments(String uid, String bookingcode)
  {
    boolean b = false;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      if (uid == null) {
        st.executeUpdate("delete from Cartdetails where Ipaddress1='" + bookingcode + "'");
      } else {
        st.executeUpdate("delete from Cartdetails where Ipaddress1='" + uid + "'");
      }
      b = true;
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public String getbrandname(String vid)
  {
    String bname = "";
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select * from Vendor where VendID='" + vid + "'");
      if (rs.next()) {
        bname = rs.getString("Vendor");
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return bname;
  }
  
  public boolean subscribeToEmail(String email)
  {
    boolean b = false;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st2 = db.dbconnect();
      Statement st3 = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select * from Customers where CustEmail='" + email + "'  ");
      ResultSet rs2 = st3.executeQuery("select * from Customers where WebMailLIst='" + email + "'");
      if (rs2.next()) {
        System.out.println("already subscribed");
      }
      if (rs.next()) {
        st2.executeUpdate("UPDATE Customers SET WebMailLIst='" + email + "' WHERE CustEmail='" + email + "'");
      } else {
        st2.executeUpdate("INSERT INTO Customers (WebMailLIst) VALUES ('" + email + "')");
      }
      db.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public String getsubcatlist(String navfocat)
  {
    String navsublist = "";
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select SubCats from JohnWebNavType where WebDisplayForNavType='" + navfocat + "'");
      while (rs.next()) {
        navsublist = rs.getString("SubCats");
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return navsublist;
  }
  
  public String getStateAbbrevation(String state)
  {
    String stateAbrevation = null;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select * from state where State='" + state + "'");
      while (rs.next()) {
        stateAbrevation = rs.getString("abbreviation");
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return stateAbrevation;
  }
  
  public float getTax(String stateAbbrevation)
  {
    float taxRate = 0.0F;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select * from TaxRates where State='" + stateAbbrevation + "'");
      if (rs.next()) {
        taxRate = rs.getFloat("TaxRate");
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return taxRate;
  }
  
  public boolean updateShipDetails(String fname, String lname, String address, String city, String postalcode, String uid, String state, String country)
  {
    boolean b = true;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      st.executeUpdate("UPDATE Customers SET CustFN='" + fname + "',CustLN='" + lname + "',CustAddr='" + address + "',CustCity='" + city + "',CustStateOrProvince='" + state + "',CustPostalCode='" + postalcode + "',CustCountry='" + country + "' WHERE CustomerID='" + uid + "'");
      
      db.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public boolean updateShipDetailsUnReg(String fname, String lname, String address, String city, String postalcode, String useremail,  String state, String country)
  {
    boolean b = true;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      st.executeUpdate("UPDATE GuestUserShippingDetails SET f_name='" + fname + "',l_name='" + lname + "',Address='" + address + "',City='" + city + "',Pincode='" + postalcode + "',State='" + state + "',Country='" + country + "' WHERE Email='" + useremail + "'");
      
      db.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return b;
  }
  
  public String getShipCost(String statename, double finalTotal)
  {
    String shipCost = "0";
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select sm.ShippingMethod,scz.ShippingCost from ShippingCostPerZone scz,State s,ShippingStateZones sz,[Shipping Methods] as sm where scz.Zone=sz.Zone and sz.State= s.abbreviation and s.State='" + statename + "' and scz.ShippingType in (7,11,12) and scz.PurchasePriceLow<='" + finalTotal + "' and scz.PurchasePriceHigh>='" + finalTotal + "' and sm.ShippingMethodID=scz.ShippingType ORDER BY ShippingCost ASC");
      if (rs.next()) {
        shipCost = rs.getString("ShippingCost");
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return shipCost;
  }
  
  public String getguestuid(String email)
  {
    String uid = "";
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select * from  Customers where CustEmail='" + email + "'");
      if (rs.next()) {
        uid = rs.getString("UID");
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return uid;
  }
  
  public String getsubcategory(String category)
  {
    String webtype = "";
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select SubCats from JohnWebNavType where WebDisplayForNavType='" + category + "'");
      if (rs.next()) {
        webtype = rs.getString("SubCats");
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return webtype;
  }

public float getminprice(String webtypesID, String subcatidd) {
    float oprice =0;
    float nprice =0;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
       //select   TOP 15  * from products as p,Vendor as v where p.VendID=v.VendID    and p.SubCatID IN ("+subcatidd+") and p.WebTypeID IN ("+id+") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='' ) and webposted = 'Yes'  order by  description
//      ResultSet rs = st.executeQuery("select * from products where ProdID in( select DISTINCT TOP 200  p.ProdID from products as p,Vendor as v where p.VendID=v.VendID  and p.SubCatID IN ("+subcatidd+") and p.WebTypeID IN ("+webtypesID+") " +
//      		"  and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='' )  and webposted = 'Yes') order by  description ");
    ResultSet rs = st.executeQuery("select   TOP 15  * from products as p,Vendor as v where p.VendID=v.VendID    and p.SubCatID IN ("+subcatidd+") and p.WebTypeID IN ("+webtypesID+") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='' ) and webposted = 'Yes'  order by  description ");
      while (rs.next())
      {
    	 
    	ArrayList colorandsize;
      	colorandsize=getcolorandsizedetails(rs.getString("ProdID")); 
      	if(colorandsize.isEmpty() && rs.getString("IsChildorParentorItem").trim().equals("1")) 
       	{
      		 
      	}
      	else
      	{
      		nprice=rs.getFloat("price"); 
      		if(oprice < nprice)
      		{
      			 
      		}
      		else
      		{
      			oprice=nprice;
      		} 
      	}  
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return oprice;
  }

public float getmaxprice(String webtypesID, String subcatidd) {
    float oprice =0;
    float nprice =0;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("select   TOP 15  * from products as p,Vendor as v where p.VendID=v.VendID    and p.SubCatID IN ("+subcatidd+") and p.WebTypeID IN ("+webtypesID+") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='' ) and webposted = 'Yes'  order by  description  ");
      while (rs.next())
      {
    	  ArrayList colorandsize;
        	colorandsize=getcolorandsizedetails(rs.getString("ProdID")); 
        	if(colorandsize.isEmpty() && rs.getString("IsChildorParentorItem").trim().equals("1")) 
         	{
        		 
        	}
        	else
        	{
        		nprice=rs.getFloat("price");
        		
        		if(oprice > nprice)
        		{
        			 
        		}
        		else
        		{
        			oprice=nprice;
        		}
        		
        		
        	}  
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return oprice;
  }
 

public float getminpriceFORSubcategoryproduct(String subcat_id, String webtypeID) {
    float type =0;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("SELECT TOP 50  MIN(price) minprice FROM products as p,Subcategory as s where  p.SubCatID=s.SubCatID and s.SubCatID='"+subcat_id+"' " +
      		" and CAST(p.WebTypeID as varchar(250)) IN ("+webtypeID+") " +
      		" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes' ");
      while (rs.next())
      {
    	  type=rs.getFloat("minprice"); 
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }

public float getmaxpriceFORSubcategoryproduct(String subcat_id, String webtypeID) {
    float type =0;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("SELECT TOP 50  MAX(price) minprice FROM products as p,Subcategory as s where  p.SubCatID=s.SubCatID and s.SubCatID='"+subcat_id+"' " +
      		" and CAST(p.WebTypeID as varchar(250)) IN ("+webtypeID+") " +
      		" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes' ");
      while (rs.next())
      {
    	  type=rs.getFloat("minprice"); 
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }
//

public float getminpriceFORCategoryAndVendors(String vid, String webtypes,
		String subCatID) {
	
 
	float type =0;
	if (subCatID.equals(""))
    {
		
	    try
	    {
	      Dbconnect db = new Dbconnect();
	      Statement st = db.dbconnect(); 
	      ResultSet rs = st.executeQuery("select TOP 50 MIN(price) minprice from products where  CAST(WebTypeID as varchar(250)) IN ("+webtypes+")" +
	      		" and VendID='"+vid+"' and webposted='Yes' " +	      		
	      		" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='')  ");
	      while (rs.next())
	      {
	    	  type=rs.getFloat("minprice"); 
	      }
	      db.close();
	      rs.close();
	    }
	    catch (Exception e)
	    {
	      System.out.println(e);
	    }
    }
	else
	{
		 
	    try
	    {
	      Dbconnect db = new Dbconnect();
	      Statement st = db.dbconnect(); 
	      ResultSet rs = st.executeQuery("select TOP 50 MIN(price) minprice from products where  CAST(WebTypeID as varchar(250))  IN (122) " +
	      		" and VendID='"+vid+"' and webposted='Yes' and SubCatID='"+subCatID+"' " +
	      		" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='')  " +
	      		" ");
	      while (rs.next())
	      {
	    	  type=rs.getFloat("minprice"); 
	      }
	      db.close();
	      rs.close();
	    }
	    catch (Exception e)
	    {
	      System.out.println(e);
	    }
	} 
    return type;
}

public float getmaxpriceFORCategoryAndVendors(String vid, String webtypes,
		String subCatID) {
	float type =0;
	if (subCatID.equals(""))
    {
		
	    try
	    {
	      Dbconnect db = new Dbconnect();
	      Statement st = db.dbconnect(); 
	      ResultSet rs = st.executeQuery("select TOP 50 MAX(price) minprice from products where  CAST(WebTypeID as varchar(250)) IN ("+webtypes+")" +
	      		" and VendID='"+vid+"' and webposted='Yes' " + 
	      		" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='')  ");
	      while (rs.next())
	      {
	    	  type=rs.getFloat("minprice"); 
	      }
	      db.close();
	      rs.close();
	    }
	    catch (Exception e)
	    {
	      System.out.println(e);
	    }
    }
	else
	{
		 
	    try
	    {
	      Dbconnect db = new Dbconnect();
	      Statement st = db.dbconnect(); 
	      ResultSet rs = st.executeQuery("select TOP 50 MAX(price) minprice from products where  CAST(WebTypeID as varchar(250))  IN ("+webtypes+") " +
	      		" and VendID='"+vid+"' and webposted='Yes' and SubCatID='"+subCatID+"' " +
	      		" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='')  " +
	      		" ");
	      while (rs.next())
	      {
	    	  type=rs.getFloat("minprice"); 
	      }
	      db.close();
	      rs.close();
	    }
	    catch (Exception e)
	    {
	      System.out.println(e);
	    }
	} 
    return type;
}

public float getminpriceFORSubcategoryproductbooleanvaluefalse(String vid,
		String webtypes, String parameter) {
	
	  
    float oprice =0;
    float nprice =0;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      
      ResultSet rs = st.executeQuery("SELECT * from products where ProdID IN( select DISTINCT TOP 5000 ProdID from products where  CAST(WebTypeID as varchar(250)) IN (" + webtypes + ") " +
        		" and webposted='Yes' and SubCatID IN ("+parameter+") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') ) and VendID='" + vid + "' order by  description");
      while (rs.next())
      {     
    	  ArrayList colorandsize;
        	colorandsize=getcolorandsizedetails(rs.getString("ProdID")); 
        	if(colorandsize.isEmpty() && rs.getString("IsChildorParentorItem").trim().equals("1")) 
         	{
        		 
        	}
        	else
        	{
        		nprice=rs.getFloat("price");
        		
        		if(oprice < nprice)
        		{
        			 
        		}
        		else
        		{
        			oprice=nprice;
        		} 
        	}  
      }
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return oprice;
  }

public float getmaxpriceFORSubcategoryproductbooleanvaluefalse(String vid,
		String webtypes, String parameter) {
	
	 
	 float oprice =0;
	    float nprice =0;
	    try
	    {
	      Dbconnect db = new Dbconnect();
	      Statement st = db.dbconnect();
	      
	      ResultSet rs = st.executeQuery("SELECT * from products where ProdID IN( select DISTINCT TOP 5000 ProdID from products where  CAST(WebTypeID as varchar(250)) IN (" + webtypes + ") " +
	        		" and webposted='Yes' and SubCatID IN ("+parameter+") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') ) and VendID='" + vid + "' order by  description");
	      while (rs.next())
	      {     
	    	  ArrayList colorandsize;
	        	colorandsize=getcolorandsizedetails(rs.getString("ProdID")); 
	        	if(colorandsize.isEmpty() && rs.getString("IsChildorParentorItem").trim().equals("1")) 
	         	{
	        		 
	        	}
	        	else
	        	{
	        		nprice=rs.getFloat("price");
	        		
	        		if(oprice > nprice)
	        		{
	        			 
	        		}
	        		else
	        		{
	        			oprice=nprice;
	        		} 
	        	}  
	      }
	      db.close();
	      rs.close();
	    }
	    catch (Exception e)
	    {
	      System.out.println(e);
	    }
	    return oprice;
  }

public ArrayList getshipdetails(String useremail, String uid)
{
	ArrayList details=new ArrayList();
	
	 System.out.println("INSIDE getshipdetails ----------------------<><>"+useremail+"------->"+uid);
	if(uid==null) 
	{
		 try
		    {
		      Dbconnect db = new Dbconnect();
		      Statement st = db.dbconnect();
		      ResultSet rs = st.executeQuery("select * from  GuestUserShippingDetails where Email='" +useremail+"'");
		      if (rs.next())
		      {
		        userDTO dt = new userDTO();
		        dt.setUid(rs.getInt("ID"));
		        dt.setFname(rs.getString("ship_f_name"));
		        dt.setMname(rs.getString("ship_m_name"));
		        dt.setLname(rs.getString("ship_l_name"));
		        dt.setCompany(rs.getString("ship_Company"));
		        dt.setPhone(rs.getString("ship_Phone"));
		        dt.setEmail(rs.getString("ship_Email"));
		        dt.setAddress(rs.getString("ship_Address"));
		        dt.setCity(rs.getString("ship_City"));
		        dt.setPostalcode(rs.getString("ship_Pincode")); 
		        dt.setFax(rs.getString("ship_ShipFax"));
		        dt.setState(rs.getString("ship_State"));
		        dt.setCountry(rs.getString("ship_Country"));
		        details.add(dt);
		      }
		    }
		    catch (Exception e)
		    {
		      System.out.println(e);
		    }
	}
	else
	{
		 try
		    {
		      Dbconnect db = new Dbconnect();
		      Statement st = db.dbconnect();
		      ResultSet rs = st.executeQuery("select * from  Customers where CustomerID='" + uid + "'");
		      if (rs.next())
		      {
		        userDTO dt = new userDTO();
		        dt.setUid(rs.getInt("CustomerID"));
		        dt.setFname(rs.getString("ShipName"));
		        dt.setMname(rs.getString("ShipMName"));
		        dt.setLname(rs.getString("ShipLName"));
		        dt.setCompany(rs.getString("ShipCompanyName"));
		        dt.setPhone(rs.getString("ShipPhoneNumber"));
		        dt.setEmail(rs.getString("ShipEmail"));
		        dt.setAddress(rs.getString("ShipAddress"));
		        dt.setCity(rs.getString("ShipCity"));
		        dt.setPostalcode(rs.getString("ShipPostalCode")); 
		        dt.setFax(rs.getString("ShipFax"));
		        dt.setState(rs.getString("ShipStateOrProvince"));
		        dt.setCountry(rs.getString("ShipCountry"));
		        details.add(dt);
		      }
		    }
		    catch (Exception e)
		    {
		      System.out.println(e);
		    }
	}
	return details;
}

public ArrayList getshippingdetailsGUESTUSER(String uid1) {
	ArrayList details=new ArrayList(); 
	try
	    {
	      Dbconnect db = new Dbconnect();
	      Statement st = db.dbconnect();
	      ResultSet rs = st.executeQuery("select * from  GuestUserShippingDetails where ID='" +uid1+"'");
	      if (rs.next())
	      {
	        userDTO dt = new userDTO();
	        dt.setUid(rs.getInt("ID"));
	        dt.setShip_fname(rs.getString("ship_f_name"));
	        dt.setShip_mname(rs.getString("ship_m_name"));
	        dt.setShip_lname(rs.getString("ship_l_name"));
	        dt.setShip_company(rs.getString("ship_Company"));
	        dt.setShip_phone(rs.getString("ship_Phone"));
	        dt.setShip_email(rs.getString("ship_Email"));
	        dt.setShip_address(rs.getString("ship_Address"));
	        dt.setShip_city(rs.getString("ship_City"));
	        dt.setShip_zipcode(rs.getString("ship_Pincode")); 
	        dt.setShip_fax(rs.getString("ship_ShipFax"));
	        dt.setShip_state(rs.getString("ship_State"));
	        dt.setShip_country(rs.getString("ship_Country"));
	        details.add(dt);
	      }
	    }
	    catch (Exception e)
	    {
	      System.out.println(e);
	    }
	 return details;
}

public ArrayList getbillengdetails(String useremail, String uid) 
{
	

	ArrayList details=new ArrayList();
	
	 
	if(uid==null)
	{
		 try
		    {
		      Dbconnect db = new Dbconnect();
		      Statement st = db.dbconnect();
		      ResultSet rs = st.executeQuery("select * from  GuestUserShippingDetails where Email='" +useremail+"'");
		      if (rs.next())
		      {
		        userDTO dt = new userDTO();
		        dt.setUid(rs.getInt("ID"));
		        dt.setFname(rs.getString("f_name"));
		        dt.setMname(rs.getString("m_name"));
		        dt.setLname(rs.getString("l_name"));
		        dt.setCompany(rs.getString("Company"));
		        dt.setPhone(rs.getString("Phone"));
		        dt.setEmail(rs.getString("Email"));
		        dt.setAddress(rs.getString("Address"));
		        dt.setCity(rs.getString("City"));
		        dt.setPostalcode(rs.getString("Pincode")); 
		        dt.setFax(rs.getString("ShipFax"));
		        dt.setState(rs.getString("State"));
		        dt.setCountry(rs.getString("Country"));
		        details.add(dt);
		      }
		    }
		    catch (Exception e)
		    {
		      System.out.println(e);
		    }
	}
	else
	{
		 try
		    {
		      Dbconnect db = new Dbconnect();
		      Statement st = db.dbconnect();
		      ResultSet rs = st.executeQuery("select * from  Customers where CustomerID='" + uid + "'");
		      if (rs.next())
		      {
		        userDTO dt = new userDTO();
		        dt.setUid(rs.getInt("CustomerID"));
		        dt.setFname(rs.getString("CustFN"));
		        dt.setMname(rs.getString("CustMI"));
		        dt.setLname(rs.getString("CustLN"));
		        dt.setCompany(rs.getString("CustCompanyName"));
		        dt.setPhone(rs.getString("CustPhone"));
		        dt.setEmail(rs.getString("CustEmail"));
		        dt.setAddress(rs.getString("CustAddr"));
		        dt.setCity(rs.getString("CustCity"));
		        dt.setPostalcode(rs.getString("CustPostalCode")); 
		        dt.setFax(rs.getString("CustFax"));
		        dt.setState(rs.getString("CustStateOrProvince"));
		        dt.setCountry(rs.getString("CustCountry"));
		        details.add(dt);
		      }
		    }
		    catch (Exception e)
		    {
		      System.out.println(e);
		    }
	}
	return details;

	
}

public boolean createTextFile(ArrayList carddetails, ArrayList shipdetails,
		ArrayList billengdetails, String parameter, String parameter2,
		String parameter3, String parameter4, String shipvia, double ototal, double txtamt, double cp, String shicp, int odid, double rbetprice) {	 
	 
	String paymentmode="";
	if(parameter.equals("1"))
	{
		paymentmode="Credit Card";
	}
	if(parameter.equals("3"))
	{
		paymentmode="Fax/Call Order In";
	}
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date(); 
	DateFormat dFormat = new SimpleDateFormat("HH:mm:ss a"); 
	Calendar cal = Calendar.getInstance(); 
	
	boolean b=false;
	String filename="D:/OrderDetails/Web-Order-"+odid+".txt";
	try 
	{ 
		ArrayList a1=new ArrayList();
		File file = new File(filename); 
		if (!file.exists()) 
		{
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.newLine();
		bw.newLine(); 
		bw.write("Web Order Number:  " +odid);
		bw.newLine(); 
		bw.write("Date:  " +dateFormat.format(date));
		bw.newLine();
		bw.write("Time:  " +dFormat.format(cal.getTime()));
		bw.newLine();
		bw.newLine();
		bw.write("Bill-To Address:");
		bw.newLine();		
		for (int i = 0; i < billengdetails.size(); i++)
	      {
			userDTO dt = (userDTO)billengdetails.get(i); 
			bw.write(" ");
			bw.write(dt.getFname());
			bw.write(" ");
	        bw.write(dt.getLname());
	        bw.newLine(); 
	        bw.write(" ");
	        bw.write(dt.getAddress());
	        bw.write(" ");
	        bw.newLine();
	        bw.write(" ");
	        bw.write(dt.getCity());
	        bw.write(" ");
	        bw.write(",");
	        bw.write(dt.getState());
	        bw.write("   ");
	        bw.write(" ");
	        bw.write(dt.getPostalcode());
	        bw.newLine();
	        bw.write(" ");
	        bw.write(dt.getCountry());
	        bw.newLine();
	        bw.write(" ");
	        bw.write("Ph:  " +dt.getPhone());
	        bw.newLine();
	        bw.write(" ");
	        bw.write(dt.getEmail());
	      } 
		 bw.newLine();
		 bw.newLine(); 
			bw.newLine();
			bw.write("Shipping-To Address:");
			bw.newLine();		
			for (int i = 0; i < shipdetails.size(); i++)
		      {
				userDTO dt = (userDTO)shipdetails.get(i); 
				bw.write(" ");
				bw.write(dt.getFname());
				bw.write(" ");
		        bw.write(dt.getLname());
		        bw.write(" ");
		        bw.newLine(); 
		        bw.write(" ");
		        bw.write(dt.getAddress());
		        bw.write(" ");
		        bw.newLine();
		        bw.write(" ");
		        bw.write(dt.getCity()); 
		        bw.write(",");
		        bw.write(" ");
		        bw.write(dt.getState());
		        bw.write("   ");
		        bw.write(dt.getPostalcode());
		        bw.newLine();
		        bw.write(" ");
		        bw.write(dt.getCountry());
		        bw.newLine();
		        bw.write(" ");
		        bw.write("Ph:  " +dt.getPhone());
		        bw.newLine();
		        bw.write(" ");
		        bw.write(dt.getEmail());
		      }
			   
			 bw.newLine();
			 bw.newLine();
		 
		 
		 bw.write("Payment:  "+paymentmode); 
		 bw.newLine();
		 bw.newLine(); 
		 if(parameter.equals("1")) 
		 {
		     String cardnumber=parameter2.replace(parameter2.substring(0,12), "************"); 
			 bw.write("	Card Number: "+cardnumber);
			 bw.newLine();
			 bw.write("	Card Expiration: "+parameter3+"/"+parameter4);
			 bw.newLine(); 
		 }
		 else
		 {
			 
		 }
		 bw.newLine();
		 bw.write("Item Details");
		 bw.newLine();
		 bw.write("========================================================================================================");
		 bw.newLine();
		 double carttotal=0;
		 for (int i = 0; i < carddetails.size(); i++)
	      {   
			 productDTO dt = (productDTO)carddetails.get(i);
			 bw.newLine();
			 bw.write("  Name:		"+dt.getDescription());
			 bw.newLine();
			 bw.write("  Sku#:		"+dt.getSKU());
			 bw.newLine();
			 bw.write("  Size/Color:	 "+dt.getColorandsize());
			 bw.newLine();
			 bw.write("  Quantity: "+dt.getQty());
			 bw.newLine();
			 bw.write("  Unit Price:	 $"+dt.getPrice());
			 bw.newLine();
			 bw.write("  Extended Price:$" +(dt.getPrice() * dt.getQty()));
			 bw.newLine();
			 carttotal=carttotal+(dt.getPrice() * dt.getQty());
	      }
		 bw.write("========================================================================================================"); 
		 bw.newLine();
		 DecimalFormat twoDForm = new DecimalFormat("#0.00");
		 bw.write("Subtotal: $"  +Double.parseDouble(twoDForm.format(((carttotal)))));
		 bw.newLine();
		 bw.write("Tax: $"  +txtamt);
		 bw.newLine();
		 bw.write("Shipping: $" +shicp +"("+shipvia+")"); 
		 bw.newLine(); 
		 if(rbetprice==0)
		 {
			System.out.println("NO REBET"); 
			ototal=(Double.parseDouble(twoDForm.format(((carttotal)))))+(Double.parseDouble(shicp)-txtamt);
		 }
		 else
		 {
			 bw.write("Rebet Total: $" +rbetprice); 
			 ototal=(Double.parseDouble(twoDForm.format(((carttotal)))))+(Double.parseDouble(shicp)-txtamt)-rbetprice; 
		 }
		 bw.newLine();
		 bw.write("Total: $" +Double.parseDouble(twoDForm.format(((ototal)))));
		 bw.newLine(); 
		bw.close(); 
		System.out.println("Done"); 
	} 
	catch (Exception e)
	{
		e.printStackTrace();
	} 
	return b;
}

public int countchildren(String pid) {
	int i=0; 
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      Statement st1 = db.dbconnect();
      String ColorID="";
       
      ResultSet rs=null; 
      int childcount=0;
      boolean b=false;
      ResultSet rs1= st1.executeQuery("select pc.ChildProdID,s.Size,c.Color,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c,Size as s where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid and p.SizeID=s.SizeID and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + pid + "'");
      if(rs1.next())
      {  
    	  rs= st.executeQuery("select pc.ChildProdID,s.Size,c.Color,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c,Size as s where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid and p.SizeID=s.SizeID and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + pid + "'");
          while (rs.next())
          {  
           i++;
          }
    	b=true; 
      }
       
      if(b==false)
      {
    	  
    	  rs= st.executeQuery("select pc.ChildProdID,c.Color,p.FreeFreight,p.OverWeight from products as p,[Products Children] pc ,Color as c where p.ProdID=pc.ChildProdID  and p.ColorID=c.colorid  and  ((upper(p.Discontinued) = 'YES' AND p.QtyAvailable > 0) or (upper(p.Discontinued) =  'NO')) and pc.ProdID='" + pid + "'");
          while (rs.next())
          {
            i++;
          } 
      } 
      //}
       
      db.close();
      rs.close();
       
    }
    catch (Exception e)
    {
      System.out.println(e);
    }  
	return i;
}

public ArrayList getgetbrandnameForCategory(String webtypesID, String subcatidd, ArrayList details) {
    ArrayList type = new ArrayList();
    long start = System.currentTimeMillis();
    
    HashMap<Integer, productDTO> venList = new HashMap<Integer, productDTO>();
    System.out.println("------------change 8---------");
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect(); 
      Statement st1 = db.dbconnect();
      
      String prodId = null;
      if (details.size() > 1) {
    	  productDTO prodto = (productDTO) details.get(details.size() - 1);
    	  prodId = prodto.getProdid();
    	 prodId = prodId.substring(0, prodId.length()-1);
    	 System.out.println("prodId---"+prodId);
	}
      
	//ResultSet rs = st.executeQuery("select   DISTINCT top 200  v.Vendor ,v.VendID,p.ProdID,p.IsChildorParentorItem from products as p,Vendor as v where p.VendID=v.VendID  and p.SubCatID IN (" + subcatidd + ") and p.WebTypeID IN (" + webtypesID + ") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes'");
      ResultSet rs = st.executeQuery("select   DISTINCT top 200  v.Vendor ,v.VendID,p.ProdID,p.IsChildorParentorItem from products as p,Vendor as v where p.VendID=v.VendID  and p.ProdID in ("+prodId+")");
     while (rs.next())
      {
    	int i=0;
    	int venId = rs.getInt("VendID");
    	productDTO dt = null; 
        /*StringBuffer sb=new StringBuffer("select ProdID,IsChildorParentorItem from products where ProdID in( select DISTINCT TOP 200  p.ProdID from products as p,Vendor as v where p.VendID=v.VendID" +
        		" and p.SubCatID IN ("+subcatidd+") and p.WebTypeID IN ("+webtypesID+") " +
        		" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='' )  and webposted = 'Yes') " +
        		" and VendID='"+rs.getInt("VendID")+"'");
        
        ResultSet rs1=st1.executeQuery(sb.toString()); 
       
        while(rs1.next())
       {*/
        	ArrayList colorandsize;
        	 long startcol = System.currentTimeMillis();
        	System.out.println("start color--"+start);
        	colorandsize=getcolorandsizedetails(rs.getString("ProdID")); 
        	long endcol = System.currentTimeMillis();
            System.out.println("total--"+(startcol-endcol));
        	 
        	if(colorandsize.isEmpty() && rs.getString("IsChildorParentorItem").trim().equals("1")) 
         	{
        		//System.out.println("emptyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        	}
        	else
        	{
        		
        		
        		if(venList.containsKey(venId)){ //loop
        			
        			dt = venList.get(venId);
        			int count = dt.getCoupan_id();
        			dt.setCoupan_id(count+1);
        			venList.put(venId, dt);

        			
        		} else{
        			//first
        			
        			dt = new productDTO();
        	        dt.setId(venId);
        	        dt.setBrand(rs.getString("Vendor"));
        	        dt.setCoupan_id(1);
        	        
        	        venList.put(venId, dt);
        		}
        		
        	} 
      // }  
       // System.out.println("VALUE OF I----------------->"+i); 
        
      }
      db.close();
      rs.close();
      
      //map to list
      System.out.println("size------"+venList.size());
      type.addAll(venList.values());
      
      long end = System.currentTimeMillis();
      System.out.println("total--"+(start-end));
      
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  }

public String getchieldid(String color) 
{
	 String val="";
	 String [] parts1 = color.split("<>");
	 String   color1 = parts1[0];
	 String  pid = parts1[1];
	try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect(); 
      Statement st1 = db.dbconnect();
      
    boolean b=false;
      ResultSet  rs = st.executeQuery("select pc.ChildProdID from products as p,[Products Children] pc ,Color as c " +
    	      		"where p.ProdID=pc.ChildProdID and p.ColorID=c.colorid   and  c.Color='"+color1+"' and pc.ProdID='"+pid+"'");
    	  if(rs.next())
          {
        	 val=rs.getString("ChildProdID");  
        	 b=true;
          }
     if(b==false)
     {
    	  ResultSet rs1 = st1.executeQuery("select pc.ChildProdID from products as p,[Products Children] pc ,Size c where p.ProdID=pc.ChildProdID and p.SizeID=c.SizeID   and  c.Size='"+color1+"' and pc.ProdID='"+pid+"'");
    	  if (rs1.next())
          {
        	  val=rs1.getString("ChildProdID"); 
          }
     } 
     
      db.close();
      rs.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
      e.printStackTrace();
    }
	
	
	return val;
}

public ArrayList getcartdetails1(String bookingcode, String uid) {
    ArrayList type = new ArrayList();
    

    
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      if (uid == null)
      {
        System.out.println("inside 1");
        ResultSet rs = st.executeQuery("select * from Cartdetails where Ipaddress1='" + bookingcode + "'");
        while (rs.next())
        {
          productDTO dt = new productDTO();
          dt.setCartID(rs.getInt("cid"));
          dt.setQty(rs.getInt("QTY"));
          dt.setCookiesvalue(rs.getString("Ipaddress1"));
          dt.setColorandsize(rs.getString("colorandsize"));
          dt.setPid(rs.getInt("productid"));
          dt.setChieldid(rs.getInt("chieldPID"));
          Statement st1 = db.dbconnect();
          Statement st2 = db.dbconnect();
          System.out.println("rs.getString-->" + rs.getString("chieldPID"));
          if (rs.getString("chieldPID") == null)
          {
           
            ResultSet rs1 = st1.executeQuery("select * from products where ProdID='" + rs.getInt("productid") + "'");
            if (rs1.next())
            {
              dt.setPid(rs.getInt("productid"));
              dt.setId(rs1.getInt("ProdID"));
              dt.setSubcatid(rs1.getString("SubCatID"));
              dt.setProduct_name(rs1.getString("description"));
              dt.setWebnoteid(rs1.getString("WebNote")); 
              dt.setRebateprice(rs1.getFloat("RetailWebPrice")); 
              dt.setManufactModel(rs1.getString("ManufactModel"));
              dt.setPicturename(rs1.getString("picture"));
              dt.setFreeshipping(rs1.getString("FreeFreight"));
              dt.setOverweight(rs1.getString("OverWeight"));
              dt.setSKU(rs1.getString("SKU"));
              dt.setDescription(rs1.getString("description"));  
              if(rs1.getString("WebNote").equals("15"))
              {
            	  dt.setPrice(rs1.getFloat("price")); 
            	  dt.setRebateprice(rs1.getFloat("RetailWebPrice"));
              }
              else
              {
            	  dt.setPrice(rs1.getFloat("price"));  
              }
              
              dt.setMSRP(rs1.getString("MSRP"));
            }
            type.add(dt);
          }
          else
          {
            ResultSet rs2 = st2.executeQuery("select * from products where ProdID='" + rs.getString("chieldPID") + "'");
            if (rs2.next())
            {
              dt.setPid(rs.getInt("productid"));
              
              dt.setId(rs2.getInt("ProdID"));
              dt.setSubcatid(rs2.getString("SubCatID"));
              dt.setProduct_name(rs2.getString("description"));
              dt.setWebnoteid(rs2.getString("WebNote")); 
              dt.setRebateprice(rs2.getFloat("RetailWebPrice")); 
              dt.setManufactModel(rs2.getString("ManufactModel"));
              dt.setPicturename(rs2.getString("picture"));
              dt.setFreeshipping(rs2.getString("FreeFreight"));
              dt.setOverweight(rs2.getString("OverWeight"));
              dt.setSKU(rs2.getString("SKU"));
              dt.setDescription(rs2.getString("description")); 
              
              if(rs2.getString("WebNote").equals("15"))
              {
            	  dt.setPrice(rs2.getFloat("RetailWebPrice")); 
              }
              else
              {
            	  dt.setPrice(rs2.getFloat("price"));  
              }
              
             
              dt.setPrice(rs2.getFloat("price"));
              dt.setMSRP(rs2.getString("MSRP"));
            }
            type.add(dt);
          }
        }
        db.close();
        rs.close();
      }
      else
      {
        System.out.println("inside 2");
        ResultSet rs = st.executeQuery("select * from Cartdetails where Ipaddress1='" + uid + "'");
        while (rs.next())
        {
          productDTO dt = new productDTO();
          dt.setCartID(rs.getInt("cid"));
          dt.setQty(rs.getInt("QTY"));
          dt.setColorandsize(rs.getString("colorandsize"));
          dt.setCookiesvalue(rs.getString("Ipaddress1"));
          dt.setPid(rs.getInt("productid"));
          dt.setChieldid(rs.getInt("chieldPID"));
          Statement st1 = db.dbconnect();
          Statement st2 = db.dbconnect();
          System.out.println("rs.getString-->" + rs.getString("chieldPID"));
          if (rs.getString("chieldPID") == null)
          {
            
            ResultSet rs1 = st1.executeQuery("select * from products where ProdID='" + rs.getInt("productid") + "'");
            if (rs1.next())
            {
              dt.setPid(rs.getInt("productid"));
              dt.setProduct_name(rs1.getString("description"));              
              dt.setWebnoteid(rs1.getString("WebNote")); 
              dt.setRebateprice(rs1.getFloat("RetailWebPrice"));               
              dt.setManufactModel(rs1.getString("ManufactModel"));
              dt.setPicturename(rs1.getString("picture"));
              dt.setFreeshipping(rs1.getString("FreeFreight"));
              dt.setOverweight(rs1.getString("OverWeight"));
              dt.setSKU(rs1.getString("SKU"));
              dt.setDescription(rs1.getString("description"));
               
              if(rs1.getString("WebNote").equals("15"))
              {
            	  dt.setPrice(rs1.getFloat("RetailWebPrice")); 
              }
              else
              {
            	  dt.setPrice(rs1.getFloat("price"));  
              }
              
              dt.setMSRP(rs1.getString("MSRP"));
            }
            type.add(dt);
          }
          else
          {
            ResultSet rs2 = st2.executeQuery("select * from products where ProdID='" + rs.getString("chieldPID") + "'");
            if (rs2.next())
            {
              dt.setPid(rs.getInt("productid"));
              
              dt.setProduct_name(rs2.getString("description"));
              dt.setWebnoteid(rs2.getString("WebNote")); 
              dt.setRebateprice(rs2.getFloat("RetailWebPrice")); 
              dt.setManufactModel(rs2.getString("ManufactModel"));
              dt.setPicturename(rs2.getString("picture"));
              dt.setFreeshipping(rs2.getString("FreeFreight"));
              dt.setOverweight(rs2.getString("OverWeight"));
              dt.setSKU(rs2.getString("SKU"));
              dt.setDescription(rs2.getString("description"));
              if(rs2.getString("WebNote").equals("15"))
              {
            	  dt.setPrice(rs2.getFloat("RetailWebPrice")); 
              }
              else
              {
            	  dt.setPrice(rs2.getFloat("price"));  
              }
              dt.setMSRP(rs2.getString("MSRP"));
            }
            type.add(dt);
          }
        }
        db.close();
        rs.close();
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return type;
  } 
public ArrayList getcartdetailsforcheckout(String bookingcode, String uid) {
	// TODO Auto-generated method stub
	return null;
}

public String getstateabbforpayment(String shipTo_state) {
    String state = null;
    try
    {
      Dbconnect db = new Dbconnect();
      Statement st = db.dbconnect();
      ResultSet rs = st.executeQuery("select abbreviation from State  where  State='"+shipTo_state+"'");
      while (rs.next()) {
    	  state = rs.getString("abbreviation");
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return state;}

public ArrayList getshipdetailswithUID(String uid) {
	// TODO Auto-generated method stub
	return null;
}

public String getradiobuttonvalue(String stateAbbrevation, double ft) 
{
		String state = null;
try
{
  Dbconnect db = new Dbconnect();
  Statement st = db.dbconnect();
  ResultSet rs = st.executeQuery("select sm.ShippingMethod,scz.ShippingCost from ShippingCostPerZone scz,State s,ShippingStateZones sz,[Shipping Methods] as sm where scz.Zone=sz.Zone and sz.State= s.abbreviation and s.State='"+stateAbbrevation+"' and scz.ShippingType in (11,12,7) and scz.PurchasePriceLow<='"+ft+"' and scz.PurchasePriceHigh>='"+ft+"' and sm.ShippingMethodID=scz.ShippingType ORDER BY ShippingCost ASC");
  while (rs.next()) 
  {    
	  state = rs.getString("ShippingCost")+","+rs.getString("ShippingMethod");
  }
}
catch (Exception e)
{
  System.out.println(e);
}
return state;
} 
}
