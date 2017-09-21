package AcceptanceTests;

import Screens.MoviesScreen;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by idorovskikh on 1/31/17.
 */
public class Movies extends GoogleLogin {

    @Test(groups = "acceptance")
    public void verifyMoviesMarkedInterested() throws InterruptedException {
        MoviesScreen moviesScreen = new MoviesScreen();
        moviesScreen.clickOnInterestedInFirstMovie();
        Assert.assertTrue(moviesScreen.getCheckedDate().isDisplayed());
    }
}
