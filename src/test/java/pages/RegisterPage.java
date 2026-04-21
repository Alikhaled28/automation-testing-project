package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement createButton;

    @FindBy(css = "p.text-\\[red\\]")
    private WebElement nameError;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void fillFormWithoutName(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        jsClick(createButton);
    }

    public String getNameError() {
        return waitForVisibility(nameError).getText();
    }
}