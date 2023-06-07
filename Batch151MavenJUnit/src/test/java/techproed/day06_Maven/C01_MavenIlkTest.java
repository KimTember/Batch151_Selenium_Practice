package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
        https://amazon.com adresine git
        arama kutusunu locate et
        Samsung headphones ile arama yap
        bulunan sonuc sayısını yazdır
        ilk ürünü tıkla
        sayfadaki tüm baslıkları yazdır

         */
        driver.get("https://amazon.com");
        WebElement aramaKutuu=driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        aramaKutuu.sendKeys("Samsung Headphones"+ Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String [] sonucSayisi=sonucYazisi.getText().split(" ");
        System.out.println("Sonuç Sayısı = " + sonucSayisi[2]);

        driver.findElement(By.xpath("(//h2//a)[1]")).click();


        //sayfadaki tüm başlıkları yazdıralım

        List<WebElement> basliklar=driver.findElements(By.xpath("//h1 | //h2"));
        basliklar.forEach(t-> System.out.println(t.getText()));





    }
}
