package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PreCadastro extends BasePage{

    public PreCadastro(WebDriver navegador) {
        super(navegador);
    }
    
    public PreCadastro login(String login){
        navegador.findElement(By.className("signup-form")).findElement(By.name("name")).sendKeys(login);
        return this;
    }

    public PreCadastro email(String email){
        navegador.findElement(By.className("signup-form")).findElement(By.name("email")).sendKeys(email);
        return this;
    }

    public PaginaDeCadastro signup(){
       navegador.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/button")).click();
       return new PaginaDeCadastro(navegador);
    }
}
