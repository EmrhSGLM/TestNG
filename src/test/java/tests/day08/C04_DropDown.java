package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_DropDown {

    ////● https://www.amazon.com/ adresine gidin.
    ////                - Test 1
    ////    Arama kutusunun yanindaki kategori menusundeki kategori
    ////    sayisinin 45 oldugunu test edin
    ////                -Test 2
    ////1. Kategori menusunden Books secenegini secin
    ////2. Arama kutusuna Java yazin ve aratin
    ////3. Bulunan sonuc sayisini yazdirin
    ////4. Sonucun Java kelimesini icerdigini test edin


    WebDriver driver;
    WebElement dropdownElement;
    Select select;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test1(){
        ////                - Test 1
        ////    Arama kutusunun yanindaki kategori menusundeki kategori
        ////    sayisinin 45 oldugunu test edin
        dropdownElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropdownElement);
        List<WebElement> optionList = select.getOptions();
        int actualOption = optionList.size();
        int expectedOption = 45;
        Assert.assertEquals(expectedOption,actualOption);
    }
    @Test
    public void test2(){
        //                -Test 2
        //1. Kategori menusunden Books secenegini secin
        select.selectByIndex(5);
        //select.selectByVisibleText("Books");
        System.out.println(select.getFirstSelectedOption().getText());

        //2. Arama kutusuna Java yazin ve aratin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement result1=driver.findElement(By.xpath("//span[@dir='auto']"));
        String result = result1.getText();
        String[] resultNumber = result.split(" ");
        System.out.println("resultNumber[3] = " + resultNumber[3]);

        //4. Sonucun Java kelimesini icerdigini test edin
        String actualJava=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String expectedJava = "Java";
        Assert.assertTrue(actualJava.contains(expectedJava),"Java is not contains");
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}
