package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class RegisterPage {
    private final String REGISTER_PAGE = "https://stellarburgers.nomoreparties.site/register";
    private By nameInputField = By.xpath("//label[text()='Имя']/../input");
    private By emailInputField = By.xpath("//label[text()='Email']/../input");
    private By passwordInputField = By.xpath("//label[text()='Пароль']/../input");
    private By  buttonRegister = By.xpath(".//button[text()='Зарегистрироваться']");
    private By errorMessage = By.xpath(".//p[text()='Некорректный пароль']");
    private WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openPage() {
        driver.get(REGISTER_PAGE);
    }
    public void fillingFieldsRegisterPage(String name, String email, String password) {
        sendNameInput(name);
        sendEmailInput(email);
        sendPasswordInput(password);
    }
    public void sendNameInput(String name) {
        driver.findElement(nameInputField).sendKeys(name);
    }
    public void sendEmailInput(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }
    public void sendPasswordInput(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }
    public void clickButtonRegister() {
        driver.findElement(buttonRegister).click();
    }
    public static String generateString() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    public void waitErrorMessage(String textExpected) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.textToBePresentInElementLocated(errorMessage, textExpected));
    }
}
