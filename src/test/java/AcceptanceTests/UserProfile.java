package AcceptanceTests;

import PageObjects.EditNameScreen;
import PageObjects.MoviesScreen;
import PageObjects.ProfileScreen;
import Utils.BaseTest;
import Utils.DateFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by idorovskikh on 1/18/17.
 */
public class UserProfile extends BaseTest {
    @BeforeMethod
    private void successfulGoogleLoginWithValidCredential() {
        System.out.println("login");
        driver.findElement(By.id("btnGoogleLogin")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(By.id("android:id/button1")).click();

        Boolean result = elementIsNotPresent(By.id("com.android.packageinstaller:id/permission_allow_button"));
        if (!result) {
            //driver.switchTo().alert().accept(); DOES NOT WORK!!!!
            driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        }

        Assert.assertTrue(driver.findElementById("btnHamburger").isDisplayed());
    }

    @AfterMethod
    public void afterEachTest() {
        System.out.println("Resetting App");
        driver.resetApp();
    }

    @Test
    public void changeName() {
        MoviesScreen moviesScreen = new MoviesScreen();
        ProfileScreen profileScreen = moviesScreen.clickOnProfileButton();
        EditNameScreen editNameScreen = profileScreen.clickOnEditName();

        String newName = "Boris";

        editNameScreen.setNameField(newName);
        ProfileScreen newProfileScreen = editNameScreen.clickOnOkButtonAfterNameChanging();

        Assert.assertEquals(newProfileScreen.getNameField(), newName);
    }

    @Test
    public void changeNameWithOneChar() {
        MoviesScreen moviesScreen = new MoviesScreen();
        ProfileScreen previousProfileScreen = moviesScreen.clickOnProfileButton();
        EditNameScreen editNameScreen = previousProfileScreen.clickOnEditName();

        String newName = "B";

        editNameScreen.setNameField(newName);
        ProfileScreen newProfileScreen = editNameScreen.clickOnOkButtonAfterNameChanging();

        Assert.assertEquals(previousProfileScreen.getNameField(), newProfileScreen.getNameField());
    }

    @Test
    public void userLandedOnMoviesScreenAfterSignIn() {
        waitForAttributeToBeVisible(By.id("us.moviemates:id/tvTitle"), "text", "Movies");
        Assert.assertTrue(MoviesScreen.getListOfMainNavTabs().get(0).isSelected());
    }

    @Test
    public void highlightedDateMatchesActualDate() {
        waitForAttributeToBeVisible(By.id("us.moviemates:id/tvTitle"), "text", "Movies");
        Assert.assertTrue(DateFactory.getActualDayOfMonth().equals(MoviesScreen.getDisplayedDayOfMonth()));
        Assert.assertTrue(DateFactory.getActualDayOfWeek().equals(MoviesScreen.getDisplayedDayOfWeek()));
        Assert.assertTrue(DateFactory.getActualMonth().contains(MoviesScreen.getDisplayedMonth()));
    }
}
