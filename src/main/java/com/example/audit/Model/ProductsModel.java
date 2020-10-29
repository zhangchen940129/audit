package com.example.audit.Model;

public class ProductsModel {


    private int id;
    private String ProductsName;

    private String Price;
    private String time;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductsName() {
        return ProductsName;
    }

    public void setProductsName(String productsName) {
        ProductsName = productsName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public ProductsModel(int id, String productsName, String price, String time) {
        this.id = id;
        ProductsName = productsName;
        Price = price;
        this.time = time;
    }






}