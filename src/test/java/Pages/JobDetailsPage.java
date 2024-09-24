package Pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class JobDetailsPage extends BasePage{
    public JobDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//a[text()='Job']")
    private WebElement jobTab;
    @FindBy(xpath = "//div[@class='oxd-select-text--after']//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
    private List<WebElement> jobTitleList;
    @FindBy(xpath = "//div[@class='oxd-select-option']/span[text()='Automaton Tester']" )
    private WebElement jobTitleValue;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    public void clickJobTab(){
        elementMethods.clickElement(jobTab);
        LoggerUtility.info("User clicks on 'Job' tab.");

    }
    public void chooseJobTitle(){
        elementMethods.clickElementInList(jobTitleList, 0);
        LoggerUtility.info("User opens jobs list");
        elementMethods.clickElement(jobTitleValue);
        LoggerUtility.info("User chooses job title 'Automation Tester'.");

    }
    public void saveChanges(){
        elementMethods.clickElement(saveButton);
        LoggerUtility.info("User clicks save.");
    }
}
