package addProduct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AddProduct {
    private WebDriver wd;

    public AddProduct  (WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    @FindBy (xpath = "//body/div[@id='contcont']/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]")
    WebElement clickOnProduct;
    @FindBy (xpath = "//a[contains(text(),'Add to cart')]")
    WebElement ATC;
    @FindBy (id = "cartur")
    WebElement cart;

    public void clickProduct () {
        clickOnProduct.click();
    }
    public void clickATC () {
        ATC.click();
    }
    public void clickOnCart () {
        cart.click();
    }
}

