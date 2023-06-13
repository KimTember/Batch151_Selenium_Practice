package techproed.day09dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
    WebDriver driver;


    /*
    getFirstSelectedOption() == dropdown da en son seçtiğimiz opsiyonu döndürmek için kullanılır
    getOptions() dropdown daki tüm opsiyonları bize döndürür.


     */

    // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
// Select a State Dropdown'undan "Arizona" seciniz
    // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz
    // Select a State Dropdown'undaki tum optionları konsolda yazdırınız


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() throws Exception {
        //driver.close();

    }

    @Test
    public void test01() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement ddmsstate = driver.findElement(By.xpath("//select[@id='state']"));
        Select select = new Select(ddmsstate);
        select.selectByVisibleText("Arizona");

        WebElement sonSecilen = select.getFirstSelectedOption();
        String sonSecilenStr = sonSecilen.getText();
        Assert.assertEquals("Arizona", sonSecilenStr);

        List<WebElement> tumOptionlar = select.getOptions();

        /*for (WebElement each:tumOptionlar
             ) {
            System.out.println(each.getText());
          */

        //lambda ile yazdıralım
        tumOptionlar.stream().forEach(t -> System.out.println(t.getText()));


        //======================tum opsiyonları almanın 2. yolu================================
        List<WebElement> tumSecimler=driver.findElements(By.xpath("//select[@id='state']//option"));
        tumSecimler.stream().forEach(t->t.getText());






    }

}
