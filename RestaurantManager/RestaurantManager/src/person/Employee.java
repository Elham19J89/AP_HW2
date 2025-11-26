package person;

public class Employee extends Person {

    private String employeeId;
    private String position;

    private static int theEmployeeId = 1;

    private double salary;

    private int hoursWorked;

    public Employee(String name , String phoneNumber , String position , double salary , int hoursWorked){
        super(name , phoneNumber);
        this.employeeId = newEmployeeId();
        this.position = position;
        this.salary = salary;
        this.hoursWorked = 0;

    }

    private static String newEmployeeId(){
        int id = theEmployeeId++;
        String idString = Integer.toString(id);
        while(idString.length() < 3){
            idString = "0" + idString;
        }
        return "E" + idString;
    }

    public void addHoursWorked(int hours){
        this.hoursWorked = this.hoursWorked + hours;
    }

    public double calculateSalary(){
        if(hoursWorked <= 160){
            return salary;
        }
        else {
            int overtime = hoursWorked - 160;
            double overtimePay = (overtime/160)*(salary*1.5);
            return salary + overtimePay;
        }

    }

    public String getEmployeeId(){
        return employeeId;
    }

    public int getHoursWorked(){
        return hoursWorked;
    }

    public String getPosition(){
        return position;
    }

    public double getSalary(){
        return salary;
    }

    @Override
    public String getInfo(){
        return "ID: " + employeeId + ", Name: " + getName() + ", Phone: " + getPhoneNumber() + ", Position: " + position + ", Hours Worked: " + hoursWorked;
    }

}
