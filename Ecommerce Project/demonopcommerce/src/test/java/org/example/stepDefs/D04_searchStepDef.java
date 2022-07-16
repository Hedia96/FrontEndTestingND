package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D04_searchStepDef extends P03_HomePage {
    private static String name;
    @Given("^user enter \"(.*)\" of the product$")

    public void enterName(String name){
        //clear text box
        getSearchTxtbox().clear();

        // send -parameter name - keys to text box
        getSearchTxtbox().sendKeys(name);

    }
    @When("click on search button")
    public void clickSearchBtn(){
        // click on search button
        getSearchBtn().click();
    }
    @Then("^check the search result includes\"(.*)\"$")
    public void checkSearch(String keywordsearch){
        //System.out.println("hello check");
        SoftAssert soft =new SoftAssert();
        List<WebElement> L=getProductListSearchResult();
        for(WebElement e :L )
        {
            soft.assertTrue(e.getText().trim().toLowerCase().contains(keywordsearch));
            System.out.println(e.getText()+ "search keyword  is "+ keywordsearch);

        }
        System.out.println("the result items of search"+  keywordsearch +" is "+L.size());
        //soft.assertAll();
    }

}
