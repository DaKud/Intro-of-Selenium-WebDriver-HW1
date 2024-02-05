package practiceWithSelenium.sm2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @params MainPage  - pattern PageObject -> главной страницы и создания поста;
 */
public class MainPage {
    @FindBy(id = "create-btn")
    WebElement createNewPost;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createPost() {
        createNewPost.click();
    }
}