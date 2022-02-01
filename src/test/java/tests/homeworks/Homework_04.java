package tests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Homework_04 extends TestBase {

    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin

    @Test
    public void test(){
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverButton = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverButton).perform();
        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
        //4. Popup mesajini yazdirin
        System.out.println("Pop mesaji : "+driver.switchTo().alert().getText());
        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. "Click and hold" kutusuna basili tutun
        WebElement holdButton = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(holdButton).perform();
        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Text : " + holdButton.getText());
        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickMeButton = driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClickMeButton).perform();
    }

}
