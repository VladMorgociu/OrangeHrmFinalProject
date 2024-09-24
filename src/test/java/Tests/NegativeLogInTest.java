package Tests;

import SharedData.SharedData;
import objectData.NegativeLogInObject;
import Pages.LogInPage;
import org.testng.annotations.Test;

public class NegativeLogInTest extends SharedData {

    @Test
    public  void testMethod(){

        NegativeLogInObject testData= new NegativeLogInObject("src/test/resources/TestData/NegativeLogInTestData.json");

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.enterWrongCredentials(testData);
        logInPage.validateAlertMessage(testData);
    }
}
