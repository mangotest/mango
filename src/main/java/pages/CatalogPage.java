package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage {
    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Перейти в категорию")
    public void clickSection(String sectonName){
        String tabXpath = String.format("//a[contains(text(), '%s')]", sectonName);
        driver.findElement(By.xpath(tabXpath)).click();
    }


}