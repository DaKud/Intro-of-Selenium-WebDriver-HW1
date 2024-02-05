package practiceWithSelenium.sm2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @params ElementPage - отдельный случай PageObject;
 */
public class ElementPage {
    @FindBy(xpath = "//button")
    List<WebElement> elements;

    public ElementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void deletePost() {
        elements.get(1).click();
    }
    public void editButton(){
        elements.get(0).click();
    }
}