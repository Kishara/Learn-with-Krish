
public class Singleton {

	public static void main(String[] args) {

		SingleObject singleObject = SingleObject.getSingleObject();
		System.out.println(singleObject);
		
		SingleObject singleObject1 = SingleObject.getSingleObject();
		System.out.println(singleObject);

	}

}
