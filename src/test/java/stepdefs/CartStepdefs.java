package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Browser;
import pages.CartPage;
import pages.ProductListPage;
import pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CartStepdefs {
    static final String WEB_URL = "http://vps-769d12b9.vps.ovh.net/prestashop";
    private static String PRODUCT_TEXT = "Hummingbird printed t-shirt";

    @Given("I am on a product detail page")
    public void iAmOnAProductDetailPage() {
        WebDriver driver = Browser.getDriver();
        driver.get(WEB_URL);

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.selectProduct(PRODUCT_TEXT);
    }

    @When("I click the add to basket button")
    public void iClickTheAddToBasketButton() {
        WebDriver driver = Browser.getDriver();
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
    }

    @Then("the product is added to my shopping basket")
    public void theProductIsAddedToMyShoppingBasket() {
        WebDriver driver = Browser.getDriver();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.productInCart(PRODUCT_TEXT));
    }
}
