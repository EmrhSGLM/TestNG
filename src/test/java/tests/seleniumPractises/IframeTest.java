package tests.seleniumPractises;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class IframeTest extends TestBase {


    @Test
    public void iframeTest(){
        //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //   ● Bir metod olusturun: iframeTest
        //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
        WebElement text = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(text.isDisplayed());

        //        ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
        WebElement textBox = driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");

        //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //        dogrulayin ve  konsolda yazdirin.

        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("(//a[@target='_blank'])[2]")).click();
        String firstWin = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        String secondWin="";

        for(String w:windowHandles){
            if(!w.equals(firstWin))  {
                secondWin = w;
            }
        }
        driver.switchTo().window(secondWin);
        WebElement elementText = driver.findElement(By.xpath("//h1[.='Elemental Selenium']"));
        Assert.assertTrue(elementText.isDisplayed());
        System.out.println("elementText = " + elementText.getText());


    }
}
