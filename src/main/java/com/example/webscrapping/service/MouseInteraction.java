package com.example.webscrapping.service;

import java.util.Scanner;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MouseInteraction {

    @Autowired
    WebDriver driver;

    @FindBy(css = " a#nav-link-accountList")
    WebElement element;

    @FindBy(css = "input#captchacharacters")
    WebElement inputcap;
    

    @FindBy(xpath = "//button[type='submit']")
    WebElement submitcap;

    
    @FindBy(css = "input#twotabsearchtextbox")
    WebElement inputsearch;

    public MouseInteraction(WebDriver driver) {
        this.driver = driver;
        // this.driver.manage().window().maximize();
        this.driver.get("https://www.amazon.com/");
        PageFactory.initElements(driver, this);
    }

    public void addcaptcha() {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        // Thread.sleep(2000L);
        inputcap.sendKeys(input.toUpperCase());
        submitcap.click();

    }

    public void moveMouse() {
        Actions actions = new Actions(driver);
        //move to search box 
        actions.moveToElement(inputsearch).click().keyDown(Keys.SHIFT).sendKeys("Hello").
        doubleClick().build().perform();
        //write click
        actions.moveToElement(element).contextClick() .build().perform();
        
    }
}
