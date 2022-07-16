package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef extends P01_Register {
    @Given("user go to register page")
    public void goRegisterPage()
    {
        //System.out.println("This is a test before start coding");

        //WebElement registerBtn = Hooks.driver.findElement(By.cssSelector("a[href=\"/register?returnUrl=%2F\"]"));
        //registerBtn.click();

        getregisterlink().click();
    }
    @When("^Entering username\"(.*)\" and Lastname\"(.*)\"and Email \"(.*)\"$")
    public void enterPersonlDetails(String firstname,String lastname, String email)
    {
        getFirstname().sendKeys(firstname);
        getLastname().sendKeys(lastname);
        getEmail().sendKeys(email);

    }
    @And("^Enter\"(.*)\"as Password and its confirmation$")
    public void enterPassword(String password){
    getPass().sendKeys(password);
    getConfirmPass().sendKeys(password);
    }
    @And ("Click on Register button")
    public void clickRegBtn()
    {
    getRegBtn().click();

    }

    @Then("Display the registration success message")
    /*use the assert in cucmber-testng*/
    public void checkSuccessRegister()
    {
        /*soft assertion for message, colour */
        SoftAssert soft =new SoftAssert();
        /***/
        String Actualmsg= getMessageSuccessReg().getText();
        soft.assertTrue(Actualmsg.contains(ExpectedSuccessReg));
        // check the color background

        soft.assertAll();
    }



}
