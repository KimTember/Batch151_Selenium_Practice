package techproed.day02__DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //Browserin konumunu yazdıralım
        //Browserın boyutlarını yazdıralım
        //Browser ı maximize yapalım
        //Techproeducation sayfasına gidelim
        //Browserin konumunu yazdıralım
        //Browserın boyutlarını yazdıralım
        //Sayfayı minimize edelim.
        //sayfayı fullscreen yapalım


        //Browserin konumunu yazdıralım
        System.out.println("Sayfanın konumu = " + driver.manage().window().getPosition());
        //Browserın boyutlarını yazdıralım
        System.out.println("Sayfanın boyutları = " + driver.manage().window().getSize());
        //Browser ı maximize yapalım

        //bir websitesine gitiğimizde browser default olarak bir boyutta gelir
        //Ve açılan browserdaki web elementlere browser maximize olmadığı için ulaşamayabiliriz
        //Dolayısıyla browseri açtıktan sonra maximize yaparsak driver bütün webElementleri görür ve rahatlıkla
        //müdahale edebilir. Bu yüzden browserı açtıktan sonra ilk olarak driver.manage().window().maximize(); yapmamız
        //bizim webelementlere ulaşmada işimizi kolaylaştırır. Böylelikle dail almamış oluruz

        driver.manage().window().maximize();

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //Browserin konumunu yazdıralım
        Thread.sleep(3000);
        System.out.println("Sayfanın Konumu = " + driver.manage().window().getPosition());
        //Browserın boyutlarını yazdıralım
        Thread.sleep(3000);
        System.out.println("Sayfanın Boyutları= " + driver.manage().window().getSize());
        //Sayfayı minimize edelim.
        Thread.sleep(3000);
        driver.manage().window().minimize();
        //sayfayı fullscreen yapalım
        Thread.sleep(3000);
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        driver.manage().window().setPosition(new Point(0,0));
        Thread.sleep(3000);
        driver.manage().window().setSize(new Dimension(600,600));
        Thread.sleep(3000);

        driver.close();







    }
}
