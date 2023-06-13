package techproed.day10_test_base;

import org.junit.Assert;
import org.junit.Test;
import utilities.Test_Base;

public class C01_TestBaseDemo extends Test_Base {

    //techproeducation sayfasına gidin
    //baslığın bootcamp içerdiğini kontrol edin


    @Test
    public void test01() {
        driver.get("https://techproeducation.com");
        String actualTitle=driver.getTitle();
        String expectedTitel="Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitel));

    }
}
