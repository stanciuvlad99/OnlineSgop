package ro.mycode.controllers;

import ro.mycode.Utils.Utile;
import ro.mycode.models.Orders;

import java.util.ArrayList;

public class ControlOrder {

    private ArrayList<Orders> orders;

    private final String FILE_PATH ="C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\orders.txt";

    public ControlOrder(){
        this.orders=new ArrayList<>();
        Utile.load(FILE_PATH,"order",orders);
    }


    public void read(){
        Utile.read(orders);
    }

}
