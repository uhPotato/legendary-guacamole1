package AcceptanceTests;

import Screens.EditNameScreen;
import Screens.MoviesScreen;
import Screens.ProfileScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by idorovskikh on 1/18/17.
 */
public class UserProfile extends GoogleLogin {
    @Test(groups = "acceptance")
    public void changeName() {

        MoviesScreen moviesScreen = new MoviesScreen();
        ProfileScreen profileScreen = moviesScreen.clickOnProfileButton();
        EditNameScreen editNameScreen = profileScreen.clickOnPencil();
        String newName = "Boris";
        ProfileScreen profileScreenAfterChanging = editNameScreen.changeName(newName);
        Assert.assertEquals(profileScreenAfterChanging.getActualName(), newName);

    }

}
