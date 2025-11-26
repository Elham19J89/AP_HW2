package order;

import menu.MenuItem;
import person.Customer;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static int theOrderId = 1;

    private int orderId;
    private Customer customer;
    private List<MenuItem> items;
    private double totalAmount;

    public Order(Customer customer , List<MenuItem> items){
        this.orderId = theOrderId++;
        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.totalAmount = 0;
    }

    public Order(Customer customer){
        this(customer , (List<MenuItem>)null);
    }



    public int getOrderId(){
        return orderId;
    }

    public Customer getCustomer(){
        return customer;
    }

    public List<MenuItem> getItems(){
        return new ArrayList<>(items);
    }

    public double getTotalAmount(){
        return totalAmount;
    }


    public void addItem(MenuItem item){
        items.add(item);
    }



    public double calculateTotal(){
        double sum = 0;
        for(int i = 0 ; i < items.size() ; i++){
            sum = sum + items.get(i).getPrice();

        }
        if(customer != null){
            customer.addLoyaltyPoints(sum);
        }

        double discount = 0.0;

        if(customer != null){
            discount = customer.getDiscount();
        }

        double discountAmount = sum*discount;
        double total = sum - discountAmount;

        this.totalAmount = total;
        return this.totalAmount;
    }

    public String getOrderSummary(){
        return "Order ID: " + orderId + ", Customer: " + customer.getName() + ", Total Amount: " + totalAmount + ", Items: " + items;
    }


}
