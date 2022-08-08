package com.example.webscrapping.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Locaters {

    @Autowired
    WebDriver webDriver;

    public WebElement getElementById(String id){
       return  webDriver.findElement(By.id(id));

    }


    public WebElement getElementByClassName(String classname){
        return  webDriver.findElement(By.className(classname));

    }


    //Custom xpath
    // todo //tagname[@attribute='value'] , //*[@attribute='value']
    public WebElement getElementByXpath(String path){
        return  webDriver.findElement(By.xpath(path));

    }

    public WebElement getElementByName(String name){
        return  webDriver.findElement(By.name(name));

    }


    public WebElement getElementByClassname(String classname){
        return  webDriver.findElement(By.className(classname));

    }

    // todo tagname[attribute='value'] , tagName#id ,tag.classname
    public WebElement getElementByCss(String css){
        return  webDriver.findElement(By.cssSelector(css));

    }


    public WebElement getElementByTag(String tag){
        return  webDriver.findElement(By.tagName(tag));

    }

    public WebElement getElementByLink(String linktext){
        return  webDriver.findElement(By.linkText(linktext));

    }


    public WebDriverWait setwait(long time){
        return new WebDriverWait(webDriver,time);
    }

}
