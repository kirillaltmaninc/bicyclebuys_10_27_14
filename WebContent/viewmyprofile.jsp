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
    <h1>Customer Profile</h1>
    <ul class="formlist">
    
    <table>
      <tr>
        <td>
         <%@ page import="java.util.*" %>
         <font color="red">
<%
ArrayList el = (ArrayList) request.getAttribute("error");
%>
<%
if (el != null) {
Iterator it = el.iterator();
while (it.hasNext()) {
%>
<%
out.println(it.next());
%>
<br>
<%
}
}
%></font>

<%if(request.getAttribute("success")==null){ %>

<%} else { %>

<font color="green">
    <b>   <%=request.getAttribute("success") %></b> 
       </font>
<%} %>
        </td>
      </tr>
    </table>
    
    
     <%@page import="com.admin.action.*"%>
 
    <c:forEach items="${viewmyprofile}" var="bean"> 
    
     <form name="checkoutformregupdate" action="updateprofile" method="post" onsubmit="return profileupdate();">
      <table width="100%" border="0" cellspacing="0" cellpadding="0"> 
        
        <input type="hidden" name="uid" value="${bean.uid}">
        <tr>
          <td>First Name:<font class="red">*</font></td>
          <td><input type="text" class="tet" name="fname" value="${bean.fname}"></td>
          <td>Middle</td>
          <td><input type="text" class="tet" name="mname" value="${bean.mname}"></td>
        </tr>
        <tr>
          <td>Last Name:<font class="red">*</font></td>
          <td><input type="text" class="tet" name="lname" value="${bean.lname}"></td>
          <td>Company</td>
          <td><input type="text" class="tet" name="company" value="${bean.company}"></td>
        </tr>
        <tr>
          <td>Address:<font class="red">*</font></td>
          <td><textarea  class="tet"  rows="3" cols="20" name="address">${bean.address}</textarea></td>
          <td>City:<font class="red">*</font></td>
          <td><input type="text" class="tet"  name="city" value="${bean.city}"/></td>
        </tr>
        <tr>
          <td>Zip/Postal Code:<font class="red">*</font></td>
          <td><input   type="text"  class="tet" name="postalcode" value="${bean.postalcode}"/></td>
          <td>State:<font class="red">*</font></td>
          <td> 
           <select name="STATEPROVINCE"  onChange="ChkSP()" class="tet">

          <option value="ZZ">Choose state/Province</option>
           <% 
					ArrayList getallstate=(ArrayList)request.getAttribute("getallstate");
					if(!getallstate.isEmpty())
                        {  	
                        for(int i=0;i<getallstate.size();i++)
                         { 
                        	userDTO e=(userDTO)getallstate.get(i); 
                          %>  
                            <option value="<%=e.getState() %>"><%=e.getState() %></option>
            <%}} %>
          </select>
          
            <div style="clear:both;"></div>
            <p style="font-size:11px; margin:0; padding:0; font-weight:normal;"> US and Canada Only!</p></td>
        </tr>
        <tr>
          <td>Email:<font class="red">*</font></td>
          <td><input  class="tet" type="text"  name="email" value="${bean.email}"/></td>
          <td>Country</td>
          <td><select name="COUNTRY"  class="tet" onchange="chk1()">

           <option value="">Choose country</option>
          <% 
					ArrayList getcountry=(ArrayList)request.getAttribute("getcountry");
					if(!getcountry.isEmpty())
                        {  	
                        for(int i=0;i<getcountry.size();i++)
                         { 
                        	userDTO e=(userDTO)getcountry.get(i); 
                          %> 
            <option value="<%=e.getCountry() %>"><%=e.getCountry() %></option>
            <%} }%>
          </select></td>
        </tr>
         
        <tr>
          <td>Phone:<font class="red">*</font></td>
          <td><input type="text" class="tet" name="phone" value="${bean.phone}"></td>
          <td>Password</td>
          <td><input type="text" class="tet" name="Province" value="${bean.password}"></td>
        </tr>
        <tr>
          <td>Fax</td>
          <td><input type="text" class="tet" name="fax" value="${bean.fax}"></td>
          <td>Comments</td>
          <td><textarea  class="tet"  rows="3" cols="20" name="comment"></textarea></td>
        </tr>
        <tr>
          <td scope="col">&nbsp;</td>
          <td colspan="3" scope="col"><button name="login_submit" class="buttond blue" type="submit">Update Profile</button></td>
        </tr>
      </table>      
      </form> 
      </c:forEach> 
    </ul>
  </div> 
  
 </div> 
 </div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>