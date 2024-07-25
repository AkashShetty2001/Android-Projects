package com.example.ecommerceapp.models;

public class MyCartModel {

    String currentDate;
    String currentTime;
    String productPrice;
    String productName;
    String totalQuantity;
    int totalPrice;

    public MyCartModel() {
    }

    public MyCartModel(String currentDate, String currentTime, String productPrice, String productName, String totalQuantity, int totalPrice) {
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.productPrice = productPrice;
        this.productName = productName;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
