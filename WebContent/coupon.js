/***************************/
//@Author: Adrian "yEnS" Mato Gondelle & Ivan Guardado Castro
//@website: www.yensdesign.com
//@email: yensamg@gmail.com
//@license: Feel free to use it, but keep this credits please!					
/***************************/
  

$(document).ready(function(){
	//global vars
	// alert("Dsafsdfsddsf");
	var form = $("#loginform");
	var address=$("#couponv");
	var addressinfo = $("#addressinfo1");
	 
	
	 
	
	//On blur 
	address.blur(validateaddress); 
	//On key press 
	address.keyup(validateaddress); 
	//On Submitting
	form.submit(function(){
		if( validateaddress() )
			return true
		else
			return false;
	}); 
	//validation functions 
	
	 
	
	function validateaddress(){
		
		if(address.val().length <=0){
			address.addClass("error");
			//addressinfo.text("Coupon Code is required");
			addressinfo.addClass("error");
			return false;
		} 
		else{			
			
			
			address.removeClass("error");
			addressinfo.text("");
			addressinfo.removeClass("error"); 
			return true;
		}
	} 
	
	
}); 
