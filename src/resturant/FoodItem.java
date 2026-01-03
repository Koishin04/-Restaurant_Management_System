package resturant;

public class FoodItem extends MenuItem {

    private int spicinessLevel; // 0..5

    public FoodItem(int id, String name, int basePrice, int spicinessLevel) {
        super(id, name, basePrice);
        setSpicinessLevel(spicinessLevel);
    }

    public int getSpicinessLevel() {
        return spicinessLevel;
    }

    public void setSpicinessLevel(int spicinessLevel) {
        if (spicinessLevel < 0) spicinessLevel = 0;
        if (spicinessLevel > 5) spicinessLevel = 5;
        this.spicinessLevel = spicinessLevel;
    }

    // ✅ POLYMORPHISM
    @Override
    public int getFinalPrice() {
        // +100 тг за каждый уровень остроты
        return getBasePrice() + spicinessLevel * 100;
    }
}
