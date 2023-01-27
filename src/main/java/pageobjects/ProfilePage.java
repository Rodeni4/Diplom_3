package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private final By textProfile = By.xpath(".//a[text()='Профиль']");
    private final By buttonConstructor = By.xpath(".//p[text()='Конструктор']");
    private final By logoStellarBurgers = By.className("AppHeader_header__logo__2D0X2");
    private final By buttonLogout = By.xpath(".//button[text()='Выход']");
    private final WebDriver driver;

    public  ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitingTextProfile(String textExpected) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.textToBePresentInElementLocated(textProfile, textExpected));
    }
    public void clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }
    public void clickLogo() {
        driver.findElement(logoStellarBurgers).click();
    }
    public void clickLogout() {
        waitingForElement(buttonLogout);
        driver.findElement(buttonLogout).click();
    }
    public void waitingForElement(By byXpath) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(byXpath));
    }

}
