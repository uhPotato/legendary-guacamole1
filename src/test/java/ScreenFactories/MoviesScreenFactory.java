package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * Created by borisgurtovyy on 10/9/17.
 */
public class MoviesScreenFactory {

    @AndroidFindBy(id = "btnHamburger")
    public MobileElement profileButton;

    @AndroidFindBy(id = "us.moviemates:id/tvTitle")
    public MobileElement moviesScreenTab;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='3']")
    public MobileElement displayedDayOfMonth;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
    public MobileElement displayedDayOfWeek;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    public MobileElement displayedMonth;
}
