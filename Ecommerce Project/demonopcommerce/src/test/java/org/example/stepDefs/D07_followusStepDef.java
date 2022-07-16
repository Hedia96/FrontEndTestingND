package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class D07_followusStepDef extends P03_HomePage
{
    @When("user click on facebook icon from follow us section")
    public void clickonFacbookicon() throws InterruptedException {
//        Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[1]/a")).click();
        getFacbookicon().click();
        Thread.sleep(1000);

    }
    @When("user click on twitter icon from follow us section")
    public void clickonTwittericon() throws InterruptedException {
//        Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[1]/a")).click();
        getTwittericon().click();
        Thread.sleep(1000);

    }


    @When("user click on Youtube icon from follow us section")
    public void clickonYoutubeicon() throws InterruptedException {
//        Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[1]/a")).click();
        getYoutubeicon().click();
        Thread.sleep(2000);

    }

    @When("user click on RSS icon from follow us section")
    public void clickonRSSicon() throws InterruptedException {
//        Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[1]/a")).click();
        getRSSicon().click();
        System.out.println(Hooks.driver.getCurrentUrl()+"  after clck rss  get utllll");
        Thread.sleep(1000);

    }



    @Then("^creating a new tab and the expected URL is \"(.*)\"$")
    public void checkFacebookFollowus(String expectedurl)
    {
       // System.out.println( "tab new ");
//get the tabs open
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        //switch the driver to the tab of facebook
      /*  for (int i=0; i<tabs.size();i++)
        {
            Hooks.driver.switchTo().window(tabs.get(i));
            System.out.println(Hooks.driver.getCurrentUrl());
        }*/
        // reload
        Hooks.driver.getWindowHandles();
        if(tabs.size()>1){
            // System.out.println("hello after reloding");
            Hooks.driver.switchTo().window(tabs.get(1));
            String actualurl= Hooks.driver.getCurrentUrl();
            Assert.assertEquals(actualurl,expectedurl);

            //System.out.println(tabs.size());
        }
        Assert.assertTrue(Hooks.driver.getWindowHandles().size()>1,"number of tabs is less than 2");
        //System.out.println("actual "+Hooks.driver.getCurrentUrl()+"expected "+ expectedurl);

    }


}
