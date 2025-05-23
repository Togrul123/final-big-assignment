package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class StaticPage extends BasePage {

    private By myAccountHeader = By.xpath("//h1[@class='heading1']/span[@class='maintext']");

    public StaticPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMyAccountHeaderVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountHeader));
            System.out.println("Found MY ACCOUNT header: " + header.getText());
            return header.isDisplayed();
        } catch (Exception e) {
            System.err.println("Failed to find MY ACCOUNT header: " + e.getMessage());

            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Files.copy(screenshot.toPath(), Paths.get("my_account_header_failure.png"));
                Files.writeString(Paths.get("page_source_failure.html"), driver.getPageSource());
                System.out.println("Saved screenshot and page source on failure");
            } catch (IOException ioException) {
                System.err.println("Error saving screenshot or page source: " + ioException.getMessage());
            }

            return false;
        }
    }
}
