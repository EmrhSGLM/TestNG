package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JSExecuter extends TestBase {

    // amazon.com anasayfaya gidin
    // sell linkine JSExecuter ile tiklayin
    // ilgili sayfaya gittigimizi test edelim

    @Test
    public void test() throws InterruptedException {
        driver.get("https:www.amazon.com");

        // 1.Adim JSExecuter objesi olusturalim ve driver'i cast edelim
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // 2.Adim ilgili web elementini locate edelim

        WebElement selelementi = driver.findElement(By.xpath("//a[normalize-space()='Sell']"));

        // 3.Adim ilgili script ve argument(bizim web elementimiz) ile objemiz uzerinden
        // executerScript method'unu calistiarlim

        jse.executeScript("arguments[0].click()", selelementi);

        Thread.sleep(3000);

        // ilgili sayfaya gittigimizi test edelim

    }
}
