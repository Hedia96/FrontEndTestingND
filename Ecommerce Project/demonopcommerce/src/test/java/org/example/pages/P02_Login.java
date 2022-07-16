package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_Login {
protected  static String URLSuccesslogin="https://demo.nopcommerce.com/";
    public WebElement getLoginTab()
    {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
    }

    public WebElement getEmail()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }

    /*** password text box */
    public WebElement getPass(){
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement getLoginBtn()
    {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
    }
public String getCurrentURL()
{
    return Hooks.driver.getCurrentUrl();
}

public WebElement getMyaccountTab(){

        return Hooks.driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header > div.header-upper > div.header-links-wrapper > div.header-links > ul > li:nth-child(1) > a"));
}
}
