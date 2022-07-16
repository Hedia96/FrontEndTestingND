package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class D06_homeSlidersStepDef extends P03_HomePage {

    @When("^click on the slider\"(.*)\"$")
    public void clickSlider(Slidersindecies index ) throws InterruptedException {
        switch(index.ordinal()){
            case 0:
                getSlider().findElement(By.xpath("//*[@id=\"nivo-slider\"]/a[1]")).click();// nokia banner1
                System.out.println("press nokia");
                break;
            case 1:
              /*  /html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a[2]*/
               // getSlider().findElement(By.xpath("//*[@id=\"nivo-slider\"]/a[2]")).click();//iphone banner2
               //Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a[2]"));
               // System.out.println("press phone");
               /* List<WebElement>l =getSliderController();
                System.out.println("sizeof arrray is "+l.size());
                f/or(WebElement e: l)
                {
                    System.out.println("in the loop"+l.getClass());
                }*/


               // JavascriptExecutor js=(JavascriptExecutor)Hooks.driver;
                //<div class="nivo-controlNav"><a class="nivo-control" rel="0">1</a>
                // <a class="nivo-control active" rel="1">2</a></div>
                //script,arg
              // js.executeScript("",Hooks.driver.findElement(By.cssSelector("div[id=\"nivo-controlNav\"]")));
                break;


        }
       // Hooks.driver.manage().timeouts().wait(1000);
        Thread.sleep(1000);
    }
    @Then("^check the current url after\"(.*)\"slider$")
    public void checkSliderRefURL(Slidersindecies index){
        String currentURL=Hooks.driver.getCurrentUrl();
        switch (index.ordinal())
        {
            case 0:
                //Assert.assertEquals(Hooks.driver.getCurrentUrl(),URL_nokia_slider);
                Assert.assertTrue(Hooks.driver.getCurrentUrl().equals(URL_nokia_slider),"Clicking on nokia slider doesn't refer probably as expected ");
                break;
            case 1:
                Assert.assertTrue(Hooks.driver.getCurrentUrl().equals(URL_iphone_slider),"Clicking on nokia slider doesn't refer probably as expected ");

                break;

        }


    }
}
