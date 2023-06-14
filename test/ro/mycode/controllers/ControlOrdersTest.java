package ro.mycode.controllers;

import org.hamcrest.core.StringEndsWith;
import org.junit.jupiter.api.Test;
import ro.mycode.models.Orders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControlOrdersTest {

    @Test
    void testFindByCustomerIdArr() {
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order = new Orders("1,1,1,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        Orders order1=new Orders("2,1,2,Bucuresti,anaionescu@email.com,Brasov,2023-01-04,canceled");
        Orders order2=new Orders("3,1,3,Calarsi,andreienache@email.com,Oltenita,2023-02-02,delivered");
        Orders order3=new Orders("4,4,4,Calarasi,andreienache@email.com,Pitesti,2023-01-19,preparing");
        orders.add(order);
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        ControlOrders controlOrders = new ControlOrders(orders);
        ArrayList<Orders> list = null;
        for (int i=0; i<orders.size();i++){
            list=controlOrders.findByCustomerIdArr(1);
        }
        int expected=3;
        assertEquals(expected, list.size());

    }

    @Test
    void testFindByCustomerId() {
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order = new Orders("1,1,1,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        orders.add(order);
        ControlOrders controlOrders = new ControlOrders(orders);
        String expected=order.toString();

        assertEquals(expected,controlOrders.findByCustomerId(order.getCustomerID()).toString());
    }

    @Test
    void testFindByCustomerIdNull(){
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order = new Orders("1,1,1,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        orders.add(order);
        ControlOrders controlOrders = new ControlOrders(orders);
        String expected=null;

        assertEquals(expected,controlOrders.findByCustomerId(order.getId()+1));
    }

    @Test
    void add() {
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order = new Orders("1,1,1,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        ControlOrders controlOrders = new ControlOrders(orders);
        controlOrders.add(order);
        int expected=1;

        assertEquals(expected, orders.size());

    }

    @Test
    void testNextId() {
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order = new Orders("1,1,1,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        orders.add(order);
        ControlOrders controlOrders = new ControlOrders(orders);
        int expected = 2;

        assertEquals(expected, controlOrders.nextId());
    }

    @Test
    void testNextIdNull() {
        ArrayList<Orders> orders = new ArrayList<>();
        ControlOrders controlOrders = new ControlOrders(orders);
        int expected = -1;

        assertEquals(expected, controlOrders.nextId());
    }

    @Test
    void testRemove() {
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order = new Orders("1,1,1,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        orders.add(order);
        ControlOrders controlOrders = new ControlOrders(orders);
        controlOrders.remove(order);
        int expected=0;

        assertEquals(expected, orders.size());
    }

    @Test
    void testFindById() {
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order = new Orders("1,1,1,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        orders.add(order);
        ControlOrders controlOrders = new ControlOrders(orders);
        String expected=order.toString();

        assertEquals(expected,controlOrders.findById(order.getId()).toString());
    }

    @Test
    void testFindByIdNull(){
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order = new Orders("1,1,1,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        orders.add(order);
        ControlOrders controlOrders = new ControlOrders(orders);
        String expected=null;

        assertEquals(expected,controlOrders.findById(order.getId()+1));
    }

    @Test
    void testFindByEmail() {
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order = new Orders("1,1,1,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        orders.add(order);
        ControlOrders controlOrders = new ControlOrders(orders);
        String expected=order.toString();

        assertEquals(expected,controlOrders.findByEmail(order.getOrderEmail()).toString());
    }

    @Test
    void testEditShippingAdressNull() {
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order = new Orders("1,1,1,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        orders.add(order);
        ControlOrders controlOrders = new ControlOrders(orders);
        String expected = null;

        assertEquals(expected,controlOrders.findByEmail(order.getOrderEmail()+1));
    }

    @Test
    void testFindByOrderIdCustomerId() {
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order = new Orders("1,1,1,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        orders.add(order);
        ControlOrders controlOrders = new ControlOrders(orders);
        String expeted=order.toString();

        assertEquals(expeted, controlOrders.findByOrderIdCustomerId(order.getId(),order.getCustomerID()).toString());
    }

    @Test
    public void testFindByOrderIdCustomerIdNull(){
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order = new Orders("1,1,1,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        orders.add(order);
        ControlOrders controlOrders = new ControlOrders(orders);
        String expected= null;

        assertEquals(expected, controlOrders.findByOrderIdCustomerId(order.getId()+1, order.getCustomerID()));
    }

    @Test
    void minOrdersAmmount() {
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order= new Orders("1,1,9,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        Orders order1 = new Orders("2,1,7,Bucuresti,anaionescu@email.com,Brasov,2023-01-04,canceled");
        Orders order2 = new Orders("3,2,3,Calarsi,andreienache@email.com,Oltenita,2023-02-02,delivered");
        Orders order3 = new Orders("4,2,4,Calarasi,andreienache@email.com,Pitesti,2023-01-19,preparing");
        orders.add(order);
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        ControlOrders controlOrders = new ControlOrders(orders);
        String expecxted = order2.toString();

        assertEquals(expecxted,controlOrders.minOrdersAmmount().toString());
    }

    @Test
    void editShippingAdress() {
        ArrayList<Orders> orders = new ArrayList<>();
        Orders order = new Orders("1,1,1,Bucuresti,anaionescu@email.com,Constanta,2023-05-12,transporting");
        Orders orders1 = new Orders("2,1,2,Oltenita,anaionescu@email.com,Constanta,2023-05-12,transporting");
        orders.add(order);
        ControlOrders controlOrders = new ControlOrders(orders);
        controlOrders.editShippingAdress(orders1);
        String expected =order.getShippingAdress();

        assertEquals(expected, orders1.getShippingAdress());
    }
}