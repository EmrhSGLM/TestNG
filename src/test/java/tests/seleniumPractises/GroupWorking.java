package tests.seleniumPractises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class GroupWorking {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        //1.http://zero.webappsecurity.com Adresine gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//i[@class='icon-signin']")).click();

        //3. Login kutusuna “username” yazin
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username");

        //4. Password kutusuna “password.” yazin
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        // Guvenlik duvari asildi
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//a[@href='/bank/redirect.html?url=pay-bills.html']")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(dropdownElement);
        select.selectByIndex(6);

        //9. “amount” kutusuna bir sayi girin
        WebElement amountBox = driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amountBox.sendKeys("100");

        //10. “US Dollars” in secilmedigini test edin
        String actualOptions = select.getFirstSelectedOption().getText();
        String expectedOptions = "US Dollars";
        Assert.assertFalse(actualOptions.equals(expectedOptions));

        //11. “Selected currency” butonunu secin
        WebElement tik = driver.findElement(By.xpath("(//label[@style='padding-bottom: 8px'])[2]"));
        tik.click();


        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();


        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        String actualWriting = driver.findElement(By.xpath("//div[@id='alert_content']")).getText();
        String expectedWriting = "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(actualWriting,expectedWriting,"Yazi ayni degil");
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}