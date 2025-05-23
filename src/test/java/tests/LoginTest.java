package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        driver.get("https://automationteststore.com/index.php?rt=account/login");

        driver.findElement(By.id("loginFrm_loginname")).sendKeys("Toghrul");
        driver.findElement(By.id("loginFrm_password")).sendKeys("3031505tT");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Login']")));
        loginBtn.click();

        String pageTitle = driver.getTitle();
        System.out.println("Page title after login: " + pageTitle);
        assertTrue(pageTitle.contains("Account"), "Page title should contain 'Account' after login.");

    }
}
