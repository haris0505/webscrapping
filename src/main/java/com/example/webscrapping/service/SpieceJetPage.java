package com.example.webscrapping.service;

import java.util.Stack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpieceJetPage {

    @Autowired
    WebDriver webDriver;

    
    // @FindBy(css = "div[data-testid='to-testID-origin'] .r-1awozwy")
    // WebElement Fromplacedropdown;

    @FindBy(xpath   = "//div[@data-testid='round-trip-radio-button']")
    WebElement RoundtripButton;

    @FindBy(xpath = "//div[@data-testid='one-way-radio-button']")
    WebElement OnetripButton;
   
    @FindBy(xpath   = "//div[@data-testid='departure-date-dropdown-label-test-id']")
    WebElement DepartureDropdown;

    @FindBy(xpath = "//div[@data-testid='undefined-month-August-2022']//div[@data-testid='undefined-calendar-day-16']")
    WebElement DepartureDate;


    @FindBy(xpath = "//div[@data-testid='return-date-dropdown-label-test-id']")
    WebElement ReturnDateDropdown;

    @FindBy(css  = "div[data-testid='undefined-month-September-2022'] div[data-testid='undefined-calendar-day-16']")
    WebElement ReturnDate;

    @FindBy(xpath   = "//div[@data-testid='to-testID-origin'] //input")
    WebElement Fromplacedropdown;

    @FindBy(xpath = "//div[@data-testid='to-testID-origin']//div[text()='Agra']")
    WebElement Fromplacevalue;

    
    // @FindBy(css = "div[data-testid='to-testID-destination'] .r-1awozwy")
    // WebElement Toplacedropdown;
   
    @FindBy(xpath  = "//div[@data-testid='to-testID-destination'] //input")
    WebElement Toplacedropdown;

    @FindBy(xpath = "//div[@data-testid='to-testID-destination']//div[text()='Amritsar']")
    WebElement Toplacevalue;

    // static drop down contain select tag
    @FindBy(css = "div[data-testid='home-page-travellers'] .r-1awozwy")
    WebElement Passenger;
    
    @FindBy(css = "div[data-testid='Adult-testID-plus-one-cta']")
    WebElement AdultAddPassenger;

    @FindBy(css = "div[data-testid='Adult-testID-minus-one-cta']")
    WebElement AdultMinusPassenger;

    

    @FindBy(css = "div[data-testid='Children-testID-plus-one-cta']")
    WebElement ChildrenAddPassenger;

    @FindBy(css = "div[data-testid='Children-testID-minus-one-cta']")
    WebElement ChildrenMinusPassenger;

    @FindBy(css = "div[data-testid='home-page-travellers-done-cta']")
    WebElement OKPassenger;
    
    
    @FindBy(xpath  = "//div[contains(text(),'Students')]")
    WebElement PassengerType;

    

    public SpieceJetPage(WebDriver driver) {
        // webDriver=driver;
        // webDriver.manage().window().maximize();
        // webDriver.get("https://www.spicejet.com/");
        PageFactory.initElements(driver, this);
    }


    public void SelectDate(){
        
        try {
            // DepartureDropdown.click();   
            Thread.sleep(2000L);
            DepartureDate.click();
            // ReturnDateDropdown.click();
            // Thread.sleep(2000L);
            ReturnDate.click();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       

        System.out.println("Depature Date" + DepartureDropdown.getText());
        System.out.println("Return Date" + ReturnDateDropdown.getText());

    }
    public void clickPasenger(){
      
        try {
            Passenger.click();
            Thread.sleep(2000L);
            click(AdultAddPassenger, 2);
            click(ChildrenAddPassenger, 2);
            OKPassenger.click();

            selectPassengeraType();

            System.out.println("Total Paasenger " +Passenger.getText());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }


    private void click(WebElement webElement,int count){
        for(int i=0;i<count;i++){
            webElement.click();
        }

    }

    public void selectplaces(){
        
        RoundtripButton.click();

        try {
            Fromplacedropdown.click();
            Thread.sleep(2000L);
            Fromplacevalue.click();
            System.out.println("From place " + Fromplacedropdown.getAttribute("value"));
            Toplacedropdown.click();
            Thread.sleep(2000L);
            Toplacevalue.click();
            System.out.println("To place " + Toplacedropdown.getAttribute("value"));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       

    }

    private void selectPassengeraType(){
       PassengerType.click();
    }



   
}



