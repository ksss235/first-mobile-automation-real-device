import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileAutomation {
    private AndroidDriver driver;

    @Before
    public void setCapatibilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "xiaomi");
        capabilities.setCapability("appium:platformName", "android");
        capabilities.setCapability("appium:platformVersion", "10.0");
        capabilities.setCapability("appium:udid", "ON4HMRAEX8ZPIRGQ");
        capabilities.setCapability("appium:appPackage", "kz.bcc.starbanking.stage");
        capabilities.setCapability("appium:appActivity", "kz.bcc.starbanking.ui.screens.splash.SplashActivity");
        capabilities.setCapability("appium:automationName", "UiAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    @Test
    public void RealDeviceLoginTest(){
        SplashScreenLocators splashScreenLocators = new SplashScreenLocators(driver);
        splashScreenLocators.splashScreenWait();
        splashScreenLocators.splashEnterClick();

        LoginScreenLocators loginScreenLocators = new LoginScreenLocators(driver);
        loginScreenLocators.loginScreenWait();

        GitIgnorePasswords gitIgnorePasswords = new GitIgnorePasswords();
        loginScreenLocators.loginProcess(gitIgnorePasswords.phoneNumber, gitIgnorePasswords.password);
        loginScreenLocators.locationPermissionWait();
        loginScreenLocators.locationDenyButtonClick();

        AccessPasswordLocators accessPasswordLocators = new AccessPasswordLocators(driver);
        accessPasswordLocators.numPadWaiter();
//        String resultTitleText = accessPasswordLocators.getTitleText();
//        Assert.assertEquals("Установите код доступа expected", accessPasswordLocators.titleTextExpected, resultTitleText);
        accessPasswordLocators.accessPasswordEntering();
        accessPasswordLocators.secondAccessPasswordWait();
        accessPasswordLocators.accessPasswordEntering();

        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.mainScreenBalanceWait();
    }

    @After
    public void tearDown(){
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.logoutProcess();
        driver.quit();
    }
}
