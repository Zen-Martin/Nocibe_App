package steps;

import io.cucumber.java.en.And;
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

    @And("User select product {string}")
    public void userSelectProductOption(String product_option) {
        productPage.filterOption(product_option);
    }

    @Then("User should see product result decrease")
    public void productResultDecreased() {
        productPage.submitFilter();
        Assert.assertEquals(productPage.verifyFilterOption(),true);
    }

    @Then("User should see filter active")
    public void filterActived() {
        Assert.assertEquals(productPage.verifyFilterActivation(),true);
    }

    @When("User select again product {string}")
    public void userSelectAgainProduct(String product_option) {
        productPage.filterOption(product_option);
    }

    @Then("User should see filter disappear")
    public void filterDisappear() {
        Assert.assertEquals(productPage.verifyFilterActivation(),false);
    }

    @And("User click on re-initialise button")
    public void reInitialiseFilter() {
        productPage.resetFilter();
    }

    @Then("User should see default product result display")
    public void defaultProductResultDisplay() {
        productPage.submitFilter();
        Assert.assertEquals(productPage.verifyFilterOption(),false);
    }


}
