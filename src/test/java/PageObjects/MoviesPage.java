package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

/**
 * Created by borisgurtovyy on 10/2/17.
 */
public class MoviesPage extends BaseTest{

    private MobileElement profileButton;


    public MoviesPage() {
        profileButton = (MobileElement) driver.findElementById("btnHamburger");
        waitForElementToLoad(profileButton);
    }


    public ProfilePage clickOnProfileButton() {
        profileButton.click();
        return new ProfilePage();
    }

}
