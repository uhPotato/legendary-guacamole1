package PageObjects;

import ScreenFactories.MoviesScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import java.util.List;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class MoviesScreen extends BaseTest {

    public static MoviesScreenFactory moviesScreenFactory = new MoviesScreenFactory();

    public MoviesScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), moviesScreenFactory);
        waitForElementToLoad(moviesScreenFactory.profileButton);
    }

    public ProfileScreen clickOnProfileButton() {
        moviesScreenFactory.profileButton.click();
        return new ProfileScreen();
    }

    public static List<MobileElement> getListOfMainNavTabs() {
        return (List<MobileElement>) driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
    }

    public static String getDisplayedDayOfMonth() {
        String asd1 = moviesScreenFactory.displayedDayOfMonth.getText();
        return asd1;
    }

    public static String getDisplayedDayOfWeek() {
        String asd2 =  moviesScreenFactory.displayedDayOfWeek.getText();
        return asd2;
    }

    public static String getDisplayedMonth() {
        String asd3 =  moviesScreenFactory.displayedMonth.getText();
        return asd3;
    }
}

