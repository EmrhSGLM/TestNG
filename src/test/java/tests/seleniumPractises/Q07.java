package tests.seleniumPractises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class Q07 extends TestBase {
    //// 1) "https://www.facebook.com/" SAYFASINA GiDiN
    //        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
    //        // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
    //        // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
    //        // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN
    @Test
    public void test(){
        //// 1) "https://www.facebook.com/" SAYFASINA GiDiN
        driver.get("https://www.facebook.com/");
        //        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //        // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
        WebElement birthDay = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select option1=new Select(birthDay);
        List<WebElement> birthDayList = option1.getOptions();
        birthDayList.stream().forEach(t-> System.out.println(t.getText()));
        //        // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
        WebElement birthMonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select option2=new Select(birthMonth);
        List<WebElement> birthMonthList = option2.getOptions();
        birthMonthList.stream().forEach(t-> System.out.println(t.getText()));
        //        // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN
        WebElement birthYear = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select option3=new Select(birthYear);
        List<WebElement> birthYearList = option3.getOptions();
        birthYearList.stream().forEach(t-> System.out.println(t.getText()));
    }
}
