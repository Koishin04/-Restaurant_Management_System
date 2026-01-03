package resturant;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ===== Restaurants =====
        Restaurant r1 = new Restaurant();
        r1.setLocation("Astana");
        r1.setTitle("Bahandi");
        r1.setQuantity(8);

        Restaurant r2 = new Restaurant();
        r2.setLocation("Aktobe");
        r2.setTitle("Pastamiya");
        r2.setQuantity(9);

        // ===== Menu items (Inheritance + Polymorphism) =====
        MenuItem pizza = new FoodItem(1, "Pizza Margorita", 4000, 1);
        MenuItem burger = new FoodItem(2, "Cheese Burger", 5000, 3);
        MenuItem cola = new Drinkitem(3, "Cola", 1200, true);

        // ===== Orders =====
        Order order1 = new Order(101, 5);
        order1.addItem(pizza);
        order1.addItem(cola);

        Order order2 = new Order(102, 4);
        order2.addItem(burger);
        order2.addItem(burger);

        // ===== Data pool =====
        r1.addMenuItem(pizza);
        r1.addMenuItem(burger);
        r1.addMenuItem(cola);

        r1.addOrder(order1);
        r1.addOrder(order2);

        // ===== Info =====
        System.out.println("--- restaurant info ---\n");
        r1.info();
        r2.info();

        // ===== toString =====
        System.out.println("--- menu ---");
        System.out.println(r1.getMenuCopy());

        // ===== Discount =====
        System.out.println("\n--- discount ---");
        order1.discount();
        order2.discount();

        // ===== Searching =====
        System.out.println("\n--- searching ---");
        System.out.println("Find Cola: " + r1.findMenuItemByName("Cola"));

        // ===== Filtering =====
        System.out.println("\n--- filtering ---");
        List<MenuItem> cheapMenu = r1.filterMenuByMaxFinalPrice(4500);
        System.out.println("Final price <= 4500: " + cheapMenu);

        // ===== Sorting =====
        System.out.println("\n--- sorting ---");
        r1.sortMenuByFinalPriceAsc();
        System.out.println("Sorted menu: " + r1.getMenuCopy());

        // ===== Compare restaurants =====
        System.out.println("\n--- compare restaurants ---");
        r1.compare_restaurant(r2);

        // ===== equals & hashCode =====
        System.out.println("\n--- equals & hashCode ---");
        Restaurant r3 = new Restaurant();
        r3.setLocation("Astana");
        r3.setTitle("Bahandi");
        r3.setQuantity(100);

        System.out.println("r1.equals(r3): " + r1.equals(r3));
        System.out.println("r1.hashCode(): " + r1.hashCode());
        System.out.println("r3.hashCode(): " + r3.hashCode());
    }
}
