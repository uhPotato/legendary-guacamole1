package ScreenFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Created by borisgurtovyy on 3/8/17.
 */
public class MoviesScreenFacrory {

    @AndroidFindBy(id = "btnHamburger")
    public MobileElement profileButton;

    @AndroidFindBy(id = "rlItemFilm")
    public List<MobileElement> movies;

    @AndroidFindBy(id = "tbButtonInterested")
    public MobileElement interestedInFirstMovie;

    @AndroidFindBy(id = "rl_date_picker_item")
    public List<MobileElement> currentDate;

    @AndroidFindBy(id = "iv_movie_date_active_select")
    public MobileElement checkedDate;

}
