import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CriarCadastroTest {

    private WebDriver navegador;

    @BeforeSuite
    public void setUp(){
        navegador = new ChromeDriver();
        navegador.get("https://automationexercise.com/login");
    }

    @Test
    public void chromeTest(){
        //Delimitar escopo do formulário de cadastro
        WebElement criarCadastro = navegador.findElement(By.className("signup-form"));
        //Preencher nome
        criarCadastro.findElement(By.name("name")).sendKeys("User");

        //Preencher email
        criarCadastro.findElement(By.name("email")).sendKeys("usertest@test.com");

        //Clicar no botão signup
        criarCadastro.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/button")).click();
    

        WebElement cadastro = navegador.findElement(By.id("form"));

        //Clicar no botão de gênero
        cadastro.findElement(By.id("id_gender1")).click();

        //Preencher senha
        cadastro.findElement(By.id("password")).sendKeys("senha123456789");

        //Preencher data de nascimento - 13/10/1999
        cadastro.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/div[5]/div/div[1]/div/select/option[14]")).click();
        cadastro.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/div[5]/div/div[2]/div/select/option[11]")).click();
        cadastro.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/div[5]/div/div[3]/div/select/option[24]")).click();

        //Se inscrever na newsletter e receber ofertas
        cadastro.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/div[6]/div/span/input")).click();
        cadastro.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/div[7]/div/span/input")).click();

        //Preencher nome
        cadastro.findElement(By.id("first_name")).sendKeys("User");

        //Preencher sobrenome
        cadastro.findElement(By.id("last_name")).sendKeys("User");

        //Preencher endereço
        cadastro.findElement(By.id("address1")).sendKeys("address line 1");

        //Preencher país
        cadastro.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/p[6]/select/option[3]")).click();

        //Preencher estado
        cadastro.findElement(By.id("state")).sendKeys("state");

        //Preencher cidade
        cadastro.findElement(By.id("city")).sendKeys("city");

        //Preencher CEP
        cadastro.findElement(By.id("zipcode")).sendKeys("00000000");

        //Preencher telefone
        cadastro.findElement(By.id("mobile_number")).sendKeys("00000000");

        //Enviar formulário
        cadastro.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/button")).click();
    }

    @AfterSuite
    public void tearDown(){
        navegador.quit();
    }
}
