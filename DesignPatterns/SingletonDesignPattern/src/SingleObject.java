
public class SingleObject {

	private static volatile SingleObject singleObject;
	
	private SingleObject() {
		if(singleObject !=null) {
			throw new RuntimeException("Please use getSingleObject Method");
		}
	}

	public static SingleObject getSingleObject() {
		
		if(singleObject==null) {
			
			synchronized (SingleObject.class) {
				if(singleObject == null) {
					singleObject=new SingleObject();
				}
			}
			
		}
		return singleObject;
	}
	
	
}
