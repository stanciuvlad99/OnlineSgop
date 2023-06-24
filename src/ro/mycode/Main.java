package ro.mycode;

import ro.mycode.controllers.ControlOrderDetails;
import ro.mycode.controllers.ControlOrders;
import ro.mycode.controllers.ControlProducts;
import ro.mycode.models.OrderDetails;
import ro.mycode.models.Orders;
import ro.mycode.view.ViewAdmin;
import ro.mycode.view.ViewCustomer;
import ro.mycode.view.ViewLogin;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

//        OrderDetails orderDetails = new OrderDetails("1,1,1,999,999");
//        ControlOrderDetails controlOrderDetails = new ControlOrderDetails();
//        controlOrderDetails.add(orderDetails);
//        controlOrderDetails.save("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\orderDetails.txt");
//        controlOrderDetails.read();

//        Orders orders = new Orders("999,999,999,qwerty,qwerty,qwerty,2023-01-04,qwerty");
//        ControlOrders controlOrders = new ControlOrders();
//        controlOrders.add(orders);
//        controlOrders.save("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\orders.txt");
//        controlOrders.read();



//        ControlProducts controlProducts = new ControlProducts();
//        System.out.println(controlProducts.minProductsWeight());
//        System.out.println(controlProducts.minProductsPrice());

        ViewCustomer viewCustomer = new ViewCustomer();
        viewCustomer.play();


    }
}