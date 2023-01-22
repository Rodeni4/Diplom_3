import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.MainPage;

public class SectionsTest {
    private WebDriver driver;
    private MainPage objMainPage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
        objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    @Description("Переход выполнен, раздел «Соусы» активный")
    public void GoToSectionSauces() {
        objMainPage.clickLinkSauces();
        objMainPage.waitingTextLink("Соусы");
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    @Description("Переход выполнен, раздел «Начинки» активный")
    public void GoToSectionFillings() {
        objMainPage.clickLinkFillings();
        objMainPage.waitingTextLink("Начинки");
    }

    @Test
    @DisplayName("Переход к разделу «Булки")
    @Description("Переход выполнен, раздел «Булки» активный")
    public void GoToSectionBreads() {
        objMainPage.clickLinkSauces();
        objMainPage.waitingTextLink("Соусы");
        objMainPage.clickLinkBreads();
        objMainPage.waitingTextLink("Булки");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
