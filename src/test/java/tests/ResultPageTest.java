package tests;

import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.ResultPage;

public class ResultPageTest extends BaseTest {
    HomePage homePage;
    ResultPage resultPage;

    @BeforeClass
    public void precondition() {
        homePage = new HomePage();
        resultPage = new ResultPage();
        homePage.openPage()
                .enterCityFrom("Москва")
                .enterDestinationCity("Санкт-Петербург")
                .selectPassengers()
                .clickCalendar()
                .selectDays("1")
                .selectDays("2")
                .clickSearchBtn();
    }

    @Test
    public void checkingResultPage() {
        resultPage.verifyCityFrom()
                .verifyCityDestination()
                .verifySortPrice()
                .verifyDepartureData();
    }
}