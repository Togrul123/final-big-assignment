package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        driver.get("https://automationteststore.com/index.php?rt=account/login");

        driver.findElement(By.id("loginFrm_loginname")).sendKeys("Toghrul");
        driver.findElement(By.id("loginFrm_password")).sendKeys("3031505tT");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Login']")));
        loginBtn.click();

        System.out.println("Current URL after login: " + driver.getCurrentUrl());

        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Logoff")));
        assertTrue(logoutLink.isDisplayed(), "Logout link should be visible after login");

        logoutLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'maintext') and contains(normalize-space(.), 'Account Logout')]")));

        String pageTitle = driver.getTitle();
        System.out.println("Page title after logout: " + pageTitle);
        assertTrue(pageTitle.contains("Account Logout"), "Page title should contain 'Account Logout' after logout.");

        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-default.mr10[title='Continue']")));

        System.out.println("Clicking Continue button via JavaScript...");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn);

        wait.until(ExpectedConditions.urlToBe("https://automationteststore.com/"));
        System.out.println("Navigation to home page confirmed.");
    }
}
