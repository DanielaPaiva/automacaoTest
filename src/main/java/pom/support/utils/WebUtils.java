package pom.support.utils;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.support.configuration.DriverFactory;
import java.time.Duration;


public class  WebUtils {


//    private WebDriver driver;

//    public UtilsPage(WebDriver driver) {
//        this.driver = driver;
//    }
   public WebUtils(){
        PageFactory.initElements(
                DriverFactory.getDriver(),this);
   }

    @After
    public void close(){
        DriverFactory.killDriver();
    }

    protected WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofMillis(60));

    protected void preencherCampo(WebElement webElement, String mensagem) {
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
        webElement.sendKeys(mensagem);
    }

//    Ajustar esse

//    protected void pesquisarPor(String opcao){
//        campoPesquisar.sendKeys(opcao);
//        btnPesquisar.click();
//    }

    protected void waitSomeTime(Duration duration){
        new Actions(DriverFactory.getDriver())
                .pause(duration)
                .build()
                .perform();
    }

    protected  void clicarAposFicarVisivel(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    protected void selecionarOpcaOCombo(WebElement webElement, String opcao) {
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
        clicarAposFicarVisivel(DriverFactory.getDriver().findElement(By.xpath("//mat-option/span[contains(normalize-space(.),'" + opcao + "')]")));
    }

    protected boolean estarPresente(WebElement webElement) {
        webElement.isDisplayed();
        return true;

    }

    protected Actions actions() {
        return new Actions(DriverFactory.getDriver());
    }

    protected static void clicarRadio(WebElement webElement, String opcao) {
        webElement.click();
    }

    protected static void clicar(WebElement webElement) {
        webElement.click();
    }

    protected WebElement encontrarElemento (String xpath){
    return DriverFactory.getDriver().findElement(By.xpath(xpath));
    }


}