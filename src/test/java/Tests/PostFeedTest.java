package Tests;
import SharedData.SharedData;
import objectData.PostFeedObject;
import Pages.BuzzPage;
import Pages.LogInPage;
import Pages.MenuItems;
import org.testng.annotations.Test;

public class PostFeedTest extends SharedData {


    @Test
    public void testMethod() {

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.enterCredentials();

        MenuItems menuItems = new MenuItems(getDriver());
        menuItems.clickBuzz();


        BuzzPage buzzPage = new BuzzPage(getDriver());
        PostFeedObject testData = new PostFeedObject("src/test/resources/TestData/PostFeedTestData.json");
        buzzPage.fillTextToPost(testData);
        buzzPage.clickPostButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        buzzPage.validateEntries(testData);

    }
}
