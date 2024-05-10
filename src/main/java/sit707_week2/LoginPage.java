package sit707_week2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        // Open the login page
        driver.get("https://www.bunnings.com.au/login");

        // Find username and password fields
        WebElement emailField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));

        // Enter username and password
        emailField.sendKeys(username);
        passwordField.sendKeys(password);

        // Find and click the login button
        WebElement checkbox = driver.findElement(By.name("remember"));

        // Find the sign-in button using Relative Locator API
        WebElement signInButton = driver.findElement(RelativeLocator.with(By.tagName("input")).below(checkbox));
        signInButton.click();
        
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Set up the WebDriver (in this case, ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Create LoginPage instance
        LoginPage loginPage = new LoginPage(driver);

        // Example usage: Logging in with valid credentials
        loginPage.login("avatarn421@gmail.com", "Whoisthi3@");
        
        
        // After login, you can perform further actions or assertions
        // For example, you can assert the current URL to ensure successful login
        
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        if (currentUrl.equals("https://www.bunnings.com.au/")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        // Close the WebDriver
        driver.quit();
    }
}
