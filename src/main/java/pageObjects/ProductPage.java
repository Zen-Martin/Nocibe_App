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

    public void seeProduct(){
        shortWaitUntil(visibilityOf(productCounter));
    }

    public void selectProduct(){
        productImage.get(0).click();
    }

    public boolean priceFilterIncrease(){
        int filter = 0;
        for(int i=0; i<((productPrice.size()/2)+1); i++){
            float previous = removeEuroDevise(productPrice.get(i).getText());
            float next = removeEuroDevise(productPrice.get(i+1).getText());
            if(previous>next){
                filter++;
                break;
            }
        }
        return (filter==0);
    }

    public boolean verifyCardProduct(){
        shortWaitUntil(visibilityOf(productInfoFrame));
        return productInfoFrame.isDisplayed();
    }

    private float removeEuroDevise(String element){
        return Float.valueOf (element.replace("€",""));
    }

}
