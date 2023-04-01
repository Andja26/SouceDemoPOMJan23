package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{


    //webelementi

    @FindBy (xpath = "//button [@data-test = 'continue-shopping']")
    WebElement continueShoppingButton;

    @FindBy (xpath = "//button [@data-test = 'checkout']")
    WebElement checkoutButton;

    @FindBy (xpath = "//button [@data-test = 'remove-sauce-labs-bike-light']")
    WebElement removeButton;

    @FindBy (xpath = "//div[@class = 'cart_item']")
    WebElement cartItem;


    //konstruktor

    public ShoppingCartPage (ChromeDriver driver) {
        super(driver);
        print("ShoppingCartPage");
        assert verifyURL(Strings.SHOPPING_CART_URL) : "Wrong URL";
    }


    //metoda (za asertaciju kada nas kupovina redirektuje na cartpage, da potvrdimo da je tekst itema jednak itemu
    //u korpi

    public String getFirstItemName () {
        print("getFirstItem");

        //posto webelementi mogu da budu delovi stranice, mi mozemo u okviru njega
        //da nadjemo elemente .// - . znaci da u okviru tog elementa trazi dalje
        WebElement itemName = cartItem.findElement(By.xpath(".//div[@class = 'inventory_item_name']"));
        return itemName.getText ();


    }






}
