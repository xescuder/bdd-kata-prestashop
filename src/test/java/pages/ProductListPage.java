package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
    public static final String PRODUCT_LOCATOR = "//div[@class='product-description']//a[text()='%s']";
    WebDriver driver=null;

    public ProductListPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProduct(String productText) {
        String product = String.format(PRODUCT_LOCATOR, productText);
        driver.findElement(By.xpath(product)).click();
    }
}
