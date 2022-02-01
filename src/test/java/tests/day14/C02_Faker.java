package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {
    //"https://facebook.com"  Adresine gidin
    //“create new account”  butonuna basin
    //“firstName” giris kutusuna bir isim yazin
    //“surname” giris kutusuna bir soyisim yazin
    //“email” giris kutusuna bir email yazin
    //“email” onay kutusuna emaili tekrar yazin
    //Bir sifre girin
    //Tarih icin gun secin
    //Tarih icin ay secin
    //Tarih icin yil secin
    //Cinsiyeti secin
    //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    //Sayfayi kapatin

    @Test
    public void facebookKayitTesti() throws InterruptedException {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //“firstName” giris kutusuna bir isim yazin
        WebElement firstNameBox = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();

        actions.click(firstNameBox).
                sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).
                //“surname” giris kutusuna bir soyisim yazin
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                //“email” giris kutusuna bir email yazin
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                //Bir sifre girin
                sendKeys(faker.internet().password()).
                //Tarih icin gun secin
                sendKeys(Keys.TAB).
                sendKeys("Jan").
                //Tarih icin ay secin
                sendKeys(Keys.TAB).
                sendKeys("15").
                //Tarih icin yil secin
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("2020").
                //Cinsiyeti secin
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).perform();

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement erkekSecimElement = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement kadinSecimElement = driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertTrue(erkekSecimElement.isSelected());
        Assert.assertFalse(kadinSecimElement.isSelected());

        Thread.sleep(3000);

    }
}
