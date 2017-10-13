package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by borisgurtovyy on 10/9/17.
 */
public class ProfileScreenFactory {

    @AndroidFindBy(id = "tvNameValue")
    public MobileElement nameFieldElement;

    @AndroidFindBy(id = "ivName")
    public MobileElement nameEditElement;

    @AndroidFindBy(id = "tvGenderValue")
    public MobileElement genderFieldElement;

    @AndroidFindBy(id = "ivGender")
    public  MobileElement genderEditElement;

}
