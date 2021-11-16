package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PropertyReader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HomePage extends BasePage {
    private By origin = By.id("origin");
    private By destination = By.id("destination");
    private By calendar = By.xpath("//div[@data-test-id='departure-date-field']");
    private By passengers = By.xpath("//div[@data-test-id='passengers-field']");
    private By addChildren = By.xpath("//div[@data-test-id='passengers-children-field']//a[contains(@class,'increment')]");
    private By searchBtn = By.xpath("//button[@data-test-id='form-submit']");
    private By showBtn = By.xpath("//div[@class='prediction-advice__title']");

    public HomePage openPage() {
        open(PropertyReader.getConfigProperties().getProperty("url"));
        return this;
    }

    public HomePage enterCityFrom() {
        wait.until(ExpectedConditions.elementToBeClickable(origin));
        clearField(origin);
        getElement(origin).sendKeys(TestData.CITY_FROM);
        return this;
    }

    public HomePage enterDestinationCity() {
        wait.until(ExpectedConditions.elementToBeClickable(destination));
        getElement(destination).sendKeys(TestData.CITY_DESTINATION);
        return this;
    }

    public HomePage selectPassengers() {
        click(passengers);
        click(addChildren);
        return this;
    }

    public HomePage clickCalendar() {
        wait.until(ExpectedConditions.elementToBeClickable(calendar));
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

    public String addDays(String plusDay) {
        Calendar calendar = new GregorianCalendar();
        int today = calendar.get(Calendar.DATE);
        int newDay = today + Integer.parseInt(plusDay);
        return Integer.toString(newDay);
    }
}