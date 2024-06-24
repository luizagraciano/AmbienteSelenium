package suport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
    public static WebDriver createChrome(){
        WebDriver navegador = new ChromeDriver();
        navegador.get("https://automationexercise.com/login");
        return navegador;
    }
}
