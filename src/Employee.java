public class Employee extends Person {
    private String position;
    private double salary;
    private String employeeID;
    private String department;
    private String shift;
    private String hireDate;

    public Employee() {}

    public Employee(String name, int age, String gender, String contactNumber, String email, String address, String nationality, String idNumber, String position, double salary, String employeeID, String department, String shift, String hireDate) {
        super(name, age, gender, contactNumber, email, address, nationality, idNumber);
        this.position = position;
        this.salary = salary;
        this.employeeID = employeeID;
        this.department = department;
        this.shift = shift;
        this.hireDate = hireDate;
    }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public String getEmployeeID() { return employeeID; }
    public void setEmployeeID(String employeeID) { this.employeeID = employeeID; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
    public String getHireDate() { return hireDate; }
    public void setHireDate(String hireDate) { this.hireDate = hireDate; }
} 