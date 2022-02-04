package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    // ovo je Page Object klasa

    private WebDriver wd;

    public Login (WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    @FindBy (id = "login2")
    WebElement login;
    @FindBy(id = "loginusername")
    WebElement userName;
    @FindBy (id = "loginpassword")
    WebElement password;
    @FindBy (xpath = "//button[contains(text(),'Log in')]")
    WebElement finalLogin;

    public void clickLogin () {
        this.login.click();
    }
    public void enterUser (String user) {
        this.userName.sendKeys(user);
    }
    public void enterPass (String pass) {
        this.password.sendKeys(pass);
    }
    public void finalLogClick () {
        this.finalLogin.click();
    }

}
