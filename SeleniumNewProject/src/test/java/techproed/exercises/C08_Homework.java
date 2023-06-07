package techproed.exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Homework {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://facebook.com");
        String actualTitle = driver.getTitle();
        String gorunen = "Facebook";


        if (actualTitle.contains(gorunen)) {
            System.out.println("VERIFY");
        } else System.out.println(actualTitle + "FAILED TITLE");

        if (driver.getCurrentUrl().contains("facebook")) {
            System.out.println("Contains Facebook");
        } else System.out.println(driver.getCurrentUrl());

        driver.get("https://www.walmart.com/");
        String wtitle = driver.getTitle();
        if (wtitle.contains("Walmart.com")) {
            System.out.println("contains Walmart.com");}else System.out.println(wtitle+"FAILED");
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().refresh();
            Thread.sleep(2000);
            driver.manage().window().maximize();
            Thread.sleep(2000);

            driver.close();


        }
    }

