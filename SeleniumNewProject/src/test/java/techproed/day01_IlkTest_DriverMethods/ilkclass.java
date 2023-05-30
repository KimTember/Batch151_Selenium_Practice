package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ilkclass {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        //Java uygulamalarında system özelliklerini ayarlamak için setProperty methodu ile kullanırız
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        //getProperty ile "key" Değerini girererk "value" ya ulaşabilirim


        WebDriver driver= new ChromeDriver();



       driver.get("https://www.techproeducation.com");
    }
}
