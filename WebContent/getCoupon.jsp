<%@page import="com.admin.action.productDTO"%>
<%@page import="com.admin.action.userDTO"%>
<%@page import="com.admin.action.adminDAOImpl"%>
<%@page import="com.admin.action.adminDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.dbconnect.Dbconnect"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%
	double cpr = 0.0;
	session.setAttribute("couponprice", cpr);
	 session.removeAttribute("aftDiscout");
	String prodTotalPrice1 = request.getParameter("totalPrice"); 
	//String v=prodTotalPrice1.replace('$','0'); 
	if(prodTotalPrice1.contains("$")){
		prodTotalPrice1 = prodTotalPrice1.replace('$', ' ');
	}
	double prodTotalPrice = Double.parseDouble(prodTotalPrice1.trim());
		String couponv = request.getParameter("couponv");
		String totalPrice = request.getParameter("totalPrice");
		
System.out.println("~~~~~~~~~~~~---couponv----~~~~~~~~~ "+couponv);
System.out.println("~~~~~~~~~~~~------totalPrice------~~~~~~~~~ "+totalPrice);
		System.out.println("~~~~~~~~~~~~------prodTotalPrice------~~~~~~~~~ "+prodTotalPrice);
		//String tp=totalPrice.substring(1);
		//String tp=totalPrice.replace('$','0');
		if(totalPrice.contains("$")){
			totalPrice = totalPrice.replace('$', ' ');
			totalPrice = totalPrice.trim();
		}
		ArrayList error=new ArrayList();
 		adminDAO obj = new adminDAOImpl();

		int z=0;
		String status="false";
		double price =0.0f;
		String afterDisc = "";
		ArrayList getoffer;
		getoffer=obj.getgetoffer(couponv, prodTotalPrice, totalPrice);
		productDTO use=new productDTO();
		for(int i=0;i<getoffer.size();i++)
		{
			use=(productDTO) getoffer.get(i);
			status=use.getStatus();
			price= use.getPrice();
			afterDisc = use.getAfterDiscount();
		}
		System.out.println("status value->"+status);


		if(couponv.equals("") && z==0)
		{
			z++;
		}

		if(status.equals("2") && z==0)
		{
			out.print(2);
			z++;
		}

		if(status.equals("1") && z==0)
		{
			out.print(1);
			z++;
		}
		if(status.equals("3"))
		{ 
			session.setAttribute("couponprice", price);
			session.setAttribute("aftDiscout", afterDisc);
			out.print(price);
		}  %>
