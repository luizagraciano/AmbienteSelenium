package pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContaCriada extends BasePage {

    public ContaCriada(WebDriver navegador) {
        super(navegador);

    }

    public ContaCriada checharContaCriada(){
        String mensagemSucesso = navegador.findElement(By.xpath("/html/body/section/div/div/div/h2")).getText();
        assertTrue(mensagemSucesso.contains("ACCOUNT CREATED!"));
        return this;
    }
    
}
