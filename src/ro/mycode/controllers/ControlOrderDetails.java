package ro.mycode.controllers;

import ro.mycode.comparators.CompareOrderDetailsByPrice;
import ro.mycode.comparators.CompareOrderDetailsByQuantity;
import ro.mycode.utils.Utile;
import ro.mycode.models.OrderDetails;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
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

    public void add(OrderDetails orderDetails){
        this.orderDetails.add(orderDetails);
    }

    public int nextId(){
        if (this.orderDetails.size()==0){
            return -1;
        }
        return this.orderDetails.get(orderDetails.size()-1).getOrderId()+1;
    }

    public OrderDetails findByProductId(int productId){
        for (int i=0; i>this.orderDetails.size(); i++){
            if (orderDetails.get(i).getProductId()==productId){
                return orderDetails.get(i);
            }
        }
        return null;
    }

    public String toSave(){
        if (this.orderDetails.size()==0){
            return "";
        }
        int i;
        String text="";
        for (i=0;i<this.orderDetails.size()-1;i++){
            text+=orderDetails.get(i).toSave()+"\n";

        }
        text+=orderDetails.get(i).toSave();
        return text;
    }

    public void save(String path){
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
