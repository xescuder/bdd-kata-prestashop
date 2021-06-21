package stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Browser;
import pages.CartPage;
import pages.ProductListPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CartStepdefs {
    static final String WEB_URL = "https://demo.prestashop.com/#/en/front";
    private static String PRODUCT_TEXT = "Hummingbird printed t-shirt";
    private WebDriver driver;


    @Before
    public void setup() {
        driver = Browser.getDriver();
    }

    @Given("I've an empty basket")
    public void iHaveAnEmptyBasket() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(WEB_URL);
        try{
            WebDriverWait w = new WebDriverWait(driver, 10);
            w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));
        } catch (Exception exc) {
        }
    }

    @When("I add a product item")
    public void iAddAProductItemToBasket() throws InterruptedException {
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.selectProduct(PRODUCT_TEXT);

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
    }

    @Then("the basket should have 1 unit of this product item")
    public void theBasketShouldHaveTheProductItem() {
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.productInCart(PRODUCT_TEXT));
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
