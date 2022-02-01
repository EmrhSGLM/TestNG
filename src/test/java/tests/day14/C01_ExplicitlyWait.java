package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {

    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //     Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin

    @Test
    public void impilicitlyWaitTesti() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement actualText = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(actualText.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement actualText1 = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(actualText1.isDisplayed());
    }

    @Test
    public void explicitlyWaitTesti() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // explicitly wait kullanabilmek icin once wait ocjesi olusturmaliyiz
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

       /*
       WebElement itsGoneElementi = driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneElementi));

     her ne kadar kodun anlasilabilir olmasi icin once locate edelim sonra
     bekleyelim yaklasimi daha guzel gorunse de web elemen zatem gorunur olmadigindan locate etmemiz de mumkun olmayacaktır
     bu durumda locate ve wait islemi beraber yapmak gerekir*/

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement itsGoneElement = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneElement.isDisplayed());

        //6. Add buttonuna basin
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[1]")));
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElement = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElement.isDisplayed());
    }
}