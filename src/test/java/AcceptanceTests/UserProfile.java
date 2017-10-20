package AcceptanceTests;

import PageObjects.*;
import PageObjects.EditGenderScreen;
import PageObjects.MoviesScreen;
import PageObjects.EditNameScreen;
import PageObjects.ProfileScreen;
import Utils.BaseTest;
import Utils.DateFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserProfile extends BaseTest {

    @DataProvider(name = "changeValidNames")
    public Object[][] createDataForValidChangeNameTest() {
        return new Object[][]{
                {"Boris"},
                {"Igor"}
        };
    }

    @DataProvider(name = "oneCharNames")
    public Object[][] createDataForOneCharNameTest() {
        return new Object[][]{
                {"a"},
                {"b"}
        };
    }

    @DataProvider(name = "changeLocations")
    public Object[][] createDataForLocationTest() {
        return new Object[][]{
                {"Sunnyvale, CA"},
                {"Milpitas, CA"}
        };
    }

    @DataProvider(name = "genders")
    public Object[][] createDataForChangeGender() {
        return new Object[][]{
                {"Female", "Male"},
                {"Female", "Male"}
        };
    }


    @DataProvider(name = "changeMovieIndex")
    public Object [][] createDataForMovieIndexing() {
        return new Object[][] {
                {1},
                {3}
        };
    }

    
    @DataProvider(name = "changeValidBirthdays")
    public Object [][] createDataForValidChangeBirthdayTest() {
        return new Object[][]{
                {"December 15, 1975"},
                {"January 17, 1978"}
        };
    }


    @BeforeMethod(groups = "acceptance")
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

    @AfterMethod(groups = "acceptance")
    public void afterEachTest() {
        System.out.println("Resetting App");
        driver.resetApp();
    }

    @Test(groups = "acceptance", dataProvider = "changeValidNames")
    public void changeName(String[] validNames) {
        MoviesScreen moviesScreen = new MoviesScreen();
        ProfileScreen profileScreen = moviesScreen.clickOnProfileButton();
        EditNameScreen editNameScreen = profileScreen.clickOnEditName();

        String newName = validNames[0];

        editNameScreen.setNameField(newName);
        ProfileScreen newProfileScreen = editNameScreen.clickOnOkButtonAfterNameChanging();

        Assert.assertEquals(newProfileScreen.getNameField(), newName);
    }

    @Test(groups = "acceptance", dataProvider = "oneCharNames")
    public void changeNameWithOneChar(String[] oneChar) {

        MoviesScreen moviesScreen = new MoviesScreen();
        ProfileScreen previousProfileScreen = moviesScreen.clickOnProfileButton();
        EditNameScreen editNameScreen = previousProfileScreen.clickOnEditName();

        String newName = oneChar[0];

        editNameScreen.setNameField(newName);
        ProfileScreen newProfileScreen = editNameScreen.clickOnOkButtonAfterNameChanging();

        Assert.assertEquals(previousProfileScreen.getNameField(), newProfileScreen.getNameField());
    }

    @Test(groups = "acceptance", dataProvider = "changeMovieIndex")
    public void markMovieInterested(int[] movieIndexes) {
        MoviesScreen moviesScreen = new MoviesScreen();
        int movieIndex = movieIndexes[0];

        moviesScreen.clickInterested(movieIndex);
        String movieTitle = moviesScreen.getMovieTitle(movieIndex);
        Assert.assertTrue(moviesScreen.isCheckMarkDisplayed());
        moviesScreen.getIndexOfInterestedMovie(movieTitle);
        moviesScreen.clickInterested(movieIndex);

    }

    @Test(groups = "acceptance")
    public void userLandedOnMoviesScreenAfterSignIn() {
        new MoviesScreen();
        Assert.assertTrue(MoviesScreen.getListOfMainNavTabs().get(0).isSelected());
    }

    @Test(groups = "acceptance")
    public void highlightedDateMatchesActualDate() {
        new MoviesScreen();
        Assert.assertTrue(DateFactory.getActualDayOfMonth().equalsIgnoreCase(MoviesScreen.getDisplayedDayOfMonth()));
        Assert.assertTrue(DateFactory.getActualDayOfWeek().equalsIgnoreCase(MoviesScreen.getDisplayedDayOfWeek()));
        Assert.assertTrue(DateFactory.getActualMonth().contains(MoviesScreen.getDisplayedMonth()));
    }

    @Test(groups = "acceptance", dataProvider = "changeLocations")
    public void changeLocation(String[] validLocations) {
        MoviesScreen moviesScreen = new MoviesScreen();
        ProfileScreen profileScreen = moviesScreen.clickOnProfileButton();
        LocationScreen locationScreen = profileScreen.clickOnEditLocation();

        String location = validLocations[0];

        locationScreen.setLocationField(location);
        locationScreen.clickOkButton();

        profileScreen.waitForLocationServerUpdate(location);

        Assert.assertEquals(profileScreen.getLocationField(), location);
    }

    @Test(groups = "acceptance", dataProvider = "genders")
    public void changeGender(String gender1, String gender2) {
        MoviesScreen moviesScreen = new MoviesScreen();
        ProfileScreen profileScreen = moviesScreen.clickOnProfileButton();

        String gender = profileScreen.getGender();
        EditGenderScreen editGender = profileScreen.clickOnEditGender();

        if (gender.equals(gender1)) {
            editGender.fromFemaleToMale();
            ProfileScreen newProfileScreen = editGender.clickOnOkButtonAfterGenderChange();
            Assert.assertEquals(newProfileScreen.getGender(), gender2);
        } else {
            editGender.fromMaleToFemale();
            ProfileScreen newProfileScreen = editGender.clickOnOkButtonAfterGenderChange();
            Assert.assertEquals(newProfileScreen.getGender(), gender1);
        }
    }

    @Test(groups = "acceptance", dataProvider = "changeValidBirthdays")
    public void changeBirthday(String[] newBirthdayData){
        String newBirthday = newBirthdayData[0];
        MoviesScreen moviesScreen = new MoviesScreen();
        ProfileScreen previousProfileScreen = moviesScreen.clickOnProfileButton();
        EditBirthdayScreen birthdayScreen = previousProfileScreen.clickOnEditBirthday();
        birthdayScreen.changeBirthdayData(newBirthday);
        ProfileScreen newProfileScreen = birthdayScreen.clickOnOkButtonAfterChangeingBirthdayData();
        Assert.assertEquals(newProfileScreen.getBirthdayField(),newBirthday);
    }


}
