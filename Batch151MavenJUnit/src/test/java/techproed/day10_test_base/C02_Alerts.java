package techproed.day10_test_base;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Test_Base;

public class C02_Alerts extends Test_Base {
    /*

https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın,
    uyarıdaki OK butonuna tıklayın
    ve result mesajının “You successfully clicked an alert” oldugunu test edin.

    Bir metod olusturun: dismissAlert
    2. butona tıklayın,
    uyarıdaki Cancel butonuna tıklayın
    ve result mesajının “successfuly” icermedigini test edin.

    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın,
    uyarıdaki mesajı konsolda yazdırın,
    uyarıdaki metin kutusuna isminizi yazin,
    OK butonuna tıklayın
    ve result mesajında isminizin görüntülendiğini doğrulayın.
            
            */

    @Test
    public void acceptAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult, actualResult);


        Thread.sleep(3000);


    }

    @Test
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String resultMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "succesfully";
        Assert.assertFalse(resultMessage.contains(expectedResult));


    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        String alertText=driver.switchTo().alert().getText();
        System.out.println("Uyarı yazısı= " + alertText);

        driver.switchTo().alert().sendKeys("Hakan");
        driver.switchTo().alert().accept();
        String actualResultt=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(actualResultt.contains("Hakan"));


    }

    public void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}


