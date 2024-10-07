package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("usuario");
    private By passwordField = By.id("senha");
    private By loginButton = By.id("btn-entrar");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Fluent methods
    public LoginPage enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this; // Returning the current LoginPage object to allow fluent chaining
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this; // Returning the current LoginPage object to allow fluent chaining
    }

    public ListaDeProdutosPage clickLogin() {
        driver.findElement(loginButton).click();
        System.out.println("Clique no botão login realizado.");
        return new ListaDeProdutosPage(driver);
        // Transition to ListaDeProdutosPage after login
    }
}
