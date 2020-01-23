package Testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import suportes.navegador;

public class CadatroCliente {
    private WebDriver testeWeb;

    @Before
    //metodo para executar a pre condicao dos testes
    public void iniciar(){

        //abrir navegador
        testeWeb = navegador.navegandoComOChrome();
    }
    @Test
    //metodo para validar se o formulario de login foi exibido com sucesso e acesso a tela
    public void CST001validarCadastroCliente(){

    }

    @After
    //metodo para executar a pos condicao dos testes
    public void finalizar(){

        //finalizar o teste, fechando a instancia do chrome utilizada
        testeWeb.quit();
    }
}
