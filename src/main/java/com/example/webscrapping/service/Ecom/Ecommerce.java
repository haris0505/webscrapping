package com.example.webscrapping.service.Ecom;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.webscrapping.service.Locaters;

@Service
public class Ecommerce {

    @Autowired
    WebDriver webDriver;

    @FindBy(css = ".product")
    // @FindBy(css = "h4.product-name")
    List<WebElement> productlist;

    @FindBy(css = "img[alt='Cart']")
    WebElement cartbtn;

    @FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
    WebElement checkout;

    @Autowired
    Locaters locaters;

    @FindBy(css = ".promoCode")
    WebElement promotext;

    @FindBy(css = ".promoBtn")
    WebElement promobtn;

    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement placeOrder;

    @FindBy(css = "h4.product-name")
    public String productname;

    @FindBy(css = "p.product-price")
    public String productprice;

    @FindBy(css = ".quantity")
    public WebElement qty;

    @FindBy(css = "a.decrement")
    public WebElement decrement;

    @FindBy(css = "a.increment")
    public WebElement increment;

    @FindBy(xpath = "//button[text()='ADD TO CART']")
    public WebElement addtoCart;

    public Ecommerce(WebDriver driver) {
        webDriver = driver;
        // webDriver.manage().window().maximize();
        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        PageFactory.initElements(driver, this);
    }

    public void printproduct() {

        System.out.println("size " + productlist.size());
        // Stream.of(productlist).flatMap(Product::).forEach(WebElement::getText);
        // System.out.println(new WebElementToJsonConverter().apply(productlist)) ;

        // productlist=webDriver.findElements(By.cssSelector(".product"));
    }

    public void addProducts() throws InterruptedException {

        String[] orderitems = { "Carrot" };
        // productlist.stream().filter(t->Arrays.asList(orderitems)
        // .contains(t.getText()) )
        // .forEach(tr->{
        // System.out.println(tr);
        // tr.findElement(By.cssSelector("a.increment")).click();
        // tr.findElement(By.xpath("//button[text()='ADD TO CART']") ).click();
        // });

        productlist.stream().limit(30).forEach((arg0) -> {
            // String name=locaters.getElementByCss("h4.product-name").getText();
            String name = arg0.findElement(By.cssSelector("h4.product-name")).getText();
            WebElement inc = arg0.findElement(By.cssSelector("a.increment"));
            WebElement add = arg0.findElement(By.xpath("//button[text()='ADD TO CART']"));
            // String name=arg0.getText();
            int index = name.contains("-") ? name.indexOf("-") : name.length();
            name = name.substring(0, index).trim();
            // locaters.getElementByCss("p.product-price");

            if (Arrays.asList(orderitems).contains(name)) {
                System.out.println(name);

                inc.click();
                add.click();
            }

        });

        cartbtn.click();
        Thread.sleep(2000L);
        checkout.click();
        WebDriverWait wait=new WebDriverWait(webDriver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
        promotext.sendKeys("Promo");
        promobtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
        placeOrder.click();
    }
}
