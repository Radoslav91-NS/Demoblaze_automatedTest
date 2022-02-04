package signUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {

    private WebDriver wd;

    public SignUp(WebDriver wd) { //inicijalizacija web drivera i page factory
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    @FindBy (id = "signin2")
    WebElement signIn;
    @FindBy (id = "sign-username")
    WebElement username;
    @FindBy(id = "sign-password")
    WebElement password;
    @FindBy (xpath = "//button[contains(text(),'Sign up')]")
    WebElement signUp;

    public void clickSignIn () {
        this.signIn.click();
    }
    public void enterUsername (String user) {
        this.username.sendKeys(user);
    }
    public void enterPassword (String pass) {
        this.password.sendKeys(pass);
    }
    public void clickSignUp () {
        this.signUp.click();
    }


}
