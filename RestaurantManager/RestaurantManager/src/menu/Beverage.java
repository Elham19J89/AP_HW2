package menu;

public class Beverage extends MenuItem {
    public enum Size {
        small,
        medium,
        large
    }

    public enum Temperature{
        hot,
        cold
    }

    private Size size;
    private Temperature temperature;

    public Beverage(int itemId , String name , int price , String category , Size size , Temperature temperature){
        super(itemId , name , price , "Beverage");
        this.size = size;
        this.temperature = temperature;

    }

    public Size getSize(){
        return size;
    }

    public Temperature getTemperature(){
        return temperature;
    }

    @Override
    public String getDetails(){
        return "ID: " + getItemId() + ", Name: " + getName() + ", Price: " + getPrice() + ", Category: " + getCategory() + ", Size: " + size + ", Temperature: " + temperature;
    }




}