
public class PrototypeDemoPattern {

	public static void main(String[] args) {

		// Handles routing makeCopy method calls to the
		// right subclasses of Animal
		CloneFactory cloneFactory = new CloneFactory();
		
		// Creates a new Sheep instance
		Sheep sheep = new Sheep();
		
		// Creates a clone of Sally and stores it in its own
		// memory location
		Sheep clonedSheep = (Sheep) cloneFactory.getClone(sheep);
		// These are exact copies of each other
		System.out.println(sheep);
		System.out.println(clonedSheep);
		System.out.println("Sheep HashCode: " + System.identityHashCode(System.identityHashCode(sheep)));
		System.out.println("Clone HashCode: " + System.identityHashCode(System.identityHashCode(clonedSheep)));
    }


}
