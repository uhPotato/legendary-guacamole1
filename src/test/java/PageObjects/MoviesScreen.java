package PageObjects;

import ScreenFactories.MoviesScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MoviesScreen extends BaseTest {

    public MoviesScreenFactory moviesScreenFacrory = new MoviesScreenFactory();

    public MoviesScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), moviesScreenFacrory);
        waitForElementToLoad(moviesScreenFacrory.profileButton);
    }

    public ProfileScreen clickOnProfileButton() {
        moviesScreenFacrory.profileButton.click();
        return new ProfileScreen();
    }
}

