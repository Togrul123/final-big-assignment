package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class ComplexXPathTest extends BaseTest {

    @Test
    public void testComplexXPathExample() {
        driver.get("https://automationteststore.com/");

        List<WebElement> links = driver.findElements(By.xpath("//div//a[@href]"));
        Assertions.assertFalse(links.isEmpty(), "No links found with complex XPath");

        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));
        }
    }
}
