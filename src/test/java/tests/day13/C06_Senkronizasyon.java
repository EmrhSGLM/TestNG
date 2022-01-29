package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Senkronizasyon extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        /*
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-submit")).click();

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("(//a[.='info@techproeducation.com'])[2]")).click();*/

        // https://the-internet.herokuapp.com/dynamic_controls sayfasina gidin
        // disable butonuna basin
        // disable yazisinin ciktigini test edin

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Enable']")).click();
        // Thread.sleep(3000); --> hard wait

        WebElement text = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(text.isDisplayed());


    }


}
