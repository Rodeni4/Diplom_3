import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.PasswordRecoveryPage;
import pageobjects.RegisterPage;

import static pageobjects.RegisterPage.generateString;

public class LoginTest {
    private String name;
    private String email;
    private String password;
    private String textExpected;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        name = "Name" + generateString();
        email = generateString() + "@yandex.ru";
        password = generateString();
        textExpected = "Оформить заказ";
    }
    private WebDriver driver;

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Вход выполнен, видим кнопку: Оформить заказ")
    public void LoginSuccessfulPressButtonLogin() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.openRegisterPage();
        objRegisterPage.fillingFieldsRegisterPage(name, email, password);
        objRegisterPage.clickButtonRegister();

        MainPage objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
        objMainPage.clickButtonLogin();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillingFieldsLoginPage(email, password);
        objLoginPage.clickButtonEnter();

        objMainPage.waitingTextButton(textExpected);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Вход выполнен, видим кнопку: Оформить заказ")
    public void LoginSuccessfulPressButtonPersonalAccount() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.openRegisterPage();
        objRegisterPage.fillingFieldsRegisterPage(name, email, password);
        objRegisterPage.clickButtonRegister();

        MainPage objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
        objMainPage.clickButtonPersonalAccount();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillingFieldsLoginPage(email, password);
        objLoginPage.clickButtonEnter();

        objMainPage.waitingTextButton(textExpected);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Вход выполнен, видим кнопку: Оформить заказ")
    public void LoginSuccessfulRegistrationFormViaButton() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.openRegisterPage();
        objRegisterPage.fillingFieldsRegisterPage(name, email, password);
        objRegisterPage.clickButtonRegister();

        objRegisterPage.openRegisterPage();
        objRegisterPage.clickLinkEnter();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillingFieldsLoginPage(email, password);
        objLoginPage.clickButtonEnter();

        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitingTextButton(textExpected);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Вход выполнен, видим кнопку: Оформить заказ")
    public void LoginSuccessfulPasswordRecoveryFormViaButton() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.openRegisterPage();
        objRegisterPage.fillingFieldsRegisterPage(name, email, password);
        objRegisterPage.clickButtonRegister();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickLinkPasswordRecovery();

        PasswordRecoveryPage objPasswordRecoveryPage = new PasswordRecoveryPage(driver);
        objPasswordRecoveryPage.clickLinkEnter();

        objLoginPage.fillingFieldsLoginPage(email, password);
        objLoginPage.clickButtonEnter();

        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitingTextButton(textExpected);
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
