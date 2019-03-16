/**
 * This is a js file for index.jsp page
 * 
 * In this file there is a JQuery function which reads the data submitted by the user and makes AJAX call to the server and 
 * it forwards the response back to the page.
 * 
 */

$(document).ready(function(){
	//alert("dom ready !");
	
	// when user tries to login
	$("#login_submitBtn").click(function(){
		//alert("login submit btn clicked");
		// remove all the error messagess
		$("#login_email_error").html("");
		$("#login_password_error").html("");
		$("login_credentials_error").html("");
		
		// get the data
		// data is correct. send it to the server
		
		var email = $("#login_email").val();
		var password = $("#login_password").val();
		
		// validate the data
		var expr = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		if((!expr.test(email)) && (password.length < 5 || password.length > 10)){
			$("#login_email_error").html("Incorrect format");
			$("#login_password_error").html("Use 6-10 characters only");
		}else if(password.length < 5 || password.length > 10){
			$("#login_password_error").html("Use 6-10 characters only");
		}else if(!expr.test(email)){
			$("#login_email_error").html("Incorrect format");
		}else{
			// when data is verified, send it to the server
			$.ajax({
				type: 'POST',
				data: {email : email, password : password, action : "login"},
				url: $("#form").attr("action"),
				success: function(message){
					if(message=="Success"){
						// just reload the page
						$('#login_modal').modal('toggle');
						location.reload();
					}else if(message=="Error 1"){
						console.log("in js error 1");
						$("#login_email_error").html("Incorrect format");
					}else if(message=="Error 2"){
						console.log("in js error 2");
						$("#login_password_error").html("Use 6-10 characters only");
					}else if(message=="Error 3"){
						console.log("in js error 3");
						$("#login_password_error").html("Use 6-10 characters only");
						$("#login_email_error").html("Incorrect format");
					}else if(message=="Error 4"){
						console.log("in js error 4");
						$("#login_credentials_error").html("Internal server problem. Please try again");
					}else if(message=="Error 5"){
						console.log("in js error 5");
						$("#login_credentials_error").html("Either Email Id or Password is incorrect");
					}
				}
			});
		}
	});
	
	// when user tries to register
	$("#register_submitBtn").click(function(){
		
		// remove all the error message
		$("#register_fn_error").html("");
		$("#register_ln_error").html("");
		$("#register_email_error").html("");
		$("#register_password_error").html("");
		$("#alredy_exist_error").html("");
		
		// get all the data
		var firstName = $("#register_fn").val();
		var lastName = $("#register_ln").val();
		var email = $("#register_email").val();
		var password = $("#register_password").val();
		
		// email validator reg-ex
		var expr = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		
		// validate the data
		if(firstName.length == 0){
			$("#register_fn_error").html("First Name cannot be blank");
		}else if(lastName.length == 0){
			$("#register_ln_error").html("Last Name cannot be blank");
		}else if(!expr.test(email)){
			$("#register_email_error").html("Incorrect format");
		}else if(password.length < 5 || password.length > 10){
			$("#register_password_error").html("Use 6-10 characters only");
		}else{
			
			// data is validated. send it to the server.
			$.ajax({
				type: 'POST',
				data: {firstName : firstName, lastName : lastName, email : email, password : password, action : "register"},
				url: $("#form").attr("action"),
				success: function(message){
					if(message == "Success"){
						// if registration is successful, just reload the page
						//console.log("success message recieved");
						 $('#register_modal').modal('toggle');
						location.reload(true);
					}else if(message == "Error 1"){
						$("#register_fn_error").html("First Name cannot be blank");
					}else if(message == "Error 2"){
						$("#register_ln_error").html("Last Name cannot be blank");
					}else if(message == "Error 3"){
						$("#register_email_error").html("Incorrect format");
					}else if(message == "Error 4"){
						$("#register_password_error").html("Use 6-10 characters only");
					}else if(message == "Error 5"){
						$("#alredy_exist_error").html("This Email Id is already registered with us. Try Login");
					}else if(message == "Error 6"){
						$("#alredy_exist_error").html("Internal server error. Please try again");
					}
				}
			});
		}
		
	});
	
});