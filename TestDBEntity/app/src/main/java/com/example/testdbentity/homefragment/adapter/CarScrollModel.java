package com.example.testdbentity.homefragment.adapter;

public class CarScrollModel {
    private int src;
    private String text1;
    private String text2;

    public CarScrollModel(int src, String text1, String text2) {
        this.src = src;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
