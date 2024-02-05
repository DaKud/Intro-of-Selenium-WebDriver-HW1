package practiceWithSelenium.sm2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemakeNamePage {

    @FindBy(xpath = "//div[@class='posts svelte-127jg4t']/a")
    private WebElement firstDummy;

    @FindBy(xpath = "//div[@class='button-block svelte-tv8alb']/button")
    private WebElement dummyButtonEditPost;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement fieldToTitle;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//a[contains(text(),'Hello')]")
    private WebElement buttonUserPage;
    @FindBy(xpath = "//ul[@class='mdc-deprecated-list']/li")
    private WebElement buttonProfile;
    public RemakeNamePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openFirstDummyCardAndSaveNewName(String name) throws InterruptedException {
        firstDummy.click();              // кликнули на первую карточку и открыли
        Thread.sleep(5000L);
        dummyButtonEditPost.click();     // кликнули на кнопку для изменения имени
        fieldToTitle.clear();            // очистили поле имени
        fieldToTitle.sendKeys(name);     // добавили новое имя
        saveButton.click();              // сохранили
    }

    public void openProfile() throws InterruptedException {
        Thread.sleep(5000l);
        buttonUserPage.click();
        buttonProfile.click();
    }

}
