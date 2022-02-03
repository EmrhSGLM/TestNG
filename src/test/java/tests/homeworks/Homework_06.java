package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class Homework_06 extends TestBase {

    //1."http://webdriveruniversity.com/" adresine gidin
    //2."Login Portal" a kadar asagi inin
    //3."Login Portal" a tiklayin
    //4.Diger window'a gecin
    //5."username" ve "password" kutularina deger yazdirin
    //6."login" butonuna basin
    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    //8.Ok diyerek Popup'i kapatin
    //9.Ilk sayfaya geri donun
    //10.Ilk sayfaya donuldugunu test edin

    @Test
    public void test01(){
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com");
        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[.='LOGIN PORTAL']")).click();
        //4.Diger window'a gecin
        String firstWin=driver.getWindowHandle();
        Set<String> windowHandlesList= driver.getWindowHandles();
        for(String w:windowHandlesList){
            driver.switchTo().window(w);
        }
        //5."username" ve "password" kutularina deger yazdirin
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='text']"));
        WebElement emailBox = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginBox = driver.findElement(By.xpath("//button[@id='login-button']"));
        usernameBox.sendKeys("xyz@gmail.com");
        emailBox.sendKeys("xyz1234!");
        //6."login" butonuna basin
        loginBox.click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        Assert.assertTrue(driver.switchTo().alert().getText().contains("validation failed"));
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(firstWin);
        //10.Ilk sayfaya donuldugunu test edin
        WebElement firstPageText = driver.findElement(By.xpath("//a[@id='nav-title']"));
        Assert.assertTrue(firstPageText.isDisplayed());

    }
}
