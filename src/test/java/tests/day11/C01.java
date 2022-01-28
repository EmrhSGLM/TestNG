package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01 {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void handleWindows() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String windowHamdleDegeri1=driver.getWindowHandle();
        System.out.println("Ilk sayfanin windowHandle degeri"+driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.WINDOW); // Yeni bir pencere de yeni bir pencere acilir
        driver.get("https://www.bestbuy.com");
        String windowHamdleDegeri2=driver.getWindowHandle();
        System.out.println("2. sayfanin handle degeri : " + driver.getWindowHandle());

        Set<String> handleDegerleriSet =  driver.getWindowHandles();
        System.out.println(handleDegerleriSet);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");

        //amazon'un acik oldugu sayfa'ya gecin ve nutella icin arama yapın
        Thread.sleep(2000);
        driver.switchTo().window(windowHamdleDegeri1);
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("nutella" + Keys.ENTER);

        //bestbuy acik olan sayfaya gecin ve title'in bestbuy icerdigini test edin
        driver.switchTo().window(windowHamdleDegeri2);
        Assert.assertTrue(!driver.getTitle().contains("bestbuy"));


        // facebook'un acik oldugu sayfaya gecin
        // ve url'nin https://www.facebook.com oldugunu test edin
        // eger acik olan pencerelerden sadece bir tanesini window ghandle degerini bilimiyorsa
        // once tum handle degerlerini bulup bir set'e koyariz

        handleDegerleriSet = driver.getWindowHandles();

        // Bu soru icin su anda set'te 3 windowHandle degeri var
        // 1. ve 2. sayfanin windowHandle degerlerini biliyoruz
        // setimizde olup, ilk iki sayfa olmayan handle degeri 3. sayfanin handle degeri olacaktir
        String windowHandleDegeri3="";

        for(String w:handleDegerleriSet){
            if(!w.equals(windowHamdleDegeri1)  &&  !w.equals(windowHamdleDegeri2)) {
                windowHandleDegeri3=w;
            }
        }
        System.out.println(windowHandleDegeri3);
        System.out.println(handleDegerleriSet);
        driver.switchTo().window(windowHandleDegeri3);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");


        Thread.sleep(2000);
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
