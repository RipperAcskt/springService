package com.example.springservice.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;


@Controller
public class Controll {
    @GetMapping("/check")
    String len(@RequestParam(value = "str", defaultValue = "default") String word, Model model){
        boolean check = true;
        String str = "Да";
        for(int i = 0; i < word.length()/2; i++){
            if(word.charAt(i) != word.charAt(word.length()-i-1)){
                check = false;
                break;
            }
        }
        if(!check) str = "Нет";
        model.addAttribute("len", word.length());
        model.addAttribute("isPolinom", str);
        return "check";
    }
}
