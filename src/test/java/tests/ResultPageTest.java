package tests;

import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultPage;

public class ResultPageTest extends BaseTest {

    @BeforeClass
    public void precondition() {
        new HomePage().openPage()
                .enterCityFrom()
                .enterDestinationCity()
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