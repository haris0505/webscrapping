package com.example.webscrapping.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MouseInteractionTest {

    @Autowired
    MouseInteraction mouseInteraction;

    @Test
    void testMoveMouse() {
        mouseInteraction.addcaptcha();
        mouseInteraction.moveMouse();

    }
}
