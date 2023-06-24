package ro.mycode.utils;

import ro.mycode.models.OrderDetails;

import java.util.ArrayList;

public class CartItem {


    private String productName;
    private int productId;
    private int quantity;
    private int productPrice;


    public CartItem(int productId, int quantity,String productName,int productPrice){
        this.productName=productName;
        this.productId=productId;
        this.quantity = quantity;
        this.productPrice=productPrice;
    }

    public CartItem(int productId, int quantity) {
        this.productId=productId;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        String text="";
        text+="product name " + productName + "\n";
        text+="product id " + productId + "\n";
        text+="quantity " + quantity + "\n";
        text+="product price " + productPrice + "\n";
        return text;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId(){
        return productId;
    }

    public void setProductId(int productId){
        this.productId=productId;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }


    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int price(int productId){
        if (this.productId==productId){
            return productPrice;
        }
        return -1;
    }


    public int getTotalAmmount(){
        return quantity*productPrice;
    }





}
