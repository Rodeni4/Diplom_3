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
    private final String textExpected = "Войти";
    private WebDriver driver;
    private MainPage objMainPage;
    private LoginPage objLoginPage;
    private RegisterPage objRegisterPage;
    private PasswordRecoveryPage objPasswordRecoveryPage;
    private OrderFeedPage objOrderFeedPage;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
        objMainPage = new MainPage(driver);
        objLoginPage = new LoginPage(driver);
        objRegisterPage = new RegisterPage(driver);
        objOrderFeedPage = new OrderFeedPage(driver);
        objPasswordRecoveryPage = new PasswordRecoveryPage(driver);
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет», с главной страницы")
    @Description("Переход выполнен, видим кнопку: Войти")
    public void MainPageGoToSuccessfullyPersonalAccount() {
        objMainPage.goToPersonalAccountPage();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет», со страницы Регистрации")
    @Description("Переход выполнен, видим кнопку: Войти")
    public void RegisterPageGoToSuccessfullyPersonalAccount() {
        objRegisterPage.goToPersonalAccountPage();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет», со страницы Восстановление пароля")
    @Description("Переход выполнен, видим кнопку: Войти")
    public void PasswordRecoveryPageGoToSuccessfullyPersonalAccount() {
        objPasswordRecoveryPage.goToPersonalAccountPage();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет», со страницы Лента заказов")
    @Description("Переход выполнен, видим кнопку: Войти")
    public void OrderFeedPageGoToSuccessfullyPersonalAccount() {
        objOrderFeedPage.goToPersonalAccountPage();
    }

    @After
    public void teardown() {
        objLoginPage.waitingTextButton(textExpected);
        driver.quit();
    }
}
