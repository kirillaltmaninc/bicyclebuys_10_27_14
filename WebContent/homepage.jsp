<jsp:include page="header.jsp"></jsp:include>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.admin.action.*"%>
<%@ page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% adminDAO obj;obj=new adminDAOImpl(); 
float firstprice=0.0f;%> 
<script type="text/javascript"> 
function changechield(PID)
   {  
		 var data = PID;
	 	 var arr = data.split('@@@@@');
	     $("#pval"+arr[2]).html("$"+arr[1]);
    
   } 
</script>
<!DOCTYPE html>
<html lang="en">
 
<body>
	<div style="clear: both;"></div>
	<div class="container">
		<div style="clear: both;"></div>
		<div class="row">
			<div class="col-md-4">
			 
			<span class="homecataloglabel">Shop by Categories </span>
			 <div id="mydiv">
			  <span id="loading"><center>  </center></span>


 
  <span id="content" style="display: none;" >
  <div class="category-inner">
					 
					
					<div id="zubair" > 
						<!-- Category and sub category Details --> 
						
						<div id="menudiv">
						
						<div class="drop">
         	  
          
         <div id="treeMenu">
 
        <ul >
        
        <c:forEach items="${details}" var="m">
									 <li><a href="Category?/${m.categoryname}/&id=${m.webTypes}&cate=${m.categoryname}&subcatid=${m.subcatid}" class="parent">${m.categoryname} fddsfsfs</a><span></span>
          
          	<c:set var="myVariable1" value="${m.subcatid}" />
										<c:set var="myVariable2" value="${m.webTypes}" /> 
										<%String myVariable1 = (String)pageContext.getAttribute("myVariable1");
										String myVariable2 = (String)pageContext.getAttribute("myVariable2");
										ArrayList getsubcategory=obj.getsubcategorylist(myVariable1,myVariable2);
										request.setAttribute("getsubcategory", getsubcategory);%> 
										
										 
          	<ul>
             <div>
             <c:choose>
										 <c:when test="${empty getsubcategory}"> 
											   
										 </c:when> 
									  <c:otherwise> 
									  <ul >
											  
											<c:forEach items="${getsubcategory}" var="m1">  
												<c:if test="${m1.status eq 'false'}">
												 
												</c:if> 
												<c:if test="${m1.status eq 'true'}">
												<li><span></span> <a
									href="Sucategory?/${m.categoryname}/${m1.subcatname}&id=${m1.id}&category=${m.categoryname}&cate=${m1.webdisplay}">${m1.webdisplay}
								     </a></li>  
										 
												</c:if> 
												
											</c:forEach> 
											 
										</ul> 
									  </c:otherwise>
									  </c:choose> 
            	 
                 </div>
            </ul>
             
             </li>
									 
										</li>
										 
										
								</c:forEach>
         
             
             
         
         
           
           
           
        </ul>
</div>
         </div>
							   <ul id="menu1">
							   
								<c:forEach items="${details}" var="m">
									
									<c:if test="${m.status eq 'false'}"></c:if>
									<c:if test="${m.status eq 'true'}">
									<li class="loaded"><a
										href="Category?/${m.categoryname}/&id=${m.webTypes}&cate=${m.categoryname}&subcatid=${m.subcatid}">
										${m.categoryname} </a>  
										<c:set var="myVariable1" value="${m.subcatid}" />
										<c:set var="myVariable2" value="${m.webTypes}" /> 
										<%String myVariable1 = (String)pageContext.getAttribute("myVariable1");
										String myVariable2 = (String)pageContext.getAttribute("myVariable2");
										ArrayList getsubcategory=obj.getsubcategorylist(myVariable1,myVariable2);
										request.setAttribute("getsubcategory", getsubcategory);%> 
										 
										 <c:choose>
										 <c:when test="${empty getsubcategory}"> 
											   
										 </c:when> 
									  <c:otherwise> 
									  <ul>
											<h1>Sub Category</h1> 
											<c:forEach items="${getsubcategory}" var="m1">  
												<c:if test="${m1.status eq 'false'}">
												 
												</c:if> 
												<c:if test="${m1.status eq 'true'}">
												<li><a
									href="Sucategory?/${m.categoryname}/${m1.subcatname}&id=${m1.id}&category=${m.categoryname}&cate=${m1.webdisplay}">${m1.webdisplay}
								     </a></li>  
										 
												</c:if> 
												
											</c:forEach> 
											 
										</ul> 
									  </c:otherwise>
									  </c:choose>
											
										 
										</li>
										</c:if>
								</c:forEach>
							</ul>   
			 
						</div>
					</div>
					
					
					
					
					
				</div>
  </span>
  
			 </div>
				
			</div>
			<!-- Promotional Details -->
			<div class="col-xs-12 col-sm-9">
				<div id="wowslider-container1">
					<div class="ws_images">
					
					<script type="text/javascript">
			                    function geturllocation (a) 
			                    { 
			                    	$.ajax({
			                    	    type: 'HEAD',
			                    	    url: a,
			                    	success: function() {
			                    		window.location.href = a;
			                    	},
			                    	error: function() {
			                    		window.location ='MainPageNotFound.jsp';
			                    	}
			                    	}); 
			                    } 
                       </script>

						<c:forEach items="${promo}" var="m">
						
						<c:set var="prodname" value="${m.product_name}" />
                        <%String prodname = (String)pageContext.getAttribute("prodname");%>  
							<a href="#" onclick="geturllocation('${m.link}');"><img 
								src="productimages/${m.picturename}" alt="banner" /></a>
						</c:forEach>  
					</div>
				</div>
				<div style="clear: both;"></div>
				<div class="banner1">
					<div style="width: 100%;">
						<img src="images/news-arrow-previous.png" class="previous" />
						<div id="newsticker-demo1">
							<ul>
								<c:forEach items="${specials}" var="m">
									<li><a href="Item?id=${m.id}&subid=${m.subcatid}"><img src="productimages/${m.picturename}"> </a> <span class="title"><!-- ${m.description} --></span></li>
								</c:forEach>
							</ul>
						</div>
						<img src="images/news-arrow.png" class="next" />
						<div class="final-clr"></div>
					</div>
					 
				</div>
			</div>

		</div>
		 
		<div class="final-clr1"></div>
		<div class="row">
			<!-- Hot deals Details -->
			<div class="products">
				 <h1>Hot Deal</h1> 
			</div>

                  
				<%int j=1; %>						 		
			  <c:forEach items="${hotdeals}" var="m"> 
                 <c:set var="myVariable" value="${m.id}" />
				  <%int myVariable = (Integer)pageContext.getAttribute("myVariable");ArrayList colorandsize;colorandsize=obj.getcolorandsizedetails(String.valueOf(myVariable));request.setAttribute("colorandsize", colorandsize);%>
						<c:choose>
							 <c:when test="${empty colorandsize and m.isparent eq '1'}"> 
											   
							 </c:when>
										 
							 <c:otherwise>
								<div class="col-6 col-sm-6 col-lg-5">
					<div class="product-details">
						<ul>
							<li>
							<form action="addtocart" method="post">
								<center>
									<a href="Item?id=${m.id}&subid=${m.subcatid}">
										<div class="fix-weight">
												<img src="productimages/${m.picturename}" class="img1" />
										</div>
									
									</a>
									
								</center> 
								<c:choose>
									<c:when test="${empty colorandsize }">
										<div>
											 
												<div class="else"></div>
											<p>
												<b><a
													href="Item?id=${m.id}&subid=${m.subcatid}">
														  
														<c:if test="fn:length(string1)  >=150}"> 
														</c:if>
														<c:if test="${fn:length(m.product_name)>100}">
														<c:set var="string2" value="${fn:substring(m.product_name, 0, 98)}" />
														    ${string2} 
														</c:if>
														<c:if test="${fn:length(m.product_name)<=100}">
															 ${m.product_name}
														</c:if> 
														</a></b>
											</p>
										</div>
										<c:set var="firstprice" value="${m.price}"></c:set>
															<%firstprice = (Float) pageContext.getAttribute("firstprice"); %>
									</c:when>

									<c:otherwise>
										<p>
											<b><a
												href="Item?id=${m.id}&subid=${m.subcatid}">
													${m.product_name} </a></b>
										</p>
										<p>
											<select name="colorandsizeid" class="dropdown"  
															 onchange="changechield(this.value)">
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
                                                               
                                                               
                                                               String sign="";
                                                               float fprice=0.0f;
                                                               if(chprice1<price1)
                                                               {
                                                                  fprice= (chprice1-price1);
                                                                  sign="-";
                                                               }
                                                               else
                                                               {
                                                            	     fprice=(chprice1-price1);
                                                            	     sign="+";
                                                               }
                                                               
                                                                %> 
                        
																	<p>
																		<b><a
																			href="Item?/${m.SKU}/${m.product_name}&id=${m.id}&subid=${m.subcatid}">
																				${m.product_name}</a></b>
																	</p>
													                <%if(price1==chprice1) {%>
																	  <option value="${aa.colorandsize}<>${aa.id}@@@@@<%= chprice1 %>@@@@@<%=j %>">${aa.colorandsize}  
																	 <%} else {%>
																	 <option value="${aa.colorandsize}<>${aa.id}@@@@@<%= chprice1 %>@@@@@<%=j %>">${aa.colorandsize}  
																	  <%=sign %> <fmt:formatNumber value="<%=fprice %>" type="currency"></fmt:formatNumber>
																	 <%} %>
																	</option>
																</c:forEach>
												 </select>
										</p>
										<div></div>
									</c:otherwise>
								</c:choose> 
								
								 
									<div class="font">
									<c:if test="${m.price >=90}">
										Free Shipping with FEDEX Ground-US Mail!)
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
								<table>
									<tbody>
										<tr>
									        <c:set var="balance" value="${m.price}" /> 
											<td class="tab">
											<div class="rs">
											<div id="pval<%=j%>"> 
											<fmt:formatNumber value="<%=firstprice%>" type="currency"/></div></div>
											</td>
											<td><input type="hidden" name="prodId" value="${m.id}"></td>
											<td><input type="hidden" value="1" name="qtyinpdes"/> </td>
											<td class="tab2"> <input type="submit" value="" class="cart"></td>
											<td class="tab3"><div class="deatil">
													
													<c:set var="prodname" value="${m.product_name}" />
                                             <%String prodname = (String)pageContext.getAttribute("prodname");%>  
													<a
														href="Item?/${m.SKU}/<%=prodname.replace('"','\'')%>&id=${m.id}&subid=${m.subcatid}">
														More Info.. </a>
												</div></td>
										</tr>
									</tbody>
								</table>
								</form>
							</li>
						</ul>
					</div>
				</div>		 
							 </c:otherwise>
										 
					   </c:choose>
				
				<%j++; %>
			</c:forEach>
		</div>

		<!-- New products Details -->

		 <div class="row">
    <div class="products">
      <h1>New Products</h1>
    </div>
    
     <c:forEach items="${newproduct}" var="m"> 
     <c:set var="myVariable" value="${m.id}" /> <%int myVariable = (Integer)pageContext.getAttribute("myVariable");ArrayList colorandsize;colorandsize=obj.getcolorandsizedetails(String.valueOf(myVariable));request.setAttribute("colorandsize", colorandsize);%>
     <c:choose>
		  <c:when test="${empty colorandsize and m.isparent eq '1'}"> 
											   
		  </c:when>
										 
	      <c:otherwise>
					<div class="col-6 col-sm-6 col-lg-5">
					<div class="product-details">
						<ul>
							<li>
							<form action="addtocart" method="post">
								<center>
									<a href="Item?id=${m.id}&subid=${m.subcatid}">
									<div class="fix-weight">
												<img src="productimages/${m.picturename}" class="img1" />
										</div>
									</a>
									
								</center> 
								<c:choose>
									<c:when test="${empty colorandsize }">
										<div>
											<div class="else1"></div>
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
											   </a></b> 
											</p>
										</div>
									</c:when> 
									<c:otherwise>
										<p>
											<b>
											<c:set var="prodname" value="${m.product_name}" />
                                           <%String prodname = (String)pageContext.getAttribute("prodname");%>  
											<a
												href="Item?/${m.SKU}/<%=prodname.replace('"','\'')%>&id=${m.id}&subid=${m.subcatid}">
													${m.description} </a></b>
										</p>
										<p>
											<select name="colorandsizeid" class="dropdown">
												<c:forEach items="${colorandsize}" var="aa">
													<p>
														<b><a
															href="Item?id=${m.id}&subid=${m.subcatid}">
																${m.description} </a></b>
													</p>
													<option value="${aa.colorandsize}<>${aa.id}">${aa.colorandsize}
													</option>
												</c:forEach>
											</select>
										</p>
										<div></div>
									</c:otherwise>
								</c:choose> 
								
								
								   <div class="font">
									<c:if test="${m.price >=90}">
										Free Shipping with FEDEX Ground-US Mail!)
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
    		<c:set var="balance" value="${m.price}" /> 
											 
    		<td class="tab"><div class="rs"><fmt:formatNumber value="${balance}" type="currency"/></div></td>
    		<td><input type="hidden" name="prodId" value="${m.id}"></td>
    		<%-- <td width="18%" background="#525250"><div class="cart"><a href="addtocart?id=<%=e.getId()%>"><img src="images/cart.png" ></a></div></td> --%>
    		<td class="tab2"> <input type="submit" value="" class="cart"> </td>
    		<td class="tab3"><c:set var="prodname" value="${m.product_name}" />
<%String prodname = (String)pageContext.getAttribute("prodname");%>  
    		<div class="deatil"><a href="Item?/${m.SKU}/<%=prodname.replace('"','\'')%>&id=${m.id}&subid=${m.subcatid}">More Info..</a></div></td>
    		</tr>
    	</table> 
								</form> 
							</li>
						</ul>
					</div>
				</div>		 
		  </c:otherwise>
							 
	 </c:choose>
     
     
     
    </c:forEach>
    </div></div>
			<!-- Include footer -->
			<jsp:include page="footer.jsp"></jsp:include>  
</body>
</html>
