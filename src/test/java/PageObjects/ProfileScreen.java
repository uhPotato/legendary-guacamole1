package PageObjects;

import ScreenFactories.ProfileScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProfileScreen extends BaseTest {


    private static ProfileScreenFactory profileScreenFactory = new ProfileScreenFactory();

    public ProfileScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), profileScreenFactory);
        waitForElementToLoad(profileScreenFactory.nameEditElement);

    }

    public String getNameField() {
        return profileScreenFactory.nameFieldElement.getText();
    }

    public EditNameScreen clickOnEditName() {
        profileScreenFactory.nameEditElement.click();
        return new EditNameScreen();
    }

}
