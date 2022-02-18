package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProductPage extends Page{

    @AndroidFindBy(id = "com.pictime.nocibe:id/productImageView")
    private List<MobileElement> productImage;

    @AndroidFindBy(id = "com.pictime.nocibe:id/priceTextView")
    private List<MobileElement> productPrice;

    @AndroidFindBy(id = "com.pictime.nocibe:id/product_name_row_id")
    private MobileElement productInfoFrame;

    @AndroidFindBy(id = "com.pictime.nocibe:id/product_count")
    private MobileElement productCounter;

    @AndroidFindBy(id = "com.pictime.nocibe:id/filterButton")
    private MobileElement filterButton;

    @AndroidFindBy(id="com.pictime.nocibe:id/filter_product_button")
    private MobileElement submitFilter;

    @AndroidFindBy(xpath = ".//android.widget.TextView[@text='Confirmer']")
    private MobileElement validOption;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<MobileElement> textView;

    @AndroidFindBy(id = "com.pictime.nocibe:id/titleTextView_filter")
    private List<MobileElement> optionValue;

    @AndroidFindBy(id = "com.pictime.nocibe:id/item_filter_label_textView")
    private List<MobileElement> filterChoice;

    @AndroidFindBy(id = "com.pictime.nocibe:id/item_filter_productCount_textView")
    private MobileElement filterActived;

    @AndroidFindBy(id = "com.pictime.nocibe:id/reset_filter_button")
    private MobileElement resetFilter;

    @AndroidFindBy(xpath = ".//android.widget.Button[@text='CONTINUER']")
    private MobileElement resetConfirmation;

    private String product_result = "";

    public void seeProduct(){
        shortWaitUntil(visibilityOf(productCounter));
        product_result = productCounter.getText();
    }

    public void selectProduct(){
        seeProduct();
        productImage.get(0).click();
    }

    public void filterOption(String element){
        actOnElementList(filterChoice,element);
        optionValue.get(0).click();
        click(validOption);
    }

    public void submitFilter(){
        click(submitFilter);
    }

    public void resetFilter(){
        click(resetFilter);
        click(resetConfirmation);
    }

    public void sortValue(String option){
        click(filterButton);
        actOnElementList(textView,option);
    }

    public boolean verifyCardProduct(){
        shortWaitUntil(visibilityOf(productInfoFrame));
        return productInfoFrame.isDisplayed();
    }

    public boolean verifyFilterOption(){
        shortWaitUntil(visibilityOf(productCounter));
        return !productCounter.getText().equals(product_result);
    }

    public boolean verifyFilterActivation(){
        try{
            return filterActived.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

}
