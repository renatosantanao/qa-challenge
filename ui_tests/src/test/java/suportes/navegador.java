package suportes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class navegador {
    //metodo criado para executar os testes no google chrome
    public static WebDriver navegandoComOChrome (){

        //definindo qual browser que vai utilizar para o teste e o caminho do driver
        System.setProperty("webdriver.chrome.driver","/Users/renato/Workspace/drivers/chromedriver");

        //abrindo o navegar
        WebDriver navegadorWeb = new ChromeDriver();

        //maximizar janela do navegador
        navegadorWeb.manage().window().maximize();

        //sistema aguarda 10 segundos até que o browser seja aberto
        navegadorWeb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //url utilizada para acessar o sistema e executar os testes
        navegadorWeb.get("http://automationpractice.com/");

        //retorna variavel com as atribuicoes do navegador chrome
        return navegadorWeb;
    }
}
