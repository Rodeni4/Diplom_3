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

import static pageobjects.RegisterPage.generateString;

public class ConstructorTest {
    private final String textExpected = "Оформить заказ";
    private String name;
    private String email;
    private String password;
    private WebDriver driver;
    private MainPage objMainPage;
    private LoginPage objLoginPage;
    private RegisterPage objRegisterPage;
    private ProfilePage objProfilePage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
        objMainPage = new MainPage(driver);
        objLoginPage = new LoginPage(driver);
        objProfilePage = new ProfilePage(driver);
        objRegisterPage = new RegisterPage(driver);
        name = "Name" + generateString();
        email = generateString() + "@yandex.ru";
        password = generateString();
        objRegisterPage.openRegisterPage();
        objRegisterPage.fillingFieldsRegisterPage(name, email, password);
        objRegisterPage.clickButtonRegister();
        objLoginPage.openLoginPage();
        objLoginPage.fillingFieldsLoginPage(email, password);
        objLoginPage.clickButtonEnter();
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на «Конструктор»")
    @Description("Вход выполнен, видим кнопку: Оформить заказ")
    public void PressButtonConstructor() {
        objProfilePage.clickButtonConstructor();
    }
    @Test
    @DisplayName("Переход из личного кабинета  по клику на логотип Stellar Burgers")
    @Description("Вход выполнен, видим кнопку: Оформить заказ")
    public void ClickLogoStellarBurgers() {
        objProfilePage.clickLogo();
    }

    @After
    public void teardown() {
        objMainPage.waitingTextButton(textExpected);
        driver.quit();
    }
}
