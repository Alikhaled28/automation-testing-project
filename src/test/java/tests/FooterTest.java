package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FooterPage;

public class FooterTest extends BaseTest {

    @Test(description = "TC08 - Verify Facebook link")
    @Description("Click Facebook icon in footer and verify URL contains facebook.com")
    public void testFacebookLink() {
        FooterPage footerPage = new FooterPage(driver);
        footerPage.scrollToFooter();
        footerPage.waitForFooterIcons();
        footerPage.clickFacebook();
        Assert.assertTrue(footerPage.getNewTabUrl().contains("facebook.com"),
                "URL should contain facebook.com");
    }

    @Test(description = "TC09 - Verify LinkedIn link")
    @Description("Click LinkedIn icon in footer and verify URL contains linkedin.com")
    public void testLinkedInLink() {
        FooterPage footerPage = new FooterPage(driver);
        footerPage.scrollToFooter();
        footerPage.waitForFooterIcons();
        footerPage.clickLinkedIn();
        Assert.assertTrue(footerPage.getNewTabUrl().contains("linkedin.com"),
                "URL should contain linkedin.com");
    }

    @Test(description = "TC10 - Verify Instagram link")
    @Description("Click Instagram icon in footer and verify URL contains instagram.com")
    public void testInstagramLink() {
        FooterPage footerPage = new FooterPage(driver);
        footerPage.scrollToFooter();
        footerPage.waitForFooterIcons();
        footerPage.clickInstagram();
        Assert.assertTrue(footerPage.getNewTabUrl().contains("instagram.com"),
                "URL should contain instagram.com");
    }
}