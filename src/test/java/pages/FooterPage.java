package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;

public class FooterPage extends BasePage {

    @FindBy(css = "a[href*='facebook']")
    private WebElement facebookIcon;

    @FindBy(css = "a[href*='linkedin']")
    private WebElement linkedinIcon;

    @FindBy(css = "a[href*='instagram']")
    private WebElement instagramIcon;

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    public void scrollToFooter() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void waitForFooterIcons() {
        wait.until(ExpectedConditions.visibilityOf(facebookIcon));
    }

    public void clickFacebook() {
        jsClick(facebookIcon);
    }

    public void clickLinkedIn() {
        jsClick(linkedinIcon);
    }

    public void clickInstagram() {
        jsClick(instagramIcon);
    }

    public String getNewTabUrl() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return driver.getCurrentUrl();
    }
}