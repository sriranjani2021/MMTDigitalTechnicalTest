package cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.methods.InventoryMethods;
import cucumber.methods.LoginMethods;
import net.thucydides.core.annotations.Steps;

public class LoginSteps {

    @Steps
    LoginMethods loginMethods;

    @Steps
    InventoryMethods inventoryMethods;


    @Given("^that I am on the login page$")
    public void thatIAmOnTheLoginPage() {
        loginMethods.navigateToLoginPage();
    }


    @Then("^an error will be thrown below the form stating \"([^\"]*)\"$")
    public void anErrorWillBeThrownBelowTheFormStating(String error) {
        loginMethods.verifyErrorMessage(error);
    }



    @When("^I click Login$")
    public void iClickLogin() {
        loginMethods.clickLoginButton();
    }

    @And("^I have entered \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iHaveEnteredAnd(String username, String password) {
        loginMethods.enterUsername(username);
        loginMethods.enterPassword(password);

    }

    @Then("^the user will be navigated to the \"([^\"]*)\" page$")
    public void theUserWillBeNavigatedToThePage(String url) {
        inventoryMethods.verifyCurrentUrl(url);
    }


    @Given("^that I am currently focused on the username field$")
    public void thatIAmCurrentlyFocusedOnTheUsernameField() {
        loginMethods.setFocusOnUsername();
    }

    @When("^I enter valid username as \"([^\"]*)\" and hit tab$")
    public void iEnterValidUsernameAsAndHitTab(String username) {
        loginMethods.enterUsernameAndTab(username);
    }

    @Then("^the current focus will be on password field$")
    public void theCurrentFocusWillBeOnPasswordField() {
        loginMethods.checkFocusOnPassword();
    }

    @When("^I enter valid password as \"([^\"]*)\" and hit tab$")
    public void iEnterValidPasswordAsAndHitTab(String password) {
        loginMethods.enterPasswordAndTab(password);
    }

    @Then("^the current focus will be on login button$")
    public void theCurrentFocusWillBeOnLoginButton() {
        loginMethods.checkFocusOnLoginButton();
    }

    @And("^When I press the enter button$")
    public void whenIPressTheEnterButton() {
        loginMethods.pressEnter();
    }
}
