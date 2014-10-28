
 <jsp:include page="header1.jsp"></jsp:include>

<script src="jquery-1.10.0.min.js"></script>
<script src="modernizr.min.js"></script>
<script src="jplist.min.js"></script>

    <%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.admin.action.*"%>
<%@ page import="java.util.*"%> 
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
  <script>
  $(function() {
    $( "#slider-range" ).slider({
      range: true,
      min: 679.99, 
      max:2999.95,
      values: [ 679.99,2999.95],
      slide: function( event, ui ) {
        $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
		$( "#amount1" ).val(ui.values[ 0 ]);
		$( "#amount2" ).val(ui.values[ 1 ]);
		
      },
		stop: function(event, ui){
			
			 
		$.ajax({
                        type: 'post',
                        url: 'getproductList.jsp',
                        datatype: 'json',
                        data: {'slider': ui.values[0],'slider1':ui.values[1],'webtype':'152,153,202',
                        	'filtval':'1'
                        	,'subcat':'130,132','SubCategoryforCategoryAndVendors':'null'
                        	,'VID':'null','VIDwebtypes':'null'},   
						beforeSend: function() 
						{
							$(".center").html('<p> <center><img src="images/27.gif" style="margin:150px;"></center></p>');
						},  
                        success: function(fromphp) {
                          
							$(".center").html('');
							  
							$(".center").html(fromphp);
 
							document.body.style.zoom = "100%"; 
						}
                    });
		
		}
		 
    });
    $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
      " - $" + $( "#slider-range" ).slider( "values", 1 ) );
	  
  });
  </script>
  
  
	<style>
		.main{
		width:1000px;
		margin:0 auto;
		}
		
		.product{
		width:400px;
		float:left;
		margin:10px;
		border:1px #dedede solid;
		padding:5px;
		background-image:url(images/corner.jpg);
		background-position:bottom right;
		background-repeat:no-repeat;
		}
		
		.product .title{
		margin-bottom:6px;}
		
		.product img{
		float:left;
		margin-right:10px;
		border:1px solid #dedede;}
		
		.product .description{font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif}
	</style>  
  

	<script>
			$('document').ready(function(){
				
				$('#demo').jplist({
					
					itemsBox: '.list' 
					,itemPath: '.list-item' 
					,panelPath: '.jplist-panel'
					
					,controlTypes: {
					
						//likes range slider
						'range-slider-likes': {
							className: 'RangeSlider'
							,options: {
								
								//jquery ui range slider
								ui_slider: function($slider, $prev, $next){		
									
									$slider.slider({
										min: 0
										,max: 350
										,range: true
										,values: [0, 350]
										,slide: function(event, ui){									
											$prev.text(ui.values[0] + ' likes');
											$next.text(ui.values[1] + ' likes');
										}
									});
								}
								
								,set_values: function($slider, $prev, $next){
									
									$prev.text($slider.slider('values', 0) + ' likes');
									$next.text($slider.slider('values', 1) + ' likes');
								}
							}
						}
						
						//prices range slider
						,'range-slider-prices': {
							className: 'RangeSlider'
							,options: {
								
								//jquery ui range slider
								ui_slider: function($slider, $prev, $next){		
									
									$slider.slider({
										min: 0
										,max: 150
										,range: true
										,values: [0, 100]
										,slide: function(event, ui){									
											$prev.text('$' + ui.values[0]);
											$next.text('$' + ui.values[1]);
										}
									});
								}
								
								,set_values: function($slider, $prev, $next){
									
									$prev.text('$' + $slider.slider('values', 0));
									$next.text('$' + $slider.slider('values', 1));
								}
							}
						}
						
						//views range slider
						,'range-slider-views': {
							className: 'RangeSlider'
							,options: {
								
								//jquery ui range slider
								ui_slider: function($slider, $prev, $next){		
									
									$slider.slider({
										min: 0
										,max: 4000
										,range: true
										,values: [0, 4000]
										,slide: function(event, ui){									
											$prev.text(ui.values[0] + ' views');
											$next.text(ui.values[1] + ' views');
										}
									});
								}
								
								,set_values: function($slider, $prev, $next){
									
									$prev.text($slider.slider('values', 0) + ' views');
									$next.text($slider.slider('values', 1) + ' views');
								}
							}
						}
					}
				});
			});
		</script><link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="footrer/extra_style.css" media="all"/>
<link rel="stylesheet" type="text/css" href="footrer/styles.css" media="all"/>
<link rel="stylesheet" type="text/css" href="footrer/responsive.css" media="all"/>
<script type="text/javascript" src="footrer/scripts.js"></script>




 
<script type='text/javascript' src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="menu1.js" type="text/javascript"></script>
<link href="css/menu1.css" rel="stylesheet" type="text/css" />
 
  
<script type='text/javascript'>//<![CDATA[ 
$( document ).ready(function() {
$("#container").mouseenter(function() {
    $("#example3-link1").slideDown();
});
$("#container").mouseleave(function() {
    $("#example3-link1").slideUp();
});
});

</script>

 
 
 
   
  
 
  

<!-- Main jumbotron for a primary marketing message or call to action -->

<div style="clear:both;"></div>
<div class="container">
  <div class="navigation1">
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">About Us</a></li>
      <li><a href="#">Home</a></li>
      <li> Home</li>
    </ul>
  </div>
  <div style="clear:both; height:10px;"></div>
  <div class="row">
    <div class="col-md-4">
      <div id="block_navigation">
        <h1 style="background-color: #373737;
border: 1px solid #373737;
border-radius: 5px 5px 0 0;line-height:25px;
color: #FFF; margin:0;
font-weight: normal;
font-family: 'Oswald', sans-serif;
font-size: 14px;
text-align: center;
padding: 4px;">Shop by Category : Pedals </h1>
        <div id="pull" ><a href="#"><i class="icon-reorder"></i>Shop by Category<span class="pull_span">+</span> </a></div>
        <ul class="navigation">
          <ul>
            <li> <a href="#">Baby Seats </a></li>
            <li> <a href="#">Handlebar Bags </a></li>
            <li> <a href="#">Tricycles / Pedal Cars </a></li>
            <li> <a href="#">Trunk Bags </a></li>
            <li> <a href="#">Seat Bags </a></li>
            <li> <a href="#">Rack Bags </a></li>
            <li> <a href="#">Pannier Bags </a></li>
            <li> <a href="#">Bicycle Racks </a></li>
            <li> <a href="#">Mountain Handlebars </a></li>
            <li> <a href="#">Road Handlebars </a></li>
            <li> <a href="#">Baby Seats </a></li>
            <li> <a href="#">Handlebar Bags </a></li>
            <li> <a href="#">Tricycles / Pedal Cars </a></li>
            <li> <a href="#">Trunk Bags </a></li>
            <li> <a href="#">Seat Bags </a></li>
            <li> <a href="#">Rack Bags </a></li>
            <li> <a href="#">Pannier Bags </a></li>
            <li> <a href="#">Bicycle Racks </a></li>
            <li> <a href="#">Mountain Handlebars </a></li>
            <li> <a href="#">Road Handlebars </a></li>
            <li> <a href="#">Handlebar Bar Ends </a></li>
            <li> <a href="#">Baby Seats </a></li>
            <li> <a href="#">Tricycles / Pedal Cars </a></li>
            <li> <a href="#">Trunk Bags </a></li>
            <li> <a href="#">Seat Bags </a></li>
            <li> <a href="#">Handlebar Bags </a></li>
            <li> <a href="#">Rack Bags </a></li>
            <li> <a href="#">Pannier Bags </a></li>
            <li> <a href="#">Bicycle Racks </a></li>
            <li> <a href="#">Mountain Handlebars </a></li>
            <li> <a href="#">Road Handlebars </a></li>
            <li> <a href="#">Handlebar Bar Ends </a></li>
            <li> <a href="#">Handlebar Bar Ends </a></li>
          </ul>
        </ul>
      </div>
      <div style="clear:both; height:15px;"></div>
      <div id="block_navigation1">
        <h1 style="background-color: #373737;
border: 1px solid #373737;
border-radius: 5px 5px 0 0; line-height:25px;
color: #FFF; margin:0;
font-weight: normal;
font-family: 'Oswald', sans-serif;
font-size: 14px;
text-align: center;
padding: 4px;">Shop by Category : Pedals </h1>
        <div id="pull1" ><a href="#"><i class="icon-reorder"></i>Shop by Category<span class="pull_span">+</span> </a></div>
        <ul class="navigation">
          <ul>

            <li> <a href="#">Baby Seats </a></li>
            <li> <a href="#">Handlebar Bags </a></li>
            <li> <a href="#">Tricycles / Pedal Cars </a></li>
            <li> <a href="#">Trunk Bags </a></li>
            <li> <a href="#">Seat Bags </a></li>
            <li> <a href="#">Rack Bags </a></li>
            <li> <a href="#">Pannier Bags </a></li>
            <li> <a href="#">Bicycle Racks </a></li>
            <li> <a href="#">Mountain Handlebars </a></li>
            <li> <a href="#">Road Handlebars </a></li>
            <li> <a href="#">Baby Seats </a></li>
            <li> <a href="#">Handlebar Bags </a></li>
            <li> <a href="#">Tricycles / Pedal Cars </a></li>
            <li> <a href="#">Trunk Bags </a></li>
            <li> <a href="#">Seat Bags </a></li>
            <li> <a href="#">Rack Bags </a></li>
            <li> <a href="#">Pannier Bags </a></li>
            <li> <a href="#">Bicycle Racks </a></li>
            <li> <a href="#">Mountain Handlebars </a></li>
            <li> <a href="#">Road Handlebars </a></li>
            <li> <a href="#">Handlebar Bar Ends </a></li>
            <li> <a href="#">Baby Seats </a></li>
            <li> <a href="#">Tricycles / Pedal Cars </a></li>
            <li> <a href="#">Trunk Bags </a></li>
            <li> <a href="#">Seat Bags </a></li>
            <li> <a href="#">Handlebar Bags </a></li>
            <li> <a href="#">Rack Bags </a></li>
            <li> <a href="#">Pannier Bags </a></li>
            <li> <a href="#">Bicycle Racks </a></li>
            <li> <a href="#">Mountain Handlebars </a></li>
            <li> <a href="#">Road Handlebars </a></li>
            <li> <a href="#">Handlebar Bar Ends </a></li>
            <li> <a href="#">Handlebar Bar Ends </a></li>
          </ul>
        </ul>
      </div>
    </div>
    <div class="col-xs-12 col-sm-8" style="background:#FFF;">
      <div class="matter">
        <h1 class="name">Top Brands</h1>
        <div style="clear:both;"></div>
          </div>
        <div style="clear:both;"></div>
         <div id="main-content" class="box">
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
										<li><span data-number="3"> 3 per page </span></li>
										<li><span data-number="5"> 5 per page </span></li>
										<li><span data-number="10" data-default="true"> 10 per page </span></li>
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
						<div class="list box text-shadow">  
          <!-- item 33 --> 
          <div class="clr"></div>
        <div class="list box text-shadow"> 
						<%int i=1; %>
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
									<c:if test="${m.price >=90}">
										Free Shipping with FEDEX Ground-US Mail!)
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
											     
										
									 </c:otherwise>
								 </c:choose> 
										<%i++;%>
									</c:forEach> 
								</div>
          
          
          
             
          
                 
          
          
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
								data-control-action="paging"
								data-control-animate-to-top="true">
								
								<ul>
									<li><span data-number="3"> 3 per page </span></li>
									<li><span data-number="5"> 5 per page </span></li>
									<li><span data-number="10" data-default="true"> 10 per page </span></li>
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
<div class="container" >
  <div class="shoping-details">
    <h1><strong>Related </strong> Cart</h1>
  </div>
  <div class="Related">
    <ul>
      <li><img src="products/1.gif" width="350" height="300"> <a href="#">Kestrel Talon Frameset</a> <span>$999.95</span> </li>
      <li><img src="products/1.gif" width="350" height="300"> <a href="#">Kestrel Talon Frameset</a> <span>$999.95</span> </li>
      <li><img src="products/1.gif" width="350" height="300"> <a href="#">Kestrel Talon Frameset</a> <span>$999.95</span> </li>
      <li><img src="products/1.gif" width="350" height="300"> <a href="#">Kestrel Talon Frameset</a> <span>$999.95</span> </li>
      <li><img src="products/1.gif" width="350" height="300"> <a href="#">Kestrel Talon Frameset</a> <span>$999.95</span> </li>
    </ul>
    <div style="clear:both;"></div>
  </div>
</div>
<div style="clear:both; height:15px;"></div>
<div class="container">
  <div class="shoping-details">
    <h1><strong>Recently View </strong></h1>
  </div>
  <div class="Related">
    <ul>
      <li><img src="products/1.gif" width="350" height="300"> <a href="#">Kestrel Talon Frameset</a> <span>$999.95</span> </li>
      <li><img src="products/1.gif" width="350" height="300"> <a href="#">Kestrel Talon Frameset</a> <span>$999.95</span> </li>
      <li><img src="products/1.gif" width="350" height="300"> <a href="#">Kestrel Talon Frameset</a> <span>$999.95</span> </li>
      <li><img src="products/1.gif" width="350" height="300"> <a href="#">Kestrel Talon Frameset</a> <span>$999.95</span> </li>
      <li><img src="products/1.gif" width="350" height="300"> <a href="#">Kestrel Talon Frameset</a> <span>$999.95</span> </li>
    </ul>
    <div style="clear:both;"></div>
  </div>
</div>
<div class="footer">
  <div class="footer-container">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <div class="footer">
   <div class="footer-container">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <div class="footer" style="padding:0;">
            <div class="footer-cols-wrapper">
              <div class="footer-col">
                <div class="f_block">
                  <h4>Information<span class="toggle"></span><span class="toggle"></span></h4>
                  <div class="footer-col-content">
                    <div class="part1">
                      <ul>
                        <li><a href="indexpage">Home</a></li>
                        <li><a href="Shipping">Shipping</a></li>
                        <li><a href="Privacy-Policy">Privacy Policy</a></li>
                        <li><a href="store-info">Store Info </a></li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
              <div class="footer-col">
                <div class="f_block">
                  <h4>Customer Service<span class="toggle"></span><span class="toggle"></span></h4>
                  <div class="footer-col-content">
                    <div class="part1">
                      <ul>
                        <li><a href="viewcartdetails">View Cart </a></li> 
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms &amp; Conditions</a></li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
               
               
               
               
              <div class="footer-col wide-col">
                <div class="f_block">
                  <h4>Subscribe for Saving<span class="toggle"></span><span class="toggle"></span></h4>
                  <div class="footer-col-content">
                  <form action="subscribetoemail" method="post">
                     <input type="text" id="newsEmail" name="emailid" value="Enter your email here" onfocus="this.value=''" onblur="if(this.value=='') this.value='Enter your email here';">
                     <input name="" type="submit" value=">" onclick="subscribe()" class="newsSubmit" return="" false="">
                      <div class="clear"></div>
                      <font color="red">
                     <div id="errormsg">
                      
                     
                     </div>
                     </font>
                    </form>
                  </div>
                </div>
              </div>
              <div class="footer-col wide-col last" style="width:150px;">
                <div class="f_block block-subscribe">
                  <h4> <span class="toggle"></span><span class="toggle"></span></h4>
                  <div class="footer-col-content">
                    <div class="part1"> <img src="images/brand.JPG" width="149" height="108">
                      <ul>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="contents">
        <p>Bicyclebuys.com will process any manufacturers warranty on any product we sell. Warranty claims need to be made to customer support at bicyclebuys.com. All warranty claims will be assessed based on the manufacturer's guidelines. Please call us at 1-888-4-Bike-Buy (1-888-424-5328, 631-673-2211) or e-mail your questions to info@bicyclebuys.com.</p>
      </div>
    </div>
  </div>
</div>
        </div>
      </div>
      <div class="contents">
        <p>Bicyclebuys.com will process any manufacturers warranty on any product we sell. Warranty claims need to be made to customer support at bicyclebuys.com. All warranty claims will be assessed based on the manufacturer's guidelines. Please call us at 1-888-4-Bike-Buy (1-888-424-5328, 631-673-2211) or e-mail your questions to info@bicyclebuys.com.</p>
      </div>
    </div>
  </div>
</div>
<div class="design-wrapper">
  <div class="container">
    <div class="design">
      <p class="fcl">BicycleBuys.com @ 2013 All rights reserved. </p>
      <p class="fcr">Phone: 1-888424-5328 1-631-673-2211 Email: info@bicyclebuys.com</p>
      <div class="clr"></div>
    </div>
  </div>
  <div class="clr"></div>
</div>
<div class="container"></div>

<!-- /container --> 

<!-- Bootstrap core JavaScript
    ================================================== --> 
<!-- Placed at the end of the document so the pages load faster --> 

<script src="js/cust.js"></script>
                 
<script src="js/jcarousellite_1.0.1c4.js" type="text/javascript"></script> 
<script src="js/newsticker.js" type="text/javascript"></script> 
<script src="js/bootstrap.min.js"></script> 
<script type="text/javascript" src="js/script.js"></script>



</body>
</html>
