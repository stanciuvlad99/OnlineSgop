package ro.mycode.controllers;

import ro.mycode.Utils.Utile;
import ro.mycode.models.Products;

import java.util.ArrayList;

public class ControlProducts {

    private ArrayList<Products> products;

    private final String FILE_PATH="C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\products.txt";

    public ControlProducts(){
        this.products=new ArrayList<>();
        Utile.load(FILE_PATH,"products", products);
    }

    public void read(){
        Utile.read(products);
    }
}
