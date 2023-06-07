package techproed.day05_xpath_cssselector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_cssSelector {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

     //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidi
     driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

     Thread.sleep(2000);
     //Add element butonuna basın
        driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();
        Thread.sleep(2000);

     //Delete butonunu görünür olduğunu test edin
       WebElement deleteButonu= driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
       if(deleteButonu.isDisplayed()) {
           System.out.println("Delte butonu Görünür");
       }else System.out.println("Delete Butonu görünmez");
        Thread.sleep(2000);
    //delete butonuna basın
        deleteButonu.click();
        Thread.sleep(2000);
        //add/remove elements yazısının gorunur olduğunu test edin
        WebElement addRemoveElements=driver.findElement(By.cssSelector("h3"));
        if(addRemoveElements.isDisplayed()) {
            System.out.println("Görünür");
        }else System.out.println("Görünür Değil");
        Thread.sleep(2000);

     //sayfayı kapatın
        driver.close();


        /*
        Xpath ve cssSelector arası farklar
        Xpath text ile çalışır, cssSelector text ile çalışmaz
        Xpath indexe göre arama yapabilir, Daha fazla kombinasyona sahiptir.
        cssSelector indexe göre arama yapamaz
        cssSelector daha hızlı çalışır

         */
    }
}
