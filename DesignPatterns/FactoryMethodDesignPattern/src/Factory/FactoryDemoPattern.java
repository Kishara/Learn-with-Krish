package Factory;

public class FactoryDemoPattern {

	public static void main(String[] args) {
	
		//create phonefactory object
		PhoneFactory phoneFactory = new PhoneFactory();
		
		//calling getPhone method at phonefactory class
		Phone phone = phoneFactory.getPhone("Expensive");
		phone.showSpec();
	}

}
