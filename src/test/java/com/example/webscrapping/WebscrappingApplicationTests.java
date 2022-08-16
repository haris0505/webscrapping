package com.example.webscrapping;

import com.example.webscrapping.service.Darazdata;
import com.example.webscrapping.service.Scrapedata;
import com.example.webscrapping.service.SpieceJetPage;
import com.example.webscrapping.service.Ecom.Ecommerce;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebscrappingApplicationTests {

    @Autowired
    Scrapedata scrapedata;

    @Autowired
    Darazdata darazdata;

    // @Autowired
    // SpieceJetPage spieceJetPage;

    

    @Test
    void contextLoads() {

        // scrapedata.GetData();

        // darazdata.ScrapData();

        // darazdata.ProductDetail("https://www.daraz.pk/products/flawless-hair-remover-for-women-facial-hair-remover-for-women-women-facial-hair-removing-machine-painless-face-hair-remover-eyebrow-shaper-upper-lips-removal-machine-hair-remover-solution-for-women-automatic-hair-removing-machine-with-light-i227341142-s1447423599.html?spm=a2a0e.searchlist.list.1.1f2b31b4Tz87Z2&search=1");

        // spieceJetPage.selectplaces();
        // spieceJetPage.SelectDate();
        // spieceJetPage.clickPasenger();

    }

}
