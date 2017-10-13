package AcceptanceTests;

import PageObjects.EditGenderScreen;
import PageObjects.MoviesScreen;
import PageObjects.EditNameScreen;
import PageObjects.ProfileScreen;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

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

    @DataProvider(name = "genders")
    public Object[][] createDataForChangeGender() {
        return  new Object[][] {
                {"Female", "Male"},
                {"Female", "Male"}
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

    @Test(dataProvider = "genders")
    public void changeGender(String gender1, String gender2) {
        MoviesScreen moviesScreen = new MoviesScreen();
        ProfileScreen profileScreen = moviesScreen.clickOnProfileButton();

        String gender = profileScreen.getGender();
        EditGenderScreen editGender = profileScreen.clickOnEditGender();

        if(gender.equals(gender1)){
            editGender.fromFemaleToMale();
            ProfileScreen newProfileScreen = editGender.clickOnOkButtonAfterGenderChange();
            Assert.assertEquals(newProfileScreen.getGender(), gender2);
        }
        else {
            editGender.fromMaleToFemale();
            ProfileScreen newProfileScreen = editGender.clickOnOkButtonAfterGenderChange();
            Assert.assertEquals(newProfileScreen.getGender(), gender1);
        }
    }

}