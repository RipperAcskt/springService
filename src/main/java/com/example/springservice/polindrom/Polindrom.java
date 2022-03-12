package com.example.springservice.polindrom;

public class Polindrom {
    private int len;
    private String isPolindrom;

    public Polindrom(int len, String isPolindrom){
        this.len = len;
        this.isPolindrom = isPolindrom;
    }

    public int getLen(){
        return len;
    }
    public String getIsPolindrom(){
        return isPolindrom;
    }

    public void setLen(int len){
        this.len = len;
    }
    public void setIsPolindrom(String isPolindrom){
        this.isPolindrom = isPolindrom;
    }
}
