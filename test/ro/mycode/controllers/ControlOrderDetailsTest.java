package ro.mycode.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ro.mycode.models.OrderDetails;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControlOrderDetailsTest {

    @Test
    void testFindByProductId() {
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        OrderDetails order = new OrderDetails("1,1,1,600,1");
        orderDetails.add(order);
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails();
        int expected=order.getProductId();

        assertEquals(expected,controlOrderDetails.findByProductIdReturnOrderId(order.getProductId()));
    }

    @Test
    void testFindByProductIdNull(){
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        OrderDetails order = new OrderDetails("1,1,1,600,1");
        orderDetails.add(order);
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails(orderDetails);
        int expected=-1;

        assertEquals(expected,controlOrderDetails.findByProductIdReturnOrderId(order.getProductId()+1));
    }

    @Test
    void minOrderDetailsQuantity() {
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        OrderDetails order =new OrderDetails("1,1,1,600,5");
        OrderDetails order1=new OrderDetails("2,1,2,1100,2");
        OrderDetails order2=new OrderDetails("3,2,3,1700,1");
        OrderDetails order3=new OrderDetails("4,2,4,5600,9");
        orderDetails.add(order);
        orderDetails.add(order1);
        orderDetails.add(order2);
        orderDetails.add(order3);
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails(orderDetails);
        String expected=order2.toString();

        assertEquals(expected,controlOrderDetails.minOrderDetailsQuantity().toString());
    }

    @Test
    void minOrderDetailsPrice() {
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        OrderDetails order =new OrderDetails("1,1,1,600,5");
        OrderDetails order1=new OrderDetails("2,1,2,1100,2");
        OrderDetails order2=new OrderDetails("3,2,3,1700,1");
        OrderDetails order3=new OrderDetails("4,2,4,5600,9");
        orderDetails.add(order);
        orderDetails.add(order1);
        orderDetails.add(order2);
        orderDetails.add(order3);
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails(orderDetails);
        String expected=order.toString();

        assertEquals(expected, controlOrderDetails.minOrderDetailsPrice().toString());
    }

    @Test
    void testAdd(){
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        OrderDetails order= new OrderDetails("1,1,1,600,5");
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails(orderDetails);
        controlOrderDetails.add(order);
        int expected=1;

        assertEquals(expected,orderDetails.size());
    }

    @Test
    void testNextId(){
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        OrderDetails orders = new OrderDetails("1,1,1,600,5");
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails(orderDetails);
        orderDetails.add(orders);
        int expected=2;

        assertEquals(expected,controlOrderDetails.nextId());
    }

    @Test
    void testNextIdNull(){
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails(orderDetails);
        int expected=-1;
        assertEquals(expected,controlOrderDetails.nextId());
    }

    @Test
    void testToSave(){
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails(orderDetails);
        OrderDetails order =new OrderDetails("1,1,1,600,5");
        OrderDetails order1=new OrderDetails("2,1,2,1100,2");
        orderDetails.add(order);
        orderDetails.add(order1);
        String expected=order.toSave()+"\n"+order1.toSave();

        assertEquals(expected,controlOrderDetails.toSave());
    }

    @Test
    void testToSaveNull(){
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails(orderDetails);
        String expected="";

        assertEquals(expected,controlOrderDetails.toSave());
    }

    @Test
    void testSave(){
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        OrderDetails order =new OrderDetails("1,1,1,600,5");
        OrderDetails order1=new OrderDetails("2,1,2,1100,2");
        orderDetails.add(order);
        orderDetails.add(order1);
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails(orderDetails);
        String path="C:\\mycode\\OOP\\OnlineShop\\test\\ro\\mycode\\data\\test.orderDetails.txt";
        controlOrderDetails.save(path);

        String expected= order.toSave()+"\n"+order1.toSave();

        assertEquals(expected,controlOrderDetails.toSave());
    }

    @AfterEach
    void clear(){
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails(new ArrayList<>());
        controlOrderDetails.save("C:\\mycode\\OOP\\OnlineShop\\test\\ro\\mycode\\data\\test.orderDetails.txt");
    }

}