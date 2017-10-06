package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

public class EditNameScreen extends BaseTest {
    private MobileElement okButtonAfterNameChanging;
    private MobileElement nameTextField;

    public EditNameScreen() {
        nameTextField = (MobileElement) driver.findElementById("edit_text");
        waitForElementToLoad(nameTextField);

        okButtonAfterNameChanging = (MobileElement) driver.findElementById("android:id/button1");
        waitForElementToLoad(okButtonAfterNameChanging);

    }

    public void setNameField(String newName) {
        nameTextField.clear();
        nameTextField.sendKeys(newName);
        driver.hideKeyboard();
    }

    public ProfileScreen clickOnOkButtonAfterNameChanging() {
        okButtonAfterNameChanging.click();
        return new ProfileScreen();
    }

}
