package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.Driver;

public class GoogleStepdefinitions {
    GooglePage googlePage=new GooglePage();


    @Given("cookies kabul eder")
    public void cookies_kabul_eder() {
    googlePage.cookiesKabulButonu.click();

    }
    @Then("google da {string} icin arama yapar")
    public void google_da_icin_arama_yapar(String istenenKelime) {
        googlePage.googleSearchBox.click();
        googlePage.googleSearchBox.sendKeys(istenenKelime+ Keys.ENTER);

    }
    @Then("google arama sonuclarinin {string} icerdigini test eder")
    public void google_arama_sonuclarinin_icerdigini_test_eder(String istenenKelime) {
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(istenenKelime));

    }

}
