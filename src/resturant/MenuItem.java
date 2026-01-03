package resturant;

import java.util.Objects;

public abstract class MenuItem {

    // ===== Encapsulation =====
    private final int id;
    private String name;
    private int basePrice;

    public MenuItem(int id, String name, int basePrice) {
        if (id <= 0) throw new IllegalArgumentException("id must be > 0");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is empty");
        if (basePrice <= 0) throw new IllegalArgumentException("price must be > 0");

        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
    }

    // ===== Getters / Setters =====
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("name is empty");
        this.name = name;
    }

    public int getBasePrice() {
        return basePrice;
    }
    public void setBasePrice(int basePrice) {
        if (basePrice <= 0)
            throw new IllegalArgumentException("price must be > 0");
        this.basePrice = basePrice;
    }

    // ===== Abstraction + Polymorphism =====
    public abstract int getFinalPrice();

    // ===== Overrides =====
    @Override
    public String toString() {
        return "MenuItem{id=" + id +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", finalPrice=" + getFinalPrice() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem)) return false;
        MenuItem menuItem = (MenuItem) o;
        return id == menuItem.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
