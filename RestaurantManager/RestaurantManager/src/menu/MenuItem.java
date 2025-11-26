package menu;
public abstract class MenuItem {
    private int itemId;
    private String name;
    private int price;
    private String category;

    private static int theItemId = 1;

    public MenuItem(int itemId ,String name , int price , String category){
        this.itemId = theItemId++;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getItemId(){
        return itemId;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public String setCategory(String category){
        this.category = category;
        return category;
    }

    public String getCategory(){
        return category;
    }




    public abstract String getDetails();
}
