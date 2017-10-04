package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

public class ProfileScreen extends BaseTest {
    String          nameField;
    MobileElement   nameFieldElement;
    MobileElement   nameEditElement;

    public ProfileScreen() {
        nameFieldElement = (MobileElement) driver.findElementById("tvNameValue");
        waitForElementToLoad(nameFieldElement);
        nameEditElement = (MobileElement) driver.findElementById("ivName");
        waitForElementToLoad(nameEditElement);

        nameField = nameFieldElement.getText();
    }

    public String getNameField() {
        return nameField;
    }

    public MyPublicNameIs clickOnEditName() {
        nameEditElement.click();
        return new MyPublicNameIs();
    }

}
