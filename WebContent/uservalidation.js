

$(document).ready(function(){
	//global vars
	var form = $("#uservalidationafterlogin"); 
	var fname = $("#fname");
	var fnameInfo = $("#fnameInfo");
	
	var lname = $("#lname");
	var lnameInfo = $("#lnameInfo");
	var shipinfo = $("#shipinfo");
	var abc = $("#abccc");
	
	
	var address=$("#address");
	var addressinfo = $("#addressinfo");
	 
	var city=$("#city");
	var cityInfo = $("#cityInfo");
	 
	var email = $("#email");
	var emailInfo = $("#emailInfo");
	var eval=email.val();
	
	var postalcode = $("#postalcode");
	var postalcodeInfo = $("#postalcodeinfo");
	
	var country = $("#country");
	var countryInfo = $("#countryinfo");
	
	
	var shipcountry=$("#shipcountry");
	
	var city = $("#city");
	var cityInfo = $("#cityinfo");
	
	 
	
	var phone = $("#phone");
	var phoneInfo = $("#phoneInfo");
	var pval=phone.val();
  
	//On blur
	fname.blur(validateName);
	lname.blur(validateName1);
	country.blur(validateCountry);
	
	
	email.blur(validateEmail);
	
	
	
	phone.blur(validatePhone);
	
	
	address.blur(validateaddress);
	postalcode.blur(validatepostal);
	city.blur(validatecity);
	abc.blur(shipping);
	//On key press
	fname.keyup(validateName);
	lname.keyup(validateName1);
	phone.keyup(validatePhone);
	country.keyup(validateCountry);
	email.keyup(validateEmail);
	address.keyup(validateaddress);
	 
	postalcode.keyup(validatepostal);
	city.keyup(validatecity);
	abc.keyup(shipping);
	
	

	shipcountry.on('change', function (e) {
		
		var v=shipcountry.val();
		
		if(v!="US")
		{
			b= $('#fitotf').text();
			
			 
				  cpr = $('#couponprice').text(); 
				  if(cpr=='')
					  { 
					  cpr=0;
				  
					  }
				  else
					  {
					  cpr = cpr.replace('$', '');
					  }
				 
				  b = b.replace('$', '');
				  var fin = (parseFloat(b) - parseFloat(cpr));
			
			$("#ftot").html("$"+fin);
			postalcode.removeClass("error");
			postalcodeInfo.text("");
			postalcodeInfo.removeClass("error");
			postalcode.val('');
			shipinfo.text("");
			shipinfo.removeClass("error");
		}
		
		else
		{
		
		postalcode.removeClass("error");
		postalcodeInfo.text("");
		postalcodeInfo.removeClass("error");
		postalcode.val('');

		}
	});

	 
	
	 
	//On Submitting
	form.submit(function(){
		if(validateName() & validateName1()  & shipping() & validateEmail() & validateCountry() & validatePhone()     &  validateaddress()  &  validatepostal() &  validatecity())
			return true
		else
			return false;
	});
	
	//validation functions
	 function shipping()
		{ //if it's NOT valid
		 if($.trim(country.val())!="ZZ")
			 {
			 
			
	if ($("input[name='shipcost']:checked").length > 0){
		  // one ore more checkboxes are checked
		shipinfo.text("");
		shipinfo.removeClass("error");
		return true;
	}
		else{
		 // no checkboxes are checked
			shipinfo.text("Choose Shipping Via!");
			shipinfo.addClass("error");
			return false;
		} }
		 else
			 {
			 
			 return true;
			 }
		}
 function validateCountry()
	{ //if it's NOT valid
	 
	 
	if(($.trim(country.val())=="ZZ" && shipcountry.val().length<=0) ||($.trim(country.val())=="ZZ" && shipcountry.val()=="US") )
	{ 
	country.addClass("error");
	countryInfo.text("Choose State!"); 
	countryInfo.addClass("error"); 
	return false; 
	} //if it's valid 
	else{ 
	country.removeClass("error"); 
	countryInfo.text("");
	countryInfo.removeClass("error"); 
	return true; }
	}
	
	
	    function validateEmail(){
			//testing regular expression
			var a = $("#email").val();
			
			 
			var filter = /^[a-zA-Z0-9]+[a-zA-Z0-9_.-]+[a-zA-Z0-9_-]+@[a-zA-Z0-9]+[a-zA-Z0-9.-]+[a-zA-Z0-9]+.[a-z]{2,4}$/;
			//if it's valid email
			if(filter.test(a)){
				email.removeClass("error");
				emailInfo.text("");
				emailInfo.removeClass("error");
				return true;
			}
			//if it's NOT valid
			else{
				email.addClass("error");
				emailInfo.text("Enter Valid Email Id");
				emailInfo.addClass("error");
				return false;
			}
			 
		}
		
		
	
	
	function validateName(){
		//if it's NOT valid
		
		var c = fname.val();
		var rname = /^[A-Za-z ]+$/;
	 
		
		if(fname.val().length < 0){
			fname.addClass("error");
			fnameInfo.text("First Name is required");
			fnameInfo.addClass("error");
			return false;
		}
		else if(!rname.test(c))
		{
			fname.addClass("error");
			fnameInfo.text("Enter Only Characters");
			fnameInfo.addClass("error");
			return false;
			
		}
		//if it's valid
		else{
			fname.removeClass("error");
			fnameInfo.text("");
			fnameInfo.removeClass("error");
			return true;
		}
	}
	
	
	function validateName1(){
		
		var c = lname.val();
		var rname = /^[A-Za-z ]+$/;
		//if it's NOT valid
		if(lname.val().length < 4){
			lname.addClass("error");
			lnameInfo.text("Last Name is required");
			lnameInfo.addClass("error");
			return false;
		}
		else if(!rname.test(c))
		{
			lname.addClass("error");
			lnameInfo.text("Enter Only Characters");
			lnameInfo.addClass("error");
			return false;
			
		}
		//if it's valid
		else{
			lname.removeClass("error");
			lnameInfo.text("");
			lnameInfo.removeClass("error");
			return true;
		}
	}
	
	 
	 
	function validatePhone(){
		//it's NOT valid
			var b = phone.val();
		 var rcontact = /^\s*\d{10}$/;
		 
	 
		 
		if(phone.val().length < 10 || phone.val().length > 10){
			phone.addClass("error");
			phoneInfo.text("Phone Number is required");
			phoneInfo.addClass("error");
			return false;
		}
		else if(!rcontact.test(b))
		{
				b=" ";
			phone.addClass("error");
			phoneInfo.text("Numbers only Allowed");
		
			phoneInfo.addClass("error");
			return false;
		}
		//it's valid
		else{			
			phone.removeClass("error");
			phoneInfo.text("");
			phoneInfo.removeClass("error");
			return true;
		}
		 
	}
	
	 
	 
	 
	function validatepostal(){
		//it's NOT valid 
		if(shipcountry.val()!='US')
		{
			postalcode.removeClass("error");
			postalcodeInfo.text("");
			postalcodeInfo.removeClass("error");
			return true;
	    } 
			else
			{
				//alert("US");
				//alert(shipcountry.val()); 
				var b = postalcode.val();
				var rcontact = /^\s*\d{5}$/;
				
			postalcode.keydown(function (e) {
				// Allow: backspace, delete, tab, escape, enter and .
				if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
				// Allow: Ctrl+A
	            (e.keyCode == 65 && e.ctrlKey === true) || 
				// Allow: home, end, left, right
	            (e.keyCode >= 35 && e.keyCode <= 39)) {
					// let it happen, don't do anything
					return true;
				}
				// Ensure that it is a number and stop the keypress
				if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
					//e.preventDefault();
				}
			});
			
			
			
				
				if(postalcode.val().length < 5 || postalcode.val().length > 5){
					postalcode.addClass("error");
					postalcodeInfo.text("Postal Code is required");
					postalcodeInfo.addClass("error");
					return false;
				}
				else if(!rcontact.test(b))
				{
					b=" ";
					postalcode.addClass("error");
					postalcodeInfo.text("Numbers only Allowed, 5 digit Postal Code");
					
					postalcodeInfo.addClass("error");
					return false;
				}
				//it's valid
				else{			
					postalcode.removeClass("error");
					postalcodeInfo.text("");
					postalcodeInfo.removeClass("error");
					return true;
				}
				
			} 
	 
	}
	 
	 
	function validateaddress(){
		//it's NOT valid
	
		if(address.val().length <=0){
			address.addClass("error");
			addressinfo.text("Address Line is required");
			addressinfo.addClass("error");
			return false;
		}
		
		
		else if(address.val().length <0){
			address.addClass("error");
			addressinfo.text("Minimum 10 Characters");
			addressinfo.addClass("error");
			return false;
		}
		//it's valid
		else{			
			address.removeClass("error");
			addressinfo.text("");
			addressinfo.removeClass("error");
			
			return true;
		}
	}
	
	
	
	
	
	function validatecity(){
		//it's NOT valid
		
		if(city.val().length <=0){
			city.addClass("error");
			cityInfo.text("City is required");
			cityInfo.addClass("error");
			return false;
		}
		
		
		else if(city.val().length < 0){
			city.addClass("error");
			cityInfo.text("Minimum 2 Characters");
			cityInfo.addClass("error");
			return false;
		}
		//it's valid
		else{			
			city.removeClass("error");
			cityInfo.text("");
			cityInfo.removeClass("error");
			
			return true;
		}
	}
	
	
	
});