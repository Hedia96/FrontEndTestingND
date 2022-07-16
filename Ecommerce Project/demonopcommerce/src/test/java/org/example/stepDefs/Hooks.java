package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
    @Before
    public static void openBrowser()
    {
        // 1- Bridge
      //  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
        String chromepath=System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromepath);
        //Note: you could use WebDriverManager.chromedriver().setup() instead of System.setProperty() as explained in the videos
        // 2- create object from chrome browser
        driver = new ChromeDriver();
        //3- Configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 4- navigate to url
        driver.get("https://demo.nopcommerce.com/");
    }
    @After
    public static void closeBrowser()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
/** get the  Random integer number**/
public static int  getRandomnumber(int max, int min)
{
    int randomNum = (int)Math.floor(Math.random()*(max-min+1)+min);
    return randomNum;
}
    /** The Implicit Wait in Selenium is used to tell the web driver to wait for a certain amount of time as long as the element still not present in DOM Page

* The mechanism is to check if the element is present in DOM Page every 0.5 second, if the element is present in DOM Page then the code will proceed without having to wait the whole timeout assigned
  for example, if the element is present in DOM Page after 2 seconds, the code won't have to wait all the 7 seconds

            * if the element still not exist in DOM page after the timeout using (findElement not findElements) then the code will throw a “No Such Element Exception” error and the test case will be failed.
            In case of using findElements >> No error will be thrown and output will be empty  which means size() = zero

* Note 1: it's not preferred to use large number like
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    because if any element is not exist in DOM page for any out of hand reason >> that means your test case will wait 100 seconds before it fails


* Beside ImplicitlyWait there's also another thing in Selenium called explicitlyWait which will be discussed later in the project
    Each one has its own usage and we are using both in Automation.
            ImplicitlyWait & ExplicitlyWait are reducing the needs to use Thread.sleep in the code but don't eliminate it, which means we still need to use Thread.sleep but within a small range

            * Keep in Mind: implicitlyWait has only one condition to check which is waiting until the element is exist in DOM Page
    but explicitlyWait has multiple conditions unlike implicitlyWait
    For example
    wait unitl element is visible on UI Page
    wait until element is clickable on UI Page
    wait until the url of the browser to be...
    wait until number of browser tabs to equal...

    We will discuss it later
*/






}
