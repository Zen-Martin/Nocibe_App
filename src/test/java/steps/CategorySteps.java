package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.CategoryPage;

public class CategorySteps {

    private CategoryPage categoryPage;

    public CategorySteps(CategoryPage categoryPage) {
        this.categoryPage = categoryPage;
    }

    @And("User look at {string} {string} {string}")
    public void foundSubCategories(String sub_1, String sub_2, String sub_3) {
        categoryPage.findElement(sub_1);
        categoryPage.findElement(sub_2);
        categoryPage.findElement(sub_3);
    }

    @Then("User should see these category")
    public void verifyTheseCategory() {
        Assert.assertEquals(categoryPage.verifyElementFound(),true);
    }


}
