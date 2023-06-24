package ro.mycode;

import ro.mycode.controllers.ControlOrderDetails;
import ro.mycode.controllers.ControlOrders;
import ro.mycode.controllers.ControlProducts;
import ro.mycode.controllers.ControlUser;
import ro.mycode.models.*;
import ro.mycode.view.ViewAdmin;
import ro.mycode.view.ViewCustomer;
import ro.mycode.view.ViewLogin;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        OrderDetails orderDetails = new OrderDetails("1,1,1,999,999");
//        ControlOrderDetails controlOrderDetails = new ControlOrderDetails();
//        controlOrderDetails.add(orderDetails);
//        controlOrderDetails.save("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\orderDetails.txt");
//        controlOrderDetails.read();

//        Orders orders = new Orders("999,999,999,qwerty,qwerty,qwerty,2023-01-04,qwerty");
//        ControlOrders controlOrders = new ControlOrders();
//        controlOrders.add(orders);
//        controlOrders.save("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\orders.txt");
//        controlOrders.read();


//        Products products = new Products("5,telefon,7000,0.3");
//        ControlProducts controlProducts = new ControlProducts();
//        controlProducts.add(products);
//        controlProducts.save("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\products.txt");
//        controlProducts.read();

//        Admin admin = new Admin("admin,3,test@test.com,password,Ionut Marian,123456799,3,qwerty,qwerty");
//        ControlUser controlUser = new ControlUser();
//        controlUser.add(admin);
//        controlUser.save("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\users.txt");
//        controlUser.read();
//
//        Customer customer = new Customer("customer,3,qwerty@test.com,password123,Vlad Andrei,054565415,2021-03-15,2019-02-03,true");
//        ControlUser controlUser = new ControlUser();
//        controlUser.add(customer);
//        controlUser.save("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\users.txt");
//        controlUser.read();


        ViewLogin viewLogin = new ViewLogin();
        viewLogin.login();


//        ControlProducts controlProducts = new ControlProducts();
//        System.out.println(controlProducts.minProductsWeight());
//        System.out.println(controlProducts.minProductsPrice());

//        ViewCustomer viewCustomer = new ViewCustomer();
//        viewCustomer.play();


    }
}