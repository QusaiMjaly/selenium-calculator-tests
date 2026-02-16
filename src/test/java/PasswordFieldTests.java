import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

public class PasswordFieldTests {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/password.html");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // ----------- Valid EP -----------
    @Test
    public void validPasswordTest() {
        driver.findElement(By.id("password")).sendKeys("Abc12*3");
        driver.findElement(By.id("submit")).click();
        String message = driver.findElement(By.id("message")).getText();
        assertEquals("Valid Password", message);
    }

    // ----------- Invalid Length (<7) -----------
    @Test
    public void shortPasswordTest() {
        driver.findElement(By.id("password")).sendKeys("Ab12*");
        driver.findElement(By.id("submit")).click();
        String message = driver.findElement(By.id("message")).getText();
        assertEquals("Invalid Password", message);
    }

    // ----------- Invalid Length (>7) -----------
    @Test
    public void longPasswordTest() {
        driver.findElement(By.id("password")).sendKeys("Abc12345*");
        driver.findElement(By.id("submit")).click();
        String message = driver.findElement(By.id("message")).getText();
        assertEquals("Invalid Password", message);
    }

    // ----------- Invalid Characters -----------
    @Test
    public void invalidCharactersTest() {
        driver.findElement(By.id("password")).sendKeys("Abc12$3");
        driver.findElement(By.id("submit")).click();
        String message = driver.findElement(By.id("message")).getText();
        assertEquals("Invalid Password", message);
    }
}