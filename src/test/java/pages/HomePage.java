package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By logoutLink = By.xpath("//a[contains(@href, 'logout') and contains(text(), 'Logoff')]");
    private By myAccountLink = By.xpath("//h1[contains(@class, 'heading1') and contains(., 'My Account')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutVisible() {
        try {
            waitForVisibility(logoutLink);
            return driver.findElement(logoutLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogout() {
        click(logoutLink);
    }

    public boolean isMyAccountVisible() {
        try {
            waitForVisibility(myAccountLink);
            return driver.findElement(myAccountLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
