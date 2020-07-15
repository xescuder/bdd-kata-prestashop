package stepdefs;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepdefs {
    @Given("I am on a product detail page")
    public void iAmOnAProductDetailPage() {
        throw new PendingException();
    }

    @When("I click the add to basket button")
    public void iClickTheAddToBasketButton() {
        throw new PendingException();
    }

    @Then("the product is added to my shopping basket")
    public void theProductIsAddedToMyShoppingBasket() {
        throw new PendingException();
    }
}
