package Utils;


import org.testng.annotations.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Utils.AppiumServer.testStaticImport;

/**
 * Created by borisgurtovyy on 10/19/17.
 */

public class ForJenkins {


    @Test
    public void testRegEx() {
        String line = "Hello World, Ultimate Bootcamp2!  12.123.3.9:8080";

        String stringPattern = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";

        Pattern pattern = Pattern.compile(stringPattern);

        Matcher m = pattern.matcher(line);

        while(m.find()) {
            System.out.println("FOUND VALUE: " + m.group(0));
        }

        Color color = Color.GREEN;


        int i = 123;
        String  s = "Hello World!";
        double doub = 2.01234;


        System.out.format("Hi, Everyone! I am showing formats here. %n %d Some other text %s Some other Text%f%n", i, s, doub);

        System.out.println(testStaticImport());

    }

}

enum Color {
    RED, BLUE, GREEN
}
