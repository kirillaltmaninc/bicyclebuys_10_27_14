 <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.dbconnect.Dbconnect"%> 
 <%@ page import="com.admin.action.*"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.io.File"%>
<%@ page import="org.json.JSONObject" %>
<%@ page  import="org.json.JSONArray" %>
<%@ page import="java.text.*" %>
<% adminDAO obj;obj=new adminDAOImpl();

String color=request.getParameter("cname");
String pid=request.getParameter("pid");
String status=request.getParameter("status");

System.out.println("color->"+color);
System.out.println("pid->"+pid);
    Dbconnect db = new Dbconnect();
	Statement st = db.dbconnect(); 
	
	float yourprice=0.0f;
	float msrp=0.0f;
	float yoursave=0.0f;
	
	ResultSet rs=null;
	
	if(status.equals("0"))
	{
		rs=st.executeQuery("select SKU,description,price,MSRP,marketingdescription,marketdescriptwo from products where ProdID=(select pc.ChildProdID from products as p,[Products Children] pc ,Color as c  where p.ProdID=pc.ChildProdID and p.ColorID=c.colorid   and  c.Color='"+color+"' and pc.ProdID='"+pid+"')");
	}
	else if(status.equals("1"))
	{ 
		rs=st.executeQuery("select SKU,description,price,MSRP,marketingdescription,marketdescriptwo from products where ProdID='"+pid+"'"); 
		
	}
		if(rs.next())
     {
		StringBuffer disph=new StringBuffer();
		DecimalFormat twoDForm = new DecimalFormat("#0.00"); 		 
		if(rs.getString("MSRP")==null)
		{
			yoursave=0.0f;	
		}else
		{
			yoursave=rs.getFloat("MSRP")-rs.getFloat("price");	
		} 
		
		if(rs.getString("marketdescriptwo")==null)
		{
			disph.append("");
		}
		else
		{
			String mkd2=rs.getString("marketdescriptwo");
			String fstr=mkd2.replace('^', '!');		
			String []hhh=fstr.split("!");		
			
			String oh=""; 
		   		 for(int i=0;i<hhh.length;i++)
		   			{   
		   			if(i==0)
			   			{ 
				   			disph.append(hhh[i]); 
			   			}
			   		else
			   			{
			   			oh="<li>"+hhh[i]+"</li>";		   					
			   			disph.append(oh);  
			   			} 
		   			 
		   			}  
		}
		
		
		JSONObject json = new JSONObject(); 
		json.put("sku",rs.getString("SKU")); 
		json.put("price", rs.getString("price"));
		json.put("yousave",Double.parseDouble(twoDForm.format(((yoursave))))); 
	    json.put("desc1", rs.getString("description"));  
		json.put("mkd1", rs.getString("marketingdescription"));  
		json.put("mkd2",disph.toString()); 
		json.put("MSRP", rs.getString("MSRP")); 
		out.print(json);
	    out.flush();

     }  
	 
%>  