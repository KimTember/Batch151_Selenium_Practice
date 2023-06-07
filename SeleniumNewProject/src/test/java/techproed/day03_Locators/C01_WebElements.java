package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /* www.amazon.com adresine gidiniz
        aramakutusunu locate ediniz ve nutella aratınız
        sayfayı kapatın
         */
    driver.get("https://www.amazon.com");
    WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
    aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

   // driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        /*
        Eğer bir WebElementi birden fazla kere kullanmayacaksanız bir webelemente assign etmeyebilirsiniz.

         */
    //Thread.sleep(3000);
    driver.close();


    }
}
