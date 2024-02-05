package practiceWithSelenium.sm1;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class FirstTaskTest {
    static WebDriver driver;
    String login = "AdEllie";
    String password = "ed33fb7c8a";
    private static WebDriverWait wait;

    @BeforeEach
    void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://test-stand.gb.ru/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Disabled
    void test() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); 
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://test-stand.gb.ru/login");
        Thread.sleep(5000L);
        driver.quit();
    }

    @Test
    @Disabled
    void authorizationTestOne() throws InterruptedException {
        WebElement loginNew = driver.findElement(By.xpath("//*[@type='text']"));
        WebElement passwordNew = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement buttonNew = driver.findElement(By.xpath("//*[@class='mdc-button__label']"));


        loginNew.sendKeys(login);
        passwordNew.sendKeys(password);
        Thread.sleep(5000L);
        buttonNew.click();

        List<WebElement> searchList = driver.findElements(By.partialLinkText("Hello"));
        Assertions.assertEquals(1, searchList.size());
    }

    @Test
    @Disabled
    void authorizationTestTwo() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement loginTwo = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("form#login input[type='text']")));
        WebElement passwordTwo = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement loginButtonTwo = driver.findElement(By.cssSelector("form#login button"));

        loginTwo.sendKeys(login);
        passwordTwo.sendKeys(password);
        Thread.sleep(5000L);
        loginButtonTwo.click();

        List<WebElement> searchList = driver.findElements(By.partialLinkText("Hello"));
        Assertions.assertEquals(1, searchList.size());
    }



    @AfterEach
    void close() {
        driver.quit();
    }
}
