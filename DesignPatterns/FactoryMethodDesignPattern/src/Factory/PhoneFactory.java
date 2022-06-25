package Factory;

public class PhoneFactory {
	

	public Phone getPhone(String shapeType) {
		if(shapeType == null) {
			return null;
		}
		//checking the inputs
		if(shapeType.equalsIgnoreCase("Cheap")) {
			//returning huawei object
			return new Huawei();
		} else if(shapeType.equalsIgnoreCase("Middle")) {
			//returning samsung object
			return new Samsung();
		} else if(shapeType.equalsIgnoreCase("Expensive")) {
			//returning iphone object
			return new Iphone();
		}
		return null;
	}
}
