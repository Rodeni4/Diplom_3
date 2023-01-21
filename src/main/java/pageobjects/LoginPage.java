package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final By emailInputField = By.xpath("//label[text()='Email']/../input");
    private final By passwordInputField = By.xpath("//label[text()='Пароль']/../input");
    private final By buttonEnter = By.xpath(".//button[text()='Войти']");
    private final By linkPasswordRecovery = By.xpath(".//a[text()='Восстановить пароль']");
    private final By textButton = By.xpath((".//button[text()='Войти']"));
    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillingFieldsLoginPage(String email, String password) {
        waitingForElement(buttonEnter);
        sendEmailInput(email);
        sendPasswordInput(password);
    }
    public void sendEmailInput(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }
    public void sendPasswordInput(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }
    public void waitingForElement(By byXpath) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(byXpath));
    }
    public void clickButtonEnter() {
        driver.findElement(buttonEnter).click();
    }
    public void clickLinkPasswordRecovery()  {
        waitingForElement(linkPasswordRecovery);
        driver.findElement(linkPasswordRecovery).click();
    }

    public void waitingTextButton(String textExpected) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.textToBePresentInElementLocated(textButton, textExpected));
    }
}
