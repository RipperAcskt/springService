package com.example.springservice.logic;


import com.example.springservice.controller.Controll;
import com.example.springservice.controller.Counter;
import com.example.springservice.polindrom.Polindrom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CountLogic {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountLogic.class);
    Polindrom result = new Polindrom();
    Hash map = new Hash();

    public Polindrom calc(String word){
        if(map.isContain(word)){
            LOGGER.info("Response Cash: len: " + String.valueOf(map.getParameters(word).getLen()) + " isPolinom: " + map.getParameters(word).getIsPolindrom() + "word" + word);
            return map.getParameters(word);
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
        result.setLen(word.length());
        result.setIsPolindrom(str);
        map.addToMap(word, result);
        LOGGER.info("Response: len: " + String.valueOf(word.length()) + " isPolinom: " + str);
        return result;
    }
}
