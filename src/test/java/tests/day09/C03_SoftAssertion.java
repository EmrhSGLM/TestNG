package tests.day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {

    @Test
    public void test(){
        int a=10;
        int b=20;
        int c=30;

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(a,b,"1. test basarisiz");//failed
        softAssert.assertTrue(a>b,"2. test basarisiz"); // failed
        softAssert.assertTrue(a<c,"3. test basarisiz"); // failed
        softAssert.assertTrue(c>b,"4. test basarisiz"); // passed
        softAssert.assertTrue(c>a,"5. test basarisiz"); // passed

        //assertAll demezsek class calisir pass yazar
        // Cunku aslinda raporlama yapmaz kodlar calismis olur
        softAssert.assertAll();
    }
}
