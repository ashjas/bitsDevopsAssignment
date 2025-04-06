package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void testGreeting() {
        App app = new App();
        assertEquals("Hello from myapp!", app.getGreeting());
    }
}