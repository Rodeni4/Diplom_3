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
import pageobjects.RegisterPage;

import static pageobjects.RegisterPage.generateString;

public class RegisterTest {
    private String name;
    private String email;
    private String password;
    private String incorrectPassword;
    private String textExpected;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        name = "name" + generateString();
        email = generateString() + "@yandex.ru";
    }
    private WebDriver driver;

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Вводим пароль 6 символов, видим кнопку: Оформить заказ")
    public void SuccessfulRegistration() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        password = generateString().substring(0,6);
        textExpected = "Оформить заказ";

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.openRegisterPage();
        objRegisterPage.fillingFieldsRegisterPage(name, email, password);
        objRegisterPage.clickButtonRegister();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillingFieldsLoginPage(email, password);
        objLoginPage.clickButtonEnter();

        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitingTextButton(textExpected);
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")
    @Description("Вводим пароль 5 символов, выдим сообщение: Некорректный пароль")
    public void NoSuccessfulRegistrationIncorrectPassword() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        incorrectPassword = generateString().substring(0,5);
        textExpected = "Некорректный пароль";

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.openRegisterPage();
        objRegisterPage.fillingFieldsRegisterPage(name, email, incorrectPassword);
        objRegisterPage.clickButtonRegister();
        objRegisterPage.waitErrorMessage(textExpected);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
