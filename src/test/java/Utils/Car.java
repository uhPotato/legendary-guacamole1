package Utils;

/**
 * Created by borisgurtovyy on 10/12/17.
 */
public class Car implements CarInterface {

    private String color;
    private int price;

    public Car(String color, int price) {
        this.color = color;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public void drive() {
        System.out.println("I Am Driving!!!");
    }

    @Override
    public void brake() {
        System.out.println("I stopped!!!");
    }
}
