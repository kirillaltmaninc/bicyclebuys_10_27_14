<script src="js/jquery-1.10.0.min.js"></script>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<link href="css/responsive-menu.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src="js/jquery-ui.js"></script>
<script src="js/menu1.js" type="text/javascript"></script>
<link href="css/menu1.css" rel="stylesheet" type="text/css" />

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