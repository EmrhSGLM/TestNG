package tests.day14;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    //1- Amazon anasayfaya gidin
    //2- tum cookie’leri listeleyin
    //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
    //6- eklediginiz cookie’nin sayfaya eklendigini test edin
    //7- ismi skin olan cookie’yi silin ve silindigini test edin
    //8- tum cookie’leri silin ve silindigini test edin

    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        cookieSet.stream().forEach(t -> System.out.println(t));

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSet.size() > 5);

        //4- ismi i18n-prefs olan cookie degerinin
        // "USD" oldugunu test edin
        Cookie cookie118n = driver.manage().getCookieNamed("i18n-prefs");
        System.out.println("cookie118n degeri : " + cookie118n);
        Assert.assertTrue(driver.manage().getCookieNamed("i18n-prefs").getValue().equals("USD"))  ;

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie myCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(myCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Set<Cookie> cookieSet1 = driver.manage().getCookies();
        cookieSet1.stream().forEach(t -> System.out.println(t));
        Assert.assertTrue(cookieSet1.contains(myCookie));

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Set<Cookie> cookieSet2 = driver.manage().getCookies();
        cookieSet2.stream().forEach(t -> System.out.println(t));
        Assert.assertFalse(cookieSet2.contains("skin"));

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Set<Cookie> cookieSet3 = driver.manage().getCookies();
        Assert.assertTrue(cookieSet3.size()==0);
    }
}
