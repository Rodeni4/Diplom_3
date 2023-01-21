package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private final By textProfile = By.xpath(".//a[text()='Профиль']");
    private final WebDriver driver;

    public  ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitingTextProfile(String textExpected) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.textToBePresentInElementLocated(textProfile, textExpected));
    }

}
