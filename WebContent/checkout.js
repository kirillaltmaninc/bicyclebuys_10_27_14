 
$(document).ready(function(){
	//global vars
	var form = $("#checkoutform");
	var fname = $("#fname");
	var fnameInfo = $("#fnameInfo");
	
	var lname = $("#lname");
	var lnameInfo = $("#lnameInfo");
	
	var address=$("#address");
	var addressinfo = $("#addressinfo");
	 
	var city=$("#city");
	var cityInfo = $("#cityinfo");
	
	var cardtype=$("#cardtype");
	
	
	var country = $("#country");
	var countryInfo = $("#countryinfo");
	
	var shipcountry = $("#shipcountry");
	var shipcInfo = $("#shipcountryi");
	
	var cardnum = $("#first-name-field");
	var cardnumInfo = $("#cardnumInfo");
	
	var firstnamefield4 = $("#first-name-field4");
	var firstnamefield4Info = $("#firstnamefield4Info");
	

	var cardexpmonth = $("#card-exp-month");
	var cardexpInfo = $("#cardexpInfo");

	var cardExpiryYear = $("#card-exp-year");
	var cardexpInfo = $("#cardexpInfo");
	 
	var cardExpiryYear = $("#card-exp-year");
	var cardexpInfo = $("#cardexpInfo");
	 
	
	var postalcode = $("#postalcode");
	var postalcodeInfo = $("#postalcodeinfo");
	
	
	
	 
	 
	
	 
	//On blur
	fname.blur(validateName);
	lname.blur(validateName1);
	
	cardnum.blur(validateCardnum);
	
	firstnamefield4.blur(validateCvvno);
	cardexpmonth.blur(validateCardexpmonth);
	cardExpiryYear.blur(validateCardExpiryYear);


	
	address.blur(validateaddress);
	postalcode.blur(validatepostal);
	city.blur(validatecity);
	country.blur(validatecity);
	
	//On key press
	fname.keyup(validateName);
	lname.keyup(validateName1);
	 
	country.keyup(validateName1);
	cardnum.keyup(validateCardnum);
	
	
	cardexpmonth.keyup(validateCardexpmonth);
	cardExpiryYear.keyup(validateCardExpiryYear);
	firstnamefield4.keyup(validateCvvno);
	postalcode.keyup(validatepostal);
	city.keyup(validatecity);
	cardtype.change(validatecard123);
	
	shipcountry.on('change', function (e) {
		var v=shipcountry.val();
				
				if(v!="US")
				{
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
	
	
	//form submition starts here
	
	form.submit(function(){

		///if the condition is unchecked
		var scval = $("#scval").html().length;
		if(scval>2)
		{
			
			//submission check based on card type
		if(cardtype.val()=="1")
			{ 
	 
		if(validateCardnum() & validateCardexpmonth() & validateCardExpiryYear() & validateCvvno())
		return true;
		else
		return false;
		
		
			}
		
		else
			{
			 
			return true;
			}
		}
		else
		{
			//submission check based on card type
			
			if(cardtype.val()=="1")
			{ 
	 
				if(validateCardnum() & validateCardexpmonth() & validateCardExpiryYear() & validateName() & 
				validateName1() & validateaddress() & validatepostal() & validatecity() & validatestate() & validateshipc())
					return true;
				else
					return false;
			}
			else
			{
				
				if(validateName() & 
						validateName1() & validateaddress() & validatepostal() & validatecity() & validatestate() & validateshipc())
							return true;
						else
							return false;
				
			}

		}

		});
	
	//form submission ends here
	
	

	function validatestate()
	{ //if it's NOT valid
	if($.trim(country.val())=="ZZ" && shipcountry.val()=="US")
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
	
	
	
	
	function validateshipc()
	{ //if it's NOT valid
	if($.trim(shipcountry.val().length)<1)
	{ 
		
		
		shipcountry.addClass("error");
		shipcInfo.text("Choose State!"); 
		shipcInfo.addClass("error"); 
	return false; 
	} //if it's valid 
	else{  
		shipcountry.removeClass("error"); 
		shipcInfo.text("");
		shipcInfo.removeClass("error"); 
	return true; }
	}
	
	
	
	
	function validatecard123()
	{
		if(cardtype.val()!="1")
			{
			cardnum.removeClass("error");
			cardnumInfo.text("");
			cardnumInfo.removeClass("error");
			
			cardexpmonth.removeClass("error");
			cardexpInfo.text("");
			cardexpInfo.removeClass("error");
			cardExpiryYear.removeClass("error");
			cardexpInfo.text("");
			cardexpInfo.removeClass("error");
			
			firstnamefield4.removeClass("error");
			firstnamefield4Info.text("");
			
			
			}
		
	}
	 

	function validateCardnum()
	{ ///^\d*\.?\d*$/
	var c = cardnum.val();
	var rname = /^\s*\d{16}$/;
	//if it's NOT valid
	if(cardnum.val().length < 1){
	cardnum.addClass("error");
	cardnumInfo.text("Card number is required");
	cardnumInfo.addClass("error");
	return false;
	}else if(!rname.test(c))
	{
	cardnum.addClass("error");
	cardnumInfo.text("Enter valid card number");
	cardnumInfo.addClass("error");
	return false;

	}
	else{//if it's valid
	cardnum.removeClass("error");
	cardnumInfo.text("");
	cardnumInfo.removeClass("error");
	return true;
	}
	}

	
	
	function validateCvvno()
	{ ///^\d*\.?\d*$/
	var c = firstnamefield4.val();
	var rname = /^\s*\d{3}$/;
	//if it's NOT valid
	if(firstnamefield4.val().length < 1){
		firstnamefield4.addClass("error");
		firstnamefield4Info.text("CVV number is required");
		firstnamefield4Info.addClass("error");
	return false;
	}else if(!rname.test(c))
	{
		firstnamefield4.addClass("error");
		firstnamefield4Info.text("Enter valid CVV number");
		firstnamefield4Info.addClass("error");
	return false;

	}
	else{//if it's valid
		firstnamefield4.removeClass("error");
		firstnamefield4Info.text("");
		firstnamefield4Info.removeClass("error");
	return true;
	}
	}

	function validateCardexpmonth()
	{ //if it's NOT valid
	if($.trim(cardexpmonth.val())=="")
	{ cardexpmonth.addClass("error");
	cardexpInfo.text("Choose card Exp Month!");
	cardexpInfo.addClass("error");
	return false;
	} //if it's valid
	else{
	cardexpmonth.removeClass("error");
	cardexpInfo.text("");
	cardexpInfo.removeClass("error");
	return true; }
	}

	function validateCardExpiryYear()
	{ //if it's NOT valid


	/*if($.trim(cardexpmonth.val())!="")
	{*/

	if($.trim(cardExpiryYear.val())=="")
	{ cardExpiryYear.addClass("error");
	cardexpInfo.text("Choose card Exp Year!");
	cardexpInfo.addClass("error");
	return false;
	} //if it's valid
	else{
	cardExpiryYear.removeClass("error");
	cardexpInfo.text("");
	cardexpInfo.removeClass("error");
	return true; }

	//}

	}
	
	function validateName(){
		//if it's NOT valid
		
		var c = fname.val();
		var rname = /^[A-Za-z ]+$/;
	 
		
		if(fname.val().length < 1){
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
		if(lname.val().length < 1){
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
	
	
	 
	 
	 
	function validatepostal(){
		//it's NOT valid 
		if(shipcountry.val()!="US")
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
			addressinfo.text("Fill In the Address!");
			addressinfo.addClass("error");
			return false;
		}
		
		
		else if(address.val().length < 1){
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
			cityInfo.text("City is Required!");
			cityInfo.addClass("error");
			return false;
		}
	 	else{			
			city.removeClass("error");
			cityInfo.text("");
			cityInfo.removeClass("error");
			
			return true;
		}
	}
	
	
	
});