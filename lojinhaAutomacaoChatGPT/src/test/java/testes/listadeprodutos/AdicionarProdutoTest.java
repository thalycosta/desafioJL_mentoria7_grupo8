package testes.listadeprodutos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AdicionarProdutoPage;
import pages.ListaDeProdutosPage;
import pages.LoginPage;

@DisplayName("Validação da Funcionalidade de Adicionar Produto")
public class AdicionarProdutoTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ListaDeProdutosPage listaDeProdutosPage;
    private AdicionarProdutoPage adicionarProdutoPage;

    @BeforeEach
    public void setup() {
        // Configuração do ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximiza o navegador
        driver = new ChromeDriver(options);
        driver.get("http://165.227.93.41/lojinha-web/v2/login"); // URL de login

        // Inicializa as páginas
        loginPage = new LoginPage(driver);

        // Realiza login
        loginPage.enterUsername("admin")
                .enterPassword("admin")
                .clickLogin();
    }

    @Test
    @DisplayName("Adicionar um produto válido.")
    public void testAdicionarProdutoValido() {
        // Verifica se está na página de lista de produtos
        listaDeProdutosPage = new ListaDeProdutosPage(driver);
        Assertions.assertTrue(listaDeProdutosPage.exibirListaDeProdutos(), "Título da lista de produtos não encontrado.");

        // Clica no botão "Adicionar Produto"
        adicionarProdutoPage = listaDeProdutosPage.clickBtAdicionarProduto();

        // Verifica se está na página de adição de produto
        Assertions.assertTrue(adicionarProdutoPage != null, "Não está na página de adição de produto.");

        // Insere os dados do produto e clica em "Salvar"
        adicionarProdutoPage.inserirDadosProduto("Produto Teste", "100.00", "Vermelho, Azul")
                .clickSalvar();

        // Verifica se a mensagem de sucesso é exibida
        Assertions.assertTrue(adicionarProdutoPage.verificarMensagemSucesso(), "Mensagem de sucesso não exibida.");
    }

    @Test
    @DisplayName("Adicionar um produto com valor inválido.")
    public void testAdicionarProdutoComValorInvalido() {
        // Verifica se está na página de lista de produtos
        listaDeProdutosPage = new ListaDeProdutosPage(driver);
        Assertions.assertTrue(listaDeProdutosPage.exibirListaDeProdutos(), "Título da lista de produtos não encontrado.");

        // Clica no botão "Adicionar Produto"
        adicionarProdutoPage = listaDeProdutosPage.clickBtAdicionarProduto();

        // Verifica se está na página de adição de produto
        Assertions.assertTrue(adicionarProdutoPage != null, "Não está na página de adição de produto.");

        // Insere os dados do produto e clica em "Salvar"
        adicionarProdutoPage.inserirDadosProduto("Produto Teste", "0.00", "Vermelho, Azul")
                .clickSalvar();

        // Verifica se a mensagem de sucesso é exibida
        Assertions.assertTrue(adicionarProdutoPage.verificarMensagemErro(), "Mensagem de sucesso não exibida.");
    }

    @Test
    @DisplayName("Adicionar um produto com campos em branco")
    public void testAdicionarProdutoEmBranco() {
        // Verifica se está na página de lista de produtos
        listaDeProdutosPage = new ListaDeProdutosPage(driver);
        Assertions.assertTrue(listaDeProdutosPage.exibirListaDeProdutos(), "Título da lista de produtos não encontrado.");

        // Clica no botão "Adicionar Produto"
        adicionarProdutoPage = listaDeProdutosPage.clickBtAdicionarProduto();

        // Verifica se está na página de adição de produto
        Assertions.assertTrue(adicionarProdutoPage != null, "Não está na página de adição de produto.");

        // Insere os dados do produto e clica em "Salvar"
        System.out.println("Campos não preenchidos.");
        adicionarProdutoPage.clickSalvar();

        // Verifica se a mensagem de sucesso é exibida
        Assertions.assertTrue(adicionarProdutoPage.verificarMensagemErro(), "Mensagem de sucesso não exibida.");
    }

    @AfterEach
    public void tearDown() {
        driver.quit(); // Fecha o navegador
    }
}
