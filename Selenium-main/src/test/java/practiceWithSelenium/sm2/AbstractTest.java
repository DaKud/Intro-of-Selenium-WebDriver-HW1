package practiceWithSelenium.sm2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private static String login = "AdEllie";

    public static String getLogin() {
        return login;
    }
    public static String getPassword() {
        return password;
    }
    private static String password = "ed33fb7c8a";

    @BeforeAll
    static void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
