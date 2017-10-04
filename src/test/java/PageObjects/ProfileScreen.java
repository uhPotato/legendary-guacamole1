package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

public class ProfileScreen extends BaseTest {

    MobileElement nameField;
    MobileElement nameEdit;

    public ProfileScreen() {
        nameField = (MobileElement) driver.findElementById("tvNameValue");
        waitForElementToLoad(nameField);
        nameEdit = (MobileElement) driver.findElementById("ivName");
        waitForElementToLoad(nameEdit);
    }

    public String getNameField() {
        return nameField.getText();
    }

    public MyPublicNameIs clickOnEditName() {
        nameEdit.click();
        return new MyPublicNameIs();
    }

}
