package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class JavaScriptExecutorTest extends BaseTest {

    @Test
    public void testJSExecutorClick() {
        driver.get("https://automationteststore.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href*='account/login']")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginLink);

        wait.until(ExpectedConditions.urlContains("account/login"));

        Assertions.assertTrue(driver.getCurrentUrl().contains("account/login"), "Login page was not loaded after JS click");
    }
}
