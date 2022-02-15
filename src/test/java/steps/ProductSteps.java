package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.ProductPage;

public class ProductSteps {

    private ProductPage productPage;

    public ProductSteps(ProductPage productPage) {
        this.productPage = productPage;
    }

    @Given("User is on product page")
    public void userIsOnProductPage() {
        productPage.seeProduct();
    }


    @When("User select a product")
    public void userSelectAProduct() {
        productPage.selectProduct();
    }

    @Then("User should be able to see choosen product info")
    public void verifyProductInfoCard() {
        productPage.verifyCardProduct();
    }

    @When("User select sort by {string}")
    public void userSelectSortBy(String option) {
        productPage.sortValue(option);
    }

    @Then("User should see effective sort by operation")
    public void verifySortByOperation() {
        Assert.assertEquals(productPage.priceFilterIncrease(),true);
    }
}
