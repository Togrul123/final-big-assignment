package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaticPageTest extends BaseTest {

    @Test
    public void testStaticPageLoads() {
        driver.get("https://automationteststore.com/index.php?rt=content/content&content_id=4");

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page source snippet: " + driver.getPageSource().substring(0, 500));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement pageHeading = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.cssSelector(".maintext")));

        assertTrue(pageHeading.isDisplayed(), "Static page heading should be visible");
        System.out.println("Static page loaded successfully.");
    }
}
