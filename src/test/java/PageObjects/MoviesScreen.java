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

    public static String getMoviesScreenTabId() {
        return moviesScreenFactory.moviesScreenTab.getId();
    }

    public static String getDisplayedDayOfMonth() {
        return String.valueOf(moviesScreenFactory.displayedDayOfMonth.getText());
    }

    public static String getDisplayedDayOfWeek() {
        return String.valueOf(moviesScreenFactory.displayedDayOfWeek.getText());
    }

    public static String getDisplayedMonth() {
        return String.valueOf(moviesScreenFactory.displayedMonth.getText());
    }
}

