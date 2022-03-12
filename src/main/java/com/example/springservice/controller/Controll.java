package com.example.springservice.controller;

import com.example.springservice.exception.Exception;
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

import java.net.BindException;

@RestController
public class Controll {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controll.class);

    @GetMapping("/")
    void error() throws Exception{
        LOGGER.info("Endpoint: /");
        LOGGER.info("Internal Server Error");
        throw new Exception("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/check")
    Polindrom len(@RequestParam(value = "str", defaultValue = "") String word) throws Exception {
        LOGGER.info("Endpoint: /cheak");
        LOGGER.info("Request: " + word);
        if(word.equals("")){
            LOGGER.info("BAD REQUEST");
            throw new Exception("BAD REQUEST", HttpStatus.BAD_REQUEST);
        }

        boolean check = true;
        String str = "Yes";
        for(int i = 0; i < word.length()/2; i++){
            if(word.charAt(i) != word.charAt(word.length()-i-1)){
                check = false;
                break;
            }
        }
        if(!check) str = "No";
        LOGGER.info("Response: len: " + String.valueOf(word.length()) + " isPolinom: " + str);
        return new Polindrom(word.length(), str);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception e){
        LOGGER.info("Exception: " + e.getException());
        Response response = new Response(e.getException());

        return new ResponseEntity<>(response, e.getStatus());
    }
}

