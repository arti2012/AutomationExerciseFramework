package pages;

import com.aventstack.extentreports.Status;

import stepdefinitions.Hooks;
import uistore.Locaters;
import utils.Base;
import utils.Reporter;
import utils.WebDriverHelper;

public class HomePage {

    WebDriverHelper webDriverHelper = new WebDriverHelper(Base.driver);

    Locaters locaters = new Locaters();
    Reporter reporter;

    public HomePage(Reporter reporter) {
        this.reporter = reporter;
    }

    // public void enterSearchText (String searchText) {
    //    webDriverHelper.sendKeysToElement(locaters.getSearchBox(), searchText);
    // }

    public void login(String email, String password) {
        webDriverHelper.clickElement(locaters.signupLoginButton);
        webDriverHelper.sendKeysToElement(locaters.emailField, email);
        webDriverHelper.sendKeysToElement(locaters.passwordField, password);
        webDriverHelper.clickElement(locaters.loginButton);
        reporter.addLog("login successful", Status.PASS , Hooks.test);
    }

    public void searchProduct(String productName) {
        webDriverHelper.scrollToElement(locaters.productsButton);
        webDriverHelper.clickElement(locaters.productsButton);
        webDriverHelper.sendKeysToElement(locaters.searchBox, productName);
        reporter.addLog("Product searched: " + productName, Status.PASS , Hooks.test);
    }

    public void addFirstProductToCart() {
        // webDriverHelper.hoverElement(locaters.firstProductAddToCart);
        webDriverHelper.clickElement(locaters.firstProductAddToCart);
        reporter.addLog("First product added to cart", Status.PASS , Hooks.test);
    }

    public void clickCart() {
        webDriverHelper.clickElement(locaters.cartButton);
        reporter.addLog("Clicked on cart", Status.PASS , Hooks.test);
    }

    public void proceedToCheckout() {
        webDriverHelper.clickElement(locaters.proceedToCheckoutButton);
        reporter.addLog("Proceeded to checkout", Status.PASS , Hooks.test);
    }

    public void placeOrder() {
        webDriverHelper.clickElement(locaters.placeOrderButton);
        reporter.addLog("Clicked on Place Order", Status.PASS , Hooks.test);
    }

    public void enterPaymentDetails(String nameOnCard, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
        webDriverHelper.sendKeysToElement(locaters.NameOnCard, nameOnCard);
        webDriverHelper.sendKeysToElement(locaters.cardNumber, cardNumber);
        webDriverHelper.sendKeysToElement(locaters.cvc, cvc);
        webDriverHelper.sendKeysToElement(locaters.expiryMonth, expiryMonth);
        webDriverHelper.sendKeysToElement(locaters.expiryYear, expiryYear);
        webDriverHelper.clickElement(locaters.payAndConfirmOrderButton);
        reporter.addLog("Entered payment details", Status.PASS , Hooks.test);
    }

    public void logout() {
        webDriverHelper.clickElement(locaters.logoutButton);
        reporter.addLog("Logged out successfully", Status.PASS , Hooks.test);
    }
    

}
