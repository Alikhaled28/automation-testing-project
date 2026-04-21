package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CoursesPage;
import pages.LoginPage;
import utils.ConfigReader;
import java.time.Duration;

public class E2ETest extends BaseTest {

    private WebDriverWait wait;

    @Test(description = "TC07 - End to End: Login and enroll in a course")
    @Description("Login with valid credentials, go to courses, enroll, and assert course added")
    public void testEndToEnd() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        loginWithValidCredentials();
        navigateToAllCourses();
        enrollInFirstCourse();
        assertCourseAdded();
    }

    @Step("Login with valid credentials from config")
    private void loginWithValidCredentials() {
        driver.get("https://eyouthlearning.com/en/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("valid.email"), ConfigReader.get("valid.password"));
        wait.until(ExpectedConditions.urlContains("home"));
    }

    @Step("Navigate to All Courses page")
    private void navigateToAllCourses() {
        driver.get("https://eyouthlearning.com/en/courses");
    }

    @Step("Enroll in the first available course")
    private void enrollInFirstCourse() {
        CoursesPage coursesPage = new CoursesPage(driver);
        coursesPage.clickSubscribeOnFirstCourse();
    }

    @Step("Assert course was added successfully")
    private void assertCourseAdded() {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("my-learning"),
                ExpectedConditions.urlContains("cart"),
                ExpectedConditions.urlContains("checkout"),
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Enrolled') or contains(text(),'Go to course') or contains(text(),'Already enrolled')]"))
        ));
        String url = driver.getCurrentUrl();
        String source = driver.getPageSource();
        Assert.assertTrue(
                url.contains("my-learning") ||
                        url.contains("cart") ||
                        url.contains("checkout") ||
                        source.contains("Enrolled") ||
                        source.contains("Go to course") ||
                        source.contains("Already enrolled"),
                "Course should be added to user account"
        );
    }
}