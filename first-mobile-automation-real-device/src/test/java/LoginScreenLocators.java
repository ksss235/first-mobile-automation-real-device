import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginScreenLocators {
    private WebDriver driver;
    private By phoneField = By
            .xpath("//android.widget.EditText[@resource-id='kz.bcc.starbanking.stage:id/view_anketa_edit_input' and @text='+7 --- --- -- --']");
    private By passwordField = By
            .xpath("//android.widget.EditText[@resource-id='kz.bcc.starbanking.stage:id/view_anketa_edit_input' and @text='Введите пароль']");
    private By enterLoginButton = By
            .xpath("//android.widget.Button[@resource-id='kz.bcc.starbanking.stage:id/fragment_login_enter']");
    private By locationDenyButton = By
            .xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']");
    public LoginScreenLocators(WebDriver driver){
    this.driver = driver;
    }
    public void loginScreenWait(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(phoneField));
    }
    private void setPhoneField(String phone){
        driver.findElement(phoneField).sendKeys(phone);
    }
    private void passwordFieldClick(){
        driver.findElement(passwordField).click();
    }
    private void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void enterButtonClick(){
        driver.findElement(enterLoginButton).click();
    }
    public void loginProcess(String phone, String password){
        setPhoneField(phone);
        passwordFieldClick();
        setPasswordField(password);
        enterButtonClick();
    }
    public void locationPermissionWait(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(locationDenyButton));
    }
    public void locationDenyButtonClick(){
        driver.findElement(locationDenyButton).click();
    }
}
