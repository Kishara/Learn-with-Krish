
public class AddEmployee {

	public static void main(String[] args) {
	
//		Employee emp = new Employee("Kishara",24,"kottawa",55536,"HRManager");
		Employee emp = new EmployeeBuilder().setName("Kishara").setAge(24).getEmployee();
		System.out.println(emp);
	}

}
