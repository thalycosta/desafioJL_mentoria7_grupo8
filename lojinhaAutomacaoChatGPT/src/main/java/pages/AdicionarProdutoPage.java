package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdicionarProdutoPage {

    WebDriver driver;
    WebDriverWait wait;

    // Localizadores
    By nomeProdutoField = By.id("produtonome");
    By valorProdutoField = By.id("produtovalor");
    By coresProdutoField = By.id("produtocores");
    By botaoSalvar = By.id("btn-salvar");
    By mensagemSucesso = By.xpath("//div[contains(@class, 'toast rounded') and text()='Produto adicionado com sucesso']");
    By mensagemErro = By.xpath("//div[contains(@class, 'toast rounded') and text()='O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00']");

    // Construtor
    public AdicionarProdutoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera explícita de 10 segundos
    }

    // Método para inserir dados nos campos de produto
    public AdicionarProdutoPage inserirDadosProduto(String nome, String valor, String cores) {
        driver.findElement(nomeProdutoField).sendKeys(nome);
        driver.findElement(valorProdutoField).sendKeys(valor);
        driver.findElement(coresProdutoField).sendKeys(cores);
        return this;
    }

    // Método para clicar no botão "Salvar"
    public void clickSalvar() {
        WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(botaoSalvar));
        botao.click();
        System.out.println("Clique no botão Salvar realizado.");
    }

    // Método para verificar se a mensagem de erro é exibida
    public boolean verificarMensagemErro() {
        try {
            WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemErro));
            System.out.println("Mensagem 'O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00' é exibida.");
            return mensagem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Método para verificar se a mensagem de sucesso é exibida
    public boolean verificarMensagemSucesso() {
        try {
            WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemSucesso));
            System.out.println("Mensagem 'Produto adicionado com sucesso' é exibida.");
            return mensagem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
