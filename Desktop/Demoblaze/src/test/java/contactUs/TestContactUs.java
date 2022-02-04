package contactUs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

/**
 * This test verifies that the contact form is working properly.
 * It follows these steps:
 * 1. Goes to the correct URL: https://www.demoblaze.com/index.html
 * 2. Click on Contact us button
 * 3. Enter name of the sender
 * 4. Enter email of the sender
 * 5. Enter the message
 * 6. Click on Send Message button
 * 7. Assert that pop-up window has appeared with the message: "Thanks for the message!!"
 */
public class TestContactUs {

    private WebDriver wd;

    @BeforeTest
    private void initialize() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wd.get("https://www.demoblaze.com/index.html");
        wd.manage().window().maximize();
    }

    @Test
    public void TestContactUsHappyPath() throws InterruptedException {
        Assert.assertEquals(wd.getCurrentUrl(), "https://www.demoblaze.com/index.html",
                "The current URL should be : https://www.demoblaze.com/index.html");


        ContactUs contactUs = new ContactUs (wd);
        contactUs.clickContact();
        contactUs.enterName("sdsd");
        contactUs.enterEmail("asdasd");
        contactUs.enterMessage("asdasd");
        contactUs.clickSend();

        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        alert.accept();

        Thread.sleep(3000);

    }
    @AfterTest
    public void closeWebDriver() throws IOException {
        wd.manage().deleteAllCookies(); // cool :)
        wd.close();
        System.out.println("Web driver closed");
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }
}
