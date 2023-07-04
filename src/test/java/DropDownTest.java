import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropDownTest {

   private WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://shop.pragmatic.bg/admin");
    }


    @Test
    public void dropdownTest() {
        WebElement elementSales = driver.findElement(By.xpath("//*[text()=' Sales']"));
        elementSales.click();
        WebElement elementOrders = driver.findElement(By.xpath("//a[text()='Orders']"));
        elementOrders.click();
        WebElement selectDropdown = driver.findElement(By.id("input-order-status"));
        Select dropdownMenu = new Select(selectDropdown);
        List<WebElement> dropdownOptions = dropdownMenu.getOptions();
        for (WebElement option : dropdownOptions) {
            String opt = option.getText();
            System.out.println(opt);
        }
        WebElement option = driver.findElement(By.xpath("//option[@value='7']"));
        String option2 = option.getText();
        Assert.assertEquals(option2, "Canceled");
    }


    @BeforeMethod
    public void TestLogin(){
        WebElement userName = driver.findElement(By.xpath("//div/input[@id='input-username']"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector(".btn"));
        userName.sendKeys("admin");
        password.sendKeys("parola123!");
        loginButton.click();
        WebElement dashboardText = driver.findElement(By.xpath("//div/following-sibling::h1"));
        String name = dashboardText.getText();
        Assert.assertEquals(name, "Dashboard");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
