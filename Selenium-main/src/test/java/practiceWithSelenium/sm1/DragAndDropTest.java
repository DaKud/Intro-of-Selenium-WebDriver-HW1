package practiceWithSelenium.sm1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DragAndDropTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions action;

    @BeforeEach
    void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // режим полного экрана
        driver = new ChromeDriver(chromeOptions);
        action = new Actions(driver);
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void checkWorkDrugAndDrop() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        WebElement dragHighTatras = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//img[@src='images/high_tatras_min.jpg']")));
        WebElement boxOfTrash = driver.findElement(By.xpath("//div[@id='trash']"));

        List<WebElement> boxHasTrash = driver.findElements(By.xpath
                ("//div[@id='trash']//h5[@class='ui-widget-header']"));
        action.dragAndDrop(dragHighTatras, boxOfTrash).build().perform();
      Assertions.assertNotNull(boxHasTrash.size());
    }

    @AfterEach
    void close() {
        driver.quit();
    }
}

