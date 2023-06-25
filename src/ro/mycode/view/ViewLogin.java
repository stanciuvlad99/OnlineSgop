package ro.mycode.view;

import ro.mycode.controllers.ControlUser;
import ro.mycode.models.Admin;
import ro.mycode.models.Customer;
import ro.mycode.models.User;

import java.time.LocalDate;
import java.util.Objects;
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
                case 2:
                    register();
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
            if (controlUser.findByType(user.getType()).getType().equals("admin")) {
                ViewAdmin viewAdmin = new ViewAdmin((Admin) user);
                viewAdmin.play();
            }
            if (controlUser.findByType(user.getType()).getType().equals("customer")) {
                ViewCustomer viewCustomer = new ViewCustomer((Customer) user);
                viewCustomer.play();
            }
        }
    }

    public void register() {
        System.out.println("Introduceti adresa de mail");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.println("Intreoduceti parola");
        String password = scanner.nextLine();
        System.out.println("Introduceti parola din nou");
        String password1 = scanner.nextLine();
        if (password.equals(password1)) {
            User user = controlUser.findByEmailPassword(email,password);
            if (user==null){
                System.out.println("Introduceti numele complect");
                String fullName=scanner.nextLine();
                System.out.println("Introduceti numarul de telefon");
                int number= Integer.parseInt(scanner.nextLine());
                Customer user1 = new Customer(controlUser.nextId(),email,password,fullName,number,LocalDate.parse("9999-09-09")
                        ,LocalDate.now(),false);
                controlUser.add(user1);
                controlUser.save("C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\users.txt");
                System.out.println("Contul a fost creat cu succes");
            }
        } else {
            System.out.println("Parolele nu sunt identice");
        }

    }
}

