<%@page import="com.dbconnect.Dbconnect"%> 
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
 <%@page import="java.util.Random"%>
<%@page import="java.io.IOException" %>
<%@page import="java.security.GeneralSecurityException" %>
<%@page import="java.util.Properties" %>
<%@page import="java.util.UUID" %>
<%@page import="javax.crypto.Cipher" %>
<%@page import="javax.crypto.spec.SecretKeySpec" %>
<%@page import="javax.mail.BodyPart" %>
<%@page import="javax.mail.Message" %>
<%@page import="javax.mail.MessagingException" %>
<%@page import="javax.mail.Multipart" %>
<%@page import="javax.mail.PasswordAuthentication" %>
<%@page import="javax.mail.Session" %>
<%@page import="javax.mail.Transport" %>
<%@page import="javax.mail.internet.InternetAddress" %>
<%@page import="javax.mail.internet.MimeBodyPart" %>
<%@page import="javax.mail.internet.MimeMessage" %>
<%@page import="javax.mail.internet.MimeMultipart" %>
<%@page import="javax.servlet.RequestDispatcher" %>
<%@page import="javax.servlet.ServletException" %>
<%@page import="javax.servlet.http.HttpServlet" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpServletResponse" %> 
<%  
        final  String MAIL_SERVER = "smtpout.secureserver.net";
	    final  String USERNAME = "basantkumar@tamagna.com";
	    final  String PASSWORD = "change123"; 
	
	    
	    String ok="";
	    
	System.out.println("inside getlist"); 
    String email=request.getParameter("forgotemail");
    System.out.println("email-->"+email); 
	Dbconnect db = new Dbconnect();
	Statement st = db.dbconnect(); 
	Statement st1 = db.dbconnect(); 
	String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String proj="BICYCLEBUYSCOM";
	int character=(int)(Math.random()*20);
	String s=alphabet.substring(character, character+2); 
	Random r = new Random();
	int Low = 100;
	int High = 1000;
	int R = r.nextInt(High-Low) + Low;  		  
	System.out.println(proj.substring(0, 3) + "->"  +s+"-->"+R);  
	String password=proj.substring(0, 3)+R+s;
	System.out.println("Final code is->"+password);
	ResultSet rs = st.executeQuery("select * from Customers where CustEmail='"+email+"'");
    if(rs.next())
     {
        st1.executeUpdate("update Customers set Password='"+password+"' where CustEmail='"+email+"'");
     }
    else
    {
    	ok="0";
    	out.println(ok);
    }
    db.close();
    rs.close();  
	    
    if(ok.equals("0"))
    {
    	
    
    }
    else
    {
    //+++++++++++++++++++++++++++++++++++
    try { 
		String fromAddress = "info@shikshanjobs.com";
		String toAddress = email;
		String subject = "Congratulations! Your password recoverymail is approved successfully";
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
		   sb1.append("<html>" +
		   		"<head><meta charset=\"utf-8\"><title>Shikshan Jobs</title>" +
		   		"<link href='http://fonts.googleapis.com/css?family=Damion' rel='stylesheet' type='text/css'>" +
		   		"<link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>" +
		   		"</head>" +
		   		"<body style=\"margin:0 auto; padding:0;  font:normal 0.8em/normal Arial, Helvetica, sans-serif;   color:#fff; text-transform:none; \">" +
		   		"<div style=\"width:724px; border:solid 4px #838383;margin:0 auto;\">" + 
		   		"<h1 style=\"font-family: 'Damion', cursive; font-weight:normal; color:#0071c1;\">Dear User </h1>" +
		   		"<p style=\" font-family:Arial, Helvetica, sans-serif; line-height:25px; font-size:13px; color:#000;\">Your password recoverymail is approved successfully Please check the below details </p>" + 
		      	"<h2 style=\"color:#004d84;font-family: 'Roboto', sans-serif; font-weight:normal; line-height:25px; margin:15px 0 0 0; float:left; font-size:1.2em;\"> Your New Password Is: </h2><h2 style=\"color:#004d84;font-family: 'Roboto', sans-serif; font-weight:normal; line-height:25px; margin:15px 0 0 0; float:left; font-size:1.2em;\"> "+password+" </h2>" +
		   		"<div style=\"clear:both;\"></div>" +
		   		"<h2 style=\"color:#004d84;font-family: 'Roboto', sans-serif; font-weight:normal; line-height:25px; margin:15px 0 0 0; float:left; font-size:1.2em;\"> You are the leaders behind our Sucess </h2>" +
		   		"<div style=\"clear:both;\"></div>" +
		   		" <h2 style=\"color:#004d84;font-family: 'Roboto', sans-serif; font-weight:normal; line-height:25px; margin:15px 0 0 0; float:left; font-size:1.2em;\">Thanks for being our member....... </h2>" +
		   		"<div style=\"clear:both;\"></div>" +
		   		"<h2 style=\"color:#004d84;font-family: 'Roboto', sans-serif; font-weight:normal; line-height:25px; margin:15px 0 0 0; float:left; font-size:1.2em;\">Bicyclebuys.com</h2>" +
		   		"<div style=\"clear:both;\"></div>" +
		   		"<h2 style=\"color:#004d84;font-family: 'Roboto', sans-serif; font-weight:normal; line-height:25px; margin:15px 0 0 0; float:left; font-size:1.2em;\">For any Queries Contact us </h2> <a href=\"#\"  style=\"text-decoration:none; color:#000; line-height:25px; color:#890205; float:left; font-weight:bold; display:block; padding:15px 0 0 5px;\">@ 1-888-424-5328 | 1-631-673-2211</a>" +
		   		"<div style=\"clear:both;\"></div>" +
		   		"<h2 style=\"color:#004d84;font-family: 'Roboto', sans-serif; font-weight:normal; line-height:25px; margin:15px 0 0 0; float:left; font-size:1.2em;\">  Email us-</h2>  <a href=\"#\" style=\"text-decoration:none; color:#000; line-height:25px; color:#890205; float:left; font-weight:bold; display:block; padding:15px 0 0 5px;\">info@bicyclebuys.com</a>" +
		   		"<div style=\"clear:both;\"></div>" +
		   		"</div>" +
		   		"</div>" +
		   		"</div>" +
		   		"</body>" +
		   		"</html>");
		     BodyPart messageBodyPart1 = new MimeBodyPart();
			 messageBodyPart1.setContent(sb1.toString(), "text/html");
			 Multipart multipart = new MimeMultipart();
			 multipart.addBodyPart(messageBodyPart1);
			message.setContent(multipart);
			
			Transport tr = session1.getTransport("smtps");
			tr.connect(MAIL_SERVER, USERNAME, PASSWORD);
			tr.sendMessage(message, message.getAllRecipients());
			System.out.println("mailsent");
			tr.close(); 
			ok="1";
			out.println(ok);
			
	} catch (MessagingException e)
	{
		ok="2";
		out.println(ok);
		throw new RuntimeException(e);
	}
    
	catch (Exception e)
	{
		ok="2";
		out.println(ok);
		e.printStackTrace();
	}
    }
    
%>