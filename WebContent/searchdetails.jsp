<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.admin.action.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% adminDAO obj;obj=new adminDAOImpl();float firstprice=0.0f;%>
<script type="text/javascript"> 
function changechield(PID)
   { 
		 var data = PID;
	 	 var arr = data.split('@@@@@');
	     $("#pval"+arr[2]).html("$"+arr[1]);
    
   } 
</script>
<!doctype html>
<html>
<jsp:include page="header1.jsp"></jsp:include>
<body>

	<div class="clear"></div>
	<div class="container">
		<div class="navigation1">
			<ul>
				<c:forEach items="${menunav}" var="m">
					<c:if test="${m.val eq '1'}">
						<li><a href="indexpage">Home</a></li>
						<li>${m.categoryname}</li>
					</c:if>

					<c:if test="${m.val eq '2'}">
						<li><a href="indexpage">Home</a></li>
						<li><a
							href="Category?id=${m.catid}&cate=${m.categoryname}">
								${m.categoryname} </a></li>
						<li>${m.subcatname}</li>
					</c:if>

					<c:if test="${m.val eq '3'}">
						<li><a href="indexpage">Home</a></li>
						<li><a
							href="Category?id=${m.catid}&cate=${m.categoryname}">
								${m.categoryname}</a></li>
						<li><a
							href="getproductsubcategorywise?id=${m.subcatid}&cate=${m.webdisplay}">
								${m.webdisplay} </a></li>
						<li>${m.brand}</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
		<div class="clear"></div>
		<div class="row">
			 
			<div class="col-xs-12 col-sm-8" id="style">
				<div class="matter">
				 	 
				 
				</div>
			 
				<div id="main-content" class="box">
					
					<div class="center">
				<div id="page-content" class="box">
<h1 class="name">Product List  :  &nbsp;&nbsp;   Total <font color="red">(</font><%=request.getAttribute("totalcount") %>  <font color="red">)</font>&nbsp; Result</h1> 
					
					 
<div id="demo" class="box jplist">
					
	<!-- ios button: show/hide panel -->
	<div class="jplist-ios-button">
		<i class="fa fa-sort"></i>
		jPList Actions
	</div>
	
	                 <c:choose>
							 <c:when test="${empty details}"> 
											   
							 </c:when>
										 
							 <c:otherwise>
							 <div class="jplist-panel box panel-top"> 
		<div 
			class="jplist-drop-down" 
			data-control-type="drop-down" 
			data-control-name="paging" 
			data-control-action="paging">
			<ul>
				<li><span data-number="8" data-default="true"> 8 per page </span></li>
				<li><span data-number="16"> 16 per page </span></li>
				<li><span data-number="40"> 40 per page </span></li> 
				<li><span data-number="all"> view all </span></li>
			</ul>
		</div>
							
		<!-- sort dropdown -->
		 

	 
	 
							
		<!-- filter by description -->
	 
							
		<!-- pagination results -->
		 
								
		<!-- pagination -->
		<div 
			class="jplist-pagination" 
			data-control-type="pagination" 
			data-control-name="paging" 
			data-control-action="paging">
		</div>
							
	</div>
							 </c:otherwise> 
					 </c:choose> 
	 				<div class="clr"></div>
    						<!-- data -->   
						<div class="list box text-shadow">
                    <%int i=1; %>
						<c:forEach items="${details}" var="m"> 
									<c:set var="myVariable" value="${m.id}" />
									<c:set var="ispar" value="${m.isparent}" />
								    <%int myVariable = (Integer)pageContext.getAttribute("myVariable");ArrayList colorandsize;colorandsize=obj.getcolorandsizedetails(String.valueOf(myVariable));request.setAttribute("colorandsize", colorandsize);%>
									<c:choose>
										 <c:when test="${empty colorandsize and m.isparent eq '1'}"> 
											   
										 </c:when>	
										 <c:otherwise>
										 <div class="list-item">
											<div class="col-6 col-sm-6 col-lg-5">
												
												<div class="cycles">
												
												<form action="addtocart" method="post">
								<center>
									<a href="Item?id=${m.id}&subid=${m.subcatid}">
									<div class="fix-weight">
												<img src="productimages/${m.picturename}" class="img1" />
										</div>
									</a>
									
								</center> 
								 
								<c:set var="myVariable" value="${m.id}" /> 
								<c:choose>
									<c:when test="${empty colorandsize }">
										<div>
											<div class="else5"></div>
											<p>
												<b> 
												<c:set var="prodname" value="${m.product_name}" />
                                                <%String prodname = (String)pageContext.getAttribute("prodname");%>   
												<a
													href="Item?/${m.SKU}/<%=prodname.replace('"','\'')%>&id=${m.id}&subid=${m.subcatid}">
													<c:if test="fn:length(string1)  >=150}"> 
														</c:if>
														<c:if test="${fn:length(m.description)>100}">
														<c:set var="string2" value="${fn:substring(m.description, 0, 98)}" />
														    ${string2} 
														</c:if>
														<c:if test="${fn:length(m.description)<=100}">
															 ${m.description}
														</c:if> 
														${m.product_name}</a></b> 
											</p>
										</div>
										<c:set var="firstprice" value="${m.price}"></c:set>
															<%firstprice = (Float) pageContext.getAttribute("firstprice"); %>
									</c:when> 

									<c:otherwise>
										<p>
											<b>
											<c:set var="prodname" value="${m.product_name}" />
                                           <%String prodname = (String)pageContext.getAttribute("prodname");%>  
											<a
												href="Item?/${m.SKU}/<%=prodname.replace('"','\'')%>&id=${m.id}&subid=${m.subcatid}">
													${m.product_name} </a></b>
										</p>
										<p>
											<select name="colorandsizeid" class="dropdown" onchange="changechield(this.value)">
											<%int k=0; %>  
												<c:forEach items="${colorandsize}" var="aa">
												 <c:set var="chprice" value="${aa.price}" />
																<c:set var="pprice" value="${m.price}" /> 
                                                               <%float chprice1 = (Float)pageContext.getAttribute("chprice");
                                                               
                                                               if(k==0)
                                                               {
                                                            	firstprice=chprice1;
                                                            	
                                                            	k++;
                                                               }
                                                               
                                                               float price1 = (Float)pageContext.getAttribute("pprice");
                                                               
                                                               
                                                               String value="";
                                                               float fprice=0.0f;
                                                               if(chprice1<price1)
                                                               {
                                                                  fprice= (chprice1-price1);
                                                                  value="-";
                                                               }
                                                               else
                                                               {
                                                            	     fprice=(chprice1-price1);
                                                            	   value="+";
                                                               }
                                                               
                                                                %> 
                        
													<p>
														<b>  
																		<a
																			href="Item?/${m.SKU}/${m.description}&id=${m.id}&subid=${m.subcatid}">
																				${m.description}</a>
																				
																</b>
													</p>
													<%if(price1==chprice1) {%>
																	  <option value="${aa.colorandsize}<>${aa.id}@@@@@<%= chprice1 %>@@@@@<%=i %>">${aa.colorandsize}  
																	 <%} else {%>
																	 <option value="${aa.colorandsize}<>${aa.id}@@@@@<%= chprice1 %>@@@@@<%=i %>">${aa.colorandsize}  
																	  <%=value %> <fmt:formatNumber value="<%=fprice %>" type="currency"></fmt:formatNumber>
																	 <%} %>
																	</option>
																</c:forEach>
											</select>
										</p>
										<div></div>
									</c:otherwise>
								</c:choose> 
								
								 
									
								   <div class="font">
									<c:if test="${m.price >=90 and m.ovw > 1}"> 
										<font color="blue">	Overweight, Oversized item.  Free Shipping does not apply. &nbsp;&nbsp;</font>
									</c:if> 
									
									<c:if test="${m.price >=90 and m.ovw <= 1}">
										Free Shipping with FEDEX Ground-US Mail 
									</c:if> 
									
									 </div>
								    <c:if test="${m.price <=90}">
										 <div class="font1">
										 
										 </div>
									</c:if>
									
							 

                                  <table>
                                     <tr> 
                                       <td class="Quantity1">
                                       <input type="hidden" name="qtyinpdes" value="1" readonly="readonly"/>  
                                       </td>
                                     </tr>
                                   </table>  
								 <div class="Quantity-clear"></div>
								<table   >
    		<tr>
    		<td class="tab">
    		<div class="rs">
    		<div id="pval<%=i%>">
    		<fmt:formatNumber value="<%=firstprice%>" type="currency"/>
    		
    		</div> 
    		 </div>
																
    		</td>
    		<td><input type="hidden" name="prodId" value="${m.id}"></td>
    		<%-- <td width="18%" background="#525250"><div class="cart"><a href="addtocart?id=<%=e.getId()%>"><img src="images/cart.png" ></a></div></td> --%>
    		<td class="tab2"> <input type="submit" value="" class="cart"> </td>
    		<td class="tab3"><c:set var="prodname" value="${m.product_name}" />
              <%String prodname = (String)pageContext.getAttribute("prodname");%>  
    		<div class="deatil"><a href="Item?/${m.SKU}/<%=prodname.replace('"','\'')%>&id=${m.id}&subid=${m.subcatid}">More Info..</a></div></td>
    		</tr>
    	</table> 
								</form> 
												</div>
												<div style="clear: both;"></div>
											</div>
										</div>
										 </c:otherwise>
										 
									</c:choose>
									<%i++;%>
									</c:forEach>
									<!-- item 33 -->
								</div>
						<div class="clr"></div>
	<div class="box jplist-no-results text-shadow align-center">
		<p>Sorry items matching your criteria were not found.</p>
	</div>
						
	<!-- ios button: show/hide panel -->
	<div class="jplist-ios-button">
		<i class="fa fa-sort"></i>
		jPList Actions
	</div>
						
	<!-- panel -->
	<c:choose>
		 <c:when test="${empty details}"> 
											   
		  </c:when> 					 
		 <c:otherwise> 
						<div class="jplist-panel box panel-bottom">
							
		<!-- items per page dropdown -->
		<div 
			class="jplist-drop-down" 
			data-control-type="drop-down" 
			data-control-name="paging" 
			data-control-action="paging"
			data-control-animate-to-top="true"> 
			<ul>
				<li><span data-number="8" data-default="true"> 8 per page </span></li>
				<li><span data-number="16"> 16 per page </span></li>
				<li><span data-number="40"> 40 per page </span></li> 
				<li><span data-number="all"> view all </span></li>
			</ul>
		</div>
														
		<!-- sort dropdown -->
		 
							
		<!-- pagination results -->
		 
								
		<!-- pagination -->
		<div 
			class="jplist-pagination" 
			data-control-animate-to-top="true"
			data-control-type="pagination" 
			data-control-name="paging" 
			data-control-action="paging">
		</div>
							
	</div>	 
		 </c:otherwise>
							 
		 </c:choose>
	
	 
</div>
<div class="space"></div>
<!-- end of demo -->				

				</div>
			</div>
					
					
					
					 
				</div>



				<!--/row-->
			</div>
			<div class="clear"></div>
			<!-- Example row of columns -->
			<div class="clear"></div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
