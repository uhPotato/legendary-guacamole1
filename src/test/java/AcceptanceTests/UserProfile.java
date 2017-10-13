package AcceptanceTests;

import PageObjects.EditNameScreen;
import PageObjects.MoviesScreen;
import PageObjects.ProfileScreen;
import Utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by idorovskikh on 1/18/17.
 */
public class UserProfile extends BaseTest {

    @DataProvider(name = "changeValidNames")
    public Object[][] createDataForValidTest() {
        return new Object[][] {
                {"Boris"},
                {"Yo"}
        };
    }

    @DataProvider(name = "changeInvalidNames")
    public Object[][] createDataForInvalidTest() {
        return new Object[][] {
                {"A"},
                {"a"}
        };
    }

    @DataProvider(name = "changeMovieIndex")
    public Object [][] createDataForMovieIndexing() {
        return new Object[][] {
                {0}
        };
    }

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

    @Test(dataProvider = "changeValidNames")
    public void changeName(String[] validNames) {
        MoviesScreen moviesScreen = new MoviesScreen();
        ProfileScreen profileScreen = moviesScreen.clickOnProfileButton();
        EditNameScreen editNameScreen = profileScreen.clickOnEditName();

        String newName = validNames[0];

        editNameScreen.setNameField(newName);
        ProfileScreen newProfileScreen = editNameScreen.clickOnOkButtonAfterNameChanging();

        Assert.assertEquals(newProfileScreen.getNameField(), newName);
    }

    @Test(dataProvider = "changeInvalidNames")
    public void changeNameWithOneChar(String[] invalidNames) {
        MoviesScreen moviesScreen = new MoviesScreen();
        ProfileScreen previousProfileScreen = moviesScreen.clickOnProfileButton();
        EditNameScreen editNameScreen = previousProfileScreen.clickOnEditName();

        String newName = invalidNames[0];

        editNameScreen.setNameField(newName);
        ProfileScreen newProfileScreen = editNameScreen.clickOnOkButtonAfterNameChanging();

        Assert.assertEquals(previousProfileScreen.getNameField(), newProfileScreen.getNameField());
    }

    @Test(dataProvider = "changeMovieIndex")
    public void markMovieInterested(int[] movieIndexes) {
        MoviesScreen moviesScreen = new MoviesScreen();
        int movieIndex = movieIndexes[0];

        //1) mark a movie as 'interested'
        moviesScreen.clickInterested(movieIndex);

        //2) save movie title in variable
        String movieTitle = moviesScreen.getMovieTitle(movieIndex);

        //3) assert that check mark is on the date
        Assert.assertTrue(moviesScreen.isCheckMarkDisplayed());

        //4) iterate list with movies and find the one with the right title
        moviesScreen.getIndexOfInterestedMovie(movieTitle);

        //5) click interested on the same movie one more time to 'uncheck' it
        moviesScreen.clickInterested(movieIndex);

        //6) verify that checkmark over date is not displayed
        Assert.assertTrue(moviesScreen.isCheckMarkNotDisplayed());

    }

}
