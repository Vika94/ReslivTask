package tests;

import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultPage;
import pages.TestData;

public class ResultPageTest extends BaseTest {
    TestData testData = new TestData();

    @BeforeClass
    public void precondition() {
        testData.setCityFrom("Москва");
        testData.setCityDestination("Санкт-Петербург");
        new HomePage().openPage()
                .enterCityFrom(testData)
                .enterDestinationCity(testData)
                .selectPassengers()
                .clickCalendar()
                .selectDays("1")
                .selectDays("2")
                .clickSearchBtn();
    }

    @Test
    public void checkingResultPage() {
        new ResultPage().verifyCityFrom()
                .verifyCityDestination()
                .verifySortPrice()
                .verifyDepartureData();
    }
}