package signUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

/**
 * This test verifies that sign up on the site is successful.
 * It follows these steps:
 * 1. Go to site URL : https://www.demoblaze.com/index.html
 * 2. Click on sign in button
 * 3. Enter desired username
 * 4. Enter desired password
 * 5. Click on Sign up button
 * 6. Assert that the user has been created
 */

public class TestSignUp {

    private WebDriver wd;

    @Test
    private void testSignupHappyPath () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wd.get("https://www.demoblaze.com/index.html");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.demoblaze.com/index.html",
                "The current URL should be : https://www.demoblaze.com/index.html");

        SignUp signUp = new SignUp(wd);

        signUp.clickSignIn();
        signUp.enterUsername("Huehue"); // moraju se menjati podaci username
        signUp.enterPassword("makaka");
        signUp.clickSignUp();
        Thread.sleep(3000);

        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        alert.accept();
        Thread.sleep(2000);
    }


    @AfterTest
    public void closeWebDriver() throws IOException {
        wd.manage().deleteAllCookies(); // cool :)
        wd.close();
        System.out.println("Web driver closed");
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }


}


