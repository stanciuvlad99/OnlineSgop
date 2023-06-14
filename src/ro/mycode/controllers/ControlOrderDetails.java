package ro.mycode.controllers;

import ro.mycode.comparators.CompareOrderDetailsByPrice;
import ro.mycode.comparators.CompareOrderDetailsByQuantity;
import ro.mycode.models.Orders;
import ro.mycode.utils.Utile;
import ro.mycode.models.OrderDetails;

import java.util.ArrayList;
import java.util.Collections;

public class ControlOrderDetails {

    private ArrayList<OrderDetails> orderDetails;

    private final String FILE_PATH ="C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\orderDetails.txt";

    public ControlOrderDetails(ArrayList<OrderDetails> orderDetails){
        this.orderDetails=orderDetails;
    }

//    public OrderDetails minOrders() {
//        return Collections.min(orderDetails);
//    }

    public ControlOrderDetails(){
        this.orderDetails=new ArrayList<>();
        Utile.load(FILE_PATH,"order details", orderDetails);
    }

    public void read() {
        Utile.read(orderDetails);
    }

    public OrderDetails minOrderDetailsQuantity(){
        return Collections.min(orderDetails,new CompareOrderDetailsByQuantity());
    }

    public OrderDetails minOrderDetailsPrice(){
        return Collections.min(orderDetails, new CompareOrderDetailsByPrice());
    }

    public int findByProductIdReturnOrderId(int productId){
        for (int i = 0 ; i<orderDetails.size(); i++){
            if (orderDetails.get(i).getOrderId()== productId){
                return orderDetails.get(i).getOrderId();
            }
        }
        return -1;
    }



}
