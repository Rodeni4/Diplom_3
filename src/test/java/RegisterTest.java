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
import pageobjects.ProfilePage;
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
    @Description("Пользователь может зарегестрироваться и перейти в Профиль")
    public void SuccessfulRegistration() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        password = generateString().substring(0,6);
        textExpected = "Профиль";

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.openPage();
        objRegisterPage.fillingFieldsRegisterPage(name, email, password);
        objRegisterPage.clickButtonRegister();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillingFieldsLoginPage(email, password);
        objLoginPage.clickButtonEnter();

        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonPersonalAccount();

        ProfilePage objProfilePage = new ProfilePage(driver);
        objProfilePage.waitingTextProfile(textExpected);
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")
    @Description("Минимальный пароль — шесть символов.")
    public void NoSuccessfulRegistrationIncorrectPassword() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        incorrectPassword = generateString().substring(0,5);
        textExpected = "Некорректный пароль";

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.openPage();
        objRegisterPage.fillingFieldsRegisterPage(name, email, incorrectPassword);
        objRegisterPage.clickButtonRegister();
        objRegisterPage.waitErrorMessage(textExpected);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
