package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

/**
 * Created by borisgurtovyy on 10/2/17.
 */
public class EditNamePage extends BaseTest {

    private MobileElement nameTextField, okButtonAfterNameChanging;

    public EditNamePage() {
        nameTextField =  (MobileElement) driver.findElementById("edit_text");
        waitForElementToLoad(nameTextField);

        okButtonAfterNameChanging = (MobileElement) driver.findElementById("android:id/button1");
        waitForElementToLoad(okButtonAfterNameChanging);

    }

    public String getName(){
        return nameTextField.getText();
    }

    public void clearName() {
        nameTextField.clear();
    }

    public void inputName(String name) {
        nameTextField.sendKeys(name);
        driver.hideKeyboard();
    }

    public ProfilePage clickOkButton(){
        okButtonAfterNameChanging.click();
        return new ProfilePage();
    }

}
