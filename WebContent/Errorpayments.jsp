<jsp:include page="header1.jsp"></jsp:include>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.admin.action.*"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.io.File"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% adminDAO obj;obj=new adminDAOImpl();%> 
<%request.setAttribute("menubar", request.getAttribute("menubar")); %> 
<body>

	<div style="clear: both;"></div>
	<div class="container">
		<div class="navigation1">
			    
			 
		</div>
		<div class="final-clr1"></div>
		<div class="row">
			<div class="col-md-4">
				  
				<div style="clear: both; height: 15px;"></div>
				 
			</div>
			<div class="col-xs-12 col-sm-8" style="background: #FFF;">
			<div class="matter">
			<h1 style="font-size: 17px;font-family: normal;font-weight: bold;margin: 0px 0px 15px">
			 <br>Your Payment is not successful please check Account Details and Resubmit. </h1> 
			</div>
				<div style="clear: both;"></div>
				<div id="main-content" class="box">
					<div class="center">
						<div id="page-content" class="box">

							<!-- demo -->
							<div id="demo" class="box jplist">

								<!-- ios button: show/hide panel -->

								<div class="list box text-shadow">

									
								 

								</div>
								 
								 
								<div class="jplist-panel box panel- bottom">

									<!-- back button button -->

									<!-- items per page dropdown -->

									<!-- sort dropdown -->
									<div style="clear: both;"></div>

									<!-- pagination results -->
									<div class="jplist-label" data-type="Page {current} of {pages}"
										data-control-type="pagination-info" data-control-name="paging"
										data-control-action="paging"></div>

									<!-- pagination -->
									<div class="jplist-pagination" data-control-type="pagination"
										data-control-name="paging" data-control-action="paging">
									</div>
									 
								</div>
							</div>
							<!-- end of demo -->
						</div>
					</div>
				</div> 
				<!--/row-->
			</div>
			<div style="clear: both;"></div>
			<!-- Example row of columns -->
			<div style="clear: both;"></div>
		</div>
	</div> 
	<jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>
