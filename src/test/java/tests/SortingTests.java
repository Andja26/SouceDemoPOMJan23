package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.Strings;

public class SortingTests extends BaseTest {

    @Test
    public void textSortByPriceAsc() {
        print("textSortByPriceAsc");
        ChromeDriver driver = openChromeDriver();
        try {

            loginUser(driver);

            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.sortItemsByText(Strings.SORT_BY_PRICE_ASC);

            //verifikovati, dohvati mi prvi item
            //probaj da sortiras jos










        } finally {

            driver.quit();
        }
    }














}
