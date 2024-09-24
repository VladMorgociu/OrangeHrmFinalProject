package Pages;


import loggerUtility.LoggerUtility;
import objectData.PostFeedObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class BuzzPage extends BasePage {
    public BuzzPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']//div[@class='oxd-grid-item oxd-grid-item--gutters']")
    private List<WebElement> actualPostCards;
    @FindBy(css = ".oxd-buzz-post-input")
    private WebElement textToPostField;
    @FindBy(xpath = "//button[@type='submit'][@class='oxd-button oxd-button--medium oxd-button--main']")
    private WebElement postButton;

    @FindBy(xpath = "//div[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='orangehrm-buzz-post-body']")
    private List<WebElement> postBody;

    public void fillTextToPost(PostFeedObject testData){
        elementMethods.fillElement(textToPostField, testData.getTextToPostValue());
        LoggerUtility.info("User fills text to post field with: " + testData.getTextToPostValue());
    }
    public void clickPostButton(){
        elementMethods.clickElement(postButton);
        LoggerUtility.info("User clicks on post button.");
    }

    public void validateEntries(PostFeedObject testData){
        String actualPostText = postBody.get(0).getText();
        Assert.assertTrue(actualPostText.contains(testData.getExpectedPostText()));
        LoggerUtility.info("Validation that actually posted text contains "+ testData.getExpectedPostText());
    }
}
