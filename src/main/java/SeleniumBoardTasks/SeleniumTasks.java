package SeleniumBoardTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumTasks {
    public static void main(String[] args)  {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.getCurrentUrl();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        WebElement username= driver.findElement(By.cssSelector("input[name=\"username\"]"));
        username.click();
        username.sendKeys("Admin");

        WebElement password=driver.findElement(By.cssSelector("input[type=\"password\"]"));
        password.click();
        password.sendKeys("admin123");

        //Get title
        String title = driver.getTitle();
        System.out.println(title);


        //Two ways for get text
          String text=driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).getText();
          System.out.println(text);

          //Get attribute
          String attribute= driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).getAttribute("attribute");

         //Is enabled
        boolean loginButton = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();

        driver.close(); // closes only a single window that is being accessed by the WebDriver instance currently
        driver.quit();// closes all the windows that were opened by the WebDriver instance
    }
}