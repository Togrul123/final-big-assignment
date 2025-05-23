package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HistoryTest extends BaseTest {

    @Test
    public void testBrowserBackButton() {
        driver.get("https://automationteststore.com/");
        String homeTitle = driver.getTitle();

        driver.navigate().to("https://automationteststore.com/index.php?rt=account/login");

        driver.navigate().back();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(homeTitle));

        Assertions.assertEquals(homeTitle, driver.getTitle(), "Back navigation did not return to homepage");
    }
}
