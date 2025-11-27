package person;

public class Employee extends Person {

    private String employeeId;
    private String position;

    private static int theEmployeeId = 1;

    private long salary;

    private int hoursWorked;

    public Employee(String name , String phoneNumber , String position , long salary , int hoursWorked){
        super(name , phoneNumber);
        this.employeeId = newEmployeeId();
        this.position = position;
        this.salary = salary;
        this.hoursWorked = hoursWorked;

    }

    private static String newEmployeeId(){
        int id = theEmployeeId++;
        String idString = Integer.toString(id);
        while(idString.length() < 3){
            idString = "0" + idString;
        }
        return "E" + idString;
    }





    public String getEmployeeId(){
        return employeeId;
    }

    public int getHoursWorked(){
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked){
        this.hoursWorked = hoursWorked;
    }

    public String getPosition(){
        return position;
    }

    public double getSalary(){
        return salary;
    }


    public void addHoursWorked(int hours){
        this.hoursWorked = this.hoursWorked + hours;
    }



    public long calculateSalary(){
        long base = this.salary;
        int hours = this.hoursWorked;
        if(hours <= 160){
            return base;
        }
        else {
            int overtime = hours - 160;
            long overtimePay = (long) ((overtime/160.0)*(base*1.5));
            return base + overtimePay;
        }

    }



    @Override
    public String getInfo(){
        return "ID: " + employeeId + ", Name: " + getName() + ", Phone: " + getPhoneNumber() + ", Position: " + position + ", Hours Worked: " + hoursWorked;
    }

}
