package deleteProduct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProduct {
    private WebDriver wd;

    public DeleteProduct(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    WebElement deleteBTN;


    public void clickDelete() {
        this.deleteBTN.click();
    }
}


