package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;

/**
 * Created by borisgurtovyy on 10/9/17.
 */
public class MoviesScreenFactory {

    @AndroidFindBy(id = "btnHamburger")
    public MobileElement profileButton;

    @AndroidFindBy(id = "tv_date_picker_day")
    public MobileElement displayedDayOfMonth;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_date_picker_day_name') and @index='2']")
    public MobileElement displayedDayOfWeek;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_date_picker_month_name') and @index='1']")
    public MobileElement displayedMonth;


}
