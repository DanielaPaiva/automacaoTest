package pom.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.support.configuration.DriverFactory;
import pom.support.utils.WebUtils;

public class HomePage extends WebUtils {


    @FindBy(css = "#uid")
    private WebElement usuario;

    @FindBy(css = "#passw")
    private WebElement senha;

    @FindBy(css = "input[value=Login]")
    private WebElement btnLogin;


    public void acessarAplicacao() {
        DriverFactory.getDriver().get("http://demo.testfire.net/login.jsp");

        //Preencher area do login
        preencherCampo(usuario, "jsmith");
        preencherCampo(senha, "Demo1234");
        clicar(btnLogin);

    }
}
