package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class HomePage extends BasePage {
    private By origin = By.id("origin");
    private By destination = By.id("destination");
    private By calendar = By.xpath("//div[@data-test-id='departure-date-field']");
    private By passengers = By.xpath("//div[@data-test-id='passengers-field']");
    private By addChildren = By.xpath("//div[@data-test-id='passengers-children-field']//a[contains(@class,'increment')]");
    private By searchBtn = By.xpath("//button[@data-test-id='form-submit']");
    private By showBtn = By.xpath("//div[@class='prediction-advice__title']");

    public HomePage openPage() {
        open("https://www.aviasales.by/");
        return this;
    }

    public HomePage enterCityFrom(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(origin));
        clearField(origin);
        getElement(origin).sendKeys(city);
        return this;
    }

    public HomePage enterDestinationCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(destination));
        getElement(destination).sendKeys(city);
        return this;
    }

    public HomePage selectPassengers() {
        click(passengers);
        click(addChildren);
        return this;
    }

    public HomePage clickCalendar() {
        click(calendar);
        return this;
    }

    public HomePage selectDays(String plusDay) {
        getElement(By.xpath(String.format("//div[@class='calendar__months']//div[contains(text(),'%s')]", addDays(plusDay)))).click();
        return this;
    }

    public HomePage clickSearchBtn() {
        click(searchBtn);
        ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab2.get(0));
        driver.close();
        driver.switchTo().window(tab2.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(showBtn));
        return this;
    }
}