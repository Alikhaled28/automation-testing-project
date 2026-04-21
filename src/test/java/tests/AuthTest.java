package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

public class AuthTest extends BaseTest {

    @Test(description = "TC03 - Open registration page")
    @Description("Navigate to register page and assert URL contains /register")
    public void testOpenRegistrationPage() {
        driver.get("https://eyouthlearning.com/en/auth/register");
        Assert.assertTrue(driver.getCurrentUrl().contains("register"),
                "URL should contain: /register");
    }

    @Test(description = "TC04 - Register with empty name")
    @Description("Submit register form without name and assert validation error")
    public void testRegisterEmptyName() {
        driver.get("https://eyouthlearning.com/en/auth/register");
        RegisterPage registerPage = new RegisterPage(driver);
        fillFormWithoutName(registerPage);
        Assert.assertTrue(registerPage.getNameError().contains("Name is required"),
                "Should show name required error");
    }

    @Test(description = "TC05 - Login with invalid credentials")
    @Description("Enter wrong credentials and assert error message is shown")
    public void testLoginInvalidCredentials() {
        driver.get("https://eyouthlearning.com/en/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        loginWithInvalidData(loginPage);
        Assert.assertFalse(loginPage.getErrorMessage().isEmpty(),
                "Error message should be displayed");
    }

    @Test(description = "TC06 - Login with empty fields")
    @Description("Click login without entering anything and assert validation messages")
    public void testLoginEmptyFields() {
        driver.get("https://eyouthlearning.com/en/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginEmpty();
        Assert.assertFalse(loginPage.getErrorMessage().isEmpty(),
                "Validation message should appear");
    }

    @Step("Assert URL contains '{path}'")
    private void assertUrlContains(String path) {
        Assert.assertTrue(driver.getCurrentUrl().contains(path),
                "URL should contain: " + path);
    }

    @Step("Fill form without name and submit")
    private void fillFormWithoutName(RegisterPage registerPage) {
        registerPage.fillFormWithoutName("test@test.com", "Test@1234");
    }

    @Step("Login with invalid username and password")
    private void loginWithInvalidData(LoginPage loginPage) {
        loginPage.login("wrong@test.com", "WrongPass123");
    }
}