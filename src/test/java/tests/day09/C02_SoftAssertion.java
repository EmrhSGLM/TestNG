package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C02_SoftAssertion {

    //Yeni bir Class Olusturun : C03_SoftAssert
    //1. “http://zero.webappsecurity.com/” Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password” yazin
    //5. Sign in tusuna basin
    //6. Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
    //         "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
    //          "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
    //          "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)",
    //          "Sweden (krona)","Singapore (dollar)","Thailand (baht)"
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test01(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Sign in butonuna basin
        driver.findElement(By.className("icon-signin")).click();
        //3. Login kutusuna “username” yazin
        WebElement loginBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginBox.sendKeys("username");
        //4. Password kutusuna “password” yazin
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        // Guvenlik
        //driver.findElement(By.xpath("//button[@id='details-button']")).click();
        //driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        driver.navigate().back();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@name='currency']"));
        Select select = new Select(dropdownElement);
        select.selectByIndex(6);
        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        String actualOption = select.getFirstSelectedOption().getText();
        String expectedOption = "Eurozone (euro)";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualOption,expectedOption,"Dropdown dogru kullanilamadi");
        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        //         "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
        //          "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        //          "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)",
        //          "Sweden (krona)","Singapore (dollar)","Thailand (baht)"
        List<WebElement> optionList = select.getOptions();
        String actualOptionListString = "" ;
        for(WebElement w:optionList) {
            actualOptionListString += "\"" + w.getText() + "\", ";
        }
        actualOptionListString = actualOptionListString.substring(0, actualOptionListString.length()-2);
        String expectedLisyString = "\"Select One\", \"Australia (dollar)\", \"Canada (dollar)\"," +
                " \"Switzerland (franc)\", \"China (yuan)\", \"Denmark (krone)\"," +
                " \"Eurozone (euro)\", \"Great Britain (pound)\", \"Hong Kong (dollar)\"," +
                " \"Japan (yen)\", \"Mexico (peso)\", \"Norway (krone)\", \"New Zealand (dollar)\"," +
                " \"Sweden (krona)\", \"Singapore (dollar)\", \"Thailand (baht)\"";;
        softAssert.assertEquals(actualOptionListString,expectedLisyString);
        softAssert.assertAll();;
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}
