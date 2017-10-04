package AcceptanceTests;

import PageObjects.MoviesScreen;
import PageObjects.MyPublicNameIs;
import PageObjects.ProfileScreen;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

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
        MyPublicNameIs myPublicNameIs = profileScreen.clickOnEditName();

        String newName = "Boris";

        myPublicNameIs.setNameField(newName);
        profileScreen = myPublicNameIs.clickOnOkButtonAfterNameChanging();

        Assert.assertEquals(profileScreen.getNameField(), newName);
    }

    @Test
    public void changeNameWithOneChar() {
        MoviesScreen moviesScreen = new MoviesScreen();
        ProfileScreen profileScreen = moviesScreen.clickOnProfileButton();

        String previousName = profileScreen.getNameField();

        MyPublicNameIs myPublicNameIs = profileScreen.clickOnEditName();

        String newName = "B";

        myPublicNameIs.setNameField(newName);
        profileScreen = myPublicNameIs.clickOnOkButtonAfterNameChanging();

        Assert.assertEquals(profileScreen.getNameField(), previousName);
    }
}
