package PageObjects;

import ScreenFactories.MoviesScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import java.util.List;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class MoviesScreen extends BaseTest {

    public MoviesScreenFactory moviesScreenFactory = new MoviesScreenFactory();

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
        return String.valueOf(driver.findElementByXPath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='3']").getText());
    }

    public static String getDisplayedDayOfWeek() {
        return String.valueOf(driver.findElementByXPath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']").getText());
    }

    public static String getDisplayedMonth() {
        return String.valueOf(driver.findElementByXPath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']").getText());
    }
}

