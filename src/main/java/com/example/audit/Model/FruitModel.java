package com.example.audit.Model;

import java.util.LinkedHashMap;

public class FruitModel {


    private int id;


    private String FruitName;
    private int Price;
    private int number;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFruitName() {
        return FruitName;
    }

    public void setFruitName(String fruitName) {
        FruitName = fruitName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }



    public FruitModel(int id, String fruitName, int price, int number) {
        this.id = id;
        FruitName = fruitName;
        Price = price;
        this.number = number;
    }



}