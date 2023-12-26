import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class SplashScreenLocators {
    private WebDriver driver;
    private By splashEnterButton = By.id("kz.bcc.starbanking.stage:id/fragment_welcome_login");

    public SplashScreenLocators(WebDriver driver) {
        this.driver = driver;
    }

    public void splashScreenWait() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(splashEnterButton));
    }

    public void splashEnterClick() {
        driver.findElement(splashEnterButton).click();
    }
}
