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
                {0},
                {1}
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
/*
4) Проитерировать лист с фильмами и найти фильм с сохраненным названием
5) Нажать еще раз на interested чтобы разчекать его
6) проверить что чекмарка на дате нет
 */
    @Test(dataProvider = "changeMovieIndex")
    public void markMovieInterested(int [] movieIndex) {
        MoviesScreen moviesScreen = new MoviesScreen();

        int newMovieIndex = movieIndex[0];

        //1) Выбать фильм как interested
        moviesScreen.clickInterested(0);

        //2) Сохранить название фильма в переменной
        String movieTitle = moviesScreen.getMovieTitle(newMovieIndex);

        //3) Заверить, что чекмарк на дате появился
        Assert.assertTrue(moviesScreen.isCheckMarkDisplayed());



    }

}
