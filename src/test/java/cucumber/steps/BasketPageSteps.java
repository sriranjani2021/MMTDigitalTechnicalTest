package cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.methods.BasketPageMethods;
import net.thucydides.core.annotations.Steps;

public class BasketPageSteps {

    @Steps
    BasketPageMethods basketPageMethods;

    @When("^I visit the basket page$")
    public void iVisitTheBasketPage() {
        basketPageMethods.navigateToBasketPage();
    }

    @Then("^I can see options to remove each product present from the basket$")
    public void iCanSeeOptionsToRemoveEachProductPresentFromTheBasket() {
        basketPageMethods.checkItemsCanBeRemovedFromCart();
    }

    @And("^I remove (\\d+) item from the basket$")
    public void iRemoveItemFromTheBasket(int value) {
        basketPageMethods.removeProductsFromBasket(value);
    }

    @Then("^the basket counter value is decreased by (\\d+) in Basket Page$")
    public void theBasketCounterValueIsDecreasedByInBasketPage(int value) {
        basketPageMethods.checkBasketCounterDecreasedByValue(value);
    }

    @Then("^the item is removed from basket$")
    public void theItemIsRemovedFromBasket() {
        basketPageMethods.verifyBasketPageIsEmpty();
    }

    @And("^the basket counter icon is disappeared$")
    public void theBasketCounterIconIsDisappeared() {
        basketPageMethods.verifyBasketCounterIconIsRemoved();
    }
}
