package ro.mycode;

import ro.mycode.controllers.ControlOrderDetails;
import ro.mycode.controllers.ControlProducts;
import ro.mycode.view.ViewAdmin;
import ro.mycode.view.ViewCustomer;

public class Main {
    public static void main(String[] args) {


//        ControlProducts controlProducts = new ControlProducts();
//        System.out.println(controlProducts.minProductsWeight());
//        System.out.println(controlProducts.minProductsPrice());

//        ViewCustomer viewCustomer = new ViewCustomer();
//        viewCustomer.play();

        ViewAdmin viewAdmin = new ViewAdmin();
        System.out.println(viewAdmin);
    }
}