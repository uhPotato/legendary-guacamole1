package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ProfileScreen extends BaseTest {

    MobileElement   nameFieldElement, nameEditElement, locationEditElement;

    public ProfileScreen() {
        nameFieldElement = (MobileElement) driver.findElementById("tvNameValue");
        waitForElementToLoad(nameFieldElement);

        nameEditElement = (MobileElement) driver.findElementById("ivName");
        waitForElementToLoad(nameEditElement);

        locationEditElement = (MobileElement) driver.findElementById("tvLocationValue");
        waitForElementToLoad(locationEditElement);
    }

    public String getNameField() {
        return nameFieldElement.getText();
    }

    public EditNameScreen clickOnEditName() {
        nameEditElement.click();
        return new EditNameScreen();
    }

    public LocationScreen clickOnEditLocation() {
        locationEditElement.click();
        return new LocationScreen();
    }

    public void waitForLocationServerUpdate(String location) {
        waitForAttributeToBeVisible(By.id("tvLocationValue"), "text", location);
    }

    public String getLocationField() {
        return locationEditElement.getText();
    }
}
