package ScreenFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by borisgurtovyy on 3/8/17.
 */
public class EditNameScreenFactory {
    @AndroidFindBy(id = "edit_text")
    public MobileElement nameTextField ;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement okButtonAfterNameChanging;
}
