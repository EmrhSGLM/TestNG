package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethods {

    //●Bir class oluşturun: D ependsOnTest
    //●https://www. amazon . adresine gidin.
    //1. Test : Amazon ana sayfaya gittiginizi test edin
    //2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    //              arama yapin ve aramanizin gerceklestigini Test edin
    //3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
    //          $16.83 oldugunu test edin
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
     @Test (priority = 1)
    public void logoTest() {
         //●https://www. amazon . adresine gidin.
         //1. Test : Amazon ana sayfaya gittiginizi test edin
         driver.get("https://www.amazon.com");
         WebElement logoElement = driver.findElement(By.id("nav-logo-sprites"));
         Assert.assertTrue(logoElement.isDisplayed());
     }
     @Test (dependsOnMethods = "logoTest")
    public void aramaTest(){
         //                     2. Test
         // 1.Test basarili ise search Box’i kullanarak “Nutella” icin
         // arama yapin ve aramanizin gerceklestigini Test edin
         WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
         searchBox.sendKeys("Nutella" + Keys.ENTER);
         String actualTitle = driver.getTitle();
         String expectedTitle = "Nutella";
         Assert.assertTrue(actualTitle.contains(expectedTitle));
     }
     @Test (dependsOnMethods = "aramaTest")
    public void test(){
         //             3.Test
         // “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
         // $14.99 oldugunu test edin
         driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();
        String actualPrice = driver.findElement(By.xpath("//span[@class='a-size-base a-color-price']")).getText();
        String expectedPrice = "$14.99";
        Assert.assertTrue(actualPrice.contains(expectedPrice));
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }

}
