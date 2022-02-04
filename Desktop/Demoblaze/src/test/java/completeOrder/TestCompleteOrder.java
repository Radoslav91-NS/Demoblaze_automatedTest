package completeOrder;

import addProduct.AddProduct;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestCompleteOrder {

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
    public  void completeOrderTest() throws InterruptedException {

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.demoblaze.com/index.html",
                "The current URL should be : https://www.demoblaze.com/index.html");

        AddProduct addProduct = new AddProduct(wd); // pokrenemo stranicu iz projekta i korisitmo metode u drugom testu
        CompleteOrder completeOrder = new CompleteOrder(wd);

        addProduct.clickProduct();
        addProduct.clickATC();
        addProduct.clickOnCart();

        completeOrder.clickOrder();
        completeOrder.enterName("makaka");
        completeOrder.enterCountry("sdsd");
        completeOrder.enterCity("sdsd");
        completeOrder.enterCard("213");
        completeOrder.enterYear("1233");
        completeOrder.enterMonth("2");
        completeOrder.clickPurchase();
        Thread.sleep(3000);

        WebElement okBtn = wd.findElement(By.xpath("//body/div[10]"));
        Assert.assertEquals(true, okBtn.isDisplayed());

    }

    @AfterTest
    public void closeWebDriver() throws IOException {
        wd.manage().deleteAllCookies(); // cool :)
        wd.close();
        System.out.println("Web driver closed");
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }

}
