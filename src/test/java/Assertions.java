import org.junit.Assert;
//import org.testing.annotation.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assertions {
 // @Test
    public void testAssertFunctions() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.browserstack.com/");
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
    }
}
