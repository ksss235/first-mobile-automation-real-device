import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainScreen {
    WebDriver driver;
    private By cardBalance = By
            .xpath("//android.widget.TextView[@resource-id='kz.bcc.starbanking.stage:id/account_item_amount']");
    private By moreButton = By
            .xpath("//android.widget.FrameLayout[@resource-id='kz.bcc.starbanking.stage:id/main_navigation_more']");
    private By logoutButton = By
            .xpath("//android.widget.FrameLayout[@resource-id='kz.bcc.starbanking.stage:id/more_logout']");
    private By popupLocator = By
            .xpath("//android.widget.TextView[@resource-id='kz.bcc.starbanking.stage:id/popup_default_title']");
    private By positiveButton = By
            .xpath("//android.widget.TextView[@resource-id='kz.bcc.starbanking.stage:id/positive']");
    public MainScreen(WebDriver driver){
        this.driver = driver;
    }
    public void mainScreenBalanceWait(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(cardBalance));
    }
    private void moreButtonClick(){
        driver.findElement(moreButton).click();
    }
    private void logoutButtonWait(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
    }
    private void logoutButtonClick(){
        driver.findElement(logoutButton).click();
    }
    private void popupLocatorWait(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(popupLocator));
    }
    private void positiveButtonClick(){
        driver.findElement(positiveButton).click();
    }
    public void logoutProcess(){
        moreButtonClick();
        logoutButtonWait();
        logoutButtonClick();
        popupLocatorWait();
        positiveButtonClick();
    }
}
