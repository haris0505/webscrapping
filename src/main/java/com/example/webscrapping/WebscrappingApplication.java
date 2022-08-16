package com.example.webscrapping;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class WebscrappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebscrappingApplication.class, args);
    }


    @Bean
    public WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver=new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return webDriver;
    }
}
