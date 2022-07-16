package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Login;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef extends P02_Login {

    @Given("user go to login page")
    public void clickLogin(){
        getLoginTab().click();
    }
    //#And Registered email before to avoid error message
    @When("^Entering registered email \"(.*)\"and Password \"(.*)\"$")
    public void enterValiddatatologin(String email,String password)
    {
        getEmail().sendKeys(email);
        getPass().sendKeys(password);
    }

    @And("click on the login Button")
    public void clickLoginBtn()
    {
        getLoginBtn().click();
    }
    @Then("refer to the page and My account appears on the left top of the page")
    public void checkSuccesslogin()
    {
        SoftAssert soft =new SoftAssert();
        /*check the url */
        soft.assertEquals(getCurrentURL(),URLSuccesslogin);
        soft.assertTrue(getMyaccountTab().isDisplayed(),"My account failed to display");

        soft.assertAll();


    }

}
