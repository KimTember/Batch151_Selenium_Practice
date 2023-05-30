package techproed.day02__DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
/*
Techproeducation sayfasın gidelim
Sonra Amazon sayfasına  gidelim
Amazon sayfasının başlığını yazdıralım
Tecproeducation sayfasıa geri dönelim
Sayfa başlığını yazdıralım
Amazon sayfasıan tekrar gidip URL'i yazdıralım
Amazon sayfasındayken sayfayı yenileyelim.
 */
        driver.navigate().to("https://techproeducation.com");
        Thread.sleep(3000);//Java kodlarını bekletmek için Thread.sleep kullanabiliriz..

        driver.navigate().to("https://amazon.com");//driver.get ile aynı
        Thread.sleep(3000);
        System.out.println("Amazon sayfa başlığı = " + driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        System.out.println("Techproed sayfa başlığı=" +driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("Amazon sayfa urlsi = " + driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.close();




    }
}
