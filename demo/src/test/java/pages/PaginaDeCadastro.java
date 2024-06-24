package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaDeCadastro extends BasePage {

    public PaginaDeCadastro(WebDriver navegador) {
        super(navegador);
    }

    public PaginaDeCadastro genero(){
        navegador.findElement(By.id("id_gender1")).click();
        return this;
    }

    public PaginaDeCadastro senha(String senha){
        navegador.findElement(By.id("password")).sendKeys(senha);
        return this;
    }

    public PaginaDeCadastro nascimento(){
        navegador.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/div[5]/div/div[1]/div/select/option[14]")).click();
        navegador.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/div[5]/div/div[2]/div/select/option[11]")).click();
        navegador.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/div[5]/div/div[3]/div/select/option[24]")).click();
        return this;
    }

    public PaginaDeCadastro newsletter(){
        navegador.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/div[6]/div/span/input")).click();
        return this;
    }

    public PaginaDeCadastro oferta(){
        navegador.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/div[7]/div/span/input")).click();
        return this;
    }

    public PaginaDeCadastro nome(String nome){
        navegador.findElement(By.id("first_name")).sendKeys(nome);
        return this;
    }

    public PaginaDeCadastro sobrenome(String sobrenome){
        navegador.findElement(By.id("last_name")).sendKeys(sobrenome);
        return this;
    }

    public PaginaDeCadastro endereco(String endereco){
        navegador.findElement(By.id("address1")).sendKeys(endereco);
        return this;
    }

    public PaginaDeCadastro pais(){
        navegador.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/p[6]/select/option[3]")).click();
        return this;
    }

    public PaginaDeCadastro estado(String estado){
        navegador.findElement(By.id("state")).sendKeys(estado);
        return this;
    }

    public PaginaDeCadastro cidade(String cidade){
        navegador.findElement(By.id("city")).sendKeys(cidade);
        return this;
    }

    public PaginaDeCadastro cep(String cep){
        navegador.findElement(By.id("zipcode")).sendKeys(cep);
        return this;
    }

    public PaginaDeCadastro celular(String celular){
        navegador.findElement(By.id("mobile_number")).sendKeys(celular);
        return this;
    }

    public ContaCriada createAccount(){
        navegador.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/button")).click();
        return new ContaCriada(navegador);
    }
}
