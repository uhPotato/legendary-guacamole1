package PageObjects;

import ScreenFactories.MoviesScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    public void clickInterested(int buttonIndex) {
        List<MobileElement> interestedButtonsList = driver.findElementsById("tbButtonInterested");
        interestedButtonsList.get(buttonIndex);
    }

    public String getMovieTitle(int movieIndex) {
        List<MobileElement> movieTitlesList = driver.findElementsById("tvTitle");
        return movieTitlesList.get(movieIndex).getText();
    }

    public boolean isCheckMarkDisplayed() {
        return driver.findElementById("iv_movie_date_active_select").isDisplayed();
    }

}

