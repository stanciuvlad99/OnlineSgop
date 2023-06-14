package ro.mycode.controllers;

import ro.mycode.comparators.CompareProductByWeight;
import ro.mycode.comparators.CompareProductsByPrice;
import ro.mycode.utils.Utile;
import ro.mycode.models.Products;

import java.util.ArrayList;
import java.util.Collections;

public class ControlProducts {


    private ArrayList<Products> products;

    private final String FILE_PATH = "C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\products.txt";

    public ControlProducts(ArrayList<Products> products) {
        this.products = products;
    }

    public ControlProducts() {
        this.products = new ArrayList<>();
        Utile.load(FILE_PATH, "products", products);
    }

    public void read() {
        Utile.read(products);
    }

//    public  Products  minProduct(){
//        return  Collections.min(products);
//    }

    public Products minProductsWeight() {
        return Collections.min(products, new CompareProductByWeight());
    }

    public Products minProductsPrice() {
        return Collections.min(products, new CompareProductsByPrice());
    }

    public Products findByProductsId(int productsId) {
        for (int i = 0; i < this.products.size(); i++) {
            if (products.get(i).getId() == productsId) {
                return products.get(i);
            }
        }
        return null;
    }

    public Products findByName(String name) {
        for (int i = 0; i < this.products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                return products.get(i);
            }
        }
        return null;
    }

    public int returnIdByName(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                return products.get(i).getId();
            }
        }
        return -1;
    }

    public int nextId() {
        if (products.size() == 0) {
            return -1;
        }
        return products.get(products.size() - 1).getId() + 1;
    }

    public void add(Products products) {
        this.products.add(products);
    }

    public Products findBySku(String sku) {
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).getSku().equals(sku)) {
                return products.get(i);
            }
        }
        return null;
    }

    public void updatePrice(Products products) {
        Products update = findBySku(products.getSku());
        if ((products.getPrice()==0)==false) {
            update.setPrice(products.getPrice());
        }
    }

    public void remove(Products products){
        this.products.remove(products);
    }


}
