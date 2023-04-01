package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    ChromeDriver driver;

    // prvo se popisuju webelementi

    @FindBy (xpath = "// input[@data-test= 'username']" )
    WebElement usernameField;

    @FindBy (xpath = "// input[@data-test= 'password']" )
    WebElement passwordField;

    @FindBy (xpath = "// input[@data-test= 'login-button']" )
    WebElement loginButton;

    //zatim se pisu konstruktori i parametar mora da bude driver
    //navigavcija na sajt - ok
    //postoji PageFactory klasa i inteElements (njena metoda), koja se izvrsava
    //nad driverom i kad kazemo this (misli se na ovu stranicu koja je poziva tj LoginPage u ovom sl)
    //PageFactory je staticka metoda i ona od svih ovde webel, pravi objekat, inicijalicuje ih
    //tek kada kreiramo objekat stranice sa ovom metodom, ona napravi objekte svih web el

    //konstruktor
    public LoginPage(ChromeDriver driver){
        this.driver = driver;
        driver.get(Strings.LOGIN_PAGE_URL);
        PageFactory.initElements(driver, this);

    }

    //metode nad webelementima

    public void enterTextInUserNameField (String text) {
        usernameField.click();
        usernameField.sendKeys(text);
    }

    public void enterTextInPasswordField(String text) {
        passwordField.click();
        passwordField.sendKeys(text);
    }

    public void clickLoginButton() {
       loginButton.click();
    }







}
