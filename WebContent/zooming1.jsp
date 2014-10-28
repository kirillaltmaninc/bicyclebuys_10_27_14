<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta charset="utf-8">  
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

 
 <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
 <link href="css/BicycleBuys.css" rel="stylesheet">
 

<script type='text/javascript' src="js/jquery.min.js"></script>
<script type='text/javascript' src="js/jquery-ui.js"></script>
 
 

<script src="js/menu1.js" type="text/javascript"></script>
<link href="css/menu1.css" rel="stylesheet" type="text/css" />


 
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/extra_style.css" media="all"/>
<link rel="stylesheet" type="text/css" href="css/styles.css" media="all"/>
<link rel="stylesheet" type="text/css" href="css/footer.css" media="all"/>
<script type="text/javascript" src="js/scripts.js"></script>

  
 
 
 
<script type='text/javascript'>//<![CDATA[ 
$( document ).ready(function() {
	 
	 
$("#container").mouseenter(function() {
    $("#example3-link1").slideDown();
});
$("#container").mouseleave(function() {
    $("#example3-link1").slideUp();
});


if($("#size").length == 0) 
{
$(".color-size").html("<h2>Select Type</h2>"); 
}

});

</script>

<!-------zoomer part design----->
    
	  <script src="js/zoomsl-3.0.min.js"></script>
    <script src="js/main.js"></script>
    
    <script>
jQuery(function(){

    // Demo1
	$('.demo1').imagezoomsl({
 descarea: '.my-container', 				
          zoomrange: [1, 12],
          magnifiereffectanimate: 'fadeIn',
          magnifierborder: '1px solid #c0c0c0',
		  magnifierbackground: 'black',
		  magnifiersize: [430, 340]
	});

    
	
});
</script>
<style>
.magnifier{ background:#FFF !important; background-position:center;}
.demo2, .demo4, .demo6{float:right;}
.my-container{border:1px solid #F0F0F0; width:250px; height:250px; float:left;}
.round-loope{border-radius:75px; border:5px solid #F0F0F0;}
#wid{max-width: 350px;
max-height: 280px;/* width:320px; height: 280px;*/} 
		.fancybox-custom .fancybox-skin {
			box-shadow: 0 0 50px #222;
		} 
</style>

<script type="text/javascript">
		$(document).ready(function() { 
			$('.fancybox').fancybox(); 
			$(".fancybox-effects-a").fancybox({
				helpers: {
					title : {
						type : 'outside'
					},
					overlay : {
						speedOut : 0
					}
				}
			}); 
		});
	</script>
    	<script type="text/javascript" src="js/jquery.fancybox.js"></script>
	<link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css" media="screen" /> 
<script src="js/jquery.popupoverlay.js"></script> 
   <script>
$(document).ready(function () {

    $('#fadeandscale').popup({
        pagecontainer: '.container',
		 scrolllock: true,
        transition: 'all 0.3s'
    }); 
});
</script>

<style>
#fadeandscale {
    -webkit-transform: scale(0.8);
       -moz-transform: scale(0.8);
        -ms-transform: scale(0.8);
            transform: scale(0.8);  display: none;
}
.popup_visible #fadeandscale { 
    -webkit-transform: scale(1);
       -moz-transform: scale(1);
        -ms-transform: scale(1);display: block;
            transform: scale(1);
}.upload-resume-post{ background:#FFF; font-family:Arial, Helvetica, sans-serif;font-size:12px;  }
.upload-resume-post h1{ 
padding: 0 10px;
border-bottom: 2px solid #EC260D;
margin:0px 0 12px 0;
padding: 5px;
color: #EC260D;}
.upload-resume-post strong{font-size: 14px;
font-weight: bold; display:block; margin:0 0 25px 0;
border-bottom: 1px dotted #CCC;
padding: 6px;
}
.upload-resume-post img{ float:right;}
.wel{min-height: 20px;
padding: 4px;
margin-bottom: 20px;
background-color: #f5f5f5;
border: 1px solid #e3e3e3;
border-radius: 4px;
-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
}
.resu{border: 1px #aeadad solid;
border-radius: 3px;
line-height: 20px;
padding: 2px 5px;
background: #ffffff;
color: #B3B3B3;
color: #000; width:100%;
}

.resu1{border: 1px #aeadad solid;
border-radius: 3px;
line-height: 20px;
padding: 2px 5px; height:150px;
background: #ffffff;
color: #B3B3B3;
color: #000; width:100%;
}
.upload-resume-post span{display: block;color: #006699;
font-family: Arial, Helvetica, sans-serif;
font-size: 12px;
font-weight: bold !important;
padding: 7px 10px 0 0;}
.upload-resume-post tr{ color:#000; line-height:20px;}
.tabsle{ width: 504px;margin:0 auto;}
.upload-resume-post td{ line-height:28px;}
.apply-job{}
.Vacancy-listings h1{font: normal 18px Arial;
border-bottom: 2px solid #0273c2;
margin: 15px 0 12px 0;
padding: 5px;
color: #000;
}
</style> 

 <script>
$(document).ready(function () {

    $('#fade').popup({
      transition: 'all 0.3s',
      scrolllock: true
    }); 
});
</script> 
<style>
#fade {
    -webkit-transform: scale(0.8);
       -moz-transform: scale(0.8);
        -ms-transform: scale(0.8);
            transform: scale(0.8);
}
.popup_visible #fade {
    -webkit-transform: scale(1);
       -moz-transform: scale(1);
        -ms-transform: scale(1);
            transform: scale(1);
}
</style> 
 <script type="text/javascript" src="js/treeMenu.js"></script>
</head>
<body> 
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
      </button>
       THE HOLIDAY GIFT GUIDE - FIND THE RIGHT GIFT FOR ANY CYCLIST >> </div>
    <div class="navbar-collapse collapse"> </div> 
  </div>
</div> 
<div class="navbar navbar-inverse navbar-fixed-top" style="background:#464445; position:relative;" role="navigation">
  <div class="container">
    <div class="navbar-header" > <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
       </button> 
        <div class="checkout">
         <ul> 
          <%if(session.getAttribute("email")==null) { %> 
		  <%}else { %>
		  <li>Welcome :</li>
		   <li> <%=session.getAttribute("email")%>  </li> 
		   <li><a href="getmyaccount?uid=<%=session.getAttribute("uid")%>">My Account </a></li> 
		    <li> <a href="userlogout">Logout</a>  </li> 
			<%} %>  
          <a href="viewcartdetails"><li>  (<font color="red"><%if(request.getAttribute("cartitems")==null) {%> 0 <%} else {%><%=request.getAttribute("cartitems") %> <%} %> </font>&nbsp;) item(s)</li></a> 
         </ul> 
      </div>
      <div class="number"> <span>1.800.424.5328</span> </div>
    </div> 
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







</body>
</html>