package tests.seleniumPractises;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q13 extends TestBase {

    //https://www.gmibank.com/ adresine gidip negative login test yapiniz..
    // test datalar :
    //{"username1@gmail.com","password1"},
    //{"username2@gmail.com","password2"},

    @DataProvider
    public Object[][] negativeSignInTest(){
        Object[][] bankData = new Object[3][2];
        bankData[0][0] = "username1@gmail.com";
        bankData[0][1] = "password1";
        bankData[1][0] = "username2@gmail.com";
        bankData[1][1] = "password2";
        bankData[2][0] = "username3@gmail.com";
        bankData[2][1] = "password3";

        return bankData;
    }

    //*[@id="account-menu"]/a//input[@id='username']
//input[@id='password']
//button[@type='submit']

    @Test (dataProvider = "negativeSignInTest")
    public void test(String username, String password){
        driver.get("https://www.gmibank.com");
        driver.findElement(By.xpath("(//a[@aria-haspopup='true'])[2]")).click();
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

}
