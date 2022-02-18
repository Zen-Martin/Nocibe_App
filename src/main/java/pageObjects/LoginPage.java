package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends Page{

    @AndroidFindBy(id = "com.pictime.nocibe:id/emailEditText")
    private MobileElement emailField;

    @AndroidFindBy(id = "com.pictime.nocibe:id/passwordEditText")
    private MobileElement passwordField;

    @AndroidFindBy(id = "com.pictime.nocibe:id/connectButton")
    private MobileElement submitButton;

    @AndroidFindBy(id = "com.pictime.nocibe:id/home_navigation")
    private MobileElement homeView;

    @AndroidFindBy(xpath = ".//android.widget.Button[@text='OUI']")
    private MobileElement accountAccess;

    private String email = "merlinmagicien1@gmail.com";

    private String password = "Test@2022";

    public void getLogged(){
        fillfield(emailField,email);
        fillfield(passwordField,password);
        click(submitButton);
        shortWaitUntil(visibilityOf(accountAccess));
        click(accountAccess);
        shortWaitUntil(visibilityOf(homeView));
    }

    public void fillfield(MobileElement element, String text){
        element.click();
        element.sendKeys(text);
    }


}
