package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class paginaSignIn {
    private WebDriver navegadorWeb;

    //construtor da pagina login para receber a instancia do Webdriver
    public  paginaLogin(WebDriver navegadorWeb){

        //a instancia recebe o atribudo do navegador
        this.navegadorWeb = navegadorWeb;

    }

    public paginaFormularioDeLogin telaDeLogin(Boolean formularioExibido){
        formularioExibido = navegadorWeb.findElement(By.linkText("Sign in")).isDisplayed();

        //retorna o navegador para o pageobjects
        return new paginaFormularioDeLogin(navegadorWeb);
    }
}
