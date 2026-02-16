import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

public class CalculatorTests {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/calculator.html"); 
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // ----------- Addition -----------
    @Test
    public void testAddition1() {
        driver.findElement(By.id("num1")).sendKeys("5");
        driver.findElement(By.id("num2")).sendKeys("3");
        driver.findElement(By.id("add")).click();
        String result = driver.findElement(By.id("result")).getText();
        assertEquals("8", result);
    }

    @Test
    public void testAddition2() {
        driver.findElement(By.id("num1")).sendKeys("10");
        driver.findElement(By.id("num2")).sendKeys("2");
        driver.findElement(By.id("add")).click();
        String result = driver.findElement(By.id("result")).getText();
        assertEquals("12", result);
    }

    // ----------- Subtraction -----------
    @Test
    public void testSubtraction1() {
        driver.findElement(By.id("num1")).sendKeys("9");
        driver.findElement(By.id("num2")).sendKeys("4");
        driver.findElement(By.id("subtract")).click();
        String result = driver.findElement(By.id("result")).getText();
        assertEquals("5", result);
    }

    @Test
    public void testSubtraction2() {
        driver.findElement(By.id("num1")).sendKeys("7");
        driver.findElement(By.id("num2")).sendKeys("2");
        driver.findElement(By.id("subtract")).click();
        String result = driver.findElement(By.id("result")).getText();
        assertEquals("5", result);
    }

    // ----------- Multiplication -----------
    @Test
    public void testMultiplication1() {
        driver.findElement(By.id("num1")).sendKeys("4");
        driver.findElement(By.id("num2")).sendKeys("3");
        driver.findElement(By.id("multiply")).click();
        String result = driver.findElement(By.id("result")).getText();
        assertEquals("12", result);
    }

    @Test
    public void testMultiplication2() {
        driver.findElement(By.id("num1")).sendKeys("6");
        driver.findElement(By.id("num2")).sendKeys("5");
        driver.findElement(By.id("multiply")).click();
        String result = driver.findElement(By.id("result")).getText();
        assertEquals("30", result);
    }
}