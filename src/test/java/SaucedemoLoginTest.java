import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SaucedemoLoginTest {

    @Test
    public void soucedemoLogin() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        browser.get("https://www.saucedemo.com/");
        WebElement username = browser.findElements(By.tagName("input")).get(0);
        username.sendKeys("standard_user");
        WebElement password = browser.findElements(By.tagName("input")).get(1);
        password.sendKeys("secret_sauce");
        password.submit();
        WebElement conformationOfLogin = browser.findElement(By.className("product_label"));
        String productText = conformationOfLogin.getText();
        assertEquals(productText,"Products","Do not pass enterense");
        browser.quit();
    }
}