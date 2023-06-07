package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_FindElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*
        amazonsayfasına gidin
        amazon sayfasında kaç tane link oluğunu yazdırın
        linkleri konsolda yazdırın
        sayfayı kapatın

         */


        driver.get("https://amazon.com");
        List<WebElement> linklerListesi= driver.findElements(By.tagName("a"));
        System.out.println("Linklerin Sayısı="+linklerListesi.size());

        for(WebElement each:linklerListesi){
            System.out.println(each.getText());
        }


    }
}
