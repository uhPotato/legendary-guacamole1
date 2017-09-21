package ScreenFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by borisgurtovyy on 3/8/17.
 */
public class ProfileScreenFactory {
    @AndroidFindBy(id = "ivName")
    public MobileElement nameEdit;
    @AndroidFindBy(id = "tvNameValue")
    public MobileElement checkTextField;
}
