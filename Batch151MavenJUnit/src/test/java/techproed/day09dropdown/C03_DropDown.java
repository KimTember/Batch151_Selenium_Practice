package techproed.day09dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class C03_DropDown {
    WebDriver driver;


    /*
    // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
    // Programlama Dili Dropdown'undan "Java" seciniz
    // Programlama Dili Dropdown'undan son secilen option'un "Java" oldugunu test ediniz
    // Programlama Dili Dropdown'undaki tum optionları konsolda yazdırınız
    // Sayfadaki tum Dropdown'lardaki tum optionları konsolda yazdırınız
         */

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

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
        WebElement ddmProgDili=driver.findElement(By.xpath("//select[@name='Languages']"));
        Select select=new Select(ddmProgDili);
        select.selectByVisibleText("Java");

        WebElement sonSecilen=select.getFirstSelectedOption();
        String sonSecilenStr=sonSecilen.getText();

        Assert.assertEquals("Java",sonSecilenStr);

        List<WebElement> tumOptions=select.getOptions();
        tumOptions.stream().forEach(t-> System.out.println(t.getText()));

        List<WebElement> tumOption =driver.findElements(By.tagName("option"));
        tumOption.stream().forEach(t-> System.out.println(t.getText()));



    }
}
