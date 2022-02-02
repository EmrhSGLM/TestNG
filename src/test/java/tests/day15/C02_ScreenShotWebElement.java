package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenShotWebElement extends TestBase {

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
        // testin calisdiginin ispati icin sonuc yazisi webelementinin screenshot'ini alalim

        // 1.Adim screenshot cekecegimiz webelementi locate edelim

        // 2.Adim acreenshot'i kaydetecegimiz bir file olusturalim

        File webElementSS = new File("target/screenshot/webelement.jpeg");

        // 3.Adim

        File geciciResim = sonucYazisiElementi.getScreenshotAs(OutputType.FILE);

        // 4.Adim gecici resmi kayit yapacagimiz asil dosyaya kopyaliyalim
        FileUtils.copyFile(geciciResim,webElementSS);




    }

}
