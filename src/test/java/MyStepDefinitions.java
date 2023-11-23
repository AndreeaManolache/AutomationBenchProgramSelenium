
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import steps.StepsInitialization;
import org.junit.Assert;



public class MyStepDefinitions extends StepsInitialization {
    public static WebDriver driver;
    @Given("Customer navigates to the website")
    public void customerNavigatesToTheWebsite() {
      //  driver.get(System.getProperty(“https://www.shopping.com/”));
    }

    @And("Customer login to his account")
    public void customerLoginToHisAccount() {
//        driver.findElement(By.id(“username”)).enterData(“username”);
//        driver.findElement(By.id(“password”)).enterData(“password”);
//        driver.findElement(By.id(“login”)).click();
    }

    @When("customer searches for laptop")
    public void customerSearchesForLaptop() {
//        driver.findElement(By.id(“searchBox”)).enterData(“Laptop”);
//        driver.findElement(By.id(“searchButton”)).click();
    }

    @And("clicks on add to cart button")
    public void clicksOnAddToCartButton() {
      //  driver.findElement(By.id(“addToCart”)).click();
    }

    @Then("Customer is redirected to cart page")
    public void customerIsRedirectedToCartPage() {
       // Assert.assertTrue(driver.findElement(By.id(“cartPageHeader”)).isDisplayed());

    }

    @And("Customer is able to click the place order button")
    public void customerIsAbleToClickThePlaceOrderButton() {
      //  Assert.assertTrue(driver.findElement(By.id(“placeOrderButton”)).isClickable());

    }
}
