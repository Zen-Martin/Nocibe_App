package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
}
