function getXMLHTTP() { // fuction to return the xml http object
	var xmlhttp = false;
	try {
		xmlhttp = new XMLHttpRequest();
	} catch (e) {
		try {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e) {
			try {
				xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e1) {
				xmlhttp = false;
			}
		}
	}

	return xmlhttp;
}



function getsize(color, pid) {

	 
	var strURL = "getsize.jsp?color="+color+"&pid="+pid;
	var req = getXMLHTTP();

	if (req) 
	{

		req.onreadystatechange = function() 
		{
			if (req.readyState == 4) 
			{
				// only if "OK"
				if (req.status == 200) 
				{ 

					/*document.getElementById("loading").innerHTML = '';*/ // Hide
					// the
					// image
					// after
					// the
					// response
					// from
					// the
					// server
					document.getElementById('size').innerHTML = req.responseText;

				} else {
					// alert("There was a problem while using XMLHTTP:\n" +
					// req.statusText);
				}
			}
		}
		/*document.getElementById("loading").innerHTML = '<img src="img/loading10.gif" />'; // Set
		 */																										// here
		// the
		// image
		// before
		// sending
		// request
		req.open("GET", strURL, true);
		req.send();
	}
}

function get(stateabbr, total) {

	var strURL = "getdata.jsp?state_abbr="+stateabbr+"&total="+total;
	var req = getXMLHTTP();

	if (req) 
	{

		req.onreadystatechange = function() 
		{
			if (req.readyState == 4) 
			{
				// only if "OK"
				if (req.status == 200) 
				{ 

					/*document.getElementById("loading").innerHTML = '';*/ // Hide
					// the
					// image
					// after
					// the
					// response
					// from
					// the
					// server
					document.getElementById('disp').innerHTML = req.responseText;

				} else {
					// alert("There was a problem while using XMLHTTP:\n" +
					// req.statusText);
				}
			}
		}
		/*document.getElementById("loading").innerHTML = '<img src="img/loading10.gif" />'; // Set
		 */																										// here
		// the
		// image
		// before
		// sending
		// request
		req.open("GET", strURL, true);
		req.send();
	}
}

function get1(stateabbr, total) {

	var strURL = "getdata1.jsp?state_abbr="+stateabbr+"&total="+total;
	var req = getXMLHTTP();

	if (req) 
	{

		req.onreadystatechange = function() 
		{
			if (req.readyState == 4) 
			{
				// only if "OK"
				if (req.status == 200) 
				{ 

					/*document.getElementById("loading").innerHTML = '';*/ // Hide
					// the
					// image
					// after
					// the
					// response
					// from
					// the
					// server
					document.getElementById('disp').innerHTML = req.responseText;

				} else {
					// alert("There was a problem while using XMLHTTP:\n" +
					// req.statusText);
				}
			}
		}
		/*document.getElementById("loading").innerHTML = '<img src="img/loading10.gif" />'; // Set
		 */																										// here
		// the
		// image
		// before
		// sending
		// request
		req.open("GET", strURL, true);
		req.send();
	}
	req.open("GET", strURL, true);
	req.send();
}



function get2(stateabbr, total) {

	 
	var strURL = "getdata2.jsp?state_abbr="+stateabbr+"&total="+total;
	var req = getXMLHTTP();

	if (req) 
	{

		req.onreadystatechange = function() 
		{
			if (req.readyState == 4) 
			{
				// only if "OK"
				if (req.status == 200) 
				{ 

					/*document.getElementById("loading").innerHTML = '';*/ // Hide
					// the
					// image
					// after
					// the
					// response
					// from
					// the
					// server
					document.getElementById('disp').innerHTML = req.responseText;

				} else {
					// alert("There was a problem while using XMLHTTP:\n" +
					// req.statusText);
				}
			}
		}
		/*document.getElementById("loading").innerHTML = '<img src="img/loading10.gif" />'; // Set
		 */																										// here
		// the
		// image
		// before
		// sending
		// request
		req.open("GET", strURL, true);
		req.send();
	}
	req.open("GET", strURL, true);
	req.send();
}




function subscribe() {

	
	var newsEmail = document.getElementById('newsEmail').value;
	 

	if(!couponv)
	{
		document.getElementById("errormsg").innerHTML ="Enter Coupon Code";

	}
	else if(!document.subsc.newsEmail.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/))
	{
		document.getElementById("errormsg").innerHTML ="Enter valid email ID";
	}
	else
	{
		var strURL = "subscribe.jsp";
		var req = getXMLHTTP();

		if (req) 
		{

			req.onreadystatechange = function() 
			{
				if (req.readyState == 4) 
				{
					// only if "OK"
					if (req.status == 200) 
					{
						//document.getElementById("loading").innerHTML = ''; // Hide
						// the
						// image
						// after
						// the
						// response
						// from
						// the
						// server
						document.getElementById("errormsg11").innerHTML ="";
						document.getElementById('result').innerHTML = req.responseText;

					} else {
						// alert("There was a problem while using XMLHTTP:\n" +
						// req.statusText);
					}
				}
			}
			//document.getElementById("loading").innerHTML = '<img src="img/loading10.gif" />'; // Set
			// here
			// request
			req.open("GET", strURL, true);
			req.send();
		}
	}
}

//
