package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P03_HomePage {
    protected static String Euro_valueselectitem="https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F";
    protected static String USDollar_valueselectitem="https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F";
    /********* varaibles for feature F06 slider   **************/
    protected static String URL_iphone_slider= "https://demo.nopcommerce.com/iphone-6 1";
    protected static String URL_nokia_slider="https://demo.nopcommerce.com/nokia-lumia-1020";
    protected enum Slidersindecies {nokia,iphone};
    /*******************************/
    //get the elements of droplist
    public Select getDropList(){
        List<WebElement> l=  Hooks.driver.findElements(By.id("customerCurrency"));
        //System.out.println("the length of list of webelements "+l.size());
       // System.out.println("the value webele"+l.get(0));
       // System.out.println("the get text  "+l.get(0).getText());
        Select selectobj=new Select(l.get(0));
       // System.out.println("print select  "+selectobj);
        //System.out.println("select Is multiple  "+selectobj.isMultiple());
       //selectobj.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
       // System.out.println("after select by value Euro");

    return selectobj;

    }
    public WebElement getDroplistElem()
    {
        return Hooks.driver.findElement(By.id("customerCurrency"));
    }
    public void selectValue(String currvalue)
    {
        //System.out.println("in page value"+ currvalue);
        if(currvalue.equals("Euro")){
            getDropList().selectByValue(Euro_valueselectitem);
            //System.out.println("Ggggggggggggggggggggggggggggggg");
        }else {
            getDropList().selectByValue(USDollar_valueselectitem);
            //System.out.println("dolllllllllllllllllllllllars");
        }

    }

    public List<WebElement> getProductsPrices()
    {
        //System.out.println("in page    elemnets"+Hooks.driver.findElements(By.className("actual-price")).size());
        return Hooks.driver.findElements(By.className("actual-price"));
    }

    /************ for Feature of hovers  try to get the category and its sub ***************/

public List<WebElement> getMainCategories(){
   return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));


    }
    public WebElement getMainCategoryRandom(){
        return  Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li["+Hooks.getRandomnumber(3,1)+"]/a"));
        //"+Hooks.getRandomnumber(3,1)+"]/a"));
    }
public List<WebElement> getSubListPerMainCategory()
{

    return Hooks.driver.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li"));
   // return Hooks.driver.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[*]/a"));

}
/************************************************** F04 | search feature elements *******************************/
public WebElement getSearchBtn()
{
    return Hooks.driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));
}

public WebElement getSearchTxtbox()
{
    return Hooks.driver.findElement(By.id("small-searchterms"));
}

public List<WebElement> getProductListSearchResult()
{
    return Hooks.driver.findElements(By.className("product-title"));
}
/************************************** F06| sliders   *************************************/
public WebElement getSlider(){
    return Hooks.driver.findElement(By.id("nivo-slider"));
}

public List<WebElement> getSliderController()
{
    return Hooks.driver.findElements(By.className("nivo-control*"));
   // /html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a[1]
}

/******************************** follow us******************/
public WebElement getFacbookicon()
{
    return  Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
}
public WebElement getTwittericon()
{
    return Hooks.driver.findElement(By.xpath("//a[@href=\"https://twitter.com/nopCommerce\"]"));
}
    public WebElement getRSSicon()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/news/rss/1\""));
//https://demo.nopcommerce.com/news/rss/1
    }
    public WebElement getYoutubeicon()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }
    /*********************** wish******************/
    public WebElement getBarWishNotifcaEle()
    {
        //Hooks.driver.findElement(By.xpath("//*[@class=\"content\"]"));
        return Hooks.driver.findElement(By.className("bar-notification"));
    }


}
