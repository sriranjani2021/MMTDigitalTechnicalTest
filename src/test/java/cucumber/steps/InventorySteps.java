package cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.methods.InventoryMethods;
import net.thucydides.core.annotations.Steps;

public class InventorySteps {

    @Steps
    InventoryMethods inventoryMethods;

    @Given("^that I am on the inventory shop page with an empty basket$")
    public void thatIAmOnTheInventoryShopPageWithAnEmptyBasket() {
        inventoryMethods.verifyBasketIsEmpty();
    }

    @When("^I click Add to cart on a product$")
    public void iClickAddToCartOnAProduct() {
        inventoryMethods.addAProductToCart();
    }

    @And("^it creates a counter on the basket icon with the value \"([^\"]*)\" in it$")
    public void itCreatesACounterOnTheBasketIconWithTheValueInIt(String value)  {
        inventoryMethods.checkCounterIncreased(value);
    }

    @Given("^that I am on the inventory page with (\\d+) item in basket$")
    public void thatIAmOnTheInventoryPageWithItemInBasket(int item) {
        inventoryMethods.pageWithItemsInBasket(item);
    }

    @Then("^the basket counter is incremented by (\\d+)$")
    public void theBasketCounterIsIncrementedBy(int value) {
        inventoryMethods.checkCounterValueIncreasedByValue(value);
    }

    @When("^I Add one more product to the cart$")
    public void iAddOneMoreProductToTheCart() {
        inventoryMethods.findCurrentCountAndAddOneMoreToCart();
    }


    @When("^I click Remove on an item I have in my basket$")
    public void iClickRemoveOnAnItemIHaveInMyBasket() {
        inventoryMethods.removeItemFromBasket();
    }

    @And("^the basket counter value is decreased by (\\d+)$")
    public void theBasketCounterValueIsDecreasedBy(int value) {
        inventoryMethods.checkCounterValueDecreasedByValue(value);
    }

    @Then("^it will change the ADD TO CART button to a REMOVE button$")
    public void itWillChangeTheADDTOCARTButtonToAREMOVEButton() {
        inventoryMethods.checkTextChangedFromAddToRemove();
    }

    @Then("^it will change the REMOVE button to a ADD TO CART button$")
    public void itWillChangeTheREMOVEButtonToAADDTOCARTButton() {
        inventoryMethods.checkTextChangedFromRemoveToAdd();
    }
}
