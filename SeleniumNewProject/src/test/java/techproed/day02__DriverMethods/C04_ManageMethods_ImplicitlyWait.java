package techproed.day02__DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;

import java.time.Duration;

public class C04_ManageMethods_ImplicitlyWait {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*Sayfadaki webelementleri görünür olana kadar(sayfada oluşana kadar) maksimum 20 saniye bekler
        eğer webelemenler 2 saniyede oluşursa 2 saniye bekler ve alt satıra geçer.Fakat belirttiğimiz max süre boyunca
        internetten yada sayfadan kaynaklı olarak webelementler oluşmazsa testimiz fail verir.
        Thread.sleep() java kodlarını bizim belirttiğimiz süre kadar bekler 30 saniye nkletmesini istersem 30 saniye
        bekler ve alt satıra geçer
         */

        /*
        Techproed sayfasına gidelim
        amazona gidelim
        techpro ya geri dönelim
        sayfa başlığının techpro içerdiğini test edelim
        tekrar amazon sayfasına gidelim
        sayfa başlığının amazon içerdiğini test edelim
         */


        driver.get("https://techproeducation.com");
        driver.get("https://amazon.com");
        driver.navigate().back();
        String actualTitle=driver.getTitle();
        String arananKelime="Techpro";
        if (actualTitle.contains(arananKelime)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED"+actualTitle);
        driver.navigate().forward();
        if(driver.getTitle().contains("Amazon")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");
        driver.close();

    }
}
