<jsp:include page="zooming1.jsp"></jsp:include> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.admin.action.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<% adminDAO obj;obj=new adminDAOImpl();%> 
<%String jscall=""; %>
<script type="text/javascript">
function getval(valp) 
	{ 
		if(valp)
		{
		 document.getElementById('colorstat').value=1;
		 document.getElementById('sizeinfo').innerHTML ="";
		}
		else
		{
		 document.getElementById('colorstat').value=0;
		}
	}
</script>

<script type="text/javascript">
				      function getproductdetaisl()
				      {  
				    	  var colorval=$("#country").val();
				    	  var sizeval=$("#size1").val(); 
				    	  if($("#size").length == 0) 
				    	  {
				    			 var data = colorval;
					    	 	 var arr = data.split('<>'); 
					    	     var dataString = "cname=" + arr[0] +"&pid="+arr[1]+"&status="+"0"; 
									$.ajax({  
										type: "POST",  
										url: "getprodetails.jsp",  
										data: dataString,
										 
										success: function(data)
										{ 
											 var json = eval('(' + data +')');
											 $("#sku").html(json.sku); 
											 $("#price").html(json.price);
											 $("#yuosave").html(json.yousave);
											 $("#MSRP").html(json.MSRP);
											 $("#desc1").html(json.desc1);
											 $("#desc2").html(json.desc1);
											 $("#desc3").html(json.desc1);
											 $("#mkd1").html(json.mkd1);
											 $("#mkd2").html(json.mkd2); 
										}
									}); 
				    		  
				    	  } 
				    	  else
				    		{  
				    		  var data = sizeval;
					    	 	 var arr = data.split('<>'); 
				    		  var dataString = "pid=" +arr[0] +"&status="+"1"; 
								$.ajax({  
									type: "POST",  
									url: "getprodetails.jsp",  
									data: dataString,
									 
									success: function(data)
									{
										
										 var json = eval('(' + data +')');
										 $("#sku").html(json.sku); 
										 $("#price").html(json.price);
										 $("#yuosave").html(json.yousave);
										 $("#MSRP").html(json.MSRP);
										 $("#desc1").html(json.desc1);
										 $("#desc2").html(json.desc1);
										 $("#desc3").html(json.desc1);
										 $("#mkd1").html(json.mkd1);
										 $("#mkd2").html(json.mkd2); 
									} 
								});
				    		     
				    		}
				    	  
				    	   
				     	  	 
				    	   
					  }
				      
				     </script>
 
<script type="text/javascript" src="js/ajax.js"></script>
  
<!-- onload="getsize('','0');" -->
<body onload="getsize('','0');"> 
<div style="clear:both;"></div>
 <div class="container">
 <div class="navigation1">
			<ul>
				<c:forEach items="${menunav}" var="m">					 
					<li><a href="indexpage">Home  </a></li>
					<li><a href="Category?id=${m.webTypes}&cate=${m.categoryname}&subcatid=${m.subcatid}">${m.categoryname} </a></li>
					<li><a href="Sucategory?/${m.categoryname}/${m.subcatname}&id=${m.id}&category=${m.categoryname}&cate=${m.webdisplay}">${m.subcatname} </a></li>
					<li>${m.product_name}</li>
					
					
				</c:forEach>
			</ul>
		</div>
		<div class="clr"></div>
 	   <div class="row">
 	   <div class="clr"></div>
     
    <div class="col-xs-12 col-sm-12">
        <div class="main-container col1-layout" >
            
            
            
            <link rel="stylesheet" href="general1.css" />
            <div class="main">
            
           
            
            	 <c:forEach items="${details1}" var="m"> 
       
         <form action="addtocart1" method="post" id="dropdownvalidation">
            	 <div class="matter"> 
         <div class="col-md-8">
         <div align="center" class="product-img-box1"> 
           <img class="demo1"  src="productimages/${m.picturename}"   id="wid"  data-large="productimages/${m.picturename}">
             <div style="clear:both; height:10px"></div>
              <a class="fancybox" href="productimages/${m.picturename}" data-fancybox-group="gallery" title="${m.description}"> 
                   <img src="images/fullscreen.png"  ><font class="view-image">CLICK FULL IMAGE</font></a>
            
            
         
    	 
    
    </div>
     </div>
     
      <div class="col-md-1">
     
     <div class="produ">
     	 
                		<div class="inner">
                        	<h1><span id="desc1">${m.description}</span></h1>
                        	
                        	 <table width="100%">
    <tr>
      <td width="50%"><h2>SKU#  </h2> </td>
      <td width="50%" align="right"><h2><b><span id="sku">${m.SKU}</span></b></h2></td>
    </tr>
    
     <c:set var="msr" value="${m.MSRP}"/>
     <c:set var="price" value="${m.price}"/> 
    <%
    float msr=0.0f;
     if((String)pageContext.getAttribute("msr")!=null)
     {
        msr= Float.parseFloat((String)pageContext.getAttribute("msr"));
     }
     else{
    	msr=0.0f; 
     }
     float price= (Float)pageContext.getAttribute("price"); 
     float yuosave=msr-price; 
     int savevalue=Math.round(yuosave);
     
     DecimalFormat twoDForm = new DecimalFormat("#0.00"); 
    %>
    
    <tr>
      <td><h2>BRAND</h2> </td>
      <td align="right"><h2><b> ${m.brand}</b></h2></td> 
    </tr>
    <td><input type="hidden" name="prodId" value="${m.id}"></td>
     
      
     <%if(savevalue==0 || msr==0  || msr==0.0) {%>
      <tr>
      <td><h2><font color="red"> YOUR PRICE  </font></h2> 
      
     
       
       
      </td>
      
      <td align="right"><h2><b style="color: red;">$&nbsp;<span id="price"> ${m.price}</span></b></h2></td>
    </tr>
     
     
     <tr>       
      <td colspan="2" align="left"> 
      
      
      </td>
    </tr>
    
    
    
     <%} else {%>
     <tr>
      <td><h2>MSRP</h2> </td>
      <td align="right"><h2><b style="text-decoration: line-through; ">$&nbsp;<span id="MSRP">${m.MSRP}</span></b></h2></td>
    </tr>
    
    
    <tr>
      <td><h2><font color="red"> YOUR PRICE</font></h2> </td>
      <td align="right"><h2><b style="color: red;">$&nbsp;<span id="price"> ${m.price}</span></b></h2></td>
    </tr>
    
     
     <% 
     if(msr == price){ %>
     
     
     <% } else{%>
    <tr>
      <td><h2><font color="blue">YOUR SAVE </font></h2> </td> 
      <td align="right"><h2><b>$&nbsp; <span id="yuosave"> <%=Double.parseDouble(twoDForm.format(((yuosave)))) %></span></b></h2></td> 
    </tr>
     
    <%} %>
     <% }%>
      
     <c:if test="${m.webnoteid eq '15'}">
       <tr>
     <td colspan="2"><a class="fadeandscale_open" href="#fadeandscale" color="blue" data-popup-ordinal="0" id="open_1163696" style="color: blue;font-weight: bold;">
       Instant Rebate will Apply During Checkout  </a>
       
       <div id="fadeandscale" class="wel">
<div class="projectstrip"> </div>

<div class="upload-resume-post">
 <a href="javascript:void(0);" id="cls"> <img src="images/close.png" class="fadeandscale_close"></a> 
  
    
    
<div class="tabsle">

 

	 <div class="inner">
                        	<h1>${m.description}</h1>
                             <img style="float:left"  src="productimages/${m.picturename}" width="250" >
                          <div id="product-price-house" style="float:right; width: 241px;"> <table width="100%">
    <tbody><tr>
      <td><h2>SKU#</h2> </td>
      <td align="right"><h2><b>${m.SKU}</b></h2></td>
    </tr>
    
    
    
    
    <tr>
      <td><h2>BRAND</h2> </td>
      <td align="right"><h2><b>${m.brand}</b></h2></td>
    </tr>
    <tr><td><input type="hidden" name="prodId" value="98461"></td>
     </tr>
    
    <tr>
      <td><h2><font color="red"> YOUR SALL PRICE</font></h2> </td>
      <td align="right"><h2><b>$&nbsp;${m.price}</b></h2></td>
    </tr>
    
    
    <tr>
      <td><h2><font color="blue">Price After Rebate:</font></h2> </td>
      <td align="right"><h2><b>$&nbsp;  ${m.rebateprice}</b></h2></td> 
    </tr>
    
     
     <tr>
      <td colspan="2"><h2><font color="black">Rebate will be applied during checkout.</font></h2> </td>
      
    </tr>
    
  </tbody></table>
									</div>
                                     
                             
                        
                        <div style="clear:both; height:15px"></div>
                         
                </div>
</div>
</div>
</div>
       </td>
    </tr>
     
     </c:if>
     
     
     <!-- 
     <c:if test="${m.price >=90 and m.ovw > 1}"> 
									<font color="blue">	Additional Shipping Charges May Apply &nbsp;&nbsp;</font> 
									</c:if>  
									
									<c:if test="${m.price >=90 and m.ovw < 1}">
										Free Shipping with FEDEX Ground-US Mail 
									</c:if>  
									
									 </div>
								    <c:if test="${m.price <=90}">
										 <div class="font2">
										 
										 </div>
									</c:if>
      -->
     
     
     <div style="clear:both; height:15px"></div> 
     <c:if test="${m.price >=90 and m.ovw > 1}">
     <tr>
       <td colspan="2"><font color="#191970"><b>Overweight, Oversized item. Free Shipping does not apply</b></font></td> 
     </tr>
     </c:if> 
     
     <c:if test="${m.price >=90 and m.ovw < 1}">
     <tr>
       <td colspan="2"><font color="red"><b>Free Shipping with FEDEX Ground-US Mail</b></font></td> 
     </tr>
     </c:if> 
     
      <c:if test="${m.price <=90}">
     <tr>
       <td colspan="2"> </td> 
     </tr>
     </c:if> 
     
    <div style="clear:both; height:15px"></div>
    <tr height="10">
       			<td colspan="2">  
        <c:set var="myVariable" value="${m.id}"/> 																																		
           	<%int myVariable = (Integer)pageContext.getAttribute("myVariable");
           	ArrayList colorandsize;colorandsize=obj.getcolorandsizedetails1(String.valueOf(myVariable));
           	request.setAttribute("colorandsize", colorandsize);%>
            <c:choose>
				  <c:when test="${empty colorandsize }">
				      <div style="height: 26px;">      <%jscall="dropdownvalidation1.js"; %>             </div>
				  </c:when>
				  
				   <c:otherwise>
				     <div class="color-size"><h2>Color </h2></div>
				     <%jscall="dropdownvalidation.js"; 
				     String sizeid="";String flag="";%>  
				     <div class="color-size1">  
				     <select name ="colorandsizeid" class="dropdown1" onchange="getsize(this.value,<%=myVariable%>);getproductdetaisl();" id="country">  
			       		 <option value="" class="color-size">Select Color</option> 
			       		<c:forEach items="${colorandsize}" var="aa"> 
			       		  <p><b><a href="viewproductdescription?id=${m.id}&subid=${m.subcatid}">  ${m.product_name} </a></b>  </p>			             
			                 <option value="${aa.color}<><%=myVariable%>">${aa.color}  </option> 
			                 <c:set var="flag" value="${aa.flag}"/> 																																		
                   	       <%  flag = (String)pageContext.getAttribute("flag");%>
			            </c:forEach>
			            </select> 
			            <span id="countryinfo"></span>
			            
			            </div>
			            <div class="clr"></div> 
			            
			            <%String sgid=""; %>
			            <%if(flag.equals("false")) {   sgid="sizedumy";%>
			            
			            <%} else { sgid="size";%>
			            <div id="<%=sgid%>" style="width: 100%;">			              
			             </div>
			            <span id="sizeinfo" style="float: right;margin: 0 67px 0 0;"></span>
			            <input type="hidden" name="colorstat" id="colorstat" value="0"/>
			            <%} %>
			             
			            
			          
			            
			            
			             <div>
                   <br/> 
             </div> 
				  </c:otherwise>
			</c:choose>           </td>
           </tr>
           
           
           
      <tr>
      <td>
      <b>
         <%@ page import="java.util.*" %>
         <font color="red">
<%
ArrayList e2 = (ArrayList) request.getAttribute("error");
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
%></font>         </b> </td>
         
         <td></td>
         </tr> 
    <tr>
       <td><h2>Quantity</h2>  </td> 
       <td><input type="text" name="qtyinpdes"  class="dropdown2" value="1" id="qtyid"/></td>
       
    </tr>
    
    
    
    <tr>
    <td>&nbsp;</td>
    <td><span id="postalcodeinfo"></span></td>
    </tr>
  </table>
                        	 
   
     <div class="add">
                                
 
 
 <c:if test="${m.caption} eq 'No Note'">
 
 </c:if>
 
 <c:if test="${m.caption} neq 'No Note'  && m.price >=90}">
 <p class="name1"> <font color="red">${m.caption} </font> </p>
 </c:if>
 

 
<div class="hands">

            <div id="">

	 


            

            <input type="hidden" value="<%=request.getAttribute("subid") %>" name="subid"/>
            <input type="hidden" value="${m.id}" name="id"/> 
			<div id="book">
			<input type="submit" value="Add to cart" class="cart1">   
			 &nbsp; 
			 
			   <c:if test="${m.qtyh <= 0}">
			 <b>Available For Order</b>
			 </c:if>
			 
			  <c:if test="${m.qtyh > 0}">
			    <b><img alt="" src="images/b_instock.gif"> </b>
			 </c:if>
			
			
			   
			    </div>

		 

		 

	</div>

            	<a href="#"></a>

            </div>
                              </div>
                             
                        
                        <div style="clear:both; height:15px"></div>
                         
                </div>
               <div style="clear:both; height:15px"></div> 
     </div>
     
     
     </div>
     
     
     <div style="clear:both; height:15px"></div>
     <div class="feacture">
                <h1><span id="desc2">${m.description}</span> </h1> 
                	  <div class="Key-Features" >
                	  <p><span>Key Features of the <label id="desc3"> ${m.description} </label>:</span></p> 
                      <label id="mkd1"> ${m.marketingdescription}</label>
                      </div>
                 <div class="Key-Features">  
                 <label id="mkd2">
               <c:set var="marketdescriptwo" value="${m.marketdescriptwo}"/>  
                 <%
                 String marketdescriptwo = (String)pageContext.getAttribute("marketdescriptwo");
                 System.out.println("marketdescriptwo--->"+marketdescriptwo);  
                 if(marketdescriptwo==null)
         		{
         			 
         		}
         		else
         		{%>
         			<%String fstr=marketdescriptwo.replace('^', '!'); 
           	  	 String []hhh=fstr.split("!");
       	   		 for(int i=0;i<hhh.length;i++)
       	   			{   
       		   		if(i==0)
       		   			{ %> 
       			   			<%=hhh[i] %>
       		   			<%}
       		   		else
       		   			{%>
       		   		      <li><%=hhh[i] %> </li>   
       		   			<%} 
       	   			}  
           	      %> 
         		<%}%> 
                 
           	     
           	     </label>
               </div> 	 
                </div>
                   <div style="clear:both; height:0px"></div> 
                   
                   <c:set var="myVariable1" value="${m.description}" />
     <c:set var="myVariable2" value="${m.brand}" /> 
	<%String myVariable1 = (String)pageContext.getAttribute("myVariable1");
	String myVariable2 = (String)pageContext.getAttribute("myVariable2");
	System.out.println("myVariable1myVariable1myVariable1myVariable1--->"+myVariable1);
	System.out.println("myVariable2myVariable2myVariable2myVariable2--->"+myVariable2);
	String str1="Diadora Team Racer Road Shoe";
	String str2="Shoe"; 
	if(str1.contains(str2)) 
	  {%>
	  <%if(myVariable2.equals("Shimano"))
	   {%>
		  <img alt="" src="images/shimanoshoesize.jpg">		  
	  <%} %>	 
	  
	  
	   <%if(myVariable2.equals("Time"))
	   {%>
		  <img alt="" src="images/TimeSizingChart.jpg">		  
	  <%} %>	
	  
	   <%if(myVariable2.equals("Diadora"))
	   {%>
		  <img alt="" src="sizing/images/DiadoraSizing.gif">		  
	  <%} %>	
	  
	   <%if(myVariable2.equals("Cannondale"))
	   {%>
		  <img alt="" src="images/CannondaleShoeSize.jpg">		  
	  <%} %>	
	  
	   <%if(myVariable2.equals("Louis Garneau"))
	   {%>
		  <img alt="" src="images/LouisGarneauShoeSize2010.jpg">		  
	  <%} %>	
	  
	   <%if(myVariable2.equals("Pearl Izumi"))
	   {%>
		  <img alt="" src="sizing/images/PIMenshoe.gif">		  
	  <%} %>	
	  
	   <%if(myVariable2.equals("SIDI"))
	   {%>
		  <img alt="" src="images/SidiSizingSmall.jpg">		  
	  <%} %>	
	  
	  
	   <%if(myVariable2.equals("Mavic"))
	   {%>
		  <img alt="" src="images/MavicSizingChart.jpg">		  
	  <%} %>	
	  
	  
	   <%if(myVariable2.equals("Giro"))
	   {%>
		  <img alt="" src="images/GiroSizingChart.jpg">		  
	  <%} %> 
	  
	<%}%> 
     <div style="clear:both; height:15px;"></div>
     </div>
            	 
            	 </form> 
            	  
            	  
     
            	  </c:forEach>  
                 <script type="text/javascript" src="<%=jscall%>"></script>
        </div>
            <div class="clr"></div>
     </div>
      
      <div style="clear:both;"></div>
       
    </div>
    <div style="clear:both;"></div>
    <!-- Example row of columns -->
    <div style="clear:both;"></div>
  </div>
 </div>
     <div style="clear:both; height:15px;"></div>
    
 <div class="container">
 <div class="shoping-details">
                    	<h1><strong>Related </strong> Product</h1>
         </div>
 	<div class="Related">
                    		<ul> 
                      
                    		 <c:forEach items="${relatedproduct}" var="m"> 
                            	<li>
                            	<c:set var="prodname" value="${m.product_name}" />
                            	    <%String prodname = (String)pageContext.getAttribute("prodname");%>  
                            	    <div class="fix-weight">  <a href="Item?/${m.SKU}/<%=prodname.replace('"','\'')%>&id=${m.id}&subid=${m.subcatid}">
                            	    <img src="productimages/${m.picturename}" class="img1"></a> </div>
                            	   
                            	       <div class="clear"></div>
                                	   <div class="hreflinks">
                                	           <a href="Item?/${m.SKU}/<%=prodname.replace('"','\'')%>&id=${m.id}&subid=${m.subcatid}"> 
														<c:set var="description" value="${m.description}" />
                            	    
                            	    <%String description = (String)pageContext.getAttribute("description");%> 
														<%String fdesc=description.replace('"','\'');%>
														
														<%if(fdesc.length() >40 ) {%>
														<%=fdesc.substring(0,38) %>..
														<%} else { %>
														<%=fdesc%> 
														<%} %> 
                                	  
                                	            </a>
                                	            </div> 
                                    <span>$ ${m.price}</span> 
                                </li>
                                </c:forEach>
                                 
                            </ul>
                             <div class="clr"></div>
                    </div>
 </div>
 <div style="clear:both; height:15px;"></div>
 <div class="container">
 <div class="shoping-details">
                    	<h1><strong>Recently View </strong></h1>
         </div>
 	<div class="bulets">
                    		<ul>  
                <%@ page import="com.admin.action.*" %>
		 	    <%@ page import="java.util.*" %>
					<% 
					ArrayList previously=(ArrayList)session.getAttribute("previously"); 
					
					if(previously==null)
					{
						
					}
					else
					{
					
					if(!previously.isEmpty() && previously.size()<=5)
                        {
                     	  	System.out.println("in side array not empty"+previously.size());
                        for(int i=previously.size()-2;i>=0;i--)
                        { 
                        	productDTO e=(productDTO)previously.get(i); 
                        System.out.println("in side for loop");
                        %>  
                            	<li> 
                            	 
                            	
                            	 
                            	  <div class="fix-weight1">  <a href="Item?/<%=e.getSKU() %>/<%=e.getProduct_name().replace('"','\'')%>&id=<%=e.getId()%>&subid=<%=e.getSubcatid()%>">	<img src="productimages/<%=e.getPicturename() %>"   alt="" class="img1" ><%=e.getDescription() %> </a></div>
                                </li> 
                        <%}} else {%>
                        
                        <%
                        int count=1;
                        for(int i=previously.size()-2;i>=0;i--)
                        { 
                        	productDTO e=(productDTO)previously.get(i); 
                        System.out.println("in side for loop");
                        
                        		if(count <5)
                        		{
                        %>  
                            	<li> 
                            	  <a href="Item?/<%=e.getSKU() %>/<%=e.getProduct_name().replace('"','\'')%>&id=<%=e.getId()%>&subid=<%=e.getSubcatid()%>">	<img src="productimages/<%=e.getPicturename() %>" class="img1"><%=e.getDescription() %> </a>
                                </li> 
                        
                        <% }count++; } }}%>
                                
                            </ul>
                             <div class="clr"></div>
                    </div>
 </div>
  
  
  	<jsp:include page="zooming-f.jsp"></jsp:include>
 
</body>
</html>
