package menu;

public class Food extends MenuItem {
    public enum SpiceLevel{
        mild ,
        medium ,
        spicy
    }

    private SpiceLevel spiceLevel;

    private int preparationTime;

    public Food(int itemId , String name , int price , String category , SpiceLevel spiceLevel , int preparationTime){
        super(itemId , name , price , "food");
        this.spiceLevel = spiceLevel;
        this.preparationTime = preparationTime;
    }

    public SpiceLevel getSpiceLevel(){
        return spiceLevel;
    }

    public void setSpiceLevel(SpiceLevel spiceLevel){
        this.spiceLevel = spiceLevel;
    }


    public int getPreparationTime(){
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime){
        this.preparationTime = preparationTime;
    }


    @Override
    public String getDetails(){
        return "ID: " + getItemId() + ", Name: " + getName() + ", Price: " + getPrice() + ", Category: " + getCategory() + ", Spice: " + spiceLevel + ", Preparation Time: " + preparationTime + "min";
    }
}
