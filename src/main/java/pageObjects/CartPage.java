package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CartPage extends Page{

    @AndroidFindBy(className = "android.widget.Button")
    private List<MobileElement> cartModificator;

    @AndroidFindBy(id = "com.pictime.nocibe:id/emptyViewTitle")
    private MobileElement notFoundInfo;

    @AndroidFindBy(id = "com.pictime.nocibe:id/item_home_top_category")
    private MobileElement navMenuOption;

    @AndroidFindBy(id = "com.pictime.nocibe:id/basketButton")
    private MobileElement cartButton;

    @AndroidFindBy(id = "com.pictime.nocibe:id/basket_navigation")
    private MobileElement cartIcon;

    @AndroidFindBy(id = "com.pictime.nocibe:id/wishlist_navigation")
    private MobileElement wishIcon;

    @AndroidFindBy(id = "com.pictime.nocibe:id/product_name_row_id")
    private MobileElement productInfoFrame;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<MobileElement> textView;

    @AndroidFindBy(id= "com.pictime.nocibe:id/addedText")
    private MobileElement alert;

    @AndroidFindBy(xpath = ".//android.widget.Button[@text='VALIDER VOTRE PANIER']")
    private MobileElement acceptCart;

    @AndroidFindBy(xpath = ".//android.widget.Button[@text='VALIDER LA LIVRAISON']")
    private MobileElement deliveryButton;

    @AndroidFindBy(xpath = ".//android.widget.TextView[@text='Ajouter au panier']")
    private MobileElement addCartButton;

    private String initContain = "";

    public void goToCartPage(){
        addToCart();
        click(cartButton);
        initContain = cartIcon.getAttribute("content-desc");
    }

    public void addToCart(){
        shortWaitUntil(visibilityOf(productInfoFrame));
        click(addCartButton);
    }

    public void cartItemOperation(String action){
        if(action.equals("-")){
            actOnElementList(cartModificator,"+");
            click(cartIcon);
            initContain = cartIcon.getAttribute("content-desc");
        }
        actOnElementList(cartModificator,action);
    }

    public boolean verifyContainUnchanged(){
        click(cartIcon);
        return cartIcon.getAttribute("content-desc").equals(initContain);
    }

    public void validateCart(){
        click(acceptCart);
    }

    public boolean verifyAddToCart(){
        return alert.isDisplayed();
    }

    public boolean verifyDeliveryPage(){
        validateCart();
        shortWaitUntil(visibilityOf(deliveryButton));
        return deliveryButton.isDisplayed();
    }

}
