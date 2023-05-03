package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    //mozemo da imamo i atribut ChromeDriver koji posle u konstruktoru setujemo
    //da bi driver iz testa, bio driver i u klasi
    ChromeDriver driver;


    //Webelements

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartIcon;

    @FindBy(xpath = "//div[contains(@class, 'burger-button')]")
    WebElement burgerMenuButton;

    @FindBy(xpath = "//a[text()='Twitter']")
    WebElement twitterButton;


    //konstruktor

    public BasePage() {
    }

    public BasePage(ChromeDriver driver) {
        //ovde setujemo da driver iz testa bude driver i u klasi
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //metode (dobro je staviti i asertaciju u metode, da bi smo znali
    //praksa je pisati i sta metode rade

    /**
     * Clicks on a Shopping cart icon in upper right corner
     */

    public void clicShoppingCartIcon() {
        print("clicShoppingCartIcon");
          /* dobro je staviti i asertaciju u metodu, pre neke akcije nad web elementom, da bi smo znali gde smo tacno pogresili,
      ako npr nemamo metodu, da li je nesto present, selenium moze da izbaci gresku no such element itd
      ovako znamo da ga nije video i da zato nije klikuno*/
        assert isShoppingCartPresent() : "Shopping cart IS NOT present";
        shoppingCartIcon.click();

    }

    /**
     * Method checks if Shopping cart icon is present in header
     *
     * @return
     */
    public boolean isShoppingCartPresent() {
        print("isShoppingCartPresent");
        boolean isPresent = shoppingCartIcon.isDisplayed();
        return isPresent;
    }

//verify url
    public boolean verifyURL(String expectedUrl) {
        print("verifyURL ( " + expectedUrl + ")");
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.equals(expectedUrl);


    }

    public static void print(String s) {
        System.out.println(s);
    }

  // staviti u base page i u base test SLEEP
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (Exception e) {
            print(e.getMessage());

        }
    }

     // is Element Present
        public boolean isElementPresent(WebElement element)  {
            try {
                print("isElementPresent()");
                boolean isPresent = element.isDisplayed();
                return isPresent;
            } catch (Exception e) {
                return false;
    }
}
    // scroll method

    public void scrollIntoView (WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);" , element);
    }





    }