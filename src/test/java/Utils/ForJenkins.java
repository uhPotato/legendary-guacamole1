package Utils;

import org.testng.annotations.*;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Utils.AppiumServer.testStaticImport;

public class ForJenkins {

    @Test
    public void testRegEx(){
        String line = "Hello World, Ultimate2 Bootcamp2!   12.123.3.9:8080";

        String stringPattern = "([A-Z])([a-z]+\\d)";           // \d -> any digit
        String stringPattern2 = "\\d{1}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}:\\d{1,4}";

        Pattern pattern  = Pattern.compile(stringPattern2);

        Matcher m = pattern.matcher(line);

        while(m.find()){
            System.out.println("FOUND VALUE: "+ m.group(0));
            //System.out.println("FOUND VALUE: "+ m.group(1));
            //System.out.println("FOUND VALUE: "+ m.group(2));
        }

        Color color = Color.BLUE;

        int i = 123;
        String s = "Hello World!";
        double doub = 2.01234;

        //System.out.printf("Hi, EVERYONE! I AM SHOWING FORMATS HERE. %d some other text %s Some other text %f%n",i, s, doub);

        //System.out.println(testStaticImport());

    }

    enum Color {
        RED, BLUE, GREEN;
    }

}
