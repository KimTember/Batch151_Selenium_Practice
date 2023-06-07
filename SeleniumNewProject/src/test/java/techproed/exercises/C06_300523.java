package techproed.exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_300523 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://amazon.com");
        System.out.println("Pozisyonu min= " + driver.manage().window().getPosition());
        System.out.println("Büyüklüğü min= " + driver.manage().window().getSize());
        driver.manage().window().minimize();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        System.out.println("Pozisyonu max= " + driver.manage().window().getPosition());
        System.out.println("Büyüklüğü max= " + driver.manage().window().getSize());
        driver.manage().window().fullscreen();
        System.out.println("Pozisyonu fs= " + driver.manage().window().getPosition());
        System.out.println("Büyüklüğü fs= " + driver.manage().window().getSize());
        driver.close();
    }
}
