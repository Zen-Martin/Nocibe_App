package pageObjects;

import com.google.common.collect.ImmutableMap;
import config.ConfigPropertiesReader;
import config.Properties;
import config.SystemPropertiesReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Page {

    private static final Logger LOG = LogManager.getLogger(Page.class);

    protected AppiumDriver<MobileElement> driver;
    protected Actions actions;
    protected TouchAction<?> touchAction;

    protected WebDriverWait shortWait;
    protected WebDriverWait wait;
    protected WebDriverWait longWait;
    protected WebDriverWait loadingWait;

    public static final long SHORT_WAIT = 5;
    public static final long WAIT = 10;
    public static final long LONG_WAIT = 15;
    public static final long LOADING_WAIT = 20;
    protected JavascriptExecutor js;

    protected SystemPropertiesReader systemPropertiesReader;
    protected ConfigPropertiesReader configPropertiesReader;

    @AndroidFindBy(id = "com.pictime.nocibe:id/home_navigation")
    private MobileElement homeView;

    public Page() {
        driver = Properties.APPIUM_DRIVER_MANAGER.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        if(!Properties.SYSTEM_PROPERTIES_READER.platformName.equals("Android"))
            touchAction = new IOSTouchAction(driver);
        else
            touchAction = new AndroidTouchAction(driver);
        wait        = new WebDriverWait(driver, WAIT);
        shortWait   = new WebDriverWait(driver, SHORT_WAIT);
        longWait    = new WebDriverWait(driver, LONG_WAIT);
        loadingWait = new WebDriverWait(driver, LOADING_WAIT);
        systemPropertiesReader = Properties.SYSTEM_PROPERTIES_READER;
        configPropertiesReader = Properties.CONFIG_PROPERTIES_READER;
    }

    /**
     * Wait until the condition in the function is satisfied
     * @param isTrue the condition
     * @param <V> the condition return type
     * @return true if the condition is satisfied, false if the condition hasn't been satisfied in the given time
     */
    protected <V> boolean shortWaitUntil(Function<? super WebDriver, V> isTrue) {
        try {
            shortWait.until(isTrue);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void click(MobileElement element) {
        if(!shortWaitUntil(visibilityOf(element)))
            LOG.warn("The element is not yet visible");
        if(!shortWaitUntil(elementToBeClickable(element)))
            LOG.warn("The element is not yet clickable");
        element.click();
    }

    public void actOnElementList(List<MobileElement> list, String element){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getText().contains(element)){
                click(list.get(i));
                break;
            }
        }
    }

    public void launch() {
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }

    public void scrollClick(String text){
        AndroidElement element =  (AndroidElement) driver.findElement(MobileBy.AndroidUIAutomator(              "new UiScrollable(new UiSelector()" +
                ".scrollable(true).index(0))" +
                ".scrollIntoView(new UiSelector()" +
                ".text(\""+text+"\"))"));
        element.click();
    }

    public void scroll(String text){
        AndroidElement element =  (AndroidElement) driver.findElement(MobileBy.AndroidUIAutomator(              "new UiScrollable(new UiSelector()" +
                ".scrollable(true).index(0))" +
                ".scrollIntoView(new UiSelector()" +
                ".text(\""+text+"\"))"));
    }

    public int findElement(List<MobileElement> list, String element){
        int occurence = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equals(element)) {
                list.get(i).click();
                occurence++;
                break;
            }
        }
        return occurence;
    }

}
