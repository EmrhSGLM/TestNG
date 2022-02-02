package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_Screenshot extends TestBase {

    @Test
    public void nutellaTesti() throws IOException {
        // amazon anasayfa'ya gidelim
        driver.get("https://www.amazon.com");

        // nutella icin arama yapalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin nutella icerdigini test edelim
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiStr = sonucYazisiElementi.getText();

        Assert.assertTrue(sonucYazisiStr.contains("Nutella"));
        // testin calisdiginin ispati icin tum sayfanin screenshot'ini alalim

        // tum sayfa screenShot icin 4 adim gerekli
        // 1.Adim TakeScreenShot objesi olusturma

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.Adim kaydedecegimiz dosyayi olusturalim

        File tumSayfaSS = new File("target/screenshot/tumsayfa.png");

        // 3.Adim bir dosya daha olusturup screenshot objesi ile screenshot'i alalim

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 4.Adim gecici resim kaydetmek istedigimiz asil dosyaya copy yapalim

        FileUtils.copyFile(geciciResim,tumSayfaSS) ;



    }


}
