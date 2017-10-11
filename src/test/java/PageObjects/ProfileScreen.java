package PageObjects;

import ScreenFactories.ProfileScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import sun.jvm.hotspot.debugger.Page;

public class ProfileScreen extends BaseTest {

    private ProfileScreenFactory profileScreenFactory = new ProfileScreenFactory();

    public ProfileScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), profileScreenFactory);

        waitForElementToLoad(profileScreenFactory.nameFieldElement);
        waitForElementToLoad(profileScreenFactory.nameEditElement);
        waitForElementToLoad(profileScreenFactory.locationEditElement);
    }

    public String getNameField() {
        return profileScreenFactory.nameFieldElement.getText();
    }

    public EditNameScreen clickOnEditName() {
        profileScreenFactory.nameEditElement.click();
        return new EditNameScreen();
    }

    public LocationScreen clickOnEditLocation() {
        profileScreenFactory.locationEditElement.click();
        return new LocationScreen();
    }

    public void waitForLocationServerUpdate(String location) {
        waitForAttributeToBeVisible(By.id("tvLocationValue"), "text", location);
    }

    public String getLocationField() {
        return profileScreenFactory.locationEditElement.getText();
    }
}
