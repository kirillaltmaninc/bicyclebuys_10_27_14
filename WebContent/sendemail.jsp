 
 
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
        final  String MAIL_SERVER = "smtp.bicyclebuys.com";
	    final  String USERNAME = "sales@BicycleBuys.com";
	    final  String PASSWORD = "7218SalesBBC"; 
 
    try {
			 
			String fromAddress = "sales@bicyclebuys.com";
			String toAddress = "basantbiet@gmail.com";
			String subject = "Job Refer To You";
			String message1 = "Hello Hows u?"; 
			Properties properties = System.getProperties();
			properties.put("mail.smtps.host", MAIL_SERVER);
			properties.put("mail.smtps.auth", "true");
			
			System.out.println(properties.get("2525"));
			properties.put("mail.smtp.port", "2525");
			Session session1 = Session.getInstance(properties);
			MimeMessage message = new MimeMessage(session1);
			  
			message.setFrom(new InternetAddress(fromAddress));
			message.addRecipients(Message.RecipientType.TO, toAddress);
			message.setSubject(subject);
			message.setText(message1); 
			String email_id=""; 
			
			StringBuffer sb1=new StringBuffer();
			   sb1.append("<html>" +
			   		"<head><meta charset=\"utf-8\"><title>Shikshan Jobs</title>" +
			   		"<link href='http://fonts.googleapis.com/css?family=Damion' rel='stylesheet' type='text/css'>" +
			   		"<link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>" +
			   		"</head>" + 
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
		}  
		catch (Exception e)
		{
			e.printStackTrace();
		}
    
   
%>