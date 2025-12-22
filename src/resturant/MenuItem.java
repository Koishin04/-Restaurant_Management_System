package resturant;

public class MenuItem {

    private String name;
    private int price;


    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;

    }
    public void setName(String name) {
        this.name = name;

    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public void Menu_info(){
        System.out.println("Menu Info: " + name + " - " + price + "Tg" + "\n");
    }
}
