import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.ContaCriada;
import pages.PaginaDeCadastro;
import pages.PreCadastro;
import suport.Web;

public class CadastroPageObjectTest {
    private WebDriver navegador;

    //Criação da massa de testes dinâmica
    Faker faker = new Faker(Locale.CANADA);
    String nomeFaker = faker.name().firstName();
    String sobrenomeFaker = faker.name().lastName();
    String emailFaker = faker.internet().emailAddress();
    String enderecoFaker = faker.address().streetAddress();
    String estadoFaker = faker.address().state();
    String cidadeFaker = faker.address().city();
    String cepFaker = faker.address().zipCode();
    String celularFaker = faker.phoneNumber().cellPhone();

    @BeforeTest
    public void setUp(){
        navegador = Web.createChrome();
    }

    @Test
    public void criarCadastro(){
        new PreCadastro(navegador)
        .login(nomeFaker)
        .email(emailFaker)
        .signup();

        new PaginaDeCadastro(navegador)
        .genero()
        .senha("senha123456789")
        .nascimento()
        .newsletter()
        .oferta()
        .nome(nomeFaker)
        .sobrenome(sobrenomeFaker)
        .endereco(enderecoFaker)
        .pais()
        .estado(estadoFaker)
        .cidade(cidadeFaker)
        .cep(cepFaker)
        .celular(celularFaker)
        .createAccount();

        new ContaCriada(navegador)
        .checharContaCriada();
    }


    @AfterTest
    public void tearDown(){
        navegador.quit();
    }
}
