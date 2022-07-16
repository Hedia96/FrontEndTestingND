package org.example.stepDefs;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.WeakHashMap;

public class D08_whishlistStepDef extends P03_HomePage {




    @When("user press on the wishlist button")
    public void clickWishBtn() throws InterruptedException {
        Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]")).click();
        Thread.sleep(200);

//


    }
    //@And("user click on url in notifcation msg")
public void clickURLNotifcationmsg()
{
    Hooks.driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a")).click();
}

    @Then("check green message pop up and content")
    public void checkWishmsg(){
        SoftAssert soft=new SoftAssert();
        //get the color background in hex
        String colourBackground_hex=Color.fromString(getBarWishNotifcaEle().
                getCssValue("background-color")).asHex();
        String expectedColorhex="#4bb07a";
        soft.assertTrue(colourBackground_hex.contains(expectedColorhex));
        /**** assert on the content of message  **/
        String actmsg= getBarWishNotifcaEle().getText();
        String expectmsg="The product has been added to your wishlist";
        soft.assertTrue(actmsg.contains(expectmsg));

      //  System.out.println("coor issssss "+Hooks.driver.findElement(By.className("bar-notification")).getCssValue("background-color"));
        //String colourBackground_hex=Color.fromString(Hooks.driver.findElement(By.className("bar-notification")).getCssValue("background-color")).asHex();
        //System.out.println(colourBackground_hex);
        soft.assertAll();
    }
    @And("refer to link wishlist shown in the message")
    public void checkWishRefURL(){
       // Hooks.driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a")).click();
        clickURLNotifcationmsg();
        // Expected url is
        String actURL=Hooks.driver.getCurrentUrl();
        String expectedURL="https://demo.nopcommerce.com/wishlist";
        Assert.assertEquals(actURL,expectedURL);

    }
    @And("check the quantity")
    public void checkQnt(){
        // get the quantity
        String quantity= Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[6]/input")).getAttribute("value");
        int qnty=Integer.valueOf(quantity);
        Assert.assertTrue(qnty>0);

    }
    @And("refer to link wishlist shown in the message and check the quantity more than 1")
    public void checkWishRefURL_Qnt(){

    }
}
