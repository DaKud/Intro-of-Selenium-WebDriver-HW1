package practiceWithSelenium.sm2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {


    @FindBy(xpath = "//*[@type='text']")
    private WebElement loginField;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class='mdc-button__label']")
    private WebElement button;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);


    }

    public void loginInSystem(String login1, String password1) {
        loginField.sendKeys(login1);
        passwordField.sendKeys(password1);
        button.click();
    }

    public void LoginInSystemWithOutParams() {
        //  loginField.sendKeys(null);
        //passwordField.sendKeys(null);
        button.click();
    }

}
