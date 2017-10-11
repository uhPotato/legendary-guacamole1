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
        List<MobileElement> interestedButtonsList = driver.findElementsById(moviesScreenFacrory.interestedButton.getId());
        interestedButtonsList.get(buttonIndex).click();
    }

    public String getMovieTitle(int movieIndex) {
        List<MobileElement> movieTitlesList = driver.findElementsById(moviesScreenFacrory.movieTitle.getId());
        return movieTitlesList.get(movieIndex).getText();
    }

    public boolean isCheckMarkDisplayed() {
        return driver.findElementById(moviesScreenFacrory.movieDateActiveCheckMark.getId()).isDisplayed();
    }

}

