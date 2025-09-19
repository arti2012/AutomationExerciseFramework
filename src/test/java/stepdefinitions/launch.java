package stepdefinitions;
import utils.Base; // <-- Highlighted change
import org.openqa.selenium.interactions.Actions;

// ...existing code...
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.WebDriverHelper;

public class launch {

    public HomePage homePage = new HomePage(Hooks.reporter);

    @Given("the user is on the Automation Exercise homepage")
    public void the_user_is_on_the_automation_exercise_homepage() {
        // homePage = new HomePage(Hooks.reporter);

    }

    @When("the user clicks on Signup \\/ Login")
    public void the_user_clicks_on_signup_login() {
        // homePage.clickSignupLogin();
    }

@When("the user enters valid {string} and {string} and clicks Login")
public void the_user_enters_valid_and_and_clicks_login(String string, String string2) {
    homePage.login(string, string2);
}

    @When("the user clicks on Products in the navigation bar")
    public void the_user_clicks_on_products_in_the_navigation_bar() {
        
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String string) {
        homePage.searchProduct(string);
        System.out.println("Search completed");
    }

  @When("the user adds the first search result to the cart")
    public void the_user_adds_the_first_search_result_to_the_cart() {
        By addToCartButton = By.xpath("(//a[@data-product-id='1'])[1]");
        WebDriverHelper helper = new WebDriverHelper(Base.driver);

        helper.scrollToElement(addToCartButton);
        helper.waitForElementToBeClickable(addToCartButton); // <-- Highlighted change
        helper.clickElement(addToCartButton);
        System.out.println("Product added to cart");
    }


    @When("the user clicks on Cart in the navigation bar")
    public void the_user_clicks_on_cart_in_the_navigation_bar() {
        homePage.clickCart();
        System.out.println("Clicked on cart");
    }

    @When("the user clicks on Proceed To Checkout")
    public void the_user_clicks_on_proceed_to_checkout() {
        homePage.proceedToCheckout();
        System.out.println("Proceeded to checkout");
    }
    // ...existing code...


    @Then("the user should be taken to the checkout page")
    public void the_user_should_be_taken_to_the_checkout_page() {
        homePage.placeOrder();
        System.out.println("Clicked on Place Order");
        homePage.enterPaymentDetails("Arti Rai", "4111111111111111", "123", "12", "2025");
        System.out.println("Payment details entered");

    }
  @When("the user clicks on the submit button")
public void the_user_clicks_on_the_submit_button() {
    By submitButton = By.id("submit");
    WebDriverHelper helper = new WebDriverHelper(Base.driver);

    // Hide ALL ad iframes and overlays (highlighted change)
    try {
        ((org.openqa.selenium.JavascriptExecutor) Base.driver)
            .executeScript(
                "window.scrollTo(0, document.body.scrollHeight);" +
                "document.querySelectorAll('iframe[id^=\"aswift_\"]').forEach(e=>e.style.display='none');" + // <-- Hides all ad iframes
                "document.querySelectorAll('.grippy-host').forEach(e=>e.style.display='none');"
            );
        Thread.sleep(2000); // Give time for DOM update
    } catch (Exception e) {
        System.out.println("No ad iframe or overlay found or could not hide.");
    }

    helper.scrollToElement(submitButton); 
    helper.waitForElementToBeClickable(submitButton);

    Actions actions = new Actions(Base.driver);
    actions.moveToElement(Base.driver.findElement(submitButton)).click().perform();

    System.out.println("Clicked on submit button");
}
    @Then("the user should see the Place Order button")
    public void the_user_should_see_the_place_order_button() {
        homePage.logout();
        System.out.println("Logged out");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }
    }

}
