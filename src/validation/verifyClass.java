package validation;

public class verifyClass {
	
	public static void main(String[] a){
		
		FieldValidationInterface obj=new FieldValidationImplementedClass();
		String receipt="F100000J01";
		
		boolean bool=false;
		bool=obj.receiptNumber(receipt);
		System.out.println(bool);
		
	}

}




