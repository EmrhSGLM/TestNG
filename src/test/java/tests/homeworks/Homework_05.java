package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Homework_05 extends TestBase {

    //1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    //2..“Our Products” butonuna basin
    //3.“Cameras product”i tiklayin
    //4.Popup mesajini yazdirin
    //5.“close” butonuna basin
    //6."WebdriverUniversity.com (IFrame)" linkini tiklayin
    //7."http://webdriveruniversity.com/index.html" adresine gittigini test edin

    @Test
    public void test() throws InterruptedException {
        //1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        //2.“Our Products” butonuna basin
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();
        //3.“Cameras product”i tiklayin
        driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]")).click();
        //4.Popup mesajini yazdirin
        Thread.sleep(3000);
        WebElement popupElement = driver.findElement(By.xpath("//div[@class='modal-body']"));
        System.out.println("Popup mesage : " + popupElement.getText());
        //5.“close” butonuna basin
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]")).click();
        driver.switchTo().defaultContent();
        //6."WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();
        //7."http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        Assert.assertEquals(actualUrl,expectedUrl);

    }
}
