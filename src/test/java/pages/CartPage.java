package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver=null;

    private static String PRODUCT_LINE_LOCATOR = "//div[@class='product-line-info']//a[text()=\"%s\"]";

    @FindBy(css = "i.shopping-cart")
    private WebElement viewCart;

    public CartPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean productInCart(String productText) {
        String productLocate = String.format(PRODUCT_LINE_LOCATOR, productText);
        viewCart.click();
        return driver.findElements(By.xpath(productLocate)).size() !=0;
    }
}