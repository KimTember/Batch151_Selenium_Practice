package techproed.day09dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown {
    WebDriver driver;





    /*Dropdown: Alt başlıkların olduğu açılır menu listesidir
    Dropdown 3 adımda handle edilir
    1)Dropdown locate edilmelidir.
    2)Select objesi oluşturulmalıdır.
    Select select =new Select(ddm)

    3)Opsiyonlardan 1 tanesi seçilmelidir

    -selectbyVisibleText() optiona görünür metin ile ulaşılmak için kullanılır
    -selectbyIndex() optiona index ile ulaşmak için kullanılır 0 dan başlar
    -selectbyValue() optiona değer ile ulaşmak için kullanılır


     */

    // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
    // Yıl Drodown'undan "2020" seciniz
    // Ay Dropdown'undan "August" seciniz
    // Gün Dropdown'undan "5" seciniz


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement ddmYil=driver.findElement(By.xpath("//select[@id='year']"));
        Select select=new Select(ddmYil);
        select.selectByVisibleText("2020");
        //select.selectByIndex(3);
       // select.deselectByValue("2020"); html kodunda value yazıyor
        WebElement ddmAy=driver.findElement(By.xpath("//select[@id='month']"));
        Select select1=new Select(ddmAy);
        select1.selectByVisibleText("August");


        WebElement ddmGun=driver.findElement(By.xpath("//select[@id='day']"));
        Select select2=new Select(ddmGun);
        select2.selectByVisibleText("5");


    }
}
