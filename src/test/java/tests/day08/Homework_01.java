package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework_01 {

    //1)Bir class oluşturun: Youtube Assertions
    //2)https://www.youtube.com adresine gidin
    //3)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //      ○titleTest => Sayfa başlığının YouTube ” oldugunu test edin
    //      ○imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
    //      ○Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //      ○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");
    }

    @Test
    public void titleTest(){
        //      ○titleTest => Sayfa başlığının YouTube ” oldugunu test edin
        String actualTitle=driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals(actualTitle, expectedTitle,"Title is not YouTube ");
    }
    @Test
    public void imageTest(){
        //      ○imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
        WebElement image = driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]"));
        Assert.assertTrue(image.isDisplayed());
    }
    @Test
    public void searchTest(){
        //      ○Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search_query']"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        //4) wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";
        Assert.assertFalse(actualTitle.equals(expectedTitle));
    }
    @AfterClass
    public void teardwon(){
        driver.close();
    }
}
