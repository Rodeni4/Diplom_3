package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private By buttonPersonalAccount= By.xpath(".//p[text()='Личный Кабинет']");
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButtonPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }
}
