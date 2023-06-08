package ro.mycode.controllers;

import ro.mycode.comparators.CompareOrdersByAmmount;
import ro.mycode.utils.Utile;
import ro.mycode.models.Orders;

import java.util.ArrayList;
import java.util.Collections;

public class ControlOrder {

    private ArrayList<Orders> orders;

    private final String FILE_PATH ="C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\orders.txt";

    public ControlOrder(){
        this.orders=new ArrayList<>();
        Utile.load(FILE_PATH,"order",orders);
    }

    public Orders minOrders(){
        return Collections.min(orders);
    }

    public Orders minOrdersAmmount(){
        return Collections.min(orders,new CompareOrdersByAmmount());
    }
    public void read(){
        Utile.read(orders);
    }

}
