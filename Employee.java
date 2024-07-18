class Employee {
    private int empNo;
    private String name;
    private double payRatePerHour;
    private PaySheet[] paySheet = new PaySheet[4];
    private double totalPayment;
    
    public Employee(int empNo, String name, double payRatePerHour, PaySheet[] paySheet) {
    	this.empNo = empNo;
    	this.name = name;
        this.payRatePerHour = payRatePerHour;
        this.paySheet = paySheet;
        this.totalPayment = 0;
    }
    
    public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPayRatePerHour() {
		return payRatePerHour;
	}

	public void setPayRatePerHour(double payRatePerHour) {
		this.payRatePerHour = payRatePerHour;
	}

	public PaySheet[] getPaySheet() {
		return paySheet;
	}

	public void setPaySheet(PaySheet[] paySheet) {
		this.paySheet = paySheet;
	}
	
	public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment() {
		int totalPayment = 0;
		for (int i = 0; i < paySheet.length; i++) {
			totalPayment += payRatePerHour * paySheet[i].getWorkDays();
		}
		
		this.totalPayment = totalPayment;
	}
}