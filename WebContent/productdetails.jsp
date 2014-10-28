<jsp:include page="header1.jsp"></jsp:include>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.admin.action.*"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.util.Collections"%> 
 
<%@ page import="java.io.File"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% adminDAO obj;obj=new adminDAOImpl();%> 
<%request.setAttribute("menubar", request.getAttribute("menubar")); 
float firstprice=0.0f;%> 
<script type="text/javascript"> 
function changechield(PID)
   { 
		 var data = PID;
	 	 var arr = data.split('@@@@@');
	     $("#pval"+arr[2]).html("$"+arr[1]);
    
   } 
</script>
	<div style="clear: both;"></div>

<div style="clear:both;"></div>
<div class="container">
  <div class="navigation1">
			   <ul>
				<c:forEach items="${menunav}" var="m">
					<c:if test="${m.val eq '1'}">
						<li><a href="indexpage">Home  </a></li>
						<li>${m.categoryname}</li>
					</c:if>

					<c:if test="${m.val eq '2'}">
						<li><a href="indexpage">Home</a></li>
						<li><a href="Category?id=${m.webTypes}&cate=${m.categoryname}&subcatid=${m.subcatid}">${m.categoryname} </a></li>
						<li>${m.subcatname}</li>
					</c:if>

					<c:if test="${m.val eq '3'}">
						<li><a href="indexpage">Home</a></li> 
					    <li><a href="Category?id=${m.webTypes}&cate=${m.categoryname}&subcatid=${m.subcatid}&navfocat=3" >${m.categoryname}</a></li>
						<li><a href="Sucategory?id=${m.subcatid}&category=${m.categoryname}&cate=${m.subcatname}">${m.subcatname} </a></li>
						<li>${m.brand}</li>
					</c:if>
					
					<c:if test="${m.val eq '4'}">
						<li><a href="indexpage">Home</a></li> 
					    <li><a href="Category?id=${m.webTypes}&cate=${m.categoryname}&subcatid=${m.subcatid}&navfocat=3">${m.categoryname}</a></li>						
						<li>${m.brand}</li>
					</c:if>
					
				</c:forEach> 
			</ul>
		</div>
  <div style="clear:both; height:10px;"></div>
  <div class="row">
    <div class="col-md-4">
				<div id="block_navigation">
					<h1 class="Pedals">
						Shop by Category:
						<%=request.getAttribute("cat") %>
					</h1>
					<div id="pull">
						<a href="#"><i class="icon-reorder"></i>Shop by Category<span
							class="pull_span">+</span> </a>
					</div>
					<ul class="navigation">
						<ul>
							<c:forEach items="${subcategorylist}" var="m">
								
								 
								<c:if test="${m.status eq 'true'}">
								<li><a
									href="Sucategory?/<%=request.getAttribute("category")%>/${m.subcatname}&category=<%=request.getAttribute("category")%>&id=${m.id}&cate=${m.webdisplay}&subidd=${m.subcatid}">${m.webdisplay}
								</a></li>
								</c:if>
								
							</c:forEach>
						</ul>
					</ul>
				</div>
				<div style="clear: both; height: 15px;"></div>
				<div id="block_navigation1">
					<h1 class="Pedals">Shop by Brands</h1>
					<div id="pull1">
						<a href="#"><i class="icon-reorder"></i>Shop by Category <span
							class="pull_span"> </span> </a>
					</div>
					<ul class="navigation">
						<ul>
							<c:forEach items="${getbrandname}" var="m"> 
									<c:if test="${m.coupan_id >0}">
									<li>
									   <a
										href="manufacturer?<%=request.getAttribute("category")%>/${m.brand}/&webtypeid=${m.webTypes}&vid=${m.id}&cate=<%=request.getAttribute("category")%>&subcategoryname=<%=request.getAttribute("cat")%>&subcatid=${m.subcatid}&navforbrands=<%=request.getAttribute("navforbrands")%>&webtypes2=<%=request.getAttribute("webtypes2")%>&subCatID2=<%=request.getAttribute("subCatID2")%>&pcount=${m.coupan_id}">
											${m.brand} <font style="color:#039;">(</font><font style="color:#9d0000;">${m.coupan_id}</font><font style="color:#039;">)</font> </a>
								    </li>	 
								</c:if>   
							</c:forEach>
						</ul>
					</ul>
				</div>
			</div>
    <div class="col-sm-8">
      <div class="matter" style="background:#FFF; width: 100%;">
       <h1 class="name" style="float: left;"><%if((Integer)request.getAttribute("pcount")==0) { %> Latest Deals for <%=request.getAttribute("producttype") %><%} else {%><%=request.getAttribute("pcount") %>   item(s)  found in <%=request.getAttribute("producttype") %> <%} %>  </h1> 
        <div style="clear:both;"></div>
        </div>
        <div style="clear:both;"></div>
         <div id="main-content" class="box"  style="background:#FFF; width: 100%;">
			<div class="center">
				<div id="page-content" class="box">

					<!-- tabs navigation --> 
<!-- demo -->
<div id="demo" class="box jplist">
					
						<!-- ios button: show/hide panel -->
						<div class="jplist-ios-button">
							<i class="fa fa-sort"></i>
							jPList Actions
						</div>
						
						<!-- panel -->
						<div class="jplist-panel box panel-top">						
							
							<!-- row -->
							<div class="box"> 
								<!-- reset button --> 
								<div 
			class="jplist-drop-down" 
			data-control-type="drop-down" 
			data-control-name="paging" 
			data-control-action="paging"> 
			<ul>
				<li><span data-number="9" data-default="true"> 9 per page </span></li>
				<li><span data-number="21"> 21 per page </span></li>
				<li><span data-number="60"> 60 per page </span></li> 
				<li><span data-number="all"> view all </span></li>
			</ul>
		</div>  
						<!-- filter by title --> 
							</div> 
							<!-- row -->
							<div class="box">
								<!-- likes range slider -->
								<!-- prices range slider -->
								 
								<div class="slider">
                                	<div 
									class="jplist-range-slider"
									data-control-type="range-slider-prices" 
									data-control-name="range-slider-prices" 
									data-control-action="filter"
									data-path=".price">
									
									<div class="value" data-type="prev-value"></div>
									<div class="ui-slider" data-type="ui-slider"></div>
									<div class="value" data-type="next-value"></div>
								</div>
                                </div>
								 
								<!-- views range slider -->
							  <div class="clr"></div>
							
							<!-- row -->
							<div class="box">
								<!-- pagination results -->
								<div 
									class="jplist-label" 
									data-type="Page {current} of {pages}" 
									data-control-type="pagination-info" 
									data-control-name="paging" 
									data-control-action="paging">
								</div>
									
								<!-- pagination -->
								<div 
									class="jplist-pagination" 
									data-control-type="pagination" 
									data-control-name="paging" 
									data-control-action="paging">
								</div>
							</div>
						</div>
						 
												<!-- data -->   
						<div class="clr"></div>
						<div class="list box text-shadow"> 
						<%int pccount=1;int i=1; float minprice=0;float maxprice=0;float oprice =0;float nprice =0;ArrayList<Float> f=new ArrayList(); %>
						
						<c:forEach items="${details}" var="m">
									 
									<c:set var="myVariable" value="${m.id}" />
									<c:set var="ispar" value="${m.isparent}" />
								    <%int myVariable = (Integer)pageContext.getAttribute("myVariable");
								    ArrayList colorandsize;colorandsize=obj.getcolorandsizedetails(String.valueOf(myVariable));
								    request.setAttribute("colorandsize", colorandsize);%>
									 <c:choose>
										 <c:when test="${empty colorandsize and m.isparent eq '1'}"> 
											   
										 </c:when> 
									  <c:otherwise> 
											      
											    	 <div class="list-item box">
											  <div class="col-6 col-sm-6 col-lg-7">
												 <div class="cycles right">
													<center>
													<c:set var="prodname1" value="${m.product_name}" />
													<%String prodname1 = (String)pageContext.getAttribute("prodname1");%> 	
													<a href="Item?${m.SKU}/<%=prodname1.replace('"','\'')%>&id=${m.id}&subid=${m.subcatid}">											
													<div class="fix-weight">
													<img src="productimages/${m.picturename}" class="img1"></div>
													</a>		
													</center> 					
													
													<form action="addtocart" method="post">
													
													<c:choose>
														<c:when test="${empty colorandsize }">
															<div>
																<div class="else2"></div>
																<p>
																	<b>
																	<c:set var="prodname" value="${m.product_name}" />
																<%String prodname = (String)pageContext.getAttribute("prodname");%>  
																	<a
																		href="Item?${m.SKU}/<%=prodname.replace('"','\'')%>&id=${m.id}&subid=${m.subcatid}">
																			<c:if test="fn:length(string1)  >=150}">
																			</c:if> <c:if test="${fn:length(m.product_name)>100}">
																				<c:set var="string2"
																					value="${fn:substring(m.product_name, 0, 98)}" />
														    ${string2} 
														</c:if> <c:if test="${fn:length(m.product_name)<=100}">
															 ${m.product_name} 
														</c:if>
																	</a></b>
																</p>
															</div>
															<c:set var="firstprice" value="${m.price}"></c:set>
															<%firstprice = (Float) pageContext.getAttribute("firstprice"); %>
														</c:when>

														<c:otherwise>
														
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
																		<b><a
																			href="Item?/${m.SKU}/${m.product_name}&id=${m.id}&subid=${m.subcatid}">
																				${m.product_name}</a></b>
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
															<div>
																<p>
																	<b><a
																		href="Item?/${m.SKU}/${m.product_name}&id=${m.id}&subid=${m.subcatid}">
																			${m.product_name} </a></b>
																</p>
															</div>
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
										 <div class="font2">
										 
										 </div>
									</c:if>
									
									
								 
									
													
													<table>
                                     <tr> 
                                       <td class="Quantity1"> 
                                       <input type="hidden" name="qtyinpdes" value="1">
                                       </td>
                                     </tr>
                                   </table>  
                                   <div class="Quantity-clear"></div>
													<table>
														<tbody>
															<tr>
                                                        <c:set var="balance" value="${m.price}" /> 
											 
    		 
																<td class="tab">
																<div class="price">
																<div id="pval<%=i%>">
																<fmt:formatNumber value="<%=firstprice%>" type="currency"/></div></div></td>
																 <td><input type="hidden" name="prodId"
																	value="${m.id}" /></td>
																<td class="tab2"><input type="submit" value=""
																	class="cart" /></td>
																<td class="tab3"><div class="deatil">
																<c:set var="prodname" value="${m.product_name}" />
																<%String prodname = (String)pageContext.getAttribute("prodname");%> 
																		<a
																			href="Item?${m.SKU}/<%=prodname.replace('"','\'')%>&id=${m.id}&subid=${m.subcatid}">
																			More Info..</a>
																	</div></td>
															</tr>
														</tbody>
													</table>
												 
												  </form>
												</div>
												<div style="clear: both;"></div>
											</div>
										</div>
		 								   
											<c:set var="pprice" value="${m.price}" />
											
										   <%float price = (Float)pageContext.getAttribute("pprice");
										   
										      f.add(price);  
										    %>	     
										
									 </c:otherwise>
								 </c:choose> 
										<% i++;pccount++;%>
									</c:forEach> 
									<%
									  Collections.sort(f); 
									  float minv=f.get(0);									  
									  float maxv=f.get(f.size()-1);
									%>
									<div id="minv" style="display: none;"><%= minv %></div>
									<div id="maxv" style="display: none;"><%= maxv %></div>
								</div>
						
						
						
						
						
						
						
						 
						
						<div class="box jplist-no-results text-shadow align-center">
							<p>No results found</p>
						</div>
						
						<!-- ios button: show/hide panel -->
						<div class="jplist-ios-button">
							<i class="fa fa-sort"></i>
							jPList Actions
						</div>
						<div style="clear:both;"></div>
						<!-- panel -->
						<div class="jplist-panel box panel-bottom">						
													
							 <div 
			class="jplist-drop-down" 
			data-control-type="drop-down" 
			data-control-name="paging" 
			data-control-action="paging">
				
			 
			
								
			<ul>
				<li><span data-number="9" data-default="true"> 9 per page </span></li>
				<li><span data-number="21"> 21 per page </span></li>
				<li><span data-number="60"> 60 per page </span></li> 
				<li><span data-number="all"> view all </span></li>
			</ul>
		</div> 
							
							<!-- pagination results -->
							 
								
							<!-- pagination -->
							<div 
								class="jplist-pagination" 
								data-control-type="pagination" 
								data-control-name="paging" 
								data-control-action="paging"
								data-control-animate-to-top="true">
							</div>	
								
						</div>
					</div>
<!-- end of demo -->				

				</div>
			</div>
		</div>
</div>
     
     
      
      <!--/row--> 
    </div>
    <div style="clear:both;"></div>
    <!-- Example row of columns -->
    <div style="clear:both;"></div>
  </div>
</div>
</div>
</div>
</div>
<div style="clear:both; height:15px;"></div>
 
<div style="clear:both; height:15px;"></div>
 
	<jsp:include page="footer.jsp"></jsp:include>