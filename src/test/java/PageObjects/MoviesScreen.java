package PageObjects;

import ScreenFactories.MoviesScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


import static org.testng.FileAssert.fail;


public class MoviesScreen extends BaseTest {

    public static MoviesScreenFactory moviesScreenFactory = new MoviesScreenFactory();

    public MoviesScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), moviesScreenFactory);
        waitForElementToLoad(moviesScreenFactory.profileButton);
    }

    public ProfileScreen clickOnProfileButton() {
        moviesScreenFactory.profileButton.click();
        return new ProfileScreen();
    }

    public void clickInterested(int buttonIndex) {
        List<MobileElement> interestedButtonsList = driver.findElementsById("tbButtonInterested");
        interestedButtonsList.get(buttonIndex).click();
    }

    public String getMovieTitle(int movieIndex) {
        List<MobileElement> movieTitlesList = driver.findElementsById("tvTitle");
        return movieTitlesList.get(movieIndex + 3).getText();
    }

    public boolean isCheckMarkDisplayed() {
        return driver.findElementById("iv_movie_date_active_select").isDisplayed();
    }

    public boolean isCheckMarkNotDisplayed() {
        try {
            driver.findElementById("iv_movie_date_active_select");
            fail ("Checkmark over date is present");
        }      catch (NoSuchElementException ex) {
            return true;
        }
        return true;
    }

    public int getIndexOfInterestedMovie(String movieTitle) {
        List<MobileElement> movieTitlesList = driver.findElementsById("tvTitle");
        for (MobileElement movieName:movieTitlesList) {
            if (movieName.getText().equals(movieTitle)) {
                return movieTitlesList.indexOf(movieName) - 3;
            } else return -1;
        }
        return -1;
    }

    public static List<MobileElement> getListOfMainNavTabs() {
        return (List<MobileElement>) driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
    }

    public static String getDisplayedDayOfMonth() {
        return moviesScreenFactory.displayedDayOfMonth.getText();
    }

    public static String getDisplayedDayOfWeek() {
        return moviesScreenFactory.displayedDayOfWeek.getText();
    }

    public static String getDisplayedMonth() {
        return moviesScreenFactory.displayedMonth.getText();
    }

}

