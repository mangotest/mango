package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilterPage {
    private WebDriver driver;

    public FilterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath="//div[contains(@data-id, 'model-')]")
    private List<WebElement> goodsList;


    @Step("Заполнить поле \"Цена от\"")
    public void setPriceFrom(String pf){
        driver.findElement(By.id("glpricefrom")).sendKeys(pf);
    }

    @Step("Заполнить поле \"Цена до\"")
    public void setPriceTo(String pt){
        driver.findElement(By.id("glpriceto")).sendKeys(pt);
    }

    @Step("Установить чекбокс на производителе")
    public void setManufacturer(String manufacturer){
        String tabXpath = String.format("//span[text()='%s']", manufacturer);
        driver.findElement(By.xpath(tabXpath)).click();
    }

    @Step("Выбрать товар из списка под номером:")
    public void selectGoods(int number){
        WebElement element = goodsList.get(number-1);
        element.findElement(By.xpath(".//div[contains(@class, 'title')]/a")).click();
    }

    @Step("Запомнить название товара под номером:")
    public String getTitleGoods(int number){
        WebElement element = goodsList.get(number-1);
        String goodsTitle = element.findElement(By.xpath(".//div[contains(@class, 'title')]/a")).getText();
        return goodsTitle;
    }
}
