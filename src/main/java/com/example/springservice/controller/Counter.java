package com.example.springservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Counter {
    private static final Logger LOGGER = LoggerFactory.getLogger(Counter.class);
    static int calls = 0;

    synchronized public void increment(){
        LOGGER.info("Increment calls");
        calls++;
    }

    @GetMapping("/calls")
    synchronized public int display_calls(){
        LOGGER.info("Display calls");
        return calls;
    }
}
