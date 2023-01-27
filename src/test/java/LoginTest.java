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
    private final String textExpected = "Оформить заказ";
    private String name;
    private String email;
    private String password;
    private WebDriver driver;
    private MainPage objMainPage;
    private LoginPage objLoginPage;
    private RegisterPage objRegisterPage;
    private PasswordRecoveryPage objPasswordRecoveryPage;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
        objMainPage = new MainPage(driver);
        objLoginPage = new LoginPage(driver);
        objRegisterPage = new RegisterPage(driver);
        objPasswordRecoveryPage = new PasswordRecoveryPage(driver);
        name = "Name" + generateString();
        email = generateString() + "@yandex.ru";
        password = generateString();
        objRegisterPage.openRegisterPage();
        objRegisterPage.fillingFieldsRegisterPage(name, email, password);
        objRegisterPage.clickButtonRegister();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Вход выполнен, видим кнопку: Оформить заказ")
    public void LoginSuccessfulPressButtonLogin() {
        objMainPage.openMainPage();
        objMainPage.clickButtonLogin();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Вход выполнен, видим кнопку: Оформить заказ")
    public void LoginSuccessfulPressButtonPersonalAccount() {
        objMainPage.openMainPage();
        objMainPage.clickButtonPersonalAccount();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Вход выполнен, видим кнопку: Оформить заказ")
    public void LoginSuccessfulRegistrationFormViaButton() {
        objRegisterPage.openRegisterPage();
        objRegisterPage.clickLinkEnter();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Вход выполнен, видим кнопку: Оформить заказ")
    public void LoginSuccessfulPasswordRecoveryFormViaButton() {
        objPasswordRecoveryPage.openPasswordRecoverPage();
        objPasswordRecoveryPage.clickLinkEnter();
    }
    @After
    public void teardown() {
        objLoginPage.fillingFieldsLoginPage(email, password);
        objLoginPage.clickButtonEnter();
        objMainPage.waitingTextButton(textExpected);
        driver.quit();
    }
}
