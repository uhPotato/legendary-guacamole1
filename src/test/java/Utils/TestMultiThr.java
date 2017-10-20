package Utils;

import org.testng.annotations.Test;

/**
 * Created by borisgurtovyy on 10/16/17.
 */
public class TestMultiThr {


    @Test
    public void testMultiThreading(){
        TestMultiThreading testMultiThreading = new TestMultiThreading();
        Thread thread = new Thread(testMultiThreading);
        thread.start();
        for (int i = 0; i < 1000000000;i ++){
            System.out.println("My Main Thread");
        }
    }

}
