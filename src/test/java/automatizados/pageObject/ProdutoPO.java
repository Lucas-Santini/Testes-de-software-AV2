package automatizados.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO {

    // Construtor da classe, inicializando o driver
    public ProdutoPO(WebDriver driver) {
        super(driver);
    }

    // Mapeamento dos elementos da página usando PageFactory
    @FindBy(id = "Código")
    public WebElement inputCodigoProduto;
    
    @FindBy(id = "Nome")
    public WebElement inputNomeProduto;

    @FindBy(id = "Quantidade")
    public WebElement inputQuantidadeProduto;

    @FindBy(id = "Valor")
    public WebElement inputPrecoProduto;
    
    @FindBy(id = "Data Cadastro")
    public WebElement inputDataProduto;

    @FindBy(id = "btn-Salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "btn-Editar")
    public WebElement buttonEditar;

    @FindBy(id = "btn-Excluir")
    public WebElement buttonExcluir;

    @FindBy(css = "div.alert>span")
    public WebElement spanMensagem;

    // Método para cadastrar um produto preenchendo todos os campos e clicando no botão Salvar
    public void cadastrarProduto(String codigo, String nome, String quantidade, String preco, String data) {
        escrever(inputCodigoProduto, codigo);
        escrever(inputNomeProduto, nome);
        escrever(inputQuantidadeProduto, quantidade);
        escrever(inputPrecoProduto, preco);
        escrever(inputDataProduto, data);
        buttonSalvar.click();
    }

    // Método para clicar no botão Editar
    public void editarProduto() {
        buttonEditar.click();
    }

    // Método para clicar no botão Excluir
    public void excluirProduto() {
        buttonExcluir.click();
    }

    // Método auxiliar para preencher campos de texto
    private void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }

    // Método para obter a mensagem de feedback exibida na página
    public String obterMensagem() {
        return spanMensagem.getText();
    }
}
