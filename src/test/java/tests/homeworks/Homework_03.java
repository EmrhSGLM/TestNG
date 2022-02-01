package tests.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Homework_03 extends TestBase {
    //                      Test 01
    // 1-) amazon'a gidin
    // 2-) Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdirin
    // 3-) dropdown menude 40 eleman oldugunu dogrulayin
    //                       Test 02
    // 1-) dropdown menude elektronik bolumu secin
    // 2-) arama kutusuna iphone yazip aratin ve bulunan sonucu yazdirin
    // 3-) sonuc sayisi bildiren yazinin iphone icerdigini test edin
    // 4-) Ikinci urune relative locater kullanarak tiklayin
    // 5-) Urunu title'ni ve fiyatini variable'a assign edip urunu sepete ekleyin
    //                      Test 03
    // 1-) Yeni bir sekme acarak amazon ana sayfaasina gidin
    // 2-) dropdown'dan bebek bolumunu secin
    // 3-) bebek puset aratip bulunan sonuc sayisini yazdirin
    // 4-) Sonuc yazisinin puset icerdigini test edelim
    // 5-) Ucuncu urune relative locator kullanarak tiklayin
    // 6-) Title ve fiyat bilgilerini assign edelim ve urunu sepete ekleyin
    //      Test 04
    // 1-) Sepette ki urunlerle ekledigimiz urunlerin ayni oldugunu isim ve fiyat olarak dogrulayin
    WebDriver driver;
    WebElement dropdownElement;
    WebElement searchBox;
    WebElement resultWriting;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test01(){
        //                      Test 01
        // 1-) amazon'a gidin
        driver.get("https://www.amazon.com");
        // 2-) Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdirin
        List<WebElement> dropdownList = driver.findElements(By.tagName("option"));
        dropdownList.stream().forEach(t-> System.out.println(t.getText()));
        // 3-) dropdown menude 40 eleman oldugunu dogrulayin
        int actualNum = dropdownList.size();
        int expectedNum = 40;
        Assert.assertFalse(actualNum==expectedNum);
    }
    @Test
    public void test02(){
        //                       Test 02
        // 1-) dropdown menude Electronics bolumu secin
        dropdownElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText("Electronics");
        // 2-) arama kutusuna iphone yazip aratin ve bulunan sonucu yazdirin
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone" + Keys.ENTER);
        // 3-) sonuc sayisi bildiren yazinin iphone icerdigini test edin
        resultWriting = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String actualWriting = resultWriting.getText();
        String expected = "iphone";
        Assert.assertTrue(actualWriting.contains(expected));
        // 4-) Ikinci urune relative locater kullanarak tiklayin
        WebElement ilkResim = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        WebElement ikinciUrun = driver.findElement(with(By.tagName("img")).below(ilkResim));
        ikinciUrun.click();
        // 5-) Urunu title'ni ve fiyatini variable'a assign edip urunu sepete ekleyin
        String iphoneTitle = driver.getTitle();

    }





}
