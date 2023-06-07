package techproed.exercises;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Manage300523 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://amazon.com");
        System.out.println("Sayfanın Boyutları = " + driver.manage().window().getSize());
        System.out.println("Sayfanın Konumu = " + driver.manage().window().getPosition());
        driver.manage().window().setPosition(new Point(300,300));
        Thread.sleep(3000);
        driver.manage().window().setSize(new Dimension(50,50));
        Thread.sleep(3000);

        //boyut testi yapamadım

        driver.close();


    }

}
