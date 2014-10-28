package validation;

public interface FieldValidationInterface {
	
	public boolean name(String name);
	
	public boolean categoryname(String categoryname) ;
	
	public boolean qualification(String qualification);
	
	public boolean address(String address);
	public boolean productcode(String pcode);
	public boolean mobile(String mobile);
	
	public boolean landline(String landphone);
	
	public boolean email(String mailid);
	
	public boolean bloodGroup(String blood);
	
	public boolean profession(String work);
	
	public boolean annualIncome(String income);
	
	public boolean age(String age);
	
	public boolean hobby(String hobby);
	public boolean memberid(String hobby);
	
	public boolean joiningReason(String reason);
	
	public boolean relationship(String relation);
	
	public boolean receiptNumber(String receipt);
	public boolean costPrice(String cost);
	public boolean brandname(String cost);
	
	
	public boolean quantity(String cost);

	public boolean pincode(String postalcode);

}
