//abstract class declaration
abstract class Employee {
	int empId;
	String empName;
	int total_leaves;
	double total_salary;

	// constructor
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	// methods declaration
	abstract void calculate_balance_leaves();

	abstract boolean avail_leave(int no_of_leaves, char type_of_leave);

	abstract void calculate_salary();

}

// class permanentemp which extends employee class
class PermanentEmp extends Employee {
	// variable declaration
	int paid_leave, sick_leave, casual_leave, balance_leave, leave_taken,
			total_leave_entitlement, leave_adjusted, avail_leaves;
	double basic_salary, hra, pf, total_salary;

	// parameterised constructor
	public PermanentEmp(double pf, double hra, double basic_salary,
			String empName, int avail_leaves, int empId, int paid_leave,
			int sick_leave, int casual_leave, int total_leave_entitlement,
			int leave_adjusted) {
		this.empName = empName;
		this.empId = empId;
		this.paid_leave = paid_leave;
		this.sick_leave = sick_leave;
		this.casual_leave = casual_leave;
		this.total_leave_entitlement = total_leave_entitlement;
		this.leave_adjusted = leave_adjusted;
		this.basic_salary = basic_salary;
		this.avail_leaves = avail_leaves;
		this.pf = pf;
		this.hra = hra;
	}

	@Override
	// here we calculate balance leaves
	void calculate_balance_leaves() {
		// TODO Auto-generated method stub
		this.leave_taken = this.sick_leave + this.casual_leave
				+ this.paid_leave;
		this.balance_leave = this.total_leave_entitlement - this.leave_taken
				+ this.leave_adjusted;

	}

	@Override
	// here we calculate available leaves
	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		// TODO Auto-generated method stub

		this.avail_leaves = this.total_leave_entitlement - this.balance_leave;
		if (this.balance_leave < this.total_leave_entitlement) {
			System.out.println("leaves are available.");
		} else {
			System.out.println("leaves are not available.");
		}

		return false;
	}

	@Override
	// for calculate salary
	void calculate_salary() {
		// TODO Auto-generated method stub
		this.pf = basic_salary * 0.12;
		// System.out.println(this.pf);
		this.hra = basic_salary * 0.5;
		this.total_salary = this.basic_salary + this.hra - this.pf;

		System.out.println("Details of Permanent employee :" + "\nName :"
				+ this.empName + " " + "\nEmployee ID :" + this.empId);
		System.out.println("Salary of the Permanent employee is :"
				+ "\nbasic salary :" + this.basic_salary + " \ntotal salary :"
				+ this.total_salary);

	}

	void print_leave_details() {

		System.out.println("Leaves details of Permanent employee :"
				+ "\nName :" + this.empName + " " + "\nEmployee ID :"
				+ this.empId);
		System.out.println("Total leaves are :" + this.total_leave_entitlement);
		System.out.println("Total leaves are taken :" + this.leave_taken);
		System.out.println("balance leaves are :" + this.balance_leave);

		System.out.println("sick leaves are :" + this.sick_leave);
		System.out.println("paid leaves are :" + this.paid_leave);
		System.out.println("casual leaves are :" + this.casual_leave);
	}

}

// another class temporary employee which extends employee
class TemporaryEmp extends Employee {

	int paid_leave, sick_leave, casual_leave, balance_leave, leave_taken,
			total_leave_entitlement, leave_adjusted;
	double basic_salary, hra, pf, total_salary;
	int avail_leaves;

	// constructor
	public TemporaryEmp(double pf, double hra, double basic_salary,
			String empName, int avail_leaves, int empId, int paid_leave,
			int sick_leave, int casual_leave, int total_leave_entitlement,
			int leave_adjusted) {
		this.empName = empName;
		this.empId = empId;
		this.paid_leave = paid_leave;
		this.sick_leave = sick_leave;
		this.casual_leave = casual_leave;
		this.total_leave_entitlement = total_leave_entitlement;
		this.leave_adjusted = leave_adjusted;

		this.basic_salary = basic_salary;
		this.avail_leaves = avail_leaves;
		this.pf = pf;
		this.hra = hra;
	}

	@Override
	// method to calculate balance leaves
	void calculate_balance_leaves() {
		// TODO Auto-generated method stub
		this.leave_taken = this.sick_leave + this.casual_leave
				+ this.paid_leave;
		this.balance_leave = this.total_leave_entitlement - this.leave_taken
				+ this.leave_adjusted;
	}

	@Override
	// method to calculate available leaves
	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		// TODO Auto-generated method stub

		this.avail_leaves = this.total_leave_entitlement - this.balance_leave;
		if (this.balance_leave < this.total_leave_entitlement) {
			System.out.println("leaves are available .");
		} else {
			System.out.println("leaves are not available.");
		}

		return false;
	}

	@Override
	// calculate salary
	void calculate_salary() {
		// TODO Auto-generated method stub
		this.pf = basic_salary * 0.12;

		this.hra = basic_salary * 0.5;
		this.total_salary = this.basic_salary + this.hra - this.pf;
		System.out.println("Details of Temporary employee :\n" + "Name :"
				+ this.empName + " " + "\nEmployee ID :" + this.empId);
		System.out.println("Salary of the Temporary employee is :"
				+ "\nbasic salary :" + this.basic_salary + " \ntotal salary :"
				+ this.total_salary);
	}

	void print_leave_details() {
		System.out.println("Leaves details of Temporary employee :"
				+ "\n  Name :" + this.empName + " " + "\nEmployee ID :"
				+ this.empId);
		System.out.println("Total leaves are :" + this.total_leave_entitlement);
		System.out.println("Total leaves are taken :" + this.leave_taken);
		System.out.println("balance leaves are :" + this.balance_leave);

		System.out.println("sick leaves are :" + this.sick_leave);
		System.out.println("paid leaves are :" + this.paid_leave);
		System.out.println("casual leaves are :" + this.casual_leave);
	}

}

// main class employeerecord
class EmployeeRecord {
	public static void main(String[] args) {
		PermanentEmp p = new PermanentEmp(0, 0, 27000.0, "Prashant", 0, 7, 2,
				1, 1, 10, 0);
		p.calculate_balance_leaves();
		p.calculate_salary();
		p.print_leave_details();
		p.avail_leave(0, 'p');

		System.out.println("***************************");
		TemporaryEmp t = new TemporaryEmp(0, 0, 20000.0, "Pratik", 0, 8, 2, 1,
				1, 10, 0);
		t.calculate_balance_leaves();
		t.calculate_salary();
		t.print_leave_details();
		t.avail_leave(0, 't');
	}

}