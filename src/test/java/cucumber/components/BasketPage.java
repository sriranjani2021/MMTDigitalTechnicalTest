package cucumber.components;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class BasketPage extends PageObject {

    @FindBy(className = "cart_button")
    public List<WebElementFacade> cartRemoveButton;

}
