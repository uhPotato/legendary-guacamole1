package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

public class LocationScreen extends BaseTest{

    private MobileElement locationTextField, okButton;

    public LocationScreen(){
        locationTextField = (MobileElement) driver.findElementById("etEnterPosition");
        waitForElementToLoad(locationTextField);

        okButton = (MobileElement) driver.findElementById("android:id/button1");
        waitForElementToLoad(okButton);
    }

    public void setLocationField(String location) {
        locationTextField.click();
        locationTextField.clear();
        locationTextField.sendKeys(location);
        driver.hideKeyboard();
    }

    public ProfileScreen clickOkButton() {
        okButton.click();
        return new ProfileScreen();

    }


}
