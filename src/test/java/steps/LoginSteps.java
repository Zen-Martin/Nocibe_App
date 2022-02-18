package steps;

import io.cucumber.java.en.Given;
import pageObjects.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("User get logged")
    public void userGetLogged() {
        loginPage.getLogged();
    }
}
