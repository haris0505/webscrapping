package com.example.webscrapping.service.Ecom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EcommerceTest {

    @Autowired
    Ecommerce ecommerce;
    
    @Test
    void testPrintproduct() throws InterruptedException {
        // ecommerce.printproduct();
        ecommerce.addProducts();
    }
}
