package techproed.day05_xpath_cssselector;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Xpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /*https://amazon.com adresine gidin
        arama kutusuna "city bike" yazıp aratın

        Hybrid bikes bölümüne tıklayın
        sonuc sayısını yazdırın
        ilk ürüne tıklayın
        sayfayı kapatın
         */

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("city Bike"+ Keys.ENTER);


        WebElement hybridBikes=driver.findElement(By.xpath("//span[text()='Hybrid Bikes']"));
        hybridBikes.click();

        WebElement sonuc=driver.findElement(By.xpath("//span[text()='15 results for']"));
       String sonnnn[]= sonuc.getText().split(" ");
        System.out.println(sonnnn[0]);


        driver.findElement(By.xpath("(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]")).click();

        driver.close();







    }
}
