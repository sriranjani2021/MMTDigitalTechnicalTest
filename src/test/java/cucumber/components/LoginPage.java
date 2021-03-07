package cucumber.components;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    public WebElementFacade userName;

    @FindBy(id = "password")
    public WebElementFacade password;

    @FindBy(id = "login-button")
    public WebElementFacade loginButton;

    @FindBy(tagName = "h3")
    public WebElementFacade errorMessage;

}
