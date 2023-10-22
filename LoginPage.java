import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // Setup WebDriver and navigate to the login page
        driver = DriverFactory.getDriver(); // You need to implement a driver factory
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter my username and password")
    public void i_enter_my_username_and_password() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        // Add assertions here to validate successful login
        assertTrue(driver.getCurrentUrl().contains("inventory"));
        driver.quit();
    }
}
