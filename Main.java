public class Main {

	public static void main(String[] args) {		
		PaySheet[] employeePaySheet1 = new PaySheet[4];
		employeePaySheet1[0] = new PaySheet("1", new int[]{8, 8, 8, 8, 0});
		employeePaySheet1[1] = new PaySheet("2", new int[]{8, 8, 8, 8, 5});
		employeePaySheet1[2] = new PaySheet("3", new int[]{4, 4, 4, 0, 0});
		employeePaySheet1[3] = new PaySheet();
		
		PaySheet[] employeePaySheet2 = new PaySheet[4];
		employeePaySheet2[0] = new PaySheet("1", new int[]{8, 0, 0, 0, 0});
		employeePaySheet2[1] = new PaySheet("2", new int[]{5, 5, 5, 0, 0});
		employeePaySheet2[2] = new PaySheet();
		employeePaySheet2[3] = new PaySheet();
		
		Employee[] employees = new Employee[2];
		employees[0] = new Employee(1, "Employee 1", 100.0, employeePaySheet1);		
		employees[1] = new Employee(2, "Employee 2", 150.0, employeePaySheet2);
		
		printInfo(employees);
		
		System.out.println("");
		System.out.println("");
		
		printWarnedEmployees(employees);
		
		System.out.println("");
		System.out.println("");
		
		sortEmps(employees);
		
	}

	public static void printInfo(Employee[] employees) {
		System.out.println("1 - Print Info");
		System.out.println("Emp N0.\t Week \t Total Days/hours\tWeekly Payment");
		for (int i = 0; i < employees.length; i++) { 
			PaySheet[]  paySheet = employees[i].getPaySheet();
			for (int j = 0; j < paySheet.length; j++) {
				if (paySheet[j].getWeekEndingDate() != "") {					
					System.out.print(employees[i].getEmpNo() + "\t ");
					System.out.print(paySheet[j].getWeekEndingDate() + "\t ");
					System.out.print(paySheet[j].getWorkDays() + "/" + paySheet[j].getHours(i) + "\t\t\t");
					System.out.println((int) employees[i].getPayRatePerHour() * paySheet[j].getWorkDays());
				}
			}
		}
	}
	
	public static void printWarnedEmployees(Employee[] employees) {
		System.out.println("2 - Warned Employees :");
    	for (int i = 0; i < employees.length; i++) {  
    		PaySheet[]  paySheet = employees[i].getPaySheet();
    		int warned = 0;
    		for (int j = 0; j < paySheet.length; j++) { 
    			if (paySheet[j].getAbsences() >= 2) {    				
    				warned++;
    			} else {
    				warned = 0;
    			}
    			
    			if (warned >= 2) {
    				System.out.println(employees[i].getName()); 
    				break;
    			}
    		}
		}
    }

	public static void sortEmps(Employee[] employees) {	
		for (int i = 0; i < employees.length; i++) {
			employees[i].setTotalPayment();
		}
		
		for (int i = 0; i < employees.length; i++) {  
			for (int j = i + 1; j < employees.length; j++) {  
				if (employees[i].getTotalPayment() > employees[j].getTotalPayment()) {  
					Employee tmp = employees[i];  
					employees[i] = employees[j];  
					employees[j] = tmp;  
				}  
			}  
		}
		
		System.out.println("3 - Sort Emps :");
		System.out.printf("--------------------------------------------------%n");
		System.out.printf("| %-10s | %-15s | %2s |%n", "Employee NO.", "Name", "Total Payment");
		System.out.printf("--------------------------------------------------%n");

		for (int i = 0; i < employees.length; i++) {
			System.out.printf("| %-12s ", employees[i].getEmpNo());
			System.out.printf("| %-15s ", employees[i].getName());
			System.out.printf("| %13.1f |%n", employees[i].getTotalPayment());
		}
		
		System.out.printf("--------------------------------------------------%n");
	}
}
