package sit707_week2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        // Set up the WebDriver (in this case, ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.login("avatarn421@gmail.com", "Whoisthi3@");
        Assert.assertEquals("https://www.bunnings.com.au/", driver.getCurrentUrl());
    }

    @Test
    public void testInvalidPassword() {
        loginPage.login("avatarn421@gmail.com", "asasas");
        Assert.assertNotEquals("https://www.bunnings.com.au/", driver.getCurrentUrl());
    }

    @Test
    public void testInvalidUsername() {
        loginPage.login("xyz@asjjbc", "Whoisthi3@");
        Assert.assertNotEquals("https://www.bunnings.com.au/", driver.getCurrentUrl());
    }

    @Test
    public void testInvalidUsernameAndPassword() {
        loginPage.login("aaa@gmail.com", "asdasd");
        Assert.assertNotEquals("https://www.bunnings.com.au/", driver.getCurrentUrl());
    }

    @Test
    public void testEmptyUsername() {
        loginPage.login("", "Whoisthi3@");
        Assert.assertNotEquals("https://www.bunnings.com.au/", driver.getCurrentUrl());
    }

    @Test
    public void testEmptyPassword() {
        loginPage.login("avatarn421@gmail.com", "");
        Assert.assertNotEquals("https://www.bunnings.com.au/", driver.getCurrentUrl());
    }

    @Test
    public void testEmptyUsernameAndPassword() {
        loginPage.login("", "");
        Assert.assertNotEquals("https://www.bunnings.com.au/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        // Close the WebDriver
        driver.quit();
    }
}
