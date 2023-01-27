package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class RegisterPage extends Throwable {
    private final String REGISTER_PAGE = "https://stellarburgers.nomoreparties.site/register";
    private final By nameInputField = By.xpath("//label[text()='Имя']/../input");
    private final By emailInputField = By.xpath("//label[text()='Email']/../input");
    private final By passwordInputField = By.xpath("//label[text()='Пароль']/../input");
    private final By  buttonRegister = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By errorMessage = By.xpath(".//p[text()='Некорректный пароль']");
    private final By linkEnter = By.xpath(".//a[text()='Войти']");
    private final By buttonPersonalAccount= By.xpath(".//p[text()='Личный Кабинет']");
    private final WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openRegisterPage() {
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
    public void clickLinkEnter() {
        driver.findElement(linkEnter).click();
    }
    public void clickButtonPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }

    public void goToPersonalAccountPage() {
        openRegisterPage();
        clickButtonPersonalAccount();
    }
    public void stepsRegistration(String name, String email, String password) {
        openRegisterPage();
        fillingFieldsRegisterPage(name, email, password);
        clickButtonRegister();

    }
}
