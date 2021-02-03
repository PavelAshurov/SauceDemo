import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

import static javax.swing.text.html.CSS.getAttribute;

public class AddingToShopingCartTest {
    @Test
    public void addingToShopingCast(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        browser.get("https://www.saucedemo.com/inventory");
       browser.findElement(By.xpath("//*[contains(text(),'Sauce Labs Bolt T-Shirt')]/../../..//button")).click();
       browser.findElement(By.xpath("//*[contains(text(),'Sauce Labs Bike Light')]/../../..//button")).click();
       String cartLink = browser.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).getAttribute("href");
       browser.get(cartLink);
       int amountOfUnits = browser.findElements(By.cssSelector(".inventory_item_name")).size();
       assertEquals(amountOfUnits,2);

    }
}
