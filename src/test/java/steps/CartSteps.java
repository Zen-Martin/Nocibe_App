package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.CartPage;

public class CartSteps {

    private CartPage cartPage;

    public CartSteps(CartPage cartPage) {
        this.cartPage = cartPage;
    }

    @Given("User go to cart page")
    public void cartPage() {
        cartPage.goToCartPage();
    }

    @When("User click on adding icon near any contain")
    public void addContain() {
        cartPage.cartItemOperation("+");
    }

    @When("User click on reducing icon near any contain")
    public void reduceContain() {
        cartPage.cartItemOperation("-");
    }

    @When("User click on cross icon near any contain")
    public void deleteContain() {
        cartPage.cartItemOperation("SUPPRIMER");
    }

    @Then("User should see contain quantity change")
    public void increaseQuantity() {
        Assert.assertEquals(cartPage.verifyContainUnchanged(),false);
    }

    @Then("User should see contain disappear")
    public void containDisappear() {
        Assert.assertEquals(cartPage.verifyContainUnchanged(),false);
    }

    @When("User click on button {string}")
    public void userClickOnButton(String arg0) {
        cartPage.addToCart();
    }

    @Then("User should see message about product add on cart")
    public void productAddOnCart() {
        Assert.assertEquals(cartPage.verifyAddToCart(),true);
    }

    @When("User click button {string}")
    public void userClickButton(String arg0) {
        cartPage.validateCart();
    }

    @Then("User should see payment page")
    public void paymentPage() {
        Assert.assertEquals(cartPage.verifyDeliveryPage(),true);
    }

}
