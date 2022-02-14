package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.HomePage;

public class HomeSteps {


    private HomePage homePage;

    public HomeSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        homePage.waitForAppLoading();
    }

    @Given("User is on search bar")
    public void userIsOnSearchBar() {
        homePage.clickOnSearchBar();
    }

    @When("User enter a {string} in search bar")
    public void userEnterProductFind(String element) { homePage.makeSearch(element);}

    @And("User validate his choice")
    public void userValidateHisChoice() {
        homePage.launch();
    }

    @Then("User should see message about choosen product results number")
    public void resultsFoundNumber() {
        Assert.assertEquals(homePage.verifyFoundResult(),true);
    }

    @Then("User should see suggestions appear")
    public void suggestionsAppear() {
        Assert.assertEquals(homePage.verifySuggestions(),true);
    }

    @Then("User should see message about no result found")
    public void noResultFound() { Assert.assertEquals(homePage.verifyNotFoundResult(),true);}

    @Given("User is on category menu")
    public void categoryMenuPage() { homePage.getOnCategory();}

    @Given("User is on selected {string}")
    public void selectCategory(String category) {
        homePage.selectCategory(category);
    }

    @When("User selected {string}")
    public void selectSubCategory(String subcategory) {
        homePage.selectSubcategory(subcategory);
    }

    @Then("User should see {string} title display")
    public void titleOfDisplay(String title) {
        Assert.assertEquals(homePage.verifyViewTitle(title),true);
    }

    @When("User enter a {string}")
    public void parfumProductPage(String element) { homePage.makeSearch(element);}



}
