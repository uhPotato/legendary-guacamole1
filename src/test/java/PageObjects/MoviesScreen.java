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
        interestedButtonsList.get(buttonIndex).click();
    }

    // there's a hard coded '3' because tabs 'MOVIES' 'MATES' & 'CHATS' share the same id as movie titles, so I exclude them from the list.
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

    // there's a hard coded '3' because check previous comment
    public int getIndexOfInterestedMovie(String movieTitle) {
        List<MobileElement> movieTitlesList = driver.findElementsById("tvTitle");
        for (MobileElement movieName:movieTitlesList) {
            if (movieName.getText() == movieTitle) {
                return movieTitlesList.indexOf(movieName) - 3;
            } else return -1;
        }


        return -1;
    }

}

