package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {

    //webelementi

    @FindBy (xpath = "//select[@data-test='product_sort_container']")
    WebElement dropDownButton;

    @FindBy (xpath = "//button[@data-test ='add-to-cart-sauce-labs-bike-light']")
    WebElement addToCartBikeLight;

    @FindBy (xpath = "//span[@class='shopping_cart_badge']")
    WebElement shoppingCartBadge;

    //konstruktor

    public InventoryPage (ChromeDriver driver) {
       super(driver);
       print("InventoryPage");
       assert verifyURL(Strings.INVENTORY_PAGE_URL) : "Wrong URL";
    }

    //click add to cart bike light method

    public void clickAddToCartBikeLight () {
        print("clickAddToCartBikeLight");
        addToCartBikeLight.click();
    }
 //get text
    public String getNumberFromShoppingCartIcon() {
        print("getNumberFromShoppingCartIcon");
        return shoppingCartBadge.getText();

    }

    //metoda za sortirnje po imenu, tj DROPDOWN

    public void sortItemsByText (String sortType) {
        print("sortItemsByText ( " + sortType + " )");
        Select dropdown = new Select(dropDownButton);
        dropdown.selectByVisibleText(sortType);


    }

}
