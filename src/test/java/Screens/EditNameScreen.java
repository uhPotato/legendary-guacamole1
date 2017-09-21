package Screens;

import ScreenFactory.EditNameScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by borisgurtovyy on 3/3/17.
 */
public class EditNameScreen extends BaseTest {

    EditNameScreenFactory editNameScreenFactory = new EditNameScreenFactory();

    public EditNameScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), editNameScreenFactory);
        waitForElementToLoad(editNameScreenFactory.nameTextField);
    }

    public ProfileScreen changeName(String newName){
        editNameScreenFactory.nameTextField.clear();
        editNameScreenFactory.nameTextField.sendKeys(newName);
        driver.hideKeyboard();
        editNameScreenFactory.okButtonAfterNameChanging.click();
        return new ProfileScreen();
    }
}
