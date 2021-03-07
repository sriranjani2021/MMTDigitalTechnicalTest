package cucumber.methods;

import cucumber.components.LoginPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginMethods extends PageObject {

    LoginPage loginPage;
    @Step
    public void navigateToLoginPage()
    {
        open();
        getDriver().manage().window().maximize();
    }

    @Step
    public void clickLoginButton()
    {
        loginPage.loginButton.click();
    }

    @Step
    public void verifyErrorMessage(String error)
    {
        Assert.assertEquals(error,loginPage.errorMessage.getText());
    }

    @Step
    public void enterUsername(String username)
    {
        loginPage.userName.sendKeys(username);
    }

    @Step
    public void enterPassword(String password)
    {
        loginPage.password.sendKeys(password);
    }

    @Step
    public void setFocusOnUsername()
    {
        loginPage.userName.setWindowFocus();
    }

    @Step
    public void enterUsernameAndTab(String username)
    {
        loginPage.userName.typeAndTab(username);
    }

    @Step
    public void checkFocusOnPassword()
    {
        Assert.assertTrue(loginPage.password.hasFocus());
    }

    @Step
    public void enterPasswordAndTab(String password)
    {
        loginPage.password.typeAndTab(password);
    }

    @Step
    public void checkFocusOnLoginButton()
    {
        Assert.assertTrue(loginPage.loginButton.hasFocus());
    }

    @Step
    public void pressEnter()
    {
        loginPage.loginButton.sendKeys(Keys.ENTER);
    }

}
