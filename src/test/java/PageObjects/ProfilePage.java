package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

/**
 * Created by borisgurtovyy on 10/2/17.
 */
public class ProfilePage extends BaseTest {
    MobileElement nameEdit;

    public ProfilePage() {
        nameEdit = (MobileElement) driver.findElementById("ivName");
        waitForElementToLoad(nameEdit);
    }

    public void clickOnEditName() {
        nameEdit.click();
    }

}
