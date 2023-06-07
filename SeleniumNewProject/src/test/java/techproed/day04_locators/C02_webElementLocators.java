package techproed.day04_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_webElementLocators {
    public static void main(String[] args) {

        /*
        www.amazon.com adresine gidin
        arama kutusuna city bike yazıp aratın
        sonuc yazısını yazdırın
        sonuc sayısını yazdırın
        ilk ürünün locatini alın
        ilk ürünün görünür olup olmadığını true false şeklinde yazdırın
        ilk ürünün erişebilir olup olmadığını true false şeklinde yazdırın
        ilk ürünün seçilebilir olup olmadığını true false şeklinde yazdırın
        ilk ürüne tıklayın
        kapatın
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bikes"+ Keys.ENTER);
        List<WebElement> sonucYazilari= driver.findElements(By.className("sg-col-inner"));
        WebElement sonucYazisi=sonucYazilari.get(0);
        System.out.println(sonucYazisi.getText());

        String sonucSayisi[]=sonucYazisi.getText().split(" ");
        System.out.println(Arrays.toString(sonucSayisi));
        System.out.println(sonucSayisi[2]);



        List<WebElement> sonuclar=driver.findElements(By.className("s-image"));
        WebElement ilkUrun=sonuclar.get(0);

        boolean gorunurMu=ilkUrun.isDisplayed();
        System.out.println("görünme durumu="+gorunurMu);

        boolean erisilebirirMi=ilkUrun.isEnabled();
        System.out.println("Erişilebiliyor mu?"+erisilebirirMi);

        boolean secilebilirMi=ilkUrun.isSelected();
        System.out.println("Seçilebilir mi?="+secilebilirMi);

        ilkUrun.click();

        driver.close();










    }
}
