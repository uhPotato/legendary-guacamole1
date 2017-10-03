package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

/**
 * Created by borisgurtovyy on 10/2/17.
 */
public class EditNamePage extends BaseTest {

    MobileElement nameTextField;

    public EditNamePage() {
        nameTextField =  (MobileElement) driver.findElementById("edit_text");
        waitForElementToLoad(nameTextField);
    }

}
