<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>

<link href="css/popup.css" rel="stylesheet" type="text/css" media="all" />
 

	   <script type="text/javascript" src="js/popup.js"></script>

  
	
	<script>
		window.onload=focus;
		function focus()
		{
			document.getElementById("forgotemail").focus();
		}
	</script>

 	
	
	
	<script type="text/javascript">
	
	$( document ).ready(function() {
		
		$("#forgotemail").keypress(function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
			}
		});
		
		
		$('#ancheck').bind('keypress', function (event) {
			var regex = new RegExp("^[a-zA-Z0-9\b]+$");
			var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
			if (!regex.test(key)) {
				event.preventDefault();
				return false;
			}
		});
		
		
		
			});	
		
		function sendpass()
		{		
			if($.trim($("#forgotemail").val()).length<=0)
			{
				$("#result1").html("Registered Email Id not entered");
				$("#forgotemail").focus();
			}
			
			
			
			if($.trim($("#forgotemail").val()).length>0)
			{
				
				var a = $("#forgotemail").val();
				var filter = /^[a-zA-Z0-9]+[a-zA-Z0-9_.-]+[a-zA-Z0-9_-]+@[a-zA-Z0-9]+[a-zA-Z0-9.-]+[a-zA-Z0-9]+.[a-z]{2,4}$/;
				//if it's valid email
				if(!filter.test(a)){
					$("#result1").html("Enter valid Registered Email Id!");
					$("#forgotemail").focus();
					
				}
				
				
				else
				{
					
					var dataString = $("#forgot").serialize();
					$.ajax({  
						type: "POST",  
						url: "fpass.jsp",  
						data: dataString, 
						beforeSend: function() 
						{
							$('#process').html("<p>Just Wait a Moment</p>");
						},  
						success: function(data)
						{
							 
							$('#process').html("");
							
							if(data==1) 
							{
								$('#result1').html("Password emailed successfully")
								//window.location='securelog.php';
							}
							else if(data==0){
								$('#result1').html("Incorrect Registered Email Id")
								
							}
							else if(data==2){
								$('#result1').html("A problem ocurred in sending email. Please retry after some time")
								
							}
							
							
						}
					});
				}//end of else
			}
		}//End of SecureLogin 
	</script>
<body>
   
  <div class="container">
 	  <div class="clients">
  <p><img src="images/border.JPG" width="959" height="7"> </p>
   
     <div class="login1">
    <h1>New customer</h1>
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
<% 

userDTO rBean = (userDTO) request.getAttribute("bean");
    %>
        	<%
if (request.getAttribute("error") == null) {
		%>
		
		
		 
    <form name="checkoutformreg" action="registeruser" method="post"  >
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>First Name:<font class="red">*</font></td>
          <td><input type="text" class="tet" name="fname"></td>
          <td>Middle</td>
          <td><input type="text" class="tet" name="mname"></td>
        </tr>
        <tr>
          <td>Last Name:<font class="red">*</font></td>
          <td><input type="text" class="tet" name="lname"></td>
          <td>Company</td>
          <td><input type="text" class="tet" name="company"></td>
        </tr>
        <tr>
          <td>Address:<font class="red">*</font></td>
          <td><textarea  class="tet"  rows="3" cols="20" name="address"></textarea></td>
          <td>City:<font class="red">*</font></td>
          <td><input type="text" class="tet"  name="city"/></td>
        </tr> 
       
        <tr>
          <td>Zip/Postal Code:<font class="red">*</font></td>
          <td><input   type="text"  class="tet" name="postalcode"/></td>
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
          <td><input  class="tet" type="text"  name="email"/></td>
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
          <td><input type="text" class="tet" name="phone"></td>
          <td>Province</td>
          <td><input type="text" class="tet" name="Province" ></td> 
        </tr>
        <tr>
          <td>Fax</td>
          <td><input type="text" class="tet" name="fax"></td>
          <td>Password:<font class="red">*</font></td>
          <td><input type="password" class="tet" name="pwd"> </td>
        </tr>
        <tr>
          <td scope="col">&nbsp;</td>
          <td colspan="3" scope="col"><button name="login_submit" class="buttond blue" type="submit">Register</button></td>
        </tr>
      </table>      
      </form>
      
        <%
} else 
{
%>
<jsp:useBean id="bean" class="com.admin.action.userDTO"  
	scope="request"></jsp:useBean> 
        
        <form name="checkoutformreg" action="registeruser" method="post"  >
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
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
          <td>Province</td>
          <td><input type="text" class="tet" name="Province" value="${been.Province}"></td> 
        </tr>
        <tr>
          <td>Fax</td>
          <td><input type="text" class="tet" name="fax" value="${bean.fax}"></td>
          <td>Password:<font class="red">*</font></td>
          <td><input type="password" class="tet" name="pwd"> </td>
        </tr>
        <tr>
          <td scope="col">&nbsp;</td>
          <td colspan="3" scope="col"><button name="login_submit" class="buttond blue" type="submit">Register</button></td>
        </tr>
      </table>      
      </form>
      
      <%} %>
    </ul>
  </div>
  
  
  <%if(session.getAttribute("email")==null) {%>
  
  
  <div class="login">
    <h1>Existing user please sign in below</h1>
    <ul class="formlist">
    
    <table>
      <tr>
        <td>
          <font color="red">
<%
ArrayList e2 = (ArrayList) request.getAttribute("error1");
%>
<%
if (e2 != null) {
Iterator it = e2.iterator();
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
        </td>
      </tr>
    </table>
    
    <form action="loginuserg" method="post">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td scope="col"><span class="required">Email Address*</span></td>
          <td scope="col"><input type="text" name="useremail123"  class="tet" /></td>
        </tr>
        <tr>
          <td scope="col"><span class=" required">Password</span></td>
          <td scope="col"><input type="password" class="tet" name="pwd"/></td>
        </tr>
        <tr>
          <td scope="col">&nbsp;</td>
          <td scope="col"><button name="login_submit" class="buttond blue" type="submit">Log in</button>
            <a class="topopup" style="padding:10px 0 0 0; display:block; color:#000; font-size:10px;">Forgot your password?</a></td>
        </tr>
      </table>      
      </form>
       <div id="mask">
			<div id="toPopup"> 
				
				<div class="close"></div>
				
				<div id="popup_content"> <!--your content start-->
					<p style="font-family: Arial, Helvetica, sans-serif;font-size:15px;text-align: left; margin:0; color:#043215; background:none; padding:10px 0; font-weight:bold;">Forgot Password </p>
				
					<div id="process"></div>
					
					<form method="POST" name="forgot" id="forgot" action="">
						<div id="result1" style="color:#F00;"></div>
						
                         
                         
                       <font style="font-family:Arial, Helvetica, sans-serif; font-weight:bold; font-size:13px;">  Enter your Registered Email Id</font>
                          <div style="clear:both; height:1px;"></div>
						
                        <input type="text" name="forgotemail" id="forgotemail" class="forgot"  
						style=" text-indent: 8px;"  />
                          <div style="clear:both; height:5px;"></div>
						<input type="button" value="Email my Password to me" onClick="sendpass();" 
						class="forgot1">
					</form>
				</div> <!--your content end-->
			</div>
            </div>
		
	    
			
			 
           </div>
      
      
      <div id="adiv1" style="font:24px bold; display: none">
        <h1>Reset your password</h1>
        <table width="0" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td scope="col"><span class="required">Email Address*</span></td>
            <td scope="col"><input type="text" name="login-username"  class="tet" /></td>
          </tr>
          
            <td scope="col">&nbsp;</td>
            <td scope="col"><button name="login_submit" class="buttond blue" type="submit">Reset</button></td>
          </tr>
        </table>
      </div>
    </ul>
  </div>
  
  
  
  <%} %>
  
  
 </div> 
 </div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>