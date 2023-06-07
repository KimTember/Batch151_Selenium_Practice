package techproed.day06_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://amazon.com");
        WebElement aramaKutus=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutus.sendKeys("City Bikes"+ Keys.ENTER);

        WebElement hybridB=driver.findElement(By.xpath("//span[text()='Hybrid Bikes']"));
        System.out.println(hybridB);
        WebElement electrikB=driver.findElement(with(By.tagName("span")).below(hybridB));
        System.out.println(electrikB);
        WebElement completeB=driver.findElement(with(By.tagName("span")).below(electrikB));
        System.out.println(completeB);

        //Bikes altındaki tüm linkleri yazdıralım

        List<WebElement> linklerListesi=driver.findElements(By.xpath("(//span[@class='a-list-item'])[position()>=8 and position()<=14]"));
        /*
        XPATH kullanımında bir sayfadaki webelementlere müdahele -etmek istediğimizde xpath ile locate aldığımızda birden
        fazla sonuc verebilir. [position()>=8 and position()<=14] bu kullanımla aralık belirterek istediğimiz webelementleri seçerek müdahele edebilirz

         */

        //lambda ile yazdırdık
        linklerListesi.forEach(t-> System.out.println(t.getText()));
        //foreach ile yazdıralım
        for(WebElement w:linklerListesi){
            System.out.println(w.getText());
        }

        //bu linklerin hepsini tıklayalım ve sayfa başlıklarıı alalım




        for (int i=0;i<linklerListesi.size();i++){
            linklerListesi=driver.findElements(By.xpath("(//span[@class='a-list-item'])[position()>=8 and position()<=14]"));
            System.out.println(linklerListesi.get(i).getText());
            linklerListesi.get(i).click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);

        }

        completeB.click();

        driver.close();






    }

}


