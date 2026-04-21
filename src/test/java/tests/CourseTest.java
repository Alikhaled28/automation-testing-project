package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CoursesPage;

public class CourseTest extends BaseTest {

    @Test(description = "TC02 - Open course details")
    @Description("Navigate to courses, click a course, and verify details page opens")
    public void testOpenCourseDetails() {
        driver.get("https://eyouthlearning.com/en/courses");
        CoursesPage coursesPage = new CoursesPage(driver);
        clickFirstCourse(coursesPage);
        Assert.assertTrue(driver.getCurrentUrl().contains("courses"),
                "Should navigate to course details page");
        Assert.assertTrue(driver.getPageSource().contains("Overview") ||
                        driver.getPageSource().contains("Course Content"),
                "Course details section should be displayed");
    }

    @Test(description = "TC11 - Verify course card UI elements")
    @Description("Verify course card contains image, title, instructor, and enroll button")
    public void testCourseCardUI() {
        driver.get("https://eyouthlearning.com/en/courses");
        CoursesPage coursesPage = new CoursesPage(driver);
        Assert.assertTrue(coursesPage.isCourseImageDisplayed(), "Course image should be visible");
        Assert.assertTrue(coursesPage.isCourseTitleDisplayed(), "Course title should be visible");
        Assert.assertTrue(coursesPage.isInstructorNameDisplayed(), "Instructor name should be visible");
        Assert.assertTrue(coursesPage.isSubscribeButtonDisplayed(), "Enroll button should be visible");
    }

    @Step("Click on first course card")
    private void clickFirstCourse(CoursesPage coursesPage) {
        coursesPage.clickFirstCourse();
    }
}