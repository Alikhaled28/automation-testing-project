package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "input[type='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//a[contains(@href,'courses') or contains(text(),'Courses') or contains(text(),'الدورات')]")
    private WebElement allCoursesLink;

    @FindBy(xpath = "//a[contains(@href,'register') or contains(text(),'Create Account') or contains(text(),'انضم')]")
    private WebElement registerLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String keyword) {
        click(searchInput);
        type(searchInput, keyword);
    }

    public void clickAllCourses() {
        click(allCoursesLink);
    }

    public void clickRegister() {
        click(registerLink);
    }
}