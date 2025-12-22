package resturant;

public class Order {
    private int place;
    private int check;


    public Order(int place, int check) {
        this.place = place;
        this.check = check;
    }


    public int getPlace() {
        return place;
    }
    public void setPlace(int place) {
        this.place = place;
    }


    public int getCheck() {
        return check;
    }
    public void setCheck(int check) {
        this.check = check;

    }


    public void discount() {
        if (check >= 10000) {
            int oldCheck = check;
            check = check - check / 10;

            System.out.println(
                    "Order{place - " + place + ", check - " + oldCheck + "} with discount " + check
            );
        } else {
            System.out.println(
                    "Order{place - " + place + ", check - " + check + "} no discount"
            );
        }
    }
}
