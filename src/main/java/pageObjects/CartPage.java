package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CartPage extends Page{

    private static final Logger LOG = LogManager.getLogger(CartPage.class);

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

    private String initContain = "";

    public void goToCartPage(){
        shortWaitUntil(visibilityOf(productInfoFrame));
        actOnElementList(textView,"Ajouter");
        click(cartButton);
        initContain = cartIcon.getAttribute("content-desc");
    }

    public void cartItemOperation(String action){
        if(action.equals("-")){
            actOnElementList(cartModificator,"+");
            click(cartIcon);
            initContain = cartIcon.getAttribute("content-desc");
        }
        actOnElementList(cartModificator,action);
    }

    public void actOnElementList(List<MobileElement> list, String element){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getText().contains(element)){
                click(list.get(i));
                break;
            }
        }
    }

    public boolean verifyContainUnchanged(){
        click(cartIcon);
        return cartIcon.getAttribute("content-desc").equals(initContain);
    }

}
