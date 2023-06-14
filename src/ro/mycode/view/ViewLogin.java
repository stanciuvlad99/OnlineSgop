package ro.mycode.view;

import ro.mycode.controllers.ControlUser;
import ro.mycode.models.Admin;
import ro.mycode.models.Customer;
import ro.mycode.models.User;

import java.util.Scanner;

public class ViewLogin {
    private ControlUser controlUser;

    public ViewLogin(){
        this.controlUser=new ControlUser();
        login();
    }

    public void login(){
        System.out.println("Introduceti adresa de mail");
        Scanner scanner = new Scanner(System.in);
        String email=scanner.nextLine();
        System.out.println("Introduceti parola");
        String password=scanner.nextLine();
        User user = controlUser.findByEmailPassword(email,password);
        if (user!=null){
            ViewAdmin viewAdmin = new ViewAdmin((Admin) user);
        }
//        if (customer!=null){
//            ViewCustomer viewCustomer = new ViewCustomer(customer);
//        }

    }
}
