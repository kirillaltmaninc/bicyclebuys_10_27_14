<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.dbconnect.Dbconnect"%> 
 <%@ page import="com.admin.action.*"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.io.File"%>
<% adminDAO obj;obj=new adminDAOImpl();%>  
 <link rel="stylesheet" href="css/styles.min.css" />
<link href="js/jplist.min.css" rel="stylesheet" type="text/css" /> 
<script src="js/jquery-1.10.0.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jplist.min.js"></script>
<script>
$('document').ready(function(){
$('#demo1').jplist({

itemsBox: '.list'
,itemPath: '.list-item'
,panelPath: '.jplist-panel'

//save plugin state
,storage: 'localstorage' //'', 'cookies', 'localstorage'
,storageName: 'jplist-div-layout'
});
});

</script> 
	<%
		String slider = request.getParameter("slider");
        String slider1 = request.getParameter("slider1"); 
        String webtype = request.getParameter("webtype"); 
        String subcat=request.getParameter("subcat");
        String SubCategoryforCategoryAndVendors=request.getParameter("SubCategoryforCategoryAndVendors"); 
        String VID=request.getParameter("VID");
        String VIDwebtypes=request.getParameter("VIDwebtypes");
        String filvalue=request.getParameter("filtval");
        
		 System.out.println("slider-->"+slider);
		 System.out.println("slider1-->"+slider1); 
		 System.out.println("filvalue-->"+filvalue); 
		 System.out.println("subcat-->"+subcat); 
		 System.out.println("webtype-->"+webtype); 
		 
		Dbconnect db = new Dbconnect();
		Statement st = db.dbconnect(); 
		ResultSet rs=null;
		if(filvalue.equals("1"))
		{
			System.out.println("filvalue1-->"+filvalue); 
			//rs=st.executeQuery("select TOP 20 * from products where CAST(WebTypeID as varchar(250)) IN ("+webtype+") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes' and price between '"+slider+"' and '"+slider1+"'");	
			rs=st.executeQuery("select * from products where ProdID in( select DISTINCT TOP 200  p.ProdID from products as p,Vendor as v where p.VendID=v.VendID  and p.SubCatID IN ("+subcat+") and p.WebTypeID IN ("+webtype+") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='' )  and webposted = 'Yes' and price between '"+slider+"' and '"+slider1+"' ) order by  description");		
		}
		if(filvalue.equals("2"))
		{ 
			System.out.println("filvalue2-->"+filvalue); 
			//rs=st.executeQuery("SELECT TOP 250  * FROM products as p,Subcategory as s where  p.SubCatID=s.SubCatID and s.SubCatID='" + subcat + "' and CAST(p.WebTypeID as varchar(250)) IN (" + webtype + ") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes'");
			
          rs=st.executeQuery("select * from products where ProdID in( select DISTINCT TOP 5000 p.ProdID from products as p,Subcategory as s,Vendor as v" +
		"  where p.SubCatID=s.SubCatID and p.VendID=v.VendID and s.SubCatID='" + subcat + "' and CAST(p.WebTypeID as varchar(250)) IN (" + webtype + ")" +
		" and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and webposted = 'Yes' and price between '"+slider+"' and '"+slider1+"') order by  description");

		}  
		if(filvalue.equals("3"))
		{ 
			if(SubCategoryforCategoryAndVendors.equals(""))
			{
				  		
				//rs=st.executeQuery("select TOP 250  * from products where  CAST(WebTypeID as varchar(250)) IN ("+VIDwebtypes+")  and VendID='"+VID+"' and webposted='Yes' and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and   price between '"+slider+"' and '"+slider1+"' ORDER BY description");
		    rs=st.executeQuery("SELECT * from products where ProdID IN( select DISTINCT TOP 5000 ProdID from products where  CAST(WebTypeID as varchar(250)) IN (" + VIDwebtypes + ") " +
	        		" and webposted='Yes' and SubCatID IN ("+subcat+") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') ) and VendID='" + VID + "' and   price between '"+slider+"' and '"+slider1+"' order by  description");
		        		
			}
			else
			{  		
				//rs=st.executeQuery("select TOP 250  * from products where  CAST(WebTypeID as varchar(250))  IN ("+VIDwebtypes+")  and VendID='"+VID+"' and webposted='Yes' and SubCatID='"+SubCategoryforCategoryAndVendors+"' and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and   price between '"+slider+"' and '"+slider1+"' ORDER BY description");	
		        rs=st.executeQuery("SELECT * from products where ProdID IN( select DISTINCT TOP 5000 ProdID from products where  CAST(WebTypeID as varchar(250)) IN (" + VIDwebtypes + ") " +
		        		" and webposted='Yes' and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and SubCatID='"+subcat+"') and VendID='" + VID + "' and   price between '"+slider+"' and '"+slider1+"' order by  description");
		        		
			} 
		}
		
		if(filvalue.equals("4"))
		{   
		  
		  if(SubCategoryforCategoryAndVendors.equals(""))
			{  		
			  //rs=st.executeQuery("select TOP 21  * from products where  CAST(WebTypeID as varchar(250)) IN (" + VIDwebtypes + ")  and VendID='" + VID + "' and webposted='Yes' and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and   price between '"+slider+"' and '"+slider1+"' ORDER BY description");
			  
		   rs=st.executeQuery("SELECT * from products where ProdID IN( select DISTINCT TOP 5000 ProdID from products where  CAST(WebTypeID as varchar(250)) IN (" + VIDwebtypes + ") " +
	        		" and webposted='Yes' and SubCatID IN ("+subcat+") and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') ) and VendID='" + VID + "' and   price between '"+slider+"' and '"+slider1+"' order by  description");
		        		
			}
			else
			{  		
				//rs=st.executeQuery("select TOP 21  * from products where  CAST(WebTypeID as varchar(250))  IN (" + VIDwebtypes + ")  and VendID='" + VID + "' and webposted='Yes' and SubCatID='"+SubCategoryforCategoryAndVendors+"' and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and   price between '"+slider+"' and '"+slider1+"' ORDER BY description");	
				
		        rs=st.executeQuery("SELECT * from products where ProdID IN( select DISTINCT TOP 5000 ProdID from products where  CAST(WebTypeID as varchar(250)) IN (" + VIDwebtypes + ") " +
		        		" and webposted='Yes' and (IsChildorParentorItem='1' or IsChildorParentorItem='0' or IsChildorParentorItem='') and SubCatID='"+SubCategoryforCategoryAndVendors+"') and VendID='" + VID + "' and   price between '"+slider+"' and '"+slider1+"' order by  description");
		        		
		        		
			} 
		}
			
		%>
		<div class="row">
		 
		 
		<div id="page-content"> 
<div id="demo1" class="box"> 
	<div class="jplist-ios-button">
		<i class="fa fa-sort"></i>
		Click Here
	</div> 	
						
	<!-- panel -->
	 
			<div class="jplist-panel box panel-top"> 
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
		<div 
			class="jplist-pagination" 
			data-control-type="pagination" 
			data-control-name="paging" 
			data-control-action="paging">
		</div> 			
	</div>  
	<div class="clr"></div>
			<div class="list box text-shadow"> 
			
		<%
		while(rs.next())
		{%>   		 
					<%int myVariable =  rs.getInt("ProdID") ;ArrayList colorandsize;colorandsize=obj.getcolorandsizedetails(String.valueOf(rs.getInt("ProdID")));request.setAttribute("colorandsize", colorandsize);%>
											
										<%if(colorandsize.isEmpty() && rs.getString("IsChildorParentorItem").equals("1")) { 
										
										System.out.println("inside COLOR AND SIZE TESTTTTTTTT");
										%>
										
										
										<%} else { %> 
	
										<div class="list-item">
											<div class="col-6 col-sm-6 col-lg-7">
												<div class="cycles">
													<center>
													 
													<%String prodname1 = rs.getString("description");%> 	
													<a href="Item?${m.SKU}/<%=prodname1.replace('"','\'')%>&id=<%=rs.getInt("ProdID")%>&subid=<%=rs.getString("SubCatID")%>">											
													<div class="fix-weight">
													<img src="productimages/<%=rs.getString("picture") %>" class="img1"></div>
													</a>		
													</center> 
													
													<form action="addtocart" method="post">
													
													<c:choose>
														<c:when test="${empty colorandsize }">
															<div>
																<div class="else2"></div>
																<p>
																	<b>
																	 
																<%String prodname = rs.getString("description");%>  
																  
														          <%String fdesc=prodname.replace('"','\'');%>
																	<a
																		href="Item?${m.SKU}/<%=prodname.replace('"','\'')%>&id=${m.id}&subid=<%=rs.getString("SubCatID")%>">
																			 
														<%if(fdesc.length() >100 ) {%>
														<%=fdesc.substring(0,98) %>..
														<%} else { %>
														<%=fdesc%> 
														<%} %> 
														
														
														
																	</a></b>
																</p>
															</div>
														</c:when>

														<c:otherwise>
															<select name="colorandsizeid" class="dropdown">
																<c:forEach items="${colorandsize}" var="aa">
																 
                        
                                                                   <c:set var="chprice" value="${aa.price}" />
																 
                                                               <%float chprice1 = (Float)pageContext.getAttribute("chprice");
                                                               float price1 = rs.getFloat("price");
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
																				${m.product_name} </a></b>
																	</p>
																	
																	  
													                <%if(price1==chprice1) {%>
																	  <option value="${aa.colorandsize}<>${aa.id}">${aa.colorandsize}  
																	 <%} else {%>
																	 <option value="${aa.colorandsize}<>${aa.id}">${aa.colorandsize}  
																	  <%=value %><fmt:formatNumber value="<%=fprice %>" type="currency"></fmt:formatNumber>
																	 <%} %>
																	</option>
																</c:forEach>
															</select>
															<div>

																<p>
																	<b><a
																		href="Item?/${m.SKU}/<%=rs.getString("description") %>&id=<%=rs.getInt("ProdID")%>&subid=<%=rs.getString("SubCatID")%>">
																			<%=rs.getString("description") %> </a></b>
																</p>
															</div>
														</c:otherwise>
													</c:choose>

													 <div class="font">
													 <%if(rs.getFloat("price") >=100) {%>
													  Free Shipping with FEDEX Ground-US Mail!)
													 <% } else {%>
													 <div class="font2">
										 
										             </div>
													 <%} %> 
									 </div> 
													
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
                                                        
																<td class="tab"><div class="rs">$ <%=rs.getFloat("price")%></div></td>
																<td><input type="hidden" name="prodId"
																	value="<%=rs.getInt("ProdID")%>" /></td>
																<td class="tab2"><input type="submit" value=""
																	class="cart" /></td>
																<td class="tab3"><div class="deatil">
																 
																<%String prodname = rs.getString("description");%> 
																		<a
																			href="Item?${m.SKU}/<%=prodname.replace('"','\'')%>&id=<%=rs.getInt("ProdID")%>&subid=<%=rs.getString("SubCatID")%>">
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
										<%} %>	 
									 
		<%} 
		db.close(); 
		%> 
		</div>
		<div class="box jplist-no-results text-shadow align-center">
		<p>No results found..!</p>
	</div>
						
	<!-- ios button: show/hide panel -->
	<div class="jplist-ios-button">
		<i class="fa fa-sort"></i>
		bicyclebuys
	</div> 		
	<!-- panel -->
	<div class="jplist-panel box panel-bottom">
							
		<!-- items per page dropdown -->
		<div  
			class="jplist-drop-down" 
			data-control-type="drop-down" 
			data-control-name="paging" 
			data-control-action="paging"
			data-control-animate-to-top="true">
								
			<ul>
				<li><span data-number="9" data-default="true"> 9 per page </span></li>
				<li><span data-number="21"> 21 per page </span></li>
				<li><span data-number="60"> 60 per page </span></li> 
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
		 </div>
		 </div>
 	 
 	</div>
 