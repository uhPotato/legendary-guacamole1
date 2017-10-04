package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

/**
 * Created by borisgurtovyy on 10/2/17.
 */
public class ProfilePage extends BaseTest {

    private MobileElement nameEdit, checkTextField;

    public ProfilePage() {
        nameEdit = (MobileElement) driver.findElementById("ivName");
        waitForElementToLoad(nameEdit);

    }

    public void clickOnEditName() {
        nameEdit.click();
        //return new EditNamePage();
    }

    public void assertName(String name){
        checkTextField = (MobileElement) driver.findElementById("tvNameValue");
        waitForElementToLoad(checkTextField);
        Assert.assertEquals(checkTextField.getText(), name);
    }



}
