package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.home")); //"C:\Users\derdi"

        //masaustundeki Deneme klasorunun path i
        // "C:\Users\derdi\OneDrive\Masaüstü\Deneme\Selenium.xlsx"

        // Yani dinamik olarak masaustunde ki Denem klasorunun path'ini yazmak istersem

        String path = System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\Deneme\\Selenium.xlsx";

        System.out.println("path = " + path);

        System.out.println("user.dir : " + System.getProperty("user.dir"));

        // Masaustunde Deneme klasoru icerisinde Selenium.xlsx isminde bir dosya oldugunu test edin
        // ******************** MasaUstunde Deneme klasoru ve icinde Selenium.xlsx olmazsa CALISMAZ ****************
        // 1- once bu dosyaya ulasmak icin gerekli dinamik path olusturalim
        String dosyaYolu = System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\Deneme\\Selenium.xlsx";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        // projemizde pom.xmloldugunu test edin
        //C:\Users\derdi\eclipse-workspace\com.TestNGBatch44\pom.xml

        System.out.println(System.getProperty("user.dir")); // projemin yolunu verir
        // C:\Users\derdi\eclipse-workspace\com.TestNGBatch44

        String pomPath = System.getProperty("user.dir") + "\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(pomPath)));


    }

}
