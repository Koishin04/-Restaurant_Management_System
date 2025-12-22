package resturant;


public class Main {

    public static void main(String[] args) {
        Restaurant  r1 = new Restaurant("Astana", "Bahandi", 8);
        Restaurant r2 = new Restaurant("Aktobe", "Pastamiya", 9);

        MenuItem first_menu = new MenuItem("Pizza Margorita" , 4000);
        MenuItem second_menu = new MenuItem("Cheese Burger" , 5000);


        Order first_order = new Order(5,8000);
        Order second_order = new Order(4,12000);


        System.out.println("---information about restaurant ---" + "\n");

        r1.info();
        r2.info();

        first_menu.Menu_info();
        second_menu.Menu_info();

        first_order.discount();
        second_order.discount();

        System.out.println("--- Copair restaurant's qualities ---" + "\n");
        r1.compare_restaurant(r2);

    }
}
