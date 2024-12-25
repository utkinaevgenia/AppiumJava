package lib.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {
    private static final String
    LOGIN_BUTTON = "css:a.cdx-button.cdx-button--fake-button.cdx-button--fake-button--enabled.cdx-button--size-medium.cdx-button--weight-primary.cdx-button--action-progressive > span",
    LOGIN_INPUT= "css:input[name='wpName']",
    PASSWORD_INPUT= "css:input[name='wpPassword']",
    SUBMIT_BUTTON = "css:button#wpLoginAttempt";

    public AuthorizationPageObject (RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Click on the authorization button")
    public void clickAuthButton() {
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot find login button", 20);
        this.waitForElementAndClick(LOGIN_BUTTON,"Cannot find and click login button", 5);
    }

    @Step("Enter login '{login}' and password into the corresponding fields")
    public void enterLoginData(String login, String password) {
        this.waitForElementAndSentValue(LOGIN_INPUT, login, "Cannot find and put login into login input", 20);
        this.waitForElementAndSentValue(PASSWORD_INPUT,password, "Cannot find and put password into password input", 20);
    }

    @Step("Submit the login form")
    public void submitForm() {
        this.waitForElementAndClick(SUBMIT_BUTTON, "Cannot find and click submit button", 20);
    }
}
