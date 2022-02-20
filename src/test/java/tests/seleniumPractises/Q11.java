package tests.seleniumPractises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q11 extends TestBase {

    // https://www.amazon.com adresine gidin
    // araba, ev, anahtarlik, ayakkabi, gomlek  kelimelerini arayiniz

    @Test (dataProvider = "urunler")
    public void amazonTest(String kelime){
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(kelime, Keys.ENTER);

    }

    @DataProvider(name="urunler")
    public Object[][] getUrunler(){
        String[][] urunler={{"araba"}, {"ev"}, {"anahatrlik"}, {"ayakkabi"}, {"gomlek"}};
        //Object[][] urunler={{"araba"}, {"ev"}, {"anahatrlik"}, {"ayakkabi"}, {"gomlek"}};


        return urunler;
    }

    // https://www.gittigidiyor.com/ adresine gidiniz
    // java, javascript ve python kelimelerini arayiniz

    @Test (dataProvider = "aranacakKelime") // veri aldigimiz method ismi belirtilirse annotaion in oldugu yerde belirtmeye gerek yoktur
    public void gittigidiyor(String arama){
        driver.get("https://www.gittigidiyor.com");
        driver.findElement(By.xpath("//input[@name='k']")).sendKeys(arama, Keys.ENTER);

    }

    @DataProvider(name= "aranacakKelime")
    public Object[][] getAranacak(){
        Object[][] aranacakKelime={{"Java"}, {"javascript"}, {"phyton"}};
        return aranacakKelime;
    }


}
