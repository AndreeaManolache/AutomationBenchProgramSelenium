package SeleniumBoardTasks;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest1 {
    public static WebDriver driver;

        @BeforeClass
        public static void initialiseDriverAndProperties() {
            loadTestProperties();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @AfterClass
        public static void closeBrowser() {
            driver.quit();
        }

        private static void loadTestProperties(){
            Properties properties = System.getProperties();
            try {
                properties.load(
                        new FileInputStream(new File("resources/test.properties")));
            } catch(Exception ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
        }
}
