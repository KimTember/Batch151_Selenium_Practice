package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /* https://testpages.herokuapp.com/styled/calculator adresine gidin
        ilk kutucuğa 20 girin
        ikinci kutucuğa 30 girin
        calculate e tıklayın
        sonucu yazdırın
        sayfayı yazdırın

         */
        driver.get("https://testpages.herokuapp.com/styled/calculator");
        WebElement ilkKutucuk=driver.findElement(By.xpath("//input[@id='number1']"));
        ilkKutucuk.sendKeys("20");
        WebElement ikinciKutucuk=driver.findElement(By.xpath("//input[@id='number2']"));
        ikinciKutucuk.sendKeys("30");

        WebElement calcuate=driver.findElement(By.xpath("//input[@id='calculate']"));
        calcuate.click();

        WebElement sonuc=driver.findElement(By.xpath("//span[@id='answer']"));
        System.out.println("Toplama işleminin sonucu="+ sonuc.getText());

        driver.close();






    }
}
