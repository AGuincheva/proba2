import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxTest {

    private WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://pragmatic.bg/automation/lecture13/Config.html");
    }

    @Test
    public void CheckboxTest(){
        Actions checkbox = new Actions(driver);
        WebElement airbagsElement = driver.findElement(By.name("airbags"));
        WebElement parksensorElement = driver.findElement(By.name("parksensor"));

        if(!airbagsElement.isSelected()){
            checkbox.click(airbagsElement).perform();
            Assert.assertTrue(airbagsElement.isSelected());
        }
        if (!parksensorElement.isSelected()){
            checkbox.click(parksensorElement).perform();
            Assert.assertTrue(parksensorElement.isSelected());
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
