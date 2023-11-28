package SeleniumBoardTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.InputEvent;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAlertsAndPopups {

        public static void main(String[] args) throws InterruptedException, AWTException {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.browserstack.com/users/sign_up");
            driver.manage().window().maximize();
            Thread.sleep(500);
            driver.findElement(By.id("accept-cookie-notification")).click(); // Clicking on the popup button
            Robot robot = new Robot();
            robot.mouseMove(400, 500); // Navigating through mouse hover. Note that the coordinates might differ, kindly check the coordinates of x and y axis and update it accordingly.
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(2000);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(2000);
            driver.quit();
        }
    }

