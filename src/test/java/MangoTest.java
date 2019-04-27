import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class MangoTest {
    private static RemoteWebDriver driver;
    private static MainPage mainPage;
    private static MarketPage marketPage;
    private static CatalogPage catalogPage;
    private static FilterPage filterPage;
    private static GoodsPage goodsPage;


    @BeforeClass
    public static void setup() throws MalformedURLException {
        URL chromeDriverUrl = new URL("http://localhost:4444/wd/hub/");
        driver = new RemoteWebDriver(chromeDriverUrl, new ChromeOptions());
        mainPage = new MainPage(driver);
        marketPage = new MarketPage(driver);
        catalogPage = new CatalogPage(driver);
        filterPage = new FilterPage(driver);
        goodsPage = new GoodsPage(driver);

        driver.get("https://yandex.ru/");
    }

    @Test
    public void Apple() throws InterruptedException {
        mainPage.clickTab("Маркет");
        marketPage.clickTab("Электроника");
        catalogPage.clickSection("Мобильные телефоны");
        filterPage.setManufacturer("Apple");
        filterPage.setPriceFrom("60000");
        Thread.sleep(4000);
        String filterPageGoodsTitle = filterPage.getTitleGoods(1);
        filterPage.selectGoods(1);
        String goodsPageGoodsTitle = goodsPage.getTitle();

        assertEquals(filterPageGoodsTitle,goodsPageGoodsTitle);
    }

    @Test
    public void Beats() throws InterruptedException {
        mainPage.clickTab("Маркет");
        marketPage.clickTab("Электроника");
        catalogPage.clickSection("Наушники и Bluetooth-гарнитуры");
        filterPage.setManufacturer("Beats");
        filterPage.setPriceFrom("17000");
        filterPage.setPriceTo("25000");
        Thread.sleep(4000);
        String filterPageGoodsTitle = filterPage.getTitleGoods(1);
        filterPage.selectGoods(1);
        String goodsPageGoodsTitle = goodsPage.getTitle();

        assertEquals(filterPageGoodsTitle,goodsPageGoodsTitle);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}
