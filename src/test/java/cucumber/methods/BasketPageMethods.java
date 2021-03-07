package cucumber.methods;

import cucumber.api.java.eo.Se;
import cucumber.components.BasketPage;
import cucumber.components.InventoryPage;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class BasketPageMethods {

    BasketPage basketPage;
    InventoryPage inventoryPage;
    int currentCounterValue;

    public void navigateToBasketPage()
    {
        inventoryPage.productCounter.click();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("cart.html"));
    }

    public void checkItemsCanBeRemovedFromCart()
    {
        currentCounterValue = Integer.parseInt(Serenity.sessionVariableCalled("currentCounterValue").toString());
        while(currentCounterValue!=0)
        {
            currentCounterValue--;
            basketPage.cartRemoveButton.get(currentCounterValue).shouldBeCurrentlyVisible();
           Assert.assertEquals("REMOVE", basketPage.cartRemoveButton.get(currentCounterValue).getText());

        }

    }

    public void removeProductsFromBasket(int value)
    {
        currentCounterValue = Integer.parseInt(Serenity.sessionVariableCalled("currentCounterValue").toString());
        int i = 0;
        while(i!=value)
        {
            currentCounterValue--;
            basketPage.cartRemoveButton.get(currentCounterValue).shouldBeCurrentlyVisible();
            Assert.assertEquals("REMOVE", basketPage.cartRemoveButton.get(currentCounterValue).getText());
            basketPage.cartRemoveButton.get(currentCounterValue).click();
            i++;
        }

    }

    public void checkBasketCounterDecreasedByValue(int value)
    {
        int previousValue = Integer.parseInt(Serenity.sessionVariableCalled("currentCounterValue").toString());
        Assert.assertEquals(previousValue-value,Integer.parseInt(inventoryPage.productCounter.getText()));
    }

    public void verifyBasketPageIsEmpty()
    {
        basketPage.cartRemoveButton.isEmpty();
    }

    public void verifyBasketCounterIconIsRemoved()
    {
        inventoryPage.productCounter.shouldNotBeVisible();
    }
}
