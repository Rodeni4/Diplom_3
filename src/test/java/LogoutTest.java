import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.*;

import static pageobjects.RegisterPage.generateString;

public class LogoutTest {
    private final String textExpected = "Войти";
    private String name;
    private String email;
    private String password;
    private WebDriver driver;
    private MainPage objMainPage;
    private LoginPage objLoginPage;
    private ProfilePage objProfilePage;
    private RegisterPage objRegisterPage;

    @Test
    @DisplayName("Ввыход по кнопке «Выйти» в личном кабинете")
    @Description("Выход выполнен, видим кнопку: Войти")
    public void LogoutSuccessful() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
        name = "Name" + generateString();
        email = generateString() + "@yandex.ru";
        password = generateString();
        objRegisterPage = new RegisterPage(driver);
        objRegisterPage.openRegisterPage();
        objRegisterPage.fillingFieldsRegisterPage(name, email, password);
        objRegisterPage.clickButtonRegister();
        objLoginPage = new LoginPage(driver);
        objLoginPage.openLoginPage();
        objLoginPage.fillingFieldsLoginPage(email, password);
        objLoginPage.clickButtonEnter();
        objMainPage = new MainPage(driver);
        objMainPage.clickButtonPersonalAccount();
        objProfilePage = new ProfilePage(driver);
        objProfilePage.clickLogout();
        objLoginPage.waitingTextButton(textExpected);
        driver.quit();
    }
}
