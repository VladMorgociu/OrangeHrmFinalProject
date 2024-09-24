package SharedData;
import loggerUtility.LoggerUtility;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

@Getter
public class SharedData {
    private WebDriver driver;

    @BeforeMethod
    public void prepareEnvironment(){
        boolean cicd = Boolean.parseBoolean(System.getProperty("CI_CD"));
        if(cicd){
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver();
        }

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.info("The browser has opened successfully!");
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if(!result.isSuccess()){
            LoggerUtility.error(result.getThrowable().getMessage());
        }
        driver.quit();
        LoggerUtility.info("The browser has closed successfully!");
    }

    public WebDriver getDriver(){
        return driver;
    }
}
