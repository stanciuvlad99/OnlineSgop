package ro.mycode.view;

import ro.mycode.controllers.ControlUser;
import ro.mycode.models.Admin;
import ro.mycode.models.Customer;
import ro.mycode.models.User;

import java.util.Scanner;

public class ViewLogin {
    private ControlUser controlUser;

    public ViewLogin() {
        this.controlUser = new ControlUser();
        play();
    }

    public void menu() {
        System.out.println("Apasati tasta 1 pentru a va loga");
        System.out.println("Apasati tsata 2 pentru a va inregistra");
    }

    public void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    login();
                    break;
                default:
                    break;
            }
        }
    }

    public void login() {
        System.out.println("Introduceti adresa de mail");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.println("Introduceti parola");
        String password = scanner.nextLine();
        User user = controlUser.findByEmailPassword(email, password);
        if (user != null) {
            if (controlUser.findByType(user.getType()).getType().equals("admin")){
                ViewAdmin viewAdmin = new ViewAdmin((Admin) user);
                viewAdmin.play();
            }
            if (controlUser.findByType(user.getType()).getType().equals("customer")){
                ViewCustomer viewCustomer = new ViewCustomer((Customer) user);
                viewCustomer.play();
            }
        }

    }
}
