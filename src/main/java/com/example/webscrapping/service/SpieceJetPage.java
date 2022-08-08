package com.example.webscrapping.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpieceJetPage {

    @Autowired
    WebDriver webDriver;

    // static drop down contain select tag
    @FindBy(css = "div[data-testid='home-page-travellers'] .r-1awozwy")
    WebElement Passenger;
    @FindBy(css = "div[data-testid='home-page-travellers-done-cta']")
    WebElement OKPassenger;

    public SpieceJetPage(WebDriver driver) {
        webDriver=driver;
        webDriver.manage().window().maximize();
        webDriver.get("https://www.spicejet.com/");
        PageFactory.initElements(driver, this);
    }

    public void clickPaasenger(){
        Passenger.click();
        try {
            Thread.sleep(2000L);
            OKPassenger.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
