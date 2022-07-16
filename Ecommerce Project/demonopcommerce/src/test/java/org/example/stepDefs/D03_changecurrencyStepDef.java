package org.example.stepDefs;

//import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class D03_changecurrencyStepDef  extends P03_HomePage {

    @Given("click on the left top tab on the page")
    public void getListCurrency()
    {
       //return getDropList();
        getDropList();
    }
    @When("^select the needed currency\"(.*)\"$")
    public void selectCurrencyvalue(String value)
    {
        selectValue(value);
        //System.out.println("in step def value"+ value);
    }
    @Then("check the selected currency reflected in the shown products")
    public void checkImpactofSelectedCurrency()
    {
        SoftAssert soft =new SoftAssert();
        //check the displayed currency according to the selected value from the drop list
        //System.out.println("SSSSSSSSSS"+Hooks.driver);

      // WebElement e=Hooks.driver.findElement(By.id("customerCurrency"));
        //Select s= new Select(e);
        String selectedvalue =getDropList().getFirstSelectedOption().getAttribute("value");
       // System.out.println("after clik"+selectedvalue);
        //soft.assertTrue(selectedvalue.contains(USDollar_valueselectitem));
        soft.assertTrue(selectedvalue.contains(Euro_valueselectitem));
        //System.out.println( s.getFirstSelectedOption().getAttribute("value"));
        //System.out.println( s.getFirstSelectedOption().getTagName());
    //    String selectValue =getDropList().getFirstSelectedOption().getText();
       // System.out.println("assertion "+selectValue);
        /******** making for loop to detect the products check to Euro sign ******/
        List<WebElement> l= getProductsPrices();

        ArrayList<String> ProductPricesList =new ArrayList<>();
        for (int i=0;i<l.size();i++)
        {
            //System.out.println("the price "+ l.get(i).getText());
            ProductPricesList.add(l.get(i).getText());
            Assert.assertTrue(ProductPricesList.get(i).contains("€"));
           // System.out.println("after asserion"+i);
        }


        soft.assertAll();
    }
}
