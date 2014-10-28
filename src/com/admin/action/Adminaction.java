package com.admin.action;

import com.cybersource.ws.client.Client;
import com.cybersource.ws.client.ClientException;
import com.cybersource.ws.client.FaultException;
import com.dbconnect.Dbconnect;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import validation.FieldValidationImplementedClass;
import validation.FieldValidationInterface;

 import  java.util.Random ;
import java.io.IOException ;
import java.security.GeneralSecurityException ;
import java.util.Properties ;
import java.util.UUID ;
import javax.crypto.Cipher ;
import javax.crypto.spec.SecretKeySpec ;
import javax.mail.BodyPart ;
import javax.mail.Message ;
import javax.mail.MessagingException ;
import javax.mail.Multipart ;
import javax.mail.PasswordAuthentication ;
import javax.mail.Session ;
import javax.mail.Transport ;
import javax.mail.internet.InternetAddress ;
import javax.mail.internet.MimeBodyPart ;
import javax.mail.internet.MimeMessage ;
import javax.mail.internet.MimeMultipart ;
import javax.servlet.RequestDispatcher ;
import javax.servlet.ServletException ;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ; 

public class Adminaction
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  adminDAO obj;
  int qty = 1;
  FieldValidationInterface val;
  Properties props = null;
  
  public void init()
    throws ServletException
  {
     obj = new adminDAOImpl();
     val = new FieldValidationImplementedClass();
    try
    {
      String path = getServletContext().getInitParameter("cybs");
      InputStream is = getServletContext().getResourceAsStream(path);
      try
      {
        this.props = new Properties();
        this.props.load(is);
      }
      finally
      {
        is.close();
      }
    }
    catch (Exception localException) {}
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    try {
		process(request, response);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    try {
		process(request, response);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  protected void process(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, ClassNotFoundException
  {
    HttpSession session = request.getSession(true);
    
    String uri1 = request.getRequestURI();
    
    String bb = request.getScheme() + "://" + 
      request.getServerName() + 
      ":" + 
      request.getServerPort() + 
      request.getRequestURI(); 
    
    String uri=uri1.replace("/bicyclebuys/", "/"); 
    
    System.out.println("FINAL URI->"+uri); 
    
    if (uri.equals("/errorlocation"))
    { 
      String link=request.getRealPath("link"); 
      System.out.println("INSIDE 404-->"+link);  
      response.sendRedirect(link);
      //response.sendRedirect("MainPageNotFound.jsp");
    }
    if (uri.equals("/Shipping"))
    {
      String uid = (String)session.getAttribute("uid");
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies == null) {
         
      } else {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            System.out.println("COOKIES AVAILABLE--->" + 
              cookies[i].getName());
            bookingcode = cookies[i].getValue();
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      
      RequestDispatcher rd = request.getRequestDispatcher("Shipping.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/Privacy-Policy"))
    {
      String uid = (String)session.getAttribute("uid");
      



      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies == null) {
        
      } else {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      


      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      RequestDispatcher rd = request.getRequestDispatcher("Privacy-Policy.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/store-info"))
    {
      String uid = (String)session.getAttribute("uid");
      



      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies == null) {
        
      } else {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      


      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      RequestDispatcher rd = request.getRequestDispatcher("store-info.jsp");
      rd.forward(request, response);
    }
    
    
     
    
    if (uri.equals("/makepayments1"))
    { 
      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      String uid = (String)session.getAttribute("uid");
      
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
            
          }
        }
      } 
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems)); 
      if (cartitems == 0)
      {
        request.setAttribute("error", "There is no Items in Cart");
        
        ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
        request.setAttribute("carddetails", carddetails);
        RequestDispatcher rd = request.getRequestDispatcher("viewShoppingCart.jsp");
        rd.forward(request, response);
      }
      
      else
      { 
      ArrayList error = new ArrayList();
      String fname = request.getParameter("fname");
      String lname = request.getParameter("lname");
      String address = request.getParameter("address");
      String city = request.getParameter("city");
      String postalcode = request.getParameter("postalcode");
      
      String state = request.getParameter("STATEPROVINCE");
      String country = request.getParameter("COUNTRY");
      
      
      String shipvia=request.getParameter("shipVIA");
      String useremail = request.getParameter("email");
      
      request.setAttribute("shipvia", shipvia); 
      
      String cardBrand=request.getParameter("cardBrand");
      
      request.setAttribute("lastdiv", "none");  
      ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
      ArrayList shipdetails,billengdetails;
      double ototal=(Double)session.getAttribute("finaltot");
      double txtamt=(Double)session.getAttribute("txtamt");
      double cp=(Double)session.getAttribute("couponprice");
      String shicp=(String)session.getAttribute("shipCost");
      int odid=(Integer)session.getAttribute("ORDERID");
      
      System.out.println("FUNAL TOTAL-->"+ototal); 
      System.out.println("FUNAL txtamt-->"+txtamt);
      System.out.println("FUNAL cp-->"+cp);
      System.out.println("FUNAL shicp-->"+shicp);
      
      double fvalue=ototal+txtamt+cp+Double.parseDouble(shicp);
      System.out.println("FINAL VALUE-->"+fvalue);  
      session.setAttribute("fvalue", fvalue);
      double rbetprice=(Double)session.getAttribute("reprice");
      boolean bool1;
      
      
      
       
      if (uid == null) 
      {
    	 if(fname.equals("") || lname.equals("") || address.equals("") || city.equals("") || postalcode.equals(""))
    	 {
    		System.out.println("No update"); 
    	 }
    	 else
    	 {
    		 //session.setAttribute("uid11", uid1);
    		 String uemail=(String)session.getAttribute("uid11");
    		 bool1 = this.obj.updateShipDetailsUnReg(fname, lname, address, city, postalcode, uemail,state,country); 
    		 session.removeAttribute("uid11");
    	 }
    	 
        shipdetails=obj.getshipdetails(useremail,uid);
        ArrayList shippingdetails=obj.getshipdetails(useremail,uid);
        billengdetails=obj.getbillengdetails(useremail,uid);
        request.setAttribute("shipdetails", shipdetails); 
        request.setAttribute("shippingdetails", shippingdetails);
        
        boolean b;
        b=obj.createTextFile(carddetails,shipdetails,billengdetails,request.getParameter("cardBrand"),request.getParameter("cardno"),request.getParameter("cardExpiryMonth"),request.getParameter("cardExpiryYear"),shipvia,ototal,txtamt,cp,shicp,odid,rbetprice);
        
        boolean e;
        e=sendemail(useremail,shipvia,fvalue,txtamt,cp,shicp,odid,carddetails,shipdetails,billengdetails,request.getParameter("cardBrand"),request.getParameter("cardno"),request.getParameter("cardExpiryMonth"),request.getParameter("cardExpiryYear"));
        request.setAttribute("errormessage", "Mail not sent successfully please check your email id or some network problems happen during send mail");
  		    
      } 
      else 
      {
    	 if(fname.equals("") || lname.equals("") || address.equals("") || city.equals("") || postalcode.equals(""))
     	 {
     		System.out.println("No update ootroertreyeyoxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"); 
     	 }
     	 else
     	 {
     		bool1 = this.obj.updateShipDetails(fname, lname, address, city, postalcode, uid,state,country); 
     	 } 
    	 
        shipdetails=obj.getshipdetails(useremail,uid); 
        billengdetails=obj.getbillengdetails(useremail,uid);
        request.setAttribute("shipdetails", shipdetails); 
        boolean b;
        b=obj.createTextFile(carddetails,shipdetails,billengdetails,request.getParameter("cardBrand"),request.getParameter("cardno"),request.getParameter("cardExpiryMonth"),request.getParameter("cardExpiryYear"),shipvia,ototal,txtamt,cp,shicp,odid,rbetprice);
        
        boolean e;
        e=sendemail(useremail,shipvia,fvalue,txtamt,cp,shicp,odid,carddetails,shipdetails,billengdetails,request.getParameter("cardBrand"),request.getParameter("cardno"),request.getParameter("cardExpiryMonth"),request.getParameter("cardExpiryYear"));
        request.setAttribute("shipdetails", shipdetails);
      } 
     
     
      if(cardBrand.equals("3"))
      {
    	  boolean b = this.obj.deletecartdetailsafterpayments(uid, bookingcode); 
          RequestDispatcher rd = request.getRequestDispatcher("successpayments.jsp");
          rd.forward(request, response);
      } 
      else
      {  
    	  String shipTo_firstName = "";
          String shipTo_lastName = "";
          String shipTo_street1 = "";
          String shipTo_city = "";
          String shipTo_state = "";
          String shipTo_postalCode = "";
          String shipTo_country = "";
          String cardnumber = "";
          String card_expirationMonth = "";
          String card_expirationYear = "";
          String item_0_unitPrice = ""; 
          String card_cvNumber=request.getParameter("first-name-field3");
          double ordertotal=(Double)session.getAttribute("fvalue");
          double fprice=0;
          DecimalFormat twoDForm = new DecimalFormat("#0.00");
          fprice = Double.parseDouble(twoDForm.format(ordertotal)); 
    	  for(Object o : shipdetails)
    	  {
    		 userDTO d = (userDTO)o;
        	 shipTo_firstName = d.getFname();
             shipTo_lastName = d.getLname();
             shipTo_street1 = d.getAddress();
             shipTo_city = d.getCity();
             shipTo_state = d.getState();
             shipTo_postalCode = d.getPostalcode();
             shipTo_country = "US";
             cardnumber = request.getParameter("cardno");
             card_expirationMonth = request.getParameter("cardExpiryMonth");
             card_expirationYear = request.getParameter("cardExpiryYear"); 
              item_0_unitPrice = String.valueOf(fprice);  
             //item_0_unitPrice = "0.01"; 
          } 
    	  
    	  String stateabb=obj.getstateabbforpayment(shipTo_state); 
    	  
    	  String requestID = runAuth(this.props, shipTo_firstName, shipTo_lastName, shipTo_street1, shipTo_city, stateabb, shipTo_postalCode, shipTo_country, 
            cardnumber, card_expirationMonth, card_expirationYear, item_0_unitPrice,billengdetails,card_cvNumber);
          System.out.println("requestID--" + requestID);
          
          if (requestID != null) 
          {  
        	runCapture(this.props, requestID,item_0_unitPrice); 
            boolean b = this.obj.deletecartdetailsafterpayments(uid, bookingcode); 
            
            session.removeAttribute("couponAmt");
            session.removeAttribute("finaltot");
            session.removeAttribute("taxrate");
            session.removeAttribute("shipCost");
            session.removeAttribute("shipMethod"); 
            
            int cartitems1 = this.obj.getcartitemscount(bookingcode, uid);
            request.setAttribute("cartitems", Integer.valueOf(cartitems1));
            
            RequestDispatcher rd = request.getRequestDispatcher("successpayments.jsp");
            rd.forward(request, response);
          }
          else
          { 
        	  System.out.println("Payment not success"); 
        	  request.setAttribute("errormessage", "There was an error processing your card:<br>Card declined. Please try again with another card or contact customer support.");
        	  
        	  if(uid==null)
        	  {
        		  request.setAttribute("error", "error");
        		  RequestDispatcher rd = request.getRequestDispatcher("guestregisteruser1");
                  rd.forward(request, response); 
        	  }
        	  else
        	  {
        		   
        		  request.setAttribute("error", "error");
        		  shipdetails=obj.getshippingdetailsforloginuser(uid);
        		  request.setAttribute("shippingdetails",shipdetails);
        		  RequestDispatcher rd = request.getRequestDispatcher("paymentgateway1");
                  rd.forward(request, response); 
        	  } 
          }  
        } 
      }  
  } 
	   
    
    if (uri.equals("/guestregisteruser1"))
    {
      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar); 
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
             
            bookingcode = cookies[i].getValue();
            
          }
        }
      }
      String uid = (String)session.getAttribute("uid");
      
      
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems)); 
      if (cartitems == 0)
      {
        request.setAttribute("error", "There is no Items in Cart");
        
        ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
        request.setAttribute("carddetails", carddetails);
        RequestDispatcher rd = request.getRequestDispatcher("viewShoppingCart.jsp");
        rd.forward(request, response);
      }
      
      else
      {   
      
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      
      ArrayList error = new ArrayList();
      String fname = request.getParameter("fname");
      String mname = request.getParameter("mname");
      String lname = request.getParameter("lname");
      String company = request.getParameter("company");
      String address = request.getParameter("address");
      String city = request.getParameter("city");
      String postalcode = request.getParameter("postalcode");
      String state = request.getParameter("STATEPROVINCE"); 
      String email = request.getParameter("email"); 
      String country = request.getParameter("COUNTRY");
      
      String phone = request.getParameter("phone");
      String Province = request.getParameter("Province");
      String fax = request.getParameter("fax");
      String comment = request.getParameter("comment"); 
      String radiovalue = request.getParameter("shipcost"); 
      String subscription = request.getParameter("subcription");
      
      request.setAttribute("radiovalue", radiovalue);
      System.out.println(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
      System.out.println("state-->"+state); 
      System.out.println("country-->"+country);
      System.out.println("radiovalue-->"+radiovalue);
      System.out.println("email-->"+email);
      request.setAttribute("statename", state);
      
      

      float taxRate=0;
      double ft=0;
      double calft=0;
      String stateAbbrevation = this.obj.getStateAbbrevation(state);
      System.out.println("stateAbbrevation-->"+stateAbbrevation);
      if(stateAbbrevation==null  )
      {
    	  System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@(((((((((((((((");
      }
      else
      {
    	    taxRate = this.obj.getTax(stateAbbrevation); 
            ft = ((Double)session.getAttribute("finaltot")).doubleValue(); 
            calft = 0.0D;
          if (taxRate == 0.0D)
          {
             
            request.setAttribute("taxRate", Double.valueOf(0.0D));
          }
          else
          {
            calft = ft * taxRate / 100.0D;
            request.setAttribute("taxRate", Float.valueOf(taxRate));
          }
          session.setAttribute("taxrate", Float.valueOf(taxRate));  
      }
     
      try
      {
        request.setAttribute("fdiv", "block");
        request.setAttribute("sdiv", "none");
        request.setAttribute("radiostatus", "checked"); 
        if(radiovalue==null || radiovalue.equals("null"))
        {
        	System.out.println("in side iffffffffffffffffffffffffffffffffffffffffffffffffffff");
        	request.setAttribute("radiovalue", null);
        	session.setAttribute("shipCost", "0");
 	        session.setAttribute("shipMethod", "You will be notified of the shipping costs after your order is placed.");
        }
        else
        {
        	System.out.println("in side eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        	String[] shipCostArray = radiovalue.split(",");
 	        String shipCost = shipCostArray[0];
 	        String shipMethod = shipCostArray[1]; 
 	        session.setAttribute("shipCost", shipCost);
 	        session.setAttribute("shipMethod", shipMethod);
        }
        
        
        Random generator = new Random();
        generator.setSeed(System.currentTimeMillis());
        
        int num = generator.nextInt(99999) + 99999;
        if ((num < 100000) || (num > 999999))
        {
          num = generator.nextInt(99999) + 99999;
          if ((num < 100000) || (num > 999999)) {
            throw new Exception(
              "Unable to generate PIN at this time..");
          }
        }
        System.out.println(num);
        session.setAttribute("ORDERID", num);
        String couponprice = String.valueOf(session.getAttribute("couponprice"));
      
        String uid1 = null;
        Dbconnect db = new Dbconnect();
        Statement st = db.dbconnect();
        String errorforpayment=(String)request.getAttribute("error");
        /*ResultSet rs = st.executeQuery("select * from GuestUserShippingDetails where Email='" + email + "'");
        if (rs.next())
        {
          uid1 = this.obj.getguid(email); 
          
          System.out.println("UIDDDDDDDDDDDDDDDDDDDDDDDDDDDD--->"+uid1); 
          
          if(errorforpayment==null)
          {
          boolean b = this.obj.updateshippingdetails(uid1, fname, mname, lname, 
            company, address, city, postalcode, state, 
            email, phone, subscription, country, Province, 
            fax, comment, bookingcode);
          }
          else
          {
        	  System.out.println("No update");
          } 
          request.setAttribute("orderID", Integer.valueOf(num));
          request.setAttribute("taxrate", Float.valueOf(taxRate));
          ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
          
          double total =0.0f;
          for(Object o : carddetails){
        	  productDTO d = (productDTO)o;
        	  
        	productDTO dt = (productDTO)o;
        	
           total = total +( dt.getPrice() * dt.getQty());
        	  session.setAttribute("finaltot", total);
        	System.out.println("----------------------------price in paymentgateway1---> "+d.getPrice());
          }
          String taxrate = String.valueOf(calft);
          
          boolean b1 = this.obj.saveorder(carddetails, num, bookingcode, uid1, 
            taxrate, couponprice);
          ArrayList shippingdetails = new ArrayList();
          
          shippingdetails = this.obj.getshippingdetailsGUESTUSER(uid1);
          
          request.setAttribute("shippingdetails", shippingdetails);
          session.setAttribute("carddetails", carddetails);
          request.setAttribute("carddetails", carddetails);
          session.setAttribute("num", Integer.valueOf(num));
        }*/
//        else
//        {
          boolean b = this.obj.registeruser1(fname, mname, lname, company, 
            address, city, postalcode, state, email, phone, 
            subscription, country, Province, fax, comment, 
            bookingcode); 

         // boolean b1 = this.obj.updateshippingdetails(uid, email, fname, mname, lname, company, address, city, postalcode, state, country, phone, Province, fax, comment);
          uid1 = this.obj.getguid(email);
          
          session.setAttribute("uid11", uid1);
          
          System.out.println("uid in serveletxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx ---> "+uid1);
          ArrayList shippingdetails = new ArrayList();
          shippingdetails = this.obj.getshippingdetailsGUESTUSER(uid1);
          request.setAttribute("shippingdetails", shippingdetails); 

          request.setAttribute("orderID", Integer.valueOf(num));
          request.setAttribute("taxrate", Float.valueOf(taxRate));
          ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
          
          double total =0.0f;
          for(Object o : carddetails){
        	  productDTO d = (productDTO)o;
        	  
        	productDTO dt = (productDTO)o;
        	
           total = total +( dt.getPrice() * dt.getQty());
        	  session.setAttribute("finaltot", total);
        	System.out.println("----------------------------price in paymentgateway1---> "+d.getPrice());
          }
          String taxrate = String.valueOf(calft);
          
          boolean b11 = this.obj.saveorder(carddetails, num, bookingcode, uid1, 
            taxrate, couponprice);
         
          session.setAttribute("carddetails", carddetails);
          session.setAttribute("num", Integer.valueOf(num));
          request.setAttribute("carddetails", carddetails);
       // }
      }
      catch (Exception e1)
      {
        System.out.println(e1);
      }
      ArrayList getallstate = this.obj.getgetallstate();
      ArrayList getcountry = this.obj.getgetcountry();
      request.setAttribute("getallstate", getallstate);
      request.setAttribute("getcountry", getcountry);
      RequestDispatcher rd = request.getRequestDispatcher("zuber.jsp");
      rd.forward(request, response);
    }
    }
    
    
    
    if (uri.equals("/registeruser"))
    {
      ArrayList error = new ArrayList();
      String fname = request.getParameter("fname");
      String mname = request.getParameter("mname");
      String lname = request.getParameter("lname");
      String company = request.getParameter("company");
      String address = request.getParameter("address");
      String city = request.getParameter("city");
      String postalcode = request.getParameter("postalcode");
      String state = request.getParameter("STATEPROVINCE");
      String email = request.getParameter("email");
      String country = request.getParameter("COUNTRY");
      String subscription = request.getParameter("subscription");
      String phone = request.getParameter("phone");
      String Province = request.getParameter("Province");
      String fax = request.getParameter("fax");
      String pwd = request.getParameter("pwd");
      
      userDTO dt = new userDTO();
      dt.setFname(fname);
      dt.setMname(mname);
      dt.setLname(lname);
      dt.setAddress(address);
      dt.setPhone(phone);
      dt.setFax(fax);
      dt.setCity(city);
      dt.setState(state);
      dt.setComment(pwd);
      dt.setCompany(company);
      dt.setCountry(country);
      dt.setEmail(email);
      dt.setPostalcode(postalcode);
      dt.setProvince(Province);
      
      int z = 0;
      boolean w = false;
      if ((fname.equals("")) || (lname.equals("")) || (address.equals("")) || 
        (postalcode.equals("")) || (email.equals("")) || 
        (phone.equals("")) || (city.equals("")) || (pwd.equals("")))
      {
        error.add("Star (*) marks field are mandatory");
        z++;
      }
      w = this.val.name(fname);
      if ((fname.equals("")) && (z == 0))
      {
        error.add("Enter Valid First Name");
        z++;
      }
      w = this.val.name(lname);
      if ((fname.equals("")) && (z == 0))
      {
        error.add("Enter Valid Last Name");
        z++;
      }
      w = this.val.address(address);
      if ((!w) && (z == 0))
      {
        z++;
        error.add("* Enter valid Address");
      }
      w = this.val.email(email);
      if ((!w) && (z == 0))
      {
        z++;
        error.add("* Enter valid Email Address");
      }
      w = this.val.mobile(phone);
      if ((!w) && (z == 0))
      {
        z++;
        error.add("* Enter valid Phone number");
      }
      try
      {
        Dbconnect db = new Dbconnect();
        Statement st = db.dbconnect();
        ResultSet rs = st
          .executeQuery("select * from Customers where CustEmail='" + 
          email + "'");
        if ((rs.next()) && (z == 0))
        {
          error.add("Email all ready Exist..!");
          z++;
        }
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
      String uid = (String)session.getAttribute("uid");
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
             
            bookingcode = cookies[i].getValue();
            
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      if (error.isEmpty())
      {
        boolean b = this.obj.registeruser(fname, mname, lname, company, address, 
          city, postalcode, state, email, phone, subscription, 
          country, Province, fax, pwd);
        

        String uid1 = null;
        
        ArrayList udetails = this.obj.checkuser(email, pwd);
        for (int i = 0; i < udetails.size(); i++)
        {
          userDTO dt1 = (userDTO)udetails.get(i);
          uid1 = dt1.getUid1();
          email = dt1.getEmail();
        }
        session.setAttribute("email", email);
        session.setAttribute("uid", uid1);
        
        
        boolean updatecart = this.obj.getupdate(uid1, bookingcode);
        


        ArrayList getallstate = this.obj.getgetallstate();
        ArrayList getcountry = this.obj.getgetcountry();
        request.setAttribute("getallstate", getallstate);
        request.setAttribute("getcountry", getcountry);
        request.setAttribute("success", 
          "You successfully Registered..!");
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
      }
      else
      {
        ArrayList getallstate = this.obj.getgetallstate();
        ArrayList getcountry = this.obj.getgetcountry();
        request.setAttribute("getallstate", getallstate);
        request.setAttribute("getcountry", getcountry);
        request.setAttribute("error", error);
        request.setAttribute("bean", dt);
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
      }
    }
    if (uri.equals("/getmyaccount"))
    {
      String uid = request.getParameter("uid");
      
      ArrayList orderdetails = this.obj.getorderdetails(uid);
      request.setAttribute("orderdetails", orderdetails);
      RequestDispatcher rd = request.getRequestDispatcher("myaccount.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/vieworderdetails"))
    {
      String uid = request.getParameter("uid");
      
      ArrayList orderdetails = this.obj.getorderdetails(uid);
      request.setAttribute("orderdetails", orderdetails);
      RequestDispatcher rd = request.getRequestDispatcher("orderdetails.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/viewproductorderwise"))
    {
      String orderid = request.getParameter("orderid");
      
      ArrayList viewproductorderwise = this.obj.viewproductorderwise(orderid);
      request.setAttribute("viewproductorderwise", viewproductorderwise);
      RequestDispatcher rd = request.getRequestDispatcher("viewproductorderwise.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/getmyprofile"))
    {
      ArrayList getallstate = this.obj.getgetallstate();
      ArrayList getcountry = this.obj.getgetcountry();
      request.setAttribute("getallstate", getallstate);
      request.setAttribute("getcountry", getcountry);
      
      String uid = request.getParameter("uid");
      
      ArrayList viewmyprofile = this.obj.viewmyprofile(uid);
      request.setAttribute("viewmyprofile", viewmyprofile);
      RequestDispatcher rd = request.getRequestDispatcher("viewmyprofile.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/updateprofile"))
    {
      String uid = request.getParameter("uid");
      String fname = request.getParameter("fname");
      String mname = request.getParameter("mname");
      String lname = request.getParameter("lname");
      String company = request.getParameter("company");
      String address = request.getParameter("address");
      String city = request.getParameter("city");
      String postalcode = request.getParameter("postalcode");
      String state = request.getParameter("STATEPROVINCE");
      String email = request.getParameter("email");
      String country = request.getParameter("COUNTRY");
      String subscription = request.getParameter("subscription");
      String phone = request.getParameter("phone");
      String Province = request.getParameter("Province");
      String fax = request.getParameter("fax");
      String comment = request.getParameter("comment");
      String password = request.getParameter("password");
      

      boolean b = this.obj.updateuserprofile(uid, fname, mname, lname, company, address, city, postalcode, state, email, country, subscription, phone, Province, fax, comment, password);
      



      ArrayList getallstate = this.obj.getgetallstate();
      ArrayList getcountry = this.obj.getgetcountry();
      request.setAttribute("getallstate", getallstate);
      request.setAttribute("getcountry", getcountry);
      


      ArrayList viewmyprofile = this.obj.viewmyprofile(uid);
      request.setAttribute("viewmyprofile", viewmyprofile);
      RequestDispatcher rd = request.getRequestDispatcher("viewmyprofile.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/loginuserg"))
    {
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
             
          }
        }
      }
      String useremail = request.getParameter("useremail123");
      String pwd = request.getParameter("pwd");
      
 

      int z = 0;
      boolean w = false;
      ArrayList error1 = new ArrayList();
      if ((useremail == null) || (pwd.equals("")))
      {
        error1.add("Star marks (*) field are mandatory");
        z++;
      }
      w = this.val.email(useremail);
      if ((!w) && (z == 0))
      {
        error1.add("* Enter valid Email Address");
        z++;
      }
      String uid = null;
      String email = null;
      ArrayList udetails = this.obj.checkuser(useremail, pwd);
      if ((udetails.isEmpty()) && (z == 0))
      {
        error1.add("Invalid Username or Password");
        z++;
      }
      else
      {
        for (int i = 0; i < udetails.size(); i++)
        {
          userDTO dt = (userDTO)udetails.get(i);
          uid = dt.getUid1();
          email = dt.getEmail();
        }
      }
      if (error1.isEmpty())
      {
        boolean updatecart = this.obj.getupdate(uid, bookingcode);
        
        ArrayList details = this.obj.getcategorydetails();
        
        ArrayList hotdeals = this.obj.gethotdeals();
        ArrayList newproduct = this.obj.getnewproduct();
        ArrayList promo = this.obj.getpromo();
        session.setAttribute("email", email);
        session.setAttribute("uid", uid);
        ArrayList specials = this.obj.getspecialsproduct();
        
        ArrayList coupandetails = this.obj.getcoupandetails();
        request.setAttribute("coupandetails", coupandetails);
        
        int cartitems = this.obj.getcartitemscount(bookingcode, uid);
        request.setAttribute("cartitems", Integer.valueOf(cartitems));
        
        request.setAttribute("specials", specials);
        request.setAttribute("newproduct", newproduct);
        request.setAttribute("details", details);
        request.setAttribute("hotdeals", hotdeals);
        request.setAttribute("promo", promo);
        
        RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
        rd.forward(request, response);
      }
      else
      {
        String uid1 = (String)session.getAttribute("uid");
        

        int cartitems = this.obj.getcartitemscount(bookingcode, uid1);
        request.setAttribute("cartitems", Integer.valueOf(cartitems));
        


        request.setAttribute("error1", error1);
        
        ArrayList getallstate = this.obj.getgetallstate();
        ArrayList getcountry = this.obj.getgetcountry();
        request.setAttribute("getallstate", getallstate);
        request.setAttribute("getcountry", getcountry);
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
      }
    }
    if (uri.equals("/userlogout"))
    {
      session.invalidate();
      String uid = null;
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
             
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      
      ArrayList details = this.obj.getcategorydetails();
      
      ArrayList hotdeals = this.obj.gethotdeals();
      ArrayList newproduct = this.obj.getnewproduct();
      ArrayList promo = this.obj.getpromo();
      ArrayList specials = this.obj.getspecialsproduct();
      
      ArrayList coupandetails = this.obj.getcoupandetails();
      request.setAttribute("coupandetails", coupandetails);
      
      request.setAttribute("specials", specials);
      request.setAttribute("newproduct", newproduct);
      request.setAttribute("details", details);
      request.setAttribute("hotdeals", hotdeals);
      request.setAttribute("promo", promo);
      
      RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
      rd.forward(request, response);
    }
    if(uri.equals("/indexpage"))
    { 
    	ArrayList menubar1 =obj.getcategorydetails();
        session.setAttribute("menubar1", menubar1);;
        request.setAttribute("details", menubar1);
//        
//        request.setAttribute("menubar", menubar1);
//        
    	
      String jd = getServletContext().getRealPath("/productimages");
      
      session.setAttribute("prodimagepath", jd);
      
      System.out.println("PRODUCT IMAGES PATH-->"+jd); 
      String uid = (String)session.getAttribute("uid");
      



      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies == null) {
         
      } else {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      ArrayList hotdeals = this.obj.gethotdeals();
      ArrayList colorandsize = new ArrayList();
      for (int i = 0; i < hotdeals.size(); i++)
      {
        productDTO dt = (productDTO)hotdeals.get(i);
        int id = dt.getId();
        colorandsize = this.obj.getcolorandsizedetails(String.valueOf(id));
      }
      request.setAttribute("colorandsize", colorandsize);
      ArrayList newproduct = this.obj.getnewproduct();
      ArrayList promo = this.obj.getpromo();
      ArrayList specials = this.obj.getspecialsproduct();
      ArrayList coupandetails = this.obj.getcoupandetails();
      request.setAttribute("coupandetails", coupandetails);
      request.setAttribute("specials", specials);
      request.setAttribute("newproduct", newproduct);
      //ArrayList details = this.obj.getcategorydetails();
      
      request.setAttribute("hotdeals", hotdeals);
      request.setAttribute("promo", promo);
      RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
      rd.forward(request, response);
    }
    
    
    if (uri.equals("/getcoupandetails"))
    {
      String couid = request.getParameter("couid");
      
      ArrayList coupandetails = this.obj.getcoupanwithproductdetails(couid);
      request.setAttribute("details", coupandetails);
      RequestDispatcher rd = request.getRequestDispatcher("searchdetails.jsp");
      rd.forward(request, response);
    } 
    
    if (uri.equals("/search"))
    {
      String searchvalue = request.getParameter("searchitem").trim();
      ArrayList details1 = this.obj.getsearchdetails(searchvalue);
      int totalcount = 0; 
      ArrayList newList = new ArrayList(new HashSet(details1));
      System.out.println("newListnewListnewListnewListnewList-->"+newList.size()); 
//      for (int i = 0; i < newList.size(); i++)
//      {
//        productDTO dt1 = (productDTO)newList.get(i); 
//        totalcount=dt1.getTotalproduct();
//        //totalcount++;
//      }
      
      request.setAttribute("totalcount", Integer.valueOf(newList.size()));
      request.setAttribute("details", newList);
      
      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      
      String uid = (String)session.getAttribute("uid");
      
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies == null) {
     
      } else {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      RequestDispatcher rd = request.getRequestDispatcher("searchdetails.jsp");
      rd.forward(request, response);
    }
    
    
    
    
    
    if (uri.equals("/testpaymentgateway"))
    {
      RequestDispatcher rd = request.getRequestDispatcher("zuber.jsp");
      rd.forward(request, response);
    }
    
    
    
    if (uri.equals("/Item"))
    {
      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);      
      String subcat_id = request.getParameter("subid");      
      String pro_id = request.getParameter("id");      
      request.setAttribute("subid", subcat_id);
      ArrayList listofsubcat = new ArrayList();;
      String subcats = "";
      String categoryforsub = "";
//      String webtypesID = "";
//      for (int i = 0; i < listofsubcat.size(); i++)
//      {
//        productDTO dt1 = (productDTO)listofsubcat.get(i);
//        subcats = dt1.getSubcatid();
//        categoryforsub = dt1.getCategoryname();
//        webtypesID = dt1.getWebTypes();
//      }
      
      request.setAttribute("categoryforsub", categoryforsub); 
      ArrayList getsubcategory = new ArrayList();;
      request.setAttribute("getsubcategory", getsubcategory); 
      ArrayList getbrandname = new ArrayList();
      request.setAttribute("getbrandname", getbrandname);
      
      String cat_id = null;
      String ven_id = null;
      String cat = null;
      String val = "4";
      

      ArrayList menunav = this.obj.getmenunav(cat_id, cat, subcat_id, ven_id, pro_id, 
        val);
      request.setAttribute("menunav", menunav);
      
      
      ArrayList details = new ArrayList();;
      ArrayList relatedproduct = this.obj.getrelatedproduct(subcat_id, pro_id);
      ArrayList details1 = this.obj.getproductdescription(pro_id);
      

      ArrayList homelink = this.obj.gethomelink1(pro_id, subcat_id);
      request.setAttribute("homelink", homelink);
      
      String productname = null;
      String productimage = null;
      String subcid = null;
      int p_id = 0;  
      String title = this.obj.gettitle(pro_id);
      request.setAttribute("metatitle", title);
      String descriptions = this.obj.getdescriptions(pro_id);
      request.setAttribute("metadescription", descriptions);
      




      String uid = (String)session.getAttribute("uid");
      if (uid == null) {
        
      }
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            bookingcode = cookies[i].getValue();
            
          }
        }
      }
       
      ArrayList previouslynew = (ArrayList)session.getAttribute("previously"); 
      if (previouslynew == null) 
      {
         
      } else 
      {
    	int pval=Integer.parseInt(pro_id);
    	int pid=0;
    	boolean b=false; 
    	for (int j = 0; j < previouslynew.size(); j++)
          {
        	 productDTO ue = (productDTO)previouslynew.get(j);
        	 pid=ue.getId();
        	 if(pid==pval)
        	 {
        		 b=true;
        	 }
          }  
    	if(b==true)
    	{
    		
    	}
    	else
    	{
        for (int i = 0; i < details1.size(); i++)
        {
          productDTO dt = (productDTO)details1.get(i);
          dt.getDescription();
          dt.getPicturename();
          dt.getSubcatid();
          dt.getId(); 
          previouslynew.add(dt); 
         }
    	}
      }  
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems)); 
      session.setAttribute("previously", previouslynew);
      ArrayList error=new ArrayList();
      request.setAttribute("error", error);
      request.setAttribute("details1", details1);
      request.setAttribute("details", details);
      request.setAttribute("relatedproduct", relatedproduct);
      RequestDispatcher rd = request.getRequestDispatcher("proddes.jsp");
      rd.forward(request, response);
    }
    
    
    
    if (uri.equals("/Category"))
    {
      session.removeAttribute("subcatidd");
      session.removeAttribute("webtypesID"); 
      request.setAttribute("filtval","1"); 
      String loop = "insidecategory";
      String webtypesID = request.getParameter("id");
      String cat = request.getParameter("cate");
      session.setAttribute("webtypesID", webtypesID);
      String subcatidd = request.getParameter("subcatid");
      session.setAttribute("subcatidd", subcatidd); 
      request.setAttribute("producttype", cat); 
      String val = "1";
      String subcat_id = null;
      String ven_id = null;
      String pro_id = null;
      session.setAttribute("categoryfornav", cat); 
      request.setAttribute("subcategory",subcatidd);
      String navforbrands = "1";
      request.setAttribute("navforbrands", navforbrands); 
      ArrayList menunav = this.obj.getmenunav(webtypesID, cat, subcat_id, ven_id, pro_id, val);
      request.setAttribute("menunav", menunav);
      session.setAttribute("loop", loop);
      ArrayList subcategorylist = null; 
      String navfocat = request.getParameter("navfocat");
      
      if (navfocat == null)
      {
        subcategorylist = this.obj.getsubcategorylist(subcatidd,webtypesID);
      }
      else if (navfocat.equals("3"))
      {
        String subcatlist = this.obj.getsubcatlist(cat);
        subcategorylist = this.obj.getsubcategorylist(subcatlist,webtypesID);
      }
      else
      {
        subcategorylist = this.obj.getsubcategorylist(subcatidd,webtypesID);
      }
     
      
      int pcount=0; 
     
     
      ArrayList details = this.obj.getcategorywiseproductdetails(webtypesID,pcount,subcatidd);
      
      
      
      ArrayList getbrandname = this.obj.getgetbrandnameForCategory(webtypesID, subcatidd,details);
   
      
      System.out.println("pcount-->"+pcount);  
    
        float minprice=0;
        float maxprice=0;
       int h=0;
       request.setAttribute("pcount", pcount);
        
       
      request.setAttribute("minprice", minprice);
      request.setAttribute("maxprice", maxprice);
      
      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      

      request.setAttribute("subcategorylist", subcategorylist);
      request.setAttribute("details", details);
      request.setAttribute("getbrandname", getbrandname);
      request.setAttribute("cat", cat);
      
      String uid = (String)session.getAttribute("uid");
      



      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
             
            bookingcode = cookies[i].getValue();
             
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems)); 

      request.setAttribute("category", cat); 

      ArrayList headerdetails = this.obj.getheaderdetails(webtypesID);
      request.setAttribute("headerdetails", headerdetails);
      
      String metadescription = "";
      String metatitle = "";
      String keywords = "";
      for (int i = 0; i < headerdetails.size(); i++)
      {
        productDTO dt = (productDTO)headerdetails.get(i);
        metadescription = dt.getMetadescription();
        metatitle = dt.getMetatitle();
        keywords = dt.getKeywords();
      }
      request.setAttribute("metadescription", metadescription);
      request.setAttribute("metatitle", metatitle);
      request.setAttribute("keywords", keywords); 
      
      RequestDispatcher rd = request.getRequestDispatcher("productdetails.jsp");
      rd.forward(request, response);  
    	
    	
    	/*session.removeAttribute("subcatidd");
        session.removeAttribute("webtypesID"); 
        request.setAttribute("filtval","1"); 
        String loop = "insidecategory";
        String webtypesID = request.getParameter("id");
        String cat = request.getParameter("cate");
        session.setAttribute("webtypesID", webtypesID);
        String subcatidd = request.getParameter("subcatid");
        session.setAttribute("subcatidd", subcatidd); 
        request.setAttribute("producttype", cat); 
        
        
        
        int pcount=120; 
       
       
       

 
        ArrayList details = this.obj.getcategorywiseproductdetails(webtypesID,pcount,subcatidd);

        request.setAttribute("details",details); 
 
        RequestDispatcher rd = request.getRequestDispatcher("xxx.jsp");
        rd.forward(request, response);
        */
        
    }
    

    if (uri.equals("/Sucategory"))
    {
      session.removeAttribute("webtypesID");
      session.removeAttribute("subcatidd");
      
      
      request.setAttribute("filtval","2");
      
      String loop = "insidesubcategory";
      session.setAttribute("loop", loop);
      
      String subcat_id = request.getParameter("id");
      String category = request.getParameter("category");
      String subidd = request.getParameter("subidd");
      String cat = request.getParameter("cate");
      

      session.setAttribute("formenubar", subidd);
      request.setAttribute("producttype", cat);
      
     
      String webtypeID = "";
      webtypeID = this.obj.getwebtypeid(category);
      
      String subcat = this.obj.getsubcategory(category);
      
      session.setAttribute("subcatidd", subcat);
    
      session.setAttribute("webtypesID", webtypeID); 
     
 

      String allsubcategoryID = this.obj.getallsubcategoryID(category);
      session.setAttribute("allsubcategoryID", allsubcategoryID);
      

      session.setAttribute("subidd", subidd);
      String val = "2";
      String cat_id = null;
      String ven_id = null;
      String pro_id = null; 
      ArrayList menunav = this.obj.getnavigation(category, cat, val, ven_id, pro_id, subcat_id);
      
      request.setAttribute("menunav", menunav); 
      ArrayList subcategorylist = this.obj.getsubcategorylist(allsubcategoryID,webtypeID); 
      ArrayList getbrandname = this.obj.getgetbrandnameforsubcategory(subcat_id, webtypeID);  
      int pcount=0;
      
      String statename = "";
      for (int i = 0; i < getbrandname.size(); i++)
      {
    	 productDTO ue = (productDTO)getbrandname.get(i);
         pcount =pcount+ ue.getCoupan_id(); 
      }
       
      request.setAttribute("pcount", pcount);

      ArrayList details = this.obj.getproductsubcategorywise(subcat_id, webtypeID,pcount);
      request.setAttribute("pcount",pcount);
      request.setAttribute("subcategory", subcat_id);

 
      
      request.setAttribute("getbrandname", getbrandname);
      request.setAttribute("subcategorylist", subcategorylist);
      request.setAttribute("cat", cat);
      request.setAttribute("details", details);
      
      String uid = (String)session.getAttribute("uid");
      if (uid == null) {
         
      }
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
             
            bookingcode = cookies[i].getValue();
           
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      

      request.setAttribute("category", category);
      


      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      


      ArrayList headerdetails = this.obj.getheaderdetailsforsubcategoryproduct(subcat_id);
      request.setAttribute("headerdetails", headerdetails);
      
      String metadescription = "";
      String metatitle = "";
      String keywords = "";
      for (int i = 0; i < headerdetails.size(); i++)
      {
        productDTO dt = (productDTO)headerdetails.get(i);
        metadescription = dt.getMetadescription();
        metatitle = dt.getMetatitle();
        keywords = dt.getKeywords();
      }
      request.setAttribute("metadescription", metadescription);
      request.setAttribute("metatitle", metatitle);
      request.setAttribute("keywords", keywords);
      

      RequestDispatcher rd = request.getRequestDispatcher("productdetails.jsp");
      rd.forward(request, response);
    } 
    
    
    /*
    if (uri.equals("/getproductsubcategorywise"))
    {
      session.removeAttribute("webtypesID");
      session.removeAttribute("subcatidd");
      
      
      request.setAttribute("filtval","2");
      
      String loop = "insidesubcategory";
      session.setAttribute("loop", loop);
      
      String subcat_id = request.getParameter("id");
      String category = request.getParameter("category");
      String subidd = request.getParameter("subidd");
      String cat = request.getParameter("cate");
      

      session.setAttribute("formenubar", subidd);
      request.setAttribute("producttype", cat);
      



      String webtypeID = "";
      webtypeID = this.obj.getwebtypeid(category);
      
      String subcat = this.obj.getsubcategory(category);
      
      session.setAttribute("subcatidd", subcat);
    
      session.setAttribute("webtypesID", webtypeID); 
     
 

      String allsubcategoryID = this.obj.getallsubcategoryID(category);
      session.setAttribute("allsubcategoryID", allsubcategoryID);
      

      session.setAttribute("subidd", subidd);
      String val = "2";
      String cat_id = null;
      String ven_id = null;
      String pro_id = null;
      



      ArrayList menunav = this.obj.getnavigation(category, cat, val, ven_id, pro_id, subcat_id);
      
      request.setAttribute("menunav", menunav);
      
      
      
      ArrayList subcategorylist = this.obj.getsubcategorylist(allsubcategoryID);
      

      ArrayList getbrandname = this.obj.getgetbrandnameforsubcategory(subcat_id, webtypeID); 

      int pcount=0;
      
      String statename = "";
      for (int i = 0; i < getbrandname.size(); i++)
      {
    	 productDTO ue = (productDTO)getbrandname.get(i);
         pcount =pcount+ ue.getCoupan_id(); 
      }
      
       
      ArrayList details = this.obj.getproductsubcategorywise(subcat_id, webtypeID,pcount);
      request.setAttribute("pcount",pcount);
      request.setAttribute("subcategory", subcat_id);

       float minprice=obj.getminpriceFORSubcategoryproduct(subcat_id,webtypeID);
       
       float maxprice=obj.getmaxpriceFORSubcategoryproduct(subcat_id,webtypeID);
       
      request.setAttribute("minprice", minprice);
      request.setAttribute("maxprice", maxprice);
      
      
      
      
      request.setAttribute("getbrandname", getbrandname);
      request.setAttribute("subcategorylist", subcategorylist);
      request.setAttribute("cat", cat);
      request.setAttribute("details", details);
      
      String uid = (String)session.getAttribute("uid");
      if (uid == null) {
         
      }
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
             
            bookingcode = cookies[i].getValue();
           
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      

      request.setAttribute("category", category);
      


      ArrayList menubar = this.obj.getcategorydetails();
      request.setAttribute("menubar", menubar);
      


      ArrayList headerdetails = this.obj.getheaderdetailsforsubcategoryproduct(subcat_id);
      request.setAttribute("headerdetails", headerdetails);
      
      String metadescription = "";
      String metatitle = "";
      String keywords = "";
      for (int i = 0; i < headerdetails.size(); i++)
      {
        productDTO dt = (productDTO)headerdetails.get(i);
        metadescription = dt.getMetadescription();
        metatitle = dt.getMetatitle();
        keywords = dt.getKeywords();
      }
      request.setAttribute("metadescription", metadescription);
      request.setAttribute("metatitle", metatitle);
      request.setAttribute("keywords", keywords);
      

      RequestDispatcher rd = request.getRequestDispatcher("productdetails.jsp");
      rd.forward(request, response);
    } 
    
    
    */
    String pro_id;
    
    if (uri.equals("/manufacturer"))
    { 	
      String loopval = (String)session.getAttribute("loop"); 
      String webtypes1 = request.getParameter("webtypeid"); 
      String webtypes = (String)session.getAttribute("webtypesID"); 
      String vid = request.getParameter("vid"); 
      String subcatidd = (String)session.getAttribute("subcatidd"); 
      String subCatID = request.getParameter("subcatid"); 
      String subcat_id1 = (String)session.getAttribute("allsubcategoryID");
      String cat = request.getParameter("cate"); 
      String brandname = this.obj.getbrandname(vid); 
      request.setAttribute("producttype", cat); 
      String subcategoryname = request.getParameter("subcategoryname"); 
      String subcat_id = request.getParameter("subcat_id"); 
      
      ArrayList menubar = new ArrayList();;
      request.setAttribute("menubar", menubar); 
      
      String uid = (String)session.getAttribute("uid");
      
      String pcount=request.getParameter("pcount");
      
      int pc=Integer.parseInt(pcount);
      
      request.setAttribute("pcount", pc);
      System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++---->"+pcount);
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies == null) {
         
      } else {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems)); 
     
      boolean b=false; 
      request.setAttribute("category", cat); 
      
      String navforbrands = request.getParameter("navforbrands");
      request.setAttribute("navforbrands", navforbrands);
      String val = null; 
      ArrayList getbrandname; 
      if (navforbrands == null)
      {
        String webtypes2 = "1";
        String subCatID2 = null;
        request.setAttribute("webtypes2", webtypes2);
        request.setAttribute("subCatID2", subCatID2);
        getbrandname = this.obj.getgetbrandname(webtypes2, subCatID2);
      }
      else if (navforbrands.equals("1"))
      {
    	  System.out.println("inside navtype 1--->"+webtypes+"subcategory->"+subcatidd); 
          getbrandname = this.obj.getgetbrandname(webtypes, subcatidd);
        val = "4";
      }
      else
      {
    	  System.out.println("inside navtype 1 else--->"+webtypes+"subcategory->"+subcatidd); 
        if (webtypes1.equals(""))
        {
          String webtypes2 = request.getParameter("webtypes2");
          String subCatID2 = request.getParameter("subCatID2");
          request.setAttribute("webtypes2", webtypes2);
          request.setAttribute("subCatID2", subCatID2);
          getbrandname = this.obj.getgetbrandname(webtypes2, subCatID2);
          b=true;
        }
        else
        {
          request.setAttribute("subCatID2", subCatID);
          request.setAttribute("webtypes2", webtypes1);
          getbrandname = this.obj.getgetbrandname(webtypes1, subCatID);
          
        }
        val = "3";
      }
      String cat_id = null;
      String ven_id = null;
      pro_id = null;
      String category = null;
      ArrayList subcategorylist=null;

      ArrayList menunav = this.obj.getnavigation(webtypes, cat, val, vid, subcategoryname, subcat_id);
      request.setAttribute("menunav", menunav); 
      ArrayList details;
      if(b==true)
      {
    	  
    	    request.setAttribute("filtval","4");
    	    details = this.obj.getproductdetailsBrandWise(vid, webtypes, request.getParameter("subCatID2"),subcatidd); 
//	  	    float minprice=obj.getminpriceFORSubcategoryproductbooleanvaluefalse(vid,webtypes,request.getParameter("subCatID2")); 
//	  	    float maxprice=obj.getmaxpriceFORSubcategoryproductbooleanvaluefalse(vid,webtypes,request.getParameter("subCatID2")); 
	  	   subcategorylist = this.obj.getsubcategorylist(subcatidd,webtypes); 
	  	  //  request.setAttribute("SubCategoryforCategoryAndVendors", request.getParameter("subCatID2")) ;
		   // request.setAttribute("VID", vid) ;
		   // request.setAttribute("VIDwebtypes", webtypes) ;
//	  	    request.setAttribute("minprice", minprice);
//	  	    request.setAttribute("maxprice", maxprice); 
	  	   request.setAttribute("subcategory", subcatidd) ;
	  	System.out.println("inside b==true-> "+request.getParameter("subCatID2")+"subcategory->"+subcatidd+"vid->"+vid+"webtypes->"+webtypes); 
      }
      else
      {
    	  	  	    
    	  request.setAttribute("filtval","3");
//  	      float minprice=obj.getminpriceFORCategoryAndVendors(vid,webtypes,subCatID);	       
//	      float maxprice=obj.getmaxpriceFORCategoryAndVendors(vid,webtypes,subCatID); 
//	      request.setAttribute("minprice", minprice);
//	      request.setAttribute("maxprice", maxprice);    
	     // request.setAttribute("SubCategoryforCategoryAndVendors", subCatID) ;
	     // request.setAttribute("VID", vid) ;
	     // request.setAttribute("VIDwebtypes", webtypes) ;
	        subcategorylist = this.obj.getsubcategorylist(subcatidd,webtypes); 
	      
    	  details = this.obj.getproductdetailsBrandWise(vid, webtypes, subCatID,subcatidd); 
    	  request.setAttribute("subcategory", subcatidd) ;
    	  System.out.println("inside b==true->  "+subCatID+"vid->"+vid+"webtypes->"+webtypes+"subcatidd->"+subcatidd); 
    	  
    	  	  	    
      }
      
    
   /* if (uri.equals("/getproductdetailsvenderwise"))
    {
    	
      String loopval = (String)session.getAttribute("loop");
      
      String webtypes1 = request.getParameter("webtypeid");
      


      String webtypes = (String)session.getAttribute("webtypesID");
      

      
      String vid = request.getParameter("vid");
      

      String subcatidd = (String)session.getAttribute("subcatidd");
      
      String subCatID = request.getParameter("subcatid");
      
      String subcat_id1 = (String)session.getAttribute("allsubcategoryID");
      String cat = request.getParameter("cate");
      



      String brandname = this.obj.getbrandname(vid);
      
      request.setAttribute("producttype", cat);
      

      String subcategoryname = request.getParameter("subcategoryname");
      
      String subcat_id = request.getParameter("subcat_id");
      


      ArrayList menubar = this.obj.getcategorydetails();
      request.setAttribute("menubar", menubar);
      



      String uid = (String)session.getAttribute("uid");
      
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies == null) {
         
      } else {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      

      request.setAttribute("pcount",0); 

      boolean b=false;

      request.setAttribute("category", cat);
      
      ArrayList subcategorylist = this.obj.getsubcategorylist(subcatidd);
      
      String navforbrands = request.getParameter("navforbrands");
      request.setAttribute("navforbrands", navforbrands);
      String val = null; 
      ArrayList getbrandname; 
      if (navforbrands == null)
      {
        String webtypes2 = "1";
        String subCatID2 = null;
        request.setAttribute("webtypes2", webtypes2);
        request.setAttribute("subCatID2", subCatID2);
        getbrandname = this.obj.getgetbrandname(webtypes2, subCatID2);
      }
      else if (navforbrands.equals("1"))
      {
          getbrandname = this.obj.getgetbrandname(webtypes, subcatidd);
        val = "4";
      }
      else
      {
           
        if (webtypes1.equals(""))
        {
          String webtypes2 = request.getParameter("webtypes2");
          String subCatID2 = request.getParameter("subCatID2");
          request.setAttribute("webtypes2", webtypes2);
          request.setAttribute("subCatID2", subCatID2);
          getbrandname = this.obj.getgetbrandname(webtypes2, subCatID2);
          b=true;
        }
        else
        {
          request.setAttribute("subCatID2", subCatID);
          request.setAttribute("webtypes2", webtypes1);
          getbrandname = this.obj.getgetbrandname(webtypes1, subCatID);
          
        }
        val = "3";
      }
      String cat_id = null;
      String ven_id = null;
      pro_id = null;
      String category = null;
      

      ArrayList menunav = this.obj.getnavigation(webtypes, cat, val, vid, subcategoryname, subcat_id);
      request.setAttribute("menunav", menunav); 
      ArrayList details;
      if(b==true)
      {
    	   request.setAttribute("filtval","4");
    	    details = this.obj.getproductdetailsBrandWise(vid, webtypes, request.getParameter("subCatID2"),subcatidd); 
	  	    float minprice=obj.getminpriceFORSubcategoryproductbooleanvaluefalse(vid,webtypes,request.getParameter("subCatID2")); 
	  	    float maxprice=obj.getmaxpriceFORSubcategoryproductbooleanvaluefalse(vid,webtypes,request.getParameter("subCatID2")); 
	  	    
	  	    request.setAttribute("SubCategoryforCategoryAndVendors", request.getParameter("subCatID2")) ;
		    request.setAttribute("VID", vid) ;
		    request.setAttribute("VIDwebtypes", webtypes) ;
	  	    request.setAttribute("minprice", minprice);
	  	    request.setAttribute("maxprice", maxprice); 
	  	  request.setAttribute("subcategory", subcatidd) ;
      }
      else
      {
    	  	  	    
    	  request.setAttribute("filtval","3");
  	      float minprice=obj.getminpriceFORCategoryAndVendors(vid,webtypes,subCatID);	       
	      float maxprice=obj.getmaxpriceFORCategoryAndVendors(vid,webtypes,subCatID); 
	      request.setAttribute("minprice", minprice);
	      request.setAttribute("maxprice", maxprice);    
	      request.setAttribute("SubCategoryforCategoryAndVendors", subCatID) ;
	      request.setAttribute("VID", vid) ;
	      request.setAttribute("VIDwebtypes", webtypes) ;
	      
	      
    	  details = this.obj.getproductdetailsBrandWise(vid, webtypes, subCatID,subcatidd); 
    	  request.setAttribute("subcategory", subcatidd) ;
    	  
    	  	  	    
      }
      
*/

      String fvalue = brandname + " " + cat;
      String title = this.obj.gettitle(pro_id);
      request.setAttribute("metatitle", fvalue);
      String descriptions = this.obj.getdescriptions(pro_id);
      request.setAttribute("metadescription", descriptions);

      request.setAttribute("details", details);
      request.setAttribute("subcategorylist", subcategorylist);
      request.setAttribute("getbrandname", getbrandname);
      request.setAttribute("cat", subcategoryname);
      
      RequestDispatcher rd = request.getRequestDispatcher("productdetails.jsp");
      rd.forward(request, response);
    }
    
    if (uri.equals("/admin.bicyclebuys"))
    {
      RequestDispatcher rd = request.getRequestDispatcher("admin/adminlogin.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/adminlogin"))
    {
      RequestDispatcher rd = request.getRequestDispatcher("admin/adminhome.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/categorydetails"))
    {
      RequestDispatcher rd = request.getRequestDispatcher("admin/categorydetails.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/productdetails"))
    {
      RequestDispatcher rd = request.getRequestDispatcher("admin/productdetails.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/addnewproduct"))
    {
      RequestDispatcher rd = request.getRequestDispatcher("admin/addnewproduct.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/addcategory"))
    {
      RequestDispatcher rd = request.getRequestDispatcher("admin/addcategory.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/addnewproduct"))
    {
      RequestDispatcher rd = request.getRequestDispatcher("admin/addcategory.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/checkoutcart"))
    {
      session.removeAttribute("aftDiscout");
      double cpr = 0.0D;
      session.setAttribute("couponprice", Double.valueOf(cpr));
      
      session.setAttribute("aftDiscout", "0");
      

      request.setAttribute("divdisplay", "none");
      String uid = (String)session.getAttribute("uid");
      
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
            
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      
      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      
      if (cartitems == 0)
      {
        request.setAttribute("error", "There is no Items in Cart");
        
        ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
        request.setAttribute("carddetails", carddetails);
        RequestDispatcher rd = request.getRequestDispatcher("viewShoppingCart.jsp");
        rd.forward(request, response);
      }
      else
      {
        ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
        request.setAttribute("carddetails", carddetails);
        
        double cartvalue = 0.0D;
        





        request.setAttribute("cartvalue", Double.valueOf(cartvalue));
        



        ArrayList getoffer = new ArrayList();
        
        request.setAttribute("afterdiscountfinaltotal", getoffer);
        
        ArrayList getallstate = this.obj.getgetallstate();
        ArrayList getcountry = this.obj.getgetcountry();
        request.setAttribute("getallstate", getallstate);
        request.setAttribute("getcountry", getcountry);
        

        ArrayList shippingdetails = new ArrayList();
        request.setAttribute("shippingdetails", shippingdetails);
        
        ArrayList userdetails = this.obj.getuserdetails1(uid);
        String statename = "";
        for (int i = 0; i < userdetails.size(); i++)
        {
          userDTO ue = (userDTO)userdetails.get(i);
          statename = ue.getState();
        }
        request.setAttribute("statename", statename);
        

        request.setAttribute("userdetails", userdetails);
        if (uid == null)
        {
          double total = 0.0D;
          double finalTotal = 0.0D;
          for (Object o : carddetails)
          {
            productDTO dt = (productDTO)o;
            total += dt.getPrice() * dt.getQty();
          }
          DecimalFormat twoDForm = new DecimalFormat("#0.00");
          finalTotal = Double.parseDouble(twoDForm.format(total));
          
         
          session.setAttribute("finaltot", Double.valueOf(finalTotal));
          request.setAttribute("afinalTotal", Double.valueOf(finalTotal));
        }
        else
        {
          double total = 0.0D;
          double finalTotal = 0.0D;
          for (Object o : carddetails)
          {
            productDTO dt = (productDTO)o;
            total += dt.getPrice() * dt.getQty();
          }
          DecimalFormat twoDForm = new DecimalFormat("#0.00");
          finalTotal = Double.parseDouble(twoDForm.format(total));
          
         
          session.setAttribute("finaltot", Double.valueOf(finalTotal));
          request.setAttribute("afinalTotal", Double.valueOf(finalTotal));
          





          String sc = this.obj.getShipCost(statename, finalTotal);
          double scd = Double.parseDouble(sc);
          double shipCost = Double.parseDouble(twoDForm.format(scd));
          finalTotal += shipCost;
          request.setAttribute("shipCost", Double.valueOf(shipCost));
          







          String getemail = this.obj.getemail(uid);
          request.setAttribute("email", getemail);
          shippingdetails = this.obj.getshippingdetails(getemail);
          request.setAttribute("shippingdetails", shippingdetails);
        }
        RequestDispatcher rd = request.getRequestDispatcher("checkoutdetails.jsp");
        rd.forward(request, response);
      }
    }
    if (uri.equals("/registerorlogin"))
    {
      ArrayList getallstate = this.obj.getgetallstate();
      ArrayList getcountry = this.obj.getgetcountry();
      request.setAttribute("getallstate", getallstate);
      request.setAttribute("getcountry", getcountry);
      

      String uid = (String)session.getAttribute("uid");
      
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies == null) {
        
      } else {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
             
            bookingcode = cookies[i].getValue();
          }
        }
      }
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      

      RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
      rd.forward(request, response);
    } 
    
    if (uri.equals("/paymentgateway1"))
    {
      
    	ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      
      String email = request.getParameter("email");
      
      String bookingcode = "";
      String cookieName = "BICYCLE";
      
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
             
            bookingcode = cookies[i].getValue();
             
          }
        }
      }
      String uid = (String)session.getAttribute("uid");
      

      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      
      ArrayList error = new ArrayList();
      String fname = request.getParameter("fname");
      String mname = request.getParameter("mname");
      String lname = request.getParameter("lname");
      String company = request.getParameter("company");
      String address = request.getParameter("address");
      String city = request.getParameter("city");
      String postalcode = request.getParameter("postalcode");
      String state = request.getParameter("STATEPROVINCE1");
      request.setAttribute("stateforship", state);
      
      String country = request.getParameter("COUNTRY1");
      
      String phone = request.getParameter("phone");
      String Province = request.getParameter("Province");
      String fax = request.getParameter("fax");
      String comment = request.getParameter("comment");
      request.setAttribute("statename", state);
      


      String Province1 = request.getParameter("subcription");
      
      String stateAbbrevation = this.obj.getStateAbbrevation(state);
      float taxRate = this.obj.getTax(stateAbbrevation);
      
      request.setAttribute("taxRate", Float.valueOf(taxRate));
      request.setAttribute("lastdiv", "none");
      
     
        request.setAttribute("fdiv", "block");
        request.setAttribute("sdiv", "none");
        request.setAttribute("radiostatus", "checked"); 
        String taxrate = this.obj.getstateabb(state);
        
        String radiovalue = request.getParameter("shipcost");
        
        request.setAttribute("radiovalue", radiovalue);
        
        if(radiovalue==null)
        {
        	request.setAttribute("radiovalue", "null");
        	session.setAttribute("shipCost", "0");
 	        session.setAttribute("shipMethod", "You will be notified of the shipping Type after your order is placed.");
        }
        else
        {
        	  String[] shipCostArray = radiovalue.split(",");
              String shipCost = shipCostArray[0];
              String shipMethod = shipCostArray[1]; 
              session.setAttribute("shipCost", shipCost);
              session.setAttribute("shipMethod", shipMethod); 
        }
        
        
       
      

        request.setAttribute("taxrate", taxrate);
        ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
        double total =0.0f;
        for(Object o : carddetails){
      	  productDTO d = (productDTO)o;
      	  
      	productDTO dt = (productDTO)o;
      	
         total = total +( dt.getPrice() * dt.getQty());
      	  session.setAttribute("finaltot", total);
      	System.out.println("----------------------------price in paymentgateway1---> "+d.getPrice());
        }
        request.setAttribute("carddetails", carddetails);
        try
        {
          Random generator = new Random();
          generator.setSeed(System.currentTimeMillis());
          
          int num = generator.nextInt(99999) + 99999;
          if ((num < 100000) || (num > 999999))
          {
            num = generator.nextInt(99999) + 99999;
            if ((num < 100000) || (num > 999999)) {
              throw new Exception(
                "Unable to generate PIN at this time..");
            }
          }
          
          String couponprice = String.valueOf(session
            .getAttribute("coupanprice"));
          
          boolean b = this.obj.saveorder(carddetails, num, bookingcode, uid, taxrate, 
            couponprice);
          request.setAttribute("orderID", Integer.valueOf(num));
          session.setAttribute("num", Integer.valueOf(num)); 
          session.setAttribute("ORDERID", Integer.valueOf(num));
          session.setAttribute("carddetails", carddetails);
          session.setAttribute("taxrate", taxrate);
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
        
        String errorforpayment=(String)request.getAttribute("error");
        if(errorforpayment==null)
        {
          boolean b1 = this.obj.updateshippingdetails(uid, email, fname, mname, lname, company, address, city, postalcode, state, country, phone, Province1, fax, comment);
        }
        else
        {
        	System.out.println("No update please");
        }

        ArrayList shippingdetails = new ArrayList();
        shippingdetails = obj.getshippingdetailsforloginuser(uid);
       
        System.out.println("(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((");
        request.setAttribute("shippingdetails", shippingdetails);
        

        ArrayList getallstate = this.obj.getgetallstate();
        ArrayList getcountry = this.obj.getgetcountry();
        request.setAttribute("getallstate", getallstate);
        request.setAttribute("getcountry", getcountry);
        
       

        ArrayList userdetails = this.obj.getuserdetails(email);
        request.setAttribute("userdetails", userdetails);
        String stateforshipping = request.getParameter("STATEPROVINCE1");
        request.setAttribute("stateforship", stateforshipping);
        RequestDispatcher rd = request.getRequestDispatcher("zuber.jsp");
        rd.forward(request, response);
       
      /*else
      {
        ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
        request.setAttribute("carddetails", carddetails);
        
        float cartvalue = 0.0F;
        





        request.setAttribute("cartvalue", Float.valueOf(cartvalue));
        



        ArrayList getoffer = new ArrayList();
        
        request.setAttribute("afterdiscountfinaltotal", getoffer);
        
        ArrayList getallstate = this.obj.getgetallstate();
        ArrayList getcountry = this.obj.getgetcountry();
        request.setAttribute("getallstate", getallstate);
        request.setAttribute("getcountry", getcountry);
        

        ArrayList shippingdetails = new ArrayList();
        request.setAttribute("shippingdetails", shippingdetails);
        
        ArrayList userdetails = this.obj.getuserdetails1(uid);
        String statename = "";
        for (int i = 0; i < userdetails.size(); i++)
        {
          userDTO ue = (userDTO)userdetails.get(i);
          statename = ue.getState();
        }
        request.setAttribute("statename", statename);
        

        request.setAttribute("userdetails", userdetails);
        if (uid != null)
        {
          String getemail = this.obj.getemail(uid);
          request.setAttribute("email", getemail);
          shippingdetails = this.obj.getshippingdetails(getemail);
          request.setAttribute("shippingdetails", shippingdetails);
        }
        RequestDispatcher rd = request.getRequestDispatcher("checkoutdetails.jsp");
        rd.forward(request, response);
      }*/
    }
    if (uri.equals("/paymentgateway"))
    {
      String email = request.getParameter("email");
      ArrayList error = new ArrayList();
      String fname = request.getParameter("fname");
      String mname = request.getParameter("mname");
      String lname = request.getParameter("lname");
      String company = request.getParameter("company");
      String address = request.getParameter("address");
      String city = request.getParameter("city");
      String postalcode = request.getParameter("postalcode");
      String state = request.getParameter("STATEPROVINCE1");
      request.setAttribute("stateforship", state);
      
      String country = request.getParameter("COUNTRY");
      String subscription = "novalue";
      String phone = request.getParameter("phone");
      String Province = request.getParameter("Province");
      String fax = request.getParameter("fax");
      String comment = request.getParameter("comment");
      
      String uid = (String)session.getAttribute("uid");
      

      boolean b1 = this.obj.updateshippingdetails(uid, email, fname, mname, lname, company, address, city, postalcode, state, country, phone, Province, fax, comment);
      
      ArrayList shippingdetails = new ArrayList();
      shippingdetails = this.obj.getshippingdetailsforloginuser(uid);
      request.setAttribute("shippingdetails", shippingdetails);
      




      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {   
            bookingcode = cookies[i].getValue(); 
          }
        }
      }
      
      String taxrate = this.obj.getstateabb(state);
      

      request.setAttribute("taxrate", taxrate);
      ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
      request.setAttribute("carddetails", carddetails);
      try
      {
        Random generator = new Random();
        generator.setSeed(System.currentTimeMillis());
        
        int num = generator.nextInt(99999) + 99999;
        if ((num < 100000) || (num > 999999))
        {
          num = generator.nextInt(99999) + 99999;
          if ((num < 100000) || (num > 999999)) {
            throw new Exception(
              "Unable to generate PIN at this time..");
          }
        }
        
        String couponprice = String.valueOf(session
          .getAttribute("coupanprice"));
        
        boolean b = this.obj.saveorder(carddetails, num, bookingcode, uid, taxrate, 
          couponprice);
        request.setAttribute("orderID", Integer.valueOf(num));
        session.setAttribute("num", Integer.valueOf(num));
        session.setAttribute("carddetails", carddetails);
        session.setAttribute("taxrate", taxrate);
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
      String stateforshipping = request.getParameter("STATEPROVINCE2");
      request.setAttribute("stateforship", stateforshipping);
      RequestDispatcher rd = request.getRequestDispatcher("zuber.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/makepaymentdetails"))
    {
      RequestDispatcher rd = request.getRequestDispatcher("makepaymentdetails.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/login1"))
    {
      session.removeAttribute("couponprice");
      session.removeAttribute("aftDiscout");
      
      double cpr = 0.0D;
      session.setAttribute("couponprice", Double.valueOf(cpr));
      
      session.setAttribute("aftDiscout", "0");
      

      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      

      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
            
          }
        }
      }
      String email = request.getParameter("email");
      String password = request.getParameter("pwd");
      

       
      ArrayList error = new ArrayList();
      int z = 0;
      boolean w = false;
      if ((email.equals("")) || (password.equals("")))
      {
        error.add("Star marks (*) field are mandatory");
        z++;
      }
      w = this.val.email(email);
      if ((!w) && (z == 0))
      {
        error.add("Enter valid email ID");
        z++;
      }
      String uid = null;
      String email1 = "";
      ArrayList udetails = this.obj.checkuser(email, password);
      for (int i = 0; i < udetails.size(); i++)
      {
        userDTO dt = (userDTO)udetails.get(i);
        uid = dt.getUid1();
        email1 = dt.getEmail();
        
        session.setAttribute("uid", uid);
      }
      if ((email1.equals("")) && (z == 0))
      {
        error.add("Invalid username or password");
        z++;
      }
      if (error.isEmpty())
      {
        ArrayList getallstate = this.obj.getgetallstate();
        ArrayList getcountry = this.obj.getgetcountry();
        request.setAttribute("getallstate", getallstate);
        request.setAttribute("getcountry", getcountry);
        

        request.setAttribute("divdisplay", "none");
        

        boolean updatecart = this.obj.getupdate(uid, bookingcode);
        
        session.setAttribute("email", email1);
        session.setAttribute("uid", uid);
        ArrayList shippingdetails = new ArrayList();
        
        request.setAttribute("shippingdetails", shippingdetails);
        ArrayList userdetails = this.obj.getuserdetails(email);
        request.setAttribute("userdetails", userdetails);
        request.setAttribute("email", email);
        
        ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
        request.setAttribute("carddetails", carddetails);
        
        double cartvalue = 0.0D;
        for (int i = 0; i < carddetails.size(); i++)
        {
          productDTO d = (productDTO)carddetails.get(i);
          cartvalue += d.getQty() * d.getPrice();
        }
        request.setAttribute("cartvalue", Double.valueOf(cartvalue));
        


        request.setAttribute("divlogin", "none");
        request.setAttribute("divreg", "block");
        request.setAttribute("userlogin", "0");
        
        shippingdetails = this.obj.getshippingdetails(email);
        request.setAttribute("shippingdetails", shippingdetails);
        



        String statename = "";
        for (int i = 0; i < userdetails.size(); i++)
        {
          userDTO ue = (userDTO)userdetails.get(i);
          statename = ue.getState();
        }
        request.setAttribute("statename", statename);
        



        double total = 0.0D;
        double finalTotal = 0.0D;
        


        DecimalFormat twoDForm = new DecimalFormat("#0.00");
        finalTotal = Double.parseDouble(twoDForm.format(cartvalue));
        
        
        session.setAttribute("finaltot", Double.valueOf(finalTotal));
        request.setAttribute("afinalTotal", Double.valueOf(finalTotal));
        





        String sc = this.obj.getShipCost(statename, finalTotal);
        double scd = Double.parseDouble(sc);
        double shipCost = Double.parseDouble(twoDForm.format(scd));
        finalTotal += shipCost;
        
        request.setAttribute("shipCost", Double.valueOf(shipCost));
        











        int cartitems = this.obj.getcartitemscount(bookingcode, uid);
        request.setAttribute("cartitems", Integer.valueOf(cartitems));
        

        RequestDispatcher rd = request.getRequestDispatcher("checkoutdetails.jsp");
        rd.forward(request, response);
      }
      else
      {
        request.setAttribute("errorlist", error);
        

        ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
        request.setAttribute("carddetails", carddetails);
        
        double cartvalue = 0.0D;
        





        request.setAttribute("cartvalue", Double.valueOf(cartvalue));
        



        ArrayList getoffer = new ArrayList();
        
        request.setAttribute("afterdiscountfinaltotal", getoffer);
        
        ArrayList getallstate = this.obj.getgetallstate();
        ArrayList getcountry = this.obj.getgetcountry();
        request.setAttribute("getallstate", getallstate);
        request.setAttribute("getcountry", getcountry);
        

        ArrayList shippingdetails = new ArrayList();
        request.setAttribute("shippingdetails", shippingdetails);
        
        ArrayList userdetails = this.obj.getuserdetails1(uid);
        String statename = "";
        for (int i = 0; i < userdetails.size(); i++)
        {
          userDTO ue = (userDTO)userdetails.get(i);
          statename = ue.getState();
        }
        request.setAttribute("statename", statename);
        

        request.setAttribute("userdetails", userdetails);
        if (uid != null)
        {
          String getemail = this.obj.getemail(uid);
          request.setAttribute("email", getemail);
          shippingdetails = this.obj.getshippingdetails(getemail);
          request.setAttribute("shippingdetails", shippingdetails);
        }
        RequestDispatcher rd = request.getRequestDispatcher("checkoutdetails.jsp");
        rd.forward(request, response);
      }
    }
    if (uri.equals("/getshippingaddress"))
    {
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
             
          }
        }
      }
      String radio = request.getParameter("radio");
      String email = request.getParameter("email");
      
       
      if (radio == null)
      {
        ArrayList shippingdetails = new ArrayList();
        request.setAttribute("shippingdetails", shippingdetails);
        
        ArrayList userdetails = this.obj.getuserdetails(email);
        request.setAttribute("userdetails", userdetails);
        request.setAttribute("email", email);
        String uid = (String)session.getAttribute("uid");
        ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
        request.setAttribute("carddetails", carddetails);
        
        request.setAttribute("radiostatus", "unchecked");
        request.setAttribute("divlogin", "none");
        request.setAttribute("divreg", "block");
        request.setAttribute("userlogin", "0");
        RequestDispatcher rd = request.getRequestDispatcher("checkoutdetails.jsp");
        rd.forward(request, response);
      }
      else
      {
        ArrayList getallstate = this.obj.getgetallstate();
        ArrayList getcountry = this.obj.getgetcountry();
        request.setAttribute("getallstate", getallstate);
        request.setAttribute("getcountry", getcountry);
        
        ArrayList shippingdetails = this.obj.getshippingdetails(email);
        
        request.setAttribute("shippingdetails", shippingdetails);
        
        request.setAttribute("radiostatus", "checked");
        
        ArrayList userdetails = this.obj.getuserdetails(email);
        request.setAttribute("userdetails", userdetails);
        request.setAttribute("email", email);
        String uid = (String)session.getAttribute("uid");
        ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
        request.setAttribute("carddetails", carddetails);
        
        request.setAttribute("divlogin", "none");
        request.setAttribute("divreg", "block");
        request.setAttribute("userlogin", "0");
        RequestDispatcher rd = request.getRequestDispatcher("checkoutdetails.jsp");
        rd.forward(request, response);
      }
    }
    if (uri.equals("/updatecart"))
    {
      String uid = (String)session.getAttribute("uid");
      String qty = request.getParameter("qtyforupdate");
      String colorandsize = request.getParameter("colorandsizeid");
      int z = 0;
      boolean w = false;
      ArrayList error = new ArrayList();
      if (qty.equals(""))
      {
        error.add("Enter Quentity");
        z++;
      }
      if ((qty.equals("0")) && (z == 0))
      {
        error.add("Quentity should not be less than 1");
        z++;
      }
      w = this.val.quantity(qty);
      if ((!w) && (z == 0))
      {
        z++;
        error.add("* Enter valid Quentity");
      }
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
             
          }
        }
      }
      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      if (error.isEmpty()) {
        try
        {
          
          String cid = request.getParameter("cartID");
          
          String[] parts = null;
          String coloransize = "";
          String chieldPID = "NULL";
          if (colorandsize == null)
          {
              
            boolean b = this.obj.updatecartdetails(cid, qty, chieldPID, 
              coloransize, bookingcode, uid);
            
            InetAddress ip = InetAddress.getLocalHost();
           

            ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
            request.setAttribute("carddetails", carddetails);
          }
          else
          {
            
            parts = colorandsize.split("<>");
            coloransize = parts[0];
            chieldPID = parts[1];
             
            
            boolean b = this.obj.updatecartdetails(cid, qty, chieldPID, 
              coloransize, bookingcode, uid);
            
            InetAddress ip = InetAddress.getLocalHost();
            
            

            ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
            request.setAttribute("carddetails", carddetails);
          }
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      } else {
        try
        {
           
          String cid = request.getParameter("cartID");
          
          String[] parts = null;
          String coloransize = "";
          String chieldPID = "NULL";
          if (colorandsize == null)
          {
             
            InetAddress ip = InetAddress.getLocalHost();
          

            ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
            request.setAttribute("carddetails", carddetails);
          }
          else
          {
            
            parts = colorandsize.split("<>");
            coloransize = parts[0];
            chieldPID = parts[1];
            

            InetAddress ip = InetAddress.getLocalHost();
            

            ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
            request.setAttribute("carddetails", carddetails);
          }
          request.setAttribute("error", error);
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }
      ArrayList afterdiscountfinaltotal = new ArrayList();
      request.setAttribute("afterdiscountfinaltotal", 
        afterdiscountfinaltotal);
      

      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      
      RequestDispatcher rd = request.getRequestDispatcher("viewShoppingCart.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/deletecartitemsaftercheckout"))
    {
      try
      {
        ArrayList menubar = new ArrayList();
        request.setAttribute("menubar", menubar);
        
        String uid = (String)session.getAttribute("uid");
        
        ArrayList getallstate = this.obj.getgetallstate();
        ArrayList getcountry = this.obj.getgetcountry();
        request.setAttribute("getallstate", getallstate);
        request.setAttribute("getcountry", getcountry);
        
        String bookingcode = "";
        String cookieName = "BICYCLE";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
          for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(cookieName))
            {
               
              bookingcode = cookies[i].getValue();
              
            }
          }
        }
        request.setAttribute("divdisplay", "none");
        String cid = request.getParameter("cid");
        

        boolean b = this.obj.deletecartdetails(cid);
        
        ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
        request.setAttribute("carddetails", carddetails);
        double cartvalue = 0.0D;
        request.setAttribute("cartvalue", Double.valueOf(cartvalue));
        ArrayList getoffer = new ArrayList();
        request.setAttribute("afterdiscountfinaltotal", getoffer);
        
        ArrayList shippingdetails = new ArrayList();
        request.setAttribute("shippingdetails", shippingdetails);
        ArrayList userdetails = this.obj.getuserdetails1(uid);
        String statename = "";
        for (int i = 0; i < userdetails.size(); i++)
        {
          userDTO ue = (userDTO)userdetails.get(i);
          statename = ue.getState();
        }
        request.setAttribute("statename", statename);
        

        request.setAttribute("userdetails", userdetails);
        

        String getemail = this.obj.getemail(uid);
        request.setAttribute("email", getemail);
        shippingdetails = this.obj.getshippingdetails(getemail);
        request.setAttribute("shippingdetails", shippingdetails);
        


        float totf = 0.0F;
        productDTO dt = new productDTO();
        for (int i = 0; i < carddetails.size(); i++)
        {
          dt = (productDTO)carddetails.get(i);
          float totp = dt.getQty() * dt.getPrice();
          totf += totp;
        }
        
        String totalprice = String.valueOf(totf);
        session.setAttribute("totalprice", totalprice);
        if (uid == null)
        {
          double total = 0.0D;
          double finalTotal = 0.0D;
          
          DecimalFormat twoDForm = new DecimalFormat("#0.00");
          finalTotal = Double.parseDouble(twoDForm.format(totf));
          
          
          session.setAttribute("finaltot", Double.valueOf(finalTotal));
          request.setAttribute("afinalTotal", Double.valueOf(finalTotal));
        }
        else
        {
          double total = 0.0D;
          double finalTotal = 0.0D;
          


          DecimalFormat twoDForm = new DecimalFormat("#0.00");
          finalTotal = Double.parseDouble(twoDForm.format(totf));
          
          
          session.setAttribute("finaltot", Double.valueOf(finalTotal));
          request.setAttribute("afinalTotal", Double.valueOf(finalTotal));
          





          String sc = this.obj.getShipCost(statename, finalTotal);
          double scd = Double.parseDouble(sc);
          double shipCost = Double.parseDouble(twoDForm.format(scd));
          
          request.setAttribute("shipCost", Double.valueOf(shipCost));
        }
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
      RequestDispatcher rd = request.getRequestDispatcher("checkoutdetails.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/deletecartitems"))
    {
      try
      {
        String bookingcode = "";
        String cookieName = "BICYCLE";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
          for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(cookieName))
            {
              
              bookingcode = cookies[i].getValue();
              
            }
          }
        }
        String cid = request.getParameter("cid");
        

        boolean b = this.obj.deletecartdetails(cid);
        
        InetAddress ip = InetAddress.getLocalHost();
        
        String uid = (String)session.getAttribute("uid");
        
        int cartitems = this.obj.getcartitemscount(bookingcode, uid);
        request.setAttribute("cartitems", Integer.valueOf(cartitems));
        
        ArrayList menubar = new ArrayList();
        request.setAttribute("menubar", menubar);

        ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
        request.setAttribute("carddetails", carddetails);
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
      ArrayList afterdiscountfinaltotal = new ArrayList();
      request.setAttribute("afterdiscountfinaltotal", 
        afterdiscountfinaltotal);
      
      RequestDispatcher rd = request.getRequestDispatcher("viewShoppingCart.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/clearcartdetails"))
    {
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
            
          }
        }
      }
      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      
      String uid = (String)session.getAttribute("uid");
      
      boolean b = this.obj.clearcartdetails(bookingcode, uid);
      


      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      

      ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
      request.setAttribute("carddetails", carddetails);
      RequestDispatcher rd = request.getRequestDispatcher("viewShoppingCart.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/viewcartdetails"))
    {
      String uid = (String)session.getAttribute("uid");
      String bookingcode = "";
      String cookieName = "BICYCLE";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals(cookieName))
          {
            
            bookingcode = cookies[i].getValue();
             
          }
        }
      }
      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      
     
      
      ArrayList afterdiscountfinaltotal = new ArrayList();
      request.setAttribute("afterdiscountfinaltotal", 
        afterdiscountfinaltotal);
      
      int cartitems = this.obj.getcartitemscount(bookingcode, uid);
      request.setAttribute("cartitems", Integer.valueOf(cartitems));
      

      ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
      request.setAttribute("carddetails", carddetails);
      RequestDispatcher rd = request.getRequestDispatcher("viewShoppingCart.jsp");
      rd.forward(request, response);
    }
    if (uri.equals("/addtocart"))
    {

        String id = request.getParameter("prodId");
        String uid = (String)session.getAttribute("uid");
        String qtyinpd = request.getParameter("qtyinpdes");
        


        ArrayList menubar = new ArrayList();
        request.setAttribute("menubar", menubar);
        
        ArrayList error = new ArrayList();
        if (qtyinpd.equals(""))
        {
          String subcat_id = request.getParameter("subid"); 
            pro_id = request.getParameter("id");
          error.add("Enter the quantity");
          request.setAttribute("subid", subcat_id);
          request.setAttribute("id", id);
          request.setAttribute("error", error);
          RequestDispatcher rd = request.getRequestDispatcher("Item");
          rd.forward(request, response);
        }
        else
        {
          String bookingcode = "";
          String cookieName = "BICYCLE";
          Cookie[] cookies = request.getCookies();
          if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
              if (cookies[i].getName().equals(cookieName))
              {
                System.out.println("COOKIES AVAILABLE--->" + 
                  cookies[i].getName());
                bookingcode = cookies[i].getValue();
                System.out.println("COOKIES VALUE--->" + bookingcode);
              }
            }
          }
          try
          {  
            String Inicolorandsize = request.getParameter("colorandsizeid"); 
            System.out.println("Inicolorandsize--->"+Inicolorandsize); 
            String coloransize = "";
            String chieldPID = "NULL"; 
            if (Inicolorandsize == null)
            {
              coloransize = "";
              System.out.println("IN SIDE COLOR AND SIDE NOT THERE-->" + 
                coloransize + "chield id->" + chieldPID);
              ArrayList details = this.obj.getproductdetailsforcart(id, coloransize, 
                chieldPID, bookingcode, uid, qtyinpd);
              request.setAttribute("details", details);
            }
            else
            {
            	String[] splits = Inicolorandsize.split("@@@@@"); 
                String colorandsize =  splits[0];; 
                String[] parts = null;
              parts = colorandsize.split("<>");
              coloransize = parts[0];
              chieldPID = parts[1];
              System.out.println(coloransize + "->" + chieldPID + "->" + 
                coloransize);
              ArrayList details = this.obj.getproductdetailsforcart(id, coloransize, 
                chieldPID, bookingcode, uid, qtyinpd);
              
              request.setAttribute("details", details);
            }
            ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
            request.setAttribute("carddetails", carddetails);
          }
          catch (Exception e)
          {
            System.out.println(e);
          }
          ArrayList afterdiscountfinaltotal = new ArrayList();
          request.setAttribute("afterdiscountfinaltotal", 
            afterdiscountfinaltotal);
          
          int cartitems = this.obj.getcartitemscount(bookingcode, uid);
          request.setAttribute("cartitems", Integer.valueOf(cartitems));
          RequestDispatcher rd = request.getRequestDispatcher("viewShoppingCart.jsp");
          rd.forward(request, response);
        } 
    }
     
    if (uri.equals("/addtocart1"))
    { 
    	System.out.println("INSIDE ADDTOCART1"); 
    	System.out.println("inside testing ramesh");
      String id = request.getParameter("prodId");
      String uid = (String)session.getAttribute("uid");
      String qtyinpd = request.getParameter("qtyinpdes"); 

      System.out.println("TESTING ONE 1------>"+id);
      System.out.println("TESTING ONE 2------>"+uid);
      System.out.println("TESTING ONE 3------>"+qtyinpd);

      ArrayList menubar = new ArrayList();
      request.setAttribute("menubar", menubar);
      
      ArrayList error = new ArrayList();
      if (qtyinpd.equals(""))
      {
        String subcat_id = request.getParameter("subid"); 
          pro_id = request.getParameter("id");
        error.add("Enter the quantity");
        request.setAttribute("subid", subcat_id);
        request.setAttribute("id", id);
        request.setAttribute("error", error);
        RequestDispatcher rd = request.getRequestDispatcher("Item");
        rd.forward(request, response);
      }
      else
      {
        String bookingcode = "";
        String cookieName = "BICYCLE";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
          for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(cookieName))
            {
              
              bookingcode = cookies[i].getValue();
               
            }
          }
        }
        try
        {
          String color = request.getParameter("colorandsizeid"); 
          System.out.println("the value of color"+color);
          //COLOR AND SIZE IN ADDTOCART1-->Campagnolo<>32905size---->32907<>700c
          //COLOR AND SIZE IN ADDTOCART1-->Campagnolo<>74449size---->null 
          String sizeandcid = request.getParameter("size");
          System.out.println("COLOR AND SIZE IN ADDTOCART1-->"+color+"size---->"+sizeandcid);
          String SIZE = "";
          String CID = "";
          String colorandsize = null;
          if (sizeandcid != null)
          {
        	  System.out.println("INSIDE sizeandcid != null");
            String[] parts1 = null;
            parts1 = sizeandcid.split("<>");
            CID = parts1[0];
            SIZE = parts1[1];
            colorandsize = SIZE + " " + color + "<>" + CID;
          }
          if(sizeandcid==null && color!=null)
          {  
        	  
        	  CID=obj.getchieldid(color);
        	  System.out.println("INSIDE SIZE IS NULL->"+CID);
        	  String[] parts1 = null;
        	  parts1 = color.split("<>"); 
        	  SIZE = parts1[0]; 
        	  colorandsize= SIZE + "<>" + CID; 
        	  System.out.println("INSIDE SIZE IS NULLcolorandsizecolorandsize->"+colorandsize);
          } 
          
          String[] parts = null;
          String coloransize = "";
          String chieldPID = "NULL";
          if (colorandsize == null)
          {
        	  System.out.println("INSIDE colorandsize == null");
            coloransize = "";
             
            ArrayList details = this.obj.getproductdetailsforcart(id, coloransize, 
              chieldPID, bookingcode, uid, qtyinpd);
            request.setAttribute("details", details);
          }
          else
          {
        	  System.out.println("INSIDE ELSEEEEEEEEEEEEE<<><><><>--->"+CID);
            parts = colorandsize.split("<>");
            coloransize = parts[0]; 
            chieldPID = parts[1];
            System.out.println("CHIELD ID IN ACTION SERVLETS-->"+chieldPID);
            ArrayList details = this.obj.getproductdetailsforcart(id, coloransize, 
              CID, bookingcode, uid, qtyinpd);
            
            request.setAttribute("details", details);
          }
          ArrayList carddetails = this.obj.getcartdetails(bookingcode, uid);
          request.setAttribute("carddetails", carddetails);
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
        ArrayList afterdiscountfinaltotal = new ArrayList();
        request.setAttribute("afterdiscountfinaltotal", 
          afterdiscountfinaltotal);
        
        int cartitems = this.obj.getcartitemscount(bookingcode, uid);
        request.setAttribute("cartitems", Integer.valueOf(cartitems));
        RequestDispatcher rd = request.getRequestDispatcher("viewShoppingCart.jsp");
        rd.forward(request, response);
      }
    }
    
    //TASK UPTO HERE
    
    if (uri.equals("/subscribetoemail"))
    {
      String email = request.getParameter("emailid");
      
      ArrayList error = new ArrayList();
      int z = 0;
      boolean w = false;
      if (email.equals(""))
      {
        error.add("Please enter the email address");
        z++;
      }
      w = this.val.email(email);
      if ((!w) && (z == 0))
      {
        error.add("Enter valid email ID");
        z++;
      }
      if (error.isEmpty())
      {
        boolean b = this.obj.subscribeToEmail(email);
        RequestDispatcher rd = request.getRequestDispatcher("indexpage");
        rd.forward(request, response);
      }
      else
      {
        request.setAttribute("errorforsubcription", error);
        RequestDispatcher rd = request.getRequestDispatcher("indexpage");
        rd.forward(request, response);
      }
    }
  }
  
  private boolean sendemail(String useremail, String shipvia, double ototal,
		double txtamt, double cp, String shicp, int odid, ArrayList carddetails, ArrayList shipdetails, ArrayList billengdetails, String string, String string2, String string3, String string4) 
  {
	  boolean b=false;
	  String cardnumber="";
	   if(string.equals("1"))
		{
		     cardnumber=string2.replace(string2.substring(0,12), "************");
		}
		if(string.equals("3"))
		{
			  cardnumber="";
		}
		
	    
	    System.out.println("IN SIDE MAIL SEND METHOD CP->"+cp); 
	    System.out.println("TAX AMOUNT-->"+txtamt); 
	    System.out.println("shicp-->"+shicp); 
	    System.out.println("order total--->"+ototal); 
	    
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date(); 
		DateFormat dFormat = new SimpleDateFormat("HH:mm:ss a"); 
		Calendar cal = Calendar.getInstance(); 
		 
	    //final  String MAIL_SERVER = "smtpout.secureserver.net";
		
		  
		
	    final  String MAIL_SERVER = "smtp.bicyclebuys.com";
	    //
	    final  String USERNAME = "sales@BicycleBuys.com";
	    final  String PASSWORD = "7218SalesBBC"; 
	    
	    //+++++++++++++++++++++++++++++++++++
	    try {
	    	String fromAddress = "info@shikshanjobs.com";
			String toAddress = useremail;
//			String fromAddress = "sales@bicyclebuys.com";
//			String toAddress = useremail;
			String subject = "ONLINE CUSTOMER WEB ORDER ACKNOWLEDGEMENT";
			String message1 = "Hello Hows u?"; 
			Properties properties = System.getProperties();
			properties.put("mail.smtps.host", MAIL_SERVER);
			properties.put("mail.smtps.auth", "true"); 
			Session session1 = Session.getInstance(properties);
			MimeMessage message = new MimeMessage(session1);
			
			message.setFrom(new InternetAddress(fromAddress));
			message.addRecipients(Message.RecipientType.TO, toAddress);
			message.setSubject(subject);
			message.setText(message1);  
			
			StringBuffer sb1=new StringBuffer(); 
			StringBuffer sb3=new StringBuffer();
			StringBuffer sb4=new StringBuffer();
			StringBuffer sb5=new StringBuffer(); 
			StringBuffer finalvalue=new StringBuffer(); 
			
			StringBuffer h1=new StringBuffer();
			StringBuffer h2=new StringBuffer();
			StringBuffer h3=new StringBuffer();
			StringBuffer h4=new StringBuffer();
			StringBuffer h5=new StringBuffer();
			 
			String PaymentMode="";
			String ifcreditcard="";
			
			if(string.equals("1"))
			{
				PaymentMode="Credit Card"; 
				ifcreditcard="Card No";
			}
			if(string.equals("3"))
			{
				PaymentMode="Fax/Call Order In"; 
				cardnumber="";
				ifcreditcard="";
			}
			//
			StringBuffer successmailbody=new StringBuffer();
			for (int i = 0; i < billengdetails.size(); i++)
		      {userDTO dt = (userDTO)billengdetails.get(i);
			h1.append("<h4>BICYCLEBUYS.COM ONLINE CUSTOMER WEB ORDER ACKNOWLEDGEMENT</h4><table width='33%'>" +
					"  " +
					"<tr><td></td><td></td></tr><tr>" +
					   " <td><b>Web Order Number:</b></td>" +
					   " <td>"+odid+"</td></tr>" +
					   "<tr><td>Date: </td><td> "+dateFormat.format(date)+" </td></tr>" +
					   "<tr><td>Time: </td><td>"+dFormat.format(cal.getTime())+" </td></tr>" +
					   "<tr><td>Customer Name: kirill altman</td><td></td></tr>" +
					   "<tr><td></td><td></td></tr>" +
					   "<tr><td colspan='2'>Bill-To/Ship-To Address: </td> </tr>" +
					   "" +
					   "<tr><td style='padding-left: 11px;'>"+dt.getFname()+" "+dt.getLname()+" </td><td> </td></tr>" +
					   "<tr><td style='padding-left: 11px;'>"+dt.getAddress()+"</td><td> </td></tr>" +
					   "<tr><td style='padding-left: 11px;'>"+dt.getCity()+", "+dt.getState()+"   "+dt.getPostalcode()+"</td><td> </td></tr>" +
					   "<tr><td style='padding-left: 11px;'>"+dt.getCountry()+"</td><td> </td></tr>" +
					   "<tr><td style='padding-left: 11px;'>Ph: " +dt.getPhone()+"</td><td> </td></tr>" +
					   "<tr><td style='padding-left: 11px;'>"+dt.getEmail()+"</td><td> </td></tr>" +
					   "" +
					   "<tr><td>&nbsp;</td><td> </td></tr>" +
					   "<tr><td> Payment:</td><td>"+PaymentMode+"</td></tr>" +
					   "<tr><td> "+ifcreditcard+"</td><td>"+cardnumber+"</td></tr></table>");  
			 }		  
			  sb3.append("<table>" +
					   " <tr>" +
					   "  <td colspan='4'>Items Details</td>" +
					   "</tr>" +
					   " <tr>" +
					   "  <td colspan='4'><b>===================================================================</b></td>" +
					   "</tr>");
			  DecimalFormat twoDForm = new DecimalFormat("#0.00");
			    double carttotal=0;
				 for (int i = 0; i < carddetails.size(); i++)
				 {
				  productDTO dt = (productDTO)carddetails.get(i);
				  sb4.append("<tr><td><b>Name:</b></td><td>"+dt.getDescription()+"</td></tr>" +
						" <tr><td><b>Sku#:</b></td><td> "+dt.getSKU()+"</td></tr></tr>" +
						" <tr><td><b>Size/Color: </b></td><td>"+dt.getColorandsize()+"</td></tr>" +
						" <tr><td><b>Quantity:</b></td><td>"+dt.getQty()+"</td></tr>" +
						" <tr><td><b>Unit Price:</b></td><td>$"+dt.getPrice()+"</td></tr>" +
						" <tr><td><b>Extended Price:</b></td><td>$" +(dt.getPrice() * dt.getQty())+"</td></tr>" +
								"<tr><td></td></tr>" ); 
				  carttotal=carttotal+(dt.getPrice() * dt.getQty());
				}  
			    h2.append("<tr><td colspan='4'><b>===================================================================</b></td></tr></table>");
			    
			    h3.append("<table>" +
			    		 
			    		"<tr><td width='20%'>SubTotal</td><td>$"  +Double.parseDouble(twoDForm.format(((carttotal))))+"</td></tr>  " +
			    		"<tr><td width='20%'>Tax</td><td>$"+Double.parseDouble(twoDForm.format(((txtamt))))+"</td></tr>" +
			    		"  <tr><td>Shipping:</td><td> $ "+shicp+" ("+shipvia+")</td></tr>" +
			    		"  <tr><td>Total:</td><td>$"+Double.parseDouble(twoDForm.format(((ototal))))+"</td></tr>" +
			    		"<tr><td><b>&nbsp;</b></td><td>&nbsp;</td></tr>" +
			    		"" +
			    		"<tr><td colspan='2'><b>Please refer to this whenever contacting BicycleBuys.com customer</b></td><td></td></tr>" +
			    		"<tr><td colspan='2'><b>service. If you have any questions please just reply to this e-mail</b></td><td></td></tr>" +
			    		"<tr><td colspan='2'><b>or call 1-888-4-BIKE-BUY.</b></td><td></td></tr></table>");
			    
			    
			    h4.append("<table width='50%'>" +
			    		"  <tr><td>Thanks again for shopping with us</td></tr>" +
			    		"  <tr><td>---------------------------------------</td></tr>" +
			    		"  <tr><td>BicycleBuys.com</td></tr>" +
			    		"  <tr><td>We Cycle The World</td></tr>" +
			    		"  <tr><td>http://www.bicyclebuys.com</td></tr></table>");
			    
			
			    sb1.append("<html>" +
			   		"<head><meta charset='utf-8'><title>Bicyclebuys.com</title>" + 
			   		"</head>" +
			   		"<body>");
			   		 
			   		 
			   
			      sb5.append("</body></html>");
			      
			      successmailbody.append(sb1.append(h1.append(sb3.append(sb4.append(h2.append(h3.append(h4.append(sb5))))))));
			
			     BodyPart messageBodyPart1 = new MimeBodyPart();
				 messageBodyPart1.setContent(successmailbody.toString(), "text/html");
				 Multipart multipart = new MimeMultipart();
				 multipart.addBodyPart(messageBodyPart1);
				message.setContent(multipart);
				
				Transport tr = session1.getTransport("smtps");
				tr.connect(MAIL_SERVER, USERNAME, PASSWORD);
				tr.sendMessage(message, message.getAllRecipients());
				System.out.println("mailsent");
				tr.close(); 
				b=true; 
				
		} catch (MessagingException e)
		{
			 b=false;
			//throw new RuntimeException(e);
		}
	    
		catch (Exception e)
		{
			b=false;
			e.printStackTrace();
		}
	    
	   
	  
	  
	  
	  
	  return b;
   }

public static String runAuth(Properties props, String shipTo_firstName, String shipTo_lastName, String shipTo_street1, String shipTo_city, String shipTo_state, String shipTo_postalCode, String shipTo_country, String cardnumber, String card_expirationMonth, String card_expirationYear, String item_0_unitPrice, ArrayList billengdetails, String card_cvNumber)
  {
    String requestID = null;
    
    HashMap request = new HashMap();
    
    request.put("ccAuthService_run", "true"); 

    request.put("merchantReferenceCode", "ramesh_cyb"); 
    
    for(Object o : billengdetails){ 
	    userDTO d = (userDTO)o; 
       request.put("billTo_firstName", d.getFname());
       request.put("billTo_lastName", d.getLname());
       request.put("billTo_street1", d.getAddress());
       request.put("billTo_city", d.getCity());
       adminDAO obj=new adminDAOImpl();
       String stateabb=obj.getstateabbforpayment(d.getState()); 
       request.put("billTo_state", stateabb);
       request.put("billTo_postalCode", d.getPostalcode());
       request.put("billTo_country", "US");
       request.put("billTo_email", d.getEmail());
       request.put("billTo_ipAddress", "10.7.7.7");
       request.put("billTo_phoneNumber", d.getPhone());
       
       System.out.println("BILLING DETAILS");
       System.out.println("billTo_firstName-->"+shipTo_firstName);
       System.out.println("billTo_lastName-->"+shipTo_lastName);
       System.out.println("billTo_street1-->"+shipTo_street1);
       System.out.println("billTo_city-->"+shipTo_city);
       System.out.println("billTo_state-->"+shipTo_state);
       System.out.println("billTo_postalCode-->"+shipTo_postalCode);
       System.out.println("billTo_country-->"+cardnumber);
       System.out.println("billTo_email-->"+card_expirationMonth);
       System.out.println("billTo_phoneNumber-->"+card_expirationYear);
       
       
    } 
    request.put("shipTo_firstName", shipTo_firstName);
    request.put("shipTo_lastName", shipTo_lastName);
    request.put("shipTo_street1", shipTo_street1);
    request.put("shipTo_city", shipTo_city);
    request.put("shipTo_state", shipTo_state);
    request.put("shipTo_postalCode", shipTo_postalCode);
    request.put("shipTo_country", shipTo_country);
    request.put("card_accountNumber", cardnumber);
    request.put("card_expirationMonth", card_expirationMonth);
    request.put("card_expirationYear", card_expirationYear); 
    request.put("card_cvNumber", card_cvNumber);
    request.put("purchaseTotals_currency", "USD"); 
    request.put("item_0_unitPrice", item_0_unitPrice); 
    System.out.println("SHIPPING DETAILS"); 
    System.out.println("shipTo_firstName-->"+shipTo_firstName);
    System.out.println("shipTo_lastName-->"+shipTo_lastName);
    System.out.println("shipTo_street1-->"+shipTo_street1);
    System.out.println("shipTo_city-->"+shipTo_city);
    System.out.println("shipTo_state-->"+shipTo_state);
    System.out.println("shipTo_postalCode-->"+shipTo_postalCode);
    System.out.println("cardnumber-->"+cardnumber);
    System.out.println("card_expirationMonth-->"+card_expirationMonth);
    System.out.println("card_expirationYear-->"+card_expirationYear); 
    System.out.println("card_cvNumber-->"+card_cvNumber); 
    System.out.println("item_0_unitPrice-->"+item_0_unitPrice); 
    
    try
    {
      displayMap("CREDIT CARD AUTHORIZATION REQUEST:", request); 
      HashMap reply = Client.runTransaction(request, props); 
      displayMap("CREDIT CARD AUTHORIZATION REPLY:", reply); 
      String decision = (String)reply.get("decision"); 
      if ("ACCEPT".equalsIgnoreCase(decision))
      {
        processReply(reply); 
        requestID = (String)reply.get("requestID");
      }
    }
    catch (ClientException e)
    {
      System.out.println(e.getMessage());
      if (e.isCritical()) {
        handleCriticalException(e, request);
      }
    }
    catch (FaultException e)
    {
      System.out.println(e.getMessage());
      if (e.isCritical()) {
        handleCriticalException(e, request);
      }
    }
    return requestID;
  }
  
  public static void runCapture(Properties props, String authRequestID, String item_0_unitPrice)
  {
     
    String requestID = null;
    
    HashMap request = new HashMap();
    
    request.put("ccCaptureService_run", "true"); 

    request.put("merchantReferenceCode", "MRC-14344"); 

    request.put("ccCaptureService_authRequestID", authRequestID);
    

    request.put("purchaseTotals_currency", "USD");
    request.put("item_0_unitPrice", item_0_unitPrice);
    try
    {
      displayMap("FOLLOW-ON CAPTURE REQUEST:", request);
      

      HashMap reply = Client.runTransaction(request, props);
      
      displayMap("FOLLOW-ON CAPTURE REPLY:", reply);
    }
    catch (ClientException e)
    {
      System.out.println(e.getMessage());
      if (e.isCritical()) {
        handleCriticalException(e, request);
      }
    }
    catch (FaultException e)
    {
      System.out.println(e.getMessage());
      if (e.isCritical()) {
        handleCriticalException(e, request);
      }
    }
  }
  
  private static void displayMap(String header, Map map)
  {
    System.out.println("REQUEST HEADER-->" + header);
    
    StringBuffer dest = new StringBuffer();
    if ((map != null) && (!map.isEmpty()))
    {
      Iterator iter = map.keySet().iterator();
      while (iter.hasNext())
      {
        String key = (String)iter.next();
        String val = (String)map.get(key);
        dest.append(key + "=" + val + "\n");
      }
    }
    System.out.println(dest.toString());
  }
  
  private static void handleCriticalException(ClientException e, Map request) {}
  
  private static void handleCriticalException(FaultException e, Map request) {}
  
  private static void processReply(HashMap reply)
    throws ClientException
  {
    MessageFormat template = new MessageFormat(
      getTemplate((String)reply.get("decision")));
    Object[] content = { getContent(reply) };
    



    System.out.println(template.format(content));
  }
  
  private static String getTemplate(String decision)
  {
    if ("ACCEPT".equalsIgnoreCase(decision)) {
      return "Your order was approved.{0}";
    }
    if ("REJECT".equalsIgnoreCase(decision)) {
      return "Your order was not approved.{0}";
    }
    return "Your order cannot be completed at this time.{0}\nPlease try again later.";
  }
  
  private static String getContent(HashMap reply)
    throws ClientException
  {
    int reasonCode = 
      Integer.parseInt((String)reply.get("reasonCode"));
    switch (reasonCode)
    {
    case 100: 
      return "\nRequest ID: " + (String)reply.get("requestID");
    case 101: 
      return 
        "\nThe following required field(s) are missing:\n" + enumerateValues(reply, "missingField");
    case 102: 
      return 
        "\nThe following field(s) are invalid:\n" + enumerateValues(reply, "invalidField");
    case 204: 
      return "\nInsufficient funds in the account. Please use a different card or select another form of payment.";
    }
    return "";
  }
  
  private static String enumerateValues(Map reply, String fieldName)
  {
    StringBuffer sb = new StringBuffer();
    String val = "";
    for (int i = 0;; i++)
    {
      String key = fieldName + "_" + i;
      if (!reply.containsKey(key)) {
        break;
      }
      val = (String)reply.get(key);
      if (val != null) {
        sb.append(val + "\n");
      }
    }
    String key;
    return sb.toString();
  }
}
