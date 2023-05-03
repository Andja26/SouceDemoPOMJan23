package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.Strings;

public class BaseTest {


    //u base testu definisem metodu openChromeDriver, jer ne zelim da u svaki test
    //stavim sve ovo. u ovoj metodi istanciram objekat ChromeOptions i
    //podizem chrome driver sa ovim argumentima i vracam ga kao povratnu vrednost
    public ChromeDriver openChromeDriver () {
        print("Opening Chrome Driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        //ovo sluzi za setovanje dimenzija browsera
       // driver.manage().window().setSize(new Dimension(600, 768));
        return driver;
    }


    public void loginUser (ChromeDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterTextInUserNameField(Strings.VALID_USERNAME);
        loginPage.enterTextInPasswordField(Strings.VALID_PASSWORD);
        loginPage.clickLoginButton();

        assert driver.getCurrentUrl().equals(Strings.INVENTORY_PAGE_URL) :
                " User is not logged in. Current url : " +driver.getCurrentUrl() + "" +
                        "Expected: " + Strings.INVENTORY_PAGE_URL;

    }




    //za stamopanje
    public static void print(String s) {System.out.println(s);}

    // staviti u base page i u base test SLEEP
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (Exception e) {
            print(e.getMessage());

        }
    }



}
