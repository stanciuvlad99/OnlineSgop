package ro.mycode.controllers;

import org.junit.jupiter.api.Test;
import ro.mycode.models.OrderDetails;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControlOrderDetailsTest {

    @Test
    void testFindByProductId() {
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        OrderDetails order = new OrderDetails("1,1,1,600,ABC333DEF,1");
        orderDetails.add(order);
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails();
        int expected=order.getProductId();

        assertEquals(expected,controlOrderDetails.findByProductIdReturnOrderId(order.getProductId()));
    }

    @Test
    void testFindByProductIdNull(){
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        OrderDetails order = new OrderDetails("1,1,1,600,ABC333DEF,1");
        orderDetails.add(order);
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails(orderDetails);
        int expected=-1;

        assertEquals(expected,controlOrderDetails.findByProductIdReturnOrderId(order.getProductId()+1));
    }

    @Test
    void minOrderDetailsQuantity() {
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        OrderDetails order =new OrderDetails("1,1,1,600,ABC333DEF,5");
        OrderDetails order1=new OrderDetails("2,1,2,1100,GHI222JKL,2");
        OrderDetails order2=new OrderDetails("3,2,3,1700,MNO333PQR,1");
        OrderDetails order3=new OrderDetails("4,2,4,5600,QWE444RTY,9");
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
        OrderDetails order =new OrderDetails("1,1,1,600,ABC333DEF,5");
        OrderDetails order1=new OrderDetails("2,1,2,1100,GHI222JKL,2");
        OrderDetails order2=new OrderDetails("3,2,3,1700,MNO333PQR,1");
        OrderDetails order3=new OrderDetails("4,2,4,5600,QWE444RTY,9");
        orderDetails.add(order);
        orderDetails.add(order1);
        orderDetails.add(order2);
        orderDetails.add(order3);
        ControlOrderDetails controlOrderDetails = new ControlOrderDetails(orderDetails);
        String expected=order.toString();

        assertEquals(expected, controlOrderDetails.minOrderDetailsPrice().toString());
    }
}