<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Bicyclebuys</title>  
<script type='text/javascript' src="js/jquery.min.js"></script>
<script type='text/javascript' src="js/jquery-ui.js"></script>
<script src="js/menu1.js" type="text/javascript"></script>
 
<link href="css/BicycleBuys.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen" /> 
<script type="text/javascript" src="js/jquery.js"></script>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src="js/jquery.min.js"></script>
<script type='text/javascript' src="js/jquery-ui.js"></script> 
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/extra_style.css" media="all"/>
<link rel="stylesheet" type="text/css" href="css/styles.css" media="all"/>
<link rel="stylesheet" type="text/css" href="css/footer.css" media="all"/>
<script type="text/javascript" src="js/scripts.js"></script>



 
<link href="css/responsive-menu-homepage.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="js/treeMenu.js"></script>


<script type="text/javascript">
function ChkSP()
{
if (document.checkoutformreg.STATEPROVINCE.selected != "ZZ")
{
//alert(document.checkoutform.STATEPROVINCE.value)
if (document.checkoutformreg.COUNTRY.value != "US")
{
document.checkoutformreg.COUNTRY.value = "US";
document.checkoutformreg.CUSTOM1.disabled=true;
document.checkoutformreg.CUSTOM1.value = 'for International';
}
}
} //end of function

function chk1()
{
if (document.checkoutformreg.STATEPROVINCE.selected != "ZZ")
{
//alert(document.checkoutform.STATEPROVINCE.value)
if (document.checkoutformreg.COUNTRY.value != "US")
{
document.checkoutformreg.STATEPROVINCE.value = "ZZ"; 
}
}
}
</script> 


<script type='text/javascript'>//<![CDATA[ 
$(window).load(function(){
 //100 = animation speed in miliseconds
 
 
  $("#content").show($("#content1").hide());
 
});//]]>  

</script>
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
          	<div class="links"> <a href="registerorlogin">Create Account |  login |</a> </div>
		  <%}else { %>
		  <li>Welcome :</li>
		   <li> <%=session.getAttribute("email")%>  </li> 
		   <li><a href="getmyaccount?uid=<%=session.getAttribute("uid")%>">My Account </a></li> 
		    <li> <a href="userlogout">Logout</a>  </li> 
			<%} %>  
             <a href="viewcartdetails"><li>   (<font color="red"><%if(request.getAttribute("cartitems")==null) {%> 0 <%} else {%><%=request.getAttribute("cartitems") %> <%} %> </font>&nbsp;) item(s)</li></a> 
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
    </div>
  </div>
  
  <!--/.navbar-collapse --> 
</div>







</body>
</html>