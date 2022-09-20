import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class homeTask {
    private WebDriver driver;

    @AfterEach
    public void tearDown(){
        if (driver != null) driver.quit();
    }

    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("safari")){
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void checkFormTest() {
        driver.findElement(By.id("firstName")).sendKeys("Test");

        driver.findElement(By.id("lastName")).sendKeys("User");

        driver.findElement(By.id("userEmail")).sendKeys("testEmail@gmail.com");

        driver.findElement(By.cssSelector("[for=gender-radio-3]")).click();

        driver.findElement(By.id("userNumber")).sendKeys("89990001122");

        driver.findElement(By.id("dateOfBirthInput")).click();

        WebElement monthList = driver.findElement(By.className("react-datepicker__month-select"));
        Select monthSelect = new Select(monthList);

        WebElement yearList = driver.findElement(By.className("react-datepicker__year-select"));
        Select yearSelect = new Select(yearList);

        monthSelect.selectByValue("3");
        yearSelect.selectByValue("1998");

        driver.findElement(By.id("subjectsInput")).sendKeys("Maths");

//        driver.findElement(By.cssSelector("[for=hobbies-checkbox-2]")).click();

        String filePath = "C:\\Users\\sasha\\IdeaProjects\\Lection5\\src\\test\\files\\IMG_6075.PNG";
        driver.findElement(By.cssSelector("input[type=file]")).sendKeys(filePath);

        driver.findElement(By.id("currentAddress")).sendKeys("3-я улица Строителей, дом 25, квартира 12");

//        driver.findElement(By.id("state")).sendKeys("NCR");
//        Select stateSelect = new Select(stateList);
//        stateSelect.selectByValue("NCR");

        driver.findElement(By.id("submit")).click();

    }
}
