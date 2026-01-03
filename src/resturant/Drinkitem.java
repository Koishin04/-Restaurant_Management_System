package resturant;

public class Drinkitem extends MenuItem {

    private boolean large; // большой объем

    public Drinkitem(int id, String name, int basePrice, boolean large) {
        super(id, name, basePrice);
        this.large = large;
    }

    public boolean isLarge() {
        return large;
    }

    public void setLarge(boolean large) {
        this.large = large;
    }

    // ✅ POLYMORPHISM
    @Override
    public int getFinalPrice() {
        // большой напиток +15%
        if (!large) {
            return getBasePrice();
        }
        return getBasePrice() + (getBasePrice() * 15 / 100);
    }
}
