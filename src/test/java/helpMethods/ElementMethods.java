package helpMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ElementMethods {

    public WebDriver driver;
    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }
    public void waitVisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitVisibilityAllElements(List<WebElement> elements){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }


    public void clickElement(WebElement element){
        waitVisibleElement(element);
        element.click();
    }

    public void clickElementInList(List<WebElement>elements, Integer index){
        waitVisibilityAllElements(elements);
        elements.get(index).click();

    }

    public void fillElement(WebElement element, String value){
        waitVisibleElement(element);
        element.sendKeys(value);
    }
    public void fillElementInList(List<WebElement>elements,Integer index, String value){
        elements.get(index).sendKeys(value);
    }

    public void scrollByPixels(Integer x, Integer y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + " ," + y + ")", "");
    }


}
