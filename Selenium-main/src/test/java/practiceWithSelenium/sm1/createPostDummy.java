package practiceWithSelenium.sm1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class createPostDummy extends FirstTaskTest {

    WebDriverWait wait;

    @Test
    @DisplayName("Create Dummy with wait")
    void createDummyInPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginNew = driver.findElement(By.xpath("//*[@type='text']"));
        WebElement passwordNew = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement buttonNew = driver.findElement(By.xpath("//*[@class='mdc-button__label']"));
        loginNew.sendKeys(login);
        passwordNew.sendKeys(password);
        Thread.sleep(5000L);
        buttonNew.click();
        WebElement buttonCreate = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.id("create-btn")));
        buttonCreate.click();
        WebElement titleNew = driver.findElement(By.xpath("//*[@type='text']"));
        titleNew.sendKeys("New Dummy test");
        WebElement descriptionNew = driver.findElement(By.cssSelector("div.field textarea.mdc-text-field__input"));
        descriptionNew.sendKeys("This is description of new Dummy");
        WebElement buttonPage = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[@type='submit']")));
        buttonPage.click();
        List<WebElement> elementsDummy = driver.findElements(By.xpath("//h1[@class='svelte-tv8alb']"));
        Assertions.assertEquals("New Dummy test",elementsDummy.get(0).getText());
//        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try{
//            FileUtils.copyFile =(screenshot,new File("\\src\\test\\resources\\screenshotDummy.png"));
//
//        } catch (IOException exception){
//            exception.printStackTrace();
//
//        }
    }
}
