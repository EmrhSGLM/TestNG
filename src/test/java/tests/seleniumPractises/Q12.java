package tests.seleniumPractises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q12 extends TestBase {

    // Siteyi açınız. http://opencart.abstracta.us/index.php?route=account/login ,
    // login yapiniz Email: batch44@gmail.com   password : 123456789
    // Search fonksiyonunu kullanarak
    // Mac,ipod ve samsung icin Dataprovider ile yapınız.

    @Test (dataProvider = "getArama")
    public void test(String text){
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("batch44@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement searchArea = driver.findElement(By.xpath("//input[@name='search']"));
        searchArea.sendKeys(text, Keys.ENTER);



    }

    @DataProvider
    public Object[][] getArama(){
        String[][] aranacakKelime= {{"Mac"}, {"ipad"}, {"samsung"}};
        return aranacakKelime;
    }

}
