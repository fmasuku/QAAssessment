package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class stepDefinitions {
    public  WebDriver driver;

    String LandingPage_Productname;

    @Given("User is on Landing Page")
    public void user_is_on_landing_page() throws InterruptedException {

        //        //preconditions ---> launch browser
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\13889\\IdeaProjects\\SundayP1\\Drivers\\chromedriver.exe");
        System.setProperty("webdriver.edge.driver","C:\\Users\\13889\\IdeaProjects\\SundayP1\\Drivers\\msedgedriver.exe");

         driver = new EdgeDriver();
         driver.get("https://master.d2thsy9okxnekb.amplifyapp.com/product");
         driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }
    @When("User searched with shortname {string} and extracted actual name of the product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortname) {
        //Clear search field
        driver.findElement(By.name("search")).clear();
        //search for "App" shortname -- for apple
        driver.findElement(By.name("search")).sendKeys(shortname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);





    }
    @Then("User add more than one {string} into the cart")
    public void user_add_more_than_one_into_the_cart(String string) {
        //Add 3 apples into a Cart---
        //Add one apple into a cart
        driver.findElement(By.xpath("/html/body/app-root/div/app-product/div[2]/div/div/div[6]/table/tbody/tr/td[2]/div/div[3]/div[3]/button")).click();
        //Add second apple into a cart
        driver.findElement(By.xpath("/html/body/app-root/div/app-product/div[2]/div/div/div[6]/table/tbody/tr/td[2]/div/div[3]/div[3]/button")).click();
        //Add third apple into a cart
        driver.findElement(By.xpath("/html/body/app-root/div/app-product/div[2]/div/div/div[6]/table/tbody/tr/td[2]/div/div[3]/div[3]/button")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //grab product name "Tomato" in offers page
        LandingPage_Productname = driver.findElement(By.xpath("/html/body/app-root/div/app-product/div[2]/div/div/div[6]/table/tbody/tr/td[2]/div/div[1]")).getText();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }
    @Then("User check if correct product is added to the Cart")
    public void user_check_if_correct_product_is_added_to_the_cart() {

        //Product name validation
        Assert.assertEquals(LandingPage_Productname, "Apples");

    }


































//    public String OffersPage_productname;

//
//    @Given("User is on GreenCart Landing Page")
//    public void user_is_on_green_cart_landing_page() throws InterruptedException {
//        //preconditions ---> launch browser
////        System.setProperty("webdriver.chrome.driver","C:\\Users\\13889\\IdeaProjects\\SundayP1\\Drivers\\chromedriver.exe");
//        System.setProperty("webdriver.edge.driver","C:\\Users\\13889\\IdeaProjects\\SundayP1\\Drivers\\msedgedriver.exe");
//
//         driver = new EdgeDriver();
//         driver.get("https://master.d2thsy9okxnekb.amplifyapp.com/product");
//         driver.manage().window().maximize();
//         Thread.sleep(2000);
//
//    }
//    @When("User searched with shortname {string} and extracted actual name of product")
//    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
//    //search for "tom" shortname
//        driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']")).sendKeys(shortname);
//        //get Tomato - product name, that has been populated after searching , 2--> get shortname "Tom"
//
//
//        landingPage_productname = driver.findElement(By.cssSelector("tbody tr td:nth-child(1)")).getText().split("-")[0].trim();
//        //click "Top deals " link to move to child window
//        Thread.sleep(2000);
//        driver.findElement(By.linkText("Top Deals")).click();
//        //Handing windows
//        Set<String> s1 = driver.getWindowHandles();
//        //iterator
//        Iterator<String> i1 = s1.iterator();
//        //moving to child window "offers page"
//        String parentWindow = i1.next();
//        String childWindow = i1.next();
//        driver.switchTo().window(childWindow);
//        //sending shortname "Tom" to search field on offers page
//        driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortname);
//        //grab product name "Tomato" in offers page
//        //OffersPage_productname = driver.findElement(By.xpath("//td[normalize-space()='Tomato']")).getText();
//        Thread.sleep(2000);
//        //grab tom text
//        OffersPage_productname =driver.findElement(By.xpath("//td[normalize-space()='Tomato']")).getText();
//    }
//    @Then("user searched for {string} shortname in Offers page to check if product exist with same name")
//    public void user_searched_for_shortname_in_offers_page_to_check_if_product_exist_with_same_name(String string) {
//    //validate
//        Assert.assertEquals(landingPage_productname, OffersPage_productname);
//    }
//


}
