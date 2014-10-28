package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldValidationImplementedClass implements FieldValidationInterface{

	  //validation for name with length 3-30 chars
	public boolean name(String name) {
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[a-zA-Z\\s\\.]{3,30}$";  
		CharSequence inputStr = name;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  

	}

	
	public boolean categoryname(String categoryname) {
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[a-zA-Z\\s\\.]{3,30}$";  
		CharSequence inputStr = categoryname;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  

	}

	
	
	
	
public boolean costPrice(String cost){
		
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[-+]?([0-9]*\\.)?[0-9]+";
		CharSequence inputStr = cost;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}


public boolean quantity(String cost){
	
	boolean isValid = false;  
	  
	//Initialize reg ex for email.  
	String expression = "^[0-9]*$";
	CharSequence inputStr = cost;  
	//Make the comparison case-insensitive.  
	Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
	Matcher matcher = pattern.matcher(inputStr);  
	if(matcher.matches()){  
	isValid = true;  
	}  
	return isValid;  
}



	/* validation for education qualification with length 2-30 chars */
 
	public boolean qualification(String qualification) {
		
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[a-zA-Z\\s\\.]{2,30}$";  
		CharSequence inputStr = qualification;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}


	/* validation for address with length 3-150 chars */
 
	public boolean address(String address) {
		
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[a-zA-Z\\d\\s\\.\\#\\/\\_\\(\\)\\,]{3,150}$";  
		CharSequence inputStr = address;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}

public boolean productcode(String pcode) {
		
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[a-zA-Z\\d\\s\\.\\#\\/\\_\\(\\)\\,]{3,20}$";  
		CharSequence inputStr = pcode;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}


	/* validation for mobile number with ISD code*/
	 
	public boolean mobile(String mobile) {
		
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^(\\+91[\\s]?)?\\d{10}$";  
		CharSequence inputStr = mobile;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}


	/* validation for landline number with 3-20 digits */
	 
	public boolean landline(String landphone) {
		
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[0-9]{3,20}$";  
		CharSequence inputStr = landphone;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}


	/* validation for email */
	 
	public boolean email(String mailid) {
		
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[\\w]{2,4}$";   
		CharSequence inputStr = mailid;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}


	/* validation for blood group */
 
	public boolean bloodGroup(String blood) {
		
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "[A|B|AB|O][\\+|\\-]";   
		CharSequence inputStr = blood;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}


	/* validation for profession with 2-50 length of char*/
	 
	public boolean profession(String work) {
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[a-zA-Z\\s]{2,50}$";  
		CharSequence inputStr = work;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid; 
	}


	/* validation for annual income with length 10*/
 
	public boolean annualIncome(String income) {
		
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[0-9]{4,10}$";  
		CharSequence inputStr = income;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}


	/* validation for age */
	 
	public boolean age(String age) {
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[0-9]{1,2}$";  
		CharSequence inputStr = age;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}


	/* validation for extra activities with length 3-100 alphanumeric char*/
	 
	public boolean hobby(String hobby) {
		
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[a-zA-Z\\d\\s]{3,100}$";
		CharSequence inputStr = hobby;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}
	
public boolean brandname(String brandname) {
		
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[a-zA-Z\\d\\s]{2,30}$";
		CharSequence inputStr = brandname;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}
public boolean memberid(String hobby) {
		
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[a-zA-Z\\d\\s]{3,10}$";
		CharSequence inputStr = hobby;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}


	/* validation for reason to join the club with length 3-500 alphanumeric chars */
	 
	public boolean joiningReason(String reason) {
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[a-zA-Z\\d\\s]{3,500}$";
		CharSequence inputStr = reason;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}
	  
	
	/* validation for relationship type with 3-50 length of char*/
	 
	public boolean relationship(String relation) {
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[a-zA-Z\\s]{3,50}$";  
		CharSequence inputStr = relation;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid; 
	}


	/* validation for receipt number with length 3-10 alphanumeric chars */
	 
	public boolean receiptNumber(String receipt) {
		
		boolean isValid = false;  
		  
		//Initialize reg ex for email.  
		String expression = "^[a-zA-Z\\d]{3,10}$";
		CharSequence inputStr = receipt;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
	}


	public boolean pincode(String postalcode) {
		boolean isValid = false;  
		String expression = "^[0-9]{5,5}$";    
		CharSequence inputStr = postalcode;  
		Pattern pattern = Pattern.compile(expression,Pattern.CANON_EQ);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  

	}

}
