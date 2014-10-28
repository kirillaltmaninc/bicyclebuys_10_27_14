<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.admin.action.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% adminDAO obj;obj=new adminDAOImpl();%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp"></jsp:include>
 
<body>
 <div class="container">
 	<div class="add-to-cart"> 
				<div class="clear"></div>
<div class="table-responsive">
				<div class="Courses1">
 <div class="clear"></div>
 <div class="shipping-center">
  <h1>Order Details</h1>
 	<table>
 	  <tbody>
 	   <tr>
         <td><strong>Your OrderID is</strong> </td>
         <td>FEDEX Ground-US Mail</td>
       </tr>
       
       <tr>
         <td><strong>Sales Tax state wise %</strong></td>
         <td>FEDEX Ground-US Mail</td>
       </tr>
       
       <tr>
         <td><strong>Your OrderID is</strong></td>
         <td>FEDEX Ground-US Mail</td>
       </tr>
       
       <tr>
         <td><strong>Tax Charges</strong></td>
         <td>FEDEX Ground-US Mail</td>
       </tr>
       
       <tr>
         <td><strong>Final Total</strong></td>
         <td>FEDEX Ground-US Mail</td>
       </tr>
       
       <tr>
         <td><strong>Coupon price</strong></td>
         <td>FEDEX Ground-US Mail</td>
       </tr>
       
       <tr>
         <td><strong>Tax Charges</strong></td>
         <td>FEDEX Ground-US Mail</td>
       </tr>
       
       <tr>
         <td><strong>Sub Total</strong></td>
         <td>FEDEX Ground-US Mail</td>
       </tr> 
     </tbody>
 	</table>
 	
 	<h1>Shipping Via</h1>
 	<table width="50%">
 	  <tbody>
 	   <tr>
         <td><strong>Ship Via</strong> </td>
         <td>
           <select>
             <option value="">Choose Shipping</option>
           </select>
         </td>
       </tr>
       
       <tr>
         <td><strong>S&H</strong></td>
         <td>$ 45</td>
       </tr> 
       
       <tr>
         <td><strong>Total w/ Shipping</strong></td>
         <td>$ 5956</td>
       </tr>  
       
     </tbody>
 	</table>
 	
 </div>
 
 <div class="continuepayment">
                           <form action="makepaymentdetails" method="post">
								<div class="Customer-Login">
									<table>
										<tbody>
										<tr>											 
											<td><input type="hidden" name="email" class="tet"></td>
											<td><input type="hidden" name="email" class="tet"></td>
											<td><input type="hidden" name="email" class="tet"></td>
											<td><input type="hidden" name="email" class="tet"></td>
											<td><input type="hidden" name="email" class="tet"></td>
										</tr> 

										<tr>  
											<td><input type="submit" value="Continue" class="buttond blue"></td>
										</tr>
									</tbody></table>
								</div>
							</form>
      </div>
					 

					<div class="clear"></div>


				</div>
				</div>

				<div class="clear"></div>
				 <div class="clear"></div>
				 <div class="table-responsive">
						<div class="login1">
							<h1>Paymeasdnt vbnnvnvnvnGateway</h1>
  <div class="table-responsive">
							<form action="" method="post">
								<div class="Customer-Login">
									<table>
										<tbody><tr>
											<td>Name:</td>
											<td><input type="text" name="email" class="tet"></td>
										</tr>

										<tr>
											<td>password:</td>
											<td><input type="password" name="pwd" class="tet"></td>
										</tr>

										<tr>
											<td></td>
											<td><input type="submit" value="Login" class="buttond blue"></td>
										</tr>
									</tbody></table>
								</div>
							</form>
							</div>
						</div>
						</div>
			</div>
 </div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
