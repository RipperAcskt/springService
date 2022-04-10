package com.example.springservice.controller;

import com.example.springservice.exception.Exception;
import com.example.springservice.logic.CountLogic;
import com.example.springservice.polindrom.Polindrom;
import com.example.springservice.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controll {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controll.class);
    private CountLogic counter = new CountLogic();
    private Counter calls = new Counter();

    @GetMapping("/")
    public void error() throws Exception{
        LOGGER.info("Endpoint: /");
        LOGGER.info("Can't process Endpoint: /");
        calls.increment();
        throw new Exception("Can't process Endpoint: /", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/check")
    public Polindrom len(@RequestParam(value = "str", defaultValue = "") String word) throws Exception {
        LOGGER.info("Endpoint: /cheak");
        LOGGER.info("Request: " + word);
        if(word.equals("")){
            LOGGER.info("Empty input parametr");
            throw new Exception("Empty input parametr", HttpStatus.BAD_REQUEST);
        }
        System.out.println(Thread.currentThread().getName());
        calls.increment();
        return counter.calc(word);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception e){
        LOGGER.error("Exception: " + e.getException());
        Response response = new Response(e.getException());

        return new ResponseEntity<>(response, e.getStatus());
    }
}

