package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordRecoveryPage {
    private final By linkEnter = By.xpath(".//a[text()='Войти']");
    private final WebDriver driver;
    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLinkEnter() {
        waitingForElement(linkEnter);
        driver.findElement(linkEnter).click();
    }
    public void waitingForElement(By byXpath) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(byXpath));
    }
}
