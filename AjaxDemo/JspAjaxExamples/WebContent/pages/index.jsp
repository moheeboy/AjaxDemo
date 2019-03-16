<%@ include file = "../common/header.jsp" %>

<script src="javascript/index_jsp.js?v=3" type="text/javascript"></script>

<div id="heading">
<%
	if(session.getAttribute("jspajax_email")!=null){
%>
	<p id="heading_font">Welcome <%=session.getAttribute("jspajax_email") %> to Mohit Techno Labs Ltd.</p>		
<%
	}else{
%>
		<p id="heading_font">Welcome to Mohit Techno Lab Ltd.</p>
<%	
	}
%>
</div>

<div id="main">
<%
	if(session.getAttribute("jspajax_email")!=null){
%>
	<!-- If the user is logged in, then show add and view users options -->
	<p>you have successfully loged in.</p>
<%
	}else{
%>	
	<!-- If the user is not logged in, show login and register options -->
	<button type="button" class="btn btn-success" data-toggle="modal" data-target="#login_modal" data-backdrop="static" data-keyboard="false">Login</button>
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#register_modal" data-backdrop="static" data-keyboard="false">Register</button>
<%	
	}
%>			
</div>

<form action="<%=request.getContextPath()%>/AjaxServlet" id="form"></form>

<!--All modals used in the system -->
<div id="modals">

	<!-- Modal for login -->
	<div id="login_modal" class="modal fade" role="dialog">
		 <div class="modal-dialog">

		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">Enter your credentials</h4>
		      </div>
		      <div class="modal-body">
		        <div class="container">
		        
		        	<div class="row">
		        		<div class="col-sm-1">
		        			Email Id
		        		</div>
		        		<div class="col-sm-2">
		        			<input type="text" id="login_email" placeholder="Email Id"/>
		        		</div>
		        		<div class="col-sm-3">
		        			<p id="login_email_error" class="error"></p>
		        		</div>
		        	</div>
		        	
		        	<div class="row">
		        		<div class="col-sm-1">
		        			Password
		        		</div>
		        		<div class="col-sm-2">
		        			<input type="password" id="login_password" placeholder="Password"/>
		        		</div>
		        		<div class="col-sm-3">
		        			<p id="login_password_error" class="error"></p>
		        		</div>
		        	</div>
		        	
		        	<div class="row">
		        		<p id="login_credentials_error" class="error"></p>
		        	</div>
		        
		        </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-success" id="login_submitBtn">Submit</button>
		      </div>
		    </div>

  		</div>	
	</div>
	<!-- End of login modal -->
	
	<!-- Modal for registration of user -->
	<div id="register_modal" class="modal fade" role="dialog">
		 <div class="modal-dialog">

		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">Enter your details</h4>
		      </div>
		      <div class="modal-body">
		        <div class="container">
		        
		        	<div class="row">
		        		<div class="col-sm-2">
		        			First Name
		        		</div>
		        		<div class="col-sm-2">
		        			<input type="text" id="register_fn" placeholder="First Name"/>
		        		</div>
		        		<div class="col-sm-3">
		        			<p id="register_fn_error" class="error"></p>
		        		</div>
		        	</div>
		        	
		        	<div class="row">
		        		<div class="col-sm-2">
		        			Last Name
		        		</div>
		        		<div class="col-sm-2">
		        			<input type="text" id="register_ln" placeholder="Last Name"/>
		        		</div>
		        		<div class="col-sm-3">
		        			<p id="register_ln_error" class="error"></p>
		        		</div>
		        	</div>
		        	
		        	<div class="row">
		        		<div class="col-sm-2">
		        			Email Id
		        		</div>
		        		<div class="col-sm-2">
		        			<input type="text" id="register_email" placeholder="Email Id"/>
		        		</div>
		        		<div class="col-sm-3">
		        			<p id="register_email_error" class="error"></p>
		        		</div>
		        	</div>
		        	
		        	<div class="row">
		        		<div class="col-sm-2">
		        			Password
		        		</div>
		        		<div class="col-sm-2">
		        			<input type="password" id="register_password" placeholder="Password"/>
		        		</div>
		        		<div class="col-sm-3">
		        			<p id="register_password_error" class="error"></p>
		        		</div>
		        	</div>
		        	
		        	<div class="row">
		        		<p id="alredy_exist_error" class="error"></p>
		        	</div>
		        
		        </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-success" id="register_submitBtn">Submit</button>
		      </div>
		    </div>

  		</div>	
	</div>
	<!-- End of register modal -->
	
</div>
<!-- End of all Modals -->

<%@ include file = "../common/footer.jsp" %>