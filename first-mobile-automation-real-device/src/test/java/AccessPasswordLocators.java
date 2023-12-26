import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccessPasswordLocators {
    WebDriver driver;
    private By titleBox = By
            .xpath("//android.widget.TextView[@resource-id='kz.bcc.starbanking.stage:id/tvTitle']");
    private By numPad = By
            .xpath("//android.view.ViewGroup[@resource-id='kz.bcc.starbanking.stage:id/vNumPad']");
    public AccessPasswordLocators(WebDriver driver){
        this.driver = driver;
    }
    public void numPadWaiter(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(numPad));
    }
    public String getTitleText(){
        String resultTitleText = driver.findElement(titleBox).getText();
        return resultTitleText;
    }
    public String titleTextExpected = "Установите код доступа";
}
