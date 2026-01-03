package resturant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Restaurant {

    // ===== Encapsulation =====
    private String location;
    private String title;
    private float quantity;



    // ===== Data pool =====
    private final List<MenuItem> menu = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();




    // ===== Getters / Setters =====
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        if (location == null) {
            throw new IllegalArgumentException("location is empty");
        }
        this.location = location;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("title is empty");
        }
        this.title = title;
    }

    public float getQuantity() {
        return quantity;
    }
    public void setQuantity(float quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity must be >= 0");
        }
        this.quantity = quantity;
    }




    // ===== Abstraction: work with pools only via methods =====
    public void addMenuItem(MenuItem item) {
        if (item == null)throw new IllegalArgumentException("menu item is null");
        menu.add(item);
    }

    public void addOrder(Order order) {
        if (order == null) throw new IllegalArgumentException("order is null");
        orders.add(order);
    }

    // ===== Searching =====
    public MenuItem findMenuItemByName(String name) {
        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    // ===== Filtering =====
    public List<MenuItem> filterMenuByMaxFinalPrice(int maxPrice) {
        List<MenuItem> result = new ArrayList<>();
        for (MenuItem item : menu) {
            if (item.getFinalPrice() <= maxPrice) {
                result.add(item);
            }
        }
        return result;
    }

    // ===== Sorting =====
    public void sortMenuByFinalPriceAsc() {
        menu.sort(Comparator.comparingInt(MenuItem::getFinalPrice));
    }

    // ===== Safe access =====
    public List<MenuItem> getMenuCopy() {
        return new ArrayList<>(menu);
    }

    public void info() {
        System.out.println("Location: " + location);
        System.out.println("Title: " + title);
        System.out.println("Quantity of restaurant: " + quantity);
        System.out.println("Menu size: " + menu.size());
        System.out.println("Orders size: " + orders.size() + "\n");
    }

    public void compare_restaurant(Restaurant that) {
        if (this.quantity < that.quantity) {
            System.out.println(this + " quantity less than " + that + " quantity");
        } else if (this.quantity > that.quantity) {
            System.out.println(this + " quantity more than " + that + " quantity");
        } else {
            System.out.println("Quantities are the same\n");
        }
    }

    // ===== Overrides =====
    @Override
    public String toString() {
        return title + " (" + location + "), qty=" + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(location, that.location)
                && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, title);
    }
}
