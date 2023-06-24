package ro.mycode.controllers;

import ro.mycode.comparators.CompareOrdersByAmmount;
import ro.mycode.utils.Utile;
import ro.mycode.models.Orders;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class ControlOrders {

    private ArrayList<Orders> orders;

    private final String FILE_PATH = "C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\orders.txt";

    public ControlOrders(ArrayList<Orders> orders){
        this.orders=orders;
    }

    public ControlOrders() {
        this.orders = new ArrayList<>();
        Utile.load(FILE_PATH, "order", orders);
    }

//    public Orders minOrders() {
//        return Collections.min(orders);
//    }

    public Orders minOrdersAmmount() {
        return Collections.min(orders, new CompareOrdersByAmmount());
    }

    public void read() {
        Utile.read(orders);
    }

    public ArrayList<Orders> findByCustomerIdArr(int customerId) {
        ArrayList<Orders> list = new ArrayList<>();
        for (int i = 0; i < this.orders.size(); i++) {
            if (orders.get(i).getCustomerID() == customerId) {
                list.add(orders.get(i));
            }
        }
        return list;
    }

    public Orders findByCustomerId(int orderId) {
        for (int i = 0; i<this.orders.size(); i++){
            if(orders.get(i).getId()==orderId){
                return orders.get(i);
            }
        }
        return null;
    }

    public void add(Orders orders){
        this.orders.add(orders);
    }

    public int nextId(){
        if (orders.size()==0){
            return -1;
        }
        return orders.get(orders.size()-1).getId()+1;
    }

    public void remove(Orders orders){
        this.orders.remove(orders);
    }

    public Orders findById(int orderId){
        for (int i=0; i<orders.size(); i++){
            if (orders.get(i).getId()==orderId){
                return orders.get(i);
            }
        }
        return null;
    }

    public Orders findByEmail(String email){
        for (int i =0; i<orders.size();i++){
            if (orders.get(i).getOrderEmail().equals(email)){
                return orders.get(i);
            }
        }
        return null;
    }
    public void editShippingAdress(Orders orders){
        Orders update=findByEmail(orders.getOrderEmail());
        if (orders.getShippingAdress().equals("")==false){
            update.setShippingAdress(orders.getShippingAdress());
        }
    }

    public Orders findByOrderIdCustomerId(int orderId, int customerId) {
        for (int i = 0; i<this.orders.size(); i++){
            if(orders.get(i).getId()==orderId && orders.get(i).getCustomerID()==customerId){
                return orders.get(i);
            }
        }
        return null;
    }

    public String toSave(){
        if (this.orders.size()==0){
            return "";
        }
        int i;
        String text = "";
        for (i=0;i<orders.size()-1;i++){
            text+=orders.get(i).toSave()+"\n";

        }
        text+=orders.get(i).toSave();
        return text;
    }

    public void save(String path) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
