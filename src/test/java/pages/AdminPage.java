package pages;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage{
    public AdminPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addUserButton;

    public void clickAddButton(){
        elementMethods.clickElement(addUserButton);
        LoggerUtility.info("User clicks 'Add' button.");
    }
}
