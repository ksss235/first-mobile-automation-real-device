import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccessPasswordLocators {
    WebDriver driver;
//    private By titleBox = By
//            .xpath("//android.widget.TextView[@resource-id='kz.bcc.starbanking.stage:id/tvTitle']");
    private By secondTitleBox = By
            .xpath("//android.widget.TextView[@resource-id='kz.bcc.starbanking.stage:id/tvTitle' and @text='Повторите код доступа']");
    private By numPad = By
            .xpath("//android.view.ViewGroup[@resource-id='kz.bcc.starbanking.stage:id/vNumPad']");
    private By digit1 = By
            .xpath("//android.view.ViewGroup[@resource-id='kz.bcc.starbanking.stage:id/vNumPad']/android.widget.FrameLayout[1]");
    private By digit2 = By
            .xpath("//android.view.ViewGroup[@resource-id='kz.bcc.starbanking.stage:id/vNumPad']/android.widget.FrameLayout[2]");
    private By digit3 = By
            .xpath("//android.view.ViewGroup[@resource-id='kz.bcc.starbanking.stage:id/vNumPad']/android.widget.FrameLayout[3]");
    private By digit4 = By
            .xpath("//android.view.ViewGroup[@resource-id='kz.bcc.starbanking.stage:id/vNumPad']/android.widget.FrameLayout[4]");
    public AccessPasswordLocators(WebDriver driver){
        this.driver = driver;
    }
    public void numPadWaiter(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(numPad));
    }
//    public String getTitleText(){
//        String resultTitleText = driver.findElement(titleBox).getText();
//        return resultTitleText;
//    }
//    public String titleTextExpected = "Установите код доступа";

    private void digit1Click(){
        driver.findElement(digit1).click();
    }
    private void digit2Click(){
        driver.findElement(digit2).click();
    }
    private void digit3Click(){
        driver.findElement(digit3).click();
    }
    private void digit4Click(){
        driver.findElement(digit4).click();
    }
    public void accessPasswordEntering(){
        digit1Click();
        digit2Click();
        digit3Click();
        digit4Click();
    }
    public void secondAccessPasswordWait(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(secondTitleBox));
    }
}
