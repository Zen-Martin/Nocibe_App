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

    @AndroidFindBy(className = "android.widget.TextView")
    private List<MobileElement> textView;

    public void seeProduct(){
        shortWaitUntil(visibilityOf(productCounter));
    }

    public void selectProduct(){
        seeProduct();
        productImage.get(0).click();
    }

    public boolean priceFilterIncrease(){
        shortWaitUntil(visibilityOf(productPrice.get(0)));
        int filter = 0;
        for(int i=0; i<((productPrice.size()/100)+3); i++){
            Double previous = removeEuroDevise(productPrice.get(i).getText());
            Double next = removeEuroDevise(productPrice.get(i+1).getText());
            if(previous>next){
                filter++;
                break;
            }
        }
        return (filter==0);
    }

    private void sortOption(String option){
        for(int i=0; i<textView.size(); i++){
            if(textView.get(i).getText().equals(option)){
                click(textView.get(i));
                break;
            }
        }
    }

    private void validChoice(String element){
        for(int i=0; i<textView.size(); i++){
            if(textView.get(i).getText().contains(element)){
                click(textView.get(i));
                break;
            }
        }
    }

    public void sortValue(String option){
        click(filterButton);
        sortOption(option);
        validChoice("Afficher");
    }

    public boolean verifyCardProduct(){
        shortWaitUntil(visibilityOf(productInfoFrame));
        return productInfoFrame.isDisplayed();
    }

    private Double removeEuroDevise(String element){
        return Double.parseDouble(element.replaceAll("\"€\"", ""));
    }

}
