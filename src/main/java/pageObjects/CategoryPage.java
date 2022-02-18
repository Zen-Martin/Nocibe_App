package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;


public class CategoryPage extends Page{

    @AndroidFindBy(className = "android.widget.TextView")
    private List<MobileElement> textView;

    private int found = 0;

    public boolean verifyElementFound(){
        return found==3;
    }

    public void getElement(String element){
        found = found + findElement(textView,element);
    }
}
