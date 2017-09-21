package Screens;

import AcceptanceTests.GoogleLogin;
import ScreenFactory.ProfileScreenFactory;
import Utils.BaseTest;
import com.sun.xml.internal.rngom.parse.host.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by borisgurtovyy on 3/2/17.
 */
public class ProfileScreen extends BaseTest {
    public ProfileScreenFactory profileScreenFactory = new ProfileScreenFactory();

    public ProfileScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), profileScreenFactory);
        waitForElementToLoad(profileScreenFactory.nameEdit);
    }

    public EditNameScreen clickOnPencil(){
        profileScreenFactory.nameEdit.click();
        return new EditNameScreen();
    }

    public String getActualName(){
        return profileScreenFactory.checkTextField.getText();
    }

}