package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ListaDeProdutosPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Localizadores
    private By tituloListaDeProdutos = By.xpath("//h3[text()='Lista de Produtos']");
    private By botaoAdicionarProduto = By.xpath("//a[contains(text(), 'Adicionar produto')]");

    // Construtor
    public ListaDeProdutosPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Espera explícita de 10 segundos
    }

    // Método para verificar se o título "Lista de Produtos" está presente
    public boolean exibirListaDeProdutos() {
        try {
            WebElement titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(tituloListaDeProdutos));
            System.out.println("Página Lista de Produtos exibida.");
            return titulo.isDisplayed();
            } catch (Exception e) {
            return false;
        }
    }

    // Método para clicar no botão "Adicionar Produto"
    public AdicionarProdutoPage clickBtAdicionarProduto() {
        WebElement botaoAdicionar = wait.until(ExpectedConditions.elementToBeClickable(botaoAdicionarProduto));
        botaoAdicionar.click();
        System.out.println("Clique no botão Adicionar Produto executado.");
        return new AdicionarProdutoPage(driver); // Retorna a instância atual para permitir o encadeamento de métodos
    }
}
