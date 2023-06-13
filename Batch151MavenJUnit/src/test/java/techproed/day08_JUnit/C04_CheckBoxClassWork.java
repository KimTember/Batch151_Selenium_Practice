package techproed.day08_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v111.audits.model.TrustedWebActivityIssueDetails;

import java.time.Duration;

public class C04_CheckBoxClassWork {
    /*
    https://the-internet-herokuapp.com/checkboxes sayfasına gidin
    CheckBox01 ve checkbox 02 elementlerini locate edin
    checkbox1 seçili değilse seçin
    checkbox02 seçili değilse seçin

     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void CheckBox() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement ilkCheckbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement ikinciCheckBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        if (!ilkCheckbox.isSelected()) {
            ilkCheckbox.click();
        }
        if (!ikinciCheckBox.isDisplayed()) {
            ikinciCheckBox.click();

        }
    }
}
