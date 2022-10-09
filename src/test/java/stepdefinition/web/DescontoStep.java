package stepdefinition.web;

import io.cucumber.java.pt.Dado;
import pom.pages.web.HomePage;



public class DescontoStep {
//    HomePage homePage = new HomePage();

    @Dado("que estou na pagina inicial")
    public void que_estou_no_site() {
        new HomePage().acessarAplicacao();
    }

}
