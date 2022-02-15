package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CartPage extends Page{

    private static final Logger LOG = LogManager.getLogger(CartPage.class);

    @AndroidFindBy(className = "android.widget.Button")
    private List<MobileElement> cartModificator;

    @AndroidFindBy(id = "com.pictime.nocibe:id/emptyViewTitle")
    private MobileElement notFoundInfo;

    @AndroidFindBy(id = "com.pictime.nocibe:id/item_home_top_category")
    private MobileElement navMenuOption;

    public void modifyContain(String element){
        for(int i=0; i<cartModificator.size(); i++){
            if(cartModificator.get(i).getText().equals(element)){
                click(cartModificator.get(i));
                break;
            }
        }
    }

    private int found = 0;

}
