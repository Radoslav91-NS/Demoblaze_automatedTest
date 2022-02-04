package addProduct;

import io.github.bonigarcia.wdm.WebDriverManager;
import login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

/**
 * This test verifies that one product has been added to cart.
 * It follows these steps:
 * 1. Goes to  https://www.demoblaze.com/index.html
 * 2. Clicks on selected product.
 * 3. Clicks on Add to Cart button.
 * 4. Click on Cart button in the nav bar.
 * 5. Asserts that the product is displayed in the cart.
 */

public class TestAddProduct {

    private WebDriver wd;

    @BeforeTest
    private void initialize () {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wd.get("https://www.demoblaze.com/index.html");
        wd.manage().window().maximize();
    }

    @Test
    public  void testAddProduct() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) wd;

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.demoblaze.com/index.html",
                "The current URL should be : https://www.demoblaze.com/index.html");

        AddProduct addProduct = new AddProduct(wd);

        WebElement Element = wd.findElement(By.linkText("Sony vaio i7")); // scroll do elementa, nalazi ga po nazivu -- RADI DOBRO!
        js.executeScript("arguments[0].scrollIntoView();", Element);

        addProduct.clickProduct();
        addProduct.clickATC();
        addProduct.clickOnCart();

        String element = wd.findElement(By.xpath("//td[contains(text(),'Samsung galaxy s6')]")).getText();
        Assert.assertTrue(element.contains("Samsung galaxy s6")); // da li ovako treba da se asert?
        System.out.println("Test succesfully executed!");

    }
    @AfterTest
    public void closeWebDriver() throws IOException {
        wd.manage().deleteAllCookies(); // cool :)
        wd.close();
        System.out.println("Web driver closed");
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }
}
