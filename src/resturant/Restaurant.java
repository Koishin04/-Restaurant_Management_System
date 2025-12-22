package resturant;

public class Restaurant {

    private String location;
    private String title;
    private float quantity;

    public Restaurant(String location, String title ,  float quantity) {
        this.location = location;
        this.title = title;
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }


    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

public void info()
{
    System.out.println("Location: " + this.location);
    System.out.println("Average bill: " + this.title);
    System.out.println("Quantity of restaurant: " + this.quantity + "\n");
}

public void compare_restaurant(Restaurant that)
{
    if (this.quantity < that.quantity) {
        System.out.println( this + " quantity less than " + that + " quantity");
    }
    else if (this.quantity > that.quantity) {
        System.out.println( this + " quantity more than " + that + " quantity");
    }
    else
    {
        System.out.println("Quantities are the same" + "\n");
    }
}

    @Override
    public String toString() {
        return  title + " " +   quantity ;
    }

}

