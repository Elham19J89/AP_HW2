import menu.Beverage;
import menu.Food;
import menu.MenuItem;
import order.Order;
import person.Customer;
import person.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        //سه تا کارمند
        List<Employee> employees = new ArrayList<>();

        Employee e1 = new Employee("Monica" , "569847" , "Chef" , 20000000 , 170);
        Employee e2 = new Employee("lolo" , "56552" , "accountant" , 20000000 , 160);
        Employee e3 = new Employee("Penny" , "568632" , "Waitress" , 15000000 , 170);

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        //5تا مشتری
        List<Customer> customers = new ArrayList<>();

        Customer c1 = new Customer("Lorelai" , "998562");
        Customer c2 = new Customer("Rory" , "998563");
        Customer c3 = new Customer("Sookie" , "998565");
        Customer c4 = new Customer("Lane" , "9985689");
        Customer c5 = new Customer("Paris" , "9985751");

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);

        //منو
        List<MenuItem> menu = new ArrayList<>();

        Food f1 = new Food(1 , "Fettuccine Alfredo Pasta" , 400000 , "food" , Food.SpiceLevel.medium , 40);
        Food f2 = new Food(2 , "Spaghetti with hot-dog" , 250000 , "food" , Food.SpiceLevel.medium , 40);
        Food f3 = new Food(3 , "Lasagna" , 400000 , "food" , Food.SpiceLevel.medium , 40);
        Food f4 = new Food(1 , "Pizza1" , 400000 , "food" , Food.SpiceLevel.mild , 40);
        Food f5 = new Food(1 , "Pizza2" , 400000 , "food" , Food.SpiceLevel.medium , 40);
        Food f6 = new Food(1 , "Pizza3" , 400000 , "food" , Food.SpiceLevel.spicy , 40);

        menu.add(f1);
        menu.add(f2);
        menu.add(f3);
        menu.add(f4);
        menu.add(f5);
        menu.add(f6);


        Beverage b1 = new Beverage(1 , "tea" , 20000 , "Beverage" , Beverage.Size.large , Beverage.Temperature.hot);
        Beverage b2 = new Beverage(2 , "tea" , 18000 , "Beverage" , Beverage.Size.medium , Beverage.Temperature.hot);
        Beverage b3 = new Beverage(3 , "coffee" , 70000 , "Beverage" , Beverage.Size.large , Beverage.Temperature.hot);
        Beverage b4 = new Beverage(4 , "coffee" , 50000 , "Beverage" , Beverage.Size.medium , Beverage.Temperature.hot);
        Beverage b5 = new Beverage(5 , "coffee" , 30000 , "Beverage" , Beverage.Size.small , Beverage.Temperature.hot);
        Beverage b6 = new Beverage(6 , "iced-coffee" , 75000 , "Beverage" , Beverage.Size.large , Beverage.Temperature.cold);
        Beverage b7 = new Beverage(7 , "soda" , 60000 , "Beverage" , Beverage.Size.large , Beverage.Temperature.cold);

        menu.add(b1);
        menu.add(b2);
        menu.add(b3);
        menu.add(b4);
        menu.add(b5);
        menu.add(b6);
        menu.add(b7);

        //ثبت سفارش
        List<Order> orders = new ArrayList<>();

        Order o1 = new Order(c1);
        o1.addItem(f1);
        o1.addItem(f3);
        o1.addItem(f6);
        o1.calculateTotal();
        orders.add(o1);

        Order o2 = new Order(c2);
        o2.addItem(f4);
        o2.addItem(f3);
        o2.addItem(b6);
        o2.calculateTotal();
        orders.add(o2);

        Order o3 = new Order(c3);
        o3.addItem(f5);
        o3.addItem(b1);
        o3.addItem(b2);
        o3.calculateTotal();
        orders.add(o3);

        Order o4 = new Order(c4);
        o4.addItem(b3);
        o4.addItem(b4);
        o4.addItem(b5);
        o4.calculateTotal();
        orders.add(o4);

        Order o5 = new Order(c5);
        o5.addItem(f1);
        o5.addItem(b1);
        o5.addItem(b6);
        o5.calculateTotal();
        orders.add(o5);

        //محاسبه حقوق کارمندا

        for(Employee e : employees){
            System.out.println(e.getInfo());
            System.out.println("Calculated Salary: " + e.calculateSalary());
        }


        //وفادارترین مشتری
        Customer mostLoyal = customers.get(0);
        for(Customer c : customers){
            if(c.getLoyaltyPoints() > mostLoyal.getLoyaltyPoints()){
                mostLoyal = c;
            }
        }

        System.out.println("Most Loyal Customer: " + mostLoyal.getName());


        //خلاصه مشتری
        for(Customer c : customers){
            System.out.println(c.getInfo());
        }

        //خلاصه کارمند
        for(Employee e : employees){
            System.out.println(e.getInfo());
        }

        //خلاصه منو
        for(MenuItem i : menu){
            System.out.println(i.getDetails());
        }

    }
}
