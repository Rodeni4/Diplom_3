import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.*;


public class PersonalAccountTest {
    private String textExpected;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        textExpected = "Войти";
    }

    private WebDriver driver;

    @Test
    @DisplayName("Переход по клику на «Личный кабинет», с главной страницы")
    @Description("Переход выполнен, видим кнопку: Войти")
    public void MainPageGoToSuccessfullyPersonalAccount() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
        objMainPage.clickButtonPersonalAccount();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitingTextButton(textExpected);
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет», со страницы Регистрации")
    @Description("Переход выполнен, видим кнопку: Войти")
    public void RegisterPageGoToSuccessfullyPersonalAccount() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.openRegisterPage();
        objRegisterPage.clickButtonPersonalAccount();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitingTextButton(textExpected);
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет», со страницы Восстановление пароля")
    @Description("Переход выполнен, видим кнопку: Войти")
    public void PasswordRecoveryPageGoToSuccessfullyPersonalAccount() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        PasswordRecoveryPage objPasswordRecoveryPage = new PasswordRecoveryPage(driver);
        objPasswordRecoveryPage.openPasswordRecoverPage();
        objPasswordRecoveryPage.clickButtonPersonalAccount();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitingTextButton(textExpected);
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет», со страницы Лента заказов")
    @Description("Переход выполнен, видим кнопку: Войти")
    public void OrderFeedPageGoToSuccessfullyPersonalAccount() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        OrderFeedPage objOrderFeedPage = new OrderFeedPage(driver);
        objOrderFeedPage.openOrderFeedPage();
        objOrderFeedPage.clickButtonPersonalAccount();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitingTextButton(textExpected);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
