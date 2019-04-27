package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MarketPage {
    private WebDriver driver;

    public MarketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Перейти в раздел")
    public void clickTab(String tabName){
        String tabXpath = String.format("//a[contains(span, '%s')]", tabName);
        driver.findElement(By.xpath(tabXpath)).click();
    }
}
