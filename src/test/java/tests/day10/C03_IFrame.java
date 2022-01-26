package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.time.Duration;

public class C03_IFrame {

    // ● Bir class olusturun: IframeTest
    //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //   ● Bir metod olusturun: iframeTest
    //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
    //        ○ Text Box’a “Merhaba Dunya!” yazin.
    //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //        dogrulayin ve  konsolda yazdirin.

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void iFrameTesti(){
        //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe ");

        //   ● Bir metod olusturun: iframeTest
        //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
        WebElement actualText = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualText.isEnabled(),"IFrame yazisi gorunmuyor");
        System.out.println("Text : " + actualText.getText());

        //        ○ Text Box’a “Merhaba Dunya!” yazin.

        // yazi yazmak istedigimiz text kutusu iframe in icinde oldugundan direk ulasamiyoruz
        // once iframe locate edip onun icine sitch yapmaliyiz
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");

        //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        // yukarida iframe'in icine switch yaptigimizdan yeniden disari cikmak istedigimizde
        // ana sayfa ya donmeliyiz
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        // yeni sayfada "Sponsored by Sauce Labs" gorunur oldugunu test edin

        //sponsored yazisi yeni sayfada oldugundan driver eski sayfada kaldigindan yaziyi locate edemedik
        
        WebElement sponsoredYazisiElementi = driver.findElement(By.xpath("//p[@class='subheader']"));
        softAssert.assertTrue(sponsoredYazisiElementi.isDisplayed(),"Sponsored yazisi gorunmuyor");

        softAssert.assertAll();
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
