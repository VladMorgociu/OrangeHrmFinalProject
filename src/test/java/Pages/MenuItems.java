package Pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuItems extends BasePage {
    public MenuItems(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Buzz']")
    private WebElement buzzMenuItem;

    @FindBy(xpath="//span[text()='PIM']")
    private WebElement PIMMenuItem;
    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminMenuItem;

    public void clickBuzz(){
        elementMethods.clickElement(buzzMenuItem);
        LoggerUtility.info("User clicks on 'Buzz' menu item");
    }
    public void clickPIM(){
        elementMethods.clickElement(PIMMenuItem);
        LoggerUtility.info("User clicks on 'PIM' menu item");
    }

    public void clickAdmin(){elementMethods.clickElement(adminMenuItem);
        LoggerUtility.info("User clicks on 'Admin' menu item");
        }
}
