package practiceWithSelenium.sm2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @params CreatePostPage - pattern PageObject -> создания Поста на странице;
 */
public class CreatePostPage {
    @FindBy(xpath = "//*[@type='text']")
    private WebElement title;
    @FindBy(xpath = "//textarea[@class='mdc-text-field__input']")
    private WebElement description;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement buttonSave;


    public CreatePostPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void savePost(String titleText, String descriptionText) {
        title.sendKeys(titleText);
        description.sendKeys(descriptionText);
        buttonSave.click();
    }


}

