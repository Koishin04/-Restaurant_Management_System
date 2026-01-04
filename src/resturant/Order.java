package resturant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private final int orderId;
    private int tableNumber;
    private final List<MenuItem> items = new ArrayList<>();
    private boolean paid;

    public Order(int orderId, int tableNumber) {
        if (orderId <= 0) throw new IllegalArgumentException("orderId must be > 0");
        if (tableNumber <= 0) throw new IllegalArgumentException("tableNumber must be > 0");
        this.orderId = orderId;
        this.tableNumber = tableNumber;
    }

    // ===== Encapsulation =====
    public int getOrderId() {
        return orderId;
    }

    public int getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(int tableNumber) {
        if (tableNumber <= 0)
            throw new IllegalArgumentException("tableNumber must be > 0");
        this.tableNumber = tableNumber;
    }

    public boolean isPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    // ===== Data pool inside Order =====
    public void addItem(MenuItem item) {
        if (item == null)
            throw new IllegalArgumentException("menu item is null");
        items.add(item);
    }

    public List<MenuItem> getItemsCopy() {
        return new ArrayList<>(items);
    }

    // ===== Polymorphism usage =====
    public int calculateTotal() {
        int sum = 0;
        for (MenuItem item : items) {
            sum += item.getFinalPrice(); // polymorphism here
        }
        return sum;
    }

    // ===== Discount logic =====
    public void discount() {
        int total = calculateTotal();
        if (total >= 10000) {
            int discounted = total - total / 10;
            System.out.println("Order{id=" + orderId + ", table=" + tableNumber +
                    ", total=" + total + "} with discount " + discounted);
        } else {
            System.out.println("Order{id=" + orderId + ", table=" + tableNumber +
                    ", total=" + total + "} no discount");
        }
    }

    // ===== Overrides =====
    @Override
    public String toString() {
        return "Order{id=" + orderId +
                ", table=" + tableNumber +
                ", items=" + items.size() +
                ", total=" + calculateTotal() +
                ", paid=" + paid + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return orderId;
    }

}
