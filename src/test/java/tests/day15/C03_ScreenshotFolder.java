package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreenshotFolder extends TestBase {
    // amazon'a gidin
    // 3 farkli test methodu ile java, nutella ve elma aratin
    // sonuc sayfasina screenshot'i kaydedin

    WebElement searchBox;
    @Test
    public void  test1() throws IOException {
        driver.get("https://www.amazon.com");
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);
        tumSayfaScreenshot("java");
    }
    @Test
    public void  test2() throws IOException {
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("nutella" + Keys.ENTER);
        tumSayfaScreenshot("nutella");
    }
    @Test
    public void  test3() throws IOException {
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("elma" + Keys.ENTER);
        tumSayfaScreenshot("elma");
    }
}
