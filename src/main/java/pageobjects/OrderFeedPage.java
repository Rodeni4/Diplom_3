package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderFeedPage {
    private final String ORDER_FEED_PAGE = "https://stellarburgers.nomoreparties.site/feed";
    private final By linkEnter = By.xpath(".//a[text()='Войти']");
    private final By buttonPersonalAccount= By.xpath(".//p[text()='Личный Кабинет']");
    private final WebDriver driver;
    public OrderFeedPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLinkEnter() {
        waitingForElement(linkEnter);
        driver.findElement(linkEnter).click();
    }
    public void waitingForElement(By byXpath) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(byXpath));
    }

    public void openOrderFeedPage() {
        driver.get(ORDER_FEED_PAGE);
    }
    public void clickButtonPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }
}

