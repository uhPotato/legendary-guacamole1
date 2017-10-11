package Utils;

import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by borisgurtovyy on 10/5/17.
 */
public class Hints {


    //argument X means random variable will be in [0.....X)
    @Test
    public void getRandomInt() {
        Random random = new Random();
        System.out.println(random.nextInt(100));
    }

    // [100...200]
    @Test
    public void getRandomInt100to200() {
        Random random = new Random();
        int result = random.nextInt(101) + 100;
        System.out.println(result);
    }


    // substrings
    @Test
    public void showSubstr() {
        String str = "Hello, world";
        String newStr = str.substring(0, 5);
        System.out.println(newStr);
    }
}
