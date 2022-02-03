package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {

    protected WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void teardown(){
       driver.quit();
    }

    public void tumSayfaScreenshot(String str) throws IOException {
        TakesScreenshot tss = (TakesScreenshot) driver;

        File tumSayfaSS = new File("target/screenshot/"+str+".jpg");

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim , tumSayfaSS);
    }

    public void webElementScreenshot(){

    }

    public void tumSayfaScreenshot() throws IOException {
        TakesScreenshot tss=(TakesScreenshot) driver;
        String tarih=new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        File tumSayfa= new File("target/screenShot/tumSayfa"+tarih+".jpg");
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tumSayfa);
    }
}
