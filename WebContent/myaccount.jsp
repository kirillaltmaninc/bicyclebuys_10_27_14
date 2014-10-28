<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<body>
   
  <div class="container">
 	  <div class="clients">
  <p><img src="images/border.JPG" width="959" height="7"> </p>
   
    <table width="100%"   cellspacing="0" cellpadding="0">
      <tr>
        <td><a href="getmyaccount?uid=<%=session.getAttribute("uid")%>"><font color="green"><b>Order Details</b> </font> </a>  |  <a href="getmyprofile?uid=<%=session.getAttribute("uid")%>"><font color="green"><b>View Profile</b></font></a> </td> 
      </tr>
    </table>
    <div style="clear: both; height: 15px;" ></div>
     <div class="login1234"> 
   
    
    <ul class="formlist">  
      <table width="100%" border="2" cellspacing="0" cellpadding="0">
        <tr>
          <td>Order ID</td>
          <td>Order Date </td>
          <td> </td> 
        </tr>
        <c:forEach items="${orderdetails}" var="m">
          <tr>
            <td>${m.orderID} </td>
            <td>${m.orderdate} </td>
            <td> <a href="viewproductorderwise?orderid=${m.orderID}">View Order Details</a> </td>
          </tr>
        </c:forEach>
      </table>   
 
    </ul>
  </div>
   <div style="clear: both; height: 15px;" ></div>
   
  
 </div> 
 </div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>