package ro.mycode.controllers;

import ro.mycode.Utils.Utile;
import ro.mycode.models.OrderDetails;

import java.util.ArrayList;

public class ControlOrderDetails {

    private ArrayList<OrderDetails> orderDetails;

    private final String FILE_PATH ="C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\orderDetails.txt";

    public ControlOrderDetails(){
        this.orderDetails=new ArrayList<>();
        Utile.load(FILE_PATH,"order details", orderDetails);
    }

    public void read(){
        Utile.read(orderDetails);
        }

}
