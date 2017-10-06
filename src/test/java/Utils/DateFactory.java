package Utils;

import net.sf.cglib.core.Local;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by borisgurtovyy on 10/5/17.
 */
public class DateFactory {

    @Test
    public void getCurrentDay(){
        LocalDate today = LocalDate.now();
        System.out.println(String.valueOf(today.getDayOfWeek()));
    }

    public void currentDayPlusXDays(int days){
        LocalDate today = LocalDate.now();
        LocalDate todayPlusDays = today.plus(days, ChronoUnit.DAYS);
        System.out.println(String.valueOf(todayPlusDays.getDayOfWeek()));
    }

    @Test
    public void testDaysPlusX(){
        currentDayPlusXDays(2);
    }

}
