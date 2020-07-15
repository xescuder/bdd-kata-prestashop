package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver=null;

    @FindBy(css = "button.add-to-cart")
    private WebElement checkout;

    @FindBy(xpath = "//div[@class='modal-content']//button[text()='Continuar comprando']")
    private WebElement continueBuy;

    public ProductPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        checkout.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='blockcart-modal'][contains(@style, 'display: block')]")));
        continueBuy.click();
    }
}