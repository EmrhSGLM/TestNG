package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle {

    //● Tests package’inda yeni bir class olusturun: WindowHandle2
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void test()  {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText = driver.findElement(By.xpath("//h3[.='Opening a new window']")).getText();
        SoftAssert softAssert = new SoftAssert();
        String expectedText="Opening a new window";
        softAssert.assertEquals(actualText,expectedText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        softAssert.assertEquals(actualTitle,expectedTitle);

        //● Click Here butonuna basın.
        //Soru da windowHandle degerini bilmedigim bir window aciliyor
        // o sayfa nin window handle degerini bulmak icin gectigim sayfalar da ki
        // window handle degerini kaydetmeliyim
        String windowHandle1=driver.getWindowHandle();
        driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        // once acilan yeni sayfanin handle degerini elde etmeliyim

        // once tum handle degerlerini alip bir set'e koyalim
        Set<String>  handleDegerleriSet= driver.getWindowHandles();
        String windowHandle2="";
        for(String w:handleDegerleriSet){
            if(!w.equals(windowHandle1)){
                windowHandle2=w;
            }
        }
        driver.switchTo().window(windowHandle2);

        String actualTitleNew=driver.getTitle();
        System.out.println(actualTitleNew);
        String expectedTitleNew="New Window";
        softAssert.assertEquals(actualTitleNew,expectedTitleNew);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualTextNew=driver.findElement(By.xpath("//h3[.='New Window']")).getText();
        String expectedTextNew="New Window";
        Assert.assertEquals(expectedTextNew, actualTextNew);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(windowHandle1);
        String actualTitle2=driver.getTitle();
        String expectedTitle2="The Internet";
        softAssert.assertEquals(actualTitle2,expectedTitle2);

        softAssert.assertAll();
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
