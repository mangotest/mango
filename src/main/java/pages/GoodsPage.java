package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoodsPage {
    private WebDriver driver;

    public GoodsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath="//div[contains(@class, 'n-title__text')]/h1")
    private WebElement goodsTitle;

    @Step("Получить название товара на странице товара")
    public String getTitle(){
        String title = goodsTitle.getText();
        return title;
    }
}
