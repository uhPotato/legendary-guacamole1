package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import java.util.List;

public class MoviesScreen extends BaseTest {

    private MobileElement profileButton;

    public MoviesScreen() {
        profileButton = (MobileElement) driver.findElementById("btnHamburger");
        waitForElementToLoad(profileButton);
    }

    public ProfileScreen clickOnProfileButton() {
        profileButton.click();
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

