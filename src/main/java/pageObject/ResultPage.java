package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends BasePage {
    private By origin = By.id("origin");
    private By destination = By.id("destination");
    private By departureData = By.xpath("//input[@data-test-id='departure-date-input']");
    private By departureReturnData = By.xpath("//input[@data-test-id='return-date-input']");
    private By flightDates = By.xpath("//div[@data-test-id='date']");
    private By flightCities = By.xpath("//div[@data-test-id='city']");
    private By price = By.xpath("//div[@data-test-id='ticket-desktop']//span[@class='buy-button__text']/..//span[@data-test-id='price']");

    public ResultPage verifyCityFrom() {
        String expectedCity = getElement(origin).getAttribute("value");
        String expectedReturnCity = getElement(destination).getAttribute("value");
        List<String> departureCities = new ArrayList<>();
        getElements(flightCities).forEach(data -> departureCities.add(data.getText()));
        for (int i = 0; i < departureCities.size(); i = i + 4) {
            Assert.assertEquals(expectedCity, departureCities.get(i));
        }
        for (int i = 2; i < departureCities.size(); i = i + 4) {
            Assert.assertEquals(expectedReturnCity, departureCities.get(i));
        }
        return this;
    }

    public ResultPage verifyCityDestination() {
        String expectedCity = getElement(destination).getAttribute("value");
        String expectedReturnCity = getElement(origin).getAttribute("value");
        List<String> destinationCities = new ArrayList<>();
        getElements(flightCities).forEach(data -> destinationCities.add(data.getText()));
        for (int i = 1; i < destinationCities.size(); i = i + 4) {
            Assert.assertEquals(expectedCity, destinationCities.get(i));
        }
        for (int i = 3; i < destinationCities.size(); i = i + 4) {
            Assert.assertEquals(expectedReturnCity, destinationCities.get(i));
        }
        return this;
    }

    public ResultPage verifyDepartureData() {
        String expectedData = getElement(departureData).getAttribute("value");
        String expectedDataBack = getElement(departureReturnData).getAttribute("value");
        List<String> departureData = getElements(flightDates).stream().map(WebElement::getText).collect(Collectors.toList());
        for (int i = 0; i < departureData.size(); i = i + 4) {
            Assert.assertEquals(expectedData.substring(0, 3), departureData.get(i).substring(0, 3));
        }
        for (int i = 2; i < departureData.size(); i = i + 4) {
            Assert.assertEquals(expectedDataBack.substring(0, 3), departureData.get(i).substring(0, 3));
        }
        return this;
    }

    public ResultPage verifySortPrice() {
        List<String> expectedPrice = getElements(price).stream().map(WebElement::getText).sorted().collect(Collectors.toList());
        List<String> actualPrice =getElements(price).stream().map(WebElement::getText).collect(Collectors.toList());
        Assert.assertEquals(expectedPrice, actualPrice);
        return this;
    }
}