package cucumber.components;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class InventoryPage extends PageObject {

    @FindBy(className = "inventory_item")
    public List<WebElementFacade> inventoryItems;

    @FindBy(className = "btn_inventory")
    public List<WebElementFacade> addToCartAndRemoveButton;

        @FindBy(className = "shopping_cart_badge")
    public WebElementFacade productCounter;
}
