package person;

public class Customer extends Person {
    private String customerId;
    private  int loyaltyPoints;

    private static int theCustomerId = 1;

    public Customer(String name , String phoneNumber){
        super(name , phoneNumber);
        this.customerId = newCustomerId();
        this.loyaltyPoints = 0;
    }
    private static String newCustomerId(){
        int id = theCustomerId++;
        String IdString = Integer.toString(id);
        while (IdString.length() < 3){
            IdString = "0" + IdString;
        }
        return "C" + IdString;
    }



    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public String getCustomerId(){
        return customerId;
    }


    public void setLoyaltyPoints(int loyaltyPoints){
        this.loyaltyPoints = loyaltyPoints;
    }

    public void addLoyaltyPoints(double Total){
        if(Total > 1000000){
            loyaltyPoints = loyaltyPoints + 2;
        }
        else if (Total > 500000) {
            loyaltyPoints = loyaltyPoints + 1;
        }
    }

    public double getDiscount(){
        if (loyaltyPoints > 5){
            return 0.10;
        }
        else if(loyaltyPoints > 3){
            return 0.05;
        }
        return 0.0;
    }

    @Override
    public String getInfo(){
        return "ID :" + customerId + ", Name: " + getName() + ", Phone: " + getPhoneNumber() + ", Loyalty Points: " + loyaltyPoints;
    }

}
