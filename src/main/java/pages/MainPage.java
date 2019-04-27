package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Перейти в раздел")
    public void clickTab(String tabName){
        String tabXpath = String.format("//a[contains(text(), '%s')]", tabName);
        driver.findElement(By.xpath(tabXpath)).click();
    }
}
