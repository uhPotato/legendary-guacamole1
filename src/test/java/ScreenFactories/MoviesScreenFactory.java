package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by borisgurtovyy on 10/9/17.
 */
public class MoviesScreenFactory {


    @AndroidFindBy(id = "btnHamburger")
    public MobileElement profileButton;

    @AndroidFindBy (id = "tvTitle")
    public MobileElement movieTitle;

    @AndroidFindBy (id = "iv_movie_date_active_select")
    public MobileElement movieDateActiveCheckMark;

    @AndroidFindBy (id = "rlToggleButton")
    public MobileElement interestedButton;


}
