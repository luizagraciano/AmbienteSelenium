import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CriarCadastroFakerTest {
    private WebDriver navegador;

    //Criação da massa de testes dinâmica
    Faker faker = new Faker(Locale.CANADA);
    String nome = faker.name().firstName();
    String sobrenome = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String endereco = faker.address().streetAddress();
    String estado = faker.address().state();
    String cidade = faker.address().city();
    String cep = faker.address().zipCode();
    String celular = faker.phoneNumber().cellPhone();

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
        criarCadastro.findElement(By.name("name")).sendKeys(nome);

        //Preencher email
        criarCadastro.findElement(By.name("email")).sendKeys(email);

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
        cadastro.findElement(By.id("first_name")).sendKeys(nome);

        //Preencher sobrenome
        cadastro.findElement(By.id("last_name")).sendKeys(sobrenome);

        //Preencher endereço
        cadastro.findElement(By.id("address1")).sendKeys(endereco);

        //Preencher país
        cadastro.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/p[6]/select/option[3]")).click();

        //Preencher estado
        cadastro.findElement(By.id("state")).sendKeys(estado);

        //Preencher cidade
        cadastro.findElement(By.id("city")).sendKeys(cidade);

        //Preencher CEP
        cadastro.findElement(By.id("zipcode")).sendKeys(cep);

        //Preencher telefone
        cadastro.findElement(By.id("mobile_number")).sendKeys(celular);

        //Enviar formulário
        cadastro.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/button")).click();
    }

    @AfterSuite
    public void tearDown(){
        navegador.quit();
    }
}
