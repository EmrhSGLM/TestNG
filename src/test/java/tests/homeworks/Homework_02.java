package tests.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Homework_02 {

    //Yeni bir Class Olusturun : D11_SoftAssert1
    //1.“https:// hepsiburada .com/” Adresine gidin
    //2.Basliginin “ Turkiye’nin En Buyuk Alisveris Sitesi " icerdigini dogrulayin
    //3.search kutusuna araba yazip arattirin
    //4.bulunan sonuc sayisini yazdirin
    //5.sonuc yazisinin "araba" icerdigini dogrulayin
    //6.Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test() {
        //1.“https://www.hepsiburada.com/” Adresine gidin
        driver.get("https://www.hepsiburada.com");

        //2.Basliginin “ Türkiye’nin En Büyük Alışveriş Sitesi " icerdigini dogrulayin
        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedTitle), "Title text'i icermiyor");

        //3.search kutusuna araba yazip arattirin
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("araba" + Keys.ENTER);

        //4.bulunan sonuc sayisini yazdirin
        WebElement result = driver.findElement(By.xpath("//div[@class='searchResultSummaryBar-mainText']"));
        System.out.println("resultNumber = " + result.getText());

        //5.sonuc yazisinin "araba" icerdigini dogrulayin
        WebElement resultWriting = driver.findElement(By.xpath("//div[@class='searchResultSummaryBar-mainText']"));
        String actualResultWriting = resultWriting.getText();
        String expectedWriting = "araba";
        softAssert.assertTrue(actualResultWriting.contains(expectedWriting), "Does not contain");

        //6.Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        System.out.println("actualResultWriting = " + actualResultWriting);
        String expectedOto = "Oto";
        softAssert.assertFalse(actualResultWriting.contains(expectedOto), "Contain");

        softAssert.assertAll();
        System.out.println("Hata yok");
    }
    @AfterMethod
    public void teardown() {
        driver.close();
    }
}