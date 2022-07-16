package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class to get all elements of webpage seprated by the code according to POM design pattern
 * to maintain easily
 *
 * */
public class P01_Register {

    protected static  String ExpectedSuccessReg="Your registration completed";
    //get the register button xpath:    /html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a
    //body > div.master-wrapper-page > div.header > div.header-upper > div.header-links-wrapper > div.header-links > ul > li:nth-child(1) > a
    public WebElement getregisterlink()
    {

        return  Hooks.driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
    }


    /*** get Firstname text box locator **/
public WebElement getFirstname()
{
    return Hooks.driver.findElement(By.id("FirstName"));
}
    /*** get Lastname text box locator **/
    public WebElement getLastname()
    {
        return Hooks.driver.findElement(By.id("LastName"));
    }
    /*** get Email text box locator **/
    public WebElement getEmail()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }

/*** password text box */
public WebElement getPass(){
    return Hooks.driver.findElement(By.id("Password"));
}

/*** confirmation password text box */
public WebElement getConfirmPass(){
    return Hooks.driver.findElement(By.id("ConfirmPassword"));
}

/**** register button****/
public WebElement getRegBtn(){
    return Hooks.driver.findElement(By.xpath("//*[@id=\"register-button\"]"));
}
public  WebElement getMessageSuccessReg()
{
   // System.out.println("The color is "+Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")).getCssValue("background-color"));
    return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));
}
}
