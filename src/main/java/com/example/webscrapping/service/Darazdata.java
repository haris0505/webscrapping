package com.example.webscrapping.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class Darazdata {

    @Autowired
    WebDriver webDriver;

    public void ScrapData(){

        String url="https://www.daraz.pk/catalog/?q=facial+hair+remover+machine+for+women&page=1";
//        String activeurl="https://www.daraz.pk/catalog/?q=facial%20hair%20remover%20machine%20for%20women&rating=1";
//        String ratingurl_4="https://www.daraz.pk/catalog/?q=facial%20hair%20remover%20machine%20for%20women&rating=4";

//        webDriver.navigate().to(url);
        webDriver.get(url);

        WebDriverWait wait1 = new WebDriverWait(webDriver, 200);
//        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"c1DXz4\"]")));

        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        WebElement productcount=webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div/div/span[1]"));

        System.out.println("Total Listing "+productcount.getText());

        webDriver.findElements(By.className("cJpy4P")).get(1).click();

       // webDriver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        new WebDriverWait(webDriver, 3000).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
         productcount=webDriver.findElement(By.xpath("//div[@class=\" c1DXz4\"]"));

        System.out.println("4 + rating "+productcount.getText());



        webDriver.findElements(By.className("cJpy4P")).get(4).click();

        //wait1.until(ExpectedConditions.visibilityOf(By.xpath("//div[@class=\"c1DXz4\"]")));
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        productcount=webDriver.findElement(By.xpath("//div[@class=\" c1DXz4\"]"));

        System.out.println("1 + rating "+productcount.getText());

        WebElement nextbtn=webDriver.findElement(By.className("ant-pagination-next"));
        int i=1;
        for(;i<=1;i++){

            System.out.println("PageNo #"+ i);
            url="https://www.daraz.pk/catalog/?q=facial+hair+remover+machine+for+women&page="+i+"&rating=1";


            webDriver.navigate().to(url);
            webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            List<WebElement> ele=webDriver.findElements(By.xpath("//div[@class=\"c3KeDq\"]"));

            ele.stream() .forEach(it->{




                String price=it.findElement(By.className("c3gUW0")).getText();
                String rating=it.findElement(By.className("c15YQ9")).getText();
                String link=it.findElement(By.xpath(".//div[@class=\"c16H9d\"]/child::a")).getAttribute("href");

                String name=it.findElement(By.xpath(".//div[@class=\"c16H9d\"]/child::a")).getText();


               ProductDetail(link);

                System.out.println(name);
                System.out.println("\t" + link);
                System.out.println("\t" + price);
                System.out.println("\t" + rating);
                System.out.println("\n");
            });

        }
//        while (nextbtn.isEnabled()){
//
//
//
//
//
//            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(languagesParagraphXpath)));
//
//            webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
//            //List<WebElement> ele=webDriver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[1]/div[2]"));
////
////            for (WebElement it:
////                    ele) {
////
////                System.out.println("Page no# "+ i);
////                String link=it.findElement(By.xpath(".//div[@class=\"c16H9d\"]/child::a")).getAttribute("href");
////                String name=it.findElement(By.xpath(".//div[@class=\"c16H9d\"]/child::a")).getText();
////                String price=it.findElement(By.className("c3gUW0")).getText();
////                String rating=it.findElement(By.className("c15YQ9")).getText();
////
////
////                System.out.println(name);
////                //System.out.println("\t" + link);
////                System.out.println("\t" + price);
////                System.out.println("\t" + rating);
////                System.out.println("\n");
////
////
////            }
//
//           // nextbtn=webDriver.findElement(By.className("ant-pagination-next"));
////            nextbtn.click();
////            webDriver.navigate().refresh();
//
//
//        }

      webDriver.quit();


    }





    public void ProductDetail(String url){

//        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
//        webDriver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);

        JavascriptExecutor js = (JavascriptExecutor)webDriver;

        webDriver.get(url);
//        WebElement reviews=webDriver.findElement(By.className(" "));
//        WebElement qs=webDriver.findElement(By.className(" "));

//        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        js.executeAsyncScript("window.open(arguments[0]); " +
                "window.addEventListener('load',function (){" +
                "alert('Its loaded')})" , url);


//        js.executeAsyncScript("console.log(items)");
//
//        String t="tr";
//        System.out.println(result);



    }







}
