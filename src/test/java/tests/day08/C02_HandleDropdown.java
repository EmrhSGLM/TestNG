package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropdown {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void dropdownTesti() throws InterruptedException {
        // Dropdown'dan var olan seceneklerden birini secmek icin
        // 1.Adim : Dropdown webelementini locate edip bir degiskene atiyoruz
        driver.get("https://www.amazon.com");
        WebElement dropdownElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2.Adim : Slect class'indan bir obje olusturalim
        // ve parametre olarak locate ettigimiz WebElementini

        Select select = new Select(dropdownElementi);

        // 3. Adim : Select objesini kullanarak, Select class'indan var olan 3 secim method'undan
        // istedigimizi kullanarak dropdown'da var olan option'lardan birini secebiliriz
        // Secim yapmamiza yardim eden bu 3 method void'dir dolayisiyla bize bir sey dondurmezler

        select.selectByIndex(3);

        //Eger sectigimiz option degerini yazdirmak istersek
        System.out.println(select.getFirstSelectedOption().getText()); // BabybleText("Deals");

        select.selectByValue("search-alias=arts-crafts-intl-ship");

        List<WebElement> optionList = select.getOptions();
        optionList.stream().forEach(t-> System.out.println(t.getText()));

    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
