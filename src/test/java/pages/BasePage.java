package pages;
import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;

    public ElementMethods elementMethods;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementMethods = new ElementMethods(driver);

    }
}
