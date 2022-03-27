package com.example.springservice.logic;

import com.example.springservice.polindrom.Polindrom;

import java.util.HashMap;

public class Hash {
    private HashMap<String, Polindrom> map = new HashMap<>();

    public boolean isContain(String key) {
        return map.containsKey(key);
    }

    public void addToMap(String key, Polindrom result) {
        map.put(key, result);
    }

    public Polindrom getParameters(String key) {
        return map.get(key);
    }
}
