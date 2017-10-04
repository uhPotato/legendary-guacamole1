package AcceptanceTests;

import PageObjects.EditNamePage;
import PageObjects.MoviesPage;
import PageObjects.ProfilePage;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.java2d.cmm.Profile;

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

        MoviesPage moviesPage = new MoviesPage();
        ProfilePage profilePage = moviesPage.clickOnProfileButton();

        EditNamePage editNamePage = profilePage.clickOnEditName();
        editNamePage.clearName();
        String newName = "Boris";
        editNamePage.inputName(newName);

        ProfilePage changedNameProfilePage = editNamePage.clickOkButton();
        Assert.assertEquals(changedNameProfilePage.getProfileName(), newName);
    }

    @Test
    public void changeNameWithOneChar() {
        MoviesPage moviesPage = new MoviesPage();
        ProfilePage profilePage = moviesPage.clickOnProfileButton();

        EditNamePage editNamePage = profilePage.clickOnEditName();
        String oldName = editNamePage.getName();
        editNamePage.clearName();
        String newName = "X";
        editNamePage.inputName(newName);

        ProfilePage changedNameProfilePage = editNamePage.clickOkButton();
        Assert.assertEquals(changedNameProfilePage.getProfileName(), oldName);
    }
}
