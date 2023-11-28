package SeleniumBoardTasks;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTests {
    public static WebDriver driver;

    @BeforeClass
    public static void initialiseDriverAndProperties() {
        loadTestProperties();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        String username = "<your_lambdatest_username>";
        String accesskey = "<your_lambdatest_accesstoken>";
        String lambdaTestGridURL = "@hub.lambdatest.com/wd/hub";

        capabilities.setCapability("build", "Selenium_Gherkin_Project");
        capabilities.setCapability("name", "Placing order for a product");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "73.0");
        capabilities.setCapability("visual", false);
        capabilities.setCapability("network", false);
        capabilities.setCapability("console", false);
        capabilities.setCapability("tunnel", false);
        try {
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + accesskey + lambdaTestGridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        }
    }

    private static void loadTestProperties() {
        Properties properties = System.getProperties();
        try {
            properties.load(
                    new FileInputStream(new File("resources/test.properties")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
