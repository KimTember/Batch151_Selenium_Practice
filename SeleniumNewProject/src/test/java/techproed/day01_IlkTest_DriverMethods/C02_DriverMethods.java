package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {


        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://amazon.com");
        System.out.println("Amazon sayfa başlığı= " + driver.getTitle());
        System.out.println("Amazon- actual URL = " + driver.getCurrentUrl());

        driver.get("https://techproeducation.com");
        System.out.println("Techproed Actual sayfa başlığı = " + driver.getTitle());//gettitle sayfa başlığını verir
        //getCurrentUrl()methodu ile gdilen sayfanın url ini verir
        System.out.println("techproed- actual URL = " + driver.getCurrentUrl());
        //getPageSource() açılan sayfanın kaynak kodlarını beriri

       //System.out.println("Techpro Kaynak Kodları = " + driver.getPageSource());

        //getWindowHandle gidilen sayfanın handle değerini  verir(Hashcode). Bu handle değerini sayfalara arası geçiş için kullanırız

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

    }
}
