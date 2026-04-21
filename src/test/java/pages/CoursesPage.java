package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class CoursesPage extends BasePage {

    @FindBy(css = "div.border-light-blue")
    private List<WebElement> courseCards;

    @FindBy(css = "div.border-light-blue img")
    private List<WebElement> courseImages;

    @FindBy(css = "div.border-light-blue h3")
    private List<WebElement> courseTitles;

    @FindBy(css = "div.border-light-blue h6")
    private List<WebElement> instructorNames;

    @FindBy(css = "div.border-light-blue button.bg-mainBlue")
    private List<WebElement> subscribeButtons;

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    public void clickFirstCourse() {
        wait.until(ExpectedConditions.visibilityOfAllElements(courseCards));
        courseCards.get(0).click();
    }

    public boolean isCourseImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(courseCards));
        wait.until(ExpectedConditions.visibilityOfAllElements(courseImages));
        return !courseImages.isEmpty() && courseImages.get(0).isDisplayed();
    }

    public boolean isCourseTitleDisplayed() {
        return !courseTitles.isEmpty() && courseTitles.get(0).isDisplayed();
    }

    public boolean isInstructorNameDisplayed() {
        return !instructorNames.isEmpty() && instructorNames.get(0).isDisplayed();
    }

    public boolean isSubscribeButtonDisplayed() {
        return !subscribeButtons.isEmpty() && subscribeButtons.get(0).isDisplayed();
    }

    public void clickSubscribeOnFirstCourse() {
        wait.until(ExpectedConditions.visibilityOfAllElements(subscribeButtons));
        jsClick(subscribeButtons.get(0));
    }
}