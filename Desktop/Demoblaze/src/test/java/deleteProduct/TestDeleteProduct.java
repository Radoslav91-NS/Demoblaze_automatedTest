package deleteProduct;

import addProduct.AddProduct;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestDeleteProduct {

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
    public  void TestDeleteProduct () throws InterruptedException {
        Assert.assertEquals(wd.getCurrentUrl(), "https://www.demoblaze.com/index.html",
                "The current URL should be : https://www.demoblaze.com/index.html");

        AddProduct addProduct = new AddProduct(wd);
        DeleteProduct deleteProduct = new DeleteProduct(wd);

        addProduct.clickProduct();
        addProduct.clickATC();
        addProduct.clickOnCart();
        Thread.sleep(3000);

        deleteProduct.clickDelete();
        Thread.sleep(3000);

        String element = wd.findElement(By.id("tbodyid")).getText();
        Assert.assertTrue(element.isEmpty());

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
