<%@ page contentType="text/html; charset=UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
<title> <%if(request.getAttribute("metatitle")==null) {%>  <%} else{%><%=request.getAttribute("metatitle")%> <%} %>| bicyclebuys.com </title>
   <meta name="description" content="<%=request.getAttribute("metadescription")%>">
   <meta name="keywords" content="<%=request.getAttribute("keywords")%>"> 
<%
String scheme = request.getScheme();             
String serverName = request.getServerName(); 
int serverPort = request.getServerPort();    
String uri = (String) request.getAttribute("javax.servlet.forward.request_uri");
String prmstr = (String) request.getAttribute("javax.servlet.forward.query_string");
String url = scheme + "://" +serverName + ":" + serverPort + uri + "?" + prmstr;
%>  
   <link rel="canonical" href="<%=url %>" />
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="author" content="">
<script type="text/javascript" src="js/jquery.min.js">
		</script>
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link href="css/BicycleBuys.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<link href="css/responsive-menu.css" rel="stylesheet" type="text/css" />
<link href="css/responsive.css" rel="stylesheet" type="text/css" />

 
<link rel="stylesheet" href="css/styles.min.css" />
<link href="css/jplist.min.css" rel="stylesheet" type="text/css" />
 
<!-- js -->

<script src="js/jquery-1.10.0.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jplist.min.js"></script>

    
   
  
  
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
				 
				var minv=parseFloat($("#minv").html());
				var maxv=parseFloat($("#maxv").html());
				
				
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
										min: minv
										,max: maxv
										,range: true
										,values: [minv, maxv]
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
										min:minv
										,max: maxv
										,range: true
										,values: [minv, maxv]
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
										min: minv
										,max: maxv
										,range: true
										,values: [minv, maxv]
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
		</script>
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/extra_style.css" media="all"/>
<link rel="stylesheet" type="text/css" href="css/footer.css" media="all"/>
<link rel="stylesheet" type="text/css" href="css/responsive.css" media="all"/>
<script type="text/javascript" src="js/scripts.js"></script>
<link rel="stylesheet" type="text/css" href="css/styles.css" media="all"/>



 
<script type='text/javascript' src="js/jquery-ui.js"></script>
<script src="js/menu1.js" type="text/javascript"></script>
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

 
 <script type="text/javascript">


	 
 
 </script>
 
 
 <script type="text/javascript" src="js/treeMenu.js"></script>
 
  


</head>
<body>
 
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
      </button>
      THE HOLIDAY GIFT GUIDE - FIND THE RIGHT GIFT FOR ANY CYCLIST >> </div>
    <div class="navbar-collapse collapse"> </div>
    <!--/.navbar-collapse --> 
  </div>
</div>

<div class="navbar navbar-inverse navbar-fixed-top" style="background:#464445; position:relative;" role="navigation">
  <div class="container">
    <div class="navbar-header" > <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
      </button>
     
       <div class="checkout">
         <ul> 
          <%if(session.getAttribute("email")==null) { %>	
           <div class="links"> <a href="registerorlogin">Create Account | login |</a> </div>			
		  <%}else { %>
		  <li>Welcome :</li>
		   <li> <%=session.getAttribute("email")%>  </li> 
		   <li><a href="getmyaccount?uid=<%=session.getAttribute("uid")%>">My Account </a></li> 
		    <li> <a href="userlogout">Logout</a>  </li> 
			<%} %>  
          <a href="viewcartdetails"><li>  (<font color="red" id="cartcount"><%if(request.getAttribute("cartitems")==null) {%> 0 <%} else {%><%=request.getAttribute("cartitems") %> <%} %> </font>&nbsp;) item(s)</li></a> 
         
        </ul> 
      </div>
      <div class="number"> <span>1.800.424.5328</span> </div>
    </div>
    
    <!--/.navbar-collapse --> 
  </div>
</div>
<div class="navbar navbar-inverse navbar-fixed-top" style="background: #f4f4f4;
border-bottom: solid 1px #bfbbbc; position:relative;" role="navigation">
  <div class="container">
    <div class="navbar-header" > <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
      </button>
      <div class="links"> <a href="indexpage"> <img src="images/logo.png"  class="logo-img" > </a> </div>
      
      
      
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <div class="navbar-collapse collapse" style="float:right;">
        <link rel="stylesheet" href="general1.css" />
        <form action="search" method="post" id="searchvalidation">
         <div class="search">
	          <input type="text" id="searchval"  name="searchitem" value="Search | Bike,Cloths and more..." onfocus="this.value=''" onblur="if(this.value=='') this.value='Search | Bike,Cloths and more...';" class="search1">
	          <span id="fsearchval"></span>
	          <div class="botton">
	           <!-- <a href="#"> <img src="image/seacrch.png" width="12" height="15"> </a>-->
	           <input type="submit" value="" style="border:0px;background-repeat:no-repeat;background-image:url('images/seacrch.png');width: 12px; height: 15px; " class="botton">
	           </div>
	        </div>
	        </form>
	        <script type="text/javascript" src="searchvalidation.js"></script>
	        
      </div>
      
      <div class="right-links">  
       
      	<span id="container"> 
    <div id="caribbean-info">
     <span>Shop by Categories<img src="images/download.png" width="15" height="9"  alt=""/></span>
    </div>
    
  <div id="example3-link1">
    
     <div class="category-inner">  
       <div >
          <div id="menudiv">
						
						<div class="drop"> 
          <%@ page import="com.admin.action.*"%>
<%@ page import="java.util.*"%>
 <% adminDAO obj;obj=new adminDAOImpl();%>
         <div id="treeMenu">
 
        <ul>
        <% 
       
        ArrayList menubar1 =  (ArrayList)session.getAttribute("menubar1");  
        request.setAttribute("menubar1", menubar1);
        System.out.println("menubar-->"+menubar1);
        %>        
        <c:forEach items="${menubar1}" var="m">
		<li><a href="Category?/${m.categoryname}/&id=${m.webTypes}&cate=${m.categoryname}&subcatid=${m.subcatid}" class="parent">${m.categoryname}</a><span></span>
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
									  <ul>
											  
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
								<c:forEach items="${menubar1}" var="m"> 
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
    </div>
    
</span>
      	
      	
      	
      	
      
       </div>
    </div>
  </div>
  
  <!--/.navbar-collapse --> 
</div>




 