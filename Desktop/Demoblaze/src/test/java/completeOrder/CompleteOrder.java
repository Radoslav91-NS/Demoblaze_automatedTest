package completeOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompleteOrder {

    private WebDriver wd;

    public CompleteOrder(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    WebElement placeOrder;
    @FindBy(id = "name")
    WebElement enterName;
    @FindBy(id = "country")
    WebElement country;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "card")
    WebElement card;
    @FindBy(id = "month")
    WebElement month;
    @FindBy(id = "year")
    WebElement year;
    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    WebElement purchase;

    public void clickOrder() {
        placeOrder.click();
    }

    public void enterName(String name) {
        enterName.sendKeys(name);
    }

    public void enterCountry(String country) {
        this.country.sendKeys(country);
    }

    public void enterCity(String city) {
        this.city.sendKeys(city);
    }

    public void enterCard(String card) {
        this.card.sendKeys(card);

    }

    public void enterMonth(String month) {
        this.month.sendKeys(month);

    }

    public void enterYear(String year) {
        this.year.sendKeys(year);
    }

    public void clickPurchase() {
        purchase.click();
    }
}
