package tests.seleniumPractises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;

public class Q07_mrvhnm {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test ( priority=1 )
    public void n11(){
        driver.get("https://www.n11.com");
    }
    @Test ( priority=2 )
    public void gittigidiyor(){
        driver.get("https://www.gittigidiyor.com");
    }
    @Test ( priority=3 )
    public void getir(){
        driver.get("https://www.getir.com");
    }
    @Test ( priority=4 )
    public void sahibinden(){
        driver.get("https://www.sahibinden.com");
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}
