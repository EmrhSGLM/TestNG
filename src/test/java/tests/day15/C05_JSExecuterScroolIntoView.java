package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_JSExecuterScroolIntoView extends TestBase {

    //1- Yeni bir class olusturun : ScroolInto
    //2- hotelmycamp anasayfasina gidin
    //3- 2 farkli test method’u olusturarak actions clasi ve
    //   Js Executor kullanarak asagidaki oda turlerinden ust sira ortadaki odayi tiklayin
    //4- istediginiz oda inceleme sayfasi acildigini test edin

    @Test
    public void scroolAction() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]")).click();
        Thread.sleep(3000);
    }

    @Test
    public void scroolJsExecuter() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com");

        // 1.Adim : JsExecuter objesi olustur ve driver'i cast et

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //2.Adim : calisacagimiz web elementi locate edelim
        WebElement odaInceleLinki = driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));

        // 3.Adim : ilgili script ve argument le js.executescript() calisir

        jse.executeScript("arguments[0].scrollIntoView(true);", odaInceleLinki );
        Thread.sleep(3000);
        jse.executeScript("arguments[0].click();", odaInceleLinki);
        Thread.sleep(3000);

    }
}
