package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page {

    private static final Logger LOG = LogManager.getLogger(HomePage.class);

    @AndroidFindBy(id = "com.pictime.nocibe:id/catalog_navigation")
    private MobileElement categoryView;

    @AndroidFindBy(id = "com.pictime.nocibe:id/item_home_top_category")
    private MobileElement categoryItem;

    @AndroidFindBy(id = "com.pictime.nocibe:id/button_disagree_link")
    private MobileElement cookieOption;

    @AndroidFindBy(id = "com.pictime.nocibe:id/searchEditText")
    private MobileElement searchBar;

    @AndroidFindBy(id = "com.pictime.nocibe:id/skip")
    private MobileElement overviewPopUp;

    @AndroidFindBy(id = "com.pictime.nocibe:id/itemExpandableRow")
    private MobileElement categorySuggestionButton;

    @AndroidFindBy(id = "com.pictime.nocibe:id/emptyViewTitle")
    private MobileElement notFoundInfo;

    @AndroidFindBy(id = "com.pictime.nocibe:id/item_home_top_category")
    private MobileElement navMenuOption;

    @AndroidFindBy(id = "com.pictime.nocibe:id/product_count")
    private MobileElement productOccurences;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<MobileElement> textView;

    private static int entryAppOccurence = 0;

    public void reject(MobileElement element){
        try {
            shortWaitUntil(visibilityOf(element));
            click(element);
        }catch (Exception e){}
    }

    public void getOnCategory(){
        click(categoryView);
    }

    public void waitForAppLoading() {
        if (entryAppOccurence==0){
            reject(cookieOption);
            reject(overviewPopUp);
        }
        entryAppOccurence++;
    }

    public void clickOnSearchBar(){
        click(searchBar);
    }

    public void makeSearch(String element){
        searchBar.sendKeys(element);
    }

    public boolean verifyFoundResult(){
        shortWaitUntil(visibilityOf(productOccurences));
        return productOccurences.isDisplayed();
    }

    public boolean verifyNotFoundResult(){
        shortWaitUntil(visibilityOf(notFoundInfo));
        return notFoundInfo.isDisplayed();
    }

    public boolean verifySuggestions(){
        shortWaitUntil(visibilityOf(categorySuggestionButton));
        return categorySuggestionButton.isDisplayed();
    }

    public boolean verifyViewTitle(String element){
        shortWaitUntil(visibilityOf(productOccurences));
        return getTitle(element)!=0;
    }

    public void selectCategory(String category){
        scrollClick(category);
    }

    public void selectSubcategory(String subcategory){
        scrollClick(subcategory);
    }

    public int getTitle(String element){
        int found = 0;
        for (int i = 0; i < textView.size(); i++) {
            if (textView.get(i).getText().equals(element)) {
                textView.get(i).click();
                found++;
                break;
            }
        }
        return found;
    }


}
