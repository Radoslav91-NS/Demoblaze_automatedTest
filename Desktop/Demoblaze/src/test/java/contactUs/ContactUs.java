package contactUs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {

    private WebDriver wd;

    public ContactUs (WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    @FindBy (xpath = "//a[contains(text(),'Contact')]")
    WebElement contact;
    @FindBy (id = "recipient-email")
    WebElement email;
    @FindBy (id = "recipient-name")
    WebElement name;
    @FindBy (id = "message-text")
    WebElement message;
    @FindBy (xpath = "//button[contains(text(),'Send message')]")
    WebElement sendMessage;

    public void clickContact () {
        this.contact.click();
    }
    public void enterEmail (String email) {
        this.email.sendKeys(email);
    }
    public void enterName (String name) {
        this.name.sendKeys(name);
    }
    public void enterMessage (String message) {
        this.message.sendKeys(message);
    }
    public void clickSend () {
        this.sendMessage.click();
    }

}
