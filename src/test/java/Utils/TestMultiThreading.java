package Utils;

/**
 * Created by borisgurtovyy on 10/16/17.
 */
public class TestMultiThreading implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000000000;i ++){
            System.out.println("My Thread");
        }
    }
}
