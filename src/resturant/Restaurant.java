package resturant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Restaurant {

    // Encapsulation: private fields
    private String location;
    private String title;
    private float quantity;

    // Data pool (collections)
    private final List<MenuItem> menu = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    // ===== Getters / Setters (Encapsulation) =====
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        if (location == null)
            throw new IllegalArgumentException("location is empty");
        this.location = location;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if (title == null)
            throw new IllegalArgumentException("title is empty");
        this.title = title;
    }

    public float getQuantity() {
        return quantity;
    }
    public void setQuantity(float quantity) {
        if (quantity < 0)
            throw new IllegalArgumentException("quantity must be >= 0");
        this.quantity = quantity;
    }

    // ===== Data Abstraction: work with pools only through methods =====
    public void addMenuItem(MenuItem item) {
        if (item == null) throw new IllegalArgumentException("menu item is null");
        menu.add(item);
    }

    public void addOrder(Order order) {
        if (order == null) throw new IllegalArgumentException("order is null");
        orders.add(order);
    }

    // Searching: find menu item by name
    public MenuItem findMenuItemByName(String name) {
        if (name == null) return null;
        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    // Filtering: menu items with price <= maxPrice
    public List<MenuItem> filterMenuByMaxPrice(int maxPrice) {
        List<MenuItem> result = new ArrayList<>();
        for (MenuItem item : menu) {
            if (item.getBasePrice() <= maxPrice) {
                result.add(item);
            }
        }
        return result;
    }

    // Sorting: sort menu by price ASC
    public void sortMenuByPriceAsc() {
        menu.sort(Comparator.comparingInt(MenuItem::getBasePrice));
    }

    //Abstraction: return copies, not original lists
    public List<MenuItem> getMenuCopy() {
        return new ArrayList<>(menu);
    }

    public List<Order> getOrdersCopy() {
        return new ArrayList<>(orders);
    }

    // ===== Your old methods kept (minimal changes) =====
    public void info() {
        System.out.println("Location: " + this.location);
        System.out.println("Title: " + this.title);
        System.out.println("Quantity of restaurant: " + this.quantity);
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
        return Objects.equals(location, that.location) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, title);
    }
}
