package uistore;

import org.openqa.selenium.By;

public class Locaters {

    public By signupLoginButton = By.xpath("//a[@href='/login']");
    public By emailField = By.xpath("//input[@data-qa='login-email']");
    public By passwordField = By.xpath("//input[@data-qa='login-password']");
    public By loginButton = By.xpath("//button[@data-qa='login-button']");
    public By productsButton = By.xpath("//a[@href='/products']");
    public By searchBox = By.id("search_product");
    public By searchButton = By.id("submit_search");
    public By firstProductAddToCart = By.xpath("(//a[@data-product-id='1'])[1]");
    public By cartButton = By.xpath("//a[@href='/view_cart']");
    public By proceedToCheckoutButton = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    public By placeOrderButton = By.xpath("//a[contains(text(),'Place Order')]");
    public By NameOnCard = By.name("name_on_card");
    public By cardNumber = By.name("card_number");
    public By cvc = By.name("cvc"); 
    public By expiryMonth = By.name("expiry_month");
    public By expiryYear = By.name("expiry_year");
    public By payAndConfirmOrderButton = By.id("submit");

    public By logoutButton = By.xpath("//a[@href='/logout']");

}
