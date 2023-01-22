package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final String INDEX_PAGE = "https://stellarburgers.nomoreparties.site/";
    private final By buttonPersonalAccount= By.xpath(".//p[text()='Личный Кабинет']");
    private final By textButton = By.xpath((".//button[text()='Оформить заказ']"));
    private final By buttonLogin = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By linkActive = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc')]");
    private final By linkSauces = By.xpath(".//span[text()='Соусы']");
    private final By linkFillings = By.xpath(".//span[text()='Начинки']");
    private final By linkBreads = By.xpath(".//span[text()='Булки']");
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButtonPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }
    public void openMainPage() {
        driver.get(INDEX_PAGE);
    }
    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }
    public void waitingTextButton(String textExpected) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.textToBePresentInElementLocated(textButton, textExpected));
    }
    public void goToPersonalAccountPage() {
        openMainPage();
        clickButtonPersonalAccount();
    }
    public void clickLinkSauces() {
        driver.findElement(linkSauces).click();
    }
    public void clickLinkFillings() {
        driver.findElement(linkFillings).click();
    }
    public void clickLinkBreads() {
        driver.findElement(linkBreads).click();
    }
    public void waitingTextLink(String textExpected) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.textToBePresentInElementLocated(linkActive, textExpected));
    }
}
