$(document).ready(function(){
//global vars
	//alert("dsfsgsdsgdfgfd");
var form1 = $("#searchvalidation");
var searchkey = $("#searchval");


//On blur
searchkey.blur(validatesearch);

//On key press
searchkey.keyup(validatesearch);

//On Submitting
form1.submit(function(){
if(validatesearch())
return true
else
return false;
});


function validatesearch(){
//if it's NOT valid
if(searchkey.val().length < 1 || searchkey.val()=="Search | Bike,Cloths and more..."){
searchkey.addClass("error");
return false;
}
//if it's valid
else{
searchkey.removeClass("error");
return true;
}
}
});
