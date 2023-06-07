package techproed.day04_locators;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_getTAgNameGetAttribute {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /*
        amazon.com sayfasına gidin
        arama kutusunu locate edin
        arama kutusunun tagName inin input olduğunu test edin
        arama kutusunun name attribute değerinin "field-keywords" olduğunu test edin.
        sayfayı kapatın

         */
        driver.get("https:www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        String actualTagName=aramaKutusu.getTagName();
        String expectedTagName="input";
        if(actualTagName.equals(expectedTagName)){
            System.out.println("Test PASSED");}else {System.out.println("Test FAILED"+actualTagName);}
        String actualAttribute=aramaKutusu.getAttribute("name");
        String expectedAttribute="field-keywords";
        if(actualAttribute.equals(expectedAttribute)){
            System.out.println("Test Passed");}
        else {
            System.out.println("Test FAILEd"+actualAttribute);
        }
        driver.close();



    }
}
