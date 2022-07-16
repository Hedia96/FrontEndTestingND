package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;

public class D05_hoverCategoriesStepDef extends P03_HomePage {

    /**************in DOM the class name was not select that means those are considered dynamic list not static ***************/
    String selectedsubcategoryString="";
    @Given("Hover on the one of main categories")
    public void hoveronRandomMainCategory() throws InterruptedException {
        // to get the random
          /* WebElement e= Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li["+ Hooks.getRandomnumber(3,1)+ "]/a"));
        System.out.println("selected main category"+e.getText());*/

        Actions action = new Actions(Hooks.driver);
        //WebElement e =getMainCategories().get(Hooks.getRandomnumber(3,1));
        WebElement e = getMainCategoryRandom();
        action.moveToElement(e).perform();
        // System.out.println("length of main " + getMainCategories().size());
        Thread.sleep(2000);


    }

@When("select one of sub categories")
    public void clickSubCategory() throws InterruptedException {

    //List<WebElement> itemspercategory = Hooks.driver.findElements(By.className("first-level"));
    // List<WebElement> itemspercategory = getSubListPerMainCategory();
    //  List<WebElement> itemspercategory= Hooks.driver.findElements(By.xpath("//ul[@class=\"first-level\"]"));
//xpath("/html/body/div[6]/div[2]/ul[1]/li")
    List<WebElement> itemspercategory = Hooks.driver.findElements(By.cssSelector("ul.first-level"));
    System.out.println(itemspercategory.size());
    int i;
    for (i = 0; i < itemspercategory.size(); i++) {

        System.out.println("name is: " + itemspercategory.get(i).getText() + " " + itemspercategory.get(i).getText().isEmpty());
        if (!itemspercategory.get(i).getText().isEmpty()) {
            break;
        }
    }
    /**** how get the all elemnts in sublist  to select it randomly too ****/
     selectedsubcategoryString=itemspercategory.get(i).getText();
     System.out.println("thee selected sub catg is "+ selectedsubcategoryString);
    itemspercategory.get(i).click();

    Thread.sleep(1000);
}

@Then("check the page title same as the text of selected sub category")
    public void checkPagetitle()
{
    //get the page title
    String Act=Hooks.driver.findElement(By.cssSelector("div.page-title")).getText();
    Act.toLowerCase().trim();
   // System.out.println("actual ssssssssssssssss"+Act);
    // assert with the variable string selected sub category
   // Assert.assertTrue(Act.contains(selectedsubcategoryString));
    Assert.assertTrue(selectedsubcategoryString.contains(Act));
   // System.out.println("Expecttttttttttted"+selectedsubcategoryString);
    //System.out.println("after assertion");

}
}



