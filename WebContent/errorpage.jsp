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
 <link href="css/bootstrap.min.css" rel="stylesheet">
 

<script type='text/javascript' src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type='text/javascript' src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
 
<script src="js/menu1.js" type="text/javascript"></script>
<link href="css/menu1.css" rel="stylesheet" type="text/css" />


 
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="footrer/extra_style.css" media="all"/>
<link rel="stylesheet" type="text/css" href="footrer/styles.css" media="all"/>
<link rel="stylesheet" type="text/css" href="footrer/responsive.css" media="all"/>
<script type="text/javascript" src="footrer/scripts.js"></script>

  

 
 
<script type='text/javascript'>//<![CDATA[ 
window.onload=function(){
$("#container").mouseenter(function() {
    $("#example3-link1").slideDown();
});
$("#container").mouseleave(function() {
    $("#example3-link1").slideUp();
});
}//]]>  

</script>

<!-------zoomer part design----->
    
	  <script src="zooming/zoomsl-3.0.min.js"></script>
    <script src="zooming/main.js"></script>
    
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
.demo2, .demo4, .demo6{float:right;}
.my-container{border:1px solid #F0F0F0; width:250px; height:250px; float:left;}
.round-loope{border-radius:75px; border:5px solid #F0F0F0;}
#wid{ width:320px; height: 280px;}

 
		.fancybox-custom .fancybox-skin {
			box-shadow: 0 0 50px #222;
		}

	 
	 
	 
</style>

<script type="text/javascript">
		$(document).ready(function() {
			/*
			 *  Simple image gallery. Uses default settings
			 */

			$('.fancybox').fancybox();

			/*
			 *  Different effects
			 */

			// Change title type, overlay closing speed
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

			// Disable opening and closing animations, change title type
			 
		});
	</script>
    	<script type="text/javascript" src="zooming/jquery.fancybox.js"></script>
	<link rel="stylesheet" type="text/css" href="zooming/jquery.fancybox.css" media="screen" />
 
   
 <!-------End zoomer part design----->

 
 
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
            		
		  <%}else { %>
		  <li>&nbsp;&nbsp;&nbsp; </li>
		   <li> &nbsp;&nbsp;   </li> 
		   <li> &nbsp;&nbsp;</li> 
		    <li>&nbsp;&nbsp;    </li> 
			<%} %>  
           <li> &nbsp;&nbsp; </li> 
         
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
	           <input type="submit" value="" style="border:0px;background-repeat:no-repeat;background-image:url('image/seacrch.png');width: 12px; height: 15px; " class="botton">
	           </div>
	        </div>
	        </form>
	        <script type="text/javascript" src="searchvalidation.js"></script>
	        
      </div>
      
      <div class="right-links">  
      
      	 
      
       </div>
    </div>
  </div>
  
  <!--/.navbar-collapse --> 
</div> 
</body>
</html>