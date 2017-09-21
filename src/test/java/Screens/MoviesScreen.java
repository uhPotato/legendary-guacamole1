package Screens;

import ScreenFactory.MoviesScreenFacrory;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by borisgurtovyy on 3/2/17.
 */


public class MoviesScreen extends BaseTest {

    public MoviesScreenFacrory moviesScreenFacrory = new MoviesScreenFacrory();

    public MoviesScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), moviesScreenFacrory);
        waitForElementToLoad(moviesScreenFacrory.interestedInFirstMovie);
    }

    public ProfileScreen clickOnProfileButton(){
        moviesScreenFacrory.profileButton.click();
        return new ProfileScreen();
    }

    public void clickOnInterestedInFirstMovie() {
        moviesScreenFacrory.interestedInFirstMovie.click();
    }

    public MobileElement getCheckedDate(){
        return moviesScreenFacrory.checkedDate;
    }

}
