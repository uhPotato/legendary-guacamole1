package Utils;

import net.sf.cglib.core.Local;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by borisgurtovyy on 10/5/17.
 */
public class DateFactory {

    @Test
    public void getCurrentDay() {
        LocalDate today = LocalDate.now();
        System.out.println(String.valueOf(today.getDayOfWeek()));
    }

    private void currentDayPlusXDays(int days) {
        LocalDate today = LocalDate.now();
        LocalDate todayPlusDays = today.plus(days, ChronoUnit.DAYS);
        System.out.println(String.valueOf(todayPlusDays.getDayOfWeek()));
    }

    @Test
    public void testDaysPlusX() {
        currentDayPlusXDays(2);
    }

    public static String getActualDayOfMonth() {
        return String.valueOf(LocalDate.now().getDayOfMonth());
    }

    public static String getActualDayOfWeek() {
        return String.valueOf(LocalDate.now().getDayOfWeek());
    }

    public static String getActualMonth() {
        return String.valueOf(LocalDate.now().getMonth());
    }
}
