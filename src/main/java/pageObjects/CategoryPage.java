package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class CategoryPage extends Page{

    private static final Logger LOG = LogManager.getLogger(CategoryPage.class);

    @AndroidFindBy(className = "android.widget.TextView")
    private List<MobileElement> textView;

    private int found = 0;

    public boolean verifyElementFound(){
        return found==3;
    }

    public int findElement(String element){
        for (int i = 0; i < textView.size(); i++) {
            if (textView.get(i).getText().equals(element)) {
                scroll(textView.get(i).getText());
                found++;
                break;
            }
        }
        return found;
    }





}
