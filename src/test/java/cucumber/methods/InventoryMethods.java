package cucumber.methods;

import cucumber.components.InventoryPage;
import jnr.ffi.annotations.In;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class InventoryMethods {

    InventoryPage inventoryPage;
    int previousCounterValue;

    @Step
    public void verifyCurrentUrl(String url)
    {
        String title = getDriver().getCurrentUrl();
       Assert.assertEquals(true,title.contains(url));
    }

    @Step
    public void verifyBasketIsEmpty()
    {
        inventoryPage.productCounter.shouldNotBeCurrentlyVisible();
    }

    @Step
    public void addAProductToCart()
    {
        inventoryPage.addToCartAndRemoveButton.get(0).shouldBeCurrentlyVisible();
        Assert.assertEquals("ADD TO CART",inventoryPage.addToCartAndRemoveButton.get(0).getText());
       inventoryPage.addToCartAndRemoveButton.get(0).click();
       Serenity.setSessionVariable("currentCounterValue").to("1");
    }

    @Step
    public void checkTextChangedFromAddToRemove( )
    {
        int currentValue = Integer.parseInt(Serenity.sessionVariableCalled("currentCounterValue").toString());
        inventoryPage.addToCartAndRemoveButton.get(currentValue-1).shouldBeCurrentlyVisible();
        Assert.assertEquals("REMOVE",inventoryPage.addToCartAndRemoveButton.get(currentValue-1).getText());

    }


    @Step
    public void checkTextChangedFromRemoveToAdd( )
    {
        int currentValue = Integer.parseInt(Serenity.sessionVariableCalled("currentCounterValue").toString());
        inventoryPage.addToCartAndRemoveButton.get(currentValue).shouldBeCurrentlyVisible();
        Assert.assertEquals("ADD TO CART",inventoryPage.addToCartAndRemoveButton.get(currentValue).getText());

    }
    @Step
    public void findCurrentCountAndAddOneMoreToCart() {
        previousCounterValue = Integer.parseInt(Serenity.sessionVariableCalled("currentCounterValue").toString());
        inventoryPage.addToCartAndRemoveButton.get(previousCounterValue).click();
    }

    @Step
    public void checkCounterIncreased(String value)
    {
        Assert.assertTrue(inventoryPage.productCounter.isVisible());
        Assert.assertEquals(value,inventoryPage.productCounter.getText());
    }

    @Step
    public void pageWithItemsInBasket(int item)
    {
        int i = 0;
        while(item!=0)
        {
            inventoryPage.addToCartAndRemoveButton.get(i).click();
            i++;
            item--;
        }
        Serenity.setSessionVariable("currentCounterValue").to(inventoryPage.productCounter.getText());
    }
    @Step
    public void checkCounterValueIncreasedByValue(int value)
    {

        previousCounterValue = Integer.parseInt(Serenity.sessionVariableCalled("currentCounterValue").toString());
        Assert.assertEquals(previousCounterValue + value , Integer.parseInt(inventoryPage.productCounter.getText()));
    }

    @Step
    public void removeItemFromBasket()
    {
        previousCounterValue = Integer.parseInt(Serenity.sessionVariableCalled("currentCounterValue").toString());
        inventoryPage.addToCartAndRemoveButton.get(previousCounterValue-1).click();
        Serenity.setSessionVariable("currentCounterValue").to(inventoryPage.productCounter.getText());
    }

    @Step
    public void checkCounterValueDecreasedByValue(int value)
    {

        Assert.assertEquals(previousCounterValue-value,Integer.parseInt(inventoryPage.productCounter.getText()));
    }



}
