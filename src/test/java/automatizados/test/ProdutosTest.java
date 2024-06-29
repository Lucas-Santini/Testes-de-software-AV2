package automatizados.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizados.pageObject.ProdutoPO;

public class ProdutosTest extends BaseTest {

    // Declaração do Page Object de Produto
    private static ProdutoPO produtoPage;

    /**
     *  Método para preparar os testes, instanciando o Page Object de Produto
     * 
     * @author Lucas Santini
     * @date 28/06/2024
     */
    @BeforeClass
    public static void prepararTestes() {
        produtoPage = new ProdutoPO(driver);
    }

    /**
     * Teste para verificar se um produto é salvo com todos os campos preenchidos
     * 
     * @author Lucas Santini
     * @date 28/06/2024
     */
    @Test
    public void TC001_DeveSalvarProdutoComCamposPreenchidos() {
        produtoPage.cadastrarProduto("01", "Nomedoproduto", "99", "15", "01011234");
        // Obtém a mensagem de feedback após salvar o produto
        String mensagem = produtoPage.obterMensagem();
        // Verifica se a mensagem de sucesso é exibida
        assertEquals("Produto salvo com sucesso!", mensagem); 
    }

    /**
     * Teste para verificar se a tela de edição é aberta ao clicar no botão Editar
     * 
     * @author Lucas Santini
     * @date 28/06/2024
     */
    @Test
    public void TC002_DeveAbrirTelaDeEdicaoAoClicarNoBotaoEditar() {
        produtoPage.editarProduto();
        // Verificação da abertura da tela de edição pelo título da página
        String tituloPagina = driver.getTitle();
        assertTrue(tituloPagina.contains("Editar")); 
    }

    /**
     * Teste para verificar se um produto é excluído com sucesso
     * 
     * @author Lucas Santini
     * @date 28/06/2024
     */
    @Test
    public void TC003_DeveExcluirProdutoCadastrado() {
        produtoPage.excluirProduto();
        // Obtém a mensagem de feedback após excluir o produto
        String mensagem = produtoPage.obterMensagem();
        // Verifica se a mensagem de sucesso é exibida
        assertEquals("Produto excluído com sucesso!", mensagem);
    }
}
