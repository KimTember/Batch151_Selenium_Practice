package techproed.day05_xpath_cssselector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_RelativeLocators {
    /*
    Relative Locators
    -Bir Webelementi direk locate edemediğimiz duurmlarda, o webelementi etrafındaki web elemenetlerin
    referansı ile tarif etmemizi sağlar
    -Bir web sayfasında benzer özellikler sahip webelementlerin olduğu durumlarda kullanılabilir
    above,near,to_left_of,to_right_of

     */
    /*amazon sayfasına gidin
    city bike aratın
    Relative locator kullanarak Hybrid Bikes üstündeki road bikes a tıklayalım
    sayfayı kapatalım
     */
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://amazon.com");
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("City Bikes"+ Keys.ENTER);

        WebElement hybridB=driver.findElement(By.xpath("//span[text()='Hybrid Bikes']"));
        WebElement roadBikes=driver.findElement(with(By.tagName("span")).above(hybridB));
        roadBikes.click();
        driver.close();






    }

}
