package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_ScreenShot extends TestBase {

    @Test
    public void screenTest(){
        driver.get("https://www.google.com");

        // 1.Adim ==> screenshot almak icin obje olusturalim deger olarak
        // driver!imizi atayalim. Deger olarak driver'i kabul etmesi icin casting yapmamiz gerekir.
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.Adim ==> tum sayfanin screenshot'ini almak icin bir File olusturalim ve
        // dosya yolunu belirtelim

        File tumSayfaSS = new File("com.TestNGBaatch44\\src\\tumSayfa.png");

        // 3.ADim ==> olusturdugumuz file ile takescreenshot objesini iliskilendirelim

        tumSayfaSS = tss.getScreenshotAs(OutputType.FILE);

        // Eger spesifik bir webelementin screenshot'ini almak istiyorsaniz
        WebElement logoElement = driver.findElement(By.xpath("//img[@id='hplogo']"));
        File  logoResmi = new File("src/logo.png");


    }
}
